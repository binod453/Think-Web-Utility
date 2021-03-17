
		
	
	function confirmApprove(articleId) {
		$("#acceptRejectForm").attr("action", "approveArticle")
		$("#articleId").val(articleId);
		$("#approveArticleModal").modal();
	}

	
	function confirmAssignToCustomer(articleId) {
		$("#assignReviewArticleId").val(articleId);
		// first clean the error
		$("#assignReviewFile1Error").text('');
		$("#assignReviewfile").text('');
		$("#assignReviewCommentError").text('');
		$("#assignReviewToError").text('');
		$("#assignReviewToEmail").val('');
		$("#assignReviewCcEmail").val('');
		 $.ajax({
			  method: "POST",
			  url: "getReviewData?articleId="+articleId,async : false,
			  success: function(data){
				  CKEDITOR.instances.assignReviewComment.setData(data);
				  setTimeout(function(){
					 var editor=CKEDITOR.instances.assignReviewComment;
					 var height= $("#cke_assignReviewComment").find(".cke_wysiwyg_frame").contents().find("body").innerHeight();
					 height=height+50;
					 
					 editor.resize(editor.config.width, height, true, false);
				  }, 200);
				  
			   }
			  });
		$("#assignReviewTaskModal").modal();
	}
	function approve() {
		$("#acceptRejectForm").submit();
	}

	function sendEmailAndAssignArticleReview() {
		var sendButton = document.getElementById("sendAssignReviewButton");
		var cancelButton = document.getElementById("cancelAssignReviewButton");
		$("#assignReviewFile1Error").text('');
		$("#assignReviewfile").text('');
		$("#assignReviewCommentError").text('');
		$("#assignReviewToError").text('');

		var toEmail = $("#assignReviewToEmail").val();
		var CcEMail = $("#assignReviewCcEmail").val();
		sendButton.disabled = true;
		cancelButton.disabled = true;
		var fileAttached = false;

	// var fileMaxSize = <spring:message code="file.maxSize"/>;
		var errorFound = false;
		var comment = CKEDITOR.instances.assignReviewComment.getData();
		comment = trim(comment);
		if (comment == '' || isBlankField(comment)) {
			$("#assignReviewCommentError").text('Comment should not be empty.');
			errorFound = true;
		}
		if (toEmail == '' || isBlankField(toEmail)) {
			$("#assignReviewToError").text('To email should not be empty.');
			errorFound = true;
		} else if (!isValidEmail(toEmail)) {
			$("#assignReviewToError").text('Invalid email.');
		}
		// file size check if any and change action according to it
	/*
	 * var input = document.getElementById('assignReviewfile'); if (input &&
	 * input.files && input.files[0]) { var size = input.files[0].size; if
	 * (parseInt(size) > parseInt(fileMaxSize)) {
	 * $("#assignReviewFile1Error").text('<spring:message
	 * code="file.size.limit.exceeded" />'); errorFound = true; } fileAttached =
	 * true; } else { fileAttached = false; }
	 */

		if (errorFound) {
			sendButton.disabled = false;
			cancelButton.disabled = false;
			return;
		}
		$("#assignReviewComment").val(comment);
		// now submit the form
		$("#assignReviewForm").attr("action", "assignArticleReviewToCustomer")
		$("#assignReviewForm").submit();
	}
	
	function sendEmailAndRejectArticle(articleId) {
		var sendButton = document.getElementById("sendButton");
		var cancelButton = document.getElementById("cancelButton");
		sendButton.disabled = true;
		cancelButton.disabled = true;
		// alert('in sendEmailAndRejectArticle');
		var fileAttached = false;
		// first clean the error
		$("#file1Error").text('');
		$("#commentError").text('');
		var fileMaxSize = '25MB';
		var errorFound = false;
		
		var comment = CKEDITOR.instances.comment.getData();
		comment = trim(comment);

		if (comment == '') {
			$("#commentError").text('Comment should not be empty.');
			errorFound = true;
		}

		if (isBlankField(comment)) {
			$("#commentError").text('Comment should not be empty.');
			errorFound = true;
		}

		/// /file size check if any and change action according to it
	var input = document.getElementById('file1');
		if (input && input.files && input.files[0]) {
			var size = input.files[0].size;
			if (parseInt(size) > parseInt(fileMaxSize)) {
				$("#file1Error").text('Maximum size limit exceeded');
				errorFound = true;
			}
			fileAttached = true;
		} else {
			fileAttached = false;
		}

		if (errorFound) {
			sendButton.disabled = false;
			cancelButton.disabled = false;
			return;
		}

		
		$("#rejectArticleForm").attr("action", "rejectArticle");
		$("#rejectArticleForm").attr("enctype", "multipart/form-data");
		

		$("#comment").val(comment);
		$("#rejectArticleId").val(articleId);
		/// /now submit the form
	$("#rejectArticleForm").submit();
	}

	function changeFileName(fileId) {
		var filename = $("#" + fileId).val();
		var lastIndex = filename.lastIndexOf("\\");
		if (lastIndex >= 0) {
			filename = filename.substring(lastIndex + 1);
		}
		document.getElementById(fileId + "Display").innerHTML = filename;
	}