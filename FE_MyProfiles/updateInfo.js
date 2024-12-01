import { handleInput, callApiPost } from "./common.js";

var fileImg;
$(".image-update").click(() => {
  $("#imgHandle").click();
});
$("#imgHandle").change(function (event) {
  const file = this.files[0];
  if (file) {
    $(".image-update").attr("src", URL.createObjectURL(file));
    fileImg = file;
  }
});

function updateInformation() {
  handleInput("name ", "name", "citizen-card", function (dataRequest) {
    callApiPost("/api/v1/admin/information", dataRequest);
  });
  handleInput("contact div", "contact", "citizen-card", function (dataRequest) {
    callApiPost("/api/v1/admin/information", dataRequest);
  });
}

export { updateInformation };
