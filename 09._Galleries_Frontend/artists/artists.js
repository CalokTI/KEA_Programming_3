fetch("http://localhost:8080/artists")
    .then(response => response.json())
    .then(result => {
        result.map(artistArticle)
    })

const artistContainer = document.getElementById('artists-list');

function artistArticle(artist) {
    const artistDivElement = document.createElement('div');

    let artistImage = artist.image;
    if (artistImage === null) {
        artistImage = "../resources/images/putin.jpg";
    } else {
        artistImage = escapeHTML(artist.image);
    }


    artistDivElement.innerHTML = `
        <div class="artist-image" ><img src="${escapeHTML(artistImage)}"></div>
        <div class="artist-name" >Name: ${escapeHTML(artist.name)}</div>
        <hr>
        <div class="artist-age" >Age: ${escapeHTML(artist.age.toString())}</div>
        <div class="artist-primary-style" >Primary Style: ${escapeHTML(artist.primaryStyle)}</div>
    `;

    artistContainer.appendChild(artistDivElement);

}

const createArtistButton = document.getElementById('create-artist-button');
const artists = [];

createArtistButton.addEventListener('click', () => {
    const name = document.getElementById('create-artist-name').value;
    const age = document.getElementById('create-artist-age').value;
    const gender = document.getElementById('create-artist-gender').value;
    const image = document.getElementById('create-artist-image').value;
    const primaryStyle = document.getElementById('create-artist-primary-style').value;

    const artist = {
        name: name,
        age: Number(age),
        gender: gender,
        image: image,
        primaryStyle: primaryStyle
    };

    fetch("http://localhost:8080/artists", {
        method: "POST",
        headers: {
            "Content-type": "application/json; charset=UTF-8"
        },
        body: JSON.stringify(artist)
    })
        .then(response => {
            if (response.status === 200){
                artistArticle(artist);
            }else{
                console.log("Artist not created.", response.status);
            }
        })
        .catch(error => console.log("Network related error", error))

})