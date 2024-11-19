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
		type: 'doughnut', // Can be 'doughnut', 'pie', etc.
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
					position: 'left',
				},
				tooltip: {
					callbacks: {
						label: function(tooltipItem) {
							const total = data.values.reduce((acc, val) => acc + val, 0);
							const value = data.values[tooltipItem.dataIndex];
							const percentage = ((value / total) * 100).toFixed(2);
							
							return `${tooltipItem.label}: ${value} (${percentage}%)`;
						}
					}
				}
			}
		}
	});
}


// Function to retrieve availability dataFunction to retrieve availability data
async function fetchAvailabilityChartData() {
	const response = await fetch('api/chart/availability-data');
	if(!response.ok) {
		console.error(`Error retrieving data: ${response.statusText}`);
	}
	
	return response.json();
}

// Function to initialize the availability graph
async function initializaAvailabilityChart() {
	const data = await fetchAvailabilityChartData();
	const ctx = document.getElementById('availabilityChart').getContext('2d');
	new Chart(ctx, {
		type: 'pie', // Can be 'doughnut', 'pie', etc.
		data: {
			labels: data.labels, // dynamic labels
			datasets: [{
				label: 'Product Availability',
				data: data.values, // Dynamic values
				backgroundColor: [
					'rgba(75, 192, 192, 0.5)', // Color for "Available"
					'rgba(255, 99, 132, 0.5)'  // Color for "Not Available"
				],
				borderColor: [
					'rgba(75, 192, 192, 1)',
					'rgba(255, 99, 132, 1)'
				],
				borderWidth: 1
			}]
		},
		options: {
			responsive: true,
			plugins: {
				legend: {
					position: 'left',
					align: 'start',
					labels: {
						boxWidth: 20, // Width of the box next to the legend
						padding: 10 // Spacing between elements
						},
					}
				},
				tooltip: {
					callbacks: {
						label: function(tooltipItem) {
							const total = data.values.reduce((acc, val) => acc + val, 0);
							const value = data.values[tooltipItem.dataIndex];
							const percentage = ((value / total) * 100).toFixed(2);
							
							return `${tooltipItem.label}: ${value} (${percentage}%)`;
						}
					}
				}
			}
		}
	});
}

// Initialize the availability graph
document.addEventListener('DOMContentLoaded', () => {
	initializeDonutChart();
	initializaAvailabilityChart();
});

