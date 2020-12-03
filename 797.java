import java.util.*;

class AllPathsSourceTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currPath = new ArrayList<>();
        Queue<List<Integer>> paths = new LinkedList<>();

        currPath.add(0);
        paths.add(currPath);

        while(!paths.isEmpty()){
            currPath = paths.poll();
            if(currPath.get(currPath.size()-1) == graph.length - 1){
                allPaths.add(currPath);
            } else{
                for(int node: graph[currPath.get(currPath.size()-1)]){
                    List<Integer> temp = new ArrayList<>(currPath);
                    temp.add(node);
                    paths.add(temp);
                }
            }
        }
        return allPaths;
    }
}