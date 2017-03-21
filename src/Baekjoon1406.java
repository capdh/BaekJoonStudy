import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon1406 {
	public static void main(String[] args) throws Exception{
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		String str = sc.readLine();
		
		int strLength = str.length(); // 문자열 길이
		int cursor = str.length(); // 커서
		
		int number = Integer.parseInt(sc.readLine());
	
		
		for(int i = 0; i<number; i++){
			String input = sc.readLine();
			char[] inputArray = input.toCharArray();
			
			switch(inputArray[0]){
			case 'L' :
				if(cursor>0){
					cursor--;
				}
				break;
			case 'D' :
				if(cursor<strLength){
					cursor++;
				}
				break;
				
			case 'B' :
				if(cursor == strLength){ //커서가 맨 끝에 있는 경우
					str = str.substring(0, strLength-1);
					cursor--;
					strLength--;
				}
				else if(cursor>0){
					String tempStr1 = str.substring(0,cursor-1);
					String tempStr2 = str.substring(cursor,strLength);
					str = tempStr1.concat(tempStr2);
					cursor--;
					strLength--;
					
				}
				break;
				
			case 'P' :
				String tempStr1 = str.substring(0, cursor);
				String tempStr2 = str.substring(cursor, strLength);
				str = tempStr1.concat(Character.toString(inputArray[2])).concat(tempStr2);
				cursor++;
				strLength ++;
				break;
			
			}

		}
		System.out.println(str);
	}

}

