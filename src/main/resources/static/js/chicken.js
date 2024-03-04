document.addEventListener("DOMContentLoaded", function() {
    const products = [
        { name: "Huhn in Soße", image: "mini_pic/chicken_in_souse.jpeg", article: "142700", price: 4.90  },
        { name: "Ganzes Huhn", image: "mini_pic/full_chicken.jpeg", article: "131670", price: 4.86  },
        { name: "Volle Hühnerpackung", image: "mini_pic/full_chicken_pack.jpeg", article: "131030", price: 4.79 }
    ];

    const productContainer = document.getElementById("product-container");

    products.forEach(product => {
        const productDiv = document.createElement("div");
        productDiv.classList.add("product");

        const image = document.createElement("img");
        image.src = product.image;
        image.alt = product.name;

        const productName = document.createElement("h2");
        productName.textContent = product.name;

        const article = document.createElement("p");
        article.textContent = "Article: " + product.article;

        const price = document.createElement("p");
        price.textContent = "Price: " + product.price + "€";

        productDiv.appendChild(image);
        productDiv.appendChild(productName);
        productDiv.appendChild(article);
        productDiv.appendChild(price);
        productContainer.appendChild(productDiv);
    });

    
    otherProducts.forEach(product => {
        const productLink = document.createElement("a");
        productLink.textContent = product.name;
        productLink.href = product.href;

        const br = document.createElement("br");

        productContainer.appendChild(productLink);
        productContainer.appendChild(br);
    });

    // Обработчики для кнопок
    document.getElementById("loginButton").addEventListener("click", function() {
        window.location.href = "/login";
    });

    document.getElementById("adminPanelButton").addEventListener("click", function() {
        window.location.href = "/admin";
    });
});
