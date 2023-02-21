package view;

import controller.ApplicationManager;
import controller.StudentManager;
import model.Student;

import java.util.List;
import java.util.Scanner;

public class Client
{

    private static ApplicationManager<Student> studentApplicationManager = new StudentManager();


    public static void displayStudent()
    {
        studentApplicationManager.display();
    }

    public static void sortStudent()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("---Sắp xếp sinh viên theo điểm trung bình--- ");
        boolean result = false;
        do {
            try
            {
                System.out.println("1.Sắp xếp điểm trung bình tăng dần");
                System.out.println("2.Sắp xếp điểm trung bình giảm dần");
                System.out.print("Chọn chức năng : ");
                int functionNumber = Integer.parseInt(input.nextLine());
                switch (functionNumber)
                {
                    case 1->{
                        studentApplicationManager.sortByScoreAscending();
                        displayStudent();
                    }
                    case 2 -> {
                        studentApplicationManager.sortByScoreDescending();
                        displayStudent();
                    }
                    case 3 ->{
                        System.exit(3);
                    }
                }
                result = true;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Nhập dữ liệu không hợp lệ !");
            }
        }
        while (!result);
    }



    public static void updateStudent()
    {
        Scanner input = new Scanner(System.in);
        boolean result = false;
        System.out.println("Cập nhật thông tin sinh viên");
        do {
            System.out.print("Student Code : ");
            String studentCode = input.nextLine();
            if (studentCode.equalsIgnoreCase(""))
            {
                studentMenuManager();
                return;
            }
            Student student = studentApplicationManager.get(studentCode);
            if (student == null)
            {
                System.out.println("Không tìm được sinh viên với mã sinh viên");
            }
            else
            {
                try
                {
                    System.out.print("Student Code : ");
                    studentCode = input.nextLine();
                    System.out.print("Student Name : ");
                    String studentName = input.nextLine();
                    System.out.print("Student Age : ");
                    int age = Integer.parseInt(input.nextLine());
                    System.out.print("Student Gender : ");
                    String gender = input.nextLine();
                    System.out.print("Student Address : ");
                    String address = input.nextLine();
                    System.out.print("Student AverageScore :");
                    double averageScore = Double.parseDouble(input.nextLine());
                    student.setName(studentName);
                    student.setStudentCode(studentCode);
                    student.setAge(age);
                    student.setAddress(address);
                    student.setAverageScore(averageScore);
                    student.setGender(gender);
                    studentApplicationManager.update(student);
                    System.out.println("Cập nhật thành công !");
                    result = true;
                    StudentManager.studentDataStatus = true;
                }
                catch (NumberFormatException e)
                {
                    System.out.println("Nhập dữ liệu không hợp lệ !");
                }
            }
        }
        while (!result);
    }
    public static void removeStudent()
    {
        Scanner input = new Scanner(System.in);
        boolean result = false;
        System.out.println("Xóa thông tin sinh viên");
        do {
            System.out.println("Student Code : ");
            String studentCode = input.nextLine();
            if (studentCode.equalsIgnoreCase(""))
            {
                studentMenuManager();
                return;
            }
            Student student = studentApplicationManager.get(studentCode);
            if (student == null)
            {
                System.out.println("Không tìm được sinh viên với mã sinh viên");
            }
            else
            {
                System.out.print("Bạn muốn xóa sinh viên này phải không");
                String confirm = input.nextLine();
                if (confirm.equals("Y"))
                {
                    System.out.println("Xóa thành công");
                    studentApplicationManager.remove(student);
                    StudentManager.studentDataStatus = true;
                }
                else
                {
                    studentMenuManager();
                }
                result = true;
            }
        }
        while (!result);
    }

    public static void addStudent()
    {
        Scanner input = new Scanner(System.in);
        boolean result = false;
        do {
            try
            {
                System.out.print("Student Code : ");
                String studentCode = input.nextLine();
                System.out.print("Student Name : ");
                String studentName = input.nextLine();
                System.out.print("Student Age : ");
                int age = Integer.parseInt(input.nextLine());
                System.out.print("Student Gender : ");
                String gender = input.nextLine();
                System.out.print("Student Address : ");
                String address = input.nextLine();
                System.out.print("Student AverageScore :");
                double averageScore = Double.parseDouble(input.nextLine());
                List<Student> studentList = studentApplicationManager.readFile();
                if (studentList.size() == 0)
                {
                    Student student = new Student(1,studentCode,studentName,age,gender,
                                                address,averageScore);
                    System.out.println("Thêm sinh viên thành công ! ");
                    studentApplicationManager.add(student);
                    result = true;

                }
                else
                {
                    Student student = new Student(studentList.get(studentList.size()-1).getId()+1,studentCode,studentName,age,gender,
                            address,averageScore);
                    boolean check = studentApplicationManager.add(student);

                    if (check)
                    {
                        System.out.println("Thêm sinh viên thành công ! ");
                        result = true;
                        StudentManager.studentDataStatus = true;
                    }
                    else
                    {
                        System.out.println("Sinh viên này đã tồn tại ! ");
                    }
                }

            }
            catch (NumberFormatException e)
            {
                System.out.println("Nhập dữ liệu không hợp lệ");
            }
        }
        while (!result);
    }


    public static void studentMenuManager()
    {
        Scanner input = new Scanner(System.in);
        boolean result = false;
        do {
            try
            {
                System.out.println("---Chương trình quản lý sinh viên");
                System.out.println("1.Xem danh sách sinh viên");
                System.out.println("2.Thêm mới");
                System.out.println("3.Cập nhật");
                System.out.println("4.Xóa");
                System.out.println("5.Sắp xếp");
                System.out.println("6.Đọc từ file");
                System.out.println("7.Ghi vào file");
                System.out.println("8.Thoát");
                System.out.print("Chọn chức năng : ");
                int functionNumber = Integer.parseInt(input.nextLine());
                switch (functionNumber)
                {
                    case 1->{
                        displayStudent();
                    }
                    case 2 -> {
                       addStudent();
                    }
                    case 3 ->{
                       updateStudent();
                    }
                    case 4 ->{
                        removeStudent();
                    }
                    case 5->{
                        sortStudent();
                    }
                    case 8->{
                        System.exit(8);
                    }
                }
                result = true;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Nhập dữ liệu không hợp lệ !");
            }
        }
        while (result);

    }



    public static void main(String[] args)
    {
        studentMenuManager();
    }
}