import { getProfile } from "./common/API_GetProfiles.js";
import { renderBasicInfoUpdate } from "./render_update/Basic-Info_Update.js";
import { renderCareerGoal } from "./render_update/CareerGoals_Update.js";

$(() => {
  getProfile(function (data) {
    console.log(data);
    renderBasicInfoUpdate(data);
    renderCareerGoal(data);
  });
});
