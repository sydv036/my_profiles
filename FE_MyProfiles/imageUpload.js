import { storage } from "./firebase-config.js";
import {
  getStorage,
  ref,
  uploadBytes,
  getDownloadURL,
} from "https://www.gstatic.com/firebasejs/11.0.1/firebase-storage.js";

// C1: su dụng callback
// function uploadImage(fileImg, callback) {
//   const file = fileImg;

//   if (!file) {
//     alert("Không có file được chọn!");
//     return;
//   }
//   const fileType = file.type.split("/")[0];
//   if (fileType !== "image") {
//     alert("Không phải ảnh!");
//     return;
//   }
//   const storageRef = ref(storage, `images/${file.name}`);
//   uploadBytes(storageRef, file)
//     .then(() => {
//       return getDownloadURL(storageRef);
//     })
//     .then((url) => {
//       console.log("url img:", url);
//       callback(url, null);
//     })
//     .catch((error) => {
//       alert("Không thể tải ảnh! Vui lòng thử lại!");
//     });
// }
// export { uploadImage };

// C2 sử dụng đới tượng bất đồng bộ Promise
function uploadImage(fileImg) {
  return new Promise((resolve, reject) => {
    const file = fileImg;

    if (!file) {
      alert("Không có file được chọn!");
      reject("Không có file");
      return;
    }

    const fileType = file.type.split("/")[0];
    if (fileType !== "image") {
      alert("Không phải ảnh!");
      reject("Không phải ảnh");
      return;
    }

    const storageRef = ref(storage, `images/${file.name}`);
    uploadBytes(storageRef, file)
      .then(() => {
        return getDownloadURL(storageRef);
      })
      .then((url) => {
        console.log("url img:", url);
        resolve(url);
      })
      .catch((error) => {
        alert("Không thể tải ảnh! Vui lòng thử lại!");
        reject(error);
      });
  });
}

export { uploadImage };
