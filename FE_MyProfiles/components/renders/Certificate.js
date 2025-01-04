function renderCertificate(data) {
  if (data === null || data.length === 0) {
    return;
  }
  renderCertificateTitle();
  let htmlCertificate = $(".certificate_info");
  data.forEach((items, index) => {
    const certificateInfo = `
            <div>
              <b class="text-hover showImgCertificate" data-id="${items.certificateID}">${items.certificateName}</b>
              <p>${items.duration}</p>
            </div>
        `;
    htmlCertificate.append(certificateInfo);
  });
}
function renderCertificateTitle() {
  const title = $(".certificate");
  title.append(`
    <div class="certificate_title text-uppercase border-bottom margin-bottom  color-common font-size-common">
      Certificate
    </div>
    <div class="certificate_info pt-1 padding-custom"></div>
  `);
}
export { renderCertificate };
