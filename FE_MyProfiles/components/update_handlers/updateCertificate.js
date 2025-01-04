import {
  callApiPost,
  create,
  handleDeleteObj,
  handleImg,
  handleImgWithList,
  handleInput,
  handleObjectFormDataImg,
} from "../../common/common.js";
import { DataRequest } from "../../common/DataRequest.js";
import { uploadImage } from "../../config/Upload-Image-Config.js";
import { renderCertificateUpdate } from "../update-renders/Certificate_Update.js";

function updateCertificate() {
  const urlGet = "/api/v1/personal/certificate";
  const functionRender = renderCertificateUpdate;
  handleObjectFormDataImg(
    "chosse-file-certificate",
    "file-cert-new",
    "fill-img-select",
    "createCert",
    "formDataCert",
    "certificateImage",
    function (data) {
      callApiPost("/api/v1/admin/createCert", data, urlGet, functionRender);
    }
  );

  handleInput("certificate_form ", "certificate_form", "id", function (data) {
    callApiPost("/api/v1/admin/updateCert", data, urlGet, functionRender);
  });

  handleImgWithList(
    "image-cert-wrapper",
    "file_img-cert",
    "certificate_form",
    "id",
    async function (file, idCert, attrName) {
      if (!file) {
        return;
      }
      let urlImg = await uploadImage(file);
      let data = new DataRequest(idCert, attrName, urlImg);
      callApiPost("/api/v1/admin/updateCert", data, urlGet, functionRender);
    }
  );
  handleDeleteObj(
    "/api/v1/admin/deleteCertificate",
    false,
    "certificate_form",
    urlGet,
    functionRender
  );
}

export { updateCertificate };
