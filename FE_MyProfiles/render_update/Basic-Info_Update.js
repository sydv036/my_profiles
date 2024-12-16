function renderBasicInfoUpdate(data) {
  const avatar = data.image ? data.image : "https://placehold.co/100X100";
  $(".avartar img").attr("src", avatar);
  //Basic Info
  let htmlBasicInfo = $(".basic-info");
  const info = `
      <div class="name border-bottom" data-citizen-card="${data.citizenCard}">
        <input type="hidden" name="citizenCard" value="${data.citizenCard}">
        <input type="text" name="fullName"  class="text-uppercase" value="${data.fullName}"/>
        <input type="text" name="jobTitleApplly"  class="text-uppercase" value="${data.jobTitleApply}" />
      </div>
      <div class="contact" data-citizen-card="${data.citizenCard}">
          <div class="birth-day">
            <i class="fas fa-calendar-week"></i>
            <input type="text" name="birthDate" value="${data.birthDate}"/>
          </div>
          <div class="sex">
            <i class="fas fa-user"></i>
            <input type="text" name="gender" value="Fame"/>
          </div>
          <div class="phone">
            <i class="fas fa-phone"></i>
            <input type="text" name="phoneNumber" value="${data.phoneNumber}" />
          </div>
          <div class="email">
            <i class="far fa-envelope"></i>
            <input type="text" name="email" value="${data.email}"/>
          </div>
          <div class="adress">
            <i class="fas fa-map-marker-alt"></i>
            <input type="text" name="adress" value="${data.adress}"/>
          </div>
          <div class="link">
            <i class="fas fa-link"></i>
            <input type="text" name="link" value="${data.link}"/>
          </div>
      </div>
    `;
  htmlBasicInfo.append(info);
}

export { renderBasicInfoUpdate };
