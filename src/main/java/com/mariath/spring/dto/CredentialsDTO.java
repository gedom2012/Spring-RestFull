package com.mariath.spring.dto;

import java.io.Serializable;

public class CredentialsDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String email;
	private String senha;
	
	public CredentialsDTO() {		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String password) {
		this.senha = password;
	}
	
	

}
