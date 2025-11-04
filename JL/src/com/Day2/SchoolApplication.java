package com.Day2;
class Person {
    String name;
    String dateOfBirth;

    Person(String name, String dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Date of Birth: " + dateOfBirth);
    }
}

class Teacher extends Person {
    double salary;
    String subject;

    Teacher(String name, String dateOfBirth, double salary, String subject) {
        super(name, dateOfBirth);
        this.salary = salary;
        this.subject = subject;
    }

    void displayTeacherInfo() {
        displayInfo();
        System.out.println("Subject: " + subject);
        System.out.println("Salary: " + salary);
        System.out.println("--------------------------");
    }
}

class Student extends Person {
    String studentId;

    Student(String name, String dateOfBirth, String studentId) {
        super(name, dateOfBirth);
        this.studentId = studentId;
    }

    void displayStudentInfo() {
        displayInfo();
        System.out.println("Student ID: " + studentId);
        System.out.println("--------------------------");
    }
}

class CollegeStudent extends Student {
    String collegeName;
    int year; // 1 - First Year, 2 - Second Year, etc.

    CollegeStudent(String name, String dateOfBirth, String studentId, String collegeName, int year) {
        super(name, dateOfBirth, studentId);
        this.collegeName = collegeName;
        this.year = year;
    }

    void displayCollegeStudentInfo() {
        displayStudentInfo();
        System.out.println("College Name: " + collegeName);
        System.out.println("Year of Study: " + year);
        System.out.println("--------------------------");
    }
}
public class SchoolApplication {
    public static void main(String[] args) {

        // Creating Teacher Object
        Teacher t = new Teacher("Rahul Sharma", "15-08-1980", 50000, "Mathematics");
        t.displayTeacherInfo();

        // Creating Student Object
        Student s = new Student("Amit Kumar", "10-10-2005", "ST1025");
        s.displayStudentInfo();

        // Creating College Student Object
        CollegeStudent cs = new CollegeStudent("Priya Verma", "05-03-2004", "CS2021", "ABC College", 2);
        cs.displayCollegeStudentInfo();
    }
}
