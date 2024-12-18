import {
  callApiPost,
  create,
  handleInput,
  handleObjectFormDataImg,
} from "./common.js";

// function createEducation() {
//   // create(
//   //   "icon-add-edu",
//   //   "education-info-custom",
//   //   `
//   //     <div class="education-info mb-3">
//   //         <div class="education-name">
//   //           <input class="" type='text' data-id="" value="Education Name"/>
//   //         </div>
//   //         <div class="major">
//   //           <input type='text' value="CNTT" />
//   //         </div>
//   //         <div class="year-learn row"><input type='text' class="col-4" value="02/2021"/>    <input type='text' class="col-4" value="02/2025"/></div>
//   //         <div class="point">
//   //           GPA:
//   //           <input type='text' value="4.0"/>
//   //         </div>
//   //     </div>
//   //   `,
//   //   function () {}
//   // );
// }
function updateEducation() {
  handleInput(
    "education-info_form",
    "education-info_form",
    "id",
    function (data) {
      callApiPost("/api/v1/admin/updateEducation", data);
    }
  );
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
}
export { updateEducation };
