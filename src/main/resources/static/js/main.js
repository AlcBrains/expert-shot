$(document).ready(() => {
    getData().then((res) => {
        console.log(res)
        // $('#allData').jsGrid()
    })
})


function getData() {
    return $.ajax({
        url: '/totals',
        method: 'GET'
    });
}
