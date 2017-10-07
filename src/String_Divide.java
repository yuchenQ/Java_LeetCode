import java.util.*;
import static java.lang.System.exit;

/**
 * This program can divide and sort a string from a char to its closest substring;
 * And attach the method of iterator to it as comment;
 * This program can also produce a random string to use if user enter a number;
 *
 * [example]
 * input:"abc"
 * output:"[a, b, c, ab, bc, abc]"
 */
public class String_Divide{

    private SortedSet<String> output;

    public String_Divide(){
        this.output = new TreeSet<>(new StrLenComparator());
    }

    public void getSubString(String input){
        int length = input.length();
        if(!this.isLetter(input)){
            System.out.println("invalid string, it should only have letters");
            exit(0);
        } else if(length > 1024){
            System.out.println("invalid string, its length larger than 1000!");
            exit(0);
        } else if(length == 1){
            this.output.add(input);
        } else {
            this.output.add(input);
            String no_head = input.substring(1);
            String no_tail = input.substring(0, length-1);

            this.output.add(no_head);
            this.output.add(no_tail);

            getSubString(no_head);
            getSubString(no_tail);
        }
    }

    public boolean isLetter(String str){
        String regex = "^[a-zA-Z]+$";
        return str.matches(regex);
    }

    public boolean isNum(String str){
        String regex = "^[0-9]+$";
        return str.matches(regex);
    }

    public String getRandomString(int length){
        Random random = new Random();
        StringBuilder buf = new StringBuilder();
        String charStr = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int charLength = charStr.length();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(charLength);
            buf.append(charStr.charAt(index));
        }
        return buf.toString();
    }

    public static void main(String args[]){
        System.out.println("pls enter a string:");
        Scanner sc = new Scanner(System.in);

        if(sc.hasNext()){
            String input = sc.next();
            String_Divide ex = new String_Divide();

            if(ex.isNum(input)){
                int num = Integer.parseInt(input);
                if(num > 50 | num <= 0){
                    System.out.println("pls enter a valid number!(1-50)");
                } else{
                    ex.getSubString(ex.getRandomString(num));
                    System.out.println(ex.output);
                }
            } else{
                ex.getSubString(input);
                System.out.println(ex.output);
            }
            // ex.output.forEach((k)->System.out.println(k));

            // Iterator it = ex.output.iterator();
            // while(it.hasNext()){
            //    System.out.println(it.next());
            // }
        }
    }
}

class StrLenComparator implements Comparator{

    @Override
    public int compare(Object o1, Object o2){
        String s1 = (String)o1;
        String s2 = (String)o2;
        int num = Integer.compare(s1.length(), s2.length());
        if (num == 0){
            return s1.compareTo(s2);
        }
        return num;
    }
}
