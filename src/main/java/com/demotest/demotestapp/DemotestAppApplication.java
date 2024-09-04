package com.demotest.demotestapp;

import com.demotest.dao.interfaces.StudentDAO;
import com.demotest.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import java.util.List;

/**
 * This annotation `@SpringBootApplication` is the primary annotation used for starting the `Spring Boot Application`
 * The attribute `scanBasePackages` is used to find packages outside the `com.demotest.demotestapp` folder i.e. on a level
 * higher than the apps level or in another directory.
 * `@EntityScan` this is used to specify the location of the entities(database schemas of sorts) when they are not in the same
 * package level as the app boot file.
 */

@SpringBootApplication(
        scanBasePackages = {
                "com.demotest.demotestapp",
                "com.demotest.util",
                "com.demotest.config",
                "com.demotest.entity",
                "com.demotest.dao",
        }
)
@EntityScan(basePackages = "com.demotest.entity")
public class DemotestAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemotestAppApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return (x) -> {
            createStudent(studentDAO);
//            readStudent(studentDAO);
//            queryForStudents(studentDAO);
//            queryForStudentsWithLastName(studentDAO);
//            updateStudent(studentDAO);
//            deleteStudent(studentDAO);
//            deleteAllStudents(studentDAO);
        };
    }

    /**
     * This method deletes all students from the Students table in the database
     * `@param studentDAO`
     */

    private void deleteAllStudents(StudentDAO studentDAO) {
        boolean flag = false;
        if (flag) {
            System.out.println("Number of deleted students: " + studentDAO.deleteAll());
        } else {
            System.out.println("Flag is false");
        }
    }

    /**
     * This method deletes a certain student with a given id
     * `@param studentDAO`
     */

    private void deleteStudent(StudentDAO studentDAO) {
        int studentId = 3;
        System.out.println("Deleting student with id: " + studentId);
        studentDAO.delete(studentId);
    }

    /**
     * This method updated a student with a given id
     * `@param studentDAO`
     */

    private void updateStudent(StudentDAO studentDAO) {
        int studentId = 3;
        System.out.println("Getting student with the id: " + studentId);
        Student myStudent = studentDAO.findById(studentId);

        System.out.println("Updating the student: ");
        myStudent.setFirstName("John");

        studentDAO.update(myStudent);

        System.out.println("Updated student: " + myStudent);
    }

    /**
     * This is a query to get all the Students from the database who have sed last name
     * `@param studentDAO`
     */

    private void queryForStudentsWithLastName(StudentDAO studentDAO) {
        List<Student> students = studentDAO.findByFirstName("Kiko");
        students.forEach(System.out::println);
    }

    /**
     * This is a query to get all the Students from the database.
     * `@param studentDAO`
     */

    private void queryForStudents(StudentDAO studentDAO) {
        List<Student> students = studentDAO.findAll();

        students.forEach(System.out::println);
    }


    /**
     * This is a sort of http GET method for sending to the backend to retrieve an element for the database.
     */

    private void readStudent(StudentDAO studentDAO) {

        System.out.println("Creating a new student object...");
        Student student = new Student("Daffy", "Duck", "kikom@gmial.com");

        System.out.println("Saving the student ...");
        studentDAO.save(student);

        int id = student.getId();
        System.out.println("Saved student. Generated id: " + student.getId());

        System.out.println("Retrieving student by id: " + id);
        Student myStudent = studentDAO.findById(id);

        System.out.println("Retrieved student: " + myStudent);

    }

    /**
     * This is a sort of http POST method for sending to the backend and creating a new element and then storing it int the database.
     */


    private void createStudent(StudentDAO studentDAO) {

        System.out.println("Creating new student object ...");
        Student tempStudent = new Student("Kiko2", "Mij2", "kikom2@gmail.com");

        System.out.println("Saving the student ...");
        studentDAO.save(tempStudent);

        System.out.printf("Saved student. Generated id: %d\n", tempStudent.getId());

    }


}
