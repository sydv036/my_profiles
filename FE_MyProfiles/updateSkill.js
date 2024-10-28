import { create } from "./common.js";
function readSkillRequest() {
  let htmlSoftSkill = $(".soft-skill-info input");
  let softSkillDataRequest = [];
  htmlSoftSkill.each(function () {
    let id = $(this).data("id");
    let value = $(this).val();
    softSkillDataRequest.push({ id: id, value: value });
  });

  let htmlProfessionalSkill = $(".professional-skill-info input");
  let professionalSkillDataRequest = [];
  htmlProfessionalSkill.each(function () {
    let id = $(this).data("id");
    let value = $(this).val();
    professionalSkillDataRequest.push({ id: id, value: value });
  });
  return { softSkillDataRequest, professionalSkillDataRequest };
}
function createSoftSkill() {
  create(
    "icon-soft-skill",
    "soft-skill-info",
    '<input class="col-12" value="Kĩ năng mềm của bạn" />'
  );
}
function createProfessionalSkill() {
  create(
    "icon-profess-skill",
    "professional-skill-info",
    '<input class="col-12" value="Kĩ năng chuyên môn của bạn" />'
  );
}
export { readSkillRequest, createSoftSkill, createProfessionalSkill };
