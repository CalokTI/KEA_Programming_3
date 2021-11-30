const galleryFormElement = document.getElementById('gallery-form');
const galleryFormButton = document.getElementById('add-new-gallery');

galleryFormButton.addEventListener('click', createGalleryForm);



function createGalleryForm(){
    galleryFormButton.style.display = 'none';

    const divContainer = document.createElement('div');

    divContainer.innerHTML = `
        <label>Name</label><input id="create-gallery-name" type="text" placeholder="Gallery Name">
        <label>Location</label><input id="create-gallery-location" type="text" placeholder="Gallery Location">
        <label>Owner</label><input id="create-gallery-owner" type="text" placeholder="Gallery Owner">
        <label>SquareFeet</label><input id="create-gallery-squarefeet" type="number" placeholder="Square Feet" min="0" max="1000000">
        <button id="create-gallery-button" onclick="newGallery()">Create</button>   
        <button id="create-gallery-cancel" onclick="hideForm()">Cancel</button> 
`;

    galleryFormElement.append(divContainer);

}

function newGallery() {

    //get input from fields
    const galleryName = document.getElementById('create-gallery-name').value;
    const galleryLocation = document.getElementById('create-gallery-location').value;
    const galleryOwner = document.getElementById('create-gallery-owner').value;
    const gallerySqrFeet = document.getElementById('create-gallery-squarefeet').value;

    //Create js object
    const newGallery = {
        name:galleryName,
        location:galleryLocation,
        owner:galleryOwner,
        squareFeet:gallerySqrFeet
    }

    //add gallery to db
    createGallery(newGallery);
}


function hideForm(){
    //remove input fields, change visibility of new gallery button
    galleryFormElement.removeChild(galleryFormElement.firstChild);
    galleryFormButton.style.display = '';
}

function createGallery(newGallery){
    fetch(baseURL + "/galleries", {
        method: "POST",
        headers: {
            "Content-type": "application/json; charset=UTF-8"
        },
        body: JSON.stringify(newGallery)
    })
        .then(response => response.json())
        .then(gallery => {
            createGalleryTableRow(gallery);
            hideForm();
        })
}