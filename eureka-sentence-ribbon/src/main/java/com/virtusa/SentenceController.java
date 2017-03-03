package com.virtusa;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;



@Controller
public class SentenceController {

	@Autowired LoadBalancerClient loadBalancer;
	
	@RequestMapping("/sentence")
	public @ResponseBody String getSentence() {
	  return String.format("%s %s %s %s %s.",
		  getWord("EUREKA-SUBJECT"),
		  getWord("EUREKA-VERB"),
		  getWord("EUREKA-ARTICLE"),
		  getWord("EUREKA-ADJECTIVE"),
		  getWord("EUREKA-NOUN") );
	}

	public String getWord(String service) {
		ServiceInstance instance = loadBalancer.choose(service);
		return (new RestTemplate()).getForObject(instance.getUri(),String.class);
	}

}
