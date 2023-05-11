import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task1 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
            final String SELECT = "SELECT * FROM students WHERE ";
            String line;
            String result;
            StringBuilder builder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                line = line.substring(1, line.length() - 2);
                line = line.replace("\"", "");
                String[] string = line.split(", ");
                for (String elem : string) {
                    String[] elemArray = elem.split(":");
                    if (!elemArray[1].equals("null")) {
                        builder.append(String.format("%s = \"%s\" AND ", elemArray[0], elemArray[1]));
                    }
                }
                result = builder.toString();
                builder.setLength(0);
                result = SELECT + result.substring(0, result.length() - 5) + ';';
                System.out.println(result);
            }
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}