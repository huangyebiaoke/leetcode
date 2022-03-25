/**
 * 1011^0111=0011
 * 0011^1011=0111
 * 0011^0111=1011
 * Created by <a href="mailto:huangyebiaoke@outlook.com">huang</a> on 2021/7/2 17:57
 */
public class SwapTwoNumber {
    public static void main(String[] args) {
        int a=10;
        int b=20;
//        a^b include the message of a & b
        a=a^b;
//        b=a^b^b
        b=a^b;
//        a=a^b^a
        a=a^b;
        System.out.println(a);
        System.out.println(b);
    }
}
