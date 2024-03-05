document.addEventListener("DOMContentLoaded", function() {
    const products = [
        { name: "Hühnerkeule", image: "/teilen/foot.jpeg", article: "333100", price: 4.97},
        { name: "Hähnchenflügel", image: "/teilen/leaf.jpeg", article: "383090", price: 4.53},
        { name: "Hühnerbrust", image: "/teilen/boots.jpeg", article: "213100", price: 8.01 },
        { name: "Hühnerviertel", image: "/teilen/virtel.jpeg", article: "313060", price: 4.86},
        { name: "Hühnerrücken", image: "/teilen/hrbety.png", article: "273090", price: 4.40},
        { name: "Hähnchenschenkel", image: "/teilen/B.png", article: "343100", price: 4.97},
        { name: "Hähnchenschenkelkoteletts", image: "/teilen/c.png", article: "363090", price: 7.28}
    ];

    const productContainer = document.getElementById("teilen-container");

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