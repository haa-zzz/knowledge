package 排序算法.链表;

/**
 *  链表实现冒泡排序
 *  冒泡排序：重复走访要排序的数列，一次比较两个元素，若较小元素在后则交换，能看到越小的元素会经由交换慢慢浮到数列的顶端
 *
 *   时间复杂度O(n^2)
 *   空间复杂度O(1)
 *   稳定性：稳定排序
 */

public class 冒泡排序 {
    //单链表冒泡排序
    public ListNode bubbleSort(ListNode node){
        //当前节点
        ListNode pre = node.next;
        //下一个节点
        ListNode cur;
        //特判
        if( (cur = pre.next) == null ){
            return node;
        }
        //前一个节点,两节点n1,n2交换位置时需要前一个节点的next指向n2节点
        ListNode upperNode = node;
        //一次排序的最后一个节点
        ListNode lastNode = null;

        boolean isChanged = false;      //优化
        //冒泡排序，每一趟都需要从头开始。当第二个节点为当次排序的最后一个节点时，整体排序结束
        while(node.next != lastNode){
            //当下一个节点为一次次排序的最后一个节点时，本次排序结束。
            if(cur == lastNode){
                //在一趟结束后判断是否这一趟有交换
                if(!isChanged){
                    break;
                }
                isChanged = false;
                
                lastNode = pre;
                pre = node.next;
                upperNode = node;
            }else if(cur.val < pre.val){
                isChanged = true;
                pre.next = cur.next;
                cur.next = pre;
                upperNode.next = cur;
                upperNode = cur;
            }else{
                upperNode = pre;
                pre = pre.next;
            }
            cur = pre.next;
        }
        return node;
    }
}
