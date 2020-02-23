# TECHNICAL PREP

#### 1.String questions: Check if one string is a rotation of other string, check if a string is a palindrome, check if a string is a substring of other string, return the index of the first occurrence of a substring in other stirng, reverse a string, Difference between StringBuilder, StringBuffer and String.

* Rotation: **Dublicate** the String A, and use `String.contains()` method.
* Palindrome: **Two pointers**.
* Substring: **Two pointers**.
* Reverse a String: **Two pointers**.
* Difference betweeen StringBuilder, StringBuffer and String: 

> *StringBuffer* is **synchronized**, which can be accessed and modified by multipe threads. 

> *StringBuilder* is not **synchronized**, which can be accessed and modified by only one thread. Faster than StringBuffer.

-
#### 2.LinkedList questions: Reverse a linked list recursively(in-place) and iteratively, delete a node from linked list, find the nth node, find the nth node from the end, test if a linked list has a cycle, write test cases

* Reverse a linked list:

Recursively: **helper**

	helper(ListNode head, ListNode temp)    
	if (head == null) return temp;        
	ListNode next = head.next;    
	head.next = temp;
	return helper(next, head);

Iteratively: **Node prev, cur, temp**
 
	prev = null; cur = head;   
	ListNode temp = cur.next;   
	cur.next = prev;   
	prev = cur;   
	cur = temp;

* Delete a node: **traverse**
* Find the nth node: **traverse**
* Finde the nth node from the end: **traverse, count**
* Cycle: **two pointers, one fast and the other slow**

-
#### 3.What is immutable, Implement an immutable class(e.g. myDateTime)

Immutable: Object whose internal state remains constant after it has been entirely created. Once an object is created, we cannot change its content.

Immutable class:

* Declare the class as final so it can't be extended.
* Make all fields private so that direct access is not allowed.
* Don't provide setter methods for variables.
* Make all **mutable fields final** so that it's value can be assigned only once.
* Initialize all the fields via a constructor performing deep copy.
* Perform cloning of objects in the getter methods to return a copy rather than returning the actual object reference.

-
#### 4.What are volatile, synchronized, atomic

-
#### 5.What are some ways to implement a singleton in Java

1.**Eager initialization**

	public class Singleton
	{
		// public instance initialized when loading the class
		private static final Singleton instance = new Singleton();
		
		private Singleton()
		{
			//private constructor
		}
		public static Singleton getInstance() {
			return instance;
		}
	}
Object of class is created when it is loaded to the memory by JVM. It can be used when program will always use instance of this class, or the cost of creating the instance is not too large in terms of resources and time.

**Pros:**    
1. Very simple to implement.

**Cons:**   
1. May lead to resource wastage. Because instance of class is created always, whether it is required or not.    
2. CPU time is also wasted in creation of instance if it is not required.    
3. Exception handling is not possible.

2.**Using static block** 

	public class Singleton
	{
		public static Singleton instance;
		
		private Singleton()
		{
			
		}
		
		{
			// static block to initialize instance
			instance = new Singleton();
		}
	}

This is also a sub part of Eager initialization. The only difference is object is created in a static block. In this way, object is created at the time of class loading. It can be used when there is a chance of exceptions in creating object with eager initialization.

**Pros:**    
1. Very simple to implement.    
2. No need to implement getInstance() method. Instance can be accessed directly.    
3. Exceptions can be handled in static block.

**Cons:**
1. May lead to resource wastage. Because instance of class is created always, whether it is required or not.    
2. CPU time is also wasted in creation of instance if it is not required.

3.Lazy initialization.

	public class Singleton
	{
		// private instane, so that it can be
		// accessed only by getInstance() method
		private static Singleton instance;
		
		private Singleton()
		{
		}
		
		// method to return instance of class
		public static Singleton getInstance()
		{
			if (instance == null)
			{
				// if instance is null, initialize
				instance = new Singleton();
			}
			return instance;
		}
	}

-
#### 10.Level-order BFS on a binary tree

BFS:

	public List<List<Integer>> levelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		List<List<Integer>> res = new LinkedList<>();
		
		if (root == null) return res;
		
		queue.offer(root);
		while (!queue.isEmpty()) {
			int level = queue.size();
			List<Integer> list = new LinkedList<>();
			for (int i = 0; i < level; i++) {
				if (queue.peek().left != null) queue.offer(queue.peek().left);
				if (queue.peek().right != null) queue.offer(queue.peek().right);
				list.add(queue.poll().val);
			}
			res.add(list);
		}
		return res;
	}
	
DFS:
  
	public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        travel(root, result, 0);  
        return result;
    }
    private void travel(TreeNode curr, List<List<Integer>> result, int level) {
        if (curr == null) {
            return;
        }
        if (result.size() <= level) {
            List<Integer> newLevel = new LinkedList<>();
            result.add(newLevel);
        }
        List<Integer> collection = result.get(level);
        collection.add(curr.val);
        
        travel(curr.left, result, level + 1);
        travel(curr.right, result, level + 1);
    }



-
