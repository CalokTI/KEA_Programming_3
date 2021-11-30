const paintingsList = document.getElementById('paintings-list');

fetch(baseURL + "/paintings")
    .then(response => response.json())
    .then(paintings => {
        paintings.map(createAPaintingCard);
    })


function createAPaintingCard(painting){
    console.log(painting)

    const paintingsDiv = document.createElement('div');
    paintingsDiv.setAttribute('id', painting.id);

    paintingsList.appendChild(paintingsDiv);

    constructAPaintingCard(paintingsDiv, painting);
}

function constructAPaintingCard(paintingsDiv, painting){ //TODO issue with escapehtml
    console.log(painting);
    paintingsDiv.innerHTML = `
                <p class="">${escapeHTML(painting.artist)}</p>
                <p class="">${escapeHTML(painting.title)}</p>
                <p class="">${escapeHTML(painting.price.toString())}</p>
                <p class="">${escapeHTML(painting.genre)}</p>
                <button id="update-button-${gallery.id}">💬</button>
                <button onclick="deleteGallery(${gallery.id})">❌</button>
                `

}


function createPainting(){

}

document.getElementById('create-painting-button').addEventListener("click", createPainting);