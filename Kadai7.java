import java.util.Scanner;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Kadai7 {
	public static void main(String args[]){
		//値の設定
		int countryNumber = 0;//入力する国数
		List<String> countryList = new ArrayList<String>();//時差の計算用の国名を修得するList
		Map<String, Integer> countryTimeMap = new LinkedHashMap<String, Integer>();//国名と時差のMap
		Calendar call = Calendar.getInstance();//時刻のインスタンス生成
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");//時刻表示の設定
		
		Scanner sc = new Scanner(System.in);
		
		countryNumber = Integer.parseInt(sc.nextLine());//国数を値を入力
		
		//値の入力
		for(int i = 0;i < countryNumber;i++){
			String s = sc.nextLine();
			String countrynumberArray[] = s.split(" ");
			countryList.add(countrynumberArray[0]);//Listに国名を入力
			countryTimeMap.put(countrynumberArray[0],Integer.parseInt(countrynumberArray[1]));//計算用Mapに国名、時差を入力
		}
		String st = sc.nextLine();//投稿時間の入力
		String inputcountryArray[] = st.split(" ");
		String inputcountry = inputcountryArray[0];//入力された国名
		String inputnumberArray[] = inputcountryArray[1].split(":");//入力された時刻
		
		//スキャナーをクローズ
		sc.close();
		
		//時差と世界標準時刻の計算と表示
		for(int i = 0;i < countryNumber;i++) {
			call.set(2020,9,2,Integer.parseInt(inputnumberArray[0]),Integer.parseInt(inputnumberArray[1]));
			call.add(Calendar.HOUR_OF_DAY, countryTimeMap.get(countryList.get(i))-countryTimeMap.get(inputcountry));
			System.out.println(countryList.get(i) + " " + sdf.format(call.getTime()));
		}
	}
}