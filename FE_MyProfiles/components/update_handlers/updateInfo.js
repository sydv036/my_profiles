import {
  handleInput,
  callApiPost,
  handleImg,
  handleImgWithList,
} from "../../common/common.js";
import { DataRequest } from "../../common/DataRequest.js";
import { uploadImage } from "../../config/Upload-Image-Config.js";

var fileImg;
function updateInformation() {
  handleInput("name ", "name", "citizen-card", function (dataRequest) {
    callApiPost("/api/v1/admin/information", dataRequest);
  });
  handleInput("contact div", "contact", "citizen-card", function (dataRequest) {
    callApiPost("/api/v1/admin/information", dataRequest);
  });
  handleImg(
    "avartar .camera",
    "imgHandle",
    "avartar_update",
    async function (file) {
      const urlImg = await uploadImage(file);
      callApiPost(
        "/api/v1/admin/information",
        new DataRequest($("#citizenCard").val(), "image", urlImg)
      );
    }
  );
}

export { updateInformation };
