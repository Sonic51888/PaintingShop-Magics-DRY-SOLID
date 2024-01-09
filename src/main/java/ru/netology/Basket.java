package ru.netology;

import ru.netology.auxiliaryInterface.DeliverySystemInterface;
import ru.netology.auxiliaryInterface.IntBasket;

import java.util.ArrayList;
import java.util.List;

public class Basket implements IntBasket {//класс корзины

    private String address;
    private static int costBasket;

    private List<AbstractOrder> basketOrders = new ArrayList<>();

    private List<AbstractOrder> basketOrdersFulfilled = new ArrayList<>();

    public Basket() {
    }

    public Basket(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean addToBasket(AbstractOrder abstractOrder) {
        if (abstractOrder.getProductPAA().getAmount() >= abstractOrder.getAmountOrder()) {
            basketOrders.add(abstractOrder);
            abstractOrder.getProductPAA().setAmount(abstractOrder.getProductPAA().getAmount() - abstractOrder.getAmountOrder());
            return true;
        } else {
            System.out.println("Запрошенное количество товара превышает остаток на складе! Заказ не добавлен.");
            return false;
        }
    }

    @Override
    public AbstractOrder getOrder(int index) throws Exception {
        if (index <= basketOrders.size()) {
            return basketOrders.get(index - 1);
        } else {
            throw new Exception("Не существует такой позиции!");
        }
    }

    @Override
    public List<AbstractOrder> getBasketOrdersFulfilled() {
        return basketOrdersFulfilled;
    }

    @Override
    public boolean delToBasket(AbstractOrder order) {
        return basketOrders.remove(order);
    }

    @Override
    public int getCostBasket() {
        basketOrders.stream().forEach(p -> {
            costBasket = costBasket + p.getCostOrder();
        });
        return costBasket;
    }

    @Override
    public boolean sendAnOrder() {
        if (!address.isEmpty()) {
            basketOrders.stream().forEach(o -> o.getProductPAA().setPurchasedOnce(o.getAmountOrder())); //обновляем счетчик продаж товара
            DeliverySystemInterface deliverySystem = new PaintingDeliverySystem(address);
            deliverySystem.sendOrder(); // посылаем товар
            basketOrders.stream().forEach(o -> { //добавляем заказы в исполненные
                basketOrdersFulfilled.add(o);
            });
            basketOrders.clear(); // отчищаем корзину
            return true;
        } else {
            System.out.println("Добавьте адрес доставки.");
            return false;
        }
    }

    @Override
    public boolean repeatSendAnOrder(int index) {
        return this.addToBasket(basketOrdersFulfilled.get(index - 1));
    }

    @Override
    public void showBasket() {
        if (basketOrders.isEmpty()) {
            System.out.println("Корзина пуста. Добавьте товар.");
        } else {
            final int[] count = {1};
            System.out.println("В корзине:\n");
            basketOrders.stream().forEach(o -> {
                System.out.print(count[0] + ". ");
                System.out.println(o.toString());
                count[0] += 1;
            });
            System.out.println("Стоимость товаров в корзине: " + this.getCostBasket() + " руб.");
        }
    }
}
