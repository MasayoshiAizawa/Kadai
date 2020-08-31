import java.util.Scanner;

public class Kadai6 extends Leet{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		//文字列の入力
		String str = sc.nextLine();
		
		sc.close();
		
		//文字列を一文字ごとに分割
		String splitArray[] = str.split("");
		
		//一文字ごとにLeet変換をし出力する
		for(String s : splitArray){
			s = Leet.leetchange(s);
			System.out.print(s);
		}
	}
}
class Leet{
	public static String leetchange(String s) {
	//文字の置換
		if(s.equals("A")){//条件に一致するか判別
			s = s.replace("A","4");//Leet変換を行う
		}
		else if(s.equals("E")){
			s = s.replace("E","3");
		}
		else if(s.equals("G")){
			s = s.replace("G","6");
		}
		else if(s.equals("I")){
			s = s.replace("I","1");
		}
		else if(s.equals("O")){
			s = s.replace("O","0");
		}
		else if(s.equals("S")){
			s = s.replace("S","5");
		}
		else if(s.equals("Z")){
			s = s.replace("Z","2");
		}
		return s;
	}
}
