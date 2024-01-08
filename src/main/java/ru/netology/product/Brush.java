package ru.netology.product;

public class Brush extends AbstractProduct{
 private String materialBrush;

    public Brush(String brand, String nameProduct,String materialBrush){
        this.setBrand(brand);
        this.setNameProduct(nameProduct);
        this.materialBrush  = materialBrush;
    }

    public String toString() {
        return "Товар: " + getBrand() +
                " " + getNameProduct() +
                " материал кисти: " + this.materialBrush;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brush that = (Brush) o;
        return that.materialBrush == materialBrush && (this.getBrand().equals(that.getBrand())) && (this.getNameProduct().equals(that.getNameProduct()));
    }

    @Override
    public int hashCode() {
        String concatParametrs = this.getBrand() + this.getNameProduct() + this.materialBrush;
        return (concatParametrs.hashCode());
    }
}
