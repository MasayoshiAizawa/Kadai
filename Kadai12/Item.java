import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="item")
public class Item {

	private String itemid;

	@XmlElement(name="itemid")
	public String getId() {
		return itemid;
	}

	public void setId(String itemid){
		this.itemid = itemid;
	}

	private String itemname;

	@XmlElement(name="itemname")
	public String getName() {
		return itemname;
	}
	public void setName(String itemname){
		this.itemname = itemname;
	}

	private int price;

	@XmlElement(name="price")
	public int getPrice() {
		return price;
	}

	public void setPrice(int price){
		this.price = price;
	}
}