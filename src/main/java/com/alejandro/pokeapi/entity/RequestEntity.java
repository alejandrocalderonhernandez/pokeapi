package com.alejandro.pokeapi.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import com.google.gson.Gson;

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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateRequest == null) ? 0 : dateRequest.hashCode());
		result = prime * result + ((ip == null) ? 0 : ip.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof RequestEntity))
			return false;
		RequestEntity other = (RequestEntity) obj;
		if (dateRequest == null) {
			if (other.dateRequest != null)
				return false;
		} else if (!dateRequest.equals(other.dateRequest))
			return false;
		if (ip == null) {
			if (other.ip != null)
				return false;
		} else if (!ip.equals(other.ip))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return new Gson().toJson(this).toString();
	}

}
