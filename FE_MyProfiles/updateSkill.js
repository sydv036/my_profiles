import { create, handleInputSingle, callApiPost } from "./common.js";
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
function updateSkill() {
  handleInputSingle("professional-skill-info ", "id", function (callback) {
    callApiPost("/api/v1/admin/updateSkill/0", callback);
  });
  handleInputSingle("soft-skill-info ", "id", function (callback) {
    callApiPost("/api/v1/admin/updateSkill/1", callback);
  });
}
export { createSoftSkill, createProfessionalSkill, updateSkill };
