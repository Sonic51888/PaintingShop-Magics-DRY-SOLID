package ru.netology.auxiliaryInterface;

import ru.netology.product.AbstractProduct;

public interface IntPriceAndAmount {
    public void setPurchasedOnce(int purchased);

    public int getPurchasedOnce();

    public void setAmount(int amount);

    public int getAmount();

    public void setPrice(int price);

    public int getPrice();

    public AbstractProduct getProduct();
}
