<!DOCTYPE HTML>
<%@ include file="/common/taglibs.jsp"%>
<%@ include file="/common/meta.jsp"%>
<html>
<head>
<meta charset="utf-8">
<title>Think Utility | Login</title>

</head>
<body id="login">
	<div class="container-fluid">
		<section class="container ">
			<div class="row justify-content-md-center">
				<div class="col-md-6 my-2">
					<div class="loginBox border p-4 mb-5">
						<h4 class="loginHeading border-b">
							Think Utility
							- Login
						</h4>
						<c:if test="${param.error != null}">
							<div  id="login-error" class="alert alert-danger in">Invalid Credentials</div>
						</c:if>
						<c:if test="${not empty message}">
							<div id="recovery-email-success" style="color: red; align: center;">${message}</div>
						</c:if>
						
						<form:form method="POST" modelAttribute="loginModel" action="dynamicRenewalCodes" id="dynamicRenewalCodeForm">
							<div class="form-group">
								<label for="username">Email</label> <form:input path = "username" type="text" name="username" class="form-control"/>
							</div>
							<div class="form-group mt-4">
								<label for="password">Password</label> <form:input path = "password" type="password" name="password" class="form-control"/>
							</div>
								 <form:select path="dsn" class="form-control">
								 <form:option value = ""  label = "Select DSN"></form:option>
								 <form:option value = "QADB-Local" label = "QADB-Local"></form:option>
								 </form:select>
							<div class="form-group clearfix mt-4">
								<button type="submit" class="btn btn-success float-right btn-danger" name="login" tabindex="3">
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
</html>
