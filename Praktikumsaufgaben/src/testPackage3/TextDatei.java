package testPackage3;



import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TextDatei {
    public static void main(String[] args) {
        PrintWriter pWriter = null;
        try {
            pWriter = new PrintWriter(new BufferedWriter(new FileWriter("D:\\JavaTestTextDateien\\test.txt")));
            pWriter.println("Hallo Welt!");
            pWriter.println("Hallo Welt!");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (pWriter != null){
                pWriter.flush();
                pWriter.close();
            }
        }
        System.out.println("Ende");
    }
}