package hw15;

public class Employee {
    private final String name;
    private final Integer age;

    public String getName(){
        return this.name;
    }

    public Integer getAge(){
        return this.age;
    }

    public Employee(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

}
