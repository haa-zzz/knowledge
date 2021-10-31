package 排序算法.链表

class 简单选择排序 {
    /**
     * 简单选择排序
     * 只是交换了value,并没有交换链表本身。
     * 因为链表交换元素只有对相邻元素容易操作，但是简单选择排序需要交换不相邻的元素，实现上来说比较复杂
     */
    fun selectionSort(head: ListNode?): ListNode? {
        if (head?.next == null)
            return head
        var i = head
        while (i?.next != null) {
            val minValue = getMin(i)
            if (minValue != i) {
                var temp = minValue.`val`
                minValue.`val` = i.`val`
                i.`val` = temp
            }
            i = i.next
        }
        return head
    }

    private fun getMin(i: ListNode): ListNode {
        var minNode = i
        var node = i
        while (node.next != null) {
            if (minNode.`val` > node.`val`) {
                minNode = node
            }
            node = node.next
        }
        return minNode
    }

}