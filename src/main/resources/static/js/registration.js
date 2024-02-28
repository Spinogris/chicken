function validateForm() {
    // Получаем значения полей формы
    var firstName = document.getElementById("firstName").value;
    var lastName = document.getElementById("lastName").value;
    var email = document.getElementById("email").value;
    var phoneNumber = document.getElementById("phoneNumber").value;
    var city = document.getElementById("city").value;
    var password = document.getElementById("password").value;

    // Проверяем, что все поля заполнены
    if (firstName == "" || lastName == "" || email == "" || phoneNumber == "" || city == "") {
        alert("Please fill in all fields");
        return false;
    }

    // Проверяем формат номера телефона
    var phoneNumberPattern = /^[0-9]{3}-[0-9]{2}-[0-9]{3}$/;
    if (!phoneNumberPattern.test(phoneNumber)) {
        alert("Please enter a valid phone number (format: XXX-XX-XXX)");
        return false;
    }

    // Проверяем формат email
    var emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailPattern.test(email)) {
        alert("Please enter a valid email address");
        return false;
    }

    // Если форма валидна, можно отправить данные на сервер
    // Например, с помощью AJAX или другого метода

    return true;
}
