import { isCheckNullList } from "../common.js";
function renderCareeGoal(data) {
  if (data === null || data.target.length === 0) {
    return;
  }
  renderCareeGoalTitle();
  data.target.forEach((items) => {
    if (items.targetTypeName == 1) {
      renderShotTermGoal(items);
    } else {
      renderLongTermGoal(items);
    }
  });
}
function renderCareeGoalTitle() {
  let htmlTitleCareeGoal = $(".career-goals");
  htmlTitleCareeGoal.append(`
    <div class="title-career-goals text-uppercase border-bottom margin-bottom ">
          Mục tiêu nghề nghiệp
    </div>
    <div class="shot-term-goals" >
    <b>Mục tiêu ngắn hạn</b>
    <ul class="shot-goal"></ul>
    </div>
    <div class="long-term-goals">
      <b>Mục tiêu dài hạn</b>
      <ul class="long-goal"></ul>
    </div>
    
  `);
}
function renderShotTermGoal(data) {
  let htmlShotTermGoal = $(".shot-goal");
  const itemShotTermGoal = `
  <li>${data.targetName}</li>
`;
  htmlShotTermGoal.append(itemShotTermGoal);
}
function renderLongTermGoal(data) {
  let htmlLongTermGoal = $(".long-goal");
  const itemLongTermGoal = `
  <li>${data.targetName}</li>
`;
  htmlLongTermGoal.append(itemLongTermGoal);
}
export { renderCareeGoal };
