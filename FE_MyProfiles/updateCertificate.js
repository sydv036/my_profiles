import {
  callApiPost,
  create,
  handleImg,
  handleImgWithList,
  handleInput,
  handleObjectFormDataImg,
} from "./common.js";
import { DataRequest } from "./DataRequest.js";
import { uploadImage } from "./imageUpload.js";

function updateCertificate() {
  handleObjectFormDataImg(
    "chosse-file-certificate",
    "file-cert-new",
    "fill-img-select",
    "createCert",
    "formDataCert",
    "certificateImage",
    function (data) {
      callApiPost("/api/v1/admin/createCert", data);
    }
  );

  handleInput("certificate-form ", "certificate-form", "id", function (data) {
    callApiPost("/api/v1/admin/updateCert", data);
  });

  handleImgWithList(
    "img-container",
    "file_img-cert",
    "certificate-form",
    "id",
    async function (file, idCert, attrName) {
      if (!file) {
        return;
      }
      let urlImg = await uploadImage(file);
      let data = new DataRequest(idCert, attrName, urlImg);
      callApiPost("/api/v1/admin/updateCert", data);
    }
  );
}

export { updateCertificate };
