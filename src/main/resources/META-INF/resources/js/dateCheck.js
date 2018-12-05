let today = new Date().toISOString().substr(0, 10);
document.querySelector("#startDate").min = today;

$("#startDate").change(
		function() {
			document.querySelector("#endDate").min = document
					.querySelector("#startDate").value;
			document.querySelector("#endDate").value = document
					.querySelector("#startDate").value;
		});