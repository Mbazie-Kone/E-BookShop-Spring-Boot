// Function to retrieve data from the backend
async function fetchDonutChartData() {
	const response = await fetch('api/chart/donut-data');
	return response.json();
}
