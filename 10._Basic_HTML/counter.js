const cookiebutton = document.getElementById('click-btn');
const collected = document.getElementById('cookies');

let clicksamount = 0;
let cookiesamount = 0;
let mouseoveramount = 0;

collected.textContent = cookiesamount.toString();

cookiebutton.addEventListener("click", () => { //shorthand for function
    buttonClicked();
})

cookiebutton.addEventListener("mouseover", buttonMouseOver);


function buttonClicked() {
    cookiesamount++;
    clicksamount++;
    collected.textContent = cookiesamount.toString();
    buttonHistory('click');
}

function buttonMouseOver() {
    if (cookiesamount > 0) {
        cookiesamount--;
        mouseoveramount++;
        collected.textContent = cookiesamount.toString();
        buttonHistory('mouseover');
    }
}

function buttonHistory(motion) {
    const paragraph = document.createElement("p");
    if (motion === 'click') {

        paragraph.innerText = "You have clicked the button " + clicksamount + " times";
    }
    if (motion === 'mouseover'){
        paragraph.innerText = "you removed a cookie, you have lost " + mouseoveramount + " cookies so far";
    }
    const counterWrapper = document.getElementById('click-counters');
    if (counterWrapper.childNodes.length > 4) {
        counterWrapper.children[4].remove();
    }
    counterWrapper.prepend(paragraph);

}