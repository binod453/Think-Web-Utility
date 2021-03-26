package com.mps.think.utility.service;

import java.rmi.RemoteException;
import java.util.List;

import javax.xml.rpc.ServiceException;

import com.google.gson.JsonObject;
import com.mps.think.utility.model.DynamicRenewalCodeModel;
import com.mps.think.utility.model.LoginModel;

import Think.XmlWebServices.Dynamic_price_select_responseDynamic_price_id;
import Think.XmlWebServices.Dynamic_price_select_responseDynamic_price_select;

public interface DynamicRenewalCodeService {

	public List<Dynamic_price_select_responseDynamic_price_select> getDynamicCodesList(LoginModel userDetails) throws ServiceException, RemoteException;

	public int addNewDynamicRenewalCode(DynamicRenewalCodeModel dynamicRenewalCodeModel) throws ServiceException, RemoteException;

	public LoginModel setLoginDetails(JsonObject jsonObj);

	public int getMaxCodeId(LoginModel loginModel) throws ServiceException, RemoteException;

	public DynamicRenewalCodeModel getDynamicCodesById(LoginModel userDetails, int id) throws ServiceException, RemoteException;

	public int updateDynamicRenewalCode(DynamicRenewalCodeModel dynamicRenewalCodeModel) throws ServiceException, RemoteException;

}
