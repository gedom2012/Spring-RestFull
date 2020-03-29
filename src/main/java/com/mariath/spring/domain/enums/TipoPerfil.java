package com.mariath.spring.domain.enums;

public enum TipoPerfil {
	
	USER(1, "ROLE_USER"),
	ADMIN(2, "ROLE_ADMIN");
	
	private int cod;
	private String descricao;
	
private TipoPerfil(int cod, String descricao) {
	this.cod = cod;
	this.descricao = descricao;
}

public int getCod() {
	return cod;
}

public String getDescricao() {
	return descricao;
}

public static TipoPerfil toEnum(Integer cod) {
	if (cod == null) {
		return null;
	}
	
	for(TipoPerfil x : TipoPerfil.values()) {
		if (cod.equals(x.getCod())) {
			return x;
		}
	}
	
	throw new IllegalArgumentException("Perfil informado é inválido:... " + cod);
}

	

}
