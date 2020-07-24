package com.nirubiru.springbootconfig.configuration;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("db")
public class DBSetting {

//	private Map<String, String> connection;
	private String connection;
	private String host;
	private int port;
	
	
	public String getConnection() {
		return connection;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public void setConnection(String connection) {
		this.connection = connection;
	}
}
