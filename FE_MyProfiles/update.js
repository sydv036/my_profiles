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
              <div class="name" data-citizen-card="${data.citizenCard}">
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

          // career goals
          let htmlShotTermGoal = $(".shot-goal");
          let htmlLongTermGoal = $(".long-goal");
          data.target.forEach((items) => {
            if (items.targetTypeName == 1) {
              const itemShotTermGoal = `
                    <input type="text"  class="col-12 input-shot-goal" data-id="${items.targetID}" value="${items.targetName}"/>
                `;
              htmlShotTermGoal.append(itemShotTermGoal);
            } else {
              const itemLongTermGoal = `
                    <input type="text" class="col-12" data-id="${items.targetID}"  value="${items.targetName}"/>
                `;
              htmlLongTermGoal.append(itemLongTermGoal);
            }
          });

          //Education
          let htmlEducationInfo = $(".education-info-custom");
          data.education.forEach((items) => {
            const education = `
            <div class="education-info mb-3" data-id="${items.educationID}">
                <div class="education-name">
                  <input type="text" name="educationName" class="" data-id="${items.educationID}" value="${items.educationName}"/>
                </div>
                <div class="major">
                  <input type="text" name="major" value="${items.major}" />
                </div>
                <div class="year-learn row"><input name="startDate" class="col-4" value="${items.startDate}"/>    <input class="col-4" name="endDate" value="${items.endDate}"/></div>
                <div class="point">
                  GPA:
                  <input type="text" name="point" value="${items.point}"/>
                </div>
            </div>
              `;
            htmlEducationInfo.append(education);
          });

          //Skills
          let htmlSoftSkills = $(".soft-skill-info");
          let htmlProfessionalSkills = $(".professional-skill-info");
          data.skills.forEach((items) => {
            if (items.skillsTypeName == 0) {
              const professionallySkill = `
                   <input type="text" class="col-12" data-id="${items.skillsID}"   value="${items.skillsName} " />
                    `;
              htmlProfessionalSkills.append(professionallySkill);
            } else {
              const softSkill = `
                   <input type="text" class="col-12" data-id="${items.skillsID}" value="${items.skillsName} " />
                    `;
              htmlSoftSkills.append(softSkill);
            }
          });

          //Experience
          let htmlExperience = $(".experience-info-update");
          data.experience.forEach((item) => {
            const experience = `
                  <div class="experience-info" data-id="${item.experienceID} ">
                    <input type="text" name="companyName" value="${item.companyName}" class="company-name" />
                    <div>
                        <input type="text" name="jobTitle" class="job-title" value="${item.jobTitle}"/>
                        <div class="time-on-job "><input type="text"  name="fromDate" value="${item.fromDate}"/> - <input type="text"  name="toDate" value="${item.toDate}"/> </div>
                    </div> 
                  </div>   
            `;
            htmlExperience.append(experience);
          });

          //certificate
          let htmlCertificate = $(".certificate-info");
          data.certificate.forEach((items, index) => {
            const img = items.certificateImage
              ? items.certificateImage
              : "https://placehold.co/100";
            const certificateInfo = `
                    <div class="certificate-form row" data-id="${items.certificateID}">
                    <div class=""col-6>
                      <input type="text"  class="col-9" name="certificateName"  value="${items.certificateName}"/>
                      <input type="text" class="duration-custom col-3"  name="duration" value="${items.duration}" />
                    </div>
                    <div>
                      <div class="img-container">
                        <img
                        src="${img}"
                        class="common-img  h100 w100 img-cert_edit"
                        alt=""
                        />
                        <div class="icon-overlay">
                          <i class="fas fa-pen"></i>
                        </div>
                      </div>                    
                    </div>
                    </div>
                `;
            htmlCertificate.append(certificateInfo);
          });
          htmlCertificate.append(
            ` <input name="certificateImage" class="file_img-cert" type="file" hidden />`
          );
          //project
          let htmlProject = $(".project-info-custom");
          data.project.forEach((item) => {
            const projectInfo = `
              <div class='project-form row' data-id="${item.projectID}">
                <div class="time-on col-6 ">
                  <input type='text' name="jobTitle" class="job-title" value="${item.jobTitle}"/>
                  <div class="working-time row"><input type='text' name="fromDate" class="col-3" value="${item.fromDate}"/> - <input type='text'name="toDate"  class="col-3" value="${item.toDate}"/></div>
                </div>
                <div class="project-description mb-2 col-6">
                  <div class="project-title"><input type='text' name='projectName' value="${item.projectName}"/></div>
                  <div class="project-body" >${item.description}</div>
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
