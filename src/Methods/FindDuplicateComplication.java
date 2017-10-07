package Methods;

import java.util.*;

public class FindDuplicateComplication {

    /**
     * 使用Set接口中三个实现类无法存入相同的元素的特性，和TresSet存储顺序为升序存储引用的特性 来实现排序
     * @param sourArray 待排序的数组
     * @return 去重且排序后的数组
     */
    public static int[] treeSetSort(int[] sourArray){
        if (sourArray.length==0) {
            int[] len={0};
            return len;
        }
        TreeSet<Integer> myTreeSet=new TreeSet<Integer>();
        for (int aSourArray : sourArray) {
            myTreeSet.add(aSourArray);
        }
        int[] desArray=new int[myTreeSet.size()];
        int Count=0;
        for (Integer xInteger :myTreeSet) {
            desArray[Count++]=xInteger;
        }
        return desArray;
    }

    /**
     * 该方法根据集合类中的set接口，使用HashSet的实现类之特性来完成，
     * 即重复元素无法加入到该集合之中。程序的时间复杂度为n，空间复杂度为HashSet占用的空间
     * @param nums 待去重的数组
     * @return 返回去重之后的数组
     */
    public static int[] hashSetReduce(int[] nums){
        if (nums.length==0) {
            int[] len={0};
            return len;
        }
        Set<Integer> mySet=new HashSet<Integer>();
        int pos=0;
        for (int i = 0; i < nums.length; i++) {
            if (mySet.add(nums[i])) {
                nums[pos]=nums[i];
                pos++;
            }

        }
        int[] desArray=new int[pos];
        for (int i = 0; i < desArray.length; i++) {
            desArray[i]=nums[i];
        }

        return desArray;
    }

    /**
     * 使用Arrays类中的sort方法实现排序，然后用后面的值与前面的一个比较，不相同则加入到新数组之中
     * 注意：该方法返回的是一个有序的数组
     * @param sourArray 源待去重数组
     * @return 升序的去重的数组
     */
    public static int[] sortToReduce(int[] sourArray){
        if (sourArray.length==0) {
            int[] len={0};
            return len;
        }

        Arrays.sort(sourArray);
        int index=1;

        for (int i = 1; i < sourArray.length; i++) {
            if (sourArray[i]!=sourArray[i-1]) {
                sourArray[index]=sourArray[i];
                index++;
            }
        }
        int[] desArray=new int[index];
        for (int i = 0; i < desArray.length; i++) {
            desArray[i]=sourArray[i];
        }
        return desArray;
    }

    /**
     * 该方法使用插入排序的思想来处理
     * 复杂度为n*n
     * @param sourArray 源数组
     * @return 去重后数组
     */
    public static int[] insertSort(int[] sourArray){
        if (sourArray.length==0) {
            int[] len={0};
            return len;

        }
        int index=1;
        for (int i = 1; i < sourArray.length; i++) {
            int j = 0;
            for (; j < index; j++) {
                if (sourArray[j]==sourArray[i]) {
                    break;//break只会爆破当前的循环，假如当前循环为内层循环，那么值跳出当前的这层内循环
                }
            }
            if (index==j) {
                sourArray[index]=sourArray[i];
                index++;
            }
        }
        int[] desArray=new int[index];
        for (int i = 0; i < desArray.length; i++) {
            desArray[i]=sourArray[i];
        }
        return desArray;
    }

    /**
     * 新建一个相同大小的数组，然后依次从老数组中拿出元素与新数组中元素比对如果不相同则不处理，
     * 如果相同则立刻break中断该层的循环函数
     * 时间复杂度为n*n
     * @param sourArray 源数组
     * @return 保持原顺序的去重过的新数组
     */
    public static int[] doubleReduce(int[] sourArray){
        if (sourArray.length==0) {
            int[] len={0};
            return len;
        }
        int[] newArray=new int[sourArray.length];
        newArray[0]=sourArray[0];
        int index=1;
        for (int i = 1; i < newArray.length; i++) {
            int j=0;
            for (; j < index; j++) {
                if (newArray[j]==sourArray[i]) {
                    break;
                }
            }
            if (j==index) {
                newArray[index]=sourArray[i];
                index++;
            }
        }
        int[] desArray=new int[index];
        for (int i = 0; i < desArray.length; i++) {
            desArray[i]=newArray[i];
        }

        return desArray;
    }
}
