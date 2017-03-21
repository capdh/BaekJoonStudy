import java.util.Scanner;
import java.util.Stack;

public class Baekjoon10799 {
	
	public static int howMany(String str){ //�������� ������ ���������� ����� ���ϴ� �޼ҵ�
		Stack stack = new Stack();
		boolean laserFlag = false; // ���ܰ迡�� �������� ���Դ��� �ȳ��Դ��� �˱� ����.
		int laserCount = 0; //�������� ���� ( ������ �� ������� 0 ���� �ʱ�ȭ �ؾ��� )
		int pipeCount = 0; //������ �߸����� ����. ������ ������ ��

		for(int i=0; i<str.length(); i++){
			
			if(stack.empty()){
				laserCount = 0 ;
			}
			
			if(str.charAt(i)=='('){ // ( ������ �ٷ� Ǫ��
				stack.push('(');
				laserFlag = false;
			}
			
			else if(str.charAt(i)==')' && laserFlag==false){ // �������� ���� ����
				stack.pop(); //���ÿ��� �������� �պκ��� ������
				laserCount++; // ������ ���� �Ѱ� �÷��ش�
				laserFlag = true; // ��� ���ÿ��� �������� ���������ٴ°��� ǥ���Ѵ�.
			}
			
			else if(str.charAt(i)==')' && laserFlag == true){ // ')'�� �������� �̰��� �������� �ƴ϶� ����������� �Ҹ�.
				stack.pop();
				pipeCount += (laserCount+1); // ������ ������ŭ ������ ī��Ʈ �÷���
			}
		}
		
		return pipeCount;
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine(); //���������� ������ ���� ��Ʈ��
		int number = howMany(str);
		System.out.println(number);
		
	}
	
	
}

