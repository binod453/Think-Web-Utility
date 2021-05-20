<%@ include file="/common/taglibs.jsp"%>
<%@ include file="/common/meta.jsp"%>
<title> Dynamic Pricing Codes </title>

<script src="<c:url value='/resources/js/renewalCodes.js'/>"></script>
<div class="col-md-12">
	<h3 class="mainHeading">
	</h3>
<%@ include file="/common/header.jsp"%>
</div>
	<div class="container-fluid mt-5">
		<div  class="pt-3"> 
			<div class="whiteBg ">
				<div class="mt-4 row">
				<div class="col-sm-12 text-right">
					
				
				<button type="button" class="btn btn-dark btn-sm" id="addNew"><em class="fa fa-plus"></em> Add New</button>
				
				</div>
				<div class="col-sm-12  mt-3">
					<table class="table table-bordered  table-striped   mt-4" id="dynamicRenewalCodesTable">
					<caption></caption>
						<thead>
							<tr>
								<th id="slNo">Dynamic Code ID</th>
								<th id="dynamic_code">Dynamic Code</th>
								<th id="description">Description</th>
								<th id="status">Status</th>
								<th id="action">Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${codeModelList}" var="dynamicCodeList" varStatus="counter">
								<tr>
									<td id="dynamic_price_id"><c:out value="${dynamicCodeList.dynamic_price_id}" /></td>
									<td id="dynamic_price_name"><c:out value="${dynamicCodeList.dynamic_price_name}" /></td>
									<td id="description"><c:out value="${dynamicCodeList.description}" /></td>
									<td id="status">
										<c:choose>
										    <c:when test="${dynamicCodeList.isactive == '1'}">
										        Active
										    </c:when>
										    <c:otherwise>
										        In-Active
										    </c:otherwise>
										</c:choose>	
									</td>
									<input type="hidden" id="dynamic_price_id" value="${dynamicCodeList.dynamic_price_id}"/>
									<td><a href=# class='btn' id="editCode" title='Edit'><em class='fa fa-edit'></em></a></td>
									
								</tr>
							</c:forEach>
						</tbody>
				</table>
				</div>
				</div>
			</div>
		</div>
		
		
	</div>
	
	<!-- Add-Modal -->
<div class="modal fade" id="addNewModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
<div class="pageloader">
   <img src="http://cdnjs.cloudflare.com/ajax/libs/semantic-ui/0.16.1/images/loader-large.gif" alt="processing..." />
</div>
    <div class="modal-dialog " style="max-width: 80%;">
        <div class="modal-content">
            <div class="modal-header">
             <h4 class="modal-title" id="myModalLabel">Create Dynamic Pricing Code</h4>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            </div>
            <div class="modal-body">
            	 <form:form method="POST" modelAttribute="dynamicRenewalCodeModel" action="addNewRenewalCode" id="addNewRenewalCodeForm">
					<fieldset>
						<div class="form-group row">
							<label for="dynamicRenewalCode" class="col-sm-4 col-form-label required-field">Dynamic Pricing Code </label>
							<div class="col-sm-8">
								<form:input path = "dynamicCode" type="text" class="form-control" id="dynamicRenewalCode" onfocusout="checkRenewalCode(this)"/>
							</div>
							<div class="col-sm-12 textError" id="errorDiv1"></div>
						</div>
						<div class="form-group row">
							<label for="description" class="col-sm-4 col-form-label">Description</label>
							<div class="col-sm-8">
								<form:input path = "description" type="text" class="form-control" id="description"/>
							</div>
						</div>
						<div class="form-group row">
						 <label class="col-sm-4 col-form-label" for="exampleCheck1">Status</label>
							<div class="col-sm-8">
								<input type="checkbox" data-toggle="toggle" id="toggle-event" data-on="Active" data-off="In-Active">
								<form:input path="isActive" type="hidden" id="isActive"/>
							</div>
						</div>
						<div class="table-responsive">
					<table class="table table-bordered  table-striped mt-4" id="tableForInstallment">
					<caption></caption>
						<thead>
							<tr>
								<th id="add_from_cycle">From Cycle</th>
								<th id="add_to_cycle">To Cycle</th>
								<th id="add_type">Type</th>
								<th id="add_value">Value</th>
								<th id="add_currency">Currency</th>
								<th id="add_action">Action</th>
							</tr>
						</thead>
						<tbody id="tbodyContainer">
							
						</tbody>
					</table>
					</div>
					<div class="col-sm-12 textError" id="errorDiv2"></div>
					
					</fieldset>
				</form:form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default reset-btn" data-dismiss="modal"  id="cancelAddNewCode">Cancel</button>
                <button type="button" class="btn btn-primary" onclick="addNewRenewalCodeForm()" id="saveNewCode" disabled>Save changes</button>
            </div>
        </div>
    </div>
</div>

<!-- Edit Modal -->

<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
<div class="pageloader">
   <img src="http://cdnjs.cloudflare.com/ajax/libs/semantic-ui/0.16.1/images/loader-large.gif" alt="processing..." />
</div>
    <div class="modal-dialog " style="max-width: 80%;">
        <div class="modal-content">
            <div class="modal-header">
             <h4 class="modal-title" id="myModalLabel">Edit Dynamic Pricing Code</h4>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true" id="close">&times;</button>
            </div>
            <div class="modal-body">
            	 <form:form method="POST" modelAttribute="dynamicRenewalCodeModel" action="saveUpdatedRenewalCode" id="updateRenewalCodeForm">
					<fieldset>
					
						<div class="form-group row">
							<label for="dynamicRenewalCode" class="col-sm-4 col-form-label required-field">Dynamic Pricing Code</label>
							<div class="col-sm-8">
								<form:input path = "dynamicCode" type="text" class="form-control" id="editDynamicRenewalCode"/>
							</div>
						</div>
						<div class="form-group row">
							<label for="description" class="col-sm-4 col-form-label">Description</label>
							<div class="col-sm-8">
								<form:input path = "description" type="text" class="form-control" id="editDescription" />
							</div>
						</div>
						<div class="form-group row">
						 <label class="col-sm-4 col-form-label" for="is_active_edit">Status</label>
							<div class="col-sm-8">
								<input type="checkbox" data-toggle="toggle" id="toggle-event-edit" data-on="Active" data-off="In-Active">
								<form:input path="isActive" type="hidden" id="isActiveEdit"/>
							</div>
						</div>
					<div class="table-responsive">
					<table class="table table-bordered  table-striped mt-4" id="editTable">
					<caption></caption>
						<thead>
							<tr>
								<th id="edit_from_cycle">From Cycle</th>
								<th id="edit_to_cycle">To Cycle</th>
								<th id="edit_type" style="width: 20%;">Type</th>
								<th id="edit_value">Value</th>
								<th id="edit_currency">Currency</th>
							</tr>
						</thead>
						<tbody id="editTableBody">
						</tbody>
					</table>
					</div>
					<div class="col-sm-12 textError" id="errorDiv3"></div>
					</fieldset>
				</form:form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal"  id="cancelCode">Cancel</button>
                <button type="button" class="btn btn-primary" onclick="updateRenewalCodeForm()" id="updateCode">Save changes</button>
            </div>
        </div>
    </div>
</div>


<c:if test="${not empty priceNameList}">
	<input type="hidden" id="priceNameList" value="${priceNameList}"/>
</c:if>

