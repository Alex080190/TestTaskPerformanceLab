import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.IntStream;

public class Task4 {
    public static void main(String[] args) throws IOException {

        int[] nums = Files.lines(Paths.get(args[0]))
                .mapToInt(Integer::parseInt).toArray();

        double averageNumber = (double) IntStream.of(nums).sum() / nums.length;
        int average = (int) Math.round(averageNumber);
        int countOfSteps = 0;

        for (int i = 0; i < nums.length; i++) {
            countOfSteps += Math.abs(average - nums[i]);
        }
        System.out.println(countOfSteps);
    }
}
