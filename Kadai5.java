import java.util.Scanner;

public class Kadai5 {
 	public static void main(String args[]) {
	
		//�l�̐ݒ�
		int receiptNumber = 0;//���V�[�g�̖���
		int purchaseAmount = 0;//���z�̍��v
		int pointAmount = 0;//�|�C���g�̍��v
		int purchaseNumber = 0;//�w�����z
		String dayNumber;//�w���������ɂ�
		
		Scanner sc = new Scanner(System.in);
		
		String t = sc.nextLine();
		receiptNumber = Integer.parseInt(t);//���V�[�g�̐������
		
		for(int i = 0;i < receiptNumber;i++){
			String st = sc.nextLine();//�w���������ɂ��ƍw�����z�����
			String numberArray[] = st.split(" ");
			dayNumber = numberArray[0];
			purchaseNumber = Integer.parseInt(numberArray[1]);
			double point = purchaseNumber/100;//�w�����z����|�C���g���Z�o
			
			if(dayNumber.indexOf("3") > -1){//3�̂����ɂ�������
				point *= 3;//3%�̃|�C���g�Ɍv�Z
			}
			if(dayNumber.indexOf("5") > -1){//5�̂����ɂ�������
				point *= 5;//5%�̃|�C���g�Ɍv�Z
			}
			
			pointAmount += (int)point;//�|�C���g�̏����_��؂�̂Ăă|�C���g���v�ɒǉ�
			
			purchaseAmount += purchaseNumber;//�w�����z�����v���z�ɒǉ�
		}
		
		sc.close();
		
		System.out.println(purchaseAmount + "�~");
		System.out.println(pointAmount + "�|�C���g");
	}	
}		