document.addEventListener("DOMContentLoaded", function() {
    const products = [
        { name: "Chicken in souse", image: "mini_pic/chicken_in_souse.jpeg", article: "142700", price: 4.90  },
        { name: "chicken voll", image: "mini_pic/full_chicken.jpeg", article: "131670", price: 4.86  },
        { name: "Full chicken pack", image: "mini_pic/full_chicken_pack.jpeg", article: "131030", price: 4.79 },
        { name: "Vile", image: "mini_pic/boots.jpeg", article: "213100", price: 8.01 },
        { name: "chicken virtel", image: "mini_pic/virtel.jpeg", article: "313060", price: 4.86 },
        { name: "foot", image: "mini_pic/foot.jpeg", article: "333100", price: 4.97},
        { name: "leaf", image: "mini_pic/leaf.jpeg", article: "383090", price: 4.53},
        { name: "neck", image: "mini_pic/neck.jpeg", article: "453090", price: 3.52},
        { name: "pechen", image: "mini_pic/pechen.jpeg", article: "413090", price: 4.24},
        { name: "heart", image: "mini_pic/heart.jpeg", article: "423090", price: 4.60}
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
    // Обработчики для кнопок
    document.getElementById("loginButton").addEventListener("click", function() {
        window.location.href = "/login";
    });

    document.getElementById("adminPanelButton").addEventListener("click", function() {
        window.location.href = "/admin";
    });
});
