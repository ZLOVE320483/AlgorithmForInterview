/**
给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。 

 在 S 上反复执行重复项删除操作，直到无法继续删除。 

 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。 

 

 示例： 

 输入："abbaca"
输出："ca"
解释：
例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有
 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 

 

 提示： 

 
 1 <= S.length <= 20000 
 S 仅由小写英文字母组成。 
 
 Related Topics 栈 字符串 👍 361 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeDuplicates(String s) {
        Deque<Character> stack = new LinkedList();
        char[] cs = s.toCharArray();
        stack.push(cs[0]);
        for (int i = 1; i < cs.length; i++) {
            if (stack.isEmpty() || stack.peek() != cs[i]) {
                stack.push(cs[i]);
            } else {
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
