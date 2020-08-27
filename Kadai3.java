import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Comparator;

public class Kadai3 {
 	public static void main(String args[]) {
		
		//’l‚Ìİ’è
		int holidayNumber = 0;//‹x“ú‚Ì“ú”
		int travelNumber = 0;//—·s‚Ì“ú’ö
		int rainyPercentNumber = 0;//~…Šm—¦
		List<Double> numberList = new ArrayList<Double>();//~…Šm—¦‚Ì•½‹Ï’l‚ğû”[‚·‚éList‚Ìì¬
		
		Scanner sc = new Scanner(System.in);
		
		//‹x“ú‚Ì“ú”‚Æ—·s“ú’ö‚Ìİ’è
		String t = sc.nextLine();//‹x“ú‚Ì“ú”‚Æ—·s“ú’ö‚Ì“ü—Í
		String holidaytravelArray[] = t.split(" ");
		holidayNumber = Integer.parseInt(holidaytravelArray[0]);
		travelNumber = Integer.parseInt(holidaytravelArray[1]);
		
		int rainArray[] = new int[holidayNumber];
		int travelArray[] = new int[holidayNumber];
		
		//—·s‚Ì“ú’ö‚Æ~…Šm—¦‚Ìİ’è
		for(int i = 0;i < holidayNumber;i++){
			String st = sc.nextLine();
			String travelrainArray[] = st.split(" ");
			travelArray[i] = Integer.parseInt(travelrainArray[0]);
			rainArray[i] = Integer.parseInt(travelrainArray[1]);
		}
		
		sc.close();
		
		//~…Šm—¦‚Ì•½‹Ï’l‚ÌŒvZ‚ÆList‚É’Ç‰Á
		int sum = 0;
		for(int j = 0;j <= (holidayNumber - travelNumber);j++){
			for(int w = 0;w < travelNumber;w++){
				rainArray[j] += rainArray[j+w];
			}
			double ave = rainArray[j]/travelNumber;
			numberList.add(ave);
		}
		
		//•½‹Ï’l‚ÌÅ¬’l
		double minAve = numberList.stream().min(Comparator.naturalOrder()).getAsDouble();
		int indextravel = numberList.IndexOf(minAve);
		println(travelArray[indextravel] + " " + travelArray[indextravel + holidayNumber - 1]);
	}
}