import { storage } from "./firebase-config.js";
import {
  getStorage,
  ref,
  uploadBytes,
  getDownloadURL,
} from "https://www.gstatic.com/firebasejs/11.0.1/firebase-storage.js";

function uploadImage(fileImg) {
  const file = fileImg;

  if (!file) {
    alert("Không có file được chọn!");
    return;
  }
  const fileType = file.type.split("/")[0];
  if (fileType !== "image") {
    alert("Không phải ảnh!");
    return;
  }
  const storageRef = ref(storage, `images/${file.name}`);
  uploadBytes(storageRef, file)
    .then(() => {
      return getDownloadURL(storageRef);
    })
    .then((url) => {
      console.log("url img:", url);
      return url;
    })
    .catch((error) => {
      alert("Không thể tải ảnh! Vui lòng thử lại!");
    });
}
export { uploadImage };
