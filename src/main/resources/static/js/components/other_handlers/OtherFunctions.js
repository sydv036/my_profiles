import {
  callApiPost,
  handlerClickToggeleClass,
  renderCss,
} from "../../common/common.js";
import { DataRequest } from "../../common/DataRequest.js";

function handlerColor() {
  const colorPicker = new iro.ColorPicker("#color-picker", {
    width: 200,
    color: "#fff",
    borderWidth: 2,
  });
  let timeout;
  let i = 0;
  colorPicker.on("color:change", function (color) {
    clearTimeout(timeout);
    timeout = setTimeout(() => {
      const hexColor = color.hexString;
      callApiPost(
        "/api/v1/admin/updateSysParam",
        new DataRequest("COLOR", "value", hexColor)
      );
      $(".color-common").css("color", hexColor);
      i++;
    }, 1500);
  });

  handlerClickToggeleClass("btn-dropdown-color", "dropdown__body-color");
}

function handlerFontSize() {
  handlerClickToggeleClass(
    "btn-dropdown-font-size",
    "dropdown__body-font-size"
  );
  $(".font-size-custom").change(function (e) {
    callApiPost(
      "/api/v1/admin/updateSysParam",
      new DataRequest("FONT_SIZE", "value", $(this).val())
    );
    renderCss("font-size-common", "font-size", $(".font-size-custom").val());
    $(".range label b").text($(".font-size-custom").val() + "px");
  });
}

function handlerFontFamily() {
  $(document).on(
    "click",
    ".font-family-custom .content-body div",
    function (e) {
      const fontFamily = $(this).data("id");
      callApiPost(
        "/api/v1/admin/updateSysParam",
        new DataRequest("FONT_FAMILY", "value", fontFamily)
      );
      renderCss("main-profile", "font-family", fontFamily);
    }
  );
  setFontFamily();
}

function setFontFamily() {
  let defaultPage = 1;
  $(".next").click(function () {
    defaultPage++;
    defaultPage = setPageFontFamily(defaultPage);
  });
  $(".previus").click(function () {
    defaultPage--;
    defaultPage = setPageFontFamily(defaultPage);
  });
  setPageFontFamily(defaultPage);
}

function setPageFontFamily(page) {
  if (page === null || page === "" || page === undefined) {
    page = 1;
  }
  const fontFamilies = [
    "Arial, sans-serif",
    "Verdana, sans-serif",
    "Helvetica, sans-serif",
    "Tahoma, sans-serif",
    "Trebuchet MS, sans-serif",
    "Times New Roman, serif",
    "Georgia, serif",
    "Garamond, serif",
    "Courier New, monospace",
    "Lucida Console, monospace",
    "Roboto, sans-serif",
    "Open Sans, sans-serif",
    "Lato, sans-serif",
    "Montserrat, sans-serif",
    "Oswald, sans-serif",
    "Poppins, sans-serif",
    "Raleway, sans-serif",
    "Ubuntu, sans-serif",
    "Merriweather, serif",
    "Playfair Display, serif",
    "Nunito, sans-serif",
    "Quicksand, sans-serif",
    "Fira Sans, sans-serif",
    "Muli, sans-serif",
    "PT Sans, sans-serif",
    "Source Sans Pro, sans-serif",
    "Alegreya, serif",
    "Bitter, serif",
    "Crimson Text, serif",
    "Spectral, serif",
    "Inconsolata, monospace",
    "Space Mono, monospace",
    "Pacifico, cursive",
    "Lobster, cursive",
    "Dancing Script, cursive",
    "Great Vibes, cursive",
    "Satisfy, cursive",
    "Sacramento, cursive",
    "Cookie, cursive",
    "Amatic SC, cursive",
    "Shadows Into Light, cursive",
    "Indie Flower, cursive",
  ];
  const pageSize = 5;
  const lengthArray = fontFamilies.length;
  const totalPage = Math.ceil(lengthArray / pageSize);
  if (page > totalPage) {
    page = 1;
  }
  if (page < 1) {
    page = totalPage;
  }
  const startIndex = (page - 1) * pageSize;
  const endIndex = Math.min(page * pageSize, lengthArray);
  $(".font-family-custom .content-body").html("");
  for (let i = startIndex; i < endIndex; i++) {
    const font = fontFamilies[i];
    const fontFamilyName = font.split(",")[0];
    $(".font-family-custom .content-body").append(`
        <div class="" name="FONT_FAMILY" style="font-family: ${font}" data-id="${font}">
          ${fontFamilyName}
        </div>
      `);
  }
  return page;
}

export { handlerColor, handlerFontSize, handlerFontFamily };
