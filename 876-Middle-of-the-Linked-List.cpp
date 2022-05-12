/*
Given the head of a singly linked list, return the middle node of the linked list.
If there are two middle nodes, return the second middle node.

Example 1:
Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.

Example 2:
Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.

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
class Solution {
public:
    
    ListNode* middleNode(ListNode* head) {
        /* 
        Brute Force 
        TC: O(n)+O(n/2)
       ---------------------------
        int count =1;
        ListNode* current = head;
        while(current->next != NULL)
        {
            count++;
            current=current->next;
        }
        count = (count/2)+1;
        current=head;
        for(int i=1;i<count;i++)
        {
            current=current->next;
        }
        return current;
       */
        
     /*Optimal Solution Using Slow n Fast Pointer*/
     /* TC: O(N/2) */
    ListNode* fast=head;
    ListNode* slow=head;
    while(fast != NULL && fast->next != NULL)
    {
        slow=slow->next;
        fast = fast->next->next;
    }
    return slow;  
    }
};