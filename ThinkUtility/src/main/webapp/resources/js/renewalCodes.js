$(document).ready(function() {
	$("#addNew").click(function(){
		 $('#addNewModal').modal('show');
	});
	
	$("#fixed").click(function () {
		$('#activePeriod').css('display', ($(this).val() === 'option1') ? 'block':'none');
		$('#tableForFixed').css('display', ($(this).val() === 'option1') ? 'block':'none');
		$('#tableForInstallment').css('display', ($(this).val() === 'option2') ? 'block':'none');
		$('#addNewInstallment').css('display', 'none');
	});
	
	$("#installment").click(function () {
		$('#activePeriod').css('display', ($(this).val() === 'option2') ? 'block':'none');
		$('#tableForFixed').css('display', ($(this).val() === 'option1') ? 'block':'none');
		$('#tableForInstallment').css('display', ($(this).val() === 'option2') ? 'block':'none');
		$('#addNewInstallment').css('display', 'block');
	});
});

function insRow()
{
    var x=document.getElementById('tableForInstallment');
    var new_row = x.rows[1].cloneNode(true);
    x.appendChild( new_row );
}

$(document).on('click', '#saveNewCode', function() {
	$('#addNewRenewalCodeForm').submit();
});

$(document).on('click', '#editCode', function() {
	 $('#addNewModal').modal('show');
});