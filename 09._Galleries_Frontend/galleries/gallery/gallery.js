const queryString = window.location.search;
const urlParams = new URLSearchParams(queryString);
const id = urlParams.get('id');

fetch(baseURL + "/galleries/" + id)
    .then(response => response.json())
    .then(gallery => {
        document.getElementById('gallery-name').innerText = gallery.name;
        document.getElementById('gallery-location').innerText = gallery.location;
        document.getElementById('gallery-owner').innerText = gallery.owner;
        document.getElementById('gallery-squarefeet').innerText = gallery.squareFeet;

    })