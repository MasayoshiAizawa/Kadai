import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="reciept")
public class Receipt {
	
	@XmlElementWrapper(name="items")
	@XmlElement(name="item")
	private List<Item> items;
	
	@XmlElement(name="purchasetime")
	private String time;
	
	public List<Item> getItems() {
		return items;
	}
	public String getTime() {
	return time;
	}
}