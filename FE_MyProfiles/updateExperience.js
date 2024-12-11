import { create, callApiPost, handleInput } from "./common.js";
function createExperience() {
  create(
    "icon-experience",
    "experience-info-update",
    `<div class="experience-info">
        <input type="text"  name="companyName" value="VIETTEL" class="company-name" />
        <div>
            <input type="text"  name="jobTitle" class="job-title" value="DEVELOPER"/>
            <div class="time-on-job "><input type="text"  name="fromDate" value="10-2020"/> - <input type="text"  name="toDate" value="10-2024"/> </div>
        </div> 
      </div> 
   `,
    function () {
      const inputValue = $(
        ".experience-info-update .experience-info:last input[type='text']"
      );
      const data = {};
      inputValue.each(function () {
        const key = $(this).attr("name");
        const value = $(this).val();
        data[key] = value;
      });
      console.log(data);
      callApiPost("/api/v1/admin/createExperience", data);
    }
  );
}
function updateExperience() {
  handleInput("experience-info", "experience-info", "id", function (data) {
    callApiPost("/api/v1/admin/updateExperience", data);
  });
}

export { createExperience, updateExperience };
