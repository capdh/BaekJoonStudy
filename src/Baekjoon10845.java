
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
			tailNode.nextNode = null; // 위에 else if(headNode==tailNode) 조건 안주면 여기서 NullPointer예외 발생. 
			//이유는 tailNode.nextNode 가 이미 null 인데 이걸로 뭔가를 하려고 했기 때문이다.
			count--;
		}
	}
	
}
