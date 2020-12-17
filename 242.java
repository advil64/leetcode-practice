import java.util.*;


class IsAnagram {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> checker = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(!checker.containsKey(s.charAt(i))){
                checker.put(s.charAt(i), 0);
            }
            checker.put(s.charAt(i), checker.get(s.charAt(i))+1);
        }
        for(int i = 0; i < t.length(); i++){
            if(!checker.containsKey(t.charAt(i))){
                return false;
            }
            int temp = checker.get(t.charAt(i));
            if(temp == 1){
                checker.remove(t.charAt(i));
            } else{
                checker.put(t.charAt(i), temp-1);
            }
        }
        if(checker.isEmpty()){
            return true;
        }
        return false;
    }
}




//did not understand the question below

// class IsAnagram {
//     public boolean isAnagram(String s, String t) {
//         Stack<Character> checker = new Stack<>();
//         char[] chars = s.toCharArray();
//         char[] res = t.toCharArray();
//         for(char c: chars){
//             checker.push(c);
//         }
//         for(int i = 0; i < t.length(); i++){
//             if(t.charAt(i) != checker.pop()){
//                 return false;
//             }
//         }
//         return true;
//     }
// }