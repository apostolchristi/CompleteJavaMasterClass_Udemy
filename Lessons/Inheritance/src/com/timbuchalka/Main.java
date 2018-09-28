package com.timbuchalka;

public class Main {

    public static void main(String[] args) {

        Animal animal = new Animal("Animal", 1, 1, 5, 5);
        Dog dog = new Dog("Yorkie", 8, 20, 2, 2, 1, 20, "loong");

        dog.eat();
        dog.walk();
        dog.run();

    }
}
