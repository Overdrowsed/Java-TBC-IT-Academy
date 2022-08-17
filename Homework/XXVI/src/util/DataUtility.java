package util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Base64;
import java.util.Scanner;

import data.Student;

public class DataUtility {
    @SuppressWarnings("unchecked")
    public static <T> T copyObject(T object) throws IOException, ClassNotFoundException{
        ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteOutput);

        objectOutputStream.writeObject(object);

        ByteArrayInputStream byteInput = new ByteArrayInputStream(byteOutput.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteInput);

        T copy = (T)objectInputStream.readObject();

        objectInputStream.close();

        return copy;
    }

    public static void serializeToFile(Student student) throws IOException{
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("out/student.ser"));

        objectOutputStream.writeObject(student);
        objectOutputStream.flush();

        objectOutputStream.close();
    }

    public static Student deserializeFromFile() throws IOException, ClassNotFoundException{
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("out/student.ser"));

        Student deserializedObject = (Student)objectInputStream.readObject();

        objectInputStream.close();

        return deserializedObject;
    }

    public static <T extends Serializable> void serializeToBase64File(T object, String path) throws IOException{
        ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteOutputStream);
        
        objectOutputStream.writeObject(object);
        objectOutputStream.close();

        FileWriter writer = new FileWriter(path);
        writer.write(Base64.getEncoder().encodeToString(byteOutputStream.toByteArray()));
        
        writer.close();
    }

    @SuppressWarnings("unchecked")
    public static <T extends Serializable> T deserializeFromBase64File(String path) throws IOException, ClassNotFoundException{
        Scanner scanner = new Scanner(new File(path));

        String base64 = scanner.nextLine();

        byte[] data = Base64.getDecoder().decode(base64);

        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(data));

        T deserializedObject = (T)objectInputStream.readObject();

        return deserializedObject;
    }
}
