function renderBasicInfo(data) {
  const avatar = data.image ? data.image : "https://placehold.co/100X100";
  $(".avartar img").attr("src", avatar);
  let htmlBasicInfo = $(".basic-info");
  const info = `
    <div class="name border-bottom">
      <h2 class="text-uppercase">${data.fullName}</h2>
      <h3 class="text-uppercase">${data.jobTitleApply}</h3>
    </div>
    <div class="contact">
    <div class="birth-day">
      <i class="fas fa-calendar-week"></i>
      <p>${data.birthDate}</p>
    </div>
    <div class="sex">
      <i class="fas fa-user"></i>
      <p>Fame</p>
    </div>
    <div class="phone">
      <i class="fas fa-phone"></i>
      <p>${data.phoneNumber}</p>
    </div>
    <div class="email">
      <i class="far fa-envelope"></i>
      <p>${data.email}</p>
    </div>
    <div class="adress">
      <i class="fas fa-map-marker-alt"></i>
      <p>${data.adress}</p>
    </div>
    <div class="link">
      <i class="fas fa-link"></i>
      <a href="${data.link}" target="_blank">${data.link}</a>
    </div>
  </div>
  `;
  htmlBasicInfo.append(info);
  renderColor(data.color);
  renderFontSize(data.fontSize);
}
function renderColor(items) {
  $(".color-common").css("color", items);
}
function renderFontSize(items) {
  $(".font-size-common").not("i").css("font-size", parseInt(items));
}
export { renderBasicInfo };
