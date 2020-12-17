import java.lang.*;
import java.util.*;

//Dude this question is fucking hard

// class DecodeString {
//     public String decodeString(String s) {
//         Stack
//     }

// }


// class DecodeString {
//     public String decodeString(String s) {
//         String finalAnswer = "";
//         String temp = "";
//         int repeat = 0;
//         Stack<Character> decoded = new Stack<>();
//         for(int i = 0; i < s.length(); i++){
//             if(!decoded.isEmpty() && decoded.peek() == ']'){
//                 decoded.pop();
//                 while(decoded.peek() != '['){
//                     temp = decoded.pop() + temp;
//                 }
//                 decoded.pop();
//                 repeat = Integer.parseInt(decoded.pop() + "");
//                 for(int j = 0; j < repeat; j++){
//                     finalAnswer += temp;
//                 }
//             }
//             decoded.push(s.charAt(i));
//         }
//         return finalAnswer;
//     }
// }



//Failed attempt below tried to use some recursion shit

// class DecodeString {
//     public String decodeString(String s) {
        
//         return rec(s, 0);
//     }

//     public String rec(String s, int start){
//         int repeat = 1;
//         String acc = "";
//         int count = start+1;
//         String res = "";

//         if(s.charAt(start) == '['){
//             repeat = Integer.parseInt(s.charAt(start-1) + "");
//         }

//         while(count < s.length() && s.charAt(count) != ']'){
//             if(s.charAt(count) == '['){
//                 res = rec(s, count);
//             } else if(Character.isAlphabetic(s.charAt(count))){
//                 acc += s.charAt(count);
//             }
//             count++;
//         }

//         for(int i = 0; i < repeat; i++){
//             res = acc + res;
//         }

//         return res;
//     }
// }