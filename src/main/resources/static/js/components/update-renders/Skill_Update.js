function renderSkillsUpdate(data) {
  $(".soft_skill_info").html("");
  $(".professional_skill_info").html("");
  data.forEach((items) => {
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
  <div class="input_wapper skill_delete">
    <input type="text" class="col-12" data-id="${items.skillsID}" value="${items.skillsName} " />
  </div>    
     `;
  htmlSoftSkills.append(softSkill);
}
function renderProfessionUpdate(items) {
  let htmlProfessionalSkills = $(".professional_skill_info");
  const professionallySkill = `
  <div class="input_wapper skill_delete">
     <input type="text" class="col-12" data-id="${items.skillsID}"   value="${items.skillsName} " />
  </div>
     `;
  htmlProfessionalSkills.append(professionallySkill);
}
export { renderSkillsUpdate };
