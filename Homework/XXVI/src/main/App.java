package main;

import java.util.Calendar;
import java.util.GregorianCalendar;

import data.Address;
import data.Person;
import data.Student;
import data.University;
import util.DataUtility;

public class App {
    public static void main(String[] args) throws Exception {
        Person person = new Person(
            "George",
            "Wilson",
            new GregorianCalendar(1975, Calendar.MARCH, 22).getTime(),
            new Address("USA", "Los Angeles", "Normandie Ave")
        );

        Student student = new Student(
            "Alex",
            "Wilson",
            new GregorianCalendar(2001, Calendar.JANUARY, 3).getTime(),
            new Address("USA", "Los Angeles", "Normandie Ave"),
            4,
            new University(
                "UCLA",
                new Address("USA", "Los Angeles", "Hilgard Avenue")
            ),
            2.4
        );

        Person person2 = DataUtility.copyObject(person);
        Student student2 = DataUtility.copyObject(student);

        //Tests that the objects were copied with correct values.
        //Should output false false true true if copied correctly
        System.out.println(
            (person == person2) + " " + (student == student2)
            + " " +
            (person.equals(person2)) + " " + (student.equals(student2))
        );

        // DataUtility.serializeToFile(student);

        // changed Student field serialVersionUID from 1L to 2L

        // InvalidClassException
        // DataUtility.deserializeFromFile();

        DataUtility.serializeToBase64File(student, "out/student_base64.dat");

        Student deserializedStudent = DataUtility.deserializeFromBase64File("out/student_base64.dat");

        System.out.println(deserializedStudent);
    }
}
