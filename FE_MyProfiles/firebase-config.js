// Import the functions you need from the SDKs you need
import { initializeApp } from "https://www.gstatic.com/firebasejs/11.0.1/firebase-app.js";
import { getStorage } from "https://www.gstatic.com/firebasejs/11.0.1/firebase-storage.js";

// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
  apiKey: "AIzaSyCChmLqR9rKEFq8701DmP1tIdZbV9edtrk",
  authDomain: "my-profiles-c2713.firebaseapp.com",
  projectId: "my-profiles-c2713",
  storageBucket: "my-profiles-c2713.appspot.com",
  messagingSenderId: "578565492167",
  appId: "1:578565492167:web:6fea98f3090b332689dde2",
  measurementId: "G-4MCEP4SE7C",
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
const storage = getStorage(app);
export { storage };
