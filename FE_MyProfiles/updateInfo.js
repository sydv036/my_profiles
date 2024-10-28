var fileImg;
$(".image-update").click(() => {
  $("#imgHandle").click();
});
$("#imgHandle").change(function (event) {
  const file = this.files[0];
  $(".image-update").attr("src", URL.createObjectURL(file));
  fileImg = file;
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
export { readAccountRequest };
