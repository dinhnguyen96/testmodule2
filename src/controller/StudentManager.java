package controller;

import model.Student;
import storage.ReadWrite;
import storage.StudentReadWrite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentManager implements ApplicationManager<Student>
{

    private ReadWrite<Student> studentReadWrite ;


    private List<Student> studentList;


    public static boolean studentDataStatus = false;


    public StudentManager()
    {
        studentReadWrite = StudentReadWrite.getInstance();
        studentList = studentReadWrite.readFile();
    }

    @Override
    public List<Student> readFile()
    {
        if (studentList == null)
        {
            studentList = new ArrayList<>();
        }
        else
        {
            if (studentDataStatus)
            {
                studentList = studentReadWrite.readFile();
            }
        }
        return studentList;
    }

    @Override
    public void writeFile(List<Student> studentList)
    {
       studentReadWrite.writeFile(studentList);
    }

    @Override
    public void display()
    {
        if (readFile().size() > 0)
        {
            System.out.println("Danh sách sinh viên");
            for (Student student : readFile())
            {
                System.out.println("Student code : " + student.getStudentCode());
                System.out.println("Student name : " + student.getName());
                System.out.println("Student age : " + student.getAge());
                System.out.println("Student gender : " + student.getGender());
                System.out.println("Student address : " + student.getAddress());
                System.out.println("Student averageScore : " + student.getAverageScore());
            }
        }
        else
        {
            System.out.println("Danh sách trống");
        }
    }
    @Override
    public Student get(String code)
    {
        for (Student student : readFile())
        {
            if (student.getStudentCode().equalsIgnoreCase(code))
            {
                return student;
            }
        }
        return null;
    }
    @Override
    public boolean add(Student student)
    {
        Student s = get(student.getStudentCode());
        if (s != null)
        {
            return false;
        }
        List<Student> students = readFile();
        students.add(student);
        writeFile(students);
        return true;
    }

    @Override
    public void update(Student student)
    {
        List<Student> students = readFile();
        students.set(students.indexOf(student), student);
        writeFile(students);
    }

    @Override
    public void remove(Student student)
    {
        List<Student> students = readFile();
        students.remove(student);
        writeFile(students);
    }

    @Override
    public void sortByScoreAscending()
    {
       readFile().sort((student1, student2) -> (int) (student1.getAverageScore() - student2.getAverageScore()));
    }

    @Override
    public void sortByScoreDescending()
    {
        readFile().sort((student1, student2) -> (int) (student2.getAverageScore() - student1.getAverageScore()));

    }

}
