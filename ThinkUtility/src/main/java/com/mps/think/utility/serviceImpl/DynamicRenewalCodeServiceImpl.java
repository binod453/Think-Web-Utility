package com.mps.think.utility.serviceImpl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.xml.rpc.ServiceException;

import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.mps.think.utility.model.DynamicRenewalCodeModel;
import com.mps.think.utility.model.LoginModel;
import com.mps.think.utility.service.DynamicRenewalCodeService;

import Think.XmlWebServices.Dynamic_price;
import Think.XmlWebServices.Dynamic_price_add_request;
import Think.XmlWebServices.Dynamic_price_add_response;
import Think.XmlWebServices.Dynamic_price_card;
import Think.XmlWebServices.Dynamic_price_card_add_request;
import Think.XmlWebServices.Dynamic_price_card_select_request;
import Think.XmlWebServices.Dynamic_price_card_select_response;
import Think.XmlWebServices.Dynamic_price_card_select_responseDynamic_price_card_select;
import Think.XmlWebServices.Dynamic_price_select_request;
import Think.XmlWebServices.Dynamic_price_select_response;
import Think.XmlWebServices.Dynamic_price_select_responseDynamic_price_id;
import Think.XmlWebServices.Dynamic_price_select_responseDynamic_price_select;
import Think.XmlWebServices.Payment_type_select_request;
import Think.XmlWebServices.Payment_type_select_responsePayment_type;
import Think.XmlWebServices.ThinkSoap;
import Think.XmlWebServices.ThinkWSLocator;
import Think.XmlWebServices.User_login_data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DynamicRenewalCodeServiceImpl implements DynamicRenewalCodeService {

	private static final Comparator<DynamicRenewalCodeModel> EMPTY_COMPARATOR = (e1, e2) -> 0;
	
	@Override
	public List<Dynamic_price_select_responseDynamic_price_select> getDynamicCodesList(LoginModel loginModel) throws ServiceException, RemoteException {
		
		List<Dynamic_price_select_responseDynamic_price_select> dynamicPriceSelectResponse = new ArrayList<Dynamic_price_select_responseDynamic_price_select>();

		ThinkSoap soap = null;
		ThinkWSLocator locator = new ThinkWSLocator();
		soap = locator.getThinkSoap();

		User_login_data loginData = new User_login_data();
		Dynamic_price_select_request dynamicPriceSelectrequest= new Dynamic_price_select_request();
		
		loginData.setLogin(loginModel.getUsername());
		loginData.setPassword(loginModel.getPassword());
		
		dynamicPriceSelectrequest.setDsn(loginModel.getDsn());
		dynamicPriceSelectrequest.setUser_login_data(loginData);
		
		dynamicPriceSelectResponse = Stream.of(soap.dynamicPriceSelect(dynamicPriceSelectrequest))
											.sorted(Comparator.comparingInt(Dynamic_price_select_responseDynamic_price_select :: getDynamic_price_id))
											.collect(Collectors.toList());
		
//		
//		Dynamic_price_card_select_request dynamicPriceCardSelectrequest = new Dynamic_price_card_select_request();
//		dynamicPriceCardSelectrequest.setDsn(loginModel.getDsn());
//		dynamicPriceCardSelectrequest.setUser_login_data(loginData);
//		
//		List<Dynamic_price_card_select_responseDynamic_price_card_select> dynamicPriceCardSelectRespose = Arrays.asList(soap.dynamicPriceCardSelect(dynamicPriceCardSelectrequest));
//		
//		List<DynamicRenewalCodeModel> model = new ArrayList<DynamicRenewalCodeModel>();
//		
//		
//		for(Dynamic_price_select_responseDynamic_price_select select : dynamicPriceSelectResponse) {
//			DynamicRenewalCodeModel m1 = new DynamicRenewalCodeModel();
//			for(Dynamic_price_card_select_responseDynamic_price_card_select cardSelect : dynamicPriceCardSelectRespose) {
//				if(select.getDynamic_price_id() == cardSelect.getDynamic_price_id()) {
//					m1.setSlNo(select.getDynamic_price_id());
//					m1.setActiveFrom(cardSelect.get);
//					m1.setActiveTo(activeTo);
//					m1.setDescription(description);
//					m1.setDynamicCode(dynamicCode);
//					m1.setOfferType(offerType);
//				}else {
//					
//				}
//			}
//		}
//		
//		
//		
//		
//		
//		
//		
//		model.stream().forEach(s-> s.setActiveFrom(activeFrom););
//		
//		List<> pageData = Arrays.asList(dynamicPriceSelectResponse);
		
		return dynamicPriceSelectResponse;
	}

	@Override
	public int addNewDynamicRenewalCode(DynamicRenewalCodeModel dynamicRenewalCodeModel) throws ServiceException, RemoteException {
		ThinkSoap soap = null;
		ThinkWSLocator locator = new ThinkWSLocator();
		soap = locator.getThinkSoap();
		
		User_login_data loginData = new User_login_data();
		Dynamic_price dynamicPrice = new Dynamic_price();
		Dynamic_price_card dynamicPriceCard = new Dynamic_price_card();
		
		Dynamic_price_add_request priceAddRequest = setDynamicPriceAddRequest(dynamicRenewalCodeModel, loginData, dynamicPrice);
		
		Dynamic_price_add_response dynamicPriceAddResponse = new Dynamic_price_add_response();
		dynamicPriceAddResponse = soap.dynamicPriceAdd(priceAddRequest);
		System.out.println(dynamicPriceAddResponse.getDynamic_price().getDynamic_price_id());
		
		Dynamic_price_card_add_request dynamicPriceCardAddRequest = setDynamicPriceCardAddRequest(dynamicRenewalCodeModel, loginData, dynamicPriceCard);
		
		return 0;
	}

	private Dynamic_price_card_add_request setDynamicPriceCardAddRequest(
			DynamicRenewalCodeModel dynamicRenewalCodeModel, User_login_data loginData, Dynamic_price_card dynamicPriceCard) {
		Dynamic_price_card_add_request priceCardAddRequest = new Dynamic_price_card_add_request();
		
		loginData.setLogin(dynamicRenewalCodeModel.getLoginModel().getUsername());
		loginData.setPassword(dynamicRenewalCodeModel.getLoginModel().getPassword());
		priceCardAddRequest.setDsn(dynamicRenewalCodeModel.getLoginModel().getDsn());
		
		dynamicPriceCard.setFrom_cycle(Objects.isNull(dynamicRenewalCodeModel.getActiveFrom()) ? 0 : dynamicRenewalCodeModel.getActiveFrom());
		dynamicPriceCard.setTo_cycle(Objects.isNull(dynamicRenewalCodeModel.getActiveTo()) ? 0 : dynamicRenewalCodeModel.getActiveTo());
	//	dynamicPriceCard.setDynamic_price_id(dynamic_price_id);
	//	dynamicPriceCard.setDynamic_price_seq(dynamic_price_seq);
	//	dynamicPriceCard.setPrice(price);
//		dynamicPriceCard.setDynamic_price_type(dynamic_price_type);
//		dynamicPriceCard.setDynamic_price_type(dynamic_price_type);
//		dynamicPriceCard.setCurrency(currency);
		
		priceCardAddRequest.setUser_login_data(loginData);
		priceCardAddRequest.setDynamic_price_card(dynamicPriceCard);
		
		return null;
	}

	private Dynamic_price_add_request setDynamicPriceAddRequest(DynamicRenewalCodeModel dynamicRenewalCodeModel,
			User_login_data loginData, Dynamic_price dynamicPrice) {
		Dynamic_price_add_request priceAddRequest = new Dynamic_price_add_request();

		dynamicPrice.setDynamic_price_name(dynamicRenewalCodeModel.getDynamicCode());
		dynamicPrice.setDescription(dynamicRenewalCodeModel.getDescription());
		// dynamicPrice.setIsactive(isactive);
		dynamicPrice.setDynamic_price_id(dynamicRenewalCodeModel.getSlNo());

		loginData.setLogin(dynamicRenewalCodeModel.getLoginModel().getUsername());
		loginData.setPassword(dynamicRenewalCodeModel.getLoginModel().getPassword());
		priceAddRequest.setDsn(dynamicRenewalCodeModel.getLoginModel().getDsn());

		priceAddRequest.setUser_login_data(loginData);
		priceAddRequest.setDynamic_price(dynamicPrice);

		return priceAddRequest;
	}

	@Override
	public LoginModel setLoginDetails(JsonObject jsonObj) {
		LoginModel loginModel = new LoginModel();
		loginModel.setUsername(jsonObj.get("UserName").getAsString());
		loginModel.setUserCode(jsonObj.get("userCode").getAsString());
		loginModel.setPublisher(jsonObj.get("publisher").getAsString());
		loginModel.setToken(jsonObj.get("Token").getAsString());
		loginModel.setStatus(jsonObj.get("Status").getAsString());
		return loginModel;
	}

//	@Override
//	public Page<DynamicRenewalCodeModel> getDynamicCodes(PagingRequest pagingRequest) {
//		ObjectMapper objectMapper = new ObjectMapper();
//
//		try {
//			List<DynamicRenewalCodeModel> dynamicCodes = objectMapper.readValue(
//					getClass().getClassLoader().getResourceAsStream("DummyData.json"),
//					new TypeReference<List<DynamicRenewalCodeModel>>() {
//					});
//
//			return getPage(dynamicCodes, pagingRequest);
//
//		} catch (IOException e) {
//			log.error(e.getMessage(), e);
//		}
//
//		return new Page<>();
//	}
//
//	private Page<DynamicRenewalCodeModel> getPage(List<DynamicRenewalCodeModel> dynamicCodes,
//			PagingRequest pagingRequest) {
//		List<DynamicRenewalCodeModel> filtered = dynamicCodes.stream().sorted(sortDynamicCodes(pagingRequest))
//				.filter(filterDynamicCodes(pagingRequest)).skip(pagingRequest.getStart())
//				.limit(pagingRequest.getLength()).collect(Collectors.toList());
//
//		long count = dynamicCodes.stream().filter(filterDynamicCodes(pagingRequest)).count();
//
//		Page<DynamicRenewalCodeModel> page = new Page<>(filtered);
//		page.setRecordsFiltered((int) count);
//		page.setRecordsTotal((int) count);
//		page.setDraw(pagingRequest.getDraw());
//
//		return page;
//	}
//
//	private Predicate<DynamicRenewalCodeModel> filterDynamicCodes(PagingRequest pagingRequest) {
//		if (pagingRequest.getSearch() == null || StringUtils.isEmpty(pagingRequest.getSearch().getValue())) {
//			return employee -> true;
//		}
//
//		String value = pagingRequest.getSearch().getValue();
//
//		return dynamicCode -> dynamicCode.getDynamicCode().toLowerCase().contains(value)
//				|| dynamicCode.getOfferType().toLowerCase().contains(value)
//				|| dynamicCode.getDescription().toLowerCase().contains(value);
//	}
//
//	private Comparator<DynamicRenewalCodeModel> sortDynamicCodes(PagingRequest pagingRequest) {
//		if (pagingRequest.getOrder() == null) {
//			return EMPTY_COMPARATOR;
//		}
//
//		try {
//			Order order = pagingRequest.getOrder().get(0);
//
//			int columnIndex = order.getColumn();
//			Column column = pagingRequest.getColumns().get(columnIndex);
//
//			Comparator<DynamicRenewalCodeModel> comparator = DynamicRenewalCodeComparator
//					.getComparator(column.getData(), order.getDir());
//			if (comparator == null) {
//				return EMPTY_COMPARATOR;
//			}
//
//			return comparator;
//
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//		}
//
//		return EMPTY_COMPARATOR;
//	}

}
