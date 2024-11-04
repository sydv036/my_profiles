import { handleAddImgCert } from "./handleImgCert.js";
import { create } from "./common.js";
function readCertificate() {
  let id = $(".cert-name-add").data("img");
  console.log("cert:", id);
}
// function createCertificate() {
//   let file = handleAddImgCert();
//   $(".add-cert").click(() => {
//     let name = $("#certificateName").val();
//     let duration = $("#certificateDuration").val();
//     let htmlCertificate = `
//         <div class="certificate-form row">
//             <b class="col-9 cert-name-add" data-img="${file}"  >${name}</b>
//             <p class="duration-custom col-3" >${duration} </p>
//         </div>
//     `;
//     $(".certificate-info").append(htmlCertificate);
//     console.log(file);

//     $(".close-modal").click();
//   });
// }
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
export { readCertificate, createCertificate };
