package MyExam.softUni;

import java.util.ArrayList;
import java.util.List;

public class SoftUni {

    private List<Student> students;
    private int capacity;
    private List<Student> data;

    public SoftUni(int capacity) {
        this.capacity = capacity;
        students = new ArrayList<>();
        //data = new ArrayList<>();
    }

    public int getCapacity() {
        // var to return capacity
        return capacity;
    }

    public int getCount() {
        return students.size();
    }

    public String insert(Student student) {
        if (students.contains(student)) {
            return "Student is already in the hall.";
        }
        if (students.size() < capacity) {
            students.add(student);
            return String.format("Added student %s %s.", student.getFirstName(), student.getLastName());
        }
        return "The hall is full.";
    }

    public String remove(Student student) {

        if (students.contains(student)) {
            String text = String.format("Removed student %s %s.", student.getFirstName(), student.getLastName());
            students.remove(student);
            return text;
        }

        return "Student not found.";
    }

    public Student getStudent(String firstName, String lastName) {
        for (Student student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return student;
            }
        }
        return null;
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder(String.format("Hall size: %d%n", students.size()));
        for (Student s : students) {
            sb.append(String.format("%s%n", s.toString()));
        }
        return sb.toString();
    }

}
