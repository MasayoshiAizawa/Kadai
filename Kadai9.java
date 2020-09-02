import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import java.util.LinkedHashMap;
import java.util.Map;

public class Kadai9 extends Change{
	public static void main(String args[]){
		//値の設定
		int firstNumber = 0;//最初の入力値
		int secondNumber = 0;//二つ目の入力値
		int sum = 0;//上記の値の合計
		Map<Integer, String> numberMap = new LinkedHashMap<Integer, String>();//計算用の値と文字のMap
		List<String> firstList = new ArrayList<String>();//文字を収納するList
		List<String> secondList = new ArrayList<String>();//文字を収納するList
		
		Scanner sc = new Scanner(System.in);
		
		//値の入力
		String s = sc.nextLine();//二つの文字を入力
		
		sc.close();//スキャナーをクローズ
		
		String Array[] = s.split(" ");
		String firstArray[] = Array[0].split("");//一つ目の文字列を一文字ごとに収納
		String secondArray[] = Array[1].split("");//二つ目の文字列を一文字ごとに収納
		firstList = Arrays.asList(firstArray);
		Collections.reverse(firstList);//収納した文字を逆順にする
		secondList = Arrays.asList(secondArray);
		Collections.reverse(secondList);//収納した文字を逆順にする
		
		//最初に入力した文字列を10進法に変換
		for(int i = 0;i < firstArray.length;i++){
			numberMap.put(i,firstList.get(i));//key(ループ値)、値(入力した文字)でMapに収納
			//文字を判別
			if(numberMap.get(i).equals("A")){
				firstNumber += 0;
			}else if(numberMap.get(i).equals("B")){
				firstNumber += 1*Math.pow(5,i);
			}else if(numberMap.get(i).equals("C")){
				firstNumber += 2*Math.pow(5,i);
			}else if(numberMap.get(i).equals("D")){
				firstNumber += 3*Math.pow(5,i);
			}else if(numberMap.get(i).equals("E")){
				firstNumber += 4*Math.pow(5,i);
			}
			numberMap.clear();//以後の計算でキーがかぶるので消去
		}
		
		//上記と同様に二つ目に入力した文字列を10進法に変換
		for(int i = 0;i < secondArray.length;i++){
			numberMap.put(i,secondList.get(i));
			if(numberMap.get(i).equals("A")){
				secondNumber += 0;
			}else if(numberMap.get(i).equals("B")){
				secondNumber += 1*Math.pow(5,i);
			}else if(numberMap.get(i).equals("C")){
				secondNumber += 2*Math.pow(5,i);
			}else if(numberMap.get(i).equals("D")){
				secondNumber += 3*Math.pow(5,i);
			}else if(numberMap.get(i).equals("E")){
				secondNumber += 4*Math.pow(5,i);
			}
		}
		
		sum = firstNumber + secondNumber;//10進法で出力する値を計算
		
		//求めた合計を5進数に変換
		String sumString = Integer.toString(sum,5);
		
		//5進数で変換したものをそれぞれ対応する文字に変換
		String splitArray[] = sumString.split("");
		for(String st : splitArray){
			st = Change.change(st);//文字に変換
			System.out.print(st);
		}
	}
}
class Change{
	public static String change(String s) {
	//文字の置換
		if(s.equals("0")){//条件に一致するか判別
			s = s.replace("0","A");
		}else if(s.equals("1")){
			s = s.replace("1","B");
		}else if(s.equals("2")){
			s = s.replace("2","C");
		}else if(s.equals("3")){
			s = s.replace("3","D");
		}else if(s.equals("4")){
			s = s.replace("4","E");
		}
		return s;
	}
}