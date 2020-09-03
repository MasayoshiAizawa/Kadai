import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import java.util.TreeMap;
import java.util.Map;


public class Kadai10 {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		//��_�̒l�̐ݒ�E����		
		String s = sc.nextLine();//��_��x�Ay���W�̓���
		String Array[] = s.split(" ");//
		int x = Integer.parseInt(Array[0]);//��_��x���W
		int y = Integer.parseInt(Array[1]);//��_��y���W
		int k = Integer.parseInt(sc.nextLine());//�v����
		int N = Integer.parseInt(sc.nextLine());//�n���̐�
		
		int numberArray[] = new int[N];//���͂����n�������[����z��

		ArrayList<List<Integer>> numberlist = new ArrayList<>();//���͂���x�Ay���W�����[����񎟌�List
		Map<Double,Integer> ranking = new TreeMap<Double,Integer>();//��_����̋����̏����Œn�������[����Map
		
		//�ϑ��_�̒l�̓���
		for(int i = 0;i < N;i++){
			String st = sc.nextLine();//x�Ay���W�̓���
			String posArray[] = st.split(" ");
			List<Integer> numbersublist = new ArrayList<Integer>();//numberlist��񎟌��z������[���邽�߂�List
			numbersublist.add(Integer.parseInt(posArray[0]));//���͂��ꂽx���W
			numbersublist.add(Integer.parseInt(posArray[1]));//���͂��ꂽy���W
			numberlist.add(numbersublist);
			numberArray[i] = Integer.parseInt(posArray[2]);//���͂��ꂽ�n��
		}
		
		//�ϑ��_�Ɗ�_�̋����������Ŏ��[
		for(int i = 0;i < N;i++){
			double dist = Math.sqrt(Math.pow(numberlist.get(i).get(0) - x,2) + Math.pow(numberlist.get(i).get(1) - y,2));
			ranking.put(dist,numberArray[i]);
		};
		
		//�����̋�����Map��key�Ƃ���value�̒n���̎��o��
		List<Integer> sqrlist = new ArrayList<>(ranking.values());
		
		//�ϑ�������v�����Ԃ�̕��ϒl���Z�o
		int sum = 0;
		for(int i = 0;i < k;i++){
			sum += sqrlist.get(i);
		}
		
		//���߂镽�ϒl��\��
		System.out.println(Math.round(sum/k));
	}
}
		