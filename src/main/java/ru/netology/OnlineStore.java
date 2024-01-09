package ru.netology;

import ru.netology.auxiliaryInterface.RecommendationSystemInterface;
import ru.netology.product.AbstractProduct;
import ru.netology.product.Brush;
import ru.netology.product.Painting;
import ru.netology.product.Paints;

import java.util.Scanner;

public class OnlineStore {
    Scanner scanner = new Scanner(System.in);
    Basket basket = new Basket();//корзина
    PaintingStock paintingStock = new PaintingStock();//
    RecommendationSystemInterface recommendationSystemInterface = new PaintingRecommendationSystem();

    private String nextLine;

    public void start() {
        AbstractProduct product1 = new Brush("Кристал", "Кисть", "Белка");
        AbstractProduct product2 = new Paints("Гамма", "Краска", "Акварель", "Красный");
        AbstractProduct product3 = new Painting("Малевич", "Холст", 70, 50);
        AbstractProduct product4 = new Brush("Calligrata", "Кисть + мастехин", "Синтетика");
        AbstractProduct product5 = new Paints("Луч", "Краска", "Гуашь", "в ассортименте");
        AbstractProduct product6 = new Painting("Малевич", "Холст", 100, 80);
        paintingStock.addStore(product1, 200, 100);
        paintingStock.addStore(product2, 300, 50);
        paintingStock.addStore(product3, 300, 100);
        paintingStock.addStore(product4, 500, 50);
        paintingStock.addStore(product5, 200, 40);
        paintingStock.addStore(product6, 50, 1200);

        System.out.println("Добро пожаловать в магазин!");
        System.out.println("Введите адрес доставки товаров:");
        while (true) {
            nextLine = scanner.nextLine();
            if (!nextLine.isEmpty()) {
                basket.setAddress(nextLine);
                break;
            } else {
                System.out.println("Введено пустое значение или пробел");
            }
        }
        System.out.println("Список доступных к покупке товаров:");
        paintingStock.showPriceAndAmount();
        showMenuRoot();
        while (true) {// меню списка доступных действий
            nextLine = scanner.nextLine();
            int commandNumber = 0;
            commandNumber = validationIntScaner(nextLine);
            switch (commandNumber) {
                case 1:
                    paintingStock.showPriceAndAmount();
                    showMenuRoot();
                    break;
                case 2:
                    addToBasket();
                    showMenuRoot();
                    break;
                case 3:
                    basket.showBasket();
                    showMenuBasket();
                    menuBasketExecute();
                    break;
                case 4:
                    recommendationSystemInterface.weRecommend(paintingStock.getListPriceAndAmount());
                    showMenuRoot();
                    break;
                case 5:
                    System.out.println("\nВведите ключевое слово: ");
                    nextLine = scanner.nextLine();
                    System.out.printf("Список отфильтрованный по ключевому слову \"%s\":\n\n", nextLine);
                    paintingStock.filterByKeyWord(nextLine);
                    showMenuRoot();
                    break;
                case 6:
                    int priceFilter = 0;
                    System.out.println("\nВведите цену для сортровки: ");
                    nextLine = scanner.nextLine();
                    priceFilter = validationIntScaner(nextLine);
                    System.out.println("\nВведите направление сортировки (\"больше\" или \"меньше\": ");
                    nextLine = scanner.nextLine();
                    if ("больше".equals(nextLine)) {
                        paintingStock.filterByPrice(priceFilter, true);
                    } else if ("меньше".equals(nextLine)) {
                        paintingStock.filterByPrice(priceFilter, false);
                    } else {
                        System.out.println("Вы ввели некорректное значение!");
                    }
                    showMenuRoot();
                    break;
                case 7:
                    System.out.println("\nВведите производителя: ");
                    nextLine = scanner.nextLine();
                    System.out.printf("Список отфильтрованный по производителю \"%s\":\n\n", nextLine);
                    paintingStock.filterByBrand(nextLine);
                    showMenuRoot();
                    break;
                case 8:
                    paintingStock.sortedByRating();
                case 9:
                    System.exit(0);
                default:
                    System.out.println("Выберите действие.");
            }
        }
    }

    private void menuBasketExecute() {
        String nextLine;
        while (true) {
            int commandNumber = 0;
            nextLine = scanner.nextLine();
            commandNumber = validationIntScaner(nextLine);
            switch (commandNumber) {
                case 1:
                    basket.showBasket();
                    showMenuBasket();
                    break;
                case 2:
                    System.out.println("Стоимость товаров в корзине: " + basket.getCostBasket() + " руб.");
                    showMenuBasket();
                    break;
                case 3:
                    addToBasket();
                    showMenuBasket();
                    break;
                case 4:
                    System.out.print("\nВвведите номер удаляемой позиции в корзине: ");
                    nextLine = scanner.nextLine();
                    commandNumber = validationIntScaner(nextLine);
                    try {
                        if (basket.delToBasket(basket.getOrder(commandNumber))) {
                            System.out.println("\nТовар успешно удален из корзины");
                        } else {
                            System.out.println("Ошибка удаления товара из корзины.\n");
                        }
                    } catch (Exception e) {
                        System.out.println("Ошибка удаления товара из корзины.\n");
                        break;
                    }
                    showMenuBasket();
                    break;
                case 5:
                    if (basket.sendAnOrder()) {
                        System.out.println("Товары из корзины успешно отправлены по адресу: " + basket.getAddress());
                    }
                    showMenuBasket();
                    break;
                case 6:
                    System.out.println("Выполненные заказы: ");
                    if (basket.getBasketOrdersFulfilled().isEmpty()) {
                        System.out.println("Выполненные заказы отсутствуют.");
                    } else {
                        final int[] count = {1};
                        System.out.println("Ранее вы купили:\n");
                        basket.getBasketOrdersFulfilled().stream().forEach(o -> {
                            System.out.print(count[0] + ". ");
                            System.out.println(o.toString());
                            count[0] += 1;
                        });
                    }
                    System.out.print("Введите номер заказа для его повтора: ");
                    nextLine = scanner.nextLine();
                    commandNumber = validationIntScaner(nextLine);
                    if (basket.repeatSendAnOrder(commandNumber)) {
                        System.out.println("Заказ успешно повторён.");
                    } else {
                        System.out.println("Ошибка повторения заказа");
                    }
                    showMenuBasket();
                    break;
                case 7:
                    showMenuRoot();
                    break;
            }
            if (nextLine.equals("7")) {
                break;
            }
        }
    }


    private void addToBasket() {
        System.out.print("\nВвведите номер товара: ");
        String nextLine = scanner.nextLine();
        var numberProduct = validationIntScaner(nextLine);
        System.out.print("\nВвведите требуемое количество: ");
        nextLine = scanner.nextLine();
        var amountProduct = validationIntScaner(nextLine);
        AbstractOrder order = new Order(paintingStock.getPriceAndAmount(numberProduct - 1), amountProduct);
        if (basket.addToBasket(order)) {
            System.out.format("\nТовар %s %s в количестве %d шт. добавлен в корзину.\n", order.getProductPAA().getProduct().getBrand(), order.getProductPAA().getProduct().getNameProduct(), amountProduct);
        } else {
            System.out.println("Ошибка добавления товара в корзину.\n");
        }
    }

    private int validationIntScaner(String valueStr) {
        int valueInt = 0;
        try {
            valueInt = Integer.parseInt(valueStr);
        } catch (NumberFormatException e) {
            System.out.println("Введите корректное значение!");
        }
        return valueInt;
    }

    private void showMenuRoot() {
        System.out.println("\nОНОВНОЕ МЕНЮ\n" +
                "1. Показать список доступных к покупке товаров.\n" +
                "2. Добавить в корзину.\n" +
                "3. Показать корзину.\n" +
                "4. Просмотреть рекомендацию.\n" +
                "5. Фильтрация товаров по ключевым словам.\n" +
                "6. Фильтрация товаров по ценам.\n" +
                "7. Фильтрация товаров по производителям.\n" +
                "8. Фильтрация по рейтингу (кол-ву уже сделанных покупок.)\n" +
                "9. Выход из магазина.\n" +
                "Ведите номер команды: "
        );

    }

    private void showMenuBasket() {
        System.out.println("\nКорзина меню\n" +
                "1. Показать список товаров в корзине.\n" +
                "2. Показать стоимость товаров в корзине.\n" +
                "3. Добавить товар в корзину.\n" +
                "4. Удалить твар из корзины.\n" +
                "5. Отправить заказ.\n" +
                "6. Повторить заказ.\n" +
                "7. Возврат в предыдущее(корневое) меню.\n" +
                "Ведите номер команды: "
        );
    }
}
