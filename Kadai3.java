import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Optional;
import java.util.Comparator;
import java.util.stream.*;
import java.util.*;

public class Kadai3 {
 	public static void main(String args[]) {
		
		//値の設定
		int holidayNumber = 0;//休日の日数
		int travelNumber = 0;//旅行の日程
		int rainyPercentNumber = 0;//降水確率
		List<Double> numberList = new ArrayList<Double>();//降水確率の平均値を収納するListの作成
		
		Scanner sc = new Scanner(System.in);
		
		//休日の日数と旅行日程の設定
		String t = sc.nextLine();//休日の日数と旅行日程の入力
		String holidaytravelArray[] = t.split(" ");
		holidayNumber = Integer.parseInt(holidaytravelArray[0]);
		travelNumber = Integer.parseInt(holidaytravelArray[1]);
		
		int rainArray[] = new int[holidayNumber];
		int travelArray[] = new int[holidayNumber];
		
		//旅行の日程と降水確率の設定
		for(int i = 0;i < holidayNumber;i++){
			String st = sc.nextLine();
			String travelrainArray[] = st.split(" ");
			travelArray[i] = Integer.parseInt(travelrainArray[0]);
			rainArray[i] = Integer.parseInt(travelrainArray[1]);
		}
		
		sc.close();
		
		//降水確率の平均値の計算とListに追加
		int sum = 0;
		for(int j = 0;j < holidayNumber - travelNumber +1;j++){
			for(int w = 1;w < travelNumber;w++){
				rainArray[j] += rainArray[j+w];
			}
			double ave = rainArray[j]/travelNumber;
			numberList.add(ave);
		}
		
		//平均値の最小値
		double minAve = numberList.stream().min(Comparator.naturalOrder()).get();
		int indextravel = numberList.IndexOf(minAve);
		System.out.println(travelArray[indextravel] + " " + travelArray[indextravel + travelNumber - 1]);
	}
}
