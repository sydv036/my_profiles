import {
  callApiPost,
  create,
  handleDeleteObj,
  handleInput,
  handleObjectFormDataImg,
} from "../../common/common.js";
import { renderEducationUpdate } from "../update-renders/Education_Update.js";

function updateEducation() {
  const urlGet = "/api/v1/personal/education";
  const functionRender = renderEducationUpdate;
  handleInput("education_form", "education_form", "id", function (data) {
    callApiPost("/api/v1/admin/updateEducation", data, urlGet, functionRender);
  });
  handleObjectFormDataImg(
    "chosse-file-edu",
    "file-edu-new",
    "fill-img-edu-select",
    "createEdu",
    "formDataEdu",
    "transcript",
    function (data) {
      callApiPost(
        "/api/v1/admin/createEducation",
        data,
        urlGet,
        functionRender
      );
    }
  );
  handleDeleteObj(
    "/api/v1/admin/deleteEducation",
    false,
    "education_form",
    urlGet,
    functionRender
  );
}
export { updateEducation };
