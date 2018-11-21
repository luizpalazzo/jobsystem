
function save() {
	var data = {}	

	if((document.getElementById("original_id").value !== "")&&(document.getElementById("original_id")!==null)){
		data["id"] = document.getElementById("original_id").value;
	}
	
	data["name"] = $("#name").val();
	data["timeSchedule"] = $("#timeSchedule").val();
	data["monitoringTeam"] = $("#monitoringTeam").val();
	data["incidentTeam"] = $("#incidentTeam").val();
	data["code"] = $("#code").val();

	$.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/jobsystem/job/insert",
        data: JSON.stringify(data),
        dataType: 'json',
        timeout: 600000,
        success: function (response) {
            alert("Cadastro efetuado com sucesso");
            //...
        },
        error: function (response) {
        	 alert("Erro no cadastro");
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
        url: "/jobsystem/job/delete",
        data: JSON.stringify(data),
        dataType: 'json',
        timeout: 600000,
        success: function (response) {
            alert("Job deletado com sucesso");
            //...
        },
        error: function (response) {
        	 alert("Erro ao deletar job");
             //...
        }
});
	
}

function execute_job(id){
	var data = {}
	data["id"] = id;
	console.log(id);
	
	$.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/jobsystem/job/execute",
        data: JSON.stringify(data),
        dataType: 'json',
        timeout: 600000,
        success: function (response) {
            alert("Job executado com sucesso");
            //...
        },
        error: function (response) {
        	 alert("Erro ao executar job");
             //...
        }
});
	
}