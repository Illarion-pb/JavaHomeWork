package com.pb.chesnokov.hw7;

public abstract class Clothes {

    protected Size size;
    protected String color;
    protected double price;

    public Clothes() {}

    public Clothes(Size size, String color, double price) {
        this.size = size;
        this.color = color;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Одежда{" +
                "размер=\"" + size.getDescription() +
                "\", цвет='" + color + '\'' +
                ", цена=" + price +
                '}';
    }
}
