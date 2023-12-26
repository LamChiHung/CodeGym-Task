// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
import { getAnalytics } from "firebase/analytics";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
    apiKey: "AIzaSyCphTkylxvgUHPBy4atrPgLxRPoMZXO-Dk",
    authDomain: "the-band-html-css.firebaseapp.com",
    projectId: "the-band-html-css",
    storageBucket: "the-band-html-css.appspot.com",
    messagingSenderId: "625253187689",
    appId: "1:625253187689:web:add536fbabb62dd47b62f8",
    measurementId: "G-8V9195BL49"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
const analytics = getAnalytics(app);