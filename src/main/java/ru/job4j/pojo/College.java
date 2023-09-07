package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Иванов И.И.");
        student.setGroup("СПИС22");
        student.setDate("07.08.2023");
        String newLine = System.lineSeparator();
        System.out.println("ФИО: " + student.getName() + newLine
                + "Группа: " + student.getGroup() + newLine
                + "Дата поступления: " + student.getDate());
    }
}
