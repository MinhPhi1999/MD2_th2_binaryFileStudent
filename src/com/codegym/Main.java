package com.codegym;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    // ghi danh sách vào file nhị phân
    public static void writeToFile(String path, List<Student> students) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //lấy ra danh sách trong file student.txt
    public static List<Student> readDataFromFile(String path){
        List<Student> students = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (List<Student>) ois.readObject();
            ois.close();
            fis.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return students;
    }

    public static void main(String[] args) {
        // write your code here
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"Minh","Ha Noi"));
        students.add(new Student(2,"Long","Hue"));
        students.add(new Student(3,"Hung","Ha Nam"));
        students.add(new Student(4,"Bien","Quang Ninh"));
        students.add(new Student(5,"Thanh","Phu Tho"));
        writeToFile("student.txt",students);
        List<Student> studentDataFromFile = readDataFromFile("student.txt");
        for (Student element: studentDataFromFile) {
            System.out.println(element);
        }
    }
}
