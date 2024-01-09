package ru.netology;

import ru.netology.auxiliaryInterface.IntPriceAndAmount;

public class Order extends  AbstractOrder{
    public Order(IntPriceAndAmount productPAA, int amountOrder) {
        this.setProduct(productPAA);
        this.setAmountOrder(amountOrder);
    }
}
