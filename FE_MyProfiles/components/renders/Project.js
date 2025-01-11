function renderProject(data) {
  if (data === null || data.length === 0) {
    return;
  }
  renderProjectTitle();
  let htmlProject = $(".project_info");
  data.forEach((item) => {
    const projectInfo = `
          <div class="time-on">
           <div class="job-title">${item.jobTitle}</div>
           <div class="working-time">${item.fromDate} ~ ${item.toDate}</div>
         </div>
         <div class="project-description mb-2">
           <div class="project_name"><b>${item.projectName}</b></div>
           <div class="project_description" >${item.description}</div>
         </div>
       `;
    htmlProject.append(projectInfo);
  });
}
function renderProjectTitle() {
  const title = $(".project");
  title.append(`
    <div class="project_title text-uppercase border-bottom margin-bottom font-size-common color-common">Project</div>
    <div class="project_info padding-custom"></div>
  `);
}
export { renderProject };
