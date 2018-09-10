class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode real = dummy;
        while(cur != null) {
        	if((pre == dummy || pre.val != cur.val) && (cur.next == null || cur.val != cur.next.val)) {
        		real.next = cur;
        		real = cur;
        	}
        	pre = cur;
        	cur = cur.next;
        	pre.next = null;
        }
        return dummy.next;
    }
}