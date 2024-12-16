function renderEducation(data) {
  if (data === null || data.education.length === 0) {
    return;
  }
  renderEducationTitle();
  let htmlEducationInfo = $(".education_info");
  data.education.forEach((items) => {
    const education = `
        <div class="education_name">
          <b class="text-hover showImgEducation" data-id="${items.educationID}">${items.educationName}</b>
        </div>
        <div class="major">
          <b>${items.major}</b>
        </div>
        <div class="education_year">${items.startDate} - ${items.endDate}</div>
        <div class="education_point">
          GPA:
          <p>${items.point}</p>
        </div>
      `;
    htmlEducationInfo.append(education);
  });
}
function renderEducationTitle() {
  const title = $(".education");
  title.append(`
    <div class="education_title text-uppercase border-bottom margin-bottom ">Học vấn</div>
    <div class="education_info padding-custom"></div>
  `);
}
export { renderEducation };
