package com.alejandro.pokeapi.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "request")
public class RequestEntity implements Serializable {
	
	private static final long serialVersionUID = -4388871325527992512L;
	@Id
	@Column(name = "id")
	@NonNull
	private String ip;
	@Column(name = "url")
	@NonNull
	private String url;
	@Column(name = "date_req")
	@NonNull
	private LocalDateTime dateRequest;
	
	public RequestEntity() {
	}

	public RequestEntity(String ip, String url, LocalDateTime dateRequest) {
		this.ip = ip;
		this.url = url;
		this.dateRequest = dateRequest;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public LocalDateTime getDateRequest() {
		return dateRequest;
	}

	public void setDateRequest(LocalDateTime dateRequest) {
		this.dateRequest = dateRequest;
	}

}
