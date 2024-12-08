import { create, handleInput, callApiPost } from "./common.js";
function createProject() {
  create(
    "icon-add-project",
    "project-info-custom",
    `
              <div class='project-form row'>
                  <div class="time-on col-6 ">
                    <input type='text' name="jobTitle" class="job-title" value="Chức vụ"/>
                    <div class="working-time row"><input type='text' name="fromDate" class="col-3" value="10/2024"/> - <input type='text' name="toDate"  class="col-3" value="12/2024"/></div>
                  </div>
                  <div class="project-description mb-2 col-6">
                    <div class="project-title"><input name='projectName' value="Đồ án tốt nghiệp"/></div>
                    <div class="project-body">Thông tin dự án</div>
                  </div>
              </div>
      `,
    function () {
      const inputValue = $(
        ".project-info-custom .project-form:last input[type='text']"
      );
      const data = {};
      inputValue.each(function () {
        const key = $(this).attr("name");
        const value = $(this).val();
        data[key] = value;
      });
      data["description"] = "Thông tin dự án";
      console.log(data);
      callApiPost("/api/v1/admin/saveProject", data);
    }
  );
}

function updateProject() {
  handleInput("project-form", "project-form", "id", function (data) {
    callApiPost("/api/v1/admin/updateProject", data);
  });
}

export { createProject, updateProject };
