# 说明文档
[toc]

**项目说明：**

- TreeMap代码在 /TreeMap/lib/src/main/java/com/example/lib/ 文件夹下
  - **UseOfTreeMap**：可运行的 **主要测试程序**，已包含测试数据，运行后可查看各类方法使用
  - TreeMapUtils：包括 TreeMap 所有使用方法文字注释与解析
  - NavigatorTreeMap：Navigator接口示例
  - HashMapCompater：HashMap与TreeMap **性能测试用例**
- README.md 为说明文档
- 测试结果.txt 包含 10万、50万、100万至1000万测试数据结果。



# TreeMap解析

## 原理

基于红黑树实现的可排序的数据结构。

>红黑树是一种非完全平衡的二叉搜索树，同时结合了 **平衡二叉树** 和 **二叉搜索树** 的性质。

红黑树的5条特征：

1. 每个结点要么是红的，要么是黑的。 

2. 根结点是黑的。 

3. 每个叶结点（叶结点即指树尾端NIL指针或NULL结点）是黑的。  

4. 如果一个结点是红的，那么它的俩个儿子都是黑的。  

5. 对于任一结点而言，**其到叶结点树尾端NIL指针的每一条路径都包含相同数目的黑结点**

   ![](https://p1-jj.byteimg.com/tos-cn-i-t2oaga2asx/gold-user-assets/2019/11/20/16e878854e7e8018~tplv-t2oaga2asx-zoom-in-crop-mark:3024:0:0:0.awebp)

## 源码实现

![](https://upload-images.jianshu.io/upload_images/5621908-9e7544ea7dd5670c.png?imageMogr2/auto-orient/strip|imageView2/2/w/486/format/webp)

TreeMap继承于AbstractMap，实现了Map, Cloneable, NavigableMap, Serializable接口。

- TreeMap 实现了Map接口，成为Map框架中的一员，可以包含着key--value形式的元素；

- TreeMap 实现了 **NavigableMap接口**（继承于SortedMap），意味着拥有了更强的元素搜索能力与排序功能；

- TreeMap 实现了Cloneable接口，实现了clone()方法，可以被克隆

- TreeMap 实现了Java.io.Serializable接口，支持序列化操作，可通过Hessian协议进行传输；

  

**TreeMap节点结构**

底层存储结构与HashMap基本相同，使用Entry对象，存储key--value键值对。

**TreeMap 构造函数**

所有的操作都是通过根节点来进行。



## 性能对比

**红黑树 RBT 与平衡二叉树 AVL 对比：**

![](https://pic1.zhimg.com/80/v2-3b0dd24fe1bc5e5940cc405233ce1e0e_1440w.jpg?source=1940ef5c)

**查找频繁**                使用AVL树。

**插入和删除频繁**    使用性能更好的红黑树。

**分析**     AVL 树比红黑树更加平衡，但AVL树在插入和删除的时候会存在大量的旋转操作，影响性能。而 **红黑树 **最多进行 **三次旋转**。





**与HashMap、ConcurrenSkipListMap对比**

<table>   	
  <tr> 		
    <td>操作类型</td> 		
    <td colspan="4">插入</td>
    <td colspan="3">查找（在100W数据量中）</td>
    <td>时间</td>
  <tr> 	
  <tr> 		
    <td></td> 	
    <td>10W</td> 	
    <td>50W</td> 
    <td>100W</td> 
    <td>150W</td> 
    <td>0-1W</td> 
    <td>0-25W</td> 
    <td>0-50W</td> 
  <tr> 	
  <tr> 		
    <td>Concurrent
      SkipListMap</td> 		
    <td>62 ms</td> 	
    <td>227 ms</td> 	
    <td>433 ms</td> 	
    <td>689 ms</td> 	
    <td>7 ms</td> 	
    <td>80 ms</td> 	
    <td>119 ms</td> 	
    <td>O(logN)</td>
  </tr> 	
  <tr> 		
    <td>HashMap</td> 		
    <td>20 ms</td> 	
    <td>57 ms</td> 	
    <td>217 ms</td> 	
    <td>303 ms</td> 	
    <td>2 ms</td> 	
    <td>13 ms</td> 	
    <td>45 ms</td>
    <td>O(log1)</td>
  </tr> 	
  <tr> 		
    <td>TreeMap</td> 		
    <td>11 ms</td> 	
    <td>64 ms</td> 	
    <td>429 ms</td> 	
    <td>584 ms</td> 	
    <td>4 ms</td> 	
    <td>34 ms</td> 	
    <td>61 ms</td> 	
    <td>O(logN)</td>
  </tr> 
</table>


**50W以下插入**   使用TreeMap

**50W以上插入**  使用HashMap

**如有排序需求，且非多线程，低并发**    使用TreeMap

**如有排序需求，且为多线程，高并发**    使用 [ConcurrentSkipListMap](https://www.jianshu.com/p/edc2fd149255)，适用于大规模数据的并发访问



**分析：**

- 当数据量较小时，HashMap扩容会引起散列冲突，解决冲突需要多花时间代价，故在f(n)=1向上浮动；
- 随着数据量的增加，HashMap的时间花费小且稳定，在单线程的环境下比TreeMap和ConcurrentSkipListMap在插入和查找上有很大的优势。
- ConcurrentSkipListMap自带锁机制





## 应用

- 红黑树

  常用于存储内存中的有序数据，增删很快，内存存储不涉及 I/O 操作。已用于实现 Linux 操作系统的 CPU 调度，大多数自平衡库函数，如 C++ 的 map 和 set，Java 的 TreeSet 和 TreeMap。

- B/B+树

  更适合磁盘存储，减少了树的层级，进而减少 I/O 次数；

- B 树和 B+ 树对比

  都是 B 树，但是 B+树更适合范围查询，比如 Mysql，且查询次数很稳定，为 logn。而 B 树更适合键值对型的聚合数据库，比如 MongoDB，查询次数最优为 O(1)；

> 红黑树更适合内存存储，B 树更适合键值对存储，B+ 树适合范围查询；

[详细资料](https://juejin.cn/post/6953547181299073037)





# 附录

![](https://oscimg.oschina.net/oscnet/up-0dcba6005c20f21c6a6e966b9f239b7bc91.png)

[从二叉搜索树->红黑树->B树的演变](https://www.modb.pro/db/33411)

## AVL 平衡二叉树

左右子树的高度差小于等于 1。平衡二叉树有两大基础操作：左旋和右旋。

**右旋操作**

![](https://pic3.zhimg.com/80/v2-eee97a3e3e45d8cb6668841f6b44191a_1440w.jpg)

**左旋操作**

![](https://pic3.zhimg.com/80/v2-0a737f5850ac96deec1821c80391a08a_1440w.jpg)

[AVL需要平衡的四种情况解析](https://zhuanlan.zhihu.com/p/34899732)

## BST 二叉查找树

又名二叉搜索树。对于二叉树中的每个节点X，它的左子树中所有项的值都小于X中的项，它的右子树中所有项的值大于X中的项。

![d](https://img2018.cnblogs.com/blog/1775037/201909/1775037-20190922154700384-1450245834.png)

同样的数据，也可以有不同二叉搜索树。

<img src="https://img2018.cnblogs.com/blog/1775037/201909/1775037-20190922162451691-280943069.png" />

由于二叉搜索树可能退化成链表，所以查找操作与该树的高度相关，如果高度为节点数 N，相应查找、插入、删除的操作**退化成O(N)** 级别。所以，一般说二叉搜索树效率为O(logN)，只是一个估算，具体与其形状有关。为了优化，提出了红黑树。

## RBT 红黑树

是一种自平衡的二叉搜索树，同时 **结合了平衡二叉树和二叉搜索树** 的性质。满足5条性质：

1. 每个结点要么是红的，要么是黑的。 
2. 根结点是黑的。 
3. 每个叶结点（叶结点即指树尾端NIL指针或NULL结点）是黑的。  
4. 如果一个结点是红的，那么它的俩个儿子都是黑的。  
5. 对于任一结点而言，**其到叶结点树尾端NIL指针的每一条路径都包含相同数目的黑结点**

![](https://p1-jj.byteimg.com/tos-cn-i-t2oaga2asx/gold-user-assets/2019/11/20/16e878854e7e8018~tplv-t2oaga2asx-zoom-in-crop-mark:3024:0:0:0.awebp)

这些性质使红黑树保持了 logN的高度，所以红黑树的查找、插入、删除的时间复杂度 **最坏为O(logN)**

[红黑树旋转解析](https://www.jianshu.com/p/ab90c2ec07e4)

## B树

[B树引入的前情提要](https://blog.csdn.net/v_JULY_v/article/details/6530142/)

[B树视频讲解2分钟，简单好懂！五星推荐！！](https://www.bilibili.com/video/BV1et4y117wc?spm_id_from=333.337.search-card.all.click&vd_source=8b91153a2dbbe77b473d729f57f2c650)

[M阶/K的概念](https://blog.csdn.net/Elephant_King/article/details/122683856?spm=1001.2101.3001.6661.1&utm_medium=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-1-122683856-blog-103533052.pc_relevant_multi_platform_whitelistv1&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-1-122683856-blog-103533052.pc_relevant_multi_platform_whitelistv1&utm_relevant_index=1)

又叫平衡多路查找树。B 树是为了磁盘或其它存储设备而设计的一种多叉平衡查找树，与红黑树类似，但在降低磁盘I/O操作方面要更好。很多数据库系统一般使用B树或者B树的变形结构。

有 N 个关键字的 X 结点，内含 N + 1 个子结点（如 D H 2个关键字的结点，有3个子女）：

![在这里插入图片描述](https://img-blog.csdnimg.cn/5173ad5cb2014d6c9302fb95cfe51e41.jpeg)

B树满足条件：

![](https://img-blog.csdnimg.cn/14d2733060d14e0ba687de0b28ea80b4.png)

## B+树

![](https://ivanzz1001.github.io/records/assets/img/data_structure/ds_bplus_tree1.jpg)

[B+树的生成](https://www.bilibili.com/video/BV1cf4y1s727?spm_id_from=333.337.search-card.all.click&vd_source=8b91153a2dbbe77b473d729f57f2c650)

[视频讲解与B树的区别，主要有两点，只有两分钟，五星推荐！！！](https://www.bilibili.com/video/BV1PS4y137LJ?spm_id_from=333.337.search-card.all.click&vd_source=8b91153a2dbbe77b473d729f57f2c650)
