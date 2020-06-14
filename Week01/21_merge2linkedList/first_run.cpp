/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
 /*
 思路：每次取两个数组中较小的那个，把两个数组组合成一个新的，时间复杂度o(n)
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
        ListNode* current = nullptr;
        if (l1 -> val > l2->val) {
            current = l2;
            l2=l2->next;
        }  else {
            current = l1;
            l1=l1->next;
        }
        ListNode* result = current;
        while (l1 != nullptr || l2 != nullptr) {
            if (l1==nullptr) {
                current->next = l2;
                l2 = l2->next;
                current = current->next;
            }else if (l2==nullptr) {
                current->next = l1;
                l1 = l1->next;
                current = current->next;
            }else if (l1 -> val > l2->val) {
                current->next = l2;
                l2=l2->next;
                current = current->next;
            }  else {
                current->next = l1;
                l1=l1->next;
                current = current->next;
            }
        }
        return result;
    }
};

