

function in_array(selectedId, selectedArr){
	
    var found = 0;
    for (var i=0, len=selectedArr.length;i<len;i++) {
        if (selectedArr[i] == selectedId) return i;
            found++;
    }
    return -1;
}
var tbLive=null;
   $(document).ready(function() {
	   
	   
	   
	   tbLive=$('#existingArticleTable').DataTable({
		   "autoWidth": false,	   
	    Processing: true,
		serverSide: true,
		searching: false,
		jQueryUI: true,
		paginationType: "full_numbers",
		infoEmpty: "No records found",
		ajax : {
			//url : "liveArticleDetails",
			url: "emptyData",
			data: function (d) {
				
                d.title = $("#titleForSearchExistingArticle").val();
                d.journal= $("#journalForSearchExistingArticle").val();			               
                d.volume= $("#volumeForSearchExistingArticle").val();
                d.issue= $("#issueForSearchExistingArticle").val();
                d.identifier= $("#identifierForSearchExistingArticle").val();
             },
		
			dataSrc : "data"	
		},
		
		
		columns: [
			{ "data": null,"width" : "10%", sortable: false, render: function( data, type, full, meta ) {
				var checked='';
				if(in_array(data.articleId , rows_selected)!=-1){
					checked='checked="checked"';
				}
                 return "<input type='checkbox' "+checked+" id='chk"+data.articleId+"' name='articles' value='"+data.articleId+"' class='articleCheckbox' onclick=\"checkDuplicate('"+data.articleId+"');\"/>"
               }
			},
            { "data": "title", "width" : "30%" },
            { "data": "journal", "width" : "15%" },
            { "data": "volume", "width" : "12%" },
            { "data": "issue", "width" : "10%" },
            { "data": "identifier","width" : "15%"}
        ],
        "order": [[0, 'asc']],
		
	});
	  /* $('[type="checkbox"]').click(function(){
	   var checkedcollection = tbLive.$(".articleCheckbox:checked");
       checkedcollection.each(function (index, elem) {
    	   rows_selected.push($(elem).val());
       })
		});*/
	  
   $("a#customer").bind('click', function () {
		/* $("#subscriptionForm").attr("action", "saveSubscription");
		$("#subscriptionForm").submit(); */
		 window.location.href="createCustomer?subscriptionId="+$("#subscriptionId").val();
	});
	   
       
	$("#availableDate").daterangepicker({
	    singleDatePicker: true,
	    showDropdowns: true,
	    minDate:'01/01/2017',
	    locale: {
            format: 'MM/DD/YYYY'
        }
	});
	
	$("#expiryDate").daterangepicker({
	    singleDatePicker: true,
	    showDropdowns: true,
	    minDate:'01/01/2018',
	    locale: {
            format: 'MM/DD/YYYY'
        }
	});
	
	
	
	$('#availableDate').on('apply.daterangepicker', function(ev, picker) {
		if($('#availableDate').val() != ''){
    		setExpiryDate($('#availableDate').val());
    	}
	});
	

	$('#expiryDate').on('apply.daterangepicker', function(ev, picker) {
		if($('#expiryDate').val() != '' && $("#thresholddays").val().length > 0 ){
			getThresholdDate();
    	}
	});
	
	
	
	
	$("a[href='subscription']").addClass("active");
	
	//set expiry date at form loading time
	/*if($('#availableDate').val() != ''){
		setExpiryDate($('#availableDate').val());
	}*/
	getThresholdDate();
	
});
   function getThresholdDate(){
	   if($("#thresholddays").val().length > 0) {
		var expiryDate=trim($("#expiryDate").val());
	    var thresholddaysArray=$("#thresholddays").val();
	    var thresholddays="";
	    if(thresholddaysArray.length > 1)
	    	{
	    thresholddays = thresholddaysArray.reduce(function(a, b) {
	        return Math.max(a, b);
	    });
	    	}
	    else
	    	{
	    	thresholddays=thresholddaysArray;
	    	}
		var thresholdDate=new Date(expiryDate);	
		var daysPrior = thresholddays;
		 thresholdDate.setDate(thresholdDate.getDate() - daysPrior);
		 thresholdDate= formatDate(thresholdDate);
		 $("#thresholdDate").val(thresholdDate);
   }
	}
   
   
   
   
  /* function setExpiryDate(availableDate){
		//alert('availableDate:'+availableDate);//01/03/2018  //MM//dd/yyyy
	//	var definitionId=$("#definitionId").val();
		var year=null;
		var month=null;
		var day=null;
		var hour=null;
		var minute=null;
		var expiryDate=null;
		var avbDate=null;
		var expiryDate=null;
		if(availableDate.indexOf('/') > -1){
			var dateArr=availableDate.split('/');
			month=dateArr[0]-1;
			day=dateArr[1];
			year=dateArr[2];
			avbDate=new Date(year,month,day);
			//alert('avbDate:'+avbDate);
		}else{
			return;
		}
		
		if(definitionId != 0){
			var accessPeriod= parseInt($("#accessPeriod"+definitionId).val());
			var accessPeriodType=$("#accessPeriodType"+definitionId).val();
			
			if(accessPeriodType == 'DAY'){
				expiryDate=new Date(avbDate.getFullYear(),avbDate.getMonth(),avbDate.getDate()+accessPeriod);
			} else if(accessPeriodType == 'MONTH'){
				expiryDate=new Date(avbDate.getFullYear(),avbDate.getMonth()+accessPeriod,avbDate.getDate());
			} else if(accessPeriodType == 'YEAR'){
				expiryDate=new Date(avbDate.getFullYear()+accessPeriod,avbDate.getMonth(),avbDate.getDate());
			}
			
			var formattedExpiryDate = getFormattedDate(expiryDate);
			$("#expiryDate").val(formattedExpiryDate);
			getThresholdDate();
		}
		
	}*/
   
   
function refreshExpiryDate(){
	var availableDate=$("#availableDate").val();
	if(availableDate != ''){
		//setExpiryDate(availableDate);
	}
	
}


function openCreateArticleModal(){
	$("#submit").prop('disabled', false);
	$("#createArticleModal").modal();
	rereshArticleForm();
}
function openExistingArticleModal(){
	$("#submit").prop('disabled', false);
	$("#addExistingArticleBtn").prop('disabled', false);
	$('#existingArticleErrorMessage').css("display","none");
	$("#addExistingArticleModal").modal();
	rereshArticleForm();
	refreshExistingArticleSearchForm();
}

function searchExistingArticle(){
	rows_selected = [];
	var title=$("#titleForSearchExistingArticle").val();
	var journal=$("#journalForSearchExistingArticle").val();
	var volume=$("#volumeForSearchExistingArticle").val();
	var issue=$("#issueForSearchExistingArticle").val();
	var identifier=$("#identifierForSearchExistingArticle").val();
	var subscriptionId=$("#subscriptionId").val();
	
	if(title == "" && journal == "" && volume == "" && issue == "" && identifier == "")
		{
		alert("Please provide at-least one");
		return false;
		} else{
	var searchUrl='searchExistingArticle'+'?title='+title+'&journal='+journal+'&volume='+volume+'&issue='+issue+'&identifier='+identifier+'&subscriptionId='
	+subscriptionId;
	tbLive.ajax.url(searchUrl).load();
	}
}

function refreshExistingArticleSearchForm(){
	$("#titleForSearchExistingArticle").val('');
	$("#journalForSearchExistingArticle").val('');
	$("#volumeForSearchExistingArticle").val('');
	$("#issueForSearchExistingArticle").val('');
	$("#identifierForSearchExistingArticle").val('');
	var searchUrl='emptyData';
	tbLive.ajax.url(searchUrl).load();
	
}


function checkDuplicate(articleId){
        /*if ((index = selected.indexOf($(this).val())) !== -1) {
        	rows_selected.splice(index, 1);
        }*/
	var index;
	if(document.getElementById('chk'+articleId).checked){
		rows_selected.push(articleId);
		//check whether this article has already been added.
		var article=document.getElementById("tr"+articleId);
		if(article !=null){
			displayMessage('This article is already added.');
			document.getElementById('chk'+articleId).checked = false;
		}
	}else{
		if ((index = rows_selected.indexOf(articleId)) !== -1) {
        	rows_selected.splice(index, 1);
        }
	}
	rows_selected = $.unique(rows_selected);
}




function setArticleData(result){
	var obj = JSON.parse(result);
    var data = obj.data;
    var outputData="";
    for(var i in data)
    {
         var subscriptionArticle = data[i];
         var articleId=subscriptionArticle.article.articleId;
         var title=subscriptionArticle.article.title;
         var journal=subscriptionArticle.article.journal;
         var volume=subscriptionArticle.article.volume;
         var issue=subscriptionArticle.article.issue;
         var downloadUrl=subscriptionArticle.downloadUrl;
         if(downloadUrl == null){
        	 downloadUrl="";
         }
         var subArticleId=subscriptionArticle.subArticleId;
         //create row
        // outputData=outputData+"<tr id='tr"+articleId+"'><td class='articleData'>"+title+"</td><td>"+journal+"</td><td>"+volume+"</td><td>"+issue+"</td><td>"+downloadUrl+"</td><td><a href=\"javascript:void(0);\" onclick=\"confirmDeleteSubscriptionArticle('"+articleId+"','"+subArticleId+"');\" class='btn btn-outline-secondary table-btn'><i class='fa fa-trash'></i></a></td></tr>";
    }
//    document.getElementById("subscriptionArticleTableBody").innerHTML=outputData;
	
}

function confirmDeleteSubscriptionArticle(articleId,subArticleId){
	$("#deleteArticleId").val(articleId);
	$("#deleteSubArticleId").val(subArticleId);
	
	//show delete subscription article confirmaiton modal
	$("#deleteSubscriptionArticleModal").modal();
}

function rereshArticleForm(){
	//alert('in rereshArticleForm()');
	clearAllErrorMessagesForArticle();
	$("#title").val("");
	$("#journal").val("");
	$("#volume").val("");
	$("#issue").val("");
	$("#identifier").val("");
	$("#instructions").val("");
	$("#file1").val("");
	$("#coverPage").val("");
	setTimeout(function(){ $("#title").focus(); }, 200);
}

function clearAllErrorMessages(){
	$("#subscriptionIdMaxLengthError").css("display", "none");		
	$("#subscriptionIdInvalidError").css("display", "none");
	$("#subscriptionIdError").css("display", "none");
	$("#customerIdError").css("display", "none");		
	$("#customerInvalidIdError").css("display", "none");
	$("#customerIdMaxLengthError").css("display", "none");
	$("#orderNoError").css("display", "none");		
	$("#orderNoInvalidError").css("display", "none");
	$("#orderNoMaxLengthError").css("display", "none");
/*	$("#definitionIdError").css("display", "none");		*/
	$/*("#definitionIdInvalidError").css("display", "none");
	$("#definitionIdMaxLengthError").css("display", "none");*/
	$("#availableDateError").css("display", "none");		
	$("#availableDateFormatError").css("display", "none");
	$("#availableInvalidDateError").css("display", "none");
	$("#availableMaxLengthDateError").css("display", "none");
	$("#availableDatelessThanNowError").css("display","none");
	$("#expiryDateError").css("display", "none");
	$("#thresholdDateError").css("display", "none");
	$("#thresholdInvalidDateError").css("display", "none");
	$("#thresholdDateMaxLengthError").css("display", "none");
	$("#thresholdlessThanAvbDateError").css("display", "none");
	$("#thresholdgreaterThanExpError").css("display", "none");
	$("#thresholdQtyError").css("display", "none");
	$("#thresholdQtyNotNumericError").css("display", "none");
	$("#thresholdQtyMaxLengthError").css("display", "none");
	$("#thresholdQtyGTAccessCountError").css("display", "none");
	$("#drmError").css("display", "none");
	$("#drmErrorInvalid").css("display", "none");
	$("#totalQtyError").css("display", "none");
	$("#totalQtyNumericError").css("display", "none");
	$("#totalQtyGTAccessCountError").css("display", "none");
	
	$("#addSubscription").prop('disabled', false);
	$("#editSubscription").prop('disabled', false);
}

function clearAllErrorMessagesForArticle(){
	$("#titleError").css("display", "none");
	$("#titleInvalidError").css("display", "none");
	$("#titleMaxLengthError").css("display", "none");
	$("#journalError").css("display", "none");
	$("#journalInvalidError").css("display", "none");
	$("#journalMaxLengthError").css("display", "none");	
	$("#volumeError").css("display", "none");
	$("#volumeMaxLengthError").css("display", "none");
	$("#identifierError").css("display", "none");
	$("#identifierInvalidError").css("display", "none");	
	$("#identifierDuplicateError").css("display", "none");
	$("#issueError").css("display", "none");
	$("#issueMaxlengthError").css("display", "none");	
	$("#file1Error").css("display", "none");
	$("#file2Error").css("display", "none");
	$("#fileError").css("display", "none");
	$("#coverPageError").css("display", "none");
	$("#coverPageError1").css("display", "none");
} 



function getFormattedDate(date){
	var formattedDate = "";
	if(parseInt(date.getMonth()+1) <10){
		formattedDate=formattedDate+"0"+parseInt(date.getMonth()+1);
	}else{
		formattedDate=formattedDate+parseInt(date.getMonth()+1);
	}
	formattedDate=formattedDate+"/";
	
	if(parseInt(date.getDate()) <10){
		formattedDate=formattedDate+"0"+parseInt(date.getDate());
	}else{
		formattedDate=formattedDate+parseInt(date.getDate());
	}
	
	var formattedDate=formattedDate +"/"+ date.getFullYear();
	
	return formattedDate;
}
function createSubscription(operation){
	var errorFound=false;
	//clean all error 
	clearAllErrorMessages();
	$("#addSubscription").prop('disabled', true);
	$("#editSubscription").prop('disabled', true);
	var subscriptionId=trim($("#subscriptionId").val());
	$("#subscriptionId").val(subscriptionId);
	var customerId=trim($("#customerId").val());
	$("#customerId").val(customerId);
	var orderNo=trim($("#orderNo").val());
	$("#orderNo").val(orderNo);
	var description=trim($("#description").val());
	$("#description").val(description);
	/*var definitionId=trim($("#definitionId").val());
	$("#definitionId").val(definitionId);
	
*/	var availableDate=trim($("#availableDate").val());
	$("#availableDate").val(availableDate);
	var expiryDate=trim($("#expiryDate").val());
	$("#expiryDate").val(expiryDate);
	 var thresholdDate=trim($("#thresholdDate").val());
	$("#thresholdDate").val(thresholdDate); 
	var totalQty=trim($("#totalQty").val());
	$("#totalQty").val(totalQty);
	
	var thresholdQty=trim($("#thresholdQty").val());
	$("#thresholdQty").val(thresholdQty);
	/*var drm=trim($("#drm").val());
	$("#drm").val(drm);
	 */

	
	if (subscriptionId == "") {
	
		$("#subscriptionIdError").css("display", "block");
		$("#subscriptionIdInvalidError").css("display", "none");
		$("#subscriptionIdMaxLengthError").css("display", "none");
		
		
		
		errorFound=true;
		} else if (isNaN(subscriptionId)) {
			$("#subscriptionIdInvalidError").css("display", "block");
			$("#subscriptionIdError").css("display", "none");
			$("#subscriptionIdMaxLengthError").css("display", "none");		
		
		errorFound=true;
		} else if (subscriptionId.length > 18) {
			$("#subscriptionIdMaxLengthError").css("display", "block");		
			$("#subscriptionIdInvalidError").css("display", "none");
			$("#subscriptionIdError").css("display", "none");
		
	
		errorFound=true;
	}
		 else{
			$("#subscriptionIdMaxLengthError").css("display", "none");		
			$("#subscriptionIdInvalidError").css("display", "none");
			$("#subscriptionIdError").css("display", "none");
		}
	 
	if (customerId == "" || customerId == 0) {
		
				
		$("#customerInvalidIdError").css("display", "none");
		$("#customerIdError").css("display", "block");
		$("#customerIdMaxLengthError").css("display", "none");
		$("#customerId").focus();
		errorFound=true;
		} else if (isNaN(customerId)) {
			
			$("#customerInvalidIdError").css("display","block");
			$("#customerIdError").css("display","none");	
			$("#customerIdMaxLengthError").css("display", "none");
			$("#customerId").focus();
		errorFound=true;
		} else if (customerId.length > 18) {
			$("#customerInvalidIdError").css("display", "none");
			$("#customerIdError").css("display", "none");	
			$("#customerIdMaxLengthError").css("display", "block");
			$("#customerId").focus();
		errorFound=true;
	}
		 else{
			$("#customerIdError").css("display", "none");		
			$("#customerInvalidIdError").css("display", "none");
			$("#customerIdMaxLengthError").css("display", "none");
		} 
	
	if (orderNo == "") {
		
		$("#orderNoError").css("display", "block");		
		$("#orderNoInvalidError").css("display", "none");
		$("#orderNoMaxLengthError").css("display", "none");
		$("#orderNo").focus();
		errorFound=true;
		} else if (!validateAlphaNumericAll(orderNo)) {
			$("#orderNoError").css("display", "none");		
			$("#orderNoInvalidError").css("display", "block");
			$("#orderNoMaxLengthError").css("display", "none");
			$("#orderNo").focus();
		errorFound=true;
		} else if (orderNo.length > 50) {
			$("#orderNoError").css("display", "none");		
			$("#orderNoInvalidError").css("display", "none");
			$("#orderNoMaxLengthError").css("display", "block");
			$("#orderNo").focus();
		errorFound=true;
	}
		 else{
			$("#orderNoError").css("display", "none");		
			$("#orderNoInvalidError").css("display", "none");
			$("#orderNoMaxLengthError").css("display", "none");
		
		} 
	

	
	/*if (description == "") {
		$("#descriptionError").text('<spring:message code="subscription.description.empty" />');
		errorFound=true;
	}
	else if (description == "" !validateAlphaNumericAllWithMore(description)) {
		$("#descriptionError").text('<spring:message code="subscription.description.invalid" />');
		errorFound=true;
	}
	else if (description.length > 5000) {
		$("#descriptionError").text('<spring:message code="subscription.description.maxLength" />');
		errorFound=true;
	}*/
	
	/*if (definitionId == "") {
		$("#definitionIdError").css("display", "block");		
		$("#definitionIdInvalidError").css("display", "none");
		$("#definitionIdMaxLengthError").css("display", "none");
		$("#definitionId").focus();
		errorFound=true;
		} else if (isNaN(definitionId)) {
			$("#definitionIdError").css("display", "none");		
			$("#definitionIdInvalidError").css("display", "block");
			$("#definitionIdMaxLengthError").css("display", "none");
			$("#definitionId").focus();
		errorFound=true;
		} else if (definitionId.length > 4) {
			$("#definitionIdError").css("display", "none");		
			$("#definitionIdInvalidError").css("display", "none");
			$("#definitionIdMaxLengthError").css("display", "block");
			$("#definitionId").focus();
		errorFound=true;
	}
		else{
			$("#definitionIdError").css("display", "none");		
			$("#definitionIdInvalidError").css("display", "none");
			$("#definitionIdMaxLengthError").css("display", "none");
		}
	
	*/
	if (availableDate == "") {
		$("#availableDateError").css("display", "block");		
		$("#availableDateFormatError").css("display", "none");
		$("#availableInvalidDateError").css("display", "none");
		$("#availableMaxLengthDateError").css("display", "none");
		$("#availableDate").focus();
		errorFound=true;
		} else if (availableDate.indexOf('/') < 0) {
			$("#availableDateError").css("display", "none");		
			$("#availableDateFormatError").css("display", "block");
			$("#availableInvalidDateError").css("display", "none");
			$("#availableMaxLengthDateError").css("display", "none");			
			$("#availableDate").focus();
		errorFound=true;
		} else if (!validateAlphaNumericAllWithMore(availableDate)) {
			$("#availableDateError").css("display", "none");		
			$("#availableDateFormatError").css("display", "none");
			$("#availableInvalidDateError").css("display", "block");
			$("#availableMaxLengthDateError").css("display", "none");
			$("#availableDate").focus();
		
		errorFound=true;
		} else if (availableDate.length > 50) {
		
		$("#availableDateError").css("display", "none");		
		$("#availableDateFormatError").css("display", "none");
		$("#availableInvalidDateError").css("display", "none");
		$("#availableMaxLengthDateError").css("display", "block");
		$("#availableDate").focus();
		errorFound=true;
	}
		else{
			$("#availableDateError").css("display", "none");		
			$("#availableDateFormatError").css("display", "none");
			$("#availableInvalidDateError").css("display", "none");
			$("#availableMaxLengthDateError").css("display", "none");
		}
	
	
	 if (thresholdDate == "") {
		
		$("#thresholdDateError").css("display", "block");
		$("#thresholdInvalidDateError").css("display", "none");
		$("#thresholdDateMaxLengthError").css("display", "none");
		$("#thresholdlessThanAvbDateError").css("display", "none");
		$("#thresholdgreaterThanExpError").css("display", "none");
		$("#thresholdDate").focus();
		errorFound=true;
	}

	else if (!validateAlphaNumericAllWithMore(thresholdDate)) {
		$("#thresholdDateError").css("display", "none");
		$("#thresholdInvalidDateError").css("display", "block");
		$("#thresholdDateMaxLengthError").css("display", "none");
		$("#thresholdlessThanAvbDateError").css("display", "none");
		$("#thresholdgreaterThanExpError").css("display", "none");
		$("#thresholdDate").focus();
		errorFound=true;
		} else if (thresholdDate.length > 50) {
			$("#thresholdDateError").css("display", "none");
			$("#thresholdInvalidDateError").css("display", "none");
			$("#thresholdDateMaxLengthError").css("display", "block");
			$("#thresholdlessThanAvbDateError").css("display", "none");
			$("#thresholdgreaterThanExpError").css("display", "none");
			$("#thresholdDate").focus();
		errorFound=true;
	}
	
		else{
			$("#thresholdDateError").css("display", "none");
			$("#thresholdInvalidDateError").css("display", "none");
			$("#thresholdDateMaxLengthError").css("display", "none");
			$("#thresholdlessThanAvbDateError").css("display", "none");
			$("#thresholdgreaterThanExpError").css("display", "none");
		}
	//add validation for threshold date and expiry date 
	if(validateThresholdAndExpiryDate(thresholdDate,availableDate,expiryDate,operation) == false){
		$("#thresholdDate").focus();
		errorFound=true;
	}
	
	
	
	
	if (totalQty == "") {
		$("#totalQtyError").css("display", "block");
		$("#totalQtyNumericError").css("display", "none");
		$("#totalQtyGTAccessCountError").css("display", "none");
		
		$("#totalQty").focus();
		errorFound=true;
		} else if (isNaN(totalQty)) {
			$("#totalQtyError").css("display", "none");
			$("#totalQtyNumericError").css("display", "block");
			$("#totalQtyGTAccessCountError").css("display", "none");
			$("#totalQty").focus();
		errorFound=true;
		} else {
		//threshold quantity should be less than or equal to defintion access count
		var accessCount=$("#accessCount");
		if(parseInt(totalQty) > parseInt(accessCount)){
			$("#totalQtyError").css("display", "none");
			$("#totalQtyNumericError").css("display", "none");
			$("#totalQtyGTAccessCountError").css("display", "block");
			$("#totalQty").focus();
			errorFound=true;
		}
	}
	  if($("#thresholddays").val().length == 0) {
		  $("#thresholdDateError").css("display", "block");
		  $("#thresholddays").focus();
			errorFound=true; 
	  }
	  else{
		  $("#thresholdDateError").css("display", "none");
	  }
	
	if (thresholdQty == "") {
		
		$("#thresholdQtyError").css("display", "block");
		$("#thresholdQtyNotNumericError").css("display", "none");
		$("#thresholdQtyMaxLengthError").css("display", "none");
		$("#thresholdQtyGTAccessCountError").css("display", "none");
		$("#thresholdQty").focus();
		errorFound=true;
		} else if (isNaN(thresholdQty)) {
			$("#thresholdQtyError").css("display", "none");
			$("#thresholdQtyNotNumericError").css("display", "block");
			$("#thresholdQtyMaxLengthError").css("display", "none");
			$("#thresholdQtyGTAccessCountError").css("display", "none");
			$("#thresholdQty").focus();
		errorFound=true;
		} else if (thresholdQty.length > 50) {		
		$("#thresholdQtyError").css("display", "none");
		$("#thresholdQtyNotNumericError").css("display", "none");
		$("#thresholdQtyMaxLengthError").css("display", "block");
		$("#thresholdQtyGTAccessCountError").css("display", "none");
		$("#thresholdQty").focus();
		errorFound=true;
	}else{
		//threshold quantity should be less than or equal to defintion access count
		var accessCount=$("#accessCount").val();
		if(parseInt(thresholdQty) > parseInt(totalQty)){

			$("#thresholdQtyError").css("display", "none");
			$("#thresholdQtyNotNumericError").css("display", "none");
			$("#thresholdQtyMaxLengthError").css("display", "none");
			$("#thresholdQtyGTAccessCountError").css("display", "block");
			$("#thresholdQty").focus();
			errorFound=true;
		}
	}
	
/*	if (drm == "") {
		$("#drmError").css("display", "block");
		$("#drmErrorInvalid").css("display", "none");
	
		errorFound=true;
		} else if (!(drm == 'Y' || drm == 'N')) {
			$("#drmError").css("display", "none");
			$("#drmErrorInvalid").css("display", "block");
		errorFound=true;
	}
	*/
	//add condition that whether any article has been added or not 
	var articleDataItems=$(".sorting_1");
	var articleDataItems1=$(".articleData");
	if(articleDataItems.length){
		//alert('Number of articles added:'+articleDataItems.length);
	}else{
			if (articleDataItems1.length) {
			
			} else {
				$("#articleDataError").css("display", "block");
		
		errorFound=true;
			}
	}
	
	if(errorFound){
		$("#addSubscription").prop('disabled', false);
		$("#editSubscription").prop('disabled', false);
		return false;
	}
	
	//Now submit the form
	if( operation == 'SAVE'){
		$("#subscriptionForm").attr("action", "saveSubscription");
		} else if (operation == 'EDIT') {
		$("#subscriptionForm").attr("action", "updateSubscription");
	}
	$("#subscriptionForm").submit();
}
function checkSubscriptionArticle(obj) {
	var articleDataItems = $(".sorting_1");
	var articleDataItems1 = $(".articleData");
	if (articleDataItems.length) {
		//	alert('Number of articles added:'+articleDataItems.length);
	} else {
		if (articleDataItems1.length) {

		} else {
			$(obj).removeAttr("data-toggle");
			
			$("#articleDataError").css("display","block");
			return false
		}
	}
}
function saveArticle(method) {
	
	//clearAllErrorMessagesForArticle();
	

	var identifier = trim($("#identifier").val());
	$("#identifier").val(identifier);
	
	var errorFound=false;

	
	

	

	if (identifier.trim() == "") {
		$("#identifierError").css("display", "block");
		$("#identifierInvalidError").css("display", "none");	
		$("#identifierDuplicateError").css("display", "none");	
	
		if(!errorFound){
			$("#identifier").focus();
		}
		errorFound=true;
		} else if (!validateAlphaNumericAllWithMore(identifier)) {
			$("#identifierError").css("display", "none");
			$("#identifierInvalidError").css("display", "block");	
			$("#identifierDuplicateError").css("display", "none");	
			
		
		if(!errorFound){
			$("#identifier").focus();
		}
		errorFound=true;
	}
	
		else if(!validateDOI(identifier)) {
			$("#identifierError").css("display", "none");
			$("#identifierInvalidError").css("display", "block");	
			$("#identifierDuplicateError").css("display", "none");	

		if(!errorFound){
			$("#identifier").focus();
		}
		errorFound=true;
	}
	
		else{
			$("#identifierError").css("display", "none");
			$("#identifierInvalidError").css("display", "none");	
			$("#identifierDuplicateError").css("display", "none");	
			errorFound=false;
		}
	
	
	/*else{
		$articleDOI = $("#identifier").val();
			$.ajax({ url : "checkDOIExist?articleDOI=" + $articleDOI, async : false, success : function(result) {
				if(result == true){							
					$("#identifierError").css("display", "none");
					$("#identifierInvalidError").css("display", "none");	
					$("#identifierDuplicateError").css("display", "block");						
					$("#identifier").focus();
					
					errorFound=true;
					 
				}
			} });
			}*/
	 var input = document.getElementById('file1');
	 var fileName=$('#file1').val();
	
	 if(input.files.length == 0){
		 $("#fileError").css("display","block");
			$("#file1Error").css("display","none");
			   $("#file2Error").css("display","none");
			 $("#file1").focus();
	   		errorFound=true;
	 }
	 
	 if (input && input.files && input.files[0]) {
		 var fileMaxSize = document.getElementById("fileMaxSize").innerText;
	   	var size=input.files[0].size;
	    var ext = fileName.split('.').pop();
	//    var ext = filename.split('.').pop().toLowerCase();
        if($.inArray(ext, ['pdf']) == -1) {
        	$("#file2Error").css("display","block");
        	 $("#fileError").css("display","none");  	   	   
  	   		$("#file1Error").css("display","none");
	   		$("#file1").focus();
	   		errorFound=true;
           
        }
	    
	   /*  if(ext!='pdf')
	    	$("#file2Error").text('<spring:message code="article.file.extension.error" />');
   		errorFound=true; */
	   	if(parseInt(size) > parseInt(fileMaxSize)){
	   	 $("#fileError").css("display","none");
	   	   $("#file2Error").css("display","none");
	   		$("#file1Error").css("display","block");
	   		$("#file1").focus();
	   		errorFound=true;
	   	}
	   
	 }
	if(errorFound){
		return false;
	}
	
	//limit for cover page
	 var coverPage = document.getElementById('coverPage');
	
	 
	
	
	 
	 if (coverPage && coverPage.files && coverPage.files[0]) {
		 var coverPageName=$('#coverPage').val();
			
		 var fileMaxSize = document.getElementById("fileMaxSize").innerText;
	   	var size=coverPage.files[0].size;
	    var ext = coverPageName.split('.').pop();
	    
	    if($.inArray(ext, ['pdf']) == -1) {
        	$("#coverPageError1").css("display","block");
        	 $("#coverPageError").css("display","none");  		   
  	   		
  	     	$("#coverPage").focus();
	   		errorFound=true;
           
        }
	   /*  if(ext!='pdf')
	    	$("#file1Error").text('<spring:message code="article.file.extension.error" />');
   		errorFound=true; */
	   	if(parseInt(size) > parseInt(fileMaxSize)){
	   		$("#coverPageError").css("display","block");
	   	    $("#coverPageError1").css("display","none");  	
	   		$("#coverPage").focus();
	   		errorFound=true;
	   	}
	   	
	 }
	if(errorFound){
		return false;
	}
	
	
	
	
	//Populate hidden field subscription_id of create article from subscriptionId of create subscription for saving
	var subscriptionId=trim($("#subscriptionId").val());
	$("#subscription_id").val(subscriptionId);
	
	//submit the form using ajax
	var form=$("#createUpdateArticleForm")[0];
	 
	var data = new FormData(form);
	$("#submit").prop('disabled', true);
		$.ajax({ url : 'saveArticle', type : 'POST', enctype: 'multipart/form-data',   processData: false,
            contentType: false,
           data : data, success : function(result) {
                var obj = JSON.parse(result);
                if(obj.articleId !=null){
                	//alert('<spring:message code="articleCreation.successMessage"/>');
                	 var articleSuccessMsg = document.getElementById("articleSuccess").innerText;
                	 displayMessage(articleSuccessMsg);
                	//remove the error if any for article add
                	$("#articleDataError").text("");
                	var subscriptionId=$("#subscriptionId").val();
                	tbForReview.ajax.reload();
                	//call ajax and get json data and set data
				$.ajax({ url : 'fetchSubscriptionArticle', type : 'GET', data : { "subscriptionId" : subscriptionId }, success : function(result) {
                    	  setArticleData(result);
                         //finally close the modal window
                     	 $("#createArticleModal").modal("hide");
				} });
                	                    	
                }else{
                	var articleFailureMsg = document.getElementById("articleFailure").innerText;
                	alert(articleFailureMsg);
                }
		} });
	
}
function changeFileName(fileId) {
	var filename = $("#" + fileId).val();
	var lastIndex = filename.lastIndexOf("\\");
	if (lastIndex >= 0) {
		filename = filename.substring(lastIndex + 1);
	}
	
}
function deleteSubscriptionArticle(){
	var articleId=$("#deleteArticleId").val();
	var subArticleId=$("#deleteSubArticleId").val();
	
//	 console.log( tbForReview.row( this ).data() );
	if(articleId !=null && subArticleId != null){
		//submit the form using ajax
		$.ajax({ 
			url : 'deleteSubscriptionArticle', 
			type : 'POST', 
			data : { "subArticleId" : subArticleId, "articleId" : articleId}, 
			success : function(result) {
                   var obj = JSON.parse(result);
                   if(obj.status !=null && obj.status == 'deleted'){
                 var subscriptionArticleRemovalSuccessMsg = document.getElementById("subscriptionArticleRemovalSuccess").innerText;
                   	displayMessage(subscriptionArticleRemovalSuccessMsg);
                   	
                   	//now remove the row
                   	//var parent = document.getElementById("subscriptionArticleTableBody");
                   	//var child = document.getElementById("tr"+articleId);
                   	//parent.removeChild(child);
                   	tbForReview.ajax.reload();
                   }else{
                	   var subscriptionArticleRemovalFailureMsg = document.getElementById("subscriptionArticleRemovalFailure").innerText;
                   	displayMessage(subscriptionArticleRemovalFailureMsg);
                   }
			} 
		});
	}
}

function addExistingArticles(){
	var selectedArticles=rows_selected.join("_"); 
	  //alert('in addExistingArticles():');
	  /* var selectedArticles="";
	  for(var i=0; i<rows_selected.length; i++){
	        if(inputElements[i].checked){
	        	selectedArticles=selectedArticles+inputElements[i].value+"_";
	        }
	  } */
	  
	  if(selectedArticles.length > 0){
		  	//alert('selectedArticles'+selectedArticles);
		  	var subscriptionId=trim($("#subscriptionId").val());
		  	$("#subscription_id").val(subscriptionId);
		  	//submit the form using ajax
 			$("#addExistingArticleBtn").prop('disabled', true);
			$.ajax({ 
				url : 'addExistingArticles', 
				type : 'POST', 
				data : { "subscriptionId" : subscriptionId, "selectedArticles" : selectedArticles }, 
				success : function(result) {
                	var obj = JSON.parse(result);
                    if(obj.status !=null && obj.status == 'success'){
                    	//alert('<spring:message code="articleCreation.successMessage"/>');
                    	 var articlesAddedMsg = document.getElementById("articlesAdded").innerText;
                    	 displayMessage(articlesAddedMsg);
                    	//remove the error if any for article add
                    	$("#existingArticleErrorMessage").css("display","none");                    	
                    	$("#articleDataError").css("display","none");
                    	tbForReview.ajax.reload();
              	 
                    	//call ajax and get json data and set data
						$.ajax({ 
							url : 'fetchSubscriptionArticle', 
							type : 'GET', 
							data : { "subscriptionId" : subscriptionId }, 
							success : function(result) {
			                    	  setArticleData(result);
			                    	  refreshExistingArticleSearchForm();
			                         //finally close the modal window for add existing article modal 
			                     	 $("#addExistingArticleModal").modal("hide");
							} 
						});
	                    	                    	
                    }else{
                    	 var articleAddFailureMsg = document.getElementById("articleAddFailure").innerText;
                    	
                    	displayMessage(articleAddFailureMsg);
                    }
			} });
	  }else{
		  $('#existingArticleErrorMessage').css("display","block");
	  }
}
	
function validateThresholdAndExpiryDate(thresholdDate, availableDate, expiryDate, operation){
	var errorFound=false;
	var avbDate=null;
	var expDate=null;
	var thDate=null;
	if(availableDate.indexOf('/') > -1 && expiryDate.indexOf('/') > -1 && thresholdDate.indexOf('/') > -1){
			var avbDateArr=availableDate.split('/');
			avbDate=new Date(avbDateArr[2], avbDateArr[0]-1, avbDateArr[1]);
			var expDateArr=expiryDate.split('/');
			expDate=new Date(expDateArr[2], expDateArr[0]-1, expDateArr[1]);
			var thDateArr=thresholdDate.split('/');
			thDate=new Date(thDateArr[2],thDateArr[0]-1, thDateArr[1]);
			
			//avbDate should be greater than current date
			var today=new Date();
			var currentDate=new Date(today.getFullYear(),today.getMonth(),today.getDate());
			if(avbDate < currentDate && operation != 'EDIT'){
				$("#availableDateError").css("display", "none");		
				$("#availableDateFormatError").css("display", "none");
				$("#availableInvalidDateError").css("display", "none");
				$("#availableMaxLengthDateError").css("display", "none");
				$("#availableDatelessThanNowError").css("display","block");
				
				errorFound=true;
			}
			
			//expiry date should be greater than available date
			if(expDate < avbDate){
				$("#expiryDateError").css("display","block");
				errorFound=true;
			}
			
			//threshold date should be greater than available date and less than expiry date
			if(thDate.getTime() < avbDate.getTime()){
				$("#thresholdDateError").css("display", "none");
				$("#thresholdInvalidDateError").css("display", "none");
				$("#thresholdDateMaxLengthError").css("display", "none");
				$("#thresholdlessThanAvbDateError").css("display", "block");
				$("#thresholdgreaterThanExpError").css("display", "none");
				
				errorFound=true;
			} else if (thDate.getTime() > expDate.getTime()) {
				$("#thresholdDateError").css("display", "none");
				$("#thresholdInvalidDateError").css("display", "none");
				$("#thresholdDateMaxLengthError").css("display", "none");
				$("#thresholdlessThanAvbDateError").css("display", "none");
				$("#thresholdgreaterThanExpError").css("display", "block");
				
				
				errorFound=true;
			}
	 }
	 
	if(errorFound){
		 return false;
	}
	
	return true;
}

function exportArticle(fileType) {
	var subscriptionId=$("#subscriptionId").val();
	window.location.href='/exportSubscriptionArticles/?subscriptionId='+subscriptionId+'&fileType='+fileType;
}




function formatDate(date) {
	var month = date.getMonth();
	month = month + 1; // javascript date goes from 0 to 11
	if (month < 10) {
		month = "0" + month; // adding the prefix
	}

	var year = date.getFullYear();
	var day = date.getDate();
	if (day < 10)
		day = "0" + day; // adding the prefix
	var hour = date.getHours();
	var timezone = "am";
	if (hour >= 12) {
		timezone = "pm";
		hour = hour - 12;
		if (hour < 10)
			hour = "0" + hour; // adding the prefix
	}
	var minutes = date.getMinutes();
	if (minutes < 10)
		minutes = "0" + minutes;
	return month + "/" + day + "/" + year
}