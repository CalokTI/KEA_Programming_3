getKanyeQuote();

let kanyeQuote;

function getKanyeQuote() {
    fetch("https://api.kanye.rest/")
        .then(response => response.json())
        .then(result => {
            document.getElementById('kanye-quote').innerText = result.quote;
            kanyeQuote = result.quote;
        });
}

function addQuote(reactionList) {
    const paragraph = document.createElement("p");
    paragraph.innerText = kanyeQuote;
    document.getElementById(reactionList).appendChild(paragraph);
}

//EVENT LISTENER
document.getElementById('btn-laugh').addEventListener("click", () => addQuote('list-laugh'))
document.getElementById('btn-wtf').addEventListener("click", () => addQuote('list-wtf'))
document.getElementById('btn-horny').addEventListener("click", () => addQuote('list-horny'))


//SCHEDULING
setInterval(getKanyeQuote, 10000);


/*
const quoteButton = document.getElementById('click-btn');

quoteButton.addEventListener("click", getKanyeQuote);
 */