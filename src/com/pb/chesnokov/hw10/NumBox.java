package com.pb.chesnokov.hw10;

public class NumBox <T extends Number>{

    private int len = 0;
    private final T[] nums;

    public NumBox(int size) {
        this.nums = (T[]) new Number[size];
    }

    public int maxLength() {
        return this.nums.length;
    }

    public void add(T num) {
        try {
            this.nums[this.len] = num;
            this.len++;
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Элемент " + num.toString() + " не добавлен, т.к. массив переполнен.");
        }
    }

    public T get(int index) throws Exception {
        if (index > nums.length)
            throw new Exception("Нет такого элемента");
        return this.nums[index];
    }

    public int length() {
        return this.len;
    }

    public double sum() {
        double s = 0;
        for (int i = 0; i < this.len; i ++)
            s += this.nums[i].doubleValue();
        return s;
    }

    public  double average() {
        return sum() / this.len;
    }



    public <T extends Comparable<T>> T max() {
        T m = (T) this.nums[0];
        for (int i = 1; i < this.len; i ++)
            if (m.compareTo((T) this.nums[i]) < 0)
                m = (T) this.nums[i];
        return m;
    }
}
