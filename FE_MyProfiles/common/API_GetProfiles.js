const API = "http://localhost:8081";
function getProfile(callback) {
  $.ajax({
    url: API + "/api/v1/profile",
    type: "GET",
    dataType: "json",
    success: function (response) {
      if (response.statusCode === 200) {
        callback(response.data);
        return;
      }
      console.log("Data couldn't get in Server");
      console.log("Error: ", response.message);
    },
    error: function (error) {
      console.log("Error: " + error);
    },
  });
}
export { getProfile };
