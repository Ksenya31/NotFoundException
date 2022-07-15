package ru.netology;

public class Product {
    protected String name;
    protected int id;
    protected int cost;

    public Product(String name, int id, int cost) {
        this.name = name;
        this.id = id;
        this.cost = cost;
    }


    public boolean matches(String query) {
        if (name.contains(query)) {
            return true;
        } else {
            return false;
        }
    }

    public int getId() {
        return id;
    }
}

