import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import java.util.TreeMap;
import java.util.Map;


public class Kadai10 {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		//基準点の値の設定・入力		
		String s = sc.nextLine();//基準点のx、y座標の入力
		String Array[] = s.split(" ");//
		int x = Integer.parseInt(Array[0]);//基準点のx座標
		int y = Integer.parseInt(Array[1]);//基準点のy座標
		int k = Integer.parseInt(sc.nextLine());//計測数
		int N = Integer.parseInt(sc.nextLine());//地価の数
		
		int numberArray[] = new int[N];//入力した地価を収納する配列

		ArrayList<List<Integer>> numberlist = new ArrayList<>();//入力したx、y座標を収納する二次元List
		Map<Double,Integer> ranking = new TreeMap<Double,Integer>();//基準点からの距離の昇順で地価を収納するMap
		
		//観測点の値の入力
		for(int i = 0;i < N;i++){
			String st = sc.nextLine();//x、y座標の入力
			String posArray[] = st.split(" ");
			List<Integer> numbersublist = new ArrayList<Integer>();//numberlistを二次元配列を収納するためのList
			numbersublist.add(Integer.parseInt(posArray[0]));//入力されたx座標
			numbersublist.add(Integer.parseInt(posArray[1]));//入力されたy座標
			numberlist.add(numbersublist);
			numberArray[i] = Integer.parseInt(posArray[2]);//入力された地価
		}
		
		//観測点と基準点の距離を昇順で収納
		for(int i = 0;i < N;i++){
			double dist = Math.sqrt(Math.pow(numberlist.get(i).get(0) - x,2) + Math.pow(numberlist.get(i).get(1) - y,2));
			ranking.put(dist,numberArray[i]);
		};
		
		//昇順の距離をMapのkeyとするvalueの地価の取り出し
		List<Integer> sqrlist = new ArrayList<>(ranking.values());
		
		//観測数から計測数ぶんの平均値を算出
		int sum = 0;
		for(int i = 0;i < k;i++){
			sum += sqrlist.get(i);
		}
		
		//求める平均値を表示
		System.out.println(Math.round(sum/k));
	}
}
		