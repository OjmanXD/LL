import java.io.*;
import java.net.*;

public class print_web_content {
    @SuppressWarnings("resource")
    public static void main(String[] args) throws IOException {
        new BufferedReader(new InputStreamReader(
                new URL("https://raw.githubusercontent.com/ai-forever/ghost/main/preprocess_vgg.py").openStream()))
                .lines().forEach(System.out::println);
    }
}