import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        List<String> file1 = new ArrayList<String>();
        List<String> file2 = new ArrayList<String>();
        ReadFromFile readFile1 = new ReadFromFile("C:\\file1", file1);
        ReadFromFile readFile2 = new ReadFromFile("C:\\file2", file2);
        Thread th1 = new Thread(readFile1);
        Thread th2 = new Thread(readFile2);
        th1.start();
        th2.start();
        try {
            th1.join();
            th2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (String x : file1) {
            if (!file2.contains(x))
                System.out.println(x);
        }
    }
}
