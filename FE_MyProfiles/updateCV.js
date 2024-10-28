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
$(() => {
  createShotGoal();
  createLongGoal();
  createSoftSkill();
  createProfessionalSkill();
  createExperience();
  $(".updateCV").click(() => {
    console.table(readAccountRequest());
    console.log(readGoalRequest());
    console.log(readSkillRequest());
    console.log(readExperienceRequest());
  });
});
