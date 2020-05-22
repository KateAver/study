package java2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        String[]arr = {"cat", "dog", "mouse", "goose", "chicken", "monkey", "lion", "giraffe", "cat", "dog",
                "cow", "bear", "horse", "bull", "goose", "pig", "rabbit", "wolf", "bear", "lion", "duck", "mouse", "dog",
                "horse", "goat", "cow", "giraffe", "cat", "leopard", "whale", "dolphin", "rabbit", "hedgehog", "monkey"};
        Set<String> set = new HashSet<>();
        for(int i = 0; i < arr.length; i++){
            set.add(arr[i]);
        }
        System.out.println(set);

        HashMap<String, Integer> hm = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            if(hm.containsKey(arr[i])){
                int oldValue = hm.get(arr[i]);
                hm.put(arr[i], oldValue + 1);
            } else {
                hm.put(arr[i], 1);
            }
        }

        for(String key: hm.keySet()) {
            System.out.println(key + ": " + hm.get(key));
        }
    }
}

class Person {
    String surname;
    String number;
    String email;

    public Person(String surname, String number, String email){
        this.surname = surname;
        this.number = number;
        this.email = email;
    }
}

class PhoneBook {
    private HashMap<String, ArrayList<Person>> hm;

    public void add(Person person){
        if(hm.containsKey(person.surname)){
            ArrayList<Person> oldValue = hm.get(person.surname);
            oldValue.add(person);
            hm.put(person.surname, oldValue);
        } else {
            ArrayList<Person> arr = new ArrayList<>();
            arr.add(person);
            hm.put(person.surname, arr);
        }
    }

    public ArrayList<String> getPhones(String surname){
        ArrayList<Person> people = hm.get(surname);
        ArrayList<String> phones = new ArrayList<>();
        for(Person person: people ){
            phones.add(person.number);
        }
        return phones;
    }

    public ArrayList<String> getEmails(String surname){
        ArrayList<Person> people = hm.get(surname);
        ArrayList<String> emails = new ArrayList<>();
        for(Person person: people ){
            emails.add(person.email);
        }
        return emails;
    }
}
