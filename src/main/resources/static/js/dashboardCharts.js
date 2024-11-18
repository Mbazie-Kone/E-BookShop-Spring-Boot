document.addEventListener("DOMContentLoaded", function () {
    const xArray = ["Italy", "France", "Spain", "USA", "Argentina"];
    const yArray = [55, 49, 44, 24, 15];
    const layout = { title: "E-Book Shop KMB/>" };
    const data = [{ labels: xArray, values: yArray, hole: 0.4, type: "pie" }];
    Plotly.newPlot("myPlot", data, layout);
});

console.log(document.getElementById("myPlot"));
