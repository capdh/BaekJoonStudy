import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon9012  {

	public static void main(String[] args) throws IOException{
		Function myFunction = new Function();
		
		int number = 0;
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		number = Integer.parseInt(sc.readLine());
			
		for(int i = 0; i<number; i++){
			String inputString = sc.readLine();
			System.out.println(myFunction.isVPS(inputString));
		}
	}
	
}

class Function{
	
	 String isVPS(String str){
		int check = 0;
		String[] splitStr = new String[str.length()];
		splitStr = str.split(""); //���ڿ� �Է¹����� �ϳ��� spit���ڿ��迭�� ����
		
		Stack<String> stack = new Stack<String>();//���û���
		
		for(int i = str.length()-1; i>=0; i--){
			stack.push(splitStr[i]);//���ÿ��ٰ� ���ڿ� ����
		}
	   boolean bool = stack.empty();
		while(stack.empty()==false){ // ������ �����������, ���ÿ� �ִ� ���� ���� üũ�� +,-
			String popString= stack.pop();
			if(popString.equals("(")) {
				check++;
			}
			else if(popString.equals(")") && check>0) {
				check --;
			}
			else if(popString == ")" && check<=0){
				return "NO";
			}
		}
		
		if(check != 0)
			return "NO";
		else
			return "YES";		
		
	}
}
