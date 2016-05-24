
public class GrammarFromAutomata {

	public static void main(String[] args) {
		System.out.println(combinePath(5));

	}

	public static String combinePath(int tam) {

		String str = "";

		for (int i = 1; i <= tam; i++) {
			for (int j = 1; j <= tam; j++) {
				String rule = putFormat(i, j) + " & \\to ";
				for (int k = 1; k <= tam; k++) {
					if (!(i == j && j == k)) {
						rule = rule.concat(putFormat(i, k) + putFormat(k, j));
						if (k != tam) {
							rule = rule.concat(" \\mid ");
						}						
					}
					
				}
				if (i==j){
					rule = rule.concat(" \\mid \\varepsilon ");
				}
				if(!(i==j && j==tam)){
					rule = rule.concat("\\\\ \n ");
				}				
				str = str.concat(rule);
			}
		}

		return str;

	}

	public static String putFormat(int i, int j) {

		return "A_{" + Integer.toString(i) + Integer.toString(j) + "}";

	}
	
	public static String putEpsilon(int i){
		return "\\varepsilon";
	}

}
