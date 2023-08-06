package hw10.User;


public class User {
    private String surname, name, patronymic, email;
    private int birthyear;

    public int getBirthyear() {
        return birthyear;
    }

    public User(String surname, String name, String patronymic, int birthyear, String email) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthyear = birthyear;
        this.email = email;
    }
    public void showUser() {
        System.out.println("ФИО " + this.surname + "  " + this.name + "  " + this.patronymic);
        System.out.println("Год рождения " + this.birthyear);
        System.out.println("email " + this.email);
    }

}
