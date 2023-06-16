
package com.example.consumingwebservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.example.consumingwebservice.wsdl.GetDiasRequest;
import com.example.consumingwebservice.wsdl.GetDiasResponse;

public class DiasClient extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(DiasClient.class);

	public GetDiasResponse getDia(String dia) {

		GetDiasRequest request = new GetDiasRequest();
		request.setName(dia);

		log.info("Requesting location for " + dia);

		GetDiasResponse response = (GetDiasResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/wsec1e1/dias", request,
						new SoapActionCallback(
								"http://spring.io/guides/gs-producing-web-service/GetDiasRequest"));

		return response;
	}

}
