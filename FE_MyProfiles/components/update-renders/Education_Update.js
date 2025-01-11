function renderEducationUpdate(data) {
  let htmlEducationInfo = $(".education_info");
  htmlEducationInfo.html("");
  data.forEach((items) => {
    const education = `
        <div class="education_form form_delete mb-3" data-id="${items.educationID}">
            <div class="education_name">
              <input type="text" name="educationName" class="" data-id="${items.educationID}" value="${items.educationName}"/>
            </div>
            <div class="major">
              <input type="text" name="major" value="${items.major}" />
            </div>
            <div class="year-learn">
                <input type="text"  name="startDate" class="" value="${items.startDate}"/>    
                <input type="text"  class="" name="endDate" value="${items.endDate}"/>
            </div>
            <div class="point">
              GPA:
              <input type="text" name="point" value="${items.point}"/>
            </div>
        </div>
          `;
    htmlEducationInfo.append(education);
  });
}
export { renderEducationUpdate };
