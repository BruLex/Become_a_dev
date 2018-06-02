import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

public class ReadFromFile implements Runnable {

    private String filename;
    private List<String> file;
    private FileReader fr;
    private Scanner scan;
    public ReadFromFile(String filename, List<String> file) {
        try {
            fr = new FileReader(filename);
            scan = new Scanner(fr);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.file = file;
    }
    @Override
    public void run(){
        while(scan.hasNext()){
            String line = scan.nextLine();
            int point = 0;
            while(true) {
                int begin = line.indexOf("user: ", point);
                if( begin == -1)
                    break;
                else
                    begin += 6;
                int end = line.indexOf(",", begin);
                if(!file.contains(line.substring(begin, end)))
                    file.add(line.substring(begin, end));
                point = end;
            }
        }
    }
}
