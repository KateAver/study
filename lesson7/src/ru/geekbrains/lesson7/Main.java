package ru.geekbrains.lesson7;

public class Main {
    public static void main(String[] args) {
        Plate plate = new Plate(100);
        plate.info();     // С помощью метода info() можно вывести информацию о тарелке

        Cat[]cats = new Cat[3];
        cats[0] = new Cat("Первый кот", 10);
        cats[1] = new Cat("Второй кот", 20);
        cats[2] = new Cat("Друг первого", 100);
        for(int i = 0; i < cats.length; i++) {
            cats[i].eat(plate);
            cats[i].info();
        }
    }
}

class Cat {
    private String name;                   // У него есть имя и аппетит
    private int appetite;
    private boolean full;                  // Full сытый
    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.full = false;
    }

    public void info() {
        if(full) {
            System.out.println(name + " сытый");
        } else {
            System.out.println(name + " голодный");
        }
    }

    public void eat(Plate plate) {
        if (plate.decreaseFood(appetite)) {
            full = true;
        }
    }
}

class Plate {                          // Еда будет храниться здесь
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void info() {
        System.out.println("plate: " + food);
    }

    public void addFood(int n) {
        food = food + n;                         // food += n
        System.out.println("Теперь в тарелке много еды. Хватит есть!");
    }

    public boolean decreaseFood(int n) {          // decrease - уменьшать
        if(food >= n) {
            food = food - n;                     // food -= n (то же самое)
            return true;
        } else {
            return false;
        }
    }

}





