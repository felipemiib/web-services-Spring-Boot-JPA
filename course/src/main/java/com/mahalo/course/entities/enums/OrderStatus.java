package com.mahalo.course.entities.enums;

public enum OrderStatus {

	WAITING_PAYMENT(1), PAID(2), SHIPPED(3), DELIVERED(4), CANCELED(5);

	// código do int ENUM
	private int code;

	// construtor do tipo ENUM é um caso especial sendo "PRIVATE"
	private OrderStatus(int code) {
		this.code = code;
	}

	// criando metodo para tornar o método PRIVATE "ORDERSTATUS" para ser acessado

	public int getCode() {
		return code;
	}

	// criando método estatico para converter o valor numerico para o tipo ENUM
	public static OrderStatus valueOf(int code) {
		// percorrer todas os valores do OrderStatus e testar se o valor é o código
		// correspondente
		for (OrderStatus value : OrderStatus.values()) {
			// valida se o código do CODE é igual
			if (value.getCode() == code) {
				return value;
			}
		}
		// criando a excessão nos casos em que o código informado não existir
		throw new IllegalArgumentException("Invalid orderStatus code");

	}
}
