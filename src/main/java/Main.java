import controller.WebWordCountController;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        WebWordCountController.operate(args[0]);
    }
}
