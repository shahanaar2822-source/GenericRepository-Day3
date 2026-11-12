
package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileExporter {

    public static void exportStudents(
            List<Student> students, String fileName)
            throws RepositoryException {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(fileName))) {

            writer.write("ID,Name,Department");
            writer.newLine();

            for (Student student : students) {
                writer.write(
                        student.getId() + "," +
                                student.getName() + "," +
                                student.getDepartment()
                );
                writer.newLine();
            }

            System.out.println("Students exported successfully!");

        } catch (IOException e) {
            throw new RepositoryException(
                    "Failed to export students: " + e.getMessage(), e
            );
        }
    }
}
