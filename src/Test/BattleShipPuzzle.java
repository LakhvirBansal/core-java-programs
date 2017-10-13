package Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class BattleShipPuzzle {

	private static final String FILENAME = "D:\\battleship\\inputFile.txt";
	static int valPlayer1 = 0;
	static int valPlayer2 = 0;
	
	static HashMap<String, Integer> shipCountPlayer1 = new HashMap<String, Integer>();
	static HashMap<String, Integer> shipCountPlayer2 = new HashMap<String, Integer>();
	static HashMap<String , Integer>  qPlayer1 = new HashMap<String , Integer>();
	static HashMap<String, Integer>  qPlayer2 = new HashMap<String, Integer>();
	
	// set input data
	static int boundaries =0;
	static String alphaNumber = "";
	static String dimensionForBattleship1 = "";
	static String dimensionForBattleship2 = "";
	static String locationOfBattleship1Forplayer1 = "";
	static String locationOfBattleship1Forplayer2 = "";
	static String locationOfBattleship2Forplayer1 = "";
	static String locationOfBattleship2Forplayer2 = "";
	static String[] missileTargetsForPlayer1 ;
	static String[] missileTargetsForPlayer2 ;
	
	static boolean declare_peace = true;
	static boolean player1Finish = false;
	static boolean player2Finish = false;

	public static void main(String[] args) {

		System.out.println("Sample Input:");

		readTextFile(); // read input file

		HashMap<String, Integer> alphaMap = getAlphaMap(alphaNumber); // map to get the index from aplhabet

		String[][] player1 = new String[boundaries + 1][alphaMap.get(alphaNumber) + 1]; // create player1 battle area
		String[][] player2 = new String[boundaries + 1][alphaMap.get(alphaNumber) + 1]; // create player2 battle area

		String dimension = dimensionForBattleship1; // read first boat dimension
		HashMap<String, Integer> dimensionMap = new HashMap<String, Integer>();
		String[] dimensionArray = dimension.split(" ");
		int count1 = Integer.parseInt(dimensionArray[0]);
		int count2 = Integer.parseInt(dimensionArray[1]);
		if (count1 > count2) {
			shipCountPlayer1.put("totalShip", count1); // map to store total area covered
		} else {
			shipCountPlayer1.put("totalShip", count2);
		}

		dimensionMap.put("W", Integer.parseInt(dimensionArray[0])); // width
		dimensionMap.put("H", Integer.parseInt(dimensionArray[1])); // height

		String locationOfPlayer1 = locationOfBattleship1Forplayer1; // player-1 boat-1 location
		String locationOfPlayer2 = locationOfBattleship1Forplayer2; // player-1 boat-1 location
		int dimensionOfWidthQ = dimensionMap.get("W");
		int dimensionOfHeightQ = dimensionMap.get("H");

		// fill boat-1 area for both players
		for (int k = 0; k < dimensionOfHeightQ; k++) {
			for (int i = 0; i < dimensionOfWidthQ; i++) {

				int firstLatterPlayer1 = alphaMap.get(String.valueOf(locationOfPlayer1.charAt(0)));
				int secondLatterPlayer1 = Integer.valueOf(String.valueOf(locationOfPlayer1.charAt(1)));

				if (i == 0) {
					player1[firstLatterPlayer1 + k][secondLatterPlayer1] = "Q";
				} else {
					player1[firstLatterPlayer1 + k][secondLatterPlayer1 + 1] = "Q";
				}

				int firstLatterPlayer2 = alphaMap.get(String.valueOf(locationOfPlayer2.charAt(0)));
				int secondLatterPlayer2 = Integer.valueOf(String.valueOf(locationOfPlayer2.charAt(1)));

				if (i == 0) {
					player2[firstLatterPlayer2][secondLatterPlayer2] = "Q";
				} else {
					player2[firstLatterPlayer2][secondLatterPlayer2 + 1] = "Q";
				}

			}
		}

		String dimension2 = dimensionForBattleship2; // second boat dimension
		HashMap<String, Integer> dimensionMap2 = new HashMap<String, Integer>();
		String[] dimensionArray2 = dimension2.split(" ");

		int count3 = Integer.parseInt(dimensionArray2[0]);
		int count4 = Integer.parseInt(dimensionArray2[1]);
		int val = shipCountPlayer1.get("totalShip");
		if (count3 > count4) {
			shipCountPlayer1.put("totalShip", val + count3);
		} else {
			shipCountPlayer1.put("totalShip", val + count4);
		}
		int totalShipForEach = shipCountPlayer1.get("totalShip");
		shipCountPlayer2.put("totalShip", totalShipForEach);

		dimensionMap2.put("W", Integer.parseInt(dimensionArray2[0]));
		dimensionMap2.put("H", Integer.parseInt(dimensionArray2[1]));

		String locationOfD2Player1 = locationOfBattleship2Forplayer1;
		String locationOfD2Player2 = locationOfBattleship2Forplayer2;

		int dimensionOfWidthQ2 = dimensionMap2.get("W");
		int dimensionOfHeightQ2 = dimensionMap2.get("H");

		// fill boat-2 area for both players
		for (int d = 0; d < dimensionOfHeightQ2; d++) {
			for (int i = 0; i < dimensionOfWidthQ2; i++) {

				int firstLatterPlayer1 = alphaMap.get(String.valueOf(locationOfD2Player1.charAt(0)));
				String secondLatterTemp = String.valueOf(locationOfD2Player1.charAt(1));
				int secondLatterPlayer1 = Integer.valueOf(secondLatterTemp);

				if (i == 0) {
					player1[firstLatterPlayer1 + d][secondLatterPlayer1] = "P";
				} else {
					player1[firstLatterPlayer1 + d][secondLatterPlayer1 + 1] = "P";
				}

				int firstLatterPlayer2 = alphaMap.get(String.valueOf(locationOfD2Player2.charAt(0)));
				int secondLatterPlayer2 = Integer.valueOf(String.valueOf(locationOfD2Player2.charAt(1)));

				if (i == 0) {
					player2[firstLatterPlayer2][secondLatterPlayer2] = "P";

				} else {
					player2[firstLatterPlayer2][secondLatterPlayer2 + 1] = "P";
				}
			}
		}

		System.out.println("*************************************");
		System.out.println("Sample Output:");

		firstPlayerTurn(player2, alphaMap, player1);

		if (declare_peace) {
			System.out.println("Players declaring peace.");
		}

	}
	
	/**
	 * method used to read the text file
	 */
	private static void readTextFile() {
		BufferedReader br = null;
		FileReader fr = null;
		try {

			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			String sCurrentLine;
			int lineCount = 0;
			while ((sCurrentLine = br.readLine()) != null) {

				setValues(lineCount, sCurrentLine);
				lineCount++;

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * method used to set the values from text file
	 * 
	 * @param lineCount
	 * @param sCurrentLine
	 */
	private static void setValues(int lineCount, String sCurrentLine) {
		
		if(lineCount == 0){
			  String value = splitByColumn(sCurrentLine.trim());
			  String first  = value.split(" ")[0];
			  alphaNumber = value.split(" ")[1];
			  boundaries = Integer.valueOf(first);
			  
		  }
		  if(lineCount == 2){
			  String value = splitByColumn(sCurrentLine.trim());
			  dimensionForBattleship1 = value;
		  }
		  if(lineCount == 3){
			  String value = splitByColumn(sCurrentLine.trim());
			  locationOfBattleship1Forplayer1 = value;
		  }
		  if(lineCount == 4){
			  String value = splitByColumn(sCurrentLine.trim());
			  locationOfBattleship1Forplayer2 = value;
		  }
		  if(lineCount == 6){
			  String value = splitByColumn(sCurrentLine.trim());
			  dimensionForBattleship2 = value;
		  }
		  if(lineCount == 7){
			  String value = splitByColumn(sCurrentLine.trim());
			  locationOfBattleship2Forplayer1 = value;
		  }
		  if(lineCount == 8){
			  String value = splitByColumn(sCurrentLine.trim());
			  locationOfBattleship2Forplayer2 = value;
		  }
		  if(lineCount == 9){
			  String value = splitByColumn(sCurrentLine.trim());
			  String[] arr = missleTarget(value);
			  missileTargetsForPlayer1 = arr;
		  }
		  if(lineCount == 10){
			  String value = splitByColumn(sCurrentLine.trim());
			  String[] arr = missleTarget(value);
			  missileTargetsForPlayer2 = arr;
		  }
		  lineCount++;
		  System.out.println(sCurrentLine);
		
	}

	/**
	 * this method used when first player hits the missile
	 * 
	 * @param player2
	 * @param alphaMap
	 * @param player1
	 */
	public static void firstPlayerTurn(String[][] player2, HashMap<String, Integer> alphaMap,String[][] player1 ){
		
		String[] shootPlayer1 = missileTargetsForPlayer1;

		if (valPlayer1 == shootPlayer1.length) {
			System.out.println("Player-1 has no more missiles left");
			player1Finish = true;
			if (!player2Finish) {
				secondPlayerTurn(player2, alphaMap, player1);
			}
		}

		for (int i = valPlayer1; i < shootPlayer1.length; i++) {

				if (shipCountPlayer1.get("totalShip") <= 0) {
					System.out.println("Player-1 won the battle");
					declare_peace = false;
					break;
				}
				if (valPlayer1 == shootPlayer1.length) {
					 System.out.println("Player-1 has no more missiles left");
					 player1Finish = true;
					 if(!player2Finish){
						 secondPlayerTurn(player2, alphaMap, player1);
					 }
				break;
				}
				String shootMen = shootPlayer1[i];
				valPlayer1++;
				int p1 = alphaMap.get(String.valueOf(shootMen.charAt(0)));
				int p2 = Integer.valueOf(String.valueOf(shootMen.charAt(1)));
				String val = player2[p1][p2];
				if ("Q".equals(val)) {
					System.out.println("Player-1 fires a missile with target " + shootMen + " which hit");
					String qVal = p1 + "-" + p2;
					if (qPlayer1.containsKey(qVal)) {
						shipCountPlayer1.put("totalShip", shipCountPlayer1.get("totalShip") - 1);
						if (qPlayer1.get(qVal) == 1) {
							player2[p1][p2] = "kill";
						}
					} else {
						qPlayer1.put(qVal, 1);
					}

				} else if ("P".equals(val)) {
					System.out.println("Player-1 fires a missile with target " + shootMen + " which hit");
					shipCountPlayer1.put("totalShip", shipCountPlayer1.get("totalShip") - 1);
					player2[p1][p2] = "kill";
				} else {
					System.out.println("Player-1 fires a missile with target " + shootMen + " which missed");
					secondPlayerTurn(player2, alphaMap, player1);
				if (!declare_peace || player2Finish) {
						break;
				}

				}
				
			}
		
	}
	
	/**
	 * this method used when second player hits the missile
	 * 
	 * @param player2
	 * @param alphaMap
	 * @param player1
	 */
	public static void secondPlayerTurn(String[][] player2, HashMap<String, Integer> alphaMap, String[][] player1 ){
		String[] shootPlayer2 = missileTargetsForPlayer2;

		if (valPlayer2 == shootPlayer2.length) {
			System.out.println("Player-2 has no more missiles left");
			player2Finish = true;
			if (!player1Finish) {
				firstPlayerTurn(player2, alphaMap, player1);
			}
		}
		for (int i = valPlayer2; i < shootPlayer2.length; i++) {

				if (shipCountPlayer2.get("totalShip") <= 0) {
					System.out.println("Player-2 won the battle");
					declare_peace = false;
					break;
				}
				if (valPlayer2 == shootPlayer2.length) {
					System.out.println("Player-2 has no more missiles left");
					player2Finish = true;
					if (!player1Finish) {
						firstPlayerTurn(player2, alphaMap, player1);
					}
				break;
				}
				String shootMen = shootPlayer2[i];
				valPlayer2++;
				int row = alphaMap.get(String.valueOf(shootMen.charAt(0)));
				int column = Integer.valueOf(String.valueOf(shootMen.charAt(1)));
				String val = player1[row][column];
				if ("Q".equals(val)) {
					System.out.println("Player-2 fires a missile with target " + shootMen + " which hit");

					boolean alreadyHitOnce = checkAlreadyHit(row, column, player1);
				} else if ("P".equals(val)) {
					System.out.println("Player-2 fires a missile with target " + shootMen + " which hit");
					shipCountPlayer2.put("totalShip", shipCountPlayer2.get("totalShip") - 1);
					player1[row][column] = "kill";
				} else {
					System.out.println("Player-2 fires a missile with target " + shootMen + " which missed");
					firstPlayerTurn(player2, alphaMap, player1);
				if (!declare_peace || player1Finish) {
						break;
				}
				}
			}
		

	}
	
	/**
	 * method used to check whether particular location is hit once or not.
	 * 
	 * @param row
	 * @param column
	 * @param player1
	 * @return
	 */
	private static boolean checkAlreadyHit(int row, int column, String[][] player1) {
		boolean returnval = false;
		String qVal = row+"-"+column;
		 if(qPlayer2.containsKey(qVal)){
			shipCountPlayer2.put("totalShip", shipCountPlayer2.get("totalShip") - 1);
			 if(qPlayer2.get(qVal) == 1){
				 player1[row][column] = "kill";
			 }
			 returnval = true;
		 }else{
			 qPlayer2.put(qVal, 1);
		 }
		 return returnval;
	}

	/**
	 * used to split the input file by colon.
	 * 
	 * @param line
	 * @return
	 */
	public static String splitByColumn(String line){
		String[] strArr = line.split(":");
		String str  = strArr[1];
		return str.trim();
	}
	
	/**
	 * used to split the missile targets
	 * 
	 * @param line
	 * @return
	 */
	public static String[] missleTarget(String line){
		String[] str  = line.split(" ");
		return str;
	}
	
	/**
	 * map to store alphabet and corresponding number.
	 * 
	 * @param charString
	 * @return
	 */
	public static HashMap<String, Integer> getAlphaMap(String charString) {

		char c = charString.charAt(0);
		char ch;
		HashMap<String, Integer> alphaMap = new HashMap<String, Integer>();
		int count = 1;
		for (ch = 'A'; ch <= c; ch++) {
			String str = String.valueOf(ch);
			alphaMap.put(str, count);
			count++;
		}
		return alphaMap;

	}
	
}
