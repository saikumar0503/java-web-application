// Example: Displaying a pop-up alert when the page is loaded
document.addEventListener("DOMContentLoaded", function () {
    alert("Welcome to XYZ Institute!");
});

// Example: Adding functionality to the 'About Us' link
document.querySelector("nav a[href='hello']").addEventListener("click", function (event) {
    event.preventDefault(); // Prevent the default link behavior
    alert("This is the 'About Us' section. Content coming soon!");
});
