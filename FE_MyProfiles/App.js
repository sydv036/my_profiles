$(() => {
  const API = "http://localhost:8081/api/v1/";

  $(".printPDF").click(() => {
    alert("Đang thực hiện chức năng!");
  });
  getProfile();

  function getProfile() {
    $.ajax({
      url: API + "profile",
      type: "GET",
      dataType: "json",
      success: function (response) {
        if (response.statusCode === 200) {
          const data = response.data;
          //Basic Info
          let htmlBasicInfo = $(".basic-info");
          const info = `
            <div class="name">
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
              <a href="#">${data.link}</a>
            </div>
          </div>
          `;
          htmlBasicInfo.append(info);

          // career goals
          let htmlShotTermGoal = $(".shot-goal");
          let htmlLongTermGoal = $(".long-goal");
          data.target.forEach((items) => {
            if (items.targetTypeName == "SHOT") {
              const itemShotTermGoal = `
                  <li>${items.targetName}</li>
              `;
              htmlShotTermGoal.append(itemShotTermGoal);
            } else {
              const itemLongTermGoal = `
                  <li>${items.targetName}</li>
              `;
              htmlLongTermGoal.append(itemLongTermGoal);
            }
          });

          //Education
          let htmlEducationInfo = $(".education-info");
          data.education.forEach((items) => {
            const education = `
              <div class="education-name">
                <b>${items.educationName}</b>
              </div>
              <div class="major">
                <b>${items.major}</b>
              </div>
              <div class="year-learn">${items.startDate} - ${items.endDate}</div>
              <div class="point">
                GPA:
                <p>${items.point}</p>
              </div>
            `;
            htmlEducationInfo.append(education);
          });

          //Skills
          let htmlSoftSkills = $(".soft-skill-info");
          let htmlProfessionalSkills = $(".professional-skill-info");
          data.skills.forEach((items) => {
            if (items.skillsTypeName == "PROFESSIONAL_SKILLS") {
              const professionallySkill = `
                  <li>${items.skillsName}</li>
                  `;
              htmlProfessionalSkills.append(professionallySkill);
            } else {
              const softSkill = `
                  <li>${items.skillsName}</li>
                  `;
              htmlSoftSkills.append(softSkill);
            }
          });

          //certificat
          let htmlCertificate = $(".certificate-info");
          data.certificate.forEach((items) => {
            const certificateInfo = `
                  <div>
                    <b>${items.certificateName}</b>
                    <p>${items.duration}</p>
                  </div>
              `;
            htmlCertificate.append(certificateInfo);
          });
          console.log(data);
          return;
        }
        console.log("Data couldn't get in Server");
      },
      error: function (error) {
        console.log("Error: " + error);
      },
    });
  }
});
