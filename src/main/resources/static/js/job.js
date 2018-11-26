$(document).ready( function () {
    $('#table-jobs').DataTable();
} );



function clear(){
	document.getElementById("name").value = "";
	document.getElementById("timeSchedule").value = "";
	document.getElementById("code").value = "";
	
}

function checkFields(){
	var name = document.getElementById("name").value;
	var timeSchedule = document.getElementById("timeSchedule").value;
	var code = document.getElementById("code").value;
	
	if((name != "") && (timeSchedule != "") && (code != "")){
		return true;
	}else{
		return false;
	}
}

function save() {
	if(checkFields()){
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
	            clear();
	        },
	        error: function (response) {
	        	 alert("Erro no cadastro");
	             //...
	        }
	});
}else{
	alert("Preencha os campos corretamente.");
}

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
            location.reload();
        },
        error: function (response) {
        	 alert("Erro ao deletar job, existem chamados ou execuções desse job.");
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

function get_log(id){
	var data = {}
	data["id"] = id;
	
	$.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/jobsystem/ticket/log",
        data: JSON.stringify(data),
        timeout: 600000,
        success: function(response) {
            alert(response);
        }
	});
	
}


function close_ticket(ticket_id){
	
    $( "#dialog-confirm" ).dialog({
      resizable: false,
      height: "auto",
      width: 400,
      modal: true,
      buttons: {
        "Sim": function() {
        	
        	var data = {}
        	data["ticketNumber"] = ticket_id;
        	data["closure"] = $("#closure").val();
        	
        	$.ajax({
                type: "POST",
                contentType: "application/json",
                url: "/jobsystem/ticket/close",
                data: JSON.stringify(data),
                timeout: 600000,
                success: function(response) {
                    alert(response);
                    
                }
        	});
        	
          $( this ).dialog( "close" );
          location.reload();
        },
        "Não": function() {
          $( this ).dialog( "close" );
        }
      }
    });
}

function get_solution(ticketNumber){
	var data = {}
	data["ticketNumber"] = ticketNumber;
	
	$.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/jobsystem/ticket/solution",
        data: JSON.stringify(data),
        timeout: 600000,
        success: function(response) {
            alert(response);
        }
	});
	
}
