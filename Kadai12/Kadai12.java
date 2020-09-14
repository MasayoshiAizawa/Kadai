import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.xml.bind.JAXB;

public class Kadai12 {

	public static void main(String[] args) {
		//ファイルの読み込み

		Receipt xml1 = (Receipt) JAXB.unmarshal("C:\\Code\\test_001.xml",Receipt.class);
		Receipt xml2 = (Receipt) JAXB.unmarshal("C:\\Code\\test_002.xml",Receipt.class);
		Receipt xml3 = (Receipt) JAXB.unmarshal("C:\\Code\\test_003.xml",Receipt.class);
		
		//計算するListの設定
		List<Items> xmlitemlist = new ArrayList<>();//Itemsクラスのリストの作成
		xmlitemlist = xml1.getItems();
		//他のファイルのデータを一つのListに収納
		List<Items> xml2itemlist = new ArrayList<>();//Itemsクラスのリストの作成
		xml2itemlist = xml2.getItems();
		for (int i = 0; i < xml2itemlist.size(); i++) {//xmlitemlisに追加
			xmlitemlist.add(xml2itemlist.get(i));
		}
		List<Items> xml3itemlist = new ArrayList<>();//Itemsクラスのリストの作成
		xml3itemlist = xml3.getItems();
		for (int i = 0; i < xml3itemlist.size(); i++) {//xmlitemlistに追加
			xmlitemlist.add(xml3itemlist.get(i));
		}
		
		Map<String,String> idnamemap = new TreeMap<String,String>();//商品IDと商品名のマップ
		Map<String,Integer> idcountmap = new TreeMap<String,Integer>();//商品IDと商品個数のマップ
		List<String> idlist = new ArrayList<>();//商品ID一覧のためのリスト

		int sum = 0;//商品合計金額

		for(Items items : xmlitemlist){
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
		
		//値の表示
		System.out.println("合計金額 : " + sum);
	}
}