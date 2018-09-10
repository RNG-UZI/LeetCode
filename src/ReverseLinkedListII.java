class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null || m >= n || m < 1) return;
        ListNode dummy = new ListNode(4396);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode mNode = head;
        ListNode post = null;
        ListNode nNode = null;
        int idx = 1;
        while(mNode.next != null) {//find m and pre
        	if(idx != m) {
        		idx++;
        		mNode = mNode.next;
        		pre = pre.next;
        	} else {
        		break;
        	}
        }
        nNode = mNode;
        post = nNode.next;
        while(nNode.next != null) {//find n and post
        	if(idx != n) {
        		idx++;
        		nNode = nNode.next;
        		post = post.next;
        	} else {
        		break;
        	}
        }
        nNode.next = null;
        //reverse
        while(mNode != null) {
        	ListNode next = mNode.next;
        	mNode.next = post;
        	post = mNode;
        	mNode = next;
        }
        pre.next = post;
        return dummy.next;
    }
}