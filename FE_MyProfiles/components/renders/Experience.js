function renderExperiences(data) {
  if (data === null || data.length === 0) {
    return;
  }
  renderExperiencesTitle();
  let htmlExperience = $(".experience_info");
  data.forEach((item) => {
    const experience = `
    <div class="experience_form">
      <b class="company-name">${item.companyName}</b>
      <div>
          <b class="job-title">${item.jobTitle}</b>
          <div class="time-on-job">${item.fromDate} ~ ${item.toDate}</div>
      </div>
    </div>  
            `;
    htmlExperience.append(experience);
  });
}
function renderExperiencesTitle() {
  const title = $(".experience");
  title.append(`
    <div class="experience_title text-uppercase border-bottom margin-bottom font-size-common color-common">
          Kinh nghiệm
    </div>
    <div class="experience_info mb-3 padding-custom"></div>
  `);
}
export { renderExperiences };
