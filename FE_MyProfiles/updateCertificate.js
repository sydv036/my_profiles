import {
  callApiPost,
  create,
  handleImg,
  handleInput,
  handleObjectFormDataImg,
} from "./common.js";
import { uploadImage } from "./imageUpload.js";
function readCertificate() {
  let id = $(".cert-name-add").data("img");
  console.log("cert:", id);
}

function createCertificate() {
  create(
    "icon-add-certificate",
    "certificate-info",
    `
       <div class="certificate-form row">
            <input class="col-9 cert-name-add" value="Certificate Name" />
            <input class="duration-custom col-3" value="11-2024" />
        </div>
    `
  );
}

let fileImg;
handleImg(
  "chosse-file-certificate",
  "file-cert-new",
  "fill-img-select",
  function (file) {
    fileImg = file;
  }
);

function updateCertificate() {
  handleObjectFormDataImg("createCert", "formDataCert", fileImg);

  // $(".createCert").click(async function () {
  //   let obj = {};
  //   let selectInput = $(".formDataCert");

  //   // Duyệt qua các input và lấy giá trị
  //   selectInput.find("input[name]").each(function () {
  //     const name = $(this).attr("name");
  //     const value = $(this).val();
  //     obj[name] = value;
  //   });

  //   try {
  //     const img = await uploadImage(fileImg);
  //     obj["certificateImage"] = img;
  //     console.log(obj);
  //     console.log(JSON.stringify(obj));

  //     callApiPost("/api/v1/admin/createCert", obj);
  //   } catch (error) {
  //     console.error("Lỗi trong quá trình upload ảnh:", error);
  //   }
  // });

  handleInput(
    ".certificate-form input",
    ".certificate-form",
    "id",
    function (data) {
      callApiPost("/api/v1/admin/updateCert", data);
    }
  );
}
export { readCertificate, createCertificate, updateCertificate };
