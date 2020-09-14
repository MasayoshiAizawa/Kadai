import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import javax.xml.bind.JAXB;

public class Kadai11 {

	public static void main(String[] args) {
		//�t�@�C���̓ǂݍ���

		Receipt receipt = (Receipt) JAXB.unmarshal("C:\\Code\\test.xml",Receipt.class);

		List<Items> itemlist = new ArrayList<>();//Items�N���X�̃��X�g�̍쐬
		itemlist = receipt.getItems();

		Map<String,String> idnamemap = new TreeMap<String,String>();//���iID�Ə��i���̃}�b�v
		Map<String,Integer> idcountmap = new TreeMap<String,Integer>();//���iID�Ə��i���̃}�b�v
		List<String> idlist = new ArrayList<>();//���iID�ꗗ�̂��߂̃��X�g

		int sum = 0;//���i���v���z

		for(Items items : itemlist){
			for(Item i : items.getItem()){//Item�N���X�̃��X�g�̊g��for��
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
			System.out.println("���i�� : " + idnamemap.get(s) + "  �w���� : " + idcountmap.get(s));
		}

		//�����̐ݒ�
		String time = receipt.getTime();//purchasetime�̓ǂݍ���
		Calendar calendar = Calendar.getInstance();
		calendar.set(Integer.parseInt(time.substring(0,4)),Integer.parseInt(time.substring(4,6)),Integer.parseInt(time.substring(6,8)),Integer.parseInt(time.substring(8,10)),Integer.parseInt(time.substring(10,12)),Integer.parseInt(time.substring(12,14)));;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�NMM��dd��HH��mm��ss�b");
		
		//�l�̕\��
		System.out.println(sdf.format(calendar.getTime()));
		System.out.println("���v���z : " + sum);
	}
}