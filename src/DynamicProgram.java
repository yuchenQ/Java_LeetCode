import java.util.Scanner;

/**
 * Created by iceice on 28/9/17.
 * Question:
 * 输入一串数字，第一个数字表明工作的天数，后面的数字两两一对，表明正常工作的薪酬，
 * 和努力工作的薪酬。每天都可以正常工作，但是努力工作的条件是前一天不工作（收益为0），
 * 求这几天能获得的最大收益？
 */
public class DynamicProgram {
    //4 7 10 6 7 4 6 6 7
    //5 1 6 1 2 1 9 1 10 1 13
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] taskList = new int[n][2];
        while(sc.hasNextInt()){
            for(int i=0; i<n;i++){
                for(int j =0; j<2; j++){
                    taskList[i][j] = sc.nextInt();
                }
            }
            System.out.println(maxStipend(n, taskList));
        }

    }
    public static int maxStipend(int n, int[][] taskList){
        int[] pay = new int[n];
        pay[0] = taskList[0][1];
        pay[1] = Math.max(taskList[0][1]+taskList[1][0], taskList[1][1]);

        for(int i=2; i<n; i++) {
            if(pay[i-2]+taskList[i][1] >= pay[i-1]+taskList[i][0]){
                pay[i]=pay[i-2]+taskList[i][1];
            }else{
                pay[i]=pay[i-1]+taskList[i][0];
            }
        }
        return pay[n-1];
    }
}
