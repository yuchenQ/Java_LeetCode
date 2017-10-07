import java.util.*;

/**
 * A city is represented by a grid 0s and 1s
 * where 0s represent trees and 1s represent the lands.
 *
 * The woodcutter has to cut some trees
 * but the citizens demand: he should leave at least some number of tree-groups.
 *
 * a tree-group is defined as the maximum bunch of trees that are adjacent(not diagonal)
 * write an algorithm to find the minimum number of trees that he should cut:
 *
 * [Inputs]
 * int rows
 * int columns
 * int numTreegroup
 * int[][] grids
 *
 * [Outputs]
 * int expected number
 *
 * [Example]
 * Input:
 * 5 3 1
 * 1 0 1
 * 1 0 0
 * 1 1 1
 * 0 0 0
 * 0 0 1
 *
 * Expected Return Value:
 * 3
 */

public class SaveTreeGroups {

    public int count;

    public SaveTreeGroups(){
        this.count = 0;
    }

    public void isTreeAround(int i, int j, int rows, int columns, int[][] grids){
        if(grids[i][j]==0){
            grids[i][j] = 2;
            this.count++;
            if(j-1 >= 0){
                isTreeAround(i, j-1, rows, columns, grids);
            }
            if(i-1 >= 0){
                isTreeAround(i-1, j, rows, columns, grids);
            }
            if(j+1 < columns){
                isTreeAround(i, j+1, rows, columns, grids);
            }
            if(i+1 < rows){
                isTreeAround(i+1, j, rows, columns, grids);
            }
        }
    }

    public static boolean isMatchConstraints(int rows, int columns, int numTreegroup){
        boolean ismatch = true;
        if(rows<1 | rows>50){
            ismatch = false;
        }
        if(columns<1 | columns>50){
            ismatch = false;
        }
        if(numTreegroup<0 | numTreegroup>50){
            ismatch = false;
        }
        return ismatch;
    }

    public static void main(String[] args){
        System.out.println("Input:");
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int columns = sc.nextInt();
        int numTreegroup = sc.nextInt();
        int[][] grids = new int[rows][columns];
        while(sc.hasNextInt()){
            for(int i=0; i< rows; i++){
                for(int j=0; j< columns; j++){
                    grids[i][j] = sc.nextInt();
                }
            }

            List<Integer> list = new ArrayList<>();
            if(SaveTreeGroups.isMatchConstraints(rows, columns, numTreegroup)){
                for(int i=0; i<rows; i++){
                    for(int j=0; j<columns; j++){
                        SaveTreeGroups obj = new SaveTreeGroups();
                        obj.isTreeAround(i, j, rows, columns, grids);
                        list.add(obj.count);
                    }
                }
                Iterator<Integer> it = list.iterator();
                while(it.hasNext()){
                    if(it.next()==0){
                        it.remove();
                    }
                }
                Collections.sort(list);
                int expected = 0;
                for(int i=0; i< list.size()-numTreegroup; i++){
                    expected += list.get(i);
                }
                System.out.println("Expected Return Value:");
                System.out.println(Integer.toString(expected));
            } else {
                System.exit(0);
            }
        }
    }
}
