document.addEventListener("DOMContentLoaded", function() {
    const products = [
        { name: "Hühnerherzen", image: "/innereien/heart.jpeg", article: "142700", price: 4.90  },
        { name: "Hühnerhals", image: "/innereien/neck.jpeg", article: "131670", price: 4.86  },
        { name: "Hühnerleber", image: "/innereien/pechen.jpeg", article: "131030", price: 4.79 }
    ];

    const productContainer = document.getElementById("innereien-container");

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
});
