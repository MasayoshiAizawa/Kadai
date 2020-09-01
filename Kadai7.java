import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.List;
import java.util.ArrayList;

public class Kadai7 {
	public static void main(String args[]){
		//値の設定
		int countryNumber = 0;//入力する国数
		List<String> countryList = new ArrayList<String>();//時差の計算用の国名を修得するList
		Map<String, Integer> countryTimeMap = new HashMap<String, Integer>();//計算用の国名と時差のMap
		Map<String, String> countryTimesubMap = new HashMap<String,String>();//表示用の国名と時刻のMap
		int time = 0;//世界基準時刻の値
		
		Scanner sc = new Scanner(System.in);
		
		countryNumber = Integer.parseInt(sc.nextLine());//国数を値を入力
		
		//値の入力
		for(int i = 0;i < countryNumber;i++){
			String s = sc.nextLine();
			String countrynumberArray[] = s.split(" ");
			countryList.add(countrynumberArray[0]);//Listに国名を入力
			countryTimeMap.put(countrynumberArray[0],Integer.parseInt(countrynumberArray[1]));//計算用Mapに国名、時差を入力
		}
		String st = sc.nextLine();
		String inputcountryArray[] = st.split(" ");
		String inputcountry = inputcountryArray[0];//入力された国名
		String inputnumberArray[] = inputcountryArray[1].split(":");//入力された時刻
		
		//スキャナーをクローズ
		sc.close();
		
		time = Integer.parseInt(inputnumberArray[0]) - countryTimeMap.get(inputcountry);//世界標準時刻の計算
		
		//時差と世界標準時刻の計算と表示用Mapへの入力
		for(String s : countryList) {
			int countrytime = time + countryTimeMap.get(s);
			//24以上の時刻か判断
			if(countrytime < 0){
				countrytime += 24;
			}
			else if(countrytime > 24){
				countrytime -= 24;
			}
			//10未満の時刻か判断
			if(countrytime < 10){
				countryTimesubMap.put(s,0 + Integer.toString(countrytime));
			}
			else{
				countryTimesubMap.put(s,Integer.toString(countrytime));
			}
		}
		//国名と時刻を表示
		for(Map.Entry<String,String>entry : countryTimesubMap.entrySet()){
			System.out.println(entry.getKey() + " "+ entry.getValue() + ":" + inputnumberArray[1]);
		}
	}
}