// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
import { getAnalytics } from "firebase/analytics";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
    apiKey: "AIzaSyAPX0TbnPVdoZXouHc6qglr1SRfvrGmBk4",
    authDomain: "js-game---shadow-dog.firebaseapp.com",
    projectId: "js-game---shadow-dog",
    storageBucket: "js-game---shadow-dog.appspot.com",
    messagingSenderId: "49071355710",
    appId: "1:49071355710:web:4913481fe3640322fc5e6f",
    measurementId: "G-FPTD87XD9B"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
const analytics = getAnalytics(app);