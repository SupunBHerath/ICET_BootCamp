import java.util.*;

class Array {

	public static double getTotalAmount(int[] index, double[] amount) {
		double totalAmount = 0;
		for (int i = 0; i < index.length; i++) {
			totalAmount += amount[index[i]];
		}
		return totalAmount;
	}

	public static void getSameIndex(int[] code, String[] name, double[] amount) {
		int[] temCode = new int[code.length];
		double[] TotalAmount = new double[amount.length];
		String[] temName = new String[name.length];
		int codeCount = 0;

		L1: for (int i = 0; i < code.length; i++) {
			for (int j = 0; j < temCode.length; j++) {
				if (temCode[j] == code[i]) {
					continue L1;
				}
			}
			temCode[codeCount] = code[i];
			temName[codeCount] = name[i];
		
			for (int k = 0; k < amount.length; k++) {
				if (code[i] == code[k]) {
					TotalAmount[codeCount] += amount[k];
				
				}
			}
			codeCount++;
		}
		int[] temCode2 = new int[codeCount];
		double[] TotalAmount2 = new double[codeCount];
		String[] temName2 = new String[codeCount];

		for (int i = 0; i < codeCount; i++) {
			temCode2[i] = temCode[i];
			TotalAmount2[i] = TotalAmount[i];
			temName2[i] = temName[i];
		}
		temCode = temCode2;
		TotalAmount = TotalAmount2;
		temName = temName2;

		// sort by Amount
		for (int i = 0; i < codeCount; i++) {
			for (int j = 0; j < codeCount - 1 - i; j++) {
				if (TotalAmount[j] < TotalAmount[j + 1]) {
					double temAmount = TotalAmount[j];
					TotalAmount[j] = TotalAmount[j + 1];
					TotalAmount[j + 1] = temAmount;

					int temcode = temCode[j];
					temCode[j] = temCode[j + 1];
					temCode[j + 1] = temcode;

					String temname = temName[j];
					temName[j] = temName[j + 1];
					temName[j + 1] = temname;
				}
			}
		}
		System.out.printf("%-5s%-10s%-10s%10s", "No", "Code", "Name", "Total Amount\n");
		for(int i = 0 ; i < codeCount; i++) {
		System.out.printf("%-5s%-10s%-10s%10.2f\n",(i+1)+".",temCode[i],temName[i],TotalAmount[i]);
		}
	
	}

	public static void main(String args[]) {
		int[] custCode = { 1001, 1002, 1001, 1001, 1003, 1002, 1003, 1001, 1002, 1003, 1004, 1005, 1004 };
		String[] name = { "Nimal", "Bimal", "Nimal", "Nimal", "Amal", "Bimal", "Amal", "Nimal", "Bimal", "Amal",
				"Ramal", "Wimal", "Ramal" };
		double[] amount = { 5600, 2300, 3300, 4300, 4500, 1200, 3000, 4000, 2400, 5300, 5600, 2450, 4300 };
		getSameIndex(custCode, name, amount);

	}
}
// output
// No   Code      Name      Total Amount
// 1.   1001      Nimal       17200.00
// 2.   1003      Amal        12800.00
// 3.   1004      Ramal        9900.00
// 4.   1002      Bimal        5900.00
// 5.   1005      Wimal        2450.00
