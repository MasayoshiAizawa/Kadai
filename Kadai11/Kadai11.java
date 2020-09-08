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

public class Kadai11 {

	public static void main(String[] args) {
		// アンマーシャル
		List <Receipt> receiptlist = Xmlpath.Xmllist("test.xml",Receipt.class);
		
		Map<String,String> idnamemap = new TreeMap<String,String>();
		Map<String,Integer> idcountmap = new TreeMap<String,Integer>();
		List<String> idlist = new ArrayList<>();
		
		int sum = 0;
		
		for(Receipt r : receiptlist){
			for(Item i : r.getItems())
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
		for(String s : idlist){
			System.out.println("商品名 : " + idnamemap.get(s) + "  購入個数 : " + idcountmap.get(s));
		}
		System.out.println("合計金額 : " + sum);
	}
}