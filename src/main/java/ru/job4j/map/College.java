package ru.job4j.map;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class College {

    private final Map<Student, Set<Subject>> students;

    public College(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    public Optional<Student> findByAccount(String account) {
        return Optional.of(students.keySet()
                        .stream()
                        .filter(s -> s.account().equals(account))
                        .findFirst())
                .orElse(Optional.empty()
                );
    }

    public Optional<Subject> findBySubjectName(String accountNumber, String name) {
        Optional<Student> account = findByAccount(accountNumber);
        return account.flatMap(student -> students.get(student)
                .stream()
                .filter(s -> s.name().equals(name))
                .findFirst()
        );
    }

    public static void main(String[] args) {
        Map<Student, Set<Subject>> students = Map.of(new Student("Student", "000001", "201-18-15"),
                Set.of(
                        new Subject("Math", 70),
                        new Subject("English", 85)
                )
        );
        College college = new College(students);
        Optional<Student> student = college.findByAccount("000001");
        System.out.println("Найденный студент: " + student);
        Optional<Subject> english = college.findBySubjectName("000001", "English");
        english.ifPresent(subject -> System.out.println("Оценка по найденному предмету: " + subject.score()));
    }
}