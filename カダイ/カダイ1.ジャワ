import java.util.*;

public class kadai1 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		//社員の名前とそれに対応する購入数の配列の作成
		int N = Integer.parseInt(sc.nextLine()); //社員人数の入力
		String s = sc.nextLine();//社員の名前を入力
		String arrayName[] =  s.split(" "); //社員の名前を配列に入力
		int arrayNumber[] = new int[N]; //社員人数と同じ数の整数配列
		int Num = Integer.parseInt(sc.nextLine()); //社員が購入した本の数を入力

		//それぞれの社員の本購入数の合計を計算
		for(int j =0;j < Num;j++){
			String t = sc.nextLine();//社員と購入数の入力
			String arrayNamesub[] = t.split(" ");
			int num = Integer.parseInt(arrayNamesub[1]);
			for(int i = 0;i < N;i++){
				if(arrayNamesub[0].equals(arrayName[i])){ //購入した社員の名前を検索
					arrayNumber[i] += num; //対応する社員の合計本購入数に追加
				}
			}
		}

		//社員を購入数の昇順に並び替える
		for(int i =0;i < N;i++){
			for(int j =i + 1;j < N;j++){
				if(arrayNumber[i] < arrayNumber[j]){
					int w = arrayNumber[i];
					arrayNumber[i] = arrayNumber[j];
					arrayNumber[j] = w;
					String st = arrayName[i];
					arrayName[i] = arrayName[j];
					arrayName[j] = st;
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
