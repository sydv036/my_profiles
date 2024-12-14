import { getProfile } from "./common/API_GetProfiles.js";
import { renderBasicInfo } from "./render/BasicInfo.js";
import { renderCareeGoal } from "./render/CareerGoals.js";
import { renderCertificate } from "./render/Certificate.js";
import { renderEducation } from "./render/Education.js";
import { renderExperiences } from "./render/Experience.js";
import { renderProject } from "./render/Project.js";
import { renderSkills } from "./render/Skills.js";
$(() => {
  getProfile(function (data) {
    renderBasicInfo(data);
    renderCareeGoal(data);
    renderEducation(data);
    renderSkills(data);
    renderExperiences(data);
    renderCertificate(data);
    renderProject(data);
  });
});
