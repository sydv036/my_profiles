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
export { create, handleInput };
