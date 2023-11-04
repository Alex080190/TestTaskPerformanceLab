import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task2 {
    public static void main(String[] args) throws IOException {
        BufferedReader circleReader = new BufferedReader(new FileReader(args[0]));
        String centerOfTheCircle = circleReader.readLine();

        float centerX = Float.parseFloat(centerOfTheCircle.split(" ")[0]);
        float centerY = Float.parseFloat(centerOfTheCircle.split(" ")[1]);
        float radius = Float.parseFloat(circleReader.readLine());

        BufferedReader pointsReader = new BufferedReader(new FileReader(args[1]));

        while (pointsReader.ready()){
            String current = pointsReader.readLine();
            float pointX = Float.parseFloat(current.split(" ")[0]);
            float pointY = Float.parseFloat(current.split(" ")[1]);
            double distance = Math.sqrt(Math.pow(pointX - centerX, 2) + Math.pow(pointY - centerY, 2));
            if (distance < radius) {
                System.out.println("точка лежит на окружности");
            } else if (distance > radius) {
                System.out.println("точка снаружи");
            } else {
                System.out.println("точка внутри");
            }
        }

    }
}
