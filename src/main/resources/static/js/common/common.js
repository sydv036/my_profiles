import { DataRequest } from "./DataRequest.js";
import { uploadImage } from "../config/Upload-Image-Config.js";
// var API = "http://localhost:8081";
function replaceURL(url) {
  url = url.replace(/^\/|\/$/g, "");
  return url;
}
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
        if (typeof callback === "function") {
          callback(new DataRequest(id, attrName, valueNew));
        }
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
function callApiGet(url) {
  url = replaceURL(url);
  return new Promise((resole, reject) => {
    $.ajax({
      type: "GET",
      url: "/" + url,
      complete: function () {
        renderCss("loading", "display", "none");
      },
      success: function (reponse) {
        if (reponse.statusCode === 200) {
          resole(reponse.data);
          return;
        }
        alert("Có lỗi tạm thời xảy ra, vui lòng thử lại sau!");
        console.log(reponse);
        // window.location = "/errors/500";
        reject("Data not found");
      },
      error: function (error) {
        reject(error);
      },
    });
  });
}
function callApiPost(url, dataRequest, url_get, functionRender) {
  renderCss("loading", "display", "block");
  url = replaceURL(url);
  $.ajax({
    url: "/" + url,
    method: "POST",
    dataType: "json",
    data: JSON.stringify(dataRequest),
    contentType: "application/json",
    complete: function () {
      renderCss("loading", "display", "none");
    },
    success: async function (response) {
      if (url_get !== undefined && functionRender !== undefined) {
        const data = await callApiGet(url_get);
        functionRender(data);
      }
      return response.statusCode;
    },
    error: function (error) {
      console.log("error", error);
      return;
    },
  });
}
function callApiDelete(url, id, url_get, functionRender) {
  renderCss("loading", "display", "block");
  url = replaceURL(url);
  $.ajax({
    type: "DELETE",
    url: "/" + url + "/" + id,
    complete: function () {
      renderCss("loading", "display", "none");
    },
    success: async function (response) {
      if (url_get !== "" && functionRender !== "") {
        const data = await callApiGet(url_get);
        functionRender(data);
      }
      return response.statusCode;
    },
    error: function (error) {},
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
function handleDeleteObj(
    url,
    typeHandleInputSingle,
    classParent,
    url_get,
    functionRender
) {
  if (typeof typeHandleInputSingle === "boolean") {
    $(document).on("click", "." + classParent, function (event) {
      const x = event.offsetX;
      const width = $(this).width();
      let id = null;
      if (typeHandleInputSingle) {
        id = $(this).children().data("id");
        if (x > width - 20) {
          callApiDelete(url, id, url_get, functionRender);
        }
        return;
      }
      //
      id = $(this).data("id");
      if (x > width - 40) {
        callApiDelete(url, id, url_get, functionRender);
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
  } else {
    $("." + classApend).css(attr, parseInt(value));
    $("." + classApend)
        .children("i")
        .css("font-size", "initial");
    $(".font-size-custom").val(parseInt(value));
    $(".range label b").text(parseInt(value) + "px");
  }
}
function handlerClick(classClick, callback) {
  $(document).on("click", "." + classClick, function (e) {
    callback(e);
  });
}
function handlerClickToggeleClass(idHandler, classToggle) {
  $("#" + idHandler).on("click", function (e) {
    $("." + classToggle).toggleClass("show");
  });
}
export {
  create,
  handleInput,
  handleImgWithList,
  callApiGet,
  callApiPost,
  handleInputSingle,
  handleImg,
  handleObjectFormDataImg,
  isCheckNullList,
  handleDeleteObj,
  renderCss,
  handlerClickToggeleClass,
  handlerClick,
};
