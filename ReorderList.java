/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param head: The head of linked list.
     * @return: void
     */
    public void reorderList(ListNode head) {  
        // write your code here
        if(head == null || head.next == null){
            return;
        }
        
        ListNode headCopy = head;
        ListNode partition = getPartition(headCopy);
        ListNode newHead = reverse(partition.next);
        partition.next = null;
        
        head = merge(head, newHead); 
    }
    
    private ListNode getPartition(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    //return the new head of the reversed list
    private ListNode reverse(ListNode head){       
        ListNode prev = null;
        while(head != null){
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
    
    private ListNode merge(ListNode head1, ListNode head2){
        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }
        ListNode dummy = new ListNode(0);
        ListNode dummyCopy = dummy;
        int cnt = 0;
        while(head1 != null && head2 != null){
            if(cnt % 2 == 0){
                dummy.next = head1;
                head1 = head1.next;
            }else{
                dummy.next = head2;
                head2 = head2.next;
            }
            dummy = dummy.next;
            cnt++;
        }
        if(head1 != null){
            dummy.next = head1;
        }
        if(head2 != null){
            dummy.next = head2;
        }
        return dummyCopy.next;
    }
}
