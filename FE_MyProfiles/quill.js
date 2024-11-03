$(() => {
  let quill;
  $(document).on("click", ".project-body", function () {
    if (quill) {
      quill = null;
      $(".modal-body-certificate").html("");
      $(".modal-body-certificate").html(`<div id="quill-custom"></div>`);
    }
    $("#quillModal").modal("show");
    quill = new Quill("#quill-custom", {
      modules: {
        toolbar: [
          [{ header: [1, 2, false] }],
          ["bold", "italic", "underline", "strike"],
          ["code-block"],
          [{ color: [] }],
          [{ size: ["small", false, "large", "huge"] }],
          ["font"],
          ["align", "direction"], // Thêm các tùy chọn giãn dòng và hướng văn bản
          [{ list: "ordered" }, { list: "bullet" }],
          ["link", "image", "video"],
          ["clean"],
        ],
      },
      placeholder: "Thông tin dự án cá nhân......",
      theme: "snow",
    });
    quill.clipboard.dangerouslyPasteHTML($(this).html());
    console.log($(this).html());
  });
  $(document).on("click", ".add-project-info", function () {
    console.log(quill.root.innerHTML);
  });
});
