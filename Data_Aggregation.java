import java.util.Map;
import java.util.HashMap;

class Student {
    String name;
    char grade;

    Student(String name, char grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public char getGrade() {
        return grade;
    }
}

public class Main {
    public static void main(String[] args) {
        String letters = "ABC";
        Student[] students = new Student[10];
        int a = 0, b = 0, c = 0;

        for (int i = 0; i < students.length; i++) {
            int randomIndex = (int) (Math.random() * letters.length());
            char randomChar = letters.charAt(randomIndex);
            students[i] = new Student("John " + i, randomChar);

            if (randomChar == 'A') a++;
            else if (randomChar == 'B') b++;
            else if (randomChar == 'C') c++;
        }


        Student[] aStudents = new Student[a];
        Student[] bStudents = new Student[b];
        Student[] cStudents = new Student[c];


        int ai = 0, bi = 0, ci = 0;
        for (Student s : students) {
            if (s.getGrade() == 'A') aStudents[ai++] = s;
            else if (s.getGrade() == 'B') bStudents[bi++] = s;
            else if (s.getGrade() == 'C') cStudents[ci++] = s;
        }


        Map<String, Character> a_map = new HashMap<>();
        for (Student obj : aStudents) {
            a_map.put(obj.getName(), obj.getGrade());
        }

        Map<String, Character> b_map = new HashMap<>();
        for (Student obj : bStudents) {
            b_map.put(obj.getName(), obj.getGrade());
        }

        Map<String, Character> c_map = new HashMap<>();
        for (Student obj : cStudents) {
            c_map.put(obj.getName(), obj.getGrade());
        }


        System.out.println("Number of A students: " + a_map.size());
        System.out.println("Number of B students: " + b_map.size());
        System.out.println("Number of C students: " + c_map.size());
    }
}
