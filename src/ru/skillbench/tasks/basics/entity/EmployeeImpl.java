package ru.skillbench.tasks.basics.entity;

public class EmployeeImpl implements Employee {
    private int salary = 1000;
    private String first_name, last_name;
    Employee mng;

    public int getSalary() {
        return salary;
    }

    public void increaseSalary(int value) {
        salary += value;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String firstName) {
        first_name = firstName;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String lastName) {
        last_name = lastName;
    }

    public String getFullName() {
        return first_name + ' ' + last_name;
    }

    public void setManager(Employee manager) {
        this.mng = manager;
    }

    public String getManagerName() {

        if (this.mng == null) {
            return "No manager";
        }
        return mng.getFirstName()+' ' +mng.getLastName();
    }

    public Employee getTopManager() {
        if (this.mng != null) {
            return mng.getTopManager();
        }
        return this;
    }
}

