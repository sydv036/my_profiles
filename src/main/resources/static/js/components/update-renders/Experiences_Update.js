function renderExperienceUpdate(data) {
  let htmlExperience = $(".experience_info");
  htmlExperience.html("");
  data.forEach((item) => {
    const experience = `
            <div class="experience_form form_delete" data-id="${item.experienceID} ">
              <input type="text" name="companyName" value="${item.companyName}" class="company-name" />
              <div>
                  <input type="text" name="jobTitle" class="job-title" value="${item.jobTitle}"/>
                  <div class="time-on-job ">
                    <input type="text"  name="fromDate" value="${item.fromDate}"/>  
                    <input type="text"  name="toDate" value="${item.toDate}"/> 
                  </div>
              </div> 
            </div>   
      `;
    htmlExperience.append(experience);
  });
}
export { renderExperienceUpdate };
