/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode curr = head.next, temp = curr;
        while(temp!=null){
            int sum=0;
            while(temp.val!=0){
                sum+=temp.val;
                temp = temp.next;
            }
            curr.val = sum;
            temp = temp.next;
            curr.next = temp;
            curr = curr.next;
        }
        return head.next;
    }
}