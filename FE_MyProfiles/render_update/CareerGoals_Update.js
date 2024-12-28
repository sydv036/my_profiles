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
  <div class="input_wapper career_goal_delete">
    <input type="text" class="col-12 input-shot-goal" data-id="${data.targetID}" value="${data.targetName}"/>
  </div>  
`;
  htmlShotTermGoal.append(itemShotTermGoal);
}
function renderLongCareerGoalUpdate(data) {
  let htmlLongTermGoal = $(".long-goal");
  const itemLongTermGoal = `
  <div class="input_wapper career_goal_delete">
     <input type="text" class="col-12" data-id="${data.targetID}"  value="${data.targetName}"/>
  </div>
   `;
  htmlLongTermGoal.append(itemLongTermGoal);
}
export { renderCareerGoalUpdate };
