package ru.skillbench.tasks.basics.entity;

public class Main {
    public static void main(String[] args) {
        EmployeeImpl e = new EmployeeImpl();
        e.setFirstName("first");
        e.setLastName("person");
        System.out.println(e.getFullName());
        EmployeeImpl e2 = new EmployeeImpl();
        e2.setFirstName("second");
        e2.setLastName("person (mng)");
       // System.out.println(e2.getFullName());
        e.setManager(e2);
        System.out.println(e.getTopManager().getFullName());

        EmployeeImpl e23 = new EmployeeImpl();
        e23.setFirstName("third");
        e23.setLastName("person (top mng)");
        //System.out.println(e23.getFullName());
        e2.setManager(e23);
        System.out.println(e.getTopManager().getFullName());

    }
}
