import {
  create,
  callApiPost,
  handleInput,
  handleInputSingle,
} from "./common.js";
function createShotGoal() {
  create(
    "icon-shot-term-goals",
    "shot-goal",
    "<input class='col-12' value='Mục tiêu ngắn hạn của bạn' />"
  );
}
function createLongGoal() {
  create(
    "icon-long-term-goals",
    "long-goal",
    "<input class='col-12' value='Mục tiêu dài hạn của bạn' />"
  );
}
function updateGoal() {
  handleInputSingle(".shot-goal input", "id", function (callback) {
    callApiPost("/api/v1/admin/updateTarge/1", callback);
  });
  handleInputSingle(".long-goal input", "id", function (callback) {
    callApiPost("/api/v1/admin/updateTarge/0", callback);
  });
}
export { createShotGoal, createLongGoal, updateGoal };
