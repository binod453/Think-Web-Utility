<!DOCTYPE HTML>
<%@ include file="/common/taglibs.jsp"%>
<%@ include file="/common/meta.jsp"%>
<html>
<head>
<meta charset="utf-8">
<title>Think Utility | Login</title>

</head>
<body id="login">
<div class="" id="loading">
  <div class="spinner-border" role="status">
    <span class="sr-only">Loading...</span>
  </div>
</div>
	<div class="container-fluid">
		<section class="container ">
			<div class="row justify-content-md-center">
				<div class="col-md-6 my-2">
					<div class="loginBox border p-4 mb-5">
						<h4 class="border-b text-center">
							Think Utility
							- Login
						</h4>
						<c:if test="${not empty message}">
							<div class="alert alert-danger alert-dismissible fade show" id="invalid-login" style="color: red;"><strong>${message}</strong></div>
						</c:if>
						
						<form:form method="POST" modelAttribute="loginModel" action="dynamicRenewalCodes" id="dynamicRenewalCodeForm">
							<div class="form-group">
								<label for="username">Username</label> <form:input path = "username" type="text" name="username" class="form-control" required="required"/>
							</div>
							<form:errors path="username" cssClass="error" />
							<div class="form-group mt-4">
								<label for="password">Password</label> <form:input path = "password" type="password" name="password" class="form-control" required="required"/>
							</div>
							<form:errors path="password" cssClass="error" />
								 <form:select path="dsn" class="form-control" required="required">
									 <form:option value = ""  label = "Select DSN"></form:option>
									 <form:option value = "QADB-Local" label = "QADB-Local"></form:option>
								 </form:select>
								 <form:errors path="dsn" cssClass="error" />
							
							<div class="form-group mt-4 row">	 
								<div class="form-group mb-2 col">
								    <input type="text" class="form-control" id="ipAddress" name="ipAddress"  placeholder="SLAP IPAddress" required="required" onfocus="removeMessege()" onfocusout = "ValidateIPaddress(this)" onkeypress="return event.charCode >= 46 && event.charCode <= 57 && event.charCode != 47"  >
								 	<div class="" id="errorDiv" style="color: red;"></div>
								 </div>
								 
								 <div class="form-group mb-2 col">
								    <input type="text" class="form-control" id="port" name="port" placeholder="Port" required="required" onkeypress="return event.charCode >= 48 && event.charCode <= 57">
								 </div>
							</div>
							<div class="form-group clearfix mt-4">
								<button type="submit" class="btn float-right btn-primary" name="login" tabindex="3">
									Login <i class="fa fa-arrow-right" aria-hidden="true"></i>
								</button>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</section>
	</div>
	
</body>
<script type="text/javascript">
$(window).load(function() {
    $('#loading').hide();
  });
  
$('#invalid-login').delay(3000).fadeOut();

var ipformat = /^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$/;

function ValidateIPaddress(inputText){
	if(inputText.value.match(ipformat))
	 {
	 $('#ipAddress').removeClass("error");
	 var ip = inputText.value.split(".");
		if (ip.length != 4) {
			 $('#errorDiv').text('Invalid SLAP IPAddress');
			$('#ipAddress').addClass("error");
			$('#ipAddress').val('');
		}
	 }else{
		 $('#errorDiv').text('Invalid SLAP IPAddress');
		$('#ipAddress').addClass("error");
		$('#ipAddress').val('');
	 }
}
function removeMessege(){
	$('#errorDiv').text('');
}

 $(document).on("click", "login", function(){
	 debugger
	 $('#loading').show();
}); 
</script>
</html>
