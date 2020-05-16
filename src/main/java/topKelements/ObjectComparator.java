package main.java.topKelements;


import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Demonstrate comparator usages
 */
class ObjectComparator {

    class Employee implements Comparable {
        private String name;
        private int age;

        Employee(String name, int age) {
            this.name = name;
            this.age = age;
        }

        String getName() {
            return name;
        }

        void setName(String name) {
            this.name = name;
        }

        int getAge() {
            return age;
        }

        void setAge(int age) {
            this.age = age;
        }

        @Override
        public boolean equals(Object obj) {
            if(this == obj) {
                return true;
            }
            if(obj instanceof Employee) {
                Employee employee = (Employee)obj;
                return this.getAge() == employee.getAge();
            }
            return false;
        }

        @Override
        public int compareTo(Object o) {
            if(o instanceof Employee) {
                Employee e = (Employee) o;
                return this.getAge() > e.getAge() ? 1 : -1;
            }
            return 0;
        }
    }

    private void sortEmployee(Employee emp1, Employee emp2) {
        List<Employee> employees = Arrays.asList(emp1, emp2);
        Collections.sort(employees);
        for(Employee e : employees){
            System.out.println(e.getName());
        }
    }

    @Test
    void shouldSortEmployees() {
        Employee e1 = new Employee("Tarun", 31);
        Employee e2 = new Employee("Mausam", 32);
        sortEmployee(e1, e2);
    }

}
