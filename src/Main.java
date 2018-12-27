import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File f = new File("aaa.txt");
        if (!f.exists()) {
            f.createNewFile();
        }
        System.out.println(f.getAbsolutePath());
        InputStream is = new FileInputStream(f);
        String s = "";
        int b;
        while ((b = is.read()) != -1) {
            System.out.print((char) b);
            s += (char) b;
        }
        is.close();

        System.out.println("==================");

        File f2 = new File("bbb.txt");
        f2.createNewFile();
        OutputStream out = new FileOutputStream(f2);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            out.write((int) c);
        }
        out.close();

        BufferedReader br = new BufferedReader(new FileReader(f));
        List<String> strings = new LinkedList<>();
        String str = null;
        while ((str = br.readLine()) != null) {
            System.out.println(str);
            strings.add(str);
        }
        br.close();

        PrintWriter pw = new PrintWriter(f2);
        for (String st : strings) {
            pw.println(st);
            pw.println("---");
        }
        pw.close();


        User u1 = new User();
        u1.name = "Alex";
        u1.age = 25;

        File f3 = new File("ccc.txt");
        f3.createNewFile();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f3));
        oos.writeObject(u1);
        oos.close();

        User u2;
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f3));
        u2 = (User) ois.readObject();
        ois.close();
        System.out.println(u2.age);
    }
}
