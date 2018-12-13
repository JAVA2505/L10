import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        File f = new File("aaa.txt");
        if (!f.exists()) {
            f.createNewFile();
        }
        System.out.println(f.getAbsolutePath());
        InputStream is = new FileInputStream(f);
        int b;
        while ((b = is.read()) != -1) {
            System.out.print((char) b);
        }
        is.close();
    }
}
