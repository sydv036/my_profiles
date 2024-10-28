function create(classClick, classAdd, value) {
  $(document).on("click", "." + classClick, function () {
    $("." + classAdd).append(value);
  });
}
export { create };
