import {
  callApiPost,
  create,
  handleDeleteObj,
  handleInput,
  handleObjectFormDataImg,
} from "./common.js";

function updateEducation() {
  handleInput("education_form", "education_form", "id", function (data) {
    callApiPost("/api/v1/admin/updateEducation", data);
  });
  handleObjectFormDataImg(
    "chosse-file-edu",
    "file-edu-new",
    "fill-img-edu-select",
    "createEdu",
    "formDataEdu",
    "transcript",
    function (data) {
      callApiPost("/api/v1/admin/createEducation", data);
    }
  );
  handleDeleteObj("/api/v1/admin/deleteEducation", false, "education_form");
}
export { updateEducation };
