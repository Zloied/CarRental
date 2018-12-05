function tableSearch() {
	var input, filter, table, tr, td, i;
	input = document.getElementById("search");
	filter = input.value.toLowerCase();
	table = document.getElementById("layOutTable");
	tr = table.getElementsByTagName("tr");
	for (i = 0; i < tr.length; i++) {
		td = tr[i].getElementsByTagName("td")[0];
		td1 = tr[i].getElementsByTagName("td")[1];
		td2 = tr[i].getElementsByTagName("td")[2];
		td3 = tr[i].getElementsByTagName("td")[3];
		if (td) {
			if ((td.innerHTML.toLowerCase().indexOf(filter) > -1)
					|| (td1.innerHTML.toLowerCase().indexOf(filter) > -1)
					|| (td2.innerHTML.toLowerCase().indexOf(filter) > -1)
					|| (td3.innerHTML.toLowerCase().indexOf(filter) > -1)) {
				tr[i].style.display = "";
			} else {
				tr[i].style.display = "none";
			}
		}
	}
}
