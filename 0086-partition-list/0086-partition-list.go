/**
 * Definition for singly-linked list.
 * type ListNode struct {
        
 *     Val int
 *     Next *ListNode
 * }
 */
func partition(head *ListNode, x int) *ListNode {
    smallerDummy := &ListNode{}
    greaterDummy := &ListNode{}
    smaller := smallerDummy
    greater := greaterDummy
    for head != nil{
        if head.Val < x{
            smaller.Next = head 
            smaller = smaller.Next
        } else{
            greater.Next = head
            greater = greater.Next
        }
        head = head.Next
    }
    greater.Next = nil
    smaller.Next = greaterDummy.Next
    return smallerDummy.Next
}