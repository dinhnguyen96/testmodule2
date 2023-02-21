package model;

import java.io.Serializable;

public class Student implements Serializable
{
    private long id;
    private String studentCode;
    private String name;
    private int age;
    private String gender;
    private String address;
    private double averageScore;

    public Student(long id, String studentCode, String name, int age, String gender, String address, double averageScore) {
        this.id = id;
        this.studentCode = studentCode;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.averageScore = averageScore;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }
}
