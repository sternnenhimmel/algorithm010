/**
首先尝试使用暴力法，即每次比较各个字符串的首字母，如果是公共字符串，再比较下一个，不然就返回。空间复杂度是o(1)，最差时间复杂度是o(m*n)。不过由于大部分case最长公共字符串都很短，所以这种方法大概率表现还不错的
*/
class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        int max_length = 0;
        for(int i=0; i<strs.size(); i++) {
            if (strs[i].length() > max_length) {
                max_length = strs[i].length();
            }
        }
        if (max_length ==0) {
            return "";
        }
        int count = 0;
        for(int i=0;i<max_length;i++){
            bool isCommon = true;
            for(int j=0; j<strs.size(); j++) {
                if (strs[j][i] != strs[0][i]) {
                    isCommon = false;
                    break;
                }
            }
            if(isCommon){
                count ++;
            } else {
                break;
            }
        }
        if(count == 0){
            return "";
        } else {
            return strs[0].substr(0, count);
        }
    }
};