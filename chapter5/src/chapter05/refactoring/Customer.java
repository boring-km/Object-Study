package chapter05.refactoring;

public class Customer {

    private final String name;
    private final String id;

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Customer(String name, String id) {
        this.name = name;
        this.id = id;
    }
}