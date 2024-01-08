package ru.netology.product;

public class Paints extends AbstractProduct {
    private String color;
    private String materialPaints;

    public Paints(String brand, String nameProduct, String materialPaints, String color) {
        this.setBrand(brand);
        this.setNameProduct(nameProduct);
        this.materialPaints = materialPaints;
        this.color = color;
    }

    public String toString() {
        return "Товар: " + getBrand() +
                " " + getNameProduct() +
                " материал краски: " + this.materialPaints +
                " цвет " + this.color;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paints that = (Paints) o;
        return that.materialPaints == materialPaints && this.color == color && (this.getBrand().equals(that.getBrand())) && (this.getNameProduct().equals(that.getNameProduct()));
    }

    @Override
    public int hashCode() {
        String concatParametrs =
                this.getBrand() +
                        this.getNameProduct() +
                        this.materialPaints +
                        this.color;
        return (concatParametrs.hashCode());
    }

}
