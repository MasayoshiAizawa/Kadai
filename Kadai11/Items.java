import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="items")
public class Items {
	
	@XmlElement(name="item")
	private List<Item> item;
	public List<Item> getItem() {
		return item;
	}
}