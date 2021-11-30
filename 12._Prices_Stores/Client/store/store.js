const queryString = window.location.search;
const urlParams = new URLSearchParams(queryString);
const id = parseInt(urlParams.get('storeId'));

const pricesDiv = document.getElementById("prices-display-case");


fetch("http://localhost:8080/stores/" + store)
    .then(response => response.json())
    .then(store => {
            console.log(store);
            store.prices.map(displayPrice);
        }
    )

function displayPrice(price) {
    const priceTagParagraph = document.createElement("p");
    priceTagParagraph.id = price.id;
    priceTagParagraph.classList.add("price");

    priceTagParagraph.innerText = price.price;
    priceTagParagraph.style.fontSize = price.size;
    priceTagParagraph.style.color = price.color;

    priceTagParagraph.style.position = "absolute";
    priceTagParagraph.style.top = randomInt(0, 100) + "%";
    priceTagParagraph.style.left = randomInt(0, 100) + "%";

    priceTagParagraph.style.backgroundColor = "#" + randomHex();
    priceTagParagraph.style.borderRadius = "50%";
    priceTagParagraph.style.padding = "5px";

    pricesDiv.append(priceTagParagraph);
}


function createPrice() {
    const price = {
        price: randomFloat(4.95, 99.95, 2),
        size: randomInt(1, 32) + "px",
        color: "#" + randomHex()
    }
    savePrice(price);
}


function savePrice(price) {
    fetch("http://localhost:8080/prices/" + store, {
        method: "POST",
        headers: {
            "Content-type": "application/json; charset=UTF-8"
        },
        body: JSON.stringify(price)
    })
        .then(response => response.json())
        .then(price => {
            displayPrice(price.price);
        })
}

function deletePrice(priceId) {
    fetch("http://localhost:8080/prices/" + priceId, {
        method: "DELETE",
        headers: {
            "Content-type": "application/json; charset=UTF-8"
        },
    })
        .then()
}

function randomInt(min, max) { //max and min inclusive
    return Math.floor(Math.random() * (max - min + 1) + min);
}

function randomFloat(min, max, fixed) {
    let float = Math.random() * (max - min + 1) + min;
    return float.toFixed(fixed);
}

function randomHex() {
    return Math.floor(Math.random() * 16777215).toString(16);
}

document.addEventListener("click", (event) => {
    if (event.ctrlKey || event.metaKey) {
        if (event.target.classList.contains("price")) {
            event.target.remove();
            deletePrice(event.target.id);
        }
    } else {
        createPrice();
    }
});