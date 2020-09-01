import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.List;
import java.util.ArrayList;

public class Kadai7 {
	public static void main(String args[]){
		//�l�̐ݒ�
		int countryNumber = 0;//���͂��鍑��
		List<String> countryList = new ArrayList<String>();//�����̌v�Z�p�̍������C������List
		Map<String, Integer> countryTimeMap = new HashMap<String, Integer>();//�v�Z�p�̍����Ǝ�����Map
		Map<String, String> countryTimesubMap = new HashMap<String,String>();//�\���p�̍����Ǝ�����Map
		int time = 0;//���E������̒l
		
		Scanner sc = new Scanner(System.in);
		
		countryNumber = Integer.parseInt(sc.nextLine());//������l�����
		
		//�l�̓���
		for(int i = 0;i < countryNumber;i++){
			String s = sc.nextLine();
			String countrynumberArray[] = s.split(" ");
			countryList.add(countrynumberArray[0]);//List�ɍ��������
			countryTimeMap.put(countrynumberArray[0],Integer.parseInt(countrynumberArray[1]));//�v�Z�pMap�ɍ����A���������
		}
		String st = sc.nextLine();
		String inputcountryArray[] = st.split(" ");
		String inputcountry = inputcountryArray[0];//���͂��ꂽ����
		String inputnumberArray[] = inputcountryArray[1].split(":");//���͂��ꂽ����
		
		//�X�L���i�[���N���[�Y
		sc.close();
		
		time = Integer.parseInt(inputnumberArray[0]) - countryTimeMap.get(inputcountry);//���E�W�������̌v�Z
		
		//�����Ɛ��E�W�������̌v�Z�ƕ\���pMap�ւ̓���
		for(String s : countryList) {
			int countrytime = time + countryTimeMap.get(s);
			//24�ȏ�̎��������f
			if(countrytime < 0){
				countrytime += 24;
			}
			else if(countrytime > 24){
				countrytime -= 24;
			}
			//10�����̎��������f
			if(countrytime < 10){
				countryTimesubMap.put(s,0 + Integer.toString(countrytime));
			}
			else{
				countryTimesubMap.put(s,Integer.toString(countrytime));
			}
		}
		//�����Ǝ�����\��
		for(Map.Entry<String,String>entry : countryTimesubMap.entrySet()){
			System.out.println(entry.getKey() + " "+ entry.getValue() + ":" + inputnumberArray[1]);
		}
	}
}