/**
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 

 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 

 

 

 示例 1： 

 
输入：digits = "23"
输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 

 示例 2： 

 
输入：digits = ""
输出：[]
 

 示例 3： 

 
输入：digits = "2"
输出：["a","b","c"]
 

 

 提示： 

 
 0 <= digits.length <= 4 
 digits[i] 是范围 ['2', '9'] 的一个数字。 
 
 Related Topics 哈希表 字符串 回溯 👍 1787 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> result = new LinkedList();
    StringBuilder tmp = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return result;
        }
        String[] alphabet = {
                "",
                "",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };
        backTracking(digits, alphabet, 0);
        return result;
    }

    private void backTracking(String digits, String[] alphabet, int index) {
        if (index == digits.length()) {
            result.add(tmp.toString());
            return;
        }
        String subAlpha = alphabet[digits.charAt(index) - '0'];
        for (int i = 0; i < subAlpha.length(); i++) {
            tmp.append(subAlpha.charAt(i));
            backTracking(digits, alphabet, index + 1);
            tmp.deleteCharAt(tmp.length() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
