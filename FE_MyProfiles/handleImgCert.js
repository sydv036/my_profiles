// function handleAddImgCert() {
//   let files;
//   $("#handaleAddImgCertificate").click(function () {
//     $("#inputAddImgCertificate").click();
//   });
//   $("#inputAddImgCertificate").change(function () {
//     let file = $(this)[0].files[0];
//     let fileType = file.type.split("/")[0];
//     if (fileType != "image") {
//       alert("Không phải là ảnh!");
//       return;
//     }
//     files = file;
//     let url = URL.createObjectURL(file);
//     $(".img-add-certificate").attr("src", url);
//     console.log("file", files);
//   });

//   return files;
// }
function handleAddImgCert() {
  return new Promise((resolve, reject) => {
    $("#handaleAddImgCertificate").click(function () {
      $("#inputAddImgCertificate").click();
    });

    $("#inputAddImgCertificate").change(function () {
      let file = $(this)[0].files[0];
      if (!file) {
        reject("Không có file nào được chọn");
        return;
      }

      let fileType = file.type.split("/")[0];
      if (fileType !== "image") {
        alert("Không phải là ảnh!");
        reject("Không phải là ảnh!");
        return;
      }
      let url = URL.createObjectURL(file);
      $(".img-add-certificate").attr("src", url);
      // Chỉ trả về file mà không cần hiển thị gì
      resolve(file);
    });
  });
}

export { handleAddImgCert };
