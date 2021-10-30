async function getPokemons(limit) {
    const results = [];
    let url = 'https://pokeapi.co/api/v2/pokemon?limit=' + limit;


    const res = await fetch(url);
    const data = await res.json();

    results.push(...data.results);

    results.map(pokemon => {
        createCard(pokemon)
    })
}

getPokemons(20);

const pokemonDiv = document.getElementById('pokemon-list');
let i = 1;

function createCard(pokemon) {

    let pokemonArticle = document.createElement('article');

    pokemonArticle.innerHTML = `
        <p>${i + " " + escapeHTML(pokemon.name)}</p>
    `

    pokemonDiv.appendChild(pokemonArticle);
    i++;
}