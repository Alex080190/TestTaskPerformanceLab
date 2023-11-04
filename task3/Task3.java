import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3 {
    public static void main(String[] args) throws IOException {

        BufferedReader testsReader = new BufferedReader(new FileReader(args[0]));
        BufferedReader valuesReader = new BufferedReader(new FileReader(args[1]));

        StringBuilder values = new StringBuilder();
        while (valuesReader.ready()) {
            values.append(valuesReader.readLine());
        }

        ArrayList<String> testsList = new ArrayList<>();
        while (testsReader.ready()) {
            String testStr = testsReader.readLine();
            testsList.add(testStr);
        }

        Pattern valuesPattern = Pattern.compile("(?<=value\":\\s\")\\w+");
        Matcher valuesMatcher = valuesPattern.matcher(values);

        ArrayList<String> list = new ArrayList<>();
        int index = 0;
        while (valuesMatcher.find()) {
            list.add(values.substring(valuesMatcher.start(), valuesMatcher.end()));

        }

        BufferedWriter writer = new BufferedWriter(new FileWriter("report.json"));

        for (int i = 0; i < list.size(); i++) {
            StringBuilder currentStr = new StringBuilder(testsList.get(i));
            Pattern testsPattern = Pattern.compile("(?<=value\":\\s\")");
            Matcher testsMatcher = testsPattern.matcher(currentStr);
            testsMatcher.find();
            currentStr.insert(testsMatcher.start(), list.get(index++));
            writer.write(String.valueOf(currentStr));
            writer.write(System.lineSeparator());
        }
        writer.flush();

    }
}
