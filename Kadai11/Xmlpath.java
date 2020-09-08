import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXB;
import javax.xml.bind.Unmarshaller;

public class Xmlpath {

	public static <T> List<T> Xmllist(String path, Class<T> cls) {
		File file = new File(path);
		File[] files = file.listFiles();
		List<T> XmlList = new ArrayList<>();
		for (File f : files) {
			XmlList.add(readXml(file.getPath(), cls));
		}
		return XmlList;
	}
	public static <T> T readXml(String path, Class<T> cls) {
		T data = (T) JAXB.unmarshal(new File(path), cls);
		return data;
	}
}