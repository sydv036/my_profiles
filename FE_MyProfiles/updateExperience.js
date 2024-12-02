import { create, callApiPost, handleInput } from "./common.js";
function createExperience() {
  create(
    "icon-experience",
    "experience-info-update",
    `<div class="experience-info">
        <input name="companyName" value="VIETTEL" class="company-name" />
        <div>
            <input name="jobTitle" class="job-title" value="DEVELOPER"/>
            <div class="time-on-job "><input name="fromDate" value="10-2100"/> - <input name="toDate" value="10-2100"/> </div>
        </div> 
      </div> 
   `
  );
}
function updateExperience() {
  handleInput("experience-info", "experience-info", "id", function (data) {
    callApiPost("/api/v1/admin/updateExperience", data);
  });
}

export { createExperience, updateExperience };
