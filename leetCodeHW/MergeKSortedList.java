package leetCodeHW;

class MergeKSortedList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if ((lists.length == 0) || (lists == null)) {
            return null;
        } else if (lists.length == 1) {
            return lists[0];
        } else if (lists.length > 1) {
            ListNode t = null;
            ListNode l1;
            for (int i = 0; i < lists.length; i++) {
                l1 = lists[i];
                t = mergetwosortedlists(t, l1);
            }
            return t;
        }
        return null;
    }

    public static ListNode mergetwosortedlists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = (l1 != null) ? l1 : l2;

        return dummy.next;
    }
}
