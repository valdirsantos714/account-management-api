package com.valdirsantos714.apiproducts.model.enums;

public enum Category {

    GROCERY_ITEMS("Produtos de mercearia"),
    PRODUCE("Hortifrúti"),
    MEAT("Carnes"),
    DAIRY("Laticínios"),
    BAKERY("Padaria"),
    BEVERAGES("Bebidas"),
    FROZEN_FOODS("Alimentos Congelados"),
    CLEANING_SUPPLIES("Produtos de Limpeza"),
    PERSONAL_CARE("Higiene Pessoal"),
    PET_FOOD("Ração para Animais");

    private String type;

    Category(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
