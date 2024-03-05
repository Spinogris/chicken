document.addEventListener("DOMContentLoaded", function() {
    const products = [
        { name: "DIE INDISCHE PAN 560 g", image: "/semifinished/1.png", article: "534060", price: 5.05, priceKg: 9.01},
        { name: "ITALIENISCHE PAN 560 g", image: "/semifinished/2.png", article: "535060", price: 5.05, priceKg:  9.01},
        { name: "LEBER IN EINER PFANNE MIT BASILIKUM 500g", image: "/semifinished/3.png", article: "539360", price: 2.34, priceKg: 4.68 },
        { name: "H.a Sp.Steh.Mar.DUO Arg+Braz bez E VAC ~1600g", image: "/semifinished/4.png", article: "553850", price: 6.88, priceKg: 11 },
        { name: "H.a Sp.Steh. Mar.DUO Gur.+Roz. bez E VAC ~1600g", image: "/semifinished/5.png", article: "553880", price: 6.88, priceKg: 11 },
        { name: "HÜHNCHEN AUF EINER ROLLE ~900g", image: "/semifinished/6.png", article: "560060", price: 5.88, priceKg: 6.53 },
        { name: "HÜHNERSPIEß MIT SPECK ~720 g", image: "/semifinished/7.png", article: "564000", price: 5.23, priceKg: 7.26 },
        { name: "HÜHNERSPIEß MIT WURST ~720 g", image: "/semifinished/8.png", article: "565000", price: 5.15, priceKg: 7.15 }
    ];

    const productContainer = document.getElementById("semifinished-container");

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

        const priceKg = document.createElement("p");
        priceKg.textContent = "Price/kg: " + product.priceKg + "€";

        productDiv.appendChild(image);
        productDiv.appendChild(productName);
        productDiv.appendChild(article);
        productDiv.appendChild(price);
        productDiv.appendChild(priceKg);
        productContainer.appendChild(productDiv);
    });
});
