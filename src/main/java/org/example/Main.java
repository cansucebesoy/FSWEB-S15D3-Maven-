package org.example;


import org.example.entity.Employee;

import java.util.*;

public class Main {

    private static Map<Integer, Employee> employeeMap;

    private static List<Employee> duplicatedEmployees;

    public static void main(String[] args) {

        Map<String, Integer> wordCount = WordCounter.calculatedWord();

        System.out.println(wordCount.entrySet());
        System.out.println("*****************************");
        for(Map.Entry<String, Integer> entry : wordCount.entrySet()){
            System.out.println("Kelime: " + entry.getKey() + " - Sayi: " + entry.getValue());
        }

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1,"cansu","cebesoy"));
        employees.add(new Employee(1,"cansu","cebesoy"));
        employees.add(new Employee(1,"cansu","cebesoy"));
        employees.add(new Employee(2,"berke","tinas"));
        employees.add(new Employee(2,"berke","tinas"));
        employees.add(new Employee(3,"mert","turker"));
        employees.add(new Employee(4,"ecem","duran"));
        employees.add(new Employee(5,"emel","ozturk"));

        System.out.println(findDuplicates(employees));
        System.out.println(findUniques(employees));
        System.out.println(removeDuplicates(employees));

    }
    public static List<Employee> findDuplicates(List<Employee>  employees){
        employeeMap = new HashMap<>();
        duplicatedEmployees = new LinkedList<>();
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()){
            Employee employee = iterator.next();
            if(employee == null){
                System.out.println("null record");
                continue; //islem yapmadan bi sonraki elemana atlar
            }
            if(employeeMap.containsKey(employee.getId())){
                duplicatedEmployees.add(employee);
            }else{
                employeeMap.put(employee.getId(), employee);
            }
        }
        return duplicatedEmployees;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> employees){
        employeeMap = new HashMap<>();  //tekrar olusturduk cunku dublicatte olusturulmus olandan devam etmemesi icin
        Iterator<Employee> iterator = employees.iterator();
        while(iterator.hasNext()){
            Employee employee = iterator.next();
            if(employee == null){
                System.out.println("null record");
                continue;
            }
            if(!employeeMap.containsKey(employee.getId())){
                employeeMap.put(employee.getId(), employee);
            }
        }
        return employeeMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees){
        List<Employee> duplicates = findDuplicates(employees);
        Map<Integer, Employee> uniques = findUniques(employees);
        List<Employee> onlyUnique = new LinkedList<>(uniques.values());
        //find unique - duplicate and use removeAll
        onlyUnique.removeAll(duplicates);
        return onlyUnique;
    }

}