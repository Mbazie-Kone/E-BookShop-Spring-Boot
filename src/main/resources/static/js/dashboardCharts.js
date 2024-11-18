// Function to retrieve data from the backend
async function fetchDonutChartData() {
	const response = await fetch('api/chart/donut-data');
	return response.json();
}

//  Function to initialize the Donut Chart
async function initializeDonutChart() {
	const data = await fetchDonutChartData();
	const ctx = document.getElementById('donutChart').getContext('2d');
	new Chart(ctx, {
		type: 'doughnut',
		data: {
			labels: data.labels,
			datasets: [{
				label: 'Distribution of Products by Category',
				data: data.values,
				backgroundColor: [
					'rgba(255, 99, 132, 0.5)',
					'rgba(54, 162, 235, 0.5)',
					'rgba(255, 206, 86, 0.5)',
					'rgba(75, 192, 192, 0.5)'
				],
				borderColor: [
					'rgba(255, 99, 132, 1)',
					'rgba(54, 162, 235, 1)',
					'rgba(255, 206, 86, 1)',
					'rgba(75, 192, 192, 1)'
				],
				borderWidth: 1	
			}]
		},
		options: {
			responsive: true,
			plugins: {
				legend: {
					position: 'top',
				},
				tooltip: {
					callbacks: {
						label: function(tooltipItem) {
							return tooltipItem.label + ': '+ tooltipItem.raw;
						}
					}
				}
			}
		}
	});
}
