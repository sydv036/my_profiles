import { create } from "./common.js";
function createProject() {
  create(
    "icon-add-project",
    "project-info-custom",
    `
              <div class='project-form row'>
                  <div class="time-on col-6 ">
                    <input class="job-title" value="Chức vụ"/>
                    <div class="working-time row"><input class="col-3" value="10/2024"/> - <input class="col-3" value="12/2024"/></div>
                  </div>
                  <div class="project-description mb-2 col-6">
                    <div class="project-title"><input value="Đồ án tốt nghiệp"/></div>
                    <input class="project-body" value="Thông tin dự án"/>
                  </div>
              </div>
      `
  );
}
export { createProject };
