/*
Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.
Return the decimal value of the number in the linked list.

Example 1:
Input: head = [1,0,1]
Output: 5
Explanation: (101) in base 2 = (5) in base 10

Example 2:
Input: head = [0]
Output: 0
*/
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

/* Approach
approach is we are assuming the node on which current is present is the last node of the linkedlist.
but when we move to the next node we found the one before was not the last node so we multiply all the node before with 2 or we can multiple ans with 2
*/

class Solution {
public:
    int getDecimalValue(ListNode* head) {
        if(head == NULL) return 0;
        int ans = 0;
        ListNode* current = head;
        while(current!=NULL)
        {
            ans = ans*2;
            ans += current->val;
            current = current->next;
        }
        return ans;   
    }
};