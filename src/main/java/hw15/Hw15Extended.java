package hw15;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Hw15Extended {
    public static void main(String[] args) {
        List<Employee> empLst = new ArrayList(10);
        empLst.add(new Employee("Саша", 45));
        empLst.add(new Employee("Миша", 13));
        empLst.add(new Employee("Паша", 40));
        empLst.add(new Employee("Вася", 30));
        empLst.add(new Employee("Люда", 23));
        empLst.add(new Employee("Марина", 45));
        empLst.add(new Employee("Галя", 90));
        empLst.add(new Employee("Вика", 30));
        empLst.add(new Employee("Sasha", 30));
        empLst.add(new Employee("Gena", 30));
        empLst.add(new Employee("Vovka", 30));
        System.out.println(getNames(empLst));

        System.out.println(getBiggerAgeNames(empLst, 40));

        System.out.println("Cредний возраст сотрудников превышает указанный аргумент:" + ifMinAverAgeOlder(empLst, 35));

        System.out.println("Cамый младший сотрудник:" + theYoungestEmployee(empLst).getName() );

    }

    //    Реализуйте метод, принимающий в качестве аргумента список сотрудников, и возвращающий список их имен;
    public static List<String> getNames(List<Employee> employeeList) {
        List<String> names = new ArrayList<>();
        Iterator<Employee> iter = employeeList.iterator();
        while (iter.hasNext()) {
            names.add(iter.next().getName());
        }
        return names;
    }

    //        Реализуйте метод, принимающий в качестве аргумента список сотрудников и минимальный возраст, и
    //        возвращающий список сотрудников, возраст которых больше либо равен указанному аргументу
    public static List<String> getBiggerAgeNames(List<Employee> employeeList, Integer ageLimit) {
        List<String> names = new ArrayList<>();
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getAge() >= ageLimit) {
                names.add(employeeList.get(i).getName());
            }
        }
        return names;
    }

    //    Реализуйте метод, принимающий в качестве аргумента список сотрудников и минимальный средний возраст, и
    //    проверяющий что средний возраст сотрудников превышает указанный аргумент;
    public static boolean ifMinAverAgeOlder(List<Employee> employeeList, Integer minAverAge) {
        int realAverageAge = 0;
        int ageSum = 0;
        for (int i = 0; i < employeeList.size(); i++) {
            ageSum += employeeList.get(i).getAge();
        }
        realAverageAge = ageSum / employeeList.size();
        return  realAverageAge > minAverAge;
    }

    //    Реализуйте метод, принимающий в качестве аргумента список сотрудников, и возвращающий ссылку на самого
    //    молодого сотрудника.
    public static Employee theYoungestEmployee(List<Employee> employeeList) {
        int youngestAge = employeeList.get(0).getAge();
        int youngestAgeIndex = 0;
        for (int i = 1; i < employeeList.size(); i++) {
            if ( youngestAge > employeeList.get(i).getAge() ) {
                youngestAge = employeeList.get(i).getAge();
                youngestAgeIndex = i;
            }
        }
        return  employeeList.get(youngestAgeIndex);
    }
}
