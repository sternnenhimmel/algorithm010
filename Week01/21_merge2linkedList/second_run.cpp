/*
看了题解以后，发现合并l1和l2可以看成合并l1->val > l2->val的情况下合并l2->next与l1这么一个子问题，这个子问题可以递归求解，因此可以有以下实现。不过这种方法的空间复杂度达到了o(m+n)，比起前一种方法的o(1)，并没占到便宜
*/
class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        if(l1==nullptr) {
            return l2;
        }
        if(l2==nullptr) {
            return l1;
        }
        if (l1->val > l2->val) {
            l2->next = mergeTwoLists(l2->next, l1);
            return l2;
        } else {
            l1->next = mergeTwoLists(l1->next, l2);
            return l1;
        }
    }
};