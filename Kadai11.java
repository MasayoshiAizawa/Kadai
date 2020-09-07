import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;
import javax.xml.bind.JAXB;
import javax.xml.bind.*;
import java.util.TreeMap;
import java.util.Map;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

class Receipt extends Items{
	static List<Items> items;
	
	public List<Items> getItems() {
		return items;
	}
	public void setItems(List<Items> items) {
		this.items = items;
	}
}

class Items extends Item{
	
	static List<Item> item;
	
	public List<Item> getItem() {
		return item;
	}
	public void setItem(List<Item> item) {
		this.item = item;
	}
}

class Item {
	static String itemid;
	static String itemname;
	static int price;

	public String getidName() {
		return itemid;
	}
	public void setidName(String itemid) {
		this.itemid = itemid;
	}
	
	public String getName() {
		return itemname;
	}
	public void setName(String itemname) {
		this.itemname = itemname;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}

public class Kadai11 extends Receipt{

	public static void main(String[] args) {
		// アンマーシャル
		Receipt r = JAXB.unmarshal(new File("test.xml"),Receipt.class);
		
		Map<String,String> idnamemap = new TreeMap<String,String>();
		Map<String,Integer> idcountmap = new TreeMap<String,Integer>();
		List<String> idlist = new ArrayList<>();
		
		int sum = 0;
		
		for(Item e : item){
			if(idlist.contains(itemid)){
				idnamemap.put(e.itemid,e.itemname);
				idcountmap.put(e.itemid,idcountmap.get(e.itemid) + 1);
				sum += e.price;
			}else{
				idlist.add(e.itemid);
				idnamemap.put(e.itemid,e.itemname);
				idcountmap.put(e.itemid,1);
				sum += e.price;
			}
		}
		for(String s : idlist){
			System.out.println("商品名 : " + idnamemap.get(s) + "  購入個数 : " + idcountmap.get(s));
		}
		System.out.println("合計金額 : " + sum);
	}
}