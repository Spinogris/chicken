document.addEventListener("DOMContentLoaded", function() {
    const products = [
        { name: "SCHINKENWÜRSTE", image: "/wurst/1.png", article: "640060", price: 6.42},
        { name: "WÜRSTE MIT KÄSE", image: "/wurst/2.png", article: "645060", price: 6.13  },
        { name: "COCKTAILWURST", image: "/wurst/3.png", article: "632060", price: 4.60 },
        { name: "DEBRECÍN-WURST", image: "/wurst/4.png", article: "633760", price: 5.48 },
        { name: "LIB-WURST", image: "/wurst/5.png", article: "634060", price: 4.24 },
        { name: "LAUTSPRECHER", image: "/wurst/6.png", article: "635860", price: 4.24 },
        { name: "Ahornwurst", image: "/wurst/7.png", article: "637900", price: 4.24 },
        { name: "WURST MIT KÄSE", image: "/wurst/8.png", article: "638060", price: 4.82 },
        { name: "KINDERWURST", image: "/wurst/9.png", article: "639860", price: 5.95 },
        { name: "HÜHNERHUFFEISEN 450g", image: "/wurst/10.png", article: "649740", price: 2.01 },
        { name: "SALAMI JUNIOR 1.5kg", image: "/wurst/11.png", article: "651070", price: 6.31 },
        { name: "SPA-SALAMI 1.5kg", image: "/wurst/12.png", article: "652070", price: 6.19 },
        { name: "GOTHAI-SALAM 400g", image: "/wurst/13.png", article: "657400", price: 2.05 },
        { name: "SCHINKEN-SALAMI 2kg", image: "/wurst/14.png", article: "659170", price: 6.36 },
        { name: "SCHINKEN-SALAMI 400 g", image: "/wurst/15.png", article: "659410", price: 2.31 }
    ];

    const productContainer = document.getElementById("wurst-container");

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
