import java.util.Scanner;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Kadai7 {
	public static void main(String args[]){
		//�l�̐ݒ�
		int countryNumber = 0;//���͂��鍑��
		List<String> countryList = new ArrayList<String>();//�����̌v�Z�p�̍������C������List
		Map<String, Integer> countryTimeMap = new LinkedHashMap<String, Integer>();//�����Ǝ�����Map
		Calendar call = Calendar.getInstance();//�����̃C���X�^���X����
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");//�����\���̐ݒ�
		
		Scanner sc = new Scanner(System.in);
		
		countryNumber = Integer.parseInt(sc.nextLine());//������l�����
		
		//�l�̓���
		for(int i = 0;i < countryNumber;i++){
			String s = sc.nextLine();
			String countrynumberArray[] = s.split(" ");
			countryList.add(countrynumberArray[0]);//List�ɍ��������
			countryTimeMap.put(countrynumberArray[0],Integer.parseInt(countrynumberArray[1]));//�v�Z�pMap�ɍ����A���������
		}
		String st = sc.nextLine();//���e���Ԃ̓���
		String inputcountryArray[] = st.split(" ");
		String inputcountry = inputcountryArray[0];//���͂��ꂽ����
		String inputnumberArray[] = inputcountryArray[1].split(":");//���͂��ꂽ����
		
		//�X�L���i�[���N���[�Y
		sc.close();
		
		//�����Ɛ��E�W�������̌v�Z�ƕ\��
		for(int i = 0;i < countryNumber;i++) {
			call.set(2020,9,2,Integer.parseInt(inputnumberArray[0]),Integer.parseInt(inputnumberArray[1]));
			call.add(Calendar.HOUR_OF_DAY, countryTimeMap.get(countryList.get(i))-countryTimeMap.get(inputcountry));
			System.out.println(countryList.get(i) + " " + sdf.format(call.getTime()));
		}
	}
}