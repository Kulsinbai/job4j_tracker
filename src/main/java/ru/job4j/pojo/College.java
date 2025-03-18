package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFcs("Кульсинбаев Ильяс Гизатович");
        student.setGroup("013");
        student.setDateOfReceipt("25.08.2024");

        System.out.println("ФИО студента: " + student.getFcs());
        System.out.println("Номер группы: " + student.getGroup());
        System.out.println("Дата поступления: " + student.getDateOfReceipt());
    }
}
