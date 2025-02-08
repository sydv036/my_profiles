import {callApiGet, handlerClick, renderCss} from "./common/common.js";
import {renderBasicInfo} from "./components/renders/BasicInfo.js";
import {renderCareeGoal} from "./components/renders/CareerGoals.js";
import {renderCertificate} from "./components/renders/Certificate.js";
import {renderEducation} from "./components/renders/Education.js";
import {renderExperiences} from "./components/renders/Experience.js";
import {renderProject} from "./components/renders/Project.js";
import {renderSkills} from "./components/renders/Skills.js";
import renderSortable from "./components/renders/Sortable.js";

async function fetchData(endPoint) {
    const data = await callApiGet(endPoint);
    return data;
}

$(async () => {
    try {
        const [
            sortable,
            dataBasicInfo,
            dataTarget,
            dataEdu,
            dataSkill,
            dataExp,
            dataPro,
            dataCert,
        ] = await Promise.all([
            fetchData("/api/v1/personal/sortable"),
            fetchData("/api/v1/personal/basic-info"),
            fetchData("/api/v1/personal/target"),
            fetchData("/api/v1/personal/education"),
            fetchData("/api/v1/personal/skill"),
            fetchData("/api/v1/personal/experiences"),
            fetchData("/api/v1/personal/project"),
            fetchData("/api/v1/personal/certificate"),
        ]);
        renderSortable(sortable);
        renderBasicInfo(dataBasicInfo);
        renderCareeGoal(dataTarget);
        renderEducation(dataEdu);
        renderSkills(dataSkill);
        renderExperiences(dataExp);
        renderProject(dataPro);
        renderCertificate(dataCert);
        handleShowImg("showImgEducation", "education", dataEdu);
        handleShowImg("showImgCertificate", "certificate", dataCert);
        renderCss("color-common", "color", dataBasicInfo.color);
        renderCss("font-size-common", "font-size", dataBasicInfo.fontSize);
        renderCss("main-profile", "font-family", dataBasicInfo.fontFamily);
    } catch (error) {
        console.log(error);
    }

    function handleShowImg(eventClass, eventType, dataResponse) {
        $(document).on("click", "." + eventClass, function () {
            const id = $(this).data("id");
            $(".image-show").css("display", "none");
            let imgName;
            if (eventType === "certificate") {
                imgName = dataResponse.find((items) => {
                    return items.certificateID == id;
                })?.certificateImage;
            } else if (eventType === "education") {
                imgName = dataResponse.find((items) => {
                    return items.educationID == id;
                })?.transcript;
            }
            imgName = imgName ? imgName : "https://placehold.co/700X500";
            $(".image-show").slideDown("slow");
            $(".image-show_image").attr("src", imgName);
        });
    }

    handlerClick("image-show_btn-cancel", function (e) {
        renderCss("image-show", "display", "none");
    });

    //download images
    $(document).on("click", ".image-show_btn-download", function () {
        const url = $(this)
            .parent(".more-function")
            .parent(".image-show")
            .find("img")
            .attr("src");
        if (!url) {
            return;
        }
        fetch("/api/v1/admin/download/img" , {
            method: "POST",
            headers: {
                "Content-Type": "application/json", // Định dạng dữ liệu gửi đi là JSON
            },
            body: JSON.stringify(url)
        }).then((respense) => {
            console.log(respense);
        });
    });
});
