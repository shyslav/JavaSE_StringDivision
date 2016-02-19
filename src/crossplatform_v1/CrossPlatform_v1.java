package crossplatform_v1;

import functions.filePrint;
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

    /**
     * @param list входящий лист строк
     * @param n количество символов в одной строке
     */
    public static void have(ArrayList<String> list, int n) {
        //переменная которая хранит слова
        String[] splits = list.get(0).split(" ");
        int cycle = 0;
        StringBuilder sb = new StringBuilder();
        // лист ответов
        ArrayList<String> answer = new ArrayList<>();
        System.out.println("-------------");
        for (int i = 0; i <= splits.length; i++) {
            if (i == splits.length) {
                answer.add(sb.toString());
                sb.setLength(0);
                break;
            }
            String tmp = splits[i];
            cycle += tmp.length() + 1;
            // добавить слово в текущую строку 
            if (cycle < n) {
                sb.append(tmp + " ");
                System.out.print(tmp + " ");
            } else {
                //Начать новую строку, кол-во символов текущей строки привысила входящее значение
                cycle = 0;
                answer.add(sb.toString());
                sb.setLength(0);
                //длина текущей строки равна длине слова +1 (пробел)
                cycle += tmp.length() + 1;
                sb.append(tmp + " ");
                System.out.print("\n" + tmp + " ");
            }
        }
        System.out.println("\n-------------");
        for (String z : answer) {
            System.out.println(z);
        }
        filePrint.FilePrint(answer);
    }
    /**
     * @param name название входящего файла
     * @return лист считанныъ строк
     */
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
