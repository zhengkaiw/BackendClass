# TECHNICAL PREP

#### 1.String questions: Check if one string is a rotation of other string, check if a string is a palindrome, check if a string is a substring of other string, return the index of the first occurrence of a substring in other stirng, reverse a string, Difference between StringBuilder, StringBuffer and String.

* Rotation: **Dublicate** the String A, and use `String.contains()` method.
* Palindrome: **Two pointers**.
* Substring: **Two pointers**.
* Reverse a String: **Two pointers**.
* Difference betweeen StringBuilder, StringBuffer and String: 

 *StringBuffer* is **synchronized**, which can be accessed and modified by multipe threads. 

 *StringBuilder* is not **synchronized**, which can be accessed and modified by only one thread. Faster than StringBuffer.

---
#### 2.LinkedList questions: Reverse a linked list recursively(in-place) and iteratively, delete a node from linked list, find the nth node, find the nth node from the end, test if a linked list has a cycle, write test cases

* Reverse a linked list:

Recursively: **helper(DFS)**

	return helper(head, null);
	
	public ListNode helper(ListNode head, ListNode temp) {
		if (head == null) return temp;
		ListNode next = head.next;
		head.next = temp;
		return helper(next, head);
	}

Iteratively: **Node prev, cur, temp**
 
	ListNode prev = null;
	ListNode cur = head;
	
	while (cur != null) {
		ListNode temp = cur.next;
		cur.next = prev;
		prev = cur;
		cur = temp;
	}
	return prev;

* Delete a node: 

		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode cur = head, prev = dummy;
		while (cur != null) {
			if (cur.val == val) {
				prev.next = cur.next;
			} else {
				prev = cur;
			}
			cur = cur.next;
		}
		return dummy.next;
	
* Find the nth node:
		
		if (n == 1) {
            return head;
        }
        return findNthNode(head.next, n - 1);
* Finde the nth node from the end:

		return findNthNode(reverseLinkedListRecursively(head), n);
* Cycle: **two pointers, one fast and the other slow**

		if (head == null) return false;
		
		ListNode slow = head;
		ListNode fast = head;
		
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if (slow == fast) return true;
		}
		return false;
---

#### 3.What is immutable, Implement an immutable class(e.g. myDateTime)

Immutable: Object whose internal state remains constant after it has been entirely created. Once an object is created, we cannot change its content.

Immutable class:

* Declare the class as final so it can't be extended.
* Make all fields private so that direct access is not allowed.
* Don't provide setter methods for variables.
* Make all **mutable fields final** so that it's value can be assigned only once.
* Initialize all the fields via a constructor performing deep copy.
* Perform cloning of objects in the getter methods to return a copy rather than returning the actual object reference.

		public final class MyDateTime
		{
			final String name;
			final String date;
			
			public MyDateTime(String name, String date)
			{
				this.name = name;
				this.date = date;
			}
			
			public String getName()
			{
				return name;
			}
			
			public String getDate()
			{
				return date;
			}
		}
		
---

#### 4.What are volatile, synchronized, atomic    

* Volatile:
	The Java keyword `volatile` is used to mark a Java variable as "being stored in main memory". More precisely that means, that every read of a volatile variable will be read from the computer's main memory, and not from the CPU cache, and that every write to a volatile variable will be written to main memory, and not just to the CPU cache.

* Synchronized:    
	Synchronized blocks in Java are marked `synchroized` with the synchronized keyword. A synchronized block in Java is synchronized on some object. All synchronized blocks synchronized on the same object can only have one thread executing inside them at the same time. All other threads attempting to enter the synchronized block are blocked until the thread inside the synchronized block exits the block.
	
* Atomic:
 

---
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

3.**Lazy initialization**.

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
	
Object is created only if it is needed. This may prevent resource wastage. It can be used in a single threaded environment because multiple threads can break singleton property because they can access get instance method simultaneously and create multiple objects.

**Pros:**    
1. Object is created only if it is needed. It may overcome resource overcome and wastage of CPU time.    
2. Exception handling is also possible in method.

**Cons:**    
1. Every time a condition of null has to be checked.    
2. Instance can't be accessed directly.    
3. In multithreaded envrionment, it may break singleton property.

4.**Thread Safe Singleton**

	public class Singleton
	{
		private static Singleton instance;
		
		private Singleton()
		{
			
		}
		
		// synchronized method to control simultaneous access
		synchronized public static Singleton getInstance()
		{
			if (instance == null)
			{
				// if instance is null, initialize
				instance = new Singleton();
			}
			return instance;
		}
	}
	
**Pros:**    
1. Lazy initialization is possible.    
2. It is also thread safe.

**Cons:**    
1.getInstance() method is synchronized so it causes slow performance as multiple threads can't access it simultaneously.

5.**Lazy initialization with Double check locking**

	public class Singleton
	{
		private static Singleton instance;
		
		private Singleton()
		{
		}
		
		public static Singleton getInstance()
		{
			if (instance == null)
			{
				// synchronized block to remove overhead
				synchronized (Singleton.class)
				{
					if (instance == null)
					{
						// if instance is null, initialize
						instance = new Singleton();
					}
				}
			}
			return instance;
		}	
	}
	
getInstance is not synchronized but the block which creates instance is synchronized so that minimum number of threads have to wait and that's only for first time.

**Pros:**    
1. Lazy initialization is possible.    
2. It is also thread safe.    
3. Performance overhead gets reduced because of synchronized keyword.

**Cons:**    
1. First time, it can affect performance.    
As cons. of double check locking method is bearable so it can be used for high performance multi-threaded applications.

6.**Bill Pugh Singleton Implementation**

	public class Singleton
	{
		private Singleton()
		{
		}
		
		// Inner class to provid instance of class
		private static class BillPughSingleton
		{
			private static final Singleton INSTANCE = new Singleton();
		}
		
		public static Singleton getInstance()
		{
			return BillPughSingleton.INSTANCE;
		}
	}
When the singleton class is loaded, inner class is not loaded and hence doesn't create object when loading the class. Inner class is created only when getInstance() method is called. So it may seem like eager initialization but it is lazy initialization.    
This is the most widely used approach as it doesn't use synchronization.

---
#### 6. Implement a counting semaphore

A Semaphore is a thread synchronization construct that can be used either to send signals between threads to avoid missed signals, or to guard a critical section like you would with a lock.

	public class CountingSemaphore
	{
		private int signals = 0;
		
		public synchronized void take() 
		{
			this.signals++;
			this.notify();
		}
		
		public synchronized void release() throws InterruptedException
		{
			while (this signals == 0) wait();
			this.signals--;
			this.notify();
		}
	}
---
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
    
---
#### 13.Write a method receiving a stream of integers, caching the last 10 min of data and returning a number if it's less than the current input.

> CacheStream.java
