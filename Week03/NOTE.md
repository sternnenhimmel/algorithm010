学习笔记

### 递归模板：
// Java
public void recur(int level, int param) { 
  // terminator 
  if (level > MAX_LEVEL) { 
    // process result 
    return; 
  }
  // process current logic 
  process(level, param); 
  // drill down 
  recur( level: level + 1, newParam); 
  // restore current status 
 
}

### 递归要点：
1. 不要人肉递归
2. 拆解成最近重复子问题
3. 数据归纳法思维

### 范型递归：
void recursive(int level, int max, List<Integer>states) {
    if(level==max){
        //teminate
    }
    //process
    this.process(states);

    //drill down
    recusive(level+1, max, states);

    //deal with some states as needed in current level
}

### 分治和回溯
1. 核心在于寻找重复性，最终会转换成递归。其中，动态规划属于最优递归。


### 分治代码模板
// Python
def divide_conquer(problem, param1, param2, ...): 
  // recursion terminator 
  if problem is None: 
	print_result 
	return 
  // prepare data 
  data = prepare_data(problem) 
  subproblems = split_problem(problem, data) 
  // conquer subproblems 
  subresult1 = self.divide_conquer(subproblems[0], p1, ...) 
  subresult2 = self.divide_conquer(subproblems[1], p1, ...) 
  subresult3 = self.divide_conquer(subproblems[2], p1, ...) 
  …
  // process and generate the final result 
  result = process_result(subresult1, subresult2, subresult3, …)
	
  // revert the current level states

### 刷题感悟
发现递归的本质其实是树的深度遍历，递归和树的深度遍历都可以用栈来实现。并且，既然是树的遍历，那么，很多题目其实可以用广度遍历的方式以同样的时间复杂度完成。只是广度遍历需要自己维护queue以及对应树的节点，而深度遍历和递归则可以直接使用系统的调用栈。