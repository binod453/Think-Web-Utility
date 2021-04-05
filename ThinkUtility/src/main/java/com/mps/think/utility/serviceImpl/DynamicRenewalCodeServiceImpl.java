package com.mps.think.utility.serviceImpl;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.xml.rpc.ServiceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.mps.think.utility.model.DynamicRenewalCodeModel;
import com.mps.think.utility.model.LoginModel;
import com.mps.think.utility.model.RenewalCodeDataDetails;
import com.mps.think.utility.service.DynamicRenewalCodeService;

import Think.XmlWebServices.Dynamic_price;
import Think.XmlWebServices.Dynamic_price_add_request;
import Think.XmlWebServices.Dynamic_price_card;
import Think.XmlWebServices.Dynamic_price_card_add_request;
import Think.XmlWebServices.Dynamic_price_card_edit_request;
import Think.XmlWebServices.Dynamic_price_card_select_request;
import Think.XmlWebServices.Dynamic_price_card_select_responseDynamic_price_card_select;
import Think.XmlWebServices.Dynamic_price_edit_request;
import Think.XmlWebServices.Dynamic_price_select_request;
import Think.XmlWebServices.Dynamic_price_select_responseDynamic_price_select;
import Think.XmlWebServices.ThinkSoap;
import Think.XmlWebServices.ThinkWSLocator;
import Think.XmlWebServices.User_authenticate_request;
import Think.XmlWebServices.User_authenticate_response;
import Think.XmlWebServices.User_login_data;

@Service
public class DynamicRenewalCodeServiceImpl implements DynamicRenewalCodeService {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public boolean getAuthenticationStatus(LoginModel loginModel) {
		log.info("Inside getAuthenticationStatus");
		
		boolean status = false;
		try {
			ThinkSoap soap = extracted(loginModel);
			
			User_authenticate_request user = new User_authenticate_request();
			
			User_login_data userLogin = new User_login_data();
			user.setDsn(loginModel.getDsn());
			userLogin.setLogin(loginModel.getUsername());
			userLogin.setPassword(loginModel.getPassword());
			user.setUser_login_data(userLogin);
			
			User_authenticate_response userAuthenticateResponse = new User_authenticate_response();
			userAuthenticateResponse = soap.userAuthenticate(user);
			 if ("yes".equals(userAuthenticateResponse.getAuthenticated().toString())) {
				 status = true;	
			 }else {
				 status=false;
			 }
			 
		return status;
		}
		catch(Exception e) {
			return status;
		}
	}

	

	@Override
	public List<Dynamic_price_select_responseDynamic_price_select> getDynamicCodesList(LoginModel loginModel)
			throws ServiceException, RemoteException {
		log.info("Inside method : getDynamicCodesList");

		List<Dynamic_price_select_responseDynamic_price_select> dynamicPriceSelectResponse = new ArrayList<Dynamic_price_select_responseDynamic_price_select>();

		ThinkSoap soap = extracted(loginModel);

		User_login_data loginData = new User_login_data();
		Dynamic_price_select_request dynamicPriceSelectrequest = new Dynamic_price_select_request();

		loginData.setLogin(loginModel.getUsername());
		loginData.setPassword(loginModel.getPassword());

		dynamicPriceSelectrequest.setDsn(loginModel.getDsn());
		dynamicPriceSelectrequest.setUser_login_data(loginData);

		dynamicPriceSelectResponse = Stream.of(soap.dynamicPriceSelect(dynamicPriceSelectrequest))
				.sorted(Comparator.comparingInt(Dynamic_price_select_responseDynamic_price_select::getDynamic_price_id))
				.collect(Collectors.toList());

		log.info("Complete method : getDynamicCodesList");
		return dynamicPriceSelectResponse;
	}

	@Override
	public int addNewDynamicRenewalCode(DynamicRenewalCodeModel dynamicRenewalCodeModel)
			throws ServiceException, RemoteException {
		log.info("Inside method : addNewDynamicRenewalCode");
		ThinkSoap soap = extracted(dynamicRenewalCodeModel.getLoginModel());

		int seq = 0;

		User_login_data loginData = new User_login_data();
		Dynamic_price dynamicPrice = new Dynamic_price();

		List<RenewalCodeDataDetails> renewalPriceCardsList = dynamicRenewalCodeModel.getRenewalCodeDataDetailsList();

		renewalPriceCardsList.removeIf(data -> data.getFromCycle() == 0);

		Dynamic_price_add_request priceAddRequest = setDynamicPriceAddRequest(dynamicRenewalCodeModel, loginData,
				dynamicPrice);
		soap.dynamicPriceAdd(priceAddRequest);

		for (RenewalCodeDataDetails priceCardDetail : renewalPriceCardsList) {
			priceCardDetail.setDynamicPriceSeq(seq++);
			Dynamic_price_card dynamicPriceCard = new Dynamic_price_card();
			Dynamic_price_card_add_request dynamicPriceCardAddRequest = setDynamicPriceCardAddRequest(
					dynamicRenewalCodeModel, priceCardDetail, loginData, dynamicPriceCard);
			soap.dynamicPricecardAdd(dynamicPriceCardAddRequest);
		}

		log.info("Complete method : addNewDynamicRenewalCode");
		return 0;
	}

	@Override
	public LoginModel setLoginDetails(JsonObject jsonObj) {
		log.info("Inside method : setLoginDetails");
		LoginModel loginModel = new LoginModel();
		loginModel.setUsername(jsonObj.get("UserName").getAsString());
		loginModel.setUserCode(jsonObj.get("userCode").getAsString());
		loginModel.setPublisher(jsonObj.get("publisher").getAsString());
		loginModel.setToken(jsonObj.get("Token").getAsString());
		loginModel.setStatus(jsonObj.get("Status").getAsString());
		log.info("Complete method : setLoginDetails");
		return loginModel;
	}

	@Override
	public int getMaxCodeId(LoginModel loginModel) throws ServiceException, RemoteException {
		log.info("Inside method : getMaxCodeId");
		List<Dynamic_price_select_responseDynamic_price_select> data = getDynamicCodesList(loginModel);
		int result = data.get(data.size() - 1).getDynamic_price_id();
		log.info("Complete method : getMaxCodeId");
		return result;
	}

	@Override
	public DynamicRenewalCodeModel getDynamicCodesById(LoginModel userDetails, int id)
			throws ServiceException, RemoteException {
		log.info("Inside method : getDynamicCodesById");
		ThinkSoap soap = extracted(userDetails);;

		User_login_data loginData = new User_login_data();
		Dynamic_price_select_request dynamicPriceSelectrequest = new Dynamic_price_select_request();
		Dynamic_price_card_select_request dynamicPriceCardSelectrequest = new Dynamic_price_card_select_request();

		loginData.setLogin(userDetails.getUsername());
		loginData.setPassword(userDetails.getPassword());

		dynamicPriceSelectrequest.setDsn(userDetails.getDsn());
		dynamicPriceSelectrequest.setUser_login_data(loginData);
		dynamicPriceSelectrequest.setDynamic_price_id(id);

		Dynamic_price_select_responseDynamic_price_select[] getCodeDetails = soap
				.dynamicPriceSelect(dynamicPriceSelectrequest);

		dynamicPriceCardSelectrequest.setDsn(userDetails.getDsn());
		dynamicPriceCardSelectrequest.setDynamic_price_id(id);
		dynamicPriceCardSelectrequest.setUser_login_data(loginData);

		Dynamic_price_card_select_responseDynamic_price_card_select[] getPriceCardDetails = soap
				.dynamicPriceCardSelect(dynamicPriceCardSelectrequest);

		DynamicRenewalCodeModel dynamicRenewalCodeModel = new DynamicRenewalCodeModel();
		List<RenewalCodeDataDetails> codeDataDetailsList = new ArrayList<RenewalCodeDataDetails>();

		if (getCodeDetails != null && getCodeDetails.length > 0) {
			dynamicRenewalCodeModel.setDescription(getCodeDetails[0].getDescription());
			dynamicRenewalCodeModel.setDynamicCode(getCodeDetails[0].getDynamic_price_name());
			dynamicRenewalCodeModel.setIsActive(getCodeDetails[0].getIsactive());
		}
		if (getPriceCardDetails != null && getPriceCardDetails.length > 0) {
			for (Dynamic_price_card_select_responseDynamic_price_card_select select : getPriceCardDetails) {
				RenewalCodeDataDetails codeDataDetails = new RenewalCodeDataDetails();
				codeDataDetails.setFromCycle(Objects.isNull(select.getFrom_cycle()) ? 0 : select.getFrom_cycle());
				codeDataDetails.setToCycle(Objects.isNull(select.getTo_cycle()) ? 0 : select.getTo_cycle());
				if (!Objects.isNull(select.getPrice()) && select.getPrice().intValueExact() > 0) {
					codeDataDetails.setValue(
							Objects.isNull(select.getPrice().intValueExact()) ? 0 : select.getPrice().intValueExact());
				} else if (!Objects.isNull(select.getPercentage()) && select.getPercentage().intValueExact() > 0) {
					codeDataDetails.setValue(Objects.isNull(select.getPercentage().intValueExact()) ? 0
							: select.getPercentage().intValueExact());
				} else {
					codeDataDetails.setValue(0);
				}
				codeDataDetails
						.setType(Objects.isNull(select.getDynamic_price_type()) ? 0 : select.getDynamic_price_type());
				codeDataDetails.setCurrency(Objects.isNull(select.getCurrency()) ? "" : select.getCurrency());

				codeDataDetailsList.add(codeDataDetails);
			}
			dynamicRenewalCodeModel.setRenewalCodeDataDetailsList(codeDataDetailsList);
		}
		log.info("Complete method : getDynamicCodesById");
		return dynamicRenewalCodeModel;
	}

	@Override
	public int updateDynamicRenewalCode(DynamicRenewalCodeModel dynamicRenewalCodeModel)
			throws ServiceException, RemoteException {
		log.info("Inside method : updateDynamicRenewalCode");
		ThinkSoap soap = extracted(dynamicRenewalCodeModel.getLoginModel());

		User_login_data loginData = new User_login_data();
		Dynamic_price dynamicPrice = new Dynamic_price();

		List<RenewalCodeDataDetails> editRenewalPriceCardsList = dynamicRenewalCodeModel
				.getRenewalCodeDataDetailsList();

		Dynamic_price_edit_request priceEditRequest = setDynamicPriceEditRequest(dynamicRenewalCodeModel, loginData,
				dynamicPrice);
		soap.dynamicPriceEdit(priceEditRequest);

		for (RenewalCodeDataDetails priceCardDetail : editRenewalPriceCardsList) {
			Dynamic_price_card dynamicPriceCard = new Dynamic_price_card();
			Dynamic_price_card_edit_request dynamicPriceCardEditRequest = setDynamicPriceCardEditRequest(
					dynamicRenewalCodeModel, priceCardDetail, loginData, dynamicPriceCard);
			soap.dynamicPricecardEdit(dynamicPriceCardEditRequest);
		}
		log.info("Complete method : updateDynamicRenewalCode");
		return 0;
	}

	private Dynamic_price_card_edit_request setDynamicPriceCardEditRequest(
			DynamicRenewalCodeModel dynamicRenewalCodeModel, RenewalCodeDataDetails priceCardDetail,
			User_login_data loginData, Dynamic_price_card dynamicPriceCard) {
		log.info("Inside method : setDynamicPriceCardEditRequest");
		Dynamic_price_card_edit_request priceCardEditRequest = new Dynamic_price_card_edit_request();

		loginData.setLogin(dynamicRenewalCodeModel.getLoginModel().getUsername());
		loginData.setPassword(dynamicRenewalCodeModel.getLoginModel().getPassword());
		priceCardEditRequest.setDsn(dynamicRenewalCodeModel.getLoginModel().getDsn());

		dynamicPriceCard
				.setFrom_cycle(Objects.isNull(priceCardDetail.getFromCycle()) ? 0 : priceCardDetail.getFromCycle());
		dynamicPriceCard.setTo_cycle(Objects.isNull(priceCardDetail.getToCycle()) ? 0 : priceCardDetail.getToCycle());
		if (!Objects.isNull(priceCardDetail.getType()) && priceCardDetail.getType() == 0) {
			dynamicPriceCard.setPrice(Objects.isNull(priceCardDetail.getValue()) ? BigDecimal.ZERO
					: BigDecimal.valueOf(priceCardDetail.getValue()));
		} else {
			dynamicPriceCard.setPercentage(Objects.isNull(priceCardDetail.getValue()) ? BigDecimal.ZERO
					: BigDecimal.valueOf(priceCardDetail.getValue()));
		}
		dynamicPriceCard
				.setDynamic_price_type(Objects.isNull(priceCardDetail.getType()) ? 0 : priceCardDetail.getType());
		dynamicPriceCard
				.setCurrency(Objects.isNull(priceCardDetail.getCurrency()) ? "" : priceCardDetail.getCurrency());
		dynamicPriceCard.setDynamic_price_id(dynamicRenewalCodeModel.getSlNo());
		dynamicPriceCard.setDynamic_price_seq(priceCardDetail.getDynamicPriceSeq());

		priceCardEditRequest.setUser_login_data(loginData);
		priceCardEditRequest.setDynamic_price_card(dynamicPriceCard);
		priceCardEditRequest.setSubmit(true);

		log.info("Complete method : setDynamicPriceCardEditRequest");
		return priceCardEditRequest;
	}

	private Dynamic_price_edit_request setDynamicPriceEditRequest(DynamicRenewalCodeModel dynamicRenewalCodeModel,
			User_login_data loginData, Dynamic_price dynamicPrice) {
		log.info("Inside method : setDynamicPriceEditRequest");
		Dynamic_price_edit_request priceEditRequest = new Dynamic_price_edit_request();

		dynamicPrice.setDynamic_price_name(dynamicRenewalCodeModel.getDynamicCode());
		dynamicPrice.setDescription(dynamicRenewalCodeModel.getDescription());
		dynamicPrice.setDynamic_price_id(dynamicRenewalCodeModel.getSlNo());
		dynamicPrice.setIsactive(dynamicRenewalCodeModel.getIsActive());

		loginData.setLogin(dynamicRenewalCodeModel.getLoginModel().getUsername());
		loginData.setPassword(dynamicRenewalCodeModel.getLoginModel().getPassword());
		priceEditRequest.setDsn(dynamicRenewalCodeModel.getLoginModel().getDsn());

		priceEditRequest.setUser_login_data(loginData);
		priceEditRequest.setDynamic_price(dynamicPrice);
		priceEditRequest.setSubmit(true);

		log.info("Complete method : setDynamicPriceEditRequest");
		return priceEditRequest;
	}

	private Dynamic_price_card_add_request setDynamicPriceCardAddRequest(
			DynamicRenewalCodeModel dynamicRenewalCodeModel, RenewalCodeDataDetails priceCardDetail,
			User_login_data loginData, Dynamic_price_card dynamicPriceCard) {
		log.info("Inside method : setDynamicPriceCardAddRequest");
		Dynamic_price_card_add_request priceCardAddRequest = new Dynamic_price_card_add_request();

		loginData.setLogin(dynamicRenewalCodeModel.getLoginModel().getUsername());
		loginData.setPassword(dynamicRenewalCodeModel.getLoginModel().getPassword());
		priceCardAddRequest.setDsn(dynamicRenewalCodeModel.getLoginModel().getDsn());

		dynamicPriceCard
				.setFrom_cycle(Objects.isNull(priceCardDetail.getFromCycle()) ? 0 : priceCardDetail.getFromCycle());
		dynamicPriceCard.setTo_cycle(Objects.isNull(priceCardDetail.getToCycle()) ? 0 : priceCardDetail.getToCycle());
		if (!Objects.isNull(priceCardDetail.getType()) && priceCardDetail.getType() == 0) {
			dynamicPriceCard.setPrice(Objects.isNull(priceCardDetail.getValue()) ? BigDecimal.ZERO
					: BigDecimal.valueOf(priceCardDetail.getValue()));
		} else {
			dynamicPriceCard.setPercentage(Objects.isNull(priceCardDetail.getValue()) ? BigDecimal.ZERO
					: BigDecimal.valueOf(priceCardDetail.getValue()));
		}
		dynamicPriceCard
				.setDynamic_price_type(Objects.isNull(priceCardDetail.getType()) ? 0 : priceCardDetail.getType());
		dynamicPriceCard
				.setCurrency(Objects.isNull(priceCardDetail.getCurrency()) ? "" : priceCardDetail.getCurrency());

		dynamicPriceCard.setDynamic_price_id(dynamicRenewalCodeModel.getSlNo());
		dynamicPriceCard.setDynamic_price_seq(priceCardDetail.getDynamicPriceSeq());

		priceCardAddRequest.setUser_login_data(loginData);
		priceCardAddRequest.setDynamic_price_card(dynamicPriceCard);
		priceCardAddRequest.setSubmit(true);

		log.info("Complete method : setDynamicPriceCardAddRequest");
		return priceCardAddRequest;
	}

	private Dynamic_price_add_request setDynamicPriceAddRequest(DynamicRenewalCodeModel dynamicRenewalCodeModel,
			User_login_data loginData, Dynamic_price dynamicPrice) {
		log.info("Inside method : setDynamicPriceAddRequest");
		Dynamic_price_add_request priceAddRequest = new Dynamic_price_add_request();

		dynamicPrice.setDynamic_price_name(dynamicRenewalCodeModel.getDynamicCode());
		dynamicPrice.setDescription(dynamicRenewalCodeModel.getDescription());
		dynamicPrice.setDynamic_price_id(dynamicRenewalCodeModel.getSlNo());
		dynamicPrice.setIsactive(dynamicRenewalCodeModel.getIsActive());

		loginData.setLogin(dynamicRenewalCodeModel.getLoginModel().getUsername());
		loginData.setPassword(dynamicRenewalCodeModel.getLoginModel().getPassword());
		priceAddRequest.setDsn(dynamicRenewalCodeModel.getLoginModel().getDsn());

		priceAddRequest.setUser_login_data(loginData);
		priceAddRequest.setDynamic_price(dynamicPrice);
		priceAddRequest.setSubmit(true);

		log.info("Complete method : setDynamicPriceAddRequest");
		return priceAddRequest;
	}
	
	private ThinkSoap extracted(LoginModel loginModel) throws ServiceException {
		ThinkSoap soap = null;
		ThinkWSLocator locator = new ThinkWSLocator();
		locator.setThinkSoap_address(loginModel.getSoapAddress());
		soap = locator.getThinkSoap();
		return soap;
	}
}
