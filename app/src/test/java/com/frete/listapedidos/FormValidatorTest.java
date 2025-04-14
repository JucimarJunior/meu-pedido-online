package com.frete.listapedidos;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.frete.listapedidos.util.OrderFormValidator;

import org.junit.Test;

public class FormValidatorTest {

    private final OrderFormValidator validator = new OrderFormValidator();

    @Test
    public void testAllFieldsFilled() {
        assertTrue(validator.areFieldsValid("João", "Produto A", "2", "100"));
    }

    @Test
    public void testOneEmptyField() {
        assertFalse(validator.areFieldsValid("", "Produto A", "2", "100"));
        assertFalse(validator.areFieldsValid("João", "Produto A", "", "100"));
        assertFalse(validator.areFieldsValid("João", "", "6", "100"));
        assertFalse(validator.areFieldsValid("João", "Produto A", "2", ""));
    }

    @Test
    public void testAllFieldsEmpty() {
        assertFalse(validator.areFieldsValid("", "", "", ""));
    }

    @Test
    public void testNullValues() {
        assertFalse(validator.areFieldsValid(null, "Produto A", "2", "100"));
        assertFalse(validator.areFieldsValid("João", null, "2", "100"));
        assertFalse(validator.areFieldsValid("João", "Produto A", null, "100"));
        assertFalse(validator.areFieldsValid("João", "Produto A", "2", null));
    }
}