
public class Baekjoon10845 {
	public static void main(String[] args){
		Queue q = new Queue();
		q.push(1);
		q.push(2);
		q.push(3);
		q.push(10);
		q.push(9);
		
		System.out.println(q.count);
		
		q.pop();
		q.pop();
		q.pop();
		q.pop();
		q.pop();
		
	}
}


class QueueNode{
	QueueNode nextNode;
	QueueNode beforeNode;
	int data;
	
	public QueueNode(int data){
		this.data = data;
	}
}

class Queue{
	QueueNode tailNode = null;
	QueueNode headNode = null;
	int count = 0;
	
	void push(int data){
		QueueNode newNode = new QueueNode(data);
		
		if(headNode == null){
			headNode = newNode;
			tailNode = newNode;
		}
		else {
			tailNode.nextNode = newNode;
			newNode.beforeNode = tailNode;
			tailNode =newNode;
		}
		
		count++;
	}
	
	void pop(){
		if(headNode ==null){
			System.out.println(-1);
		}
		else if(headNode == tailNode){
			System.out.println(tailNode.data);
			headNode = null;
			tailNode = null;
			count --;
		}
		else{
			System.out.println(tailNode.data);
			tailNode = tailNode.beforeNode;
			tailNode.nextNode = null; // ���� else if(headNode==tailNode) ���� ���ָ� ���⼭ NullPointer���� �߻�. 
			//������ tailNode.nextNode �� �̹� null �ε� �̰ɷ� ������ �Ϸ��� �߱� �����̴�.
			count--;
		}
	}
	
}
