import { DataRequest } from "./DataRequest.js";

function create(classClick, classAdd, value) {
  $(document).on("click", "." + classClick, function () {
    $("." + classAdd).append(value);
  });
}
function handleInput(classInput, classParent, dataName, callback) {
  $(document).on("change", classInput, function () {
    let id = $(this).closest(classParent).data(dataName);
    let attrName = $(this).attr("name");
    let valueNew = $(this).val();
    callback(new DataRequest(id, attrName, valueNew));
  });
}
function handleInputSingle(classInput, dataName, callback) {
  $(document).on("change", classInput, function () {
    let id = $(this).data(dataName);
    let valueNew = $(this).val();
    callback(new DataRequest(id, null, valueNew));
  });
}
let API = "http://localhost:8081";
function callApiPost(url, dataRequest) {
  $.ajax({
    url: API + url,
    method: "POST",
    dataType: "json",
    data: JSON.stringify(dataRequest),
    contentType: "application/json",
    success: function (response) {
      console.log(response);
    },
    error: function (error) {
      console.log(error.responseJSON);
    },
  });
}
export { create, handleInput, callApiPost, handleInputSingle };
