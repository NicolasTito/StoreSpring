package com.nide_mel.store.store.domain.enums;

public enum StatePayment {

	OUTSTANDING(1, "outstanding"),
	SETTLED(2, "sttled"),
	CANCELED(3, "canceled");

	private int cod;
	private String description;

	private StatePayment(int cod, String description){
		this.cod = cod;
		this.description = description;
	}

	public int getCod(){
		return cod;
	}

	public String getDescription(){
		return description;
	}

	public static StatePayment toEnum(Integer cod) {
		if (cod == null)
			return null;
		for (StatePayment x : StatePayment.values()) {
			if (cod.equals(x.getCod()))
				return x;
		}
		throw new IllegalArgumentException("Invalid ID: " + cod);
	}
}
