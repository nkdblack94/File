import java.io.*;

public class CopyFile {
    public static void main(String[] args) {

        File input = new File("D:/File/src/main/java/input.txt");
        File output = new File("D:/File/src/main/java/output.txt");

        try {

            if (!(input.exists())){
                input.createNewFile();
            }
            if (!(output.exists())){
                output.createNewFile();
            }

            FileReader in = new FileReader(input);
            FileWriter out = new FileWriter(output);

            BufferedReader reader = new BufferedReader(in);
            BufferedWriter writer = new BufferedWriter(out);
            int c;
            int characters = 0;
                while ((c = reader.read()) != -1) {
                    writer.write(c);
                    characters++;
                }
                reader.close();
                writer.close();
                System.out.println("Số ký tự trong file là: " + characters);

        } catch (IOException e) {
            System.out.println("Lỗi file ko tồn tại");;
        }
    }
}
