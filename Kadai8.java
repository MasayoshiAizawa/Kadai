import java.util.Scanner;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Kadai8 {
	public static void main(String args[]){
		//値の設定
		int toAmin = 0;//自宅からA駅までのかかる時間
		int toBmin = 0;//電車に乗っている時間
		int toOfficemin = 0;//駅から会社までの時間
		int officehour = 8;//会社の始業時刻(時)
		int officemin = 59;//会社の始業時刻(分)
		Calendar officetime = Calendar.getInstance();//始業時間のインスタンス
		Calendar traintime = Calendar.getInstance();//電車乗車時間のインスタンス
		Calendar gotime = Calendar.getInstance();//出発時刻のインスタンス
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");//時刻表示の設定
		
		officetime.set(2020,9,2,officehour,officemin);//始業時刻を設定
		
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
		}
		
		//スキャナーをクローズ
		sc.close();
		
		//乗車時刻の比較と出発時刻の入力
		for(int i = 0;i < stationNumber;i++){
			traintime.set(2020,9,2,trainhourArray[i],trainminArray[i] + toBmin + toOfficemin);
			if(officetime.after(traintime)){
				gotime.set(2020,9,2,trainhourArray[i],trainminArray[i] - toAmin);
				continue;
			}else{
				break;
			}
		}
		
		//出発時刻を表示
		System.out.println(sdf.format(gotime.getTime()));
	}
}