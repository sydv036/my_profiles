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
function readAccountRequest() {
  let accountRequest = {};

  $(".name input")
    .serializeArray()
    .forEach((item) => {
      accountRequest[item.name] = item.value;
    });
  $(".contact input")
    .serializeArray()
    .forEach(function (item) {
      accountRequest[item.name] = item.value;
    });
  accountRequest["image"] = "123";
  return accountRequest;
}

function updateInformation() {
  handleInput(".name input", ".name", "citizen-card", function (dataRequest) {
    callApiPost("/api/v1/admin/information", dataRequest);
  });
  handleInput(
    ".contact input",
    ".contact",
    "citizen-card",
    function (dataRequest) {
      callApiPost("/api/v1/admin/information", dataRequest);
    }
  );
}

export { readAccountRequest, updateInformation };
