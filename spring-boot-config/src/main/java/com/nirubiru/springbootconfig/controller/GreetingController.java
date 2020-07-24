package com.nirubiru.springbootconfig.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nirubiru.springbootconfig.configuration.DBSetting;

@RestController
// all the dependencies been need to refreshed.
@RefreshScope
@RequestMapping("/api")
public class GreetingController {

	@Value("${my.greeting}")
	private String greetingMessage;

	@Value("${my.greeting : defaultMessage}")
	private String greetingMessageDefaultMessage;

	@Value("staticmessage")
	private String staticmessage;

	@Value("${my.list.value}")
	private List<String> listValue;

	@Value("${app.description}")
	private String appInfo;

	@Autowired
	private DBSetting dbSetting;

//	@Value("${actual value:default value}")
//	# represent the ESPL (Expression language)
	@Value("#{${dbValues}}")
	private Map<String, String> dbValues;

	@RequestMapping("/greeting")
	public String greetingMessage() {
//		return greetingMessage + "\t" + greetingMessageDefaultMessage + "\t" + staticmessage + "\t" + listValue+"\t"+dbValues;
//		return greetingMessage + "\t" + dbSetting.getConnection() + "\t" + dbSetting.getPort() + "\t"
//				+ dbSetting.getHost();
		return greetingMessage;
	}

	@RequestMapping("/app")
	public String appInfo() {
		return appInfo;
	}

	@Autowired
	private Environment environment;

	@RequestMapping("/envdetails")
	public String getEnvDetails() {
//		return environment.getProperty("my.greeting");
		return environment.toString();
	}
}
