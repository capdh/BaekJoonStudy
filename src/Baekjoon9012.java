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
		splitStr = str.split(""); //문자열 입력받은거 하나씩 spit문자열배열에 넣음
		
		Stack<String> stack = new Stack<String>();//스택생성
		
		for(int i = str.length()-1; i>=0; i--){
			stack.push(splitStr[i]);//스택에다가 문자열 넣음
		}
	   boolean bool = stack.empty();
		while(stack.empty()==false){ // 스택이 비워질때까지, 스택에 있는 값에 따라 체크값 +,-
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
