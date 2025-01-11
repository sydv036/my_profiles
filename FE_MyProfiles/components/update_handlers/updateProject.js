import {
    create,
    handleInput,
    callApiPost,
    handleDeleteObj,
} from "../../common/common.js";
import { renderProjectUpdate } from "../update-renders/Project_Update.js";
const urlGet = "/api/v1/personal/project";
const functionRender = renderProjectUpdate;
function createProject() {
    create(
        "icon-add-project",
        "project_form",
        `
              <div class='project_info form_delete'>
                  <div class="time-on  ">
                    <input type='text' name="jobTitle" class="job-title" value="Chức vụ"/>
                    <div class="working-time ">
                      <input type='text' name="fromDate" class="" value="10/2021"/>
                      <input type='text' name="toDate"  class="" value="12/2024"/>
                    </div>
                  </div>
                  <div class="project_description mb-2 col-6">
                    <div class="project_title">
                      <input type='text' name='projectName' value="Dự án của bạn"/>
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
            callApiPost("/api/v1/admin/saveProject", data, urlGet, functionRender);
        }
    );
}

function updateProject() {
    handleInput("project_info", "project_info", "id", function (data) {
        callApiPost("/api/v1/admin/updateProject", data, urlGet, functionRender);
    });
    handleDeleteObj(
        "/api/v1/admin/deleteProject",
        false,
        "project_info",
        urlGet,
        functionRender
    );
}

export { createProject, updateProject };
