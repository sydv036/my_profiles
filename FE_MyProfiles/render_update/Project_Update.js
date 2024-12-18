function renderProjectUpdate(data) {
  let htmlProject = $(".project_form");
  data.project.forEach((item) => {
    const projectInfo = `
        <div class='project_info' data-id="${item.projectID}">
          <div class="time-on ">
            <input type='text' name="jobTitle" class="job-title" value="${item.jobTitle}"/>
            <div class="working-time ">
                <input type='text' name="fromDate" class="" value="${item.fromDate}"/>
                <input type='text'name="toDate"  class="" value="${item.toDate}"/>
            </div>
          </div>
          <div class="project_description mb-2">
            <div class="project_title">
                <input type='text' name='projectName' value="${item.projectName}"/>
            </div>
            <div class="project_body" >${item.description}</div>
          </div>
        </div>
      `;
    htmlProject.append(projectInfo);
  });
}
export { renderProjectUpdate };
