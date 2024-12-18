import { create, handleInput, callApiPost } from "./common.js";
function createProject() {
  create(
    "icon-add-project",
    "project_form",
    `
              <div class='project_info row'>
                  <div class="time-on col-6 ">
                    <input type='text' name="jobTitle" class="job-title" value="Chức vụ"/>
                    <div class="working-time row">
                      <input type='text' name="fromDate" class="col-3" value="10/2024"/>
                      <input type='text' name="toDate"  class="col-3" value="12/2024"/>
                    </div>
                  </div>
                  <div class="project_description mb-2 col-6">
                    <div class="project_title">
                      <input type='text' name='projectName' value="Đồ án tốt nghiệp"/>
                    </div>
                    <div class="project_body">Thông tin dự án</div>
                  </div>
              </div>
      `,
    function () {
      const inputValue = $(
        ".project_form .project_info:last input[type='text']"
      );
      const data = {};
      inputValue.each(function () {
        const key = $(this).attr("name");
        const value = $(this).val();
        data[key] = value;
      });
      data["description"] = "Thông tin dự án";
      callApiPost("/api/v1/admin/saveProject", data);
    }
  );
}

function updateProject() {
  handleInput("project_info", "project_info", "id", function (data) {
    callApiPost("/api/v1/admin/updateProject", data);
  });
}

export { createProject, updateProject };
