import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<String> messages = new ArrayList<>();
        String buffer = "";
        System.out.println("Start texting...");
        while(!buffer.equals("stop")){
            try {
                buffer = bufferedReader.readLine().toLowerCase();
                messages.add(buffer);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        WriteToFile("test.txt", messages);
        System.out.println("-------------------");
        ReadFromFile("test.txt");
    }

    private static void WriteToFile(String fileName, List<String> content){
        try{
            File file = new File(fileName);
            PrintWriter pw = new PrintWriter(file);
            if(file.exists()){
                file.createNewFile();
            }
            content.forEach(pw::println);
            pw.close();
        }catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }

    }
    private static void ReadFromFile(String fileName) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}