package 树和图;

import java.util.*;

/**
 * 哈夫曼编码：根据读入的一段电文，统计电文中的每一个字符出现的频率，构建哈夫曼树，为该段电文设计哈夫曼编码并编译
 * 哈夫曼树，又称最优二叉树，是带权路径长度最短的树，
 * 用途：构造最优编码，用于信息传输，数据压缩
 * 哈夫曼树的数据结构：静态三叉链表
 */

//树结点
class Node {
    private String data;
    private Node leftNode;
    private Node rightNode;
    //结点的权值
    private double weight;
    public Node(String data, double weight) {
        this.data = data;
        this.weight = weight; }
    public Node getLeftNode() {
        return leftNode;
    }
    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }
    public Node getRightNode() {
        return rightNode;
    }
    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    @Override
    public String toString() {
        return "Node[data=" + data + ",weight=" + weight + "]";
    }
}

//哈夫曼树
class HuffmanTree {
    private List<Node> nodes = new ArrayList<Node>();       //节点集合
    public HuffmanTree addNode(Node node) {     //添加节点
        nodes.add(node);
        return this; }
    private void quickSort() {  //快速排序
        sort(0, nodes.size() - 1);
    }
    //根据weight进行排序
    private void sort(int start, int end) {
        if (start < end) {
            double temp = nodes.get(start).getWeight();
            int i = start;
            int j = end + 1;
            while (true) {
                while (i < end && nodes.get(++i).getWeight() <= temp) ;
                while (j > start && nodes.get(--j).getWeight() >= temp) ;
                if (i < j) {
                    swap(i, j);
                } else {
                    break;
                }
            }
            swap(start, j);
            sort(start, j - 1);
            sort(j + 1, end);
        }
    }
    //节点交换
    private void swap(int i, int j) {
        Node temp;
        temp = nodes.get(i);
        nodes.set(i, nodes.get(j));
        nodes.set(j, temp);
    }
    //生成哈夫曼树，返回根结点
    public Node createHuffmanTree() {
        //当结点集合中只有一个结点（即根结点）时结束
        while (nodes.size() > 1) {
            //对当前结合中的结点进行排序(结点集合中的结点个数每次都会改变)
            quickSort();
            //取到两个权值最小的结点
            Node left = nodes.get(0);
            Node right = nodes.get(1);
            //新结点
            Node newNode = new Node(null, left.getWeight() + right.getWeight());
            newNode.setLeftNode(left);
            newNode.setRightNode(right);
            //移除两个最小的结点
            nodes.remove(0);
            nodes.remove(0);
            nodes.add(newNode);     //添加新结点
        }
        return nodes.get(0);    //返回根结点
    }
    //广度优先遍历（需要借助队列）
    public List<Node> breadthFirst(Node root) {
        //保存结果集
        List<Node> lists = new ArrayList<Node>();
        //队列
        Queue<Node> queue = new ArrayDeque<Node>();
        if (root != null) {
            //加入结点到队列中
            queue.offer(root);
        }
        //如果队列为空，则结束
        while (!queue.isEmpty()) {
            //peek方法不移除结点
            lists.add(queue.peek());
            //弹出且移除
            Node p = queue.poll();
            //如果左结点不为空，则加入队列
            if (p.getLeftNode() != null) {
                queue.offer(p.getLeftNode());
            }
            //如果右结点不为空，则加入队列
            if (p.getRightNode() != null) {
                queue.offer(p.getRightNode());
            }
        }
        return lists;
    }
}
//哈夫曼编码实现类
class HuffmanCoding {
    Map<String, String> map = new HashMap<>();
    public Map<String, String> coding(Node root) {
        process(root, "");
        return map;
    }
    private void process(Node node, String content) {
        //叶子结点
        if (node.getLeftNode() == null) {
            map.put(node.getData(), content);
            return;
        }
        //对左子树分配代码"0"
        process(node.getLeftNode(), content + "0");
        //对右子树分配代码"1"
        process(node.getRightNode(), content + "1");
    }
}
public class 哈夫曼编码 {
    public static void main(String[] args) {
        HuffmanTree tree = new HuffmanTree();
        tree.addNode(new Node("A", 40.0))
                .addNode(new Node("B", 8.0))
                .addNode(new Node("C", 10.0))
                .addNode(new Node("D", 30.0))
                .addNode(new Node("E", 10.0))
                .addNode(new Node("F", 2.0));
        Node root = tree.createHuffmanTree();

        HuffmanCoding coding = new HuffmanCoding();
        Map<String, String> map = coding.coding(root);
        for(String str : map.keySet()){
            System.out.println(str + ":" + map.get(str));
        }
    }
}