var currentIndex = 0;
var editableIndex = 0;
let fromValue = 0;
let toValue = 0;
let prevToValue = 0;
$(document).ready(function() {
	document.getElementById('errorDiv1').textContent = "";
	//document.getElementById('errorDiv2').textContent = "";
	
	 $("#success-alert").hide();
	 $("#danger-alert").hide();
	 
	$('#dynamicRenewalCodesTable').DataTable();
	
	$("#dynamicRenewalCodesTable").on(
			'click',
			'#editCode',
			function() {
//				var id = $('#dynamicRenewalCodesTable').DataTable().row($(this).parents('tr')).data()[0];
				var id = $(this).parents('tr').find('input[type="hidden"]').val();
				 $.ajax({
			                  url : "/editNewRenewalCode/"+id,
			                  type: "POST",
			                  contentType: "application/json",
			                  success:function(data)
			                  {
			                	  
			                	  $('#editModal').modal('show');
			                	  $("#editDynamicRenewalCode").val(data.dynamicCode);
			                	  $("#editDynamicRenewalCode").prop('readonly', true);
			                	  $("#editDescription").val(data.description);
			                	  if(data.isActive == 1){
			                		  $('#toggle-event-edit').prop('checked', true);
			                	  }else{
			                		  $('#toggle-event-edit').prop('checked', false);
			                	  }
			                	  $("#toggle-event-edit").val(data.isActive);
			                	  $("#isActiveEdit").val(data.isActive);
			                	  
			                	  
			                	  for(var i = 0; i < data.renewalCodeDataDetailsList.length ; i++) {
			                		var row = $('<tr id="dynamic">');
			                	    row.append($('<td><input type="text" id="renewalCodeDataDetailsList-'+ i +'_fromCycle" name="renewalCodeDataDetailsList['+ i +'].fromCycle" class="form-control" value="'+data.renewalCodeDataDetailsList[i].fromCycle+'" onkeypress="return event.charCode >= 48 && event.charCode <= 57" onfocusout = "checkFromCycleForEdit(this)"/></td>'));
			                	    row.append($('<td><input type="text" id="renewalCodeDataDetailsList-'+ i +'_toCycle" name="renewalCodeDataDetailsList['+ i +'].toCycle" class="form-control" value="'+data.renewalCodeDataDetailsList[i].toCycle+'" onkeypress="return event.charCode >= 48 && event.charCode <= 57" onfocusout = "checkToCycleForEdit(this)"/></td>'));
			                	    if(data.renewalCodeDataDetailsList[i].type === 0){
			                	    	row.append($('<td><select id = "renewalCodeDataDetailsList-'+ i +'_type" class="form-control" onchange="typeChange(this)" name="renewalCodeDataDetailsList['+ i +'].type"> <option value = "0" label = "Amount" id="AmountType" selected>Amount</option> <option value = "1"  label = "Percentage" id="percentageType" >Percentage</option>'));
			                	    	row.append($('</select></td>'));
			                	    	row.append($('<td><input id = "renewalCodeDataDetailsList-'+ i +'_value" type="text" class="form-control" onkeypress="return event.charCode >= 48 && event.charCode <= 57" onfocusout = "checkValue(this)" name="renewalCodeDataDetailsList['+ i +'].value" value="'+data.renewalCodeDataDetailsList[i].value+'"/></td>'));
					                	row.append($('<td><input type="text" name="renewalCodeDataDetailsList['+ i +'].currency" class="form-control" value="'+data.renewalCodeDataDetailsList[i].currency+'" id = "renewalCodeDataDetailsList-'+ i +'_currency"/></td>'));
//					                	    
			                	    }
			                	    if(data.renewalCodeDataDetailsList[i].type === 1){
			                	     	row.append($('<td><select id = "renewalCodeDataDetailsList-'+ i +'_type" class="form-control" onchange="typeChange(this)" name="renewalCodeDataDetailsList['+ i +'].type"><option value = "0" label = "Amount" id="AmountType">Amount</option><option value = "1"  label = "Percentage" id="percentageType" selected>Percentage</option>'));
			                	    	row.append($('</select></td>'));
			                	    	row.append($('<td><input id = "renewalCodeDataDetailsList-'+ i +'_value" type="text" class="form-control" onkeypress="return event.charCode >= 48 && event.charCode <= 57" onfocusout = "checkValue(this)" name="renewalCodeDataDetailsList['+ i +'].value" value="'+data.renewalCodeDataDetailsList[i].value+'"/></td>'));
					                	row.append($('<td><input type="text" name="renewalCodeDataDetailsList['+ i +'].currency" class="form-control" value="'+data.renewalCodeDataDetailsList[i].currency+'" id = "renewalCodeDataDetailsList-'+ i +'_currency" disabled/></td>'));
//					                	    
			                	    }
			                	   row.append($('<td><a href=# class="btn btn-outline-secondary table-btn" id="deleteCode" title="Delete" ><i class="fa fa-trash"></i></a>'));
//			                	    row.append($('</td>'));
			                	    row.append($('<input type="hidden" name="renewalCodeDataDetailsList['+ i +'].dynamicPriceSeq" id = "renewalCodeDataDetailsList'+ i +'.dynamicPriceSeq"  value="'+ i +'"/>'));
			                	    row.append($('</tr>'));
			                	   
			                	    $('#editTableBody').append(row);
			                	    
			                	    if(data.renewalCodeDataDetailsList[i].type == 0){
			                	    	$("#renewalCodeDataDetailsList"+ i +"_currency").attr('disabled', false);
			                	    }else{
			                	    	$("#renewalCodeDataDetailsList"+ i +"_currency").attr('disabled', true);
			                	    }
			                	    
			                	    editableIndex = i+1;
			                	  }
			                	  
			                	  var editCodeId = $('<input type="hidden" name="editedId" id="editedId" value="'+id+'"/>');
			                	  $('#updateRenewalCodeForm').append(editCodeId);
			                	 
			                  }, 
			                  error: function(data)
			                  {
			
			                  }
			                });
	});
	
	$("#addNew").click(function(){
		 $('#addNewModal').modal('show');
		 var rowConstructed = constructRow(currentIndex++, 0);
		    $("#tbodyContainer").append(rowConstructed);
		 
	});
	

	// Append table with add row form on add new button click
	// Add row on add button click
  
	$(document).on("click", ".add", function(){
		var empty = false;
		var index = $("table tbody tr:last-child").index();
		var input = $(this).parents("tr").find('input[type="text"]');
        input.each(function(){
			if(!$(this).val()){
				if($(this).context.name.includes('currency')){
					$(this).removeClass("error");
				}else{
					$(this).addClass("error");
					document.getElementById('errorDiv2').textContent = "Please Enter Table Inputs";
					empty = true;
				}
			} else{
                $(this).removeClass("error");
                document.getElementById('errorDiv2').textContent = "";
               /* if($(this).context.name.includes('fromCycle')){
                	fromValue = $(this).val();
                	if($(this).val() < toValue && $(this).val() > prevToValue){
    					 $(this).removeClass("error");
    				}else{
    					$(this).addClass("error");
    					empty = true;
    					//add message : fromCycle Value should not be less than previous toCycle value
    				}
                }else if($(this).context.name.includes('toCycle')){
                	if($(this).val() > fromValue){
    					prevToValue = $(this).val();
    					 $(this).removeClass("error");
    				}else{
    					$(this).addClass("error");
    					empty = true;
    					//add message : toCycle Value should not be less than fromCycle value
    				}
                }*/
            }
		});
        
		$(this).parents("tr").find(".error").first().focus();
		if(!empty){
			$(this).parents("tr").find(".add").addClass("d-none");
			let row = constructRow(currentIndex++, toValue);
			$("#tbodyContainer").append(row);
			prevToValue = toValue;
		}		
    });

	$(document).on("click", ".delete", function(){
		console.log( $(this).closest("tr"));
        $(this).parents("tr").remove();
		$(".add-new").removeAttr("disabled");
    });

	$('#editModal').on('hidden.bs.modal', function () {
		//$(this).find('form').trigger('reset');
		$('#editTableBody').empty();
		$('#editedId').remove();
	})
	
	
	$('#addNewModal').on('hidden.bs.modal', function () {
		$("#addNewRenewalCodeForm").trigger("reset");
        $('#tbodyContainer').empty();
        currentIndex = 0;
	})
	
	$('#addNewModal').on('shown.bs.modal', function () {
    $('#dynamicRenewalCode').focus();
})  
	
	$("#cancelCode").click(function () {
		$('#editTableBody').empty();
		$('#editedId').remove();
	});
	
	   $(".reset-btn").click(function(){
	        $("#addNewRenewalCodeForm").trigger("reset");
	        $('#tbodyContainer').empty();
	        currentIndex = 0;
	    });
	   
   $('#toggle-event').on('change', function(){
	   this.value = this.checked ? 1 : 0;
	   $("#isActive").val(this.value);
	}).change();
   
   $('#toggle-event-edit').on('change', function(){
	   this.value = this.checked ? 1 : 0;
	   $("#isActiveEdit").val(this.value);
	}).change();
   
});

function constructRow(index, initialValue)
{
	initialValue++;
	let action='';
	if(index == 0){
		action = '<td><a class="add" title="Add" data-toggle="tooltip"><i class="fa fa-plus"></i></a></td>';
	}else{
		action = '<td><a class="add" title="Add" data-toggle="tooltip"><i class="fa fa-plus"></i></a> &nbsp; <a class="delete" title="Add" data-toggle="tooltip"><i class="fa fa-trash"></i></a></td>';
	}
	return '<tr>'+
		'<td><input name = "renewalCodeDataDetailsList['+ index +'].fromCycle" id = "renewalCodeDataDetailsList-'+ index +'_fromCycle" type="text" class="form-control" onkeypress="return event.charCode >= 48 && event.charCode <= 57" onfocusout = "checkFromCycle(this)" value="'+initialValue+'"/></td>'+
		'<td><input name = "renewalCodeDataDetailsList['+ index +'].toCycle" id = "renewalCodeDataDetailsList-'+ index +'_toCycle" type="text" class="form-control" onkeypress="return event.charCode >= 48 && event.charCode <= 57" onfocusout = "checkToCycle(this)"/></td>'+
		'<td><select name = "renewalCodeDataDetailsList['+ index +'].type" id = "renewalCodeDataDetailsList-'+ index +'_type" class="form-control type" onchange="typeChange(this)"><option value = "0" label = "Amount" id="AmountType" selected>Amount</option><option value = "1"  label = "Percentage" id="percentageType" >Percentage</option></select>'+
		'<td><input name = "renewalCodeDataDetailsList['+ index +'].value" id = "renewalCodeDataDetailsList-'+ index +'_value" type="text" class="form-control" onkeypress="return event.charCode >= 48 && event.charCode <= 57" onfocusout = "checkValue(this)"/></td>'+
		'<td><input name = "renewalCodeDataDetailsList['+ index +'].currency" id = "renewalCodeDataDetailsList-'+ index +'_currency" type="text" class="form-control"/></td>'+
		action+
		/*'<td><a class="add" title="Add" data-toggle="tooltip"><i class="fa fa-plus">&#xE03B;</i></a><a class="edit" title="Add" data-toggle="tooltip"><i class="fa fa-pencil">&#xE03B;</i></a><a class="delete" title="Delete" data-toggle="tooltip"><i class="fa fa-trash">&#xE872;</i></a></td>'+*/
		'<input type="hidden" name="renewalCodeDataDetailsList['+ index +'].dynamicPriceSeq" id = "renewalCodeDataDetailsList'+ index +'.dynamicPriceSeq"  value="'+ index +'"/>'+
	'</tr>';
}
function typeChange(obj){
	let id = $(obj).attr('id');
	let commonID = id.split('_')[0];
	let type = $("#"+commonID+"_value").val();
	if(obj.value =='1'){
		$("#"+commonID+"_value").val('');
		$("#"+commonID+"_currency").val('');
		$("#"+commonID+"_currency").prop('disabled', true);
	}else{
		$("#"+commonID+"_value").val('');
		$("#"+commonID+"_currency").val('');
		$("#"+commonID+"_currency").removeAttr('disabled');
	}
}

function checkValue(obj){
	let id = $(obj).attr('id');
	let commonID = id.split('_')[0];
	if($("#"+commonID+"_type").val() == 1 && obj.value > 100){
		$("#"+commonID+"_value").val('');
		document.getElementById('errorDiv2').textContent = "Percentage value must be less than 100";
		document.getElementById('errorDiv3').textContent = "Percentage value must be less than 100";
	}
}

function checkToCycle(obj){
	let id = $(obj).attr('id');
	let commonID = id.split('_')[0];
	if($("#"+commonID+"_fromCycle").val() >= obj.value){
		$("#"+commonID+"_toCycle").addClass("error");
		document.getElementById('errorDiv2').textContent = "ToCycle value must be greater than FromCycle value";
	}
	else{
		$("#"+commonID+"_toCycle").removeClass("error");
		document.getElementById('errorDiv2').textContent = "";
		toValue = obj.value;
		fromValue = $("#"+commonID+"_fromCycle").val();
	}
}

function checkFromCycle(obj){
	let id = $(obj).attr('id');
	let commonID = id.split('_')[0];
	let commonIdWithoutIndex = commonID.split('-')[0];
	let indexId = commonID.split('-')[1];
	if(indexId > 0){
		let prevIndexId = indexId-1;
		let idName = (commonIdWithoutIndex+"-").concat(prevIndexId).concat('_toCycle');
		let prevToCycleValue = $("#"+idName).val();
		if(obj.value <= prevToCycleValue){
			$("#"+commonID+"_fromCycle").addClass("error");
			document.getElementById('errorDiv2').textContent = "FromCycle value must be greater than previous ToCycle value";
		}else{
			$("#"+commonID+"_fromCycle").removeClass("error");
			document.getElementById('errorDiv2').textContent = "";
		}
	}else{
		if($("#"+commonID+"_toCycle").val() <= obj.value){
			$("#"+commonID+"_fromCycle").addClass("error");
			document.getElementById('errorDiv2').textContent = "FromCycle value must be greater than previous ToCycle value";
		}
		else{
			$("#"+commonID+"_fromCycle").removeClass("error");
			document.getElementById('errorDiv2').textContent = "";
		}
	}
}

function checkToCycleForEdit(obj){
	let id = $(obj).attr('id');
	let commonID = id.split('_')[0];
	if($("#"+commonID+"_fromCycle").val() >= obj.value){
		$("#"+commonID+"_toCycle").addClass("error");
		document.getElementById('errorDiv3').textContent = "ToCycle value must be greater than FromCycle value";
	}
	else{
		$("#"+commonID+"_toCycle").removeClass("error");
		document.getElementById('errorDiv3').textContent = "";
		toValue = obj.value;
		fromValue = $("#"+commonID+"_fromCycle").val();
	}
}

function checkFromCycleForEdit(obj){
	let id = $(obj).attr('id');
	let commonID = id.split('_')[0];
	let commonIdWithoutIndex = commonID.split('-')[0];
	let indexId = commonID.split('-')[1];
	if(indexId > 0){
		let prevIndexId = indexId-1;
		let idName = (commonIdWithoutIndex+"-").concat(prevIndexId).concat('_toCycle');
		let prevToCycleValue = $("#"+idName).val();
		if(obj.value <= prevToCycleValue){
			$("#"+commonID+"_fromCycle").addClass("error");
			document.getElementById('errorDiv3').textContent = "FromCycle value must be greater than previous ToCycle value";
		}else{
			$("#"+commonID+"_fromCycle").removeClass("error");
			document.getElementById('errorDiv3').textContent = "";
		}
	}else{
		if($("#"+commonID+"_toCycle").val() <= obj.value){
			$("#"+commonID+"_fromCycle").addClass("error");
			document.getElementById('errorDiv3').textContent = "FromCycle value must be greater than previous ToCycle value";
		}
		else{
			$("#"+commonID+"_fromCycle").removeClass("error");
			document.getElementById('errorDiv3').textContent = "";
		}
	}
}



function checkRenewalCode(obj){
	if(obj.value == ''){
		$('#dynamicRenewalCode').addClass("error");
		document.getElementById('errorDiv1').textContent = "Please Enter Dynamic Renewal Code";
	}else{
		if($('#priceNameList').val().indexOf(obj.value) !== -1){
			$('#dynamicRenewalCode').addClass("error");
			$('#dynamicRenewalCode').val('');
			document.getElementById('errorDiv1').textContent = "Duplicate Dynamic Renewal Code Found";
		}else{
			$('#dynamicRenewalCode').removeClass("error");
			$('#saveNewCode').removeAttr('disabled');
			document.getElementById('errorDiv1').textContent = "";
		}
	}
}

function deleteCell(obj){
	var i = obj.parentNode.parentNode.rowIndex-1;
	document.getElementById("tbodyContainer").deleteRow(i);
}

function insEditRow()
{
	var new_row = constructRow(editableIndex++, 0);
	$("#editTableBody").append(new_row);
}

function insNewRow()
{
	var new_row = constructRow(currentIndex++, 0);
	$("#tbodyContainer").append(new_row);
}

function addNewRenewalCodeForm(){
		$('#addNewRenewalCodeForm').submit();
		currentIndex=0;
}

function updateRenewalCodeForm(){
	$('#updateRenewalCodeForm').submit();
}

function resetForm(){
	 $("#editDynamicRenewalCode").val("");
	  $("#editDescription").val("");
}

