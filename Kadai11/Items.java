import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Items")
public class Items {

	private List<Item> item;

	@XmlElement(name="item")
	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item){
		this.item = item;
	}
}