<%@ include file="/common/taglibs.jsp"%>
<%@ include file="/common/meta.jsp"%>
<title> Dynamic Renewal Codes </title>

<script src="<c:url value='/resources/js/datatables/dataTables.bootstrap4.min.js'/>"></script>
<script src="<c:url value='/resources/js/datatables/jquery.dataTables.min.js'/>"></script>
<script src="<c:url value='/resources/js/renewalCodes.js'/>"></script>

<!-- Alert -->
<div class="alert alert-success alert-dismissible fade show customErrorMsg" role="alert" id="greenAlert" style="display:none">
   <span id="alertMessage"></span>
  <button type="button" class="close"  aria-label="Close" onclick="$('#greenAlert').hide();">
    <span aria-hidden="true">&times;</span>
  </button>
</div>

<div class="col-md-12">
	<h3 class="mainHeading">
	</h3>
<%@ include file="/common/header.jsp"%>
</div>
	<div class="tab-content">
		<div id="tab1" class="tab-pane fade show active "> 
			<div class="whiteBg tabContent">
				<div class=" clearfix"></div>
				<div class="col-sm-12 ">
					<hr>
				</div>
				<div class="col-sm-12 p-0 mt-3">
					<table class="table table-bordered  table-striped   mt-4" id="dynamicRenewalCodesTable">
						<thead>
							<tr>
								<th>Sl No</th>
								<th>Dynamic Code</th>
								<th>Type</th>
								<th>Description</th>
								<th>Active From</th>
								<th>Active To</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${sessionScope.dynamicPriceSelectResponseList}" var="dynamicCodeList">
								<tr>
									<td><c:out value="${dynamicCodeList.dynamic_price_id}" /></td>
									<td><c:out value="${dynamicCodeList.dynamic_price_name}" /></td>
									<td></td>
									<td><c:out value="${dynamicCodeList.description}" /></td>
									<td></td>
									<td></td>
									<td><a href=# class='btn btn-outline-secondary table-btn' id="editCode" title='Edit'><i class='fa fa-edit'></i></a></td>
								</tr>
							</c:forEach>
						</tbody>
				</table>
				</div>
			</div>
		</div>
		
		<button type="button" class="btn btn-primary btn-lg btn-block" id="addNew">Click to Add New</button>
	</div>
	
	<!-- Modal -->
<div class="modal fade" id="addNewModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog " style="max-width: 80%;">
        <div class="modal-content">
            <div class="modal-header">
             <h4 class="modal-title" id="myModalLabel">Create Dynamic Renewal Code</h4>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            </div>
            <div class="modal-body">
            	 <form:form method="POST" modelAttribute="dynamicRenewalCodeModel" action="addNewRenewalCode" id="addNewRenewalCodeForm">
					<fieldset>
						<div class="form-group row">
							<label for="dynamicRenewalCode" class="col-sm-8 col-form-label">Please Enter Dynamic Renewal Code</label>
							<div class="col-sm-4">
								<form:input path = "dynamicCode" type="text" class="form-control" id="dynamicRenewalCode" />
							</div>
						</div>
						<div class="form-group row">
							<label for="description" class="col-sm-4 col-form-label">Description</label>
							<div class="col-sm-8">
								<form:input path = "description" type="text" class="form-control" id="description" />
							</div>
						</div>
						<fieldset class="form-group">
						    <div class="row">
						      <legend class="col-form-label col-sm-4 pt-0">Offer Type</legend>
						      <div class="col-sm-8">
						        <div class="form-check">
						          <form:radiobutton path = "offerType" class="form-check-input" name="offerTypeRadios" id="fixed" value="option1"/>
						          <label class="form-check-label" for="fixed">
						            Fixed
						          </label>
						        </div>
						        <div class="form-check">
						          <form:radiobutton path = "offerType" class="form-check-input" name="offerTypeRadios" id="installment" value="option2"/>
						          <label class="form-check-label" for="installment">
						           	Installment
						          </label>
						        </div>
						      </div>
						    </div>
					  </fieldset>
					  <div class="form-group row">
					  <label for="activePeriod" class="col-2 col-form-label">Active Period</label>
					  <div class="col-4">
					    <form:input path = "activeFrom" class="form-control" type="date" id="activeFrom"/>
					  </div>
					  <div class="col-4">
					    <form:input path = "activeTo" class="form-control" type="date" id="activeTo"/>
					  </div>
					</div>
					<table class="table table-bordered  table-striped mt-4" id="tableForFixed" style='display:none'>
						<thead>
							<tr>
								<th style="width: 20%;">From Cycle</th>
								<th style="width: 20%;">To Cycle</th>
								<th style="width: 20%;">Value</th>
								<th style="width: 40%;">Type</th>
								<th style="width: 20%;">Currency</th>
								<!-- <th style="width: 20%;">Action</th> -->
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><form:input path = "renewalCodeDataDetails.fromCycle" type="text" name="fromCycle" class="form-control"/></td>
								<td><form:input path = "renewalCodeDataDetails.toCycle" type="text" name="toCycle" class="form-control"/></td>
								<td><form:input path = "renewalCodeDataDetails.value" type="text" name="value" class="form-control"/></td>
								<td><form:select path="renewalCodeDataDetails.type" class="form-control" name="type">
								    <form:option value = "Percentage"  label = "Percentage" id="percentageType"></form:option>
								    <form:option value = "Amount" label = "Amount" id="AmountType"></form:option>
								 </form:select></td>
								<td><form:input path = "renewalCodeDataDetails.currency" type="text" name="currency" class="form-control" id="currency"/></td>
								<!-- <td><a href=# class='btn btn-outline-secondary table-btn' id="editCode" title='Edit Renewal Code'><i class='fa fa-edit'></i></a></td> -->
							</tr>
						</tbody>
					</table>
					
					<table class="table table-bordered  table-striped mt-4" id="tableForInstallment" style='display:none'>
						<thead>
							<tr>
								<th style="width: 20%;">From Cycle</th>
								<th style="width: 20%;">To Cycle</th>
								<th style="width: 20%;">Value</th>
								<th style="width: 30%;">Type</th>
								<th style="width: 20%;">Currency</th>
								<th style="width: 20%;">Action</th>
							</tr>
						</thead>
						<tbody>
								<tr>
								<td><form:input path = "renewalCodeDataDetails.fromCycle" type="text" name="fromCycle" class="form-control"/></td>
								<td><form:input path = "renewalCodeDataDetails.toCycle" type="text" name="toCycle" class="form-control"/></td>
								<td><form:input path = "renewalCodeDataDetails.value" type="text" name="value" class="form-control"/></td>
								<td><form:select path="renewalCodeDataDetails.type" class="form-control" name="type">
								    <form:option value = "Percentage"  label = "Percentage" id="percentageType"></form:option>
								    <form:option value = "Amount" label = "Amount" id="AmountType"></form:option>
								 </form:select></td>
								<td><form:input path = "renewalCodeDataDetails.currency" type="text" name="currency" class="form-control" id="currency"/></td>
								<td><!-- <a href=# class='btn btn-outline-secondary table-btn' id="editCode" title='Edit'><i class='fa fa-edit'></i></a> --> <a href=# class='btn btn-outline-secondary table-btn' id="deleteCode" title='Delete' ><i class='fa fa-trash'></i></a>
								</td>
							</tr>
						</tbody>
					</table>
					<button type="button" class="btn btn-primary btn-lg btn-block" id="addNewInstallment" style="display: none" onclick="insRow()">Click to Add New</button>
					</fieldset>
				</form:form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                <button type="button" class="btn btn-primary" form="addNewRenewalCodeForm" id="saveNewCode">Save changes</button>
            </div>
        </div>
    </div>
</div>
