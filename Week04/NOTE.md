学习笔记

### DFS：深度优先遍历
本质是用栈来实现，先近后出，可以利用递归，从而使用系统自带的栈实现，简化代码，代码模板如下：
1. 递归写法：
```
visited = set() 
def dfs(node, visited):
    if node in visited: # terminator
    	# already visited 
    	return 
	visited.add(node) 
	# process current node here. 
	...
	for next_node in node.children(): 
		if next_node not in visited: 
			dfs(next_node, visited)
```

2. 非递归写法：
```
def DFS(self, tree): 
	if tree.root is None: 
		return [] 
	visited, stack = [], [tree.root]
	while stack: 
		node = stack.pop() 
		visited.add(node)
		process (node) 
		nodes = generate_related_nodes(node) 
		stack.push(nodes) 
	# other processing work 
	...
```

### BFS：广度优先遍历
需要用queue来实现，达到先进先出的效果，代码模板：
```
def BFS(graph, start, end):
    visited = set()
	queue = [] 
	queue.append([start]) 
	while queue: 
		node = queue.pop() 
		visited.add(node)
		process(node) 
		nodes = generate_related_nodes(node) 
		queue.push(nodes)
	# other processing work 
	...
```

### 贪心算法
1. 往往比较巧妙且最优
2. 实用性不高

### 二分查找
1. 存在上下限
2. 单调性
3. 通过索引访问

### 代码模板
看起来是递归的一种：
```
# Python
left, right = 0, len(array) - 1 
while left <= right: 
	  mid = (left + right) / 2 
	  if array[mid] == target: 
		    # find the target!! 
		    break or return result 
	  elif array[mid] < target: 
		    left = mid + 1 
	  else: 
		    right = mid - 1
```

### 解题四步骤：
1. 审题，尤其要弄清楚边界条件并进行判断
2. 和面试官探讨所有可能的解法，算时间复杂度空间复杂度，在面试官同意的情况下才能开始写代码
3. 写代码
4. 给一些测试的样例，一般是正常测试，边界条件，变态样例

### 关于找出找出数组变异点的讨论
这个其实和作业中找出变异数组最小值很像，变异点右边的数就是最小值，而变异点左半部分和右边部分中总有一个部分是不符合单调递增规律的，只要按照这个思路二分缩小查找范围即可。
```java
/**
这个题其实就是要用二分查找找出旋转的点
*/
class Solution {
    public int findMin(int[] nums) {
        if(nums==null||nums.length==0) {
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        int left=0, right=nums.length-1;
        while(left <= right) {
            int mid = (left+right)/2;
            if(mid<nums.length-1&&nums[mid]>nums[mid+1]) {
                return mid;
            }
            if(mid>0&&nums[mid]<nums[mid-1]){
                return mid-1;
            }
            //除去上面2种情况，出现问题的点肯定在左边或者右边不遵守条件的地方
            if(nums[mid]<nums[left]){
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        //最终都没找到变异点，那就是每变异，第一个就是变异点
        return 0;
    }
}
```