/*
console.log("test")

const list = [1,2,3,4,5];
const squaredList = list.map(number => number * number);

console.log(squaredList)

const isOdd = list.filter(number => number % 2 !== 0); //filter that shows only odd numbers from list
console.log(isOdd);
*/

//array
const kajkager = [{
    type: "Andrea",
    color: "blue",
    deliciousness: 8
}];

//add to array
kajkager.push({
    type: "Kaj",
    color: "green",
    deliciousness: 10
})

kajkager.push({
    type: "Ole",
    color: "#ffe4c4",
    deliciousness: 3
})

//get element from html
const tbodyElement = document.getElementById('cake-tbody');
/*
//create table data with map
let tableData =
    kajkager.map(function (element){
        return `
    <tr>
        <td>${escapeHTML(element.type)}</td>
        <td>${escapeHTML(element.color)}</td>
        <td>${escapeHTML(element.deliciousness.toString())}</td>
    </tr>
`
    });

tbodyElement.innerHTML = tableData.join('\n');*/


kajkager.map(cake => {
    let tr = document.createElement('tr');
    tr.innerHTML = `
        <td>${escapeHTML(cake.type)}</td>
        <td>${escapeHTML(cake.color)}</td>
        <td>${escapeHTML(cake.deliciousness.toString())}</td>
    `
    tbodyElement.appendChild(tr)
});


/*

tbodyElement.innerHTML = `
    <tr>
        <td>${escapeHTML(kajkager[0].type)}</td>
        <td>${escapeHTML(kajkager[0].color)}</td>
        <td>${escapeHTML(kajkager[0].deliciousness.toString())}</td>
    </tr>
`;
*/


fetch(url)
.then(response => response.json())
.then(result => {
    result.results.map(character => {
        //do something here for each character in results
    })
})