/**
字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。 

 

 示例： 

 
输入：S = "ababcbacadefegdehijhklij"
输出：[9,7,8]
解释：
划分结果为 "ababcbaca", "defegde", "hijhklij"。
每个字母最多出现在一个片段中。
像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 

 

 提示： 

 
 S的长度在[1, 500]之间。 
 S只包含小写字母 'a' 到 'z' 。 
 
 Related Topics 贪心 哈希表 双指针 字符串 👍 738 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> partitionLabels(String s) {
        int length = s.length();
        int[] lastPos = new int[26];
        for (int i = 0; i < length; i++) {
            lastPos[s.charAt(i) - 'a'] = i;
        }
        List<Integer> res = new LinkedList();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            end = Math.max(end, lastPos[s.charAt(i) - 'a']);
            if (i == end) {
                res.add(end - start + 1);
                start = end + 1;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
