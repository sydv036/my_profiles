import { getProfile } from "./common/API_GetProfiles.js";
import { renderBasicInfoUpdate } from "./render_update/Basic-Info_Update.js";
import { renderCareerGoalUpdate } from "./render_update/CareerGoals_Update.js";
import { renderCertificateUpdate } from "./render_update/Certificate_Update.js";
import { renderEducationUpdate } from "./render_update/Education_Update.js";
import { renderExperienceUpdate } from "./render_update/Experiences_Update.js";
import { renderProjectUpdate } from "./render_update/Project_Update.js";
import { renderSkillsUpdate } from "./render_update/Skill_Update.js";

$(() => {
  getProfile(function (data) {
    console.log(data);
    renderBasicInfoUpdate(data);
    renderCareerGoalUpdate(data);
    renderEducationUpdate(data);
    renderSkillsUpdate(data);
    renderExperienceUpdate(data);
    renderProjectUpdate(data);
    renderCertificateUpdate(data);
  });
});
