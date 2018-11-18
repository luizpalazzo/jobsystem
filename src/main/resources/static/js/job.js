
function save() {
	var data = {}
	data["name"] = $("#name").val();
	data["timeSchedule"] = $("#timeSchedule").val();
	data["monitoringTeam"] = $("#monitoringTeam").val();
	data["incidentTeam"] = $("#incidentTeam").val();
	data["code"] = $("#code").val();
	
	$.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/job/insert",
        data: JSON.stringify(data),
        dataType: 'json',
        timeout: 600000,
        success: function (response) {
            alert("deu certo");
            //...
        },
        error: function (response) {
        	 alert("deu errado");
             //...
        }
});
}

function delete_job(id){
	var data = {}
	data["id"] = id;
	console.log(id);
	
	$.ajax({
        type: "DELETE",
        contentType: "application/json",
        url: "/job/delete",
        data: JSON.stringify(data),
        dataType: 'json',
        timeout: 600000,
        success: function (response) {
            alert("deu certo");
            //...
        },
        error: function (response) {
        	 alert("deu errado");
             //...
        }
});
	
}