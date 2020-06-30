import java.io.*;
import java.util.Scanner;

public class ReadFileExample {
    public void readFileText(String filePath){
        try{
            File file = new File(filePath);
            if (!file.exists()){
                throw new FileNotFoundException();
            }

            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = "";
            int sum = 0;
            while ((line = bufferedReader.readLine()) != null){
                System.out.println(line);
                sum += Integer.parseInt(line);
            }
            bufferedReader.close();
            System.out.println("Tổng = " + sum);
        } catch (Exception e) {
            System.out.println("file ko tồn tại hoặc nội dung có nỗi");
        }
    }
    public static void main(String[] args) {
        System.out.println("Nhập đường dẫn file: ");
        Scanner scanner = new Scanner(System.in);
        String path = "D:/File/src/main/java/demo.txt";

        ReadFileExample readFileEx = new ReadFileExample();
        readFileEx.readFileText(path);
    }
}
