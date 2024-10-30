$(() => {
  const API = "http://localhost:8081/api/v1/";
  var dataCertificateResponse;

  getProfile();
  handleShowImg(".showImgCertificate", "certificate");
  handleShowImg(".showImgEducation", "education");
  cancelImg();

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
                <input type="hidden" name="citizenCard" value="${data.citizenCard}">
                <input type="text" name="fullName" class="text-uppercase" value="${data.fullName}"/>
                <input type="text" name="jobTitleApply" class="text-uppercase" value="${data.jobTitleApply}" />
              </div>
              <div class="contact">
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

          // career goals
          let htmlShotTermGoal = $(".shot-goal");
          let htmlLongTermGoal = $(".long-goal");
          data.target.forEach((items) => {
            if (items.targetTypeName == "SHOT") {
              const itemShotTermGoal = `
                    <input class="col-12" data-id="${items.targetID}" value="${items.targetName}"/>
                `;
              htmlShotTermGoal.append(itemShotTermGoal);
            } else {
              const itemLongTermGoal = `
                    <input class="col-12" data-id="${items.targetID}"  value="${items.targetName}"/>
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
                  <input value="${items.major}" />
                </div>
                <div class="year-learn row"><input value="${items.startDate}"/>  -  <input value="${items.endDate}"/></div>
                <div class="point">
                  GPA:
                  <input value="${items.point}"/>
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
                   <input class="col-12" data-id="${items.skillsID}"   value="${items.skillsName} " />
                    `;
              htmlProfessionalSkills.append(professionallySkill);
            } else {
              const softSkill = `
                   <input class="col-12" data-id="${items.skillsID}" value="${items.skillsName} " />
                    `;
              htmlSoftSkills.append(softSkill);
            }
          });

          //Experience
          let htmlExperience = $(".experience-info-update");
          data.experience.forEach((item) => {
            const experience = `
                  <div class="experience-info">
                    <input data-id=""${item.experienceID} name="companyName" value="${item.companyName}" class="company-name" />
                    <div>
                        <input name="jobTitle" class="job-title" value="${item.jobTitle}"/>
                        <div class="time-on-job "><input name="fromDate" value="${item.fromDate}"/> - <input name="toDate" value="${item.toDate}"/> </div>
                    </div> 
                  </div>   
            `;
            htmlExperience.append(experience);
          });

          //certificate
          let htmlCertificate = $(".certificate-info");
          data.certificate.forEach((items, index) => {
            const certificateInfo = `
                    <div class="certificate-form row">
                      <b class="col-9 " data-id="${items.certificateID}" >${items.certificateName}</b>
                      <p class="duration-custom col-3" >${items.duration} </p>
                    </div>
                `;
            htmlCertificate.append(certificateInfo);
          });

          //project
          let htmlProject = $(".project-info-custom");
          data.project.forEach((item) => {
            const projectInfo = `
              <div class='project-form row'>
                <div class="time-on col-6 ">
                  <input class="job-title" value="${item.jobTitle}"/>
                  <div class="working-time row"><input class="col-3" value="${item.fromDate}"/> - <input class="col-3" value="${item.toDate}"/></div>
                </div>
                <div class="project-description mb-2 col-6">
                  <div class="project-title"><input value="${item.projectName}"/></div>
                  <input class="project-body" value="${item.description}"/>
                </div>
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
        $(".img-show-more").attr("src", "data:image/png;base64," + imgName);
      } else {
        alert("Ảnh chưa được cập nhật......");
      }
    });
  }
  function cancelImg() {
    $(document).on("click", ".cancel-img", function () {
      $(".main-show-img").css("display", "none");
    });
  }
});
