import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="item")
public class Item {
	
	@XmlElement(name="itemid")
	static String itemid;
	
	@XmlElement(name="itemname")
	static String itemname;
	
	@XmlElement(name="price")
	static int price;
	
	public String getId() {
		return itemid;
	}
	public String getName() {
		return itemname;
	}
	public int getPrice() {
		return price;
	}
}