import java.util.Scanner;

public class Kadai6 extends Lee{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		//������̓���
		String str = sc.nextLine();
		
		sc.close();
		
		//��������ꕶ�����Ƃɕ���
		String splitArray[] = str.split("");
		
		//�ꕶ�����Ƃ�Lee�ϊ������o�͂���
		for(String s : splitArray){
			s = Lee.leechange(s);
			System.out.print(s);
		}
	}
}
class Lee{
	public static String leechange(String s) {
	//�����̒u��
		if(s.equals("A")){//�����Ɉ�v���邩����
			s = s.replace("A","4");//Lee�ϊ����s��
		}
		if(s.equals("E")){
			s = s.replace("E","3");
		}
		if(s.equals("G")){
			s = s.replace("G","6");
		}
		if(s.equals("I")){
			s = s.replace("I","1");
		}
		if(s.equals("O")){
			s = s.replace("O","0");
		}
		if(s.equals("S")){
			s = s.replace("S","5");
		}
		if(s.equals("Z")){
			s = s.replace("Z","2");
		}
		return s;
	}
}