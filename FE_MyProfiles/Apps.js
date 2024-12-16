import { getProfile } from "./common/API_GetProfiles.js";
import { renderBasicInfo } from "./render/BasicInfo.js";
import { renderCareeGoal } from "./render/CareerGoals.js";
import { renderCertificate } from "./render/Certificate.js";
import { renderEducation } from "./render/Education.js";
import { renderExperiences } from "./render/Experience.js";
import { renderProject } from "./render/Project.js";
import { renderSkills } from "./render/Skills.js";
$(() => {
  getProfile(function (data) {
    if (data === null) {
      return;
    }
    handleShowImg("showImgEducation", "education", data);
    handleShowImg("showImgCertificate", "certificate", data);
    renderBasicInfo(data);
    renderCareeGoal(data);
    renderEducation(data);
    renderSkills(data);
    renderExperiences(data);
    renderCertificate(data);
    renderProject(data);
  });
  function handleShowImg(eventClass, eventType, dataResponse) {
    $(document).on("click", "." + eventClass, function () {
      const id = $(this).data("id");
      $(".image-show").css("display", "none");
      let imgName;
      if (eventType === "certificate") {
        imgName = dataResponse.certificate.find((items) => {
          return items.certificateID == id;
        })?.certificateImage;
      } else if (eventType === "education") {
        imgName = dataResponse.education.find((items) => {
          return items.educationID == id;
        })?.transcript;
      }
      imgName = imgName ? imgName : "https://placehold.co/700X500";
      $(".image-show").slideDown("slow");
      $(".image-show_image").attr("src", imgName);
    });
  }

  $(document).on("click", ".image-show_btn-cancel", function () {
    // $(".image-show").css("transition", "1s ease-in-out");
    $(".image-show").css("display", "none");
  });
  $(document).on("click", ".image-show_btn-download", function () {
    const url = $(this)
      .parent(".more-function")
      .parent(".image-show")
      .find("img")
      .attr("src");
    if (!url) {
      return;
    }
    console.log(url);
    fetch("http://localhost:8081/api/v1/admin/download/img?url=" + url, {
      method: "GET",
      headers: {
        "Content-Type": "application/json", // Định dạng dữ liệu gửi đi là JSON
      },
    }).then((respense) => {
      console.log(respense);
    });
  });
});
