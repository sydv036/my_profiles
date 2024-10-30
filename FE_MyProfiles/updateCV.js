import { uploadImage } from "./imageUpload.js";
import { readAccountRequest } from "./updateInfo.js";
import {
  readGoalRequest,
  createShotGoal,
  createLongGoal,
} from "./updateGoal.js";
import {
  readSkillRequest,
  createSoftSkill,
  createProfessionalSkill,
} from "./updateSkill.js";
import { readExperienceRequest, createExperience } from "./updateExperience.js";
import { createProject } from "./updateProject.js";
import { readCertificate, createCertificate } from "./updateCertificate.js";

$(() => {
  createShotGoal();
  createLongGoal();
  createSoftSkill();
  createProfessionalSkill();
  createExperience();
  createProject();
  createCertificate();
  $(".updateCV").click(() => {
    console.table(readAccountRequest());
    console.log(readGoalRequest());
    console.log(readSkillRequest());
    console.log(readExperienceRequest());
    readCertificate();
  });
});
