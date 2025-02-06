import { callApiGet, renderCss } from "../../common/common.js";
import { renderBasicInfoUpdate } from "./Basic-Info_Update.js";
import { renderCareerGoalUpdate } from "./CareerGoals_Update.js";
import { renderCertificateUpdate } from "./Certificate_Update.js";
import { renderEducationUpdate } from "./Education_Update.js";
import { renderExperienceUpdate } from "./Experiences_Update.js";
import { renderProjectUpdate } from "./Project_Update.js";
import { renderSkillsUpdate } from "./Skill_Update.js";

$(async () => {
  const dataBasicInfo = await callApiGet("/api/v1/personal/basic-info");
  const dataTarget = await callApiGet("/api/v1/personal/target");
  const dataEdu = await callApiGet("/api/v1/personal/education");
  const dataSkill = await callApiGet("/api/v1/personal/skill");
  const dataExp = await callApiGet("/api/v1/personal/experiences");
  const dataPro = await callApiGet("/api/v1/personal/project");
  const dataCert = await callApiGet("/api/v1/personal/certificate");
  renderBasicInfoUpdate(dataBasicInfo);
  renderCareerGoalUpdate(dataTarget);
  renderEducationUpdate(dataEdu);
  renderSkillsUpdate(dataSkill);
  renderExperienceUpdate(dataExp);
  renderProjectUpdate(dataPro);
  renderCertificateUpdate(dataCert);
  renderCss("color-common", "color", dataBasicInfo.color);
  renderCss("font-size-common", "font-size", dataBasicInfo.fontSize);
  renderCss("main-profile", "font-family", dataBasicInfo.fontFamily);
});
