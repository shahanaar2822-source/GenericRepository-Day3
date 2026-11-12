
package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Create Generic Repository
        Repository<Student, Integer> repository =
                new InMemoryRepository<>();

        // Add Students
        repository.save(101, new Student(101, "Shahanaa", "IT"));
        repository.save(102, new Student(102, "Rahul", "CSE"));
        repository.save(103, new Student(103, "Priya", "ECE"));

        // Display All Students
        System.out.println("All Students:");
        repository.findAll().forEach(System.out::println);

        // Search Student
        System.out.println("\nSearching Student ID 102:");
        System.out.println(
                repository.findById(102).orElse(null)
        );

        // Delete Student
        repository.delete(103);

        System.out.println("\nAfter Deletion:");
        repository.findAll().forEach(System.out::println);

        // Custom Exception Handling
        System.out.println("\nTesting Exception Handling:");

        try {
            repository.delete(999);
        } catch (EntityNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Export Students to CSV
        System.out.println("\nExporting Students:");

        try {
            FileExporter.exportStudents(
                    repository.findAll(),
                    "students.csv"
            );
        } catch (RepositoryException e) {
            System.out.println("Export Error: " + e.getMessage());
        }

        // Bounded Generics
        System.out.println("\nTesting Bounded Generics:");

        List<Integer> numbers =
                Arrays.asList(10, 20, 30, 40);

        double total = GenericUtils.sumNumbers(numbers);

        System.out.println("Sum of numbers: " + total);

        // PECS Wildcards
        System.out.println("\nTesting PECS Wildcards:");

        List<Integer> source = Arrays.asList(1, 2, 3);
        List<Number> destination = new ArrayList<>();

        GenericUtils.copyItems(source, destination);

        System.out.println("Copied items: " + destination);

        // Completion Message
        System.out.println(
                "\nDay 3 Generic Repository Module Completed!"
        );
    }
}
y