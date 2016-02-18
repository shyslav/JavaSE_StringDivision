package crossplatform_v1;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author shyshkin_vlad
 */
public class CrossPlatform_v1 {

    public static void main(String[] args) {
        ArrayList<String> fileRead = fileRead("input.txt");
        int lengthString = fileRead.get(fileRead.size() - 1).length();
        char lastWord = fileRead.get(fileRead.size() - 1).charAt(lengthString - 1);
        if (lastWord == ' ') {
            System.out.println("Последний символ пробел");
        } else {
            System.out.println("Последний символ " + lastWord);
        }
        have(fileRead, 15);
    }

    public static void have(ArrayList<String> list, int n) {
        System.out.println(list.get(0));
        String[] splits = list.get(0).split(" ");
        for (String tmp : splits) {
            System.out.println(tmp + " " + tmp.length());
        }
        int cycle = 0;
        System.out.println("-------------");
        for (String tmp : splits) {
            cycle += tmp.length()+1;
            if (cycle < n) {
                System.out.print(tmp + " ");
            } else {
                cycle = 0;
                System.out.println(tmp);
            }
        }
    }

    public static ArrayList<String> fileRead(String name) {
        Scanner scan = null;
        String tmp = null;
        ArrayList<String> list = new ArrayList<>();
        try {
            scan = new Scanner(Paths.get(name));
            while (scan.hasNext()) {
                tmp = scan.nextLine();
                System.out.println(tmp);
                list.add(tmp);
            }
        } catch (IOException ex) {
            System.out.println("Файл не найден");
        } finally {
            scan.close();
        }
        return list;
    }

}
