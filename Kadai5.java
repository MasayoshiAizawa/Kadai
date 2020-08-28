import java.util.Scanner;

public class Kadai5 {
 	public static void main(String args[]) {
	
		//値の設定
		int receiptNumber = 0;//レシートの枚数
		int purchaseAmount = 0;//金額の合計
		int pointAmount = 0;//ポイントの合計
		int purchaseNumber = 0;//購入金額
		String dateString;//購入した日にち
		
		Scanner sc = new Scanner(System.in);
		
		String t = sc.nextLine();
		receiptNumber = Integer.parseInt(t);//レシートの数を入力
		
		for(int i = 0;i < receiptNumber;i++){
			String st = sc.nextLine();//購入した日にちと購入金額を入力
			String numberArray[] = st.split(" ");
			dateString = numberArray[0];
			purchaseNumber = Integer.parseInt(numberArray[1]);
			
			double point = 0;//購入金額からのポイント
			if(dayNumber.indexOf("3") > -1){//3のつく日にちか判別
				point = purchaseNumber/100*3;//3%のポイントに計算
			}
			if(dayNumber.indexOf("5") > -1){//5のつく日にちか判別
				point = purchaseNumber/100*5;//5%のポイントに計算
			}
			
			pointAmount += (int)point;//ポイントの小数点を切り捨ててポイント合計に追加
			
			purchaseAmount += purchaseNumber;//購入金額を合計金額に追加
		}
		
		sc.close();
		
		System.out.println(purchaseAmount + "円");
		System.out.println(pointAmount + "ポイント");
	}	
}		
