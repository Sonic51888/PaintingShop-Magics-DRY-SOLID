package ru.netology;

import ru.netology.auxiliaryInterface.DeliverySystemInterface;

public class PaintingDeliverySystem implements DeliverySystemInterface {
    private String address;

    private PaintingDeliverySystem() {
    }// запрещаем пустойц контсруктор

    public PaintingDeliverySystem(String address) {
        this.address = address;
    }

    @Override
    public void sendOrder() {
        System.out.println("Товар отправлен по адресу: " + address);
    }
}
