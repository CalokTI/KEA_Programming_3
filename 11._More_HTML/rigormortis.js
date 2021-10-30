async function getRickAndMortyCharacters() {
    const results = [];
    let url = 'https://rickandmortyapi.com/api/character';

    //do {
        const res = await fetch(url);
        const data = await res.json();
        url = data.info.next;

        results.push(...data.results);
    //} while (url)

    results.map(character => {
        createCard(character)
    })
}

getRickAndMortyCharacters();

const characterSectionElement = document.getElementById('character-card');

function createCard(character) {
    let characterArticle = document.createElement('article');

    let alive;
    if (character.status === "Alive") {
        alive = "💖 Alive";
    } else if (character.status === "unknown") {
        alive = "❓ Unknown";
    } else {
        alive = "🖤 Dead";
    }

    characterArticle.classList.add('character');
    characterArticle.classList.add(escapeHTML(character.status));
    characterArticle.classList.add(escapeHTML(character.species).replace(" ", ""));
    if (escapeHTML(character.species) !== 'Human' && escapeHTML(character.species) !== 'Alien'){
        characterArticle.classList.add('other');
    }
    characterArticle.classList.add(escapeHTML(character.gender));


    characterArticle.innerHTML = `
        <div class="characterCardImage"><img src="${escapeHTML(character.image)}"</div>
        <div class="characterCardInfo">
        <span class="characterCardName">${escapeHTML(character.name)}</span>
        <hr>
            
            <div class="characterCardStatus">
            ${alive} - ${escapeHTML(character.species)}
            </div>
              
            <div class="characterCardLocation">
            <span>🌍 Origin</span><br>
            <p>${escapeHTML(character.origin.name)}</p>
            <span>🎯 Last known location</span><br>
            <p>${escapeHTML(character.location.name)}</p>
            </div>           
        </div>  
    `;
    characterSectionElement.appendChild(characterArticle);
}

let selectedStatus = "character";
let selectedSpecies = "character";


document.getElementById('character-status').addEventListener('change', function() {
    selectedStatus = this.value;
    console.log(selectedStatus)
    filterCharacters();
});

document.getElementById('character-species').addEventListener('change', function() {
    selectedSpecies = this.value;
    console.log(selectedSpecies)
    filterCharacters();
});

function filterCharacters(){
    document.querySelectorAll('.character').forEach(function(element){
        //hvis class ikke indeholde character eller character, species har other, men ikke class der passer
        if (!element.classList.contains(selectedStatus) || !element.classList.contains(selectedSpecies)){
            element.style.display = 'none';
        }
        else {
            element.style.display = '';
        }
    })
}


let input = document.getElementById('search-field');
input.addEventListener('keyup', function (){
    console.log(this.value);
    let list = document.querySelectorAll('.character', 'div:not([style*="display: none;"])');
    list.filter(character => character.name.includes.ignoreCase(this.value));
    //todo fix filter

})




//JQUERY WHO THE FUCK KNOWS?


/*
$("character-search").click(function(){
    console.log("Hello");
    let show = $(this).attr('class');
    $('.character').each(function(){
        $(this).show();
        let test = $(this).attr('class');
        if (test.indexOf(show) < 0) $(this).hide();
    })
    $("section.character-card article[class!=" + characterStatus + "]").hide();
})



document.getElementById('character-search').addEventListener('click', function(){
    console.log(characterStatus, characterSpecies)
    $("section.character-card article[class=" + characterStatus + "]").hide();
});
*/