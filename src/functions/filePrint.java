package functions;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Shyshkin Vladyslav
 */
public class filePrint {
    /**
     * @param list массив который записать в файл
     */
    public static void FilePrint(ArrayList<String> list) {
        PrintWriter out = null;
        try {
            out = new PrintWriter("output.txt");
            for (String tmp : list) {
                out.print(tmp);
                out.print("("+tmp.length()+")" +"\n");
            }
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            if (out != null) {
                out.close();
            }
        }

    }
}
