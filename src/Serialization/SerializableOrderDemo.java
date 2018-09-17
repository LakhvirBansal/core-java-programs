package Serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableOrderDemo {

	public static void main(String[] args) {
		Data d = new Data();
		Data1 d1 = new Data1();
		System.out.println("serialization started");
		try {
			FileOutputStream fos = new FileOutputStream("abc.ser");
			ObjectOutputStream os = new ObjectOutputStream(fos);
			os.writeObject(d);
			os.writeObject(d1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("serialization ended");
		System.out.println("Deserialization started");
		try {
			FileInputStream fis = new FileInputStream("abc.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Data d2 = (Data) ois.readObject();
			Data1 d3 = (Data1) ois.readObject();
			System.out.println("Deserialization ended");
			System.out.println(d2.i + "................" + d2.j);
			System.out.println(d3.i + "................" + d3.j);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
