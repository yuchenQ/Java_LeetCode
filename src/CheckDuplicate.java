import java.util.*;

/**
 * This program can find out whether input arrays(no duplicate inside)
 * have common parts or not, if they have, print sorted common parts,
 * otherwise, print sorted concat;
 *
 * [example]
 * input:{1,2,3}, {1,2,3,4,5}
 * output:"1,2,3"
 */
public class CheckDuplicate {

    private int[] merge;

    public CheckDuplicate(int[] array_1, int[] array_2) {
        this.merge = this.concat(array_1, array_2);
    }

    public int[] concat(int[] first, int[] second) {
        int[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }

    public ArrayList<Integer> getDuplicate(int[] array) {
        ArrayList<Integer> res = new ArrayList<>();
        if(array == null || array.length < 2) {
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<array.length; i++){
            if(map.containsKey(array[i])){
                map.put(array[i], map.get(array[i])+1);
            }else{
                map.put(array[i], 1);
            }
        }
        for(Integer key : map.keySet()){
            if(map.get(key) > 1)
                res.add(key);
        }
        return res;
    }

    public static void main(String args[]){
        int[] array_1 = new int[] {1,2,3};
        int[] array_2 = new int[] {2,3,4,5};

        CheckDuplicate cd = new CheckDuplicate(array_1, array_2);
        ArrayList<Integer> res = cd.getDuplicate(cd.merge);

        if(res.isEmpty()){
            Arrays.sort(cd.merge);System.out.println(Arrays.toString(cd.merge));
        }else{
            Collections.sort(res);System.out.println(res);
        }
    }

}
