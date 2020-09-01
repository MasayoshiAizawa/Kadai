import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.Optional;
import java.util.Comparator;

public class Kadai8 {
	public static void main(String args[]){
		//値の設定
		int toAmin = 0;//自宅からA駅までのかかる時間
		int toBmin = 0;//電車に乗っている時間
		int toOfficemin = 0;//駅から会社までの時間
		int officehour = 8;//会社の始業時刻(時)
		int officemin = 59;//会社の始業時刻(分)
		int gomin = 0;//出発時刻(分)
		int gohour = 0;//出発時刻(時)
		String gominString;//出力用出発時刻(分)
		String gohourString;//出力用出発時刻(時)
		List<Integer> numberList = new ArrayList<Integer>();//乗車電車比較用List
		
		Scanner sc = new Scanner(System.in);
		
		//時間の入力
		String s = sc.nextLine();
		String minArray[] = s.split(" ");
		toAmin = Integer.parseInt(minArray[0]);
		toBmin = Integer.parseInt(minArray[1]);
		toOfficemin = Integer.parseInt(minArray[2]);
		
		int stationNumber = Integer.parseInt(sc.nextLine());//入力する駅の数の入力
		int trainhourArray[] = new int[stationNumber];//乗車時刻(時)に対応する配列の生成
		int trainminArray[] = new int[stationNumber];//乗車時刻(分)に対応する配列の生成
		
		//乗車駅からかかる時間の入力
		for(int i = 0;i < stationNumber;i++){
			String st = sc.nextLine();//乗車時間の入力
			String numberArray[] = st.split(" ");
			//乗車時刻を配列に入力
			trainhourArray[i] = Integer.parseInt(numberArray[0]);
			trainminArray[i] = Integer.parseInt(numberArray[1]);
			//乗車時刻から始業時刻までにかかる時間(分)をListに入力
			numberList.add(officehour*60 + officemin - toBmin - toOfficemin - trainhourArray[i]*60 - trainminArray[i]);
		}
		
		//スキャナーをクローズ
		sc.close();
		
		//かかる時間の最小値を計算
		int min = numberList.stream().filter(e -> e > 0).min(Comparator.naturalOrder()).get();
		int indexnumber = numberList.indexOf(min);//最小値のインデックス番号を出力
		
		//出発時刻に入力
		gomin = trainminArray[indexnumber] - toAmin;
		gohour = trainhourArray[indexnumber];
		
		//出発時刻を正確な時刻に整理
		if(gomin < 0){
			gomin += 60;
			gohour -= 1;
		}
		
		//出力値を二桁に整理
		if(gomin < 10){
			gominString = 0 + Integer.toString(gomin);
		}else{
			gominString = Integer.toString(gomin);
		}
		if(gohour < 10){
			gohourString = 0 + Integer.toString(gohour);
		}else{
			gohourString = Integer.toString(gohour);
		}
		
		//出発時刻を表示
		System.out.println(gohourString + ":" + gominString);
	}
}