import { updateInformation } from "./updateInfo.js";
import { createShotGoal, createLongGoal, updateGoal } from "./updateGoal.js";
import {
  createSoftSkill,
  createProfessionalSkill,
  updateSkill,
} from "./updateSkill.js";
import { createExperience, updateExperience } from "./updateExperience.js";
import { createProject, updateProject } from "./updateProject.js";
import { updateCertificate } from "./updateCertificate.js";
import { updateEducation } from "./updateEducation.js";
import {
  handlerColor,
  handlerFontSize,
  handlerFontFamily,
} from "../other_handlers/OtherFunctions.js";
import { hanlerQuill } from "../../config/Quill-Config.js";

$(() => {
  createShotGoal();
  createLongGoal();
  createSoftSkill();
  createProfessionalSkill();
  createExperience();
  createProject();
  updateInformation();
  updateGoal();
  updateSkill();
  updateCertificate();
  updateExperience();
  updateProject();
  updateEducation();
  handlerColor();
  handlerFontSize();
  handlerFontFamily();
  hanlerQuill();
});
