const galleryList = document.getElementById('gallery-tbody');

fetch(baseURL + "/galleries")
    .then(response => response.json())
    .then(galleries => {
        galleries.map(createGalleryTableRow);
    })

function createGalleryTableRow(gallery){
    const galleryTableRow = document.createElement('tr');
    galleryTableRow.setAttribute('id', gallery.id);

    galleryList.appendChild(galleryTableRow);

    constructGalleryTableRow(galleryTableRow, gallery);
}

function constructGalleryTableRow(galleryTableRow, gallery){
    galleryTableRow.innerHTML = `
                <td><a href="./gallery/gallery.html?id=${gallery.id}"><p class="row-gallery-name">${gallery.name}</p></a></td>
                <td><p class="row-gallery-location">${gallery.location}</p></td>
                <td><p class="row-gallery-owner">${gallery.owner}</p></td>
                <td><p class="row-gallery-square-feet">${gallery.squareFeet}</p></td>
                <td><button id="update-button-${gallery.id}">💬</button></td>
                <td><button onclick="deleteGallery(${gallery.id})">❌</button></td>
                `
    document.getElementById(`update-button-${gallery.id}`).addEventListener("click", () => updateGallery(gallery));

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