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
        String[] splits = list.get(0).split("\\s+");
        StringBuilder sb = new StringBuilder();
        ArrayList<String> answer = new ArrayList<>();
        String substring = "";
        System.out.println("****"+splits.length);
        for (int i = 0; i < splits.length;) {
            String tmp = splits[i].trim();
            System.out.println(i);
            if (sb.length() <= n) {
                int stringSize = sb.length() + tmp.length();
                if (tmp.length() < n && stringSize < n) {
                    sb.append(tmp + " ");
                    if(i+1==splits.length && !sb.toString().equals(" "))
                        answer.add(sb.toString().trim());
                    i++;
                } else {
                    substring = tmp.substring(0, n - sb.length());
                    sb.append(substring);
                    splits[i] = tmp.substring(substring.length(), tmp.length());
                    if(splits[i].equals("")||splits.equals(" "))
                    {
                        i++;
                    }
                    answer.add(sb.toString());
                    sb.setLength(0);
                }
            }

//            while(cycle != n)
//            {
//                if(tmp.length()<n)  //14 символов
//                {
//                    sb.append(tmp + " ");
//                    i++;
//                    break;
//                }
//                else if(tmp.length()>=n)
//                {
//                    substring = tmp.substring(0, n-sb.length());
//                    sb.append(substring);
//                    cycle+=substring.length()+1;
//                    splits[i]=tmp.substring(substring.length(),tmp.length());
//                    answer.add(sb.toString());
//                    cycle=0;
//                    sb.setLength(0);
//                    break;
//                }
//            }
//            if(cycle<n)
//            {
//                sb.append(splits[i]);
//            }
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
                list.add(tmp.trim());
            }
        } catch (IOException ex) {
            System.out.println("Файл не найден");
        } finally {
            scan.close();
        }
        return list;
    }

}
