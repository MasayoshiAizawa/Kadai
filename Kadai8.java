import java.util.Scanner;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Kadai8 {
	public static void main(String args[]){
		//�l�̐ݒ�
		int toAmin = 0;//�����A�w�܂ł̂����鎞��
		int toBmin = 0;//�d�Ԃɏ���Ă��鎞��
		int toOfficemin = 0;//�w�����Ђ܂ł̎���
		int officehour = 8;//��Ђ̎n�Ǝ���(��)
		int officemin = 59;//��Ђ̎n�Ǝ���(��)
		Calendar officetime = Calendar.getInstance();//�n�Ǝ��Ԃ̃C���X�^���X
		Calendar traintime = Calendar.getInstance();//�d�ԏ�Ԏ��Ԃ̃C���X�^���X
		Calendar gotime = Calendar.getInstance();//�o�������̃C���X�^���X
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");//�����\���̐ݒ�
		
		officetime.set(2020,9,2,officehour,officemin);//�n�Ǝ�����ݒ�
		
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
		}
		
		//�X�L���i�[���N���[�Y
		sc.close();
		
		//��Ԏ����̔�r�Əo�������̓���
		for(int i = 0;i < stationNumber;i++){
			traintime.set(2020,9,2,trainhourArray[i],trainminArray[i] + toBmin + toOfficemin);
			if(officetime.after(traintime)){
				gotime.set(2020,9,2,trainhourArray[i],trainminArray[i] - toAmin);
				continue;
			}else{
				break;
			}
		}
		
		//�o��������\��
		System.out.println(sdf.format(gotime.getTime()));
	}
}