function renderCertificateUpdate(data) {
  let htmlCertificate = $(".certificate_info");
  htmlCertificate.html("");
  data.forEach((items, index) => {
    const img = items.certificateImage
        ? items.certificateImage
        : "https://placehold.co/100";
    const certificateInfo = `
    <div class="certificate_form form_delete " data-id="${items.certificateID}">
        <div class="certificate_basic">
            <input type="text"  class="" name="certificateName"  value="${items.certificateName}"/>
            <input type="text" class="duration-custom"  name="duration" value="${items.duration}" />
        </div>
        <div clas="">
            <div class="img-container image-cert-wrapper">
                <img
                src="${img}"
                class="common-img h50 w50 img-cert_edit"
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
}
export { renderCertificateUpdate };
