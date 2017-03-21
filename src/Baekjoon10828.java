import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon10828 {
	public static void main(String[] args){
		String inputString = null; // �Է¹޴� ���ڿ�
		String[] splitString = new String[2]; // push 3 �̷��Ÿ� push�� 3���� �ɰ��� ���� ���ڿ� �迭
		int number = 0; // ��� ��������
		MyStack myStack = new MyStack(); //���� ����
		
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		try{
			number = Integer.parseInt(sc.readLine());
		}
		catch(IOException e){
			e.getMessage();
		}
		
		for(int i =0; i<number; i++){
			try{
				inputString = sc.readLine();
				splitString = inputString.split(" ");
			}
			catch(IOException e){
				e.getMessage();
			}
			
			switch(splitString[0]){ 
			case "push":
				myStack.push(Integer.parseInt(splitString[1]));
				break;
			
			case "pop":
				myStack.pop();
				break;
				
			case "size":
				myStack.size();
				break;
				
			case "empty":
				myStack.empty();
				break;
				
			case "top":
				myStack.top();
				break;
			}
			
		}
	}
	
		

}

class MyStack{
	int count;
	Node headNode;
	
	public MyStack(){
		count = 0;
		headNode = null;
	}
	
	
	void push(int data){
		if(count==0){
			Node newNode = new Node(data);
			headNode = newNode;
			count++;
		}
		
		else{
			Node newNode = new Node(data);
			newNode.nextNode = headNode;
			headNode = newNode;
			count++;
		}
	}
	
	void pop(){
		if(count > 0){
			System.out.println(headNode.data);
			headNode = headNode.nextNode;
			count--;
		}
		else{
			System.out.println(-1);
		}
		
	}
	
	void size(){
		System.out.println(count);
	}
	
	void empty(){
		if(count>0)
			System.out.println(0);
		else
			System.out.println(1);
	}
	
	void top(){
		if(count>0)
			System.out.println(headNode.data);
		else
			System.out.println(-1);
	}
	
}

class Node{
	Node nextNode;
	int data;
	
	public Node(int data){
		this.data = data;
	}
}