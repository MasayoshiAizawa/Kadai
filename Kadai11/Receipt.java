import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="reciept")
public class Receipt {


	private List<Items> items;
	@XmlElement(name="items")
	public List<Items> getItems() {
		return items;
	}

	public void setItems(List<Items> items){
		this.items = items;
	}

	private String time;

	@XmlElement(name="purchasetime")
	public String getTime() {
	return time;
	}

	public void setTime(String time){
		this.time = time;
	}
}