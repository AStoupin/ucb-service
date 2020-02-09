package ru.cetelem.ucbservice.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.ext.logging.LoggingFeature;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import ru.cetelem.ucbservice.api.schema.UcbService;

import ru.cetelem.ucbservice.service.UcbServiceEndpoint;

@Configuration
@ComponentScan("ru.cetelem.ucbservice.service")
public class TestConfig {

	private static final String SERVICE_URL = "http://localhost:8091/ucb-service/api";
	
	@Bean("ucbServiceClient")
	public UcbService ucbServiceClient() {

		JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
		jaxWsProxyFactoryBean.setServiceClass(UcbService.class);
		jaxWsProxyFactoryBean.setAddress(SERVICE_URL);		    
		return (UcbService) jaxWsProxyFactoryBean.create();
	}
	
	@Bean(name=Bus.DEFAULT_BUS_ID)
	public SpringBus springBus(LoggingFeature loggingFeature) {
		
		SpringBus bus = new  SpringBus();
		bus.getFeatures().add(loggingFeature);
		
		return bus;
	}

	@Bean
	public LoggingFeature loggingFeature() {
		
		LoggingFeature loggingFeature = new LoggingFeature();
		loggingFeature.setPrettyLogging(true);
		
		return loggingFeature;
	}
	
	@Bean
	public Endpoint endpoint(Bus bus, LoggingFeature loggingFeature, UcbServiceEndpoint ucbServiceEndpoint) {
		
		EndpointImpl endpoint = new EndpointImpl(bus, ucbServiceEndpoint);
		endpoint.publish(SERVICE_URL);
		
		return endpoint;
	}
	
}