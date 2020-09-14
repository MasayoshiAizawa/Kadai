import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import javax.xml.bind.JAXB;

public class Kadai11 {

	public static void main(String[] args) {
		//ファイルの読み込み

		Receipt receipt = (Receipt) JAXB.unmarshal("C:\\Code\\test.xml",Receipt.class);

		List<Items> itemlist = new ArrayList<>();//Itemsクラスのリストの作成
		itemlist = receipt.getItems();

		Map<String,String> idnamemap = new TreeMap<String,String>();//商品IDと商品名のマップ
		Map<String,Integer> idcountmap = new TreeMap<String,Integer>();//商品IDと商品個数のマップ
		List<String> idlist = new ArrayList<>();//商品ID一覧のためのリスト

		int sum = 0;//商品合計金額

		for(Items items : itemlist){
			for(Item i : items.getItem()){//Itemクラスのリストの拡張for文
				if(idlist.contains(i.getId())){
					idnamemap.put(i.getId(),i.getName());
					idcountmap.put(i.getId(),idcountmap.get(i.getId()) + 1);
					sum += i.getPrice();
				}else{
					idlist.add(i.getId());
					idnamemap.put(i.getId(),i.getName());
					idcountmap.put(i.getId(),1);
					sum += i.getPrice();
				}
			}
		}

		for(String s : idlist){
			System.out.println("商品名 : " + idnamemap.get(s) + "  購入個数 : " + idcountmap.get(s));
		}

		//時刻の設定
		String time = receipt.getTime();//purchasetimeの読み込み
		Calendar calendar = Calendar.getInstance();
		calendar.set(Integer.parseInt(time.substring(0,4)),Integer.parseInt(time.substring(4,6)),Integer.parseInt(time.substring(6,8)),Integer.parseInt(time.substring(8,10)),Integer.parseInt(time.substring(10,12)),Integer.parseInt(time.substring(12,14)));;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH時mm分ss秒");
		
		//値の表示
		System.out.println(sdf.format(calendar.getTime()));
		System.out.println("合計金額 : " + sum);
	}
}