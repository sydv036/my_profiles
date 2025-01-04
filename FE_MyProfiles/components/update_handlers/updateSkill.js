import {
  create,
  handleInputSingle,
  callApiPost,
  handleDeleteObj,
} from "../../common/common.js";
import { renderSkillsUpdate } from "../update-renders/Skill_Update.js";
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
  const urlGet = "/api/v1/personal/skill";
  const functioRender = renderSkillsUpdate;
  handleInputSingle("professional_skill_info ", "id", function (callback) {
    callApiPost("/api/v1/admin/updateSkill/0", callback, urlGet, functioRender);
  });
  handleInputSingle("soft_skill_info ", "id", function (callback) {
    callApiPost("/api/v1/admin/updateSkill/1", callback, urlGet, functioRender);
  });
  handleDeleteObj(
    "/api/v1/admin/deleteSkill",
    true,
    "skill_delete",
    urlGet,
    functioRender
  );
}
export { createSoftSkill, createProfessionalSkill, updateSkill };
