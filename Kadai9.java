import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import java.util.LinkedHashMap;
import java.util.Map;

public class Kadai9 extends Change{
	public static void main(String args[]){
		//�l�̐ݒ�
		int firstNumber = 0;//�ŏ��̓��͒l
		int secondNumber = 0;//��ڂ̓��͒l
		int sum = 0;//��L�̒l�̍��v
		Map<Integer, String> numberMap = new LinkedHashMap<Integer, String>();//�v�Z�p�̒l�ƕ�����Map
		List<String> firstList = new ArrayList<String>();//���������[����List
		List<String> secondList = new ArrayList<String>();//���������[����List
		
		Scanner sc = new Scanner(System.in);
		
		//�l�̓���
		String s = sc.nextLine();//��̕��������
		
		sc.close();//�X�L���i�[���N���[�Y
		
		String Array[] = s.split(" ");
		String firstArray[] = Array[0].split("");//��ڂ̕�������ꕶ�����ƂɎ��[
		String secondArray[] = Array[1].split("");//��ڂ̕�������ꕶ�����ƂɎ��[
		firstList = Arrays.asList(firstArray);
		Collections.reverse(firstList);//���[�����������t���ɂ���
		secondList = Arrays.asList(secondArray);
		Collections.reverse(secondList);//���[�����������t���ɂ���
		
		//�ŏ��ɓ��͂����������10�i�@�ɕϊ�
		for(int i = 0;i < firstArray.length;i++){
			numberMap.put(i,firstList.get(i));//key(���[�v�l)�A�l(���͂�������)��Map�Ɏ��[
			//�����𔻕�
			if(numberMap.get(i).equals("A")){
				firstNumber += 0;
			}else if(numberMap.get(i).equals("B")){
				firstNumber += 1*Math.pow(5,i);
			}else if(numberMap.get(i).equals("C")){
				firstNumber += 2*Math.pow(5,i);
			}else if(numberMap.get(i).equals("D")){
				firstNumber += 3*Math.pow(5,i);
			}else if(numberMap.get(i).equals("E")){
				firstNumber += 4*Math.pow(5,i);
			}
			numberMap.clear();//�Ȍ�̌v�Z�ŃL�[�����Ԃ�̂ŏ���
		}
		
		//��L�Ɠ��l�ɓ�ڂɓ��͂����������10�i�@�ɕϊ�
		for(int i = 0;i < secondArray.length;i++){
			numberMap.put(i,secondList.get(i));
			if(numberMap.get(i).equals("A")){
				secondNumber += 0;
			}else if(numberMap.get(i).equals("B")){
				secondNumber += 1*Math.pow(5,i);
			}else if(numberMap.get(i).equals("C")){
				secondNumber += 2*Math.pow(5,i);
			}else if(numberMap.get(i).equals("D")){
				secondNumber += 3*Math.pow(5,i);
			}else if(numberMap.get(i).equals("E")){
				secondNumber += 4*Math.pow(5,i);
			}
		}
		
		sum = firstNumber + secondNumber;//10�i�@�ŏo�͂���l���v�Z
		
		//���߂����v��5�i���ɕϊ�
		String sumString = Integer.toString(sum,5);
		
		//5�i���ŕϊ��������̂����ꂼ��Ή����镶���ɕϊ�
		String splitArray[] = sumString.split("");
		for(String st : splitArray){
			st = Change.change(st);//�����ɕϊ�
			System.out.print(st);
		}
	}
}
class Change{
	public static String change(String s) {
	//�����̒u��
		if(s.equals("0")){//�����Ɉ�v���邩����
			s = s.replace("0","A");
		}else if(s.equals("1")){
			s = s.replace("1","B");
		}else if(s.equals("2")){
			s = s.replace("2","C");
		}else if(s.equals("3")){
			s = s.replace("3","D");
		}else if(s.equals("4")){
			s = s.replace("4","E");
		}
		return s;
	}
}