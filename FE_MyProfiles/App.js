function printPDF() {
  const { jsPDF } = window.jspdf;
  const doc = new jsPDF();

  doc
    .html(document.getElementById("main-profile"), {
      callback: function (doc) {
        doc.save("profile.pdf");
      },
      x: 15,
      y: 15,
    })
    .then(() => {
      doc.save("profile.pdf");
    });
}
