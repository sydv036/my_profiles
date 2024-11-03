import { create } from "./common.js";

function readEducationRequest() {
  let educationHTML = $(".education-info input");
}
function createEducation() {
  create(
    "icon-add-edu",
    "education-info-custom",
    `
      <div class="education-info mb-3">
          <div class="education-name">
            <input class="" data-id="" value="Education Name"/>
          </div>
          <div class="major">
            <input value="CNTT" />
          </div>
          <div class="year-learn row"><input class="col-4" value="02/2021"/>    <input class="col-4" value="02/2025"/></div>
          <div class="point">
            GPA:
            <input value="4.0"/>
          </div>    
      </div>
    `
  );
}
export { readEducationRequest, createEducation };
