$(() => {
  const API = "http://localhost:8081/api/v1/";
  var dataCertificateResponse;

  getProfile();
  handleShowImg(".showImgCertificate", "certificate");
  handleShowImg(".showImgEducation", "education");

  function getProfile() {
    $.ajax({
      url: API + "profile",
      type: "GET",
      dataType: "json",
      success: function (response) {
        if (response.statusCode === 200) {
          const data = response.data;
          dataResponse = data.certificate;
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
              <a href="${data.link}" target="_blank">${data.link}</a>
            </div>
          </div>
          `;
          htmlBasicInfo.append(info);

          // career goals
          let htmlShotTermGoal = $(".shot-goal");
          let htmlLongTermGoal = $(".long-goal");
          data.target.forEach((items) => {
            if (items.targetTypeName == 1) {
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
                <b class="show-more showImgEducation">${items.educationName}</b>
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

          //Experience
          let htmlExperience = $(".experience-info");
          data.experience.forEach((item) => {
            console.log("helo");

            const experience = `
                <div class="company-name">${item.companyName}</div>
                <div>
                    <div class="job-title">${item.jobTitle}</div>
                    <div class="time-on-job">${item.fromDate} - ${item.toDate} </div>
                </div>
            `;
            htmlExperience.append(experience);
          });

          //certificate
          let htmlCertificate = $(".certificate-info");
          data.certificate.forEach((items, index) => {
            const certificateInfo = `
                  <div>
                    <b class="show-more showImgCertificate" data-id="${items.certificateID}">${items.certificateName}</b>
                    <p>${items.duration}</p>
                  </div>
              `;
            htmlCertificate.append(certificateInfo);
          });

          //project
          let htmlProject = $(".project-info");
          data.project.forEach((item) => {
            const projectInfo = `
                <div class="time-on">
                 <div class="job-title">${item.jobTitle}</div>
                 <div class="working-time">${item.fromDate} - ${item.toDate}</div>
               </div>
               <div class="project-description mb-2">
                 <div class="project-title"><b>${item.projectName}</b></div>
                 <div class="project-body">${item.description}</div>
               </div>
             `;
            htmlProject.append(projectInfo);
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

  function handleShowImg(eventClass, eventType) {
    $(document).on("click", eventClass, function () {
      const idCertificate = $(this).data("id");
      $(".main-show-img").css("display", "none");

      let imgName;
      if (eventType === "certificate") {
        imgName = dataResponse.find((items) => {
          return items.certificateID == idCertificate;
        })?.certificateImage;
      } else if (eventType === "education") {
        imgName = "education";
      }

      if (imgName !== "" || imgName.trim() !== "") {
        $(".main-show-img").slideDown("slow");
        $(".img-show-more").attr("src", imgName);
      } else {
        alert("Ảnh chưa được cập nhật......");
      }
    });
  }

  $(document).on("click", ".cancel-img", function () {
    $(".main-show-img").css("display", "none");
  });
});
