import java.util.*;

class  CRC {

	static StringBuilder CRCcompute(StringBuilder data, StringBuilder generator, boolean check) {
		
		char[] datan = new char[data.length()+generator.length()-1];

		if(check == true) {
			for(int i = 0; i < generator.length()-1;i++)
				data.append("0");
		}

		data.getChars(0,data.length(), datan,0);

		for(int i = 0; i < data.length()-generator.length()+1; i++) {
			
			if(datan[i] == '1') {
				for(int j = 0; j < generator.length();j++) {
					datan[i+j] = (datan[i+j] == generator.charAt(j)) ? '0': '1';
				}
			}
		}

		StringBuilder rem = new StringBuilder(" ");
		int k = 0;
		for(int i = data.length()-generator.length()+1; k < generator.length()-1;i++, k++)
			rem.append(datan[i]);

		return rem;

	}


	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter dataword: ");
		
		StringBuilder data = new StringBuilder(sc.next());
		StringBuilder d = new StringBuilder(data.toString());

		System.out.println("Enter generator: ");
		StringBuilder genr = new StringBuilder(sc.next());
		StringBuilder rem = CRCcompute(data, genr, true);
		d.append(rem);

		System.out.println("Codeword is: " + d);
		System.out.println("Enter received codeword: ");
		data = new StringBuilder(sc.next());
		StringBuilder rem2 = CRCcompute(data, genr, false);

		if(Integer.parseInt(rem2.toString()) == 0)
			System.out.println("No error found");
		else 
			System.out.println("Error found");
	}

}
