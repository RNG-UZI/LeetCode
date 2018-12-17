/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode cur = head;
        //create new nodes
        while (cur != null) {
        	map.put(cur, new RandomListNode(cur.label));
        	cur = cur.next;
        }
        //copy the next and random pointers
        cur = head;
        while (cur != null) {
        	map.get(cur).next = map.get(cur.next);
        	map.get(cur).random = map.get(cur.random);
        	cur = cur.next;
        }
        return map.get(head);

    }
}