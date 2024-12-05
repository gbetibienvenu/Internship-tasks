// /static/js/script.js

document.addEventListener("DOMContentLoaded", () => {
    console.log("Page loaded successfully!");

    const alertBox = document.querySelector(".alert");
    if (alertBox) {
        setTimeout(() => {
            alertBox.style.display = "none";
        }, 5000); // Hide alert after 5 seconds
    }
});
