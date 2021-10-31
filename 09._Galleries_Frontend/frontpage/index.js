fetch('http://localhost:8080/artists')
    .then(response => response.json())
    .then(result => {
        result.map(artist => {
            console.log(artist);
            const articleElement = document.createElement('article');
            let artistBirthday = artist.birthDate;
            artistBirthday ? escapeHTML(artistBirthday.toString()) : "";

            articleElement.innerHTML = `
            <p>Name: ${escapeHTML(artist.name)}</p>
            <p>Age: ${escapeHTML(artist.age.toString())} ${artistBirthday}</p>
            <p>Style: ${escapeHTML(artist.primaryStyle)}</p>
            <hr>
            `
            recentArtistElement.appendChild(articleElement);
        })
    })

fetch('http://localhost:8080/artists/4')
    .then(response => response.json())
    .then(artist => {
        const pElement = document.createElement('p');
        pElement.innerText = artist.name;
        featuredArtistElement.appendChild(pElement);
    })

const featuredArtistElement = document.getElementById('featured-artist');
const recentArtistElement = document.getElementById('recent-artist');
