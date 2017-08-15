
import java.util.LinkedHashMap;



public class Dec2Roman {

	// esta indirecao extra so para poder trocar as versoes facil!
	// troque conv0 por conv1, conv2, conv10, etc. 
	// assim voce pode manter as versoes como metodos da mesma classe.
	public static String conv(int num) {
		return convFinalMelhorado(num);
	}
	
	// 1 {} -> null
	public static String conv0(int num) {
		return null; 	// version 0: no test passes.
	}
	
	// next iteration: one test passes
	// 2 nil -> constant
	public static String conv1(int num) {
		return "I";
	}
	
	/*********************************************************/
	// 3rd iteration: 2 tests pass
	// 4 Constant -> variable
	// 5 statement -> statements
	// 6 unconditional -> conditional
	public static String conv2(int num) {
		 String res = "I";
	     if (num > 1) {
	            res += "I";
	     }
	     return res;
	}

	// **************** WHAT YOU HAVE TO DO ****************
	// now write a convX method for each test. 
	// each new convX version must make a new test pass
	// BUT PERFORM ONLY THE MINIMUM CHANGES AT EACH STEP
	// *****************************************************
	public static String conv3(int num) {
		String res = "";
	     while (num > 0) {
	    	 res += "I";
	    	 num -= 1;
	     }
	     return res;
	}
	
	// Adicionamos o 4 no condicional
	public static String conv4(int num) {
		String res = "";
		if (num == 4)
			return "IV";
		
	    while (num > 0) {
	    	 res += "I";
	    	 num -= 1;
	     }
	     return res;
	}
	
	// Adicionamos o 5 no condicional
	public static String conv5(int num) {
		String res = "";
		if (num == 4)
			return "IV";
		if (num >= 5)
			return "V";
	    while (num > 0) {
	    	 res += "I";
	    	 num -= 1;
	     }
	     return res;
	}
	
	// Melhoramos o condicional do 5
	public static String conv8(int num) {
		String res = "";
		if (num == 4)
			return "IV";
		if (num >= 5) {
			res += "V";
			num -= 5;
		}
	    while (num > 0) {
	    	 res += "I";
	    	 num -= 1;
	     }
	     return res;
	}
	
	// Adicionamos o 10 no codicional utilizando a mesma lógica do 10
	public static String conv10(int num) {
		String res = "";
		if (num >= 10) {
			res += "X";
			num -= 10;
		}
		if (num == 9)
			return "IX";
		if (num >= 5) {
			res += "V";
			num -= 5;
		}
		if (num == 4)
			return "IV";
	    while (num > 0) {
	    	 res += "I";
	    	 num -= 1;
	     }
	     return res;
	}
	
	
	// O professor Mirisola sugeriu utilizar o Map a partir do teste 10, refizemos.
	// Porém, já tinhamos feito até o conv100, então para não apagar o que já tínhamos
	// feito, criamos os métodos "b";
	public static String conv10b(int num) {
		LinkedHashMap<Integer, String> valores = new LinkedHashMap<Integer, String>();
		valores.put(10, "X");
		valores.put(9, "IX");
		valores.put(5, "V");
		valores.put(4, "IV");
		valores.put(1, "I");
		String res = "";
		for (int valor : valores.keySet()) {
			while (num >= valor) {
				res += valores.get(valor);
				num -= valor;
			}
		}
	    return res;
	}
	
	
	public static String conv14(int num) {
		String res = "";
		if (num >= 10) {
			res += "X";
			num -= 10;
		}
		if (num == 9)
			return "IX";
		if (num >= 5) {
			res += "V";
			num -= 5;
		}
		if (num == 4) {
			res += "IV";
			num -= 4;
		}
	    while (num > 0) {
	    	 res += "I";
	    	 num -= 1;
	     }
	     return res;
	}
	
	
	// O professor Mirisola sugeriu utilizar o Map a partir do teste 10, refizemos
	public static String conv14b(int num) {
		LinkedHashMap<Integer, String> valores = new LinkedHashMap<Integer, String>();
		valores.put(10, "X");
		valores.put(9, "IX");
		valores.put(5, "V");
		valores.put(4, "IV");
		valores.put(1, "I");
		String res = "";
		for (int valor : valores.keySet()) {
			while (num >= valor) {
				res += valores.get(valor);
				num -= valor;
			}
		}
	    return res;
	}
		
	
	public static String conv44(int num) {
		String res = "";
		if (num >= 40) {
			res += "XL";
			num -= 40;
		}
		while (num >= 10) {
			res += "X";
			num -= 10;
		}
		if (num == 9) {
			res += "IX";
			num -= 9;
		}
		if (num >= 5) {
			res += "V";
			num -= 5;
		}
		if (num == 4) {
			res += "IV";
			num -= 4;
		}
	    while (num > 0) {
	    	 res += "I";
	    	 num -= 1;
	     }
	     return res;
	}
	
	// O professor Mirisola sugeriu utilizar o Map a partir do teste 10, refizemos
	public static String conv44b(int num) {
		LinkedHashMap<Integer, String> valores = new LinkedHashMap<Integer, String>();
		valores.put(40, "XL");
		valores.put(10, "X");
		valores.put(9, "IX");
		valores.put(5, "V");
		valores.put(4, "IV");
		valores.put(1, "I");
		String res = "";
		for (int valor : valores.keySet()) {
			while (num >= valor) {
				res += valores.get(valor);
				num -= valor;
			}
		}
	    return res;
	}
	
	
	public static String conv100(int num) {
		String res = "";
		if (num >= 100) {
			res += "C";
			num -= 100;
		}
		if (num >= 90) {
			res += "XC";
			num -= 90;
		}
		if (num >= 50) {
			res += "L";
			num -= 50;
		}
		if (num >= 40) {
			res += "XL";
			num -= 40;
		}
		while (num >= 10) {
			res += "X";
			num -= 10;
		}
		if (num == 9) {
			res += "IX";
			num -= 9;
		}
		if (num >= 5) {
			res += "V";
			num -= 5;
		}
		if (num == 4) {
			res += "IV";
			num -= 4;
		}
	    while (num > 0) {
	    	 res += "I";
	    	 num -= 1;
	     }
	     return res;
	}
	
	
	public static String conv100b(int num) {
		LinkedHashMap<Integer, String> valores = new LinkedHashMap<Integer, String>();
		valores.put(400, "CD");
		valores.put(100, "C");
		valores.put(90, "XC");
		valores.put(50, "L");
		valores.put(40, "XL");
		valores.put(10, "X");
		valores.put(9, "IX");
		valores.put(5, "V");
		valores.put(4, "IV");
		valores.put(1, "I");
		String res = "";
		for (int valor : valores.keySet()) {
			while (num >= valor) {
				res += valores.get(valor);
				num -= valor;
			}
		}
	    return res;
	}
	
	
	// Passa em tudo
	public static String convFinal(int num) {
		LinkedHashMap<Integer, String> valores = new LinkedHashMap<Integer, String>();
		valores.put(1000, "M");
		valores.put(900, "CM");
		valores.put(500, "D");
		valores.put(400, "CD");
		valores.put(100, "C");
		valores.put(90, "XC");
		valores.put(50, "L");
		valores.put(40, "XL");
		valores.put(10, "X");
		valores.put(9, "IX");
		valores.put(5, "V");
		valores.put(4, "IV");
		valores.put(1, "I");
		String res = "";
		for (int valor : valores.keySet()) {
			while (num >= valor) {
				res += valores.get(valor);
				num -= valor;
			}
		}
	    return res;
	}
	
	// Passa em tudo
		public static String convFinalMelhorado(int num) {
			LinkedHashMap<Integer, String> valores = new LinkedHashMap<Integer, String>();
			valores.put(1000, "M");
			valores.put(900, "CM");
			valores.put(500, "D");
			valores.put(400, "CD");
			valores.put(100, "C");
			valores.put(90, "XC");
			valores.put(50, "L");
			valores.put(40, "XL");
			valores.put(10, "X");
			valores.put(9, "IX");
			valores.put(5, "V");
			valores.put(4, "IV");
			valores.put(1, "I");
			String res = "";
			if(num > 3999 || num <= 0) {
				throw new IllegalArgumentException("Must be between 3999 and 1"); 
			}
			for (int valor : valores.keySet()) {
				while (num >= valor) {
					res += valores.get(valor);
					num -= valor;
				}
			}
		    return res;
		}
	
}// class Dec2Roman
	
	/*
	 * 		LinkedHashMap<Integer, String> valores = new LinkedHashMap<Integer, String>();
		valores.put(1, "I");
		valores.put(4, "IV");
		valores.put(5, "V");
		valores.put(9, "IX");
		valores.put(10, "X");
	/// EXAMPLE OF HOW TO USE A DICTIONARY!
	// example of how to use a dictionary to avoid repetition
	public static String conv4_2(int number)
	    {
	    	LinkedHashMap<Integer, String> Results = new LinkedHashMap<Integer, String>();
	    	Results.put(1,"I");
	    	Results.put(4,"IV");
	    	
	        if (Results.containsKey(number) )
	        {
	            return Results.get(number);
	        }
	        return Results.get(1) + conv4_2(number - 1);
	    }
	*/


	
		

