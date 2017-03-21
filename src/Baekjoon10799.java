import java.util.Scanner;
import java.util.Stack;

public class Baekjoon10799 {
	
	public static int howMany(String str){ //레이저로 나뉘는 쇠파이프가 몇개인지 구하는 메소드
		Stack stack = new Stack();
		boolean laserFlag = false; // 전단계에서 레이저가 나왔는지 안나왔는지 알기 위해.
		int laserCount = 0; //레이저의 갯수 ( 스택이 다 비워지면 0 으로 초기화 해야함 )
		int pipeCount = 0; //파이프 잘린것의 갯수. 마지막 리턴할 값

		for(int i=0; i<str.length(); i++){
			
			if(stack.empty()){
				laserCount = 0 ;
			}
			
			if(str.charAt(i)=='('){ // ( 나오면 바로 푸쉬
				stack.push('(');
				laserFlag = false;
			}
			
			else if(str.charAt(i)==')' && laserFlag==false){ // 레이저가 맞을 조건
				stack.pop(); //스택에서 레이저의 앞부분을 꺼낸다
				laserCount++; // 레이저 갯수 한개 올려준다
				laserFlag = true; // 방금 스택에서 꺼낸것이 레이져였다는것을 표시한다.
			}
			
			else if(str.charAt(i)==')' && laserFlag == true){ // ')'이 나왔지만 이것은 레이저가 아니라 쇠파이프라는 소리.
				stack.pop();
				pipeCount += (laserCount+1); // 레이저 갯수만큼 파이프 카운트 올려줌
			}
		}
		
		return pipeCount;
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine(); //쇠파이프와 레이저 정보 스트링
		int number = howMany(str);
		System.out.println(number);
		
	}
	
	
}

