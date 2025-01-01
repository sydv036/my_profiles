import { DataRequest } from "./DataRequest.js";
import { uploadImage } from "./imageUpload.js";
var API = "http://localhost:8081";
function create(classClick, classAdd, value, callback) {
  $(document).on("click", "." + classClick, function () {
    $("." + classAdd).append(value);
    if (typeof callback === "function") {
      callback();
    }
  });
}
function handleInput(classInput, classParent, dataName, callback) {
  $(document).on(
    "change",
    "." + classInput + " " + "input[type='text']",
    function () {
      let id = $(this)
        .closest("." + classParent)
        .data(dataName);
      let attrName = $(this).attr("name");
      let valueNew = $(this).val();
      callback(new DataRequest(id, attrName, valueNew));
    }
  );
}
function handleInputSingle(classInput, dataName, callback) {
  $(document).on(
    "change",
    "." + classInput + " " + "input[type='text']",
    function () {
      let id = $(this).data(dataName);
      let valueNew = $(this).val();
      callback(new DataRequest(id, null, valueNew));
    }
  );
}
function callApiPost(url, dataRequest) {
  const urlCheck = url.substring(0, 1);
  if (urlCheck === "/") {
    url = url.slice(1);
  }
  $.ajax({
    url: API + "/" + url,
    method: "POST",
    dataType: "json",
    data: JSON.stringify(dataRequest),
    contentType: "application/json",
    success: function (response) {
      console.log(response);
      return response.statusCode;
    },
    error: function (error) {
      console.log(error.responseJSON);
      return response.statusCode;
    },
  });
}
function callApiDelete(url, id) {
  const firstURL = url.substring(0, 1);
  if (firstURL === "/") {
    url = url.slice(1);
  }
  const lastURL = url.substring(url.length - 1, url.length);
  if (lastURL === "/") {
    url = url.slice(0, -1);
  }
  $.ajax({
    type: "DELETE",
    url: API + "/" + url + "/" + id,
    success: function (response) {
      console.log(response);
    },
    error: function (error) {
      console.log("error", error);
    },
  });
}
function handleImg(
  classHandler,
  classReplaceHandler,
  classImgFill,
  onSelectFile
) {
  $(document).on("click", "." + classHandler, function () {
    $("." + classReplaceHandler).click();
  });

  $("." + classReplaceHandler).change(function () {
    let file = $(this)[0].files[0];
    if (!file) {
      alert("Không có file nào được chọn");
      return;
    }
    let fileType = file.type.split("/")[0];
    if (fileType !== "image") {
      alert("Không phải là ảnh! Hãy chọn ảnh điiiiii");
      return;
    }
    let url = URL.createObjectURL(file);
    $("." + classImgFill).attr("src", url);
    if (typeof onSelectFile === "function") {
      onSelectFile(file);
    }
  });
}
function handleImgWithList(
  classHandler,
  classReplaceHandler,
  classParent,
  dataName,
  onSelectFile
) {
  let img = null;
  $(document).on("click", "." + classHandler, function () {
    let fileInput = $("." + classReplaceHandler);
    fileInput.off("change");
    fileInput.click();
    img = $(this).find("img");
    let idCert = $(this)
      .closest("." + classParent)
      .data(dataName);
    let attrName = fileInput.attr("name");
    $("." + classReplaceHandler).change(function () {
      let file = $(this)[0].files[0];
      if (!file) {
        alert("Không có file nào được chọn");
        return;
      }

      let fileType = file.type.split("/")[0];
      if (fileType !== "image") {
        alert("Không phải là ảnh! Hãy chọn ảnh điiiiii");
        return;
      }
      if (confirm("Bạn có chắc chắn thay đổi thành ảnh này không zậy?")) {
        let url = URL.createObjectURL(file);
        img.attr("src", url);
        if (typeof onSelectFile === "function") {
          onSelectFile(file, idCert, attrName);
        }
      }
    });
  });
}
function handleObjectFormDataImg(
  classImgHandler,
  classImgReplaceHandler,
  classImgFill,
  classClick,
  classFormData,
  attrNameImg,
  callback
) {
  let file = null;
  handleImg(
    classImgHandler,
    classImgReplaceHandler,
    classImgFill,
    function (fileImg) {
      file = fileImg;
    }
  );
  $("." + classClick).click(async function () {
    let obj = {};
    let selectInput = $("." + classFormData);

    // Duyệt qua các input và lấy giá trị
    selectInput.find("input[name]").each(function () {
      const name = $(this).attr("name");
      const value = $(this).val();
      obj[name] = value;
    });

    try {
      if (file !== null) {
        const img = await uploadImage(file);
        obj[attrNameImg] = img;
      }
      callback(obj);
    } catch (error) {
      console.error("Lỗi trong quá trình upload ảnh:", error);
    }
  });
}
function isCheckNullList(list_data, data_name) {
  if (list_data === null) {
    return;
  }
  console.log("list_data." + data_name + ".length");

  if ("list_data." + data_name + ".length" === 0) {
    return;
  }
}
function handleDeleteObj(url, typeHandleInputSingle, classParent) {
  if (typeof typeHandleInputSingle === "boolean") {
    $(document).on("click", "." + classParent, function (event) {
      const x = event.offsetX;
      const width = $(this).width();
      let id = null;
      if (typeHandleInputSingle) {
        id = $(this).children().data("id");
        if (x > width - 20) {
          callApiDelete(url, id);
        }
        return;
      }
      //
      id = $(this).data("id");
      if (x > width - 40) {
        callApiDelete(url, id);
      }
    });
  }
}
function renderCss(classApend, attr, value) {
  if (value === null || value === "") {
    return;
  }
  if (isNaN(value)) {
    $("." + classApend).css(attr, value);
  }
  $("." + classApend).css(attr, parseInt(value));
  $("." + classApend)
    .children("i")
    .css("font-size", "initial");
  $(".font-size-custom").val(parseInt(value));
  $(".range label b").text(parseInt(value) + "%");
}
export {
  create,
  handleInput,
  handleImgWithList,
  callApiPost,
  handleInputSingle,
  handleImg,
  handleObjectFormDataImg,
  isCheckNullList,
  handleDeleteObj,
  renderCss,
};
