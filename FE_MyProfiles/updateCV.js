import { uploadImage } from "./imageUpload.js";
import { readAccountRequest, updateInformation } from "./updateInfo.js";
import {
  readGoalRequest,
  createShotGoal,
  createLongGoal,
  updateGoal,
} from "./updateGoal.js";
import {
  readSkillRequest,
  createSoftSkill,
  createProfessionalSkill,
} from "./updateSkill.js";
import { readExperienceRequest, createExperience } from "./updateExperience.js";
import { createProject, handleQuill } from "./updateProject.js";
import { readCertificate, createCertificate } from "./updateCertificate.js";
import { createEducation } from "./updateEducation.js";

$(() => {
  createShotGoal();
  createLongGoal();
  createSoftSkill();
  createProfessionalSkill();
  createExperience();
  createProject();
  handleQuill();
  createCertificate();
  createEducation();
  updateInformation();
  updateGoal();
  $(".updateCV").click(() => {
    console.table(readAccountRequest());
    console.log(readGoalRequest());
    console.log(readSkillRequest());
    console.log(readExperienceRequest());
    readCertificate();
  });
});
