package demo;

/**
 * 链表
 * @author Administrator
 *
 * @param <T>
 */
public class Link<T> {
	public class Node{
		/**
		 * 当前节点
		 */
		private T value;
		/**
		 * 指针
		 */
		private Node next;
		
		public Node(T value,Node next)
		{
			this.value = value;
			
			this.next = next;
		}
		public Node(T value)
		{
			this.value = value;
			this.next = null;
		}
	}
	private Node head;//头节点
	private int size;//节点数量
	
	//链表初始化
	public Link() {
		this.head = null;
		this.size = 0;
	}
	
	//获得头节点
	public Node getHead(){
		return this.head;
	}
	/**
	 * 插入头节点
	 * @param value 插入元素
	 */
	public void addFirst(T value) {
		Node node = new Node(value);
		node.next = head;
		this.head = node;
		this.size ++;
	}
	/**
	 * 中间插入节点
	 * @param value 插入元素
	 * @param args 插入位置的下标
	 */
	public void addNode(T value, int args) {
		if (args < 0 && args > size  )
		{
			throw new IllegalArgumentException();
		}
		if (args == 0)
		{
			this.addFirst(value);
		}else {
			Node preNode = head;
			//从第二个节点开始遍历
			for (int i = 0; i < args-1; i++ )
			{
				preNode =  preNode.next ;
			}
			Node node = new Node(value);
			//连接插入的节点
			node.next = preNode.next;
			preNode.next = node;
			this.size++;
		}

	}
	
	/**
	 * 插入尾节点
	 * @param value 插入元素
	 */
	public void addTail(T value)
	{
		addNode(value,this.size);
	}
	
	/**
	 * 删除节点
	 * @param args 删除元素下标
	 */
	public void deleteNode(int args) 
	{
		Node headNode = head;
		Node selfNode = head;
		if (0 == args)
		{
			head = head.next;
		}else {
			for (int i = 0 ; i < args; i++)
			{
				headNode = selfNode;
				selfNode = selfNode.next;
			}
			headNode.next = selfNode.next;		
		}
		this.size--;
	}
	/**
	 * 打印链表
	 */
	public void printLink()
	{
		Node node = head;
		while(null != node) 
		{
			System.out.println(node.value );
			node =  node.next;
		}
	}
	/**
	 * 反向打印链表
	 * @param node
	 */
	public void reversePrint(Node node)
	{
		if(null != node && null != node.next)
		{
			 reversePrint(node.next);
		}
		System.out.println(node.value);
	}
	/**
	 *  测试
	 * @param args
	 */
	public static void main(String[] args) {

		Link<Integer> link = new Link<Integer>();
		link.addFirst(1);
		link.addTail(3);
		link.addNode(2, 1);
		link.addTail(4);
		link.deleteNode(1);
		link.addNode(0,0);
		link.addTail(5);
		System.out.println("——顺序输出.——");
		System.out.println(); link.printLink();
		System.out.println("——逆序序输出.——");
		link.reversePrint(link.getHead());
		
	}
	
	
	
	
}
