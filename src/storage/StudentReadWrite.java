package storage;

import model.Student;

import java.io.*;
import java.util.List;

public class StudentReadWrite extends ReadWrite<Student>
{
    private static ReadWrite<Student> studentReadWrite;

    protected StudentReadWrite(String pathDataFile)
    {
        super(pathDataFile);
    }


    public static ReadWrite<Student> getInstance()
    {
        if (studentReadWrite == null)
        {
            studentReadWrite = new StudentReadWrite("src/storage/file/student.csv");
        }
        return studentReadWrite;
    }

    @Override
    public List<Student> readFile()
    {
        try(InputStream categoriesDataFile = new FileInputStream(getPathDataFile());
            ObjectInputStream objectInputStream = new ObjectInputStream(categoriesDataFile) )
        {
            List<Student> studentList  = (List<Student>)objectInputStream.readObject();
            return studentList;
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Không tìm thấy đường dẫn file student !");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Không tìm thấy lớp hợp lệ!");
        }
        catch (IOException e)
        {
            System.out.println("Lỗi đọc dữ liệu file student");
        }
        return null;
    }

    @Override
    public void writeFile(List<Student> studentList)
    {
        try(OutputStream categoriesFile = new FileOutputStream(getPathDataFile());
            ObjectOutputStream objectOutStream = new ObjectOutputStream(categoriesFile))
        {
            objectOutStream.writeObject(studentList);

        }
        catch (FileNotFoundException e)
        {
            System.out.println("Không tìm thấy đường dẫn file student !");
        }
        catch (IOException e)
        {
            System.out.println("Lỗi ghi file dữ liệu student !");
        }
    }
}
