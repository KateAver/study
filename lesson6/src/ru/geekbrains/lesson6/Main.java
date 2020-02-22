package ru.geekbrains.lesson6;

public class Main {

    public static void main(String[] args) {

        Cat cat1 = new Cat();
        Dog dog1 = new Dog();

        cat1.run(100);
        cat1.run(500);

        cat1.jump(2);
        cat1.jump(5);

        cat1.swim(50);

        dog1.run(200);
        dog1.run(600);

        dog1.jump(0.2);
        dog1.jump(0.6);

        dog1.swim(5);
        dog1.swim(20);
    }

}

class Animal {
    public void jump(double height) {
        System.out.println("Животное подпрыгнуло на " + height);

    }

    public void swim(double length) {
        System.out.println("Животное проплыло " + length);

    }

    public void run(double length) {
        System.out.println("Животное пробежало " + length);
    }

}

class Cat extends Animal {    // Cat подкласс Animal (Animal является супер классом для Cat)
    @Override
    public void run(double length) {
        if(length <= 200) {
            System.out.println("Кошка пробежала " + length);
        } else {
            System.out.println("Слишком длинная дистанция для кошки " + length);
        }
    }

    @Override
    public void jump(double height) {
        if(height <= 2) {
            System.out.println("Кошка пропрыгала " + height);
        } else {
            System.out.println("Слишком высоко для кошки " + height);
        }
    }

    @Override
    public void swim(double length) {
        System.out.println("Кошка не умеет плавать");
    }
}
class Dog extends Animal {

    @Override
    public void run(double length) {
        if(length <= 500) {
            System.out.println("Собака пробежала " + length);
        } else {
            System.out.println("Слишком длинная дистанция для собаки " + length);
        }
    }

    @Override
    public void jump(double height) {
        if(height <= 0.5) {
            System.out.println("Собака пропрыгала " + height);
        } else {
            System.out.println("Слишком высоко для собаки " + height);
        }
    }

    @Override
    public void swim(double length) {
        if(length <= 10) {
            System.out.println("Собака проплыла " + length);
        } else {
            System.out.println("Слишком длинная дистанция для собаки " + length);
        }
    }







}
