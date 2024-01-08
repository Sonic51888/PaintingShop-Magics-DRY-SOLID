package ru.netology.product;

public class Painting  extends  AbstractProduct{
    private int height;
    private int width;

    public Painting (String brand, String nameProduct, int height, int width){
        this.setBrand(brand);
        this.setNameProduct(nameProduct);
        this.height = height;
        this.width = width;
    }

    @Override
    public String toString() {
        return "Товар: " + getBrand() +
                " " + getNameProduct() +
                " высота холста: " + this.height+
                " ширина: " +this.width;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Painting that = (Painting) o;
        return that.height == height && that.width == width && (this.getBrand().equals(that.getBrand())) && (this.getNameProduct().equals(that.getNameProduct()));
    }

    @Override
    public int hashCode() {
        String concatParametrs = this.getBrand() + this.getNameProduct() + Integer.toString(height) + Integer.toString(width);
        return (concatParametrs.hashCode());
    }
}
