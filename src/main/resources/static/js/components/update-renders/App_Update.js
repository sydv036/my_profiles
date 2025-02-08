import { callApiGet, renderCss } from "../../common/common.js";
import { renderBasicInfoUpdate } from "./Basic-Info_Update.js";
import { renderCareerGoalUpdate } from "./CareerGoals_Update.js";
import { renderCertificateUpdate } from "./Certificate_Update.js";
import { renderEducationUpdate } from "./Education_Update.js";
import { renderExperienceUpdate } from "./Experiences_Update.js";
import { renderProjectUpdate } from "./Project_Update.js";
import { renderSkillsUpdate } from "./Skill_Update.js";
import renderSortableUpdate from "./Sortable_Update.js";

async function fetchData(endPoint) {
  const data = await callApiGet(endPoint);
  return data;
}

$(async () => {
  try {
    const [
      sortable,
      dataBasicInfo,
      dataTarget,
      dataEdu,
      dataSkill,
      dataExp,
      dataPro,
      dataCert,
    ] = await Promise.all([
      fetchData("/api/v1/personal/sortable"),
      fetchData("/api/v1/personal/basic-info"),
      fetchData("/api/v1/personal/target"),
      fetchData("/api/v1/personal/education"),
      fetchData("/api/v1/personal/skill"),
      fetchData("/api/v1/personal/experiences"),
      fetchData("/api/v1/personal/project"),
      fetchData("/api/v1/personal/certificate"),
    ]);
    renderSortableUpdate(sortable);
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
  }catch (err) {
    console.log(err);
  }
});
