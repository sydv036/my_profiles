import {
  create,
  callApiPost,
  handleInput,
  handleInputSingle,
  handleDeleteObj,
  callApiGet,
} from "../../common/common.js";
import { renderCareerGoalUpdate } from "../update-renders/CareerGoals_Update.js";
function createShotGoal() {
  create(
    "icon-shot-term-goals",
    "shot-goal",
    "<input type='text'  class='col-12' value='Mục tiêu ngắn hạn của bạn' />"
  );
}
function createLongGoal() {
  create(
    "icon-long-term-goals",
    "long-goal",
    "<input type='text' class='col-12' value='Mục tiêu dài hạn của bạn' />"
  );
}
function updateGoal() {
  const urlGet = "/api/v1/personal/target";
  const functionRender = renderCareerGoalUpdate;
  handleInputSingle("shot-goal ", "id", function (callback) {
    callApiPost(
      "/api/v1/admin/updateTarge/1",
      callback,
      urlGet,
      functionRender
    );
  });
  handleInputSingle("long-goal ", "id", function (callback) {
    callApiPost(
      "/api/v1/admin/updateTarge/0",
      callback,
      urlGet,
      functionRender
    );
  });
  handleDeleteObj(
    "/api/v1/admin/deleteTarget/",
    true,
    "career_goal_delete",
    "/api/v1/personal/target",
    renderCareerGoalUpdate
  );
}
export { createShotGoal, createLongGoal, updateGoal };
