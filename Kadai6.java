import java.util.Scanner;

public class Kadai6 extends Lee{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		//•¶š—ñ‚Ì“ü—Í
		String str = sc.nextLine();
		
		sc.close();
		
		//•¶š—ñ‚ğˆê•¶š‚²‚Æ‚É•ªŠ„
		String splitArray[] = str.split("");
		
		//ˆê•¶š‚²‚Æ‚ÉLee•ÏŠ·‚ğ‚µo—Í‚·‚é
		for(String s : splitArray){
			s = Lee.leechange(s);
			System.out.print(s);
		}
	}
}
class Lee{
	public static String leechange(String s) {
	//•¶š‚Ì’uŠ·
		if(s.equals("A")){//ğŒ‚Éˆê’v‚·‚é‚©”»•Ê
			s = s.replace("A","4");//Lee•ÏŠ·‚ğs‚¤
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