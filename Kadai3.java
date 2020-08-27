import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Comparator;

public class Kadai3 {
 	public static void main(String args[]) {
		
		//lΜέθ
		int holidayNumber = 0;//xϊΜϊ
		int travelNumber = 0;//·sΜϊφ
		int rainyPercentNumber = 0;//~m¦
		List<Double> numberList = new ArrayList<Double>();//~m¦Μ½Οlπϋ[·ιListΜμ¬
		
		Scanner sc = new Scanner(System.in);
		
		//xϊΜϊΖ·sϊφΜέθ
		String t = sc.nextLine();//xϊΜϊΖ·sϊφΜόΝ
		String holidaytravelArray[] = t.split(" ");
		holidayNumber = Integer.parseInt(holidaytravelArray[0]);
		travelNumber = Integer.parseInt(holidaytravelArray[1]);
		
		int rainArray[] = new int[holidayNumber];
		int travelArray[] = new int[holidayNumber];
		
		//·sΜϊφΖ~m¦Μέθ
		for(int i = 0;i < holidayNumber;i++){
			String st = sc.nextLine();
			String travelrainArray[] = st.split(" ");
			travelArray[i] = Integer.parseInt(travelrainArray[0]);
			rainArray[i] = Integer.parseInt(travelrainArray[1]);
		}
		
		sc.close();
		
		//~m¦Μ½ΟlΜvZΖListΙΗΑ
		int sum = 0;
		for(int j = 0;j <= (holidayNumber - travelNumber);j++){
			for(int w = 0;w < travelNumber;w++){
				rainArray[j] += rainArray[j+w];
			}
			double ave = rainArray[j]/travelNumber;
			numberList.add(ave);
		}
		
		//½ΟlΜΕ¬l
		double minAve = numberList.stream().min(Comparator.naturalOrder()).getAsDouble();
		int indextravel = numberList.IndexOf(minAve);
		println(travelArray[indextravel] + " " + travelArray[indextravel + holidayNumber - 1]);
	}
}