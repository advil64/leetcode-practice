import java.util.*;

class Leaderboard {
    //record scores in a hashmap and output top k scores with priority queue

    Map<Integer, ArrayList<Integer>> scores;
    PriorityQueue<Integer> topScores;

    public Leaderboard() {
        scores = new HashMap<>();
        topScores = new PriorityQueue<>((a, b) -> b-a);
    }
    
    public void addScore(int playerId, int score) {
        if(!scores.containsKey(playerId)){
            scores.put(playerId, new ArrayList<>());
        }
        scores.get(playerId).add(score);
        topScores.add(score);
    }
    
    public int top(int K) {
        List<Integer> kScores = new ArrayList<>();
        for(int i = 0; i < K; i++){
            kScores.add(topScores.poll());
        }
        int sum = 0;
        for(int s: kScores){
            topScores.add(s);
            sum += s;
        }
        return sum;
    }
    
    public void reset(int playerId) {
        scores.remove(playerId);
        topScores.clear();
        scores.forEach((player, s) -> {
            s.forEach((sc) -> topScores.add(sc));
        });
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */