package ru.netology;

import ru.netology.auxiliaryInterface.*;
import ru.netology.product.AbstractProduct;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//склад магазина
public class PaintingStock implements Stock {
    private List<IntPriceAndAmount> paintingStock = new ArrayList<>();

    @Override
    public void addStore(AbstractProduct abstractProduct, int amountProduct, int priceProduct) {
        if (!(paintingStock.stream().filter(object -> object.getProduct().equals(abstractProduct)).count() > 0)) {//проверяется отсутствие повторений позиции на складе
            paintingStock.add(new PriceAndAmount(abstractProduct, amountProduct, priceProduct));//если товара нет добавляет его
        } else {
            System.out.printf("Данный товар %s уже имеется на складе.\n", abstractProduct.getBrand() + " " + abstractProduct.getNameProduct());//отбивка
        }
    }

    @Override
    public void deleteStore(IntPriceAndAmount priceAndAmount) {
        paintingStock.remove(priceAndAmount);
    }

    @Override
    public void setPriceProduct(IntPriceAndAmount priceAndAmount, int price) {
        int i = paintingStock.indexOf(priceAndAmount);//получаем индекс переданного товара
        paintingStock.get(i).setPrice(price);//меняем цену в данном товаре
    }

    @Override
    public int getPriceProduct(IntPriceAndAmount priceAndAmount) {
        int i = paintingStock.indexOf(priceAndAmount);//получаем индекс переданного товара
        return paintingStock.get(i).getPrice();//получаем цену данного товара
    }

    @Override
    public void setAmountProduct(IntPriceAndAmount priceAndAmount, int amount) {
        int i = paintingStock.indexOf(priceAndAmount);//получаем индекс переданного товара
        paintingStock.get(i).setAmount(amount);//меняем цену в данном товаре
    }

    @Override
    public int getAmountProduct(IntPriceAndAmount priceAndAmount) {
        int i = paintingStock.indexOf(priceAndAmount);//получаем индекс переданного товара
        return paintingStock.get(i).getAmount();//получаем кол-во данного товара
    }

    @Override
    public IntPriceAndAmount getPriceAndAmount(int index) {
        return paintingStock.get(index);
    }

    @Override
    public void showPriceAndAmount() {
        paintingStock.stream().forEach(object -> {
            System.out.format("%d |%-40s| Цена руб.: %-10d| Доступное кол-во: %-10d| Куплено шт.: %d \n",
                    paintingStock.indexOf(object) + 1,
                    object.getProduct(),
                    object.getPrice(),
                    object.getAmount(),
                    object.getPurchasedOnce());
        });
    }

    @Override
    public List<IntPriceAndAmount> getListPriceAndAmount() {
        return paintingStock;
    }

    public void sortedByRating() {
        paintingStock.stream().sorted().forEach(object -> {
            System.out.format("%d |%-40s| Цена руб.: %-10d|  Доступное кол-во: %-10d| Куплено шт.: %d \n",
                    paintingStock.indexOf(object) + 1,
                    object.getProduct(),
                    object.getPrice(),
                    object.getAmount(), object.getPurchasedOnce());
        });
    }

    public void filterByBrand(String brand) {
        List<IntPriceAndAmount> paintingStoreFiltered = new ArrayList<>(paintingStock.stream()
                .filter(o -> brand.toLowerCase()
                        .equals(o.getProduct()
                                .getBrand()
                                .toLowerCase()))
                .collect(Collectors.toList()));
        if (paintingStoreFiltered.isEmpty()) {
            System.out.println("Не найдено подходящих товаров!");
        } else {
            paintingStoreFiltered.stream().forEach(System.out::println);
        }
    }

    public void filterByPrice(int border, boolean moreOrLess) {
        if (moreOrLess) {
            paintingStock.stream().filter(o -> o.getPrice() > border).forEach(System.out::println);
        } else {
            paintingStock.stream().filter(o -> o.getPrice() < border).forEach(System.out::println);
        }

    }

    public void filterByKeyWord(String key) {
        List<IntPriceAndAmount> paintingStoreFiltered = new ArrayList<>(paintingStock.stream()
                .filter(o -> o.getProduct()
                        .getNameProduct()
                        .toLowerCase()
                        .contains(key.toLowerCase()) || o.getProduct()
                        .getBrand().toLowerCase()
                        .contains(key.toLowerCase()))
                .collect(Collectors.toList()));
        if (paintingStoreFiltered.isEmpty()) {
            System.out.println("Не найдено подходящих товаров!");
        } else {
            paintingStoreFiltered.stream().forEach(System.out::println);
        }
    }
}
