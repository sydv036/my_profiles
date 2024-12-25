import { create, callApiPost, handleInput } from "./common.js";
function createExperience() {
  create(
    "icon-experience",
    "experience_info",
    `<div class="experience_form form_delete">
        <input type="text"  name="companyName" value="VIETTEL" class="company-name" />
        <div>
            <input type="text"  name="jobTitle" class="job-title" value="DEVELOPER"/>
            <div class="time-on-job "><input type="text"  name="fromDate" value="10-2020"/>
              <input type="text"  name="toDate" value="10-2024"/> 
            </div>
        </div> 
      </div> 
   `,
    function () {
      const inputValue = $(
        ".experience_info .experience_form:last input[type='text']"
      );
      const data = {};
      inputValue.each(function () {
        const key = $(this).attr("name");
        const value = $(this).val();
        data[key] = value;
      });
      callApiPost("/api/v1/admin/createExperience", data);
    }
  );
}
function updateExperience() {
  handleInput("experience_form", "experience_form", "id", function (data) {
    callApiPost("/api/v1/admin/updateExperience", data);
  });
  // $(document).on("click", ".experience_form", function (event) {
  //   console.log("oke");
  //   // const x = e.offsetx;
  // });
}

export { createExperience, updateExperience };
