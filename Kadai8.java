import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.Optional;
import java.util.Comparator;

public class Kadai8 {
	public static void main(String args[]){
		//�l�̐ݒ�
		int toAmin = 0;//�����A�w�܂ł̂����鎞��
		int toBmin = 0;//�d�Ԃɏ���Ă��鎞��
		int toOfficemin = 0;//�w�����Ђ܂ł̎���
		int officehour = 8;//��Ђ̎n�Ǝ���(��)
		int officemin = 59;//��Ђ̎n�Ǝ���(��)
		int gomin = 0;//�o������(��)
		int gohour = 0;//�o������(��)
		String gominString;//�o�͗p�o������(��)
		String gohourString;//�o�͗p�o������(��)
		List<Integer> numberList = new ArrayList<Integer>();//��ԓd�Ԕ�r�pList
		
		Scanner sc = new Scanner(System.in);
		
		//���Ԃ̓���
		String s = sc.nextLine();
		String minArray[] = s.split(" ");
		toAmin = Integer.parseInt(minArray[0]);
		toBmin = Integer.parseInt(minArray[1]);
		toOfficemin = Integer.parseInt(minArray[2]);
		
		int stationNumber = Integer.parseInt(sc.nextLine());//���͂���w�̐��̓���
		int trainhourArray[] = new int[stationNumber];//��Ԏ���(��)�ɑΉ�����z��̐���
		int trainminArray[] = new int[stationNumber];//��Ԏ���(��)�ɑΉ�����z��̐���
		
		//��ԉw���炩���鎞�Ԃ̓���
		for(int i = 0;i < stationNumber;i++){
			String st = sc.nextLine();//��Ԏ��Ԃ̓���
			String numberArray[] = st.split(" ");
			//��Ԏ�����z��ɓ���
			trainhourArray[i] = Integer.parseInt(numberArray[0]);
			trainminArray[i] = Integer.parseInt(numberArray[1]);
			//��Ԏ�������n�Ǝ����܂łɂ����鎞��(��)��List�ɓ���
			numberList.add(officehour*60 + officemin - toBmin - toOfficemin - trainhourArray[i]*60 - trainminArray[i]);
		}
		
		//�X�L���i�[���N���[�Y
		sc.close();
		
		//�����鎞�Ԃ̍ŏ��l���v�Z
		int min = numberList.stream().filter(e -> e > 0).min(Comparator.naturalOrder()).get();
		int indexnumber = numberList.indexOf(min);//�ŏ��l�̃C���f�b�N�X�ԍ����o��
		
		//�o�������ɓ���
		gomin = trainminArray[indexnumber] - toAmin;
		gohour = trainhourArray[indexnumber];
		
		//�o�������𐳊m�Ȏ����ɐ���
		if(gomin < 0){
			gomin += 60;
			gohour -= 1;
		}
		
		//�o�͒l��񌅂ɐ���
		if(gomin < 10){
			gominString = 0 + Integer.toString(gomin);
		}else{
			gominString = Integer.toString(gomin);
		}
		if(gohour < 10){
			gohourString = 0 + Integer.toString(gohour);
		}else{
			gohourString = Integer.toString(gohour);
		}
		
		//�o��������\��
		System.out.println(gohourString + ":" + gominString);
	}
}