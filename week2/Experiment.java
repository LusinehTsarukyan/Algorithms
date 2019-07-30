package week2;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Experiment {

    public static ArrayList<Long> DISReader(String path) throws IOException {
        List<Long> array = new ArrayList<Long>();
        try (DataInputStream sc = new DataInputStream(new FileInputStream(path))) {
            while (true) {
                long next = sc.readLong();
                array.add(next);
                if (next == 91901) {
                    break;
                }
            }
        }
        return (ArrayList<Long>) array;
    }

    public static void main(String args[]) throws IOException {
//        try {
//            ArrayList file = Inversions.reader("C:/Users/Lyulik/Desktop/coursera/nums.txt");
//            System.out.println("Scanner :: " + file);
//            ArrayList file2 = DISReader("C:/Users/Lyulik/Desktop/coursera/nums.txt");
//            System.out.println("DataInputStream :: " + file2);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        List<Long> array = new ArrayList<Long>();
        try (DataInputStream sc = new DataInputStream(new FileInputStream("C:/Users/Lyulik/Desktop/coursera/nums.txt"))) {
            while (true) {
                long next = sc.readLong();
                array.add(next);
                if(next == 91901){
                    break;
                }
            }
        }
    }
}
