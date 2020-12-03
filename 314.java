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

class VerticalOrder {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> tree = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> myMap = new HashMap<>();
        dfs(root, 0, 0, myMap);
        List<Integer> keys = new ArrayList<>(myMap.keySet());
        Collections.sort(keys);
        keys.forEach((key) -> {
            tree.add(myMap.get(key));
        });
        return tree;
    }

    public void dfs(TreeNode curr, int x, int y, HashMap<Integer, ArrayList<Integer>> myMap){
        if(curr == null){
            return;
        }
        dfs(curr.left, x-1, y-1, myMap);
        dfs(curr.right, x+1, y+1, myMap);
        if(!myMap.containsKey(y)){
            myMap.put(y, new ArrayList<>());
        }
        myMap.get(y).add(0, curr.val);
    }
}