function renderSkillsUpdate(data) {
  data.skills.forEach((items) => {
    if (items.skillsTypeName == 0) {
      renderProfessionUpdate(items);
    } else {
      renderSoftSkillUpdate(items);
    }
  });
}
function renderSoftSkillUpdate(items) {
  let htmlSoftSkills = $(".soft_skill_info");
  const softSkill = `
    <input type="text" class="col-12" data-id="${items.skillsID}" value="${items.skillsName} " />
     `;
  htmlSoftSkills.append(softSkill);
}
function renderProfessionUpdate(items) {
  let htmlProfessionalSkills = $(".professional_skill_info");
  const professionallySkill = `
    <input type="text" class="col-12" data-id="${items.skillsID}"   value="${items.skillsName} " />
     `;
  htmlProfessionalSkills.append(professionallySkill);
}
export { renderSkillsUpdate };
