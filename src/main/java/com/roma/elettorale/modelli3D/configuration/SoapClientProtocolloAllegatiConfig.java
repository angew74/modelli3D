package com.roma.elettorale.modelli3D.configuration;

import com.roma.elettorale.modelli3D.extensions.LogHttpHeaderClientInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

public class SoapClientProtocolloAllegatiConfig {


    public Jaxb2Marshaller jaxb2Marshaller() {
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller
                .setContextPath("com.roma.elettorale.modelli3D.entity.protocollo.allegati");

        return jaxb2Marshaller;
    }



    @Bean
    public WebServiceTemplate webServiceTemplate() throws Exception {
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
        webServiceTemplate.setMarshaller(jaxb2Marshaller());
        webServiceTemplate.setUnmarshaller(jaxb2Marshaller());
        ClientInterceptor[] interceptors;
        interceptors = new ClientInterceptor[]{
                new LogHttpHeaderClientInterceptor()
        };
        webServiceTemplate.setInterceptors(interceptors);
        HttpComponentsMessageSender httpComponentsMessageSender = new HttpComponentsMessageSender();
        httpComponentsMessageSender.setReadTimeout(3000);
        httpComponentsMessageSender.setConnectionTimeout(5000);
        webServiceTemplate.setMessageSender(httpComponentsMessageSender);
        return webServiceTemplate;
    }

}
