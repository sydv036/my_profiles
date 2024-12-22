import { callApiPost } from "./common.js";
import { DataRequest } from "./DataRequest.js";

$(() => {
  let quill;
  let idProject = null;
  $(document).on("click", ".project_body", function () {
    idProject = $(this).closest(".project_info").data("id");
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
  });

  $(document).on("click", ".btn-prj-description", function () {
    let description = quill.root.innerHTML;
    callApiPost(
      "/api/v1/admin/updateProject",
      new DataRequest(idProject, "description", description)
    );
  });
});
