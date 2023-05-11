import java.io.IOException;
import java.util.Arrays;
import java.util.logging.*;

public class Task2 {
    public static void main(String[] args) throws IOException {

        Logger logger = Logger.getLogger(Task2.class.getName());
        FileHandler fh = new FileHandler("log.txt");
        logger.addHandler(fh);
        SimpleFormatter sFormatter = new SimpleFormatter();
        fh.setFormatter(sFormatter);

        int[] array = new int[] { 2, 5, 1, 7, 19, 3, 14, 7, 44, 1, 2, 44 };
        logger.log(Level.INFO, Arrays.toString(array));

        for (int out = array.length - 1; out > 1; out--) {
            for (int in = 0; in < out; in++) {
                if (array[in] > array[in + 1]) {
                    int tmp = array[in];
                    array[in] = array[in + 1];
                    array[in + 1] = tmp;
                }
            }
            logger.log(Level.INFO, Arrays.toString(array));
        }
    }
}