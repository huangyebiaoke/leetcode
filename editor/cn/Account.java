import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by <a href="mailto:huangyebiaoke@outlook.com">huang</a> on 2022/3/25 9:51
 */
public class Account {
    static HashSet<String> strings=new HashSet<>();
    static ArrayList<String> strings2=new ArrayList<>();
    private static String ver(String str){
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isLetter(str.charAt(i))){
                return "illegal charactor";
            }
        }
        if (!(str.length()>=6&&str.length()<=12)){
            return "illegal length";
        }
        if (strings.contains(str)){
            return "account existed";
        }
        return "registration complete";
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        if (scanner.hasNextInt()){
            int times=scanner.nextInt();
            while (scanner.hasNext()){
                String str=scanner.next();
//                System.out.println("str:"+str+" ver(str):"+ver(str));
                strings2.add(ver(str));
                times--;
                if (times==0){
                    break;
                }
            }
            for (String str:strings2) {
                System.out.println(str);
            }
        }
    }
}
