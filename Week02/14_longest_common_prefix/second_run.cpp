/**
看了题解以后可以尝试以下分治法，即分成很多子组合，求每个子组合的最长公共子串。
时间复杂度来看，当前问题可以看成是T = 2*T/2 + k，时间复杂度是o(n)，
而对于每一个字符串的处理时间依旧为o(m)，所以最终时间复杂度实际为o(m*n)，
而且鉴于最长公共子串这个比较特殊的case，在对各个字符串进行两两比较时，
有比较大的概率会遍历比较多的元素。所以这个方法思路比较好，但是在当前case下结果不一定会很好。
这里也补充实现一下.
*/
class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        if(strs.size() ==0){
            return "";
        }
        return longestCommonPrefix(strs, 0, strs.size()-1);
    }

    string longestCommonPrefix(vector<string>& strs, int start, int end) {
        if (start == end) {
            return strs[start];
        } else if(end-start == 1){
            return longestCommonPrefix(strs[start], strs[end]);
        }else{
            int mid = (start+end)/2;
            string left = longestCommonPrefix(strs, start, mid);
            string right = longestCommonPrefix(strs, mid+1, end);
            return longestCommonPrefix(left,right);
        }
    }

    string longestCommonPrefix(string s1, string s2) {
        int length = min(s1.length(), s2.length());
        if(length ==0){
            return "";
        }
        int count =0;
        for (int i=0; i<length; i++) {
            if(s1[i]==s2[i]){
                count++;
            }else {
                break;
            }
        }
        if (count==0) {
            return "";
        } else {
            return s1.substr(0,count);
        }
    }
};