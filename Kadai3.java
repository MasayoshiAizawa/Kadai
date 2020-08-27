import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Comparator;

public class Kadai3 {
 	public static void main(String args[]) {
		
		//�l�̐ݒ�
		int holidayNumber = 0;//�x���̓���
		int travelNumber = 0;//���s�̓���
		int rainyPercentNumber = 0;//�~���m��
		List<Double> numberList = new ArrayList<Double>();//�~���m���̕��ϒl�����[����List�̍쐬
		
		Scanner sc = new Scanner(System.in);
		
		//�x���̓����Ɨ��s�����̐ݒ�
		String t = sc.nextLine();//�x���̓����Ɨ��s�����̓���
		String holidaytravelArray[] = t.split(" ");
		holidayNumber = Integer.parseInt(holidaytravelArray[0]);
		travelNumber = Integer.parseInt(holidaytravelArray[1]);
		
		int rainArray[] = new int[holidayNumber];
		int travelArray[] = new int[holidayNumber];
		
		//���s�̓����ƍ~���m���̐ݒ�
		for(int i = 0;i < holidayNumber;i++){
			String st = sc.nextLine();
			String travelrainArray[] = st.split(" ");
			travelArray[i] = Integer.parseInt(travelrainArray[0]);
			rainArray[i] = Integer.parseInt(travelrainArray[1]);
		}
		
		sc.close();
		
		//�~���m���̕��ϒl�̌v�Z��List�ɒǉ�
		int sum = 0;
		for(int j = 0;j <= (holidayNumber - travelNumber);j++){
			for(int w = 0;w < travelNumber;w++){
				rainArray[j] += rainArray[j+w];
			}
			double ave = rainArray[j]/travelNumber;
			numberList.add(ave);
		}
		
		//���ϒl�̍ŏ��l
		double minAve = numberList.stream().min(Comparator.naturalOrder()).getAsDouble();
		int indextravel = numberList.IndexOf(minAve);
		println(travelArray[indextravel] + " " + travelArray[indextravel + holidayNumber - 1]);
	}
}