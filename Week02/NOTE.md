## 学习笔记

### 面试四步法
1. classification
2. possible solutions -> (optimize time &space)
3. code 
4. test cases

### 哈希表
哈希函数，哈希碰撞（可以拉链表解决），常用的有map和set

#### hashMap总结
java中hash值的计算是个native方法，不过哈希表还是在此基础上做了一个移位异或，以达到更好的分散效果
1. put：为了防止越界，存放位置是hash值与n-1的&操作符结果。如果目标位置有相同的值key，则替换，如果目标位置有冲突，则转换成链表，这个链表达到一定长度（8）以后就会存成一棵树。put以后检查size是否达到阈值(capacity*load_factor)，如果达到了，则需要扩容。扩容一般会把容量加倍，然后把老表的内容重新散列分散到新表
2. getNode：算好hash以后找到目标位置所存放的值，如果只有一个值则返回，如果已经链表化，则遍历，如果目标位置的节点是个TreeNode，则从树结构中寻找目标的key

### 树：数据结构往二维的扩展

#### 二叉搜索树：
1. 左子树节点小于根节点
2. 右子树节点大于根节点
3. 左右子树也都是二叉搜索树
4. 查询插入都是o(n),但不平衡时会退化

#### 思考题：为什么树的考题都是递归的？
因为子树和树本身有相同的结构和客观规律以及处理方式，树本身就是一种重复性的体现

#### 二叉树的前中后序遍历：
public void preorder(Node root) {
    if (root != null) {
        dealwith(root);
        preorder(root->left);
        preorder(root->right);
    }
}

public void inorder(Node root) {
    if (root != null) {
        inorder(root->left);
        dealwith(root);
        inorder(root->right);
    }
}

public void postorder(Node root) {
    if (root != null) {
        postorder(root->left);
        postorder(root->right);
        dealwith(root);
    }
}