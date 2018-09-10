class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null) return head;
        ListNode dummy = new ListNode(0);
        ListNode left = dummy;
        dummy.next = head;
        ListNode cur = head;
        ListNode pre = dummy;
        while(cur != null) {
        	if(pre == left) {//all the nodes before are all < x
        		if(cur.val < x) {
        			left = left.next;
        		}
        		pre = cur;
        		cur = cur.next;
        	} else {
        		if(cur.val >= x) {//pass the nodes >= x
        			pre = cur;
        			cur = cur.next;
        		} else {//insert the nodes < x
        			prev.next = cur.next;
        			cur.next = left.next;
        			left.next = cur;
        			left = left.next;
        			cur = pre.next;
        		}
        	}
        }
        return dummy.next;
    }
}