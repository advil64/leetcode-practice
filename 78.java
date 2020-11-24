import java.util.*;

class Solution {
    public static void main(String[] args){
        System.out.print(subsets(new int[]{1,2,3}));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        calculate(0, nums, new ArrayList<Integer>(), result);
        
        return result;
    }

    public static void calculate(int index, int[] nums, List<Integer> current, List<List<Integer>> res){
        
        res.add(new ArrayList<Integer>(current));
        
        for(int i = index; i < nums.length; i++){
            current.add(nums[i]);
            calculate(i+1, nums, current, res);
            current.remove(current.size() - 1);
        }
        
    }
}