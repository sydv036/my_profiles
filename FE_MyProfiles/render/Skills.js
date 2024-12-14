function renderSkills(data) {
  if (data === null || data.skills.length === 0) {
    return;
  }
  renderTitleSkills();
  data.skills.forEach((items) => {
    if (items.skillsTypeName == 0) {
      renderProfessionallySkills(items);
    } else {
      renderSoftSkills(items);
    }
  });
}
function renderSoftSkills(data) {
  let htmlSoftSkills = $(".soft_skill_info");
  const softSkill = `
    <li>${data.skillsName}</li>
    `;
  htmlSoftSkills.append(softSkill);
}
function renderProfessionallySkills(data) {
  let htmlProfessionalSkills = $(".professional_skill_info");
  const professionallySkill = `
    <li>${data.skillsName}</li>
    `;
  htmlProfessionalSkills.append(professionallySkill);
}
function renderTitleSkills() {
  const skill = $(".skills");
  skill.append(`
    <div class="skills_title border-bottom text-uppercase">
          Kĩ năng
    </div>
    <div class="skills_name padding-custom">
      <div class="soft_skills">
        <b>Kĩ năng mềm</b>
        <ul class="soft_skill_info"></ul>
      </div>
      <div class="professional_skills padding-custom">
        <b>Kĩ năng chuyên môn</b>
        <ul class="professional_skill_info"></ul>
      </div>
    </div>
  `);
}
export { renderSkills };
