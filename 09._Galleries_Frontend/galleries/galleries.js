const galleryList = document.getElementById('gallery-tbody');

fetch(baseURL + "/galleries")
    .then(response => response.json())
    .then(galleries => {
        galleries.map(createGalleryCard);
        console.log(galleries);
    })

function createGalleryCard(gallery){
    const galleryCard = document.createElement('tr');
    galleryCard.setAttribute('id', gallery.id);

    galleryCard.innerHTML = `
                <td><a href="./gallery/gallery.html?id=${gallery.id}">${gallery.name}</a></td>
                <td>${gallery.location}</td>
                <td>${gallery.owner}</td>
                <td>${gallery.squareFeet}</td>
                <td><button onclick="deleteGallery(${gallery.id})">❌</button></td>
                `

    galleryCard.style.border = 'solid';
    galleryCard.style.borderRadius = '10px';

    galleryCard.style.width = '300px';
    galleryCard.style.margin = '10px';
    galleryCard.style.padding = '10px';

    galleryList.appendChild(galleryCard);
}

function deleteGallery(galleryId) {
    fetch(baseURL + "/galleries/" + galleryId, {
        method: "DELETE",
    })
        .then(response => {
            if(response.status === 200){
                document.getElementById(galleryId).remove();
            }else{
                console.log("Can't delete " + response.status);
            }
        });
}