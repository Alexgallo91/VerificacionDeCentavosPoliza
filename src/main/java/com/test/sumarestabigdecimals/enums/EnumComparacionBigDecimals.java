package com.test.sumarestabigdecimals.enums;

public enum EnumComparacionBigDecimals {
	
	IGUAL("Numero igual a", 0),
	MENOR("Numero menor a", -1),
	MAYOR("Numero mayor a", 1);
	
	private String comparacion;
	private int codigo;
	
	private EnumComparacionBigDecimals(String comparacion, int codigo) {
		this.comparacion = comparacion;
		this.codigo = codigo;
	}

	public String getComparacion() {
		return comparacion;
	}

	public int getCodigo() {
		return codigo;
	}
	
}
