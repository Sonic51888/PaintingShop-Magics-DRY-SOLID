package ru.netology.product;

public class AbstractProduct {

    private String brand;
    private  String nameProduct;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getBrand() {
        return brand;
    }

    public String getNameProduct() {
        return nameProduct;
    }
    @Override
    public String toString() {
        return "Товар: " + brand + " " + nameProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractProduct that = (AbstractProduct) o;
        return (brand.equals(that.brand)) && (nameProduct.equals(that.nameProduct));
    }

    @Override
    public int hashCode() {
        String concatParametrs = brand + nameProduct;
        return (concatParametrs.hashCode());
    }
}
