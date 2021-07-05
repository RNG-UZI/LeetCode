class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode firstPrev = dummy;
        for (int i = 0; i < k - 1; ++i) {
        	firstPrev = firstPrev.next;
        }

        ListNode secondPrev = dummy;
        ListNode tail = firstPrev.next.next;
        // when tail reaches the end, the secondPrev is in the right place
        while (tail != null) {
        	tail = tail.next;
        	secondPrev = secondPrev.next;
        }

        ListNode first = firstPrev.next;
        ListNode second = secondPrev.next;
        ListNode firstNext = first.next;
        ListNode secondNext = second.next;
        // 4 circumstances total
        if (second.next == first) {
        	secondPrev.next = first;
        	first.next = second;
        	second.next = firstNext;
        } else if (secondPrev == first) {
        	firstPrev.next = second;
        	second.next = first;
        	first.next = secondNext;
        } else {
        	firstPrev.next = second;
        	second.next = firstNext;
        	secondPrev.next = first;
        	first.next = secondNext;
        }
        return dummy.next;
    }
}