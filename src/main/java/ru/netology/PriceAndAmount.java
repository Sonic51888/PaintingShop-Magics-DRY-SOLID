package ru.netology;
//клас для хранения информации о цене.количестве покупок продукта
import ru.netology.auxiliaryInterface.IntPriceAndAmount;
import ru.netology.product.AbstractProduct;

public class PriceAndAmount implements IntPriceAndAmount , Comparable {
    private AbstractProduct product;
    private int amount = 0;
    private int price = 0;
    private int purchasedOnce = 0;

    public PriceAndAmount(AbstractProduct product, int amount, int price) {
        this.product = product;
        this.amount = amount;
        this.price = price;
    }

    @Override
    public void setPurchasedOnce(int purchasedOnce) {
        this.purchasedOnce += purchasedOnce;
        System.out.println("Товар приобрели: " + this.purchasedOnce + " раз");
    }

    @Override
    public int getPurchasedOnce() {
        return this.purchasedOnce;
    }

    @Override
    public void setAmount(int amount) {
        if (amount > 0) {
            this.amount += amount;
            System.out.println("Добавлено на склад: " + this.amount + " штук");
        } else {
            System.out.println("Введено некорректное значение!");
        }
    }

    @Override
    public int getAmount() {
        return this.amount;
    }

    @Override
    public void setPrice(int price) {
        if (price > 0) {
            this.price = price;
            System.out.println("Цена установлена на: " + this.price);
        } else {
            System.out.println("Введено некорректное значение!");
        }
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public AbstractProduct getProduct() {
        return this.product;
    }
    @Override
    public int hashCode() {
        String concatParametrs = product.getBrand() + product.getNameProduct();
        return (concatParametrs.hashCode());
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriceAndAmount that = (PriceAndAmount) o;
        return (product.getBrand().equals(that.getProduct().getBrand())) && (product.getNameProduct().equals(that.getProduct().getNameProduct()));
    }
    @Override
    public String toString() {
        return "Товар: " + product.getBrand() + " " + product.getNameProduct() +
                ", цена: " + price +
                ", доступное количество: " + amount;
    }
    public int compareTo(Object o) {
        PriceAndAmount that = (PriceAndAmount) o;
        if (this.purchasedOnce < that.purchasedOnce) {
            return 1;
        } else if (this.purchasedOnce == that.purchasedOnce) {
            return 0;
        } else return -1;

    }
}
