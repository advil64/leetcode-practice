# Uses a stack to sort of candy crush the adjacent chars


class Solution:

    def removeDuplicates(s: str, k: int) -> str:
        stack = [['#', 0]]
        for c in s:
            if stack[-1][0] == c:
                stack[-1][1] += 1
                if stack[-1][1] == k:
                    stack.pop()
            else:
                stack.append([c, 1])
        return ''.join(c * k for c, k in stack)
    
    print(removeDuplicates(s="pbbcggttciiippooaais", k=2))