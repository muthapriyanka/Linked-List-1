//time complexity:O(m+n)
//space complexity:O(1)
public class Intersection {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB)
    {
        if(headA==null || headB==null)
        {
            return null;
        }
        ListNode currA = headA;
        ListNode currB = headB;

        int lenA = 0;
        int lenB = 0;

        // Calculate the length of list A
        while (currA != null) {
            lenA++;
            currA = currA.next;

        }

        // Calculate the length of list B
        while (currB != null) {
            lenB++;
            currB = currB.next;
        }

        // Reset the pointers to the head of each list
        currA = headA;
        currB = headB;

        // Adjust the starting point for the longer list
        while (lenA > lenB) {
            currA = currA.next;
            lenA--;
        }
        while (lenB > lenA) {
            currB = currB.next;
            lenB--;
        }

        // Move both pointers until they meet at the intersection point
        while (currA != currB) {
            currA = currA.next;
            currB = currB.next;
        }

        return currA;
    }
    public static void main(String[] args)
    {
        Intersection obj=new Intersection();
        ListNode common = new ListNode(3, new ListNode(4));

        ListNode headA = new ListNode(1, new ListNode(2, common));
        ListNode headB = new ListNode(5, common);
        ListNode node=obj.getIntersectionNode(headA, headB);
        System.out.println(node.val);

    }
}
