function renderCareerGoalUpdate(data) {
  data.target.forEach((items) => {
    if (items.targetTypeName == 1) {
      renderShotTermGoalUpdate(items);
    } else {
      renderLongCareerGoalUpdate(items);
    }
  });
}
function renderShotTermGoalUpdate(data) {
  let htmlShotTermGoal = $(".shot-goal");
  const itemShotTermGoal = `
    <input type="text" class="col-12 input-shot-goal" data-id="${data.targetID}" value="${data.targetName}"/>
`;
  htmlShotTermGoal.append(itemShotTermGoal);
}
function renderLongCareerGoalUpdate(data) {
  let htmlLongTermGoal = $(".long-goal");
  const itemLongTermGoal = `
    <input type="text" class="col-12" data-id="${data.targetID}"  value="${data.targetName}"/>
`;
  htmlLongTermGoal.append(itemLongTermGoal);
}
export { renderCareerGoalUpdate };
