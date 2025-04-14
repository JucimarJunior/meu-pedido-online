package com.frete.listapedidos.util;

public class OrderFormValidator {
    public boolean areFieldsValid(String nameClient, String nameProduct, String quantity, String total) {
        return !(isEmpty(nameClient) || isEmpty(nameProduct) || isEmpty(quantity) || isEmpty(total));
    }

    private boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}
