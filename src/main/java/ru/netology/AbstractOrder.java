package ru.netology;

import ru.netology.auxiliaryInterface.IntPriceAndAmount;

public abstract class AbstractOrder {
    private IntPriceAndAmount productPAA;
    private int amountOrder;
    public void setProduct(IntPriceAndAmount productPAA) {
        this.productPAA = productPAA;
    }

    public void setAmountOrder(int amountOrder) {
        this.amountOrder = amountOrder;
    }

    public IntPriceAndAmount getProductPAA() {
        return productPAA;
    }

    public int getAmountOrder() {
        return amountOrder;
    }


    public int getCostOrder() {
        return amountOrder * productPAA.getPrice();
    }

    @Override
    public String toString() {
        return "Товар: " +
                productPAA.getProduct().getBrand() +
                " " +
                productPAA.getProduct().getNameProduct() +
                ",  в количестве " + amountOrder + " шт. " +
                "стоимостью " +
                getCostOrder() + " руб.";
    }
}