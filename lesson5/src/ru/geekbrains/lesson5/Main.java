package ru.geekbrains.lesson5;

public class Main {

    public static void main(String[] args) {
        Employee[] arr = new Employee[5];   //Создали пустой массив сотрудников, длиной 5
        arr[0] = new Employee("Гарри",
                "Поттер",
                "Джеймсович",
                "Волшебник",
                "harry.potter@gmail.com",
                "0987654321",
                0,
                39);
        arr[1] = new Employee("Джон",
                "Сноу",
                "Рэйгарович",
                "Король севера",
                "john.snow@gmail.com",
                "123456789",
                100,
                340);
        arr[2] = new Employee("Шерлок",
                "Холмс",
                "Артурович",
                "Детектив, крутой мужик",
                "sherlok.holms@gmail.com",
                "234567890",
                500,
                45);
        arr[3] = new Employee("Король",
                "Ночи",
                "Зимней",
                "Зима близко",
                "night.king@gmail.com",
                "66666666666666",
                1000000,
                500);
        arr[4] = new Employee("Мужик",
                "Какой то",
                "Бытькович",
                "Все могу",
                "mujik.kakoito@gmail.com",
                "000000000000",
                0,
                40);

        for(int i = 0; i < arr.length; i++) {
            if(arr[i].age > 40) {  // Через точку обращаемся к публичным полям объекта с public
                arr[i].info();   // Чтобы вызвать метод info, который вывод информацию о сотруднике
            }
        }
    }
}

class Employee {  // Создали класс Сотрудник
    public String name, surname, fatherName;
    public String position;
    public String email;
    public String number;
    public int salary;
    public int age;

    public Employee(String name, String surname, String fatherName, String position, String email, String number, int salary, int age) {
        this.name = name;       // this ключевое слово, чтобы метод ссылался на вызвавший его объект
        this.surname = surname; // Им можно пользоваться в теле любого метода для ссылки на текущий объект
        this.fatherName = fatherName;
        this.position = position;
        this.email = email;
        this.number = number;
        this.salary = salary;
        this.age = age;
    }

    public void info() {
        System.out.println("name: " + name + " surname: " + surname + " fatherName: " + fatherName + " position: " +
                position + " email: " + email + " number: " + number + " salary: " + salary + " age: " + age);
    }
}