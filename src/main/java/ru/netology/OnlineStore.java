package ru.netology;

import ru.netology.product.*;

import java.util.Scanner;

public class OnlineStore {
    Scanner scanner = new Scanner(System.in);
    Basket basket = new Basket ();//корзина
    PaintingStock paintingStore = new PaintingStock();//

    public void start() {
        AbstractProduct product1 = new Brush("Кристал", "Кисть", "Белка");
        AbstractProduct product2 = new Paints("Гамма", "Краска", "Акварель", "Красный");
        AbstractProduct product3 = new Painting("Малевич", "Холст", 70, 50);
        AbstractProduct product4 = new Brush("Calligrata", "Кисть + мастехин", "Синтетика");
        AbstractProduct product5 = new Paints("Луч", "Краска", "Гуашь", "в ассортименте");
        AbstractProduct product6 = new Painting("Малевич", "Холст", 100, 80);

    }
}
