package ru.netology.auxiliaryInterface;

import ru.netology.PriceAndAmount;
import ru.netology.product.AbstractProduct;

import java.util.List;

//интерфейс склада магазина
public interface Stock {

    public void addStore(AbstractProduct abstractProduct, int amountProduct, int priceProduct);//добавить продукт на склад

    public void deleteStore(IntPriceAndAmount priceAndAmount);//удалить товар со склада

    public void setPriceProduct(IntPriceAndAmount priceAndAmount, int price); //изменить стоимость товара

    public int getPriceProduct(IntPriceAndAmount priceAndAmount);//получить стоимость

    public void setAmountProduct(IntPriceAndAmount priceAndAmount, int amount);//установить кол-во

    public int getAmountProduct(IntPriceAndAmount priceAndAmount);//получить кол-во

    public IntPriceAndAmount getPriceAndAmount(int index);//получить объект со склада с номером

    public void showPriceAndAmount(); //вывести список всех товаров со склада

    public List<IntPriceAndAmount> getListPriceAndAmount(); //запросить список всех товаров на складе
}
