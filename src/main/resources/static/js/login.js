// Открытие и закрытие окна логирования
function openLogin() {
    document.getElementById("loginContainer").style.display = "block";
}

function closeLogin() {
    document.getElementById("loginContainer").style.display = "none";
}

// Открытие и закрытие окна регистрации
function showRegistration() {
    closeLogin();
    document.getElementById("registrationContainer").style.display = "block";
}

function closeRegistration() {
    document.getElementById("registrationContainer").style.display = "none";
}

// Обработка отправки формы логина
document.getElementById("loginForm").addEventListener("submit", function(event) {
    event.preventDefault();
    // Ваш код для отправки данных на сервер и обработки ответа
});

// Обработка отправки формы регистрации
document.getElementById("registrationForm").addEventListener("submit", function(event) {
    event.preventDefault();
    // Ваш код для отправки данных на сервер и обработки ответа
});
