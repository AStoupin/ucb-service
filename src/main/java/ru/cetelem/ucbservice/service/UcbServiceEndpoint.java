package ru.cetelem.ucbservice.service;

import javax.jws.WebService;

import org.springframework.stereotype.Service;

import ru.cetelem.ucbservice.api.schema.*;


@Service
public class UcbServiceEndpoint implements ru.cetelem.ucbservice.api.schema.UcbService {

	@Override
	public InvokeResponse invoke(InvokeRequest invokeRequest) {
		ObjectFactory factory = new ObjectFactory();
		InvokeResponse ir = factory.createInvokeResponse();
		ir.setOut(factory.createCreditBureauResponse());
		ir.getOut().setResponseData(factory.createResponseData());
		ir.getOut().getResponseData().setCreditBureauName("XXX");
		return ir;
	}

	@Override
	public GetOrInvokeResponse getOrInvoke(GetOrInvokeRequest getOrInvokeRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetVersionResponse getVersion() {
		ObjectFactory factory = new ObjectFactory();
		GetVersionResponse v = factory.createGetVersionResponse();
		v.setOut("1");
		return v;
	}

	
}