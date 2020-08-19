import java.util.*;

public class kadai1 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		//社員の名前とそれに対応する購入数の配列の作成
		int N = Integer.parseInt(sc.nextLine()); //社員人数の入力
		String s = sc.nextLine();//社員の名前を入力
		String array1[] =  s.split(" "); //社員の名前を配列に入力
		int array2[] = new int[N-1]; //社員人数と同じ数の整数配列
		int Num = Integer.parseInt(sc.nextLine()); //社員が購入した本の数を入力

		//それぞれの社員の本購入数の合計を計算
		for(int j =0;j < Num;j++){
			String t = sc.nextLine();//社員と購入数の入力
			String array3[] = t.split(" ");
			int num = Integer.parseInt(array3[1]);
			for(int i = 0;i < N;i++){
				if(array3[0] == array1[i]){ //購入した社員の名前を検索
					array2[i] += num; //対応する社員の合計本購入数に追加
				}
			}
		}

		//社員を購入数の昇順に並び替える
		for(int i =0;i < N;i++){
			for(int j =i + 1;j < N;j++){
				if(array2[i] < array2[j]){
					int w = array2[i];
					array2[i] = array2[j];
					array2[j] = w;
					String st = array1[i];
					array1[i] = array1[j];
					array1[j] = st;
				}
			}
		}

		//社員を購入数の昇順で表示
		for(String str : array1){
			System.out.println(str);
		}
		System.out.println();

		//Scannerクラスのインスタンスをクローズ
		sc.close();
	}
}
