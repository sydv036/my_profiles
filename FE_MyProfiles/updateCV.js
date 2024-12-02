import { uploadImage } from "./imageUpload.js";
import { updateInformation } from "./updateInfo.js";
import { createShotGoal, createLongGoal, updateGoal } from "./updateGoal.js";
import {
  createSoftSkill,
  createProfessionalSkill,
  updateSkill,
} from "./updateSkill.js";
import { createExperience, updateExperience } from "./updateExperience.js";
import { createProject, handleQuill } from "./updateProject.js";
import { updateCertificate } from "./updateCertificate.js";
import { createEducation } from "./updateEducation.js";

$(() => {
  createShotGoal();
  createLongGoal();
  createSoftSkill();
  createProfessionalSkill();
  createExperience();
  createProject();
  handleQuill();
  createEducation();
  updateInformation();
  updateGoal();
  updateSkill();
  updateCertificate();
  updateExperience();
});
