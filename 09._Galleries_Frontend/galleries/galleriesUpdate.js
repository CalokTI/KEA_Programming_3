function updateGallery(gallery) {

    const tableRowToUpdate = document.getElementById(gallery.id);

    tableRowToUpdate.innerHTML = `
        <td><input id="update-gallery-name-${gallery.id}" value="${gallery.name}"></td>
        <td><input id="update-gallery-location-${gallery.id}" value="${gallery.location}"></td>
        <td><input id="update-gallery-owner-${gallery.id}" value="${gallery.owner}"></td>
        <td><input id="update-gallery-square-feet-${gallery.id}" value="${gallery.squareFeet}"></td>
        <td>
            <button id="confirm-update-${gallery.id}" onclick="updateGalleryInBackend(${gallery.id})">✔</button>
            <button id="cancel-update-${gallery.id}" onclick="undoUpdateTableRow(${gallery.id})">➖</button>
        </td>
        <td><button onclick="deleteGallery(${gallery.id})">❌</button></td>
    `


    document.getElementById(`cancel-update-${gallery.id}`)
        .addEventListener("click", () => undoUpdateTableRow(gallery))

}

function undoUpdateTableRow(gallery) {
    const galleryTableRow = document.getElementById(gallery.id);

    constructGalleryTableRow(galleryTableRow, gallery);

}

function updateGalleryInBackend(galleryID) {

    const tableRowToUpdate = document.getElementById(galleryID);

    const galleryToUpdate = {
        id: galleryID,
        name: document.getElementById(`update-gallery-name-${galleryID}`).value,
        location: document.getElementById(`update-gallery-location-${galleryID}`).value,
        owner: document.getElementById(`update-gallery-owner-${galleryID}`).value,
        squareFeet: document.getElementById(`update-gallery-square-feet-${galleryID}`).value
    }

    fetch(baseURL + "/galleries/" + galleryID, {
        method: "PATCH",
        headers: {
            "Content-type": "application/json; charset=UTF-8"
        },
        body: JSON.stringify(galleryToUpdate)
    })
        .then(response => {
            if (response.status === 200) {
                constructGalleryTableRow(tableRowToUpdate, galleryToUpdate);
            }
        });
}
