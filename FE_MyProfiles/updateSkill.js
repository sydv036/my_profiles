import {
  create,
  handleInputSingle,
  callApiPost,
  handleDeleteObj,
} from "./common.js";
function createSoftSkill() {
  create(
    "icon-soft-skill",
    "soft_skill_info",
    '<input type="text" class="col-12" value="Kĩ năng mềm của bạn" />'
  );
}
function createProfessionalSkill() {
  create(
    "icon-profess-skill",
    "professional_skill_info",
    '<input type="text" class="col-12" value="Kĩ năng chuyên môn của bạn" />'
  );
}
function updateSkill() {
  handleInputSingle("professional_skill_info ", "id", function (callback) {
    callApiPost("/api/v1/admin/updateSkill/0", callback);
  });
  handleInputSingle("soft_skill_info ", "id", function (callback) {
    callApiPost("/api/v1/admin/updateSkill/1", callback);
  });
  handleDeleteObj("/api/v1/admin/deleteSkill", true, "skill_delete");
}
export { createSoftSkill, createProfessionalSkill, updateSkill };
