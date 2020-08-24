import java.util.*;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class Kadai2 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		String butNumber = sc.nextLine();//嫌いな数字の入力
		int roomNumber = Integer.parseInt(sc.nextLine());//病室の総数の入力
		List<String> roomList new ArrayList<String>();//病室のListの作成

		for(int i = 0;i < roomNumber;i++){
			room.List.add(sc.nextLine());//上記のListに部屋番号を入力
		}
		
		sc.close();
		
		List<String> roomListsub = roomList.stream()
		.filter(num -> num.indexOf(butNumber) < 0)//部屋番号から嫌いな数字を取り除く
		.collect(Collectors.toList());//filterをしたものを再List化

		roomListsub.stream().forEach(System.out::println);//条件に一致する部屋番号の表示

		if(roomListsub.isEmpty()){//すべての部屋番号が条件に一致しない場合の出力
				System.out.println("none");
		}
	}
}
