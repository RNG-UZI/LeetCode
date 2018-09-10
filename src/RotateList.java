class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) {
        	return head;
        }
        int len = 1;
        ListNode p = head;
        while(p.next != null) {
        	p = p.next;
        	len++;
        }
        p.next = head;//form a loop
        for(int i = 1; i < len - k % len; i++) {
        	head = head.next;
        }
        ListNode res = head.next;
        head.next = null;
        return res;
    }
}