import java.io.BufferedReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Baekjoon11718{
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
	
		String str;
		String[] strSplit;
		int result=0;
		
		//몇개의 숫자를 입력받을 건지
		int count = sc.nextInt();
		sc.nextLine();
		
		
			str=sc.nextLine();
			strSplit = str.split("");
			
			//
			int[] numbers = new int[count];
			
			for(int j=0; j<count; j++){
				numbers[j]=Integer.parseInt(strSplit[j]);
			}
			
			for(int z=0; z<strSplit.length; z++){
				result+=numbers[z];
			}
			System.out.println(result);

		
	}
}