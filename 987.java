import java.util.*;


//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class VerticalTraversal {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> sameLine = new ArrayList<>();
        Map<Integer, ArrayList<int[]>> tree = dfs(0, 0, root);
        List<Integer> keys = new ArrayList<>(tree.keySet());
        Collections.sort(keys);
        for(Integer key: keys){
            List<int[]> value = tree.get(key);
            ArrayList<Integer> toAdd = new ArrayList<>();
            Collections.sort(value, (a, b) -> {
                if(a[1] == b[1]){
                    return a[0] - b[0];
                }
                return a[1] - b[1];
            });
            value.forEach((x) -> toAdd.add(x[0]));
            sameLine.add(toAdd);
        }
        return sameLine;
   }

   public Map<Integer, ArrayList<int[]>> dfs(int x, int y, TreeNode curr){
        if(curr == null){
            return(new HashMap<>());
        }
        Map<Integer, ArrayList<int[]>> leftMap = dfs(x-1, y-1, curr.left);
        Map<Integer, ArrayList<int[]>> rightMap = dfs(x+1, y+1, curr.right);
        Map<Integer, ArrayList<int[]>> myMap = new HashMap<>(leftMap);
        rightMap.forEach((key, val) -> {
            if(myMap.containsKey(key)){
                myMap.get(key).addAll(val);
            } else{
                myMap.put(key, val);
            }
        });
        if(myMap.containsKey(y)){
            myMap.get(y).add(0,new int[]{curr.val, x});
        } else{
            myMap.put(y, new ArrayList<>());
            myMap.get(y).add(0,new int[]{curr.val, x});
        }
        return myMap;
   }
}