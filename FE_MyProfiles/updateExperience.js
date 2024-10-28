import { create } from "./common.js";
function readExperienceRequest() {
  let htmlExperience = $(".experience-info-update .experience-info ");
  let experienceDataRequest = [];
  htmlExperience.each(function (item) {
    htmlExperience[item].querySelectorAll("input").forEach((data) => {
      experienceDataRequest.push(data.defaultValue);
    });
  });
}
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
export { readExperienceRequest, createExperience };