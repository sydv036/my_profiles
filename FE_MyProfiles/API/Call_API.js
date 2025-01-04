import { callApiGet } from "../common/common.js";

async function callApiGetBasicInfo() {
  const dataBasicInfo = await callApiGet("/api/v1/personal/basic-info");
  return dataBasicInfo;
}
async function callApiGetEducation() {
  const dataEdu = await callApiGet("/api/v1/personal/education");
  return dataEdu;
}
async function callApiGetTarget() {
  const dataTarget = await callApiGet("/api/v1/personal/target");
  return dataTarget;
}
async function callApiGetSkill() {
  const dataSkill = await callApiGet("/api/v1/personal/skill");
  return dataSkill;
}
async function callApiGetExperience() {
  const dataExp = await callApiGet("/api/v1/personal/experiences");
  return dataExp;
}
async function callApiGetProject() {
  const dataPro = await callApiGet("/api/v1/personal/project");
  return dataPro;
}
async function callApiGetCertificate() {
  const dataCert = await callApiGet("/api/v1/personal/certificate");
  return dataCert;
}
export {
  callApiGetBasicInfo,
  callApiGetEducation,
  callApiGetTarget,
  callApiGetSkill,
  callApiGetExperience,
  callApiGetProject,
  callApiGetCertificate,
};
