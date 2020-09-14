import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.xml.bind.JAXB;

public class Kadai12 {

	public static void main(String[] args) {
		//�t�@�C���̓ǂݍ���

		Receipt xml1 = (Receipt) JAXB.unmarshal("C:\\Code\\test_001.xml",Receipt.class);
		Receipt xml2 = (Receipt) JAXB.unmarshal("C:\\Code\\test_002.xml",Receipt.class);
		Receipt xml3 = (Receipt) JAXB.unmarshal("C:\\Code\\test_003.xml",Receipt.class);
		
		//�v�Z����List�̐ݒ�
		List<Items> xmlitemlist = new ArrayList<>();//Items�N���X�̃��X�g�̍쐬
		xmlitemlist = xml1.getItems();
		//���̃t�@�C���̃f�[�^�����List�Ɏ��[
		List<Items> xml2itemlist = new ArrayList<>();//Items�N���X�̃��X�g�̍쐬
		xml2itemlist = xml2.getItems();
		for (int i = 0; i < xml2itemlist.size(); i++) {//xmlitemlis�ɒǉ�
			xmlitemlist.add(xml2itemlist.get(i));
		}
		List<Items> xml3itemlist = new ArrayList<>();//Items�N���X�̃��X�g�̍쐬
		xml3itemlist = xml3.getItems();
		for (int i = 0; i < xml3itemlist.size(); i++) {//xmlitemlist�ɒǉ�
			xmlitemlist.add(xml3itemlist.get(i));
		}
		
		Map<String,String> idnamemap = new TreeMap<String,String>();//���iID�Ə��i���̃}�b�v
		Map<String,Integer> idcountmap = new TreeMap<String,Integer>();//���iID�Ə��i���̃}�b�v
		List<String> idlist = new ArrayList<>();//���iID�ꗗ�̂��߂̃��X�g

		int sum = 0;//���i���v���z

		for(Items items : xmlitemlist){
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
		
		//�l�̕\��
		System.out.println("���v���z : " + sum);
	}
}