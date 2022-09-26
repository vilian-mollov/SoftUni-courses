package WorkingWithAbstraction.StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {

    private Map<String, Student> repo;

    public StudentSystem() {
        this.repo = new HashMap<>();
    }
    
    public void create(String[] data) {
        String name = data[1];
        int age = Integer.parseInt(data[2]);
        double grade = Double.parseDouble(data[3]);

        if (!repo.containsKey(name)) {
            var student = new Student(name, age, grade);
            repo.put(name, student);
        }

    }

    public String show(String[] data) {
        String name = data[1];

        if (repo.containsKey(name)) {
            Student student = repo.get(name);
            String outputText = String.format("%s is %d years old.", student.getName(), student.getAge());

            outputText = getStudentGradeRate(student, outputText);

            return outputText;
        }

        return "There is no such student!";
    }

    private static String getStudentGradeRate(Student student, String outputText) {
        if (student.getGrade() >= 5.00) {
            outputText += " Excellent student.";
        } else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
            outputText += " Average student.";
        } else {
            outputText += " Very nice person.";
        }
        return outputText;
    }

}
