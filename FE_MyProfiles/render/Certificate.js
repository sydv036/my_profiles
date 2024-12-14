function renderCertificate(data) {
  let htmlCertificate = $(".certificate-info");
  data.certificate.forEach((items, index) => {
    const certificateInfo = `
            <div>
              <b class="show-more showImgCertificate" data-id="${items.certificateID}">${items.certificateName}</b>
              <p>${items.duration}</p>
            </div>
        `;
    htmlCertificate.append(certificateInfo);
  });
}
export { renderCertificate };
