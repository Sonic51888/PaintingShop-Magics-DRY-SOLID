package ru.netology.auxiliaryInterface;

import ru.netology.AbstractOrder;

import java.util.List;

public interface IntBasket {

    public boolean addToBasket(AbstractOrder abstractOrder);//добавить заказ в корзину

    public AbstractOrder getOrder(int index) throws Exception;// получить объект заказа

    public List<AbstractOrder> getBasketOrdersFulfilled();//получить список уже исполненных заказов

    public boolean delToBasket(AbstractOrder order); //удалить заказ из корзины

    public int getCostBasket(); //получить сумму/стоимость товаров в корзине

    public boolean sendAnOrder(); //отправить товары из корзины получателю

    public boolean repeatSendAnOrder(int index); //повторить заказ

    public void showBasket(); //показать содержимое корзины
}
