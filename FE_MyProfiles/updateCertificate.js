import { handleAddImgCert } from "./handleImgCert.js";
function readCertificate() {
  let id = $(".cert-name-add").data("img");
  console.log("cert:", id);
}
function createCertificate() {
  let file = handleAddImgCert();
  $(".add-cert").click(() => {
    let name = $("#certificateName").val();
    let duration = $("#certificateDuration").val();
    let htmlCertificate = `
        <div class="certificate-form row">
            <b class="col-9 cert-name-add" data-img="${file}"  >${name}</b>
            <p class="duration-custom col-3" >${duration} </p>
        </div>
    `;
    $(".certificate-info").append(htmlCertificate);
    console.log(file);

    $(".close-modal").click();
  });
}
export { readCertificate, createCertificate };
