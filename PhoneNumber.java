package lessonone;

import java.util.ArrayList;

import extra.Util;

public class PhoneNumber {
	
	/**
	 *	Klasa nuk eshte immutable.
	 *	Paraqet informacion per numra telefoni ne Shqiperi,
	 *	per te cilet, ruhet:
	 *
	 * 		prefix shteti		355			(gjithmone keshtu)
	 * 		numer operatori		68
	 * 		numer sim			2000001
	 * 
	 * 	Numrat jane unik.
	 * 	Ne Shqiperi operatori mund te ndryshohet, por jo
	 * 	identifikuesi i tij.
	 * 	Operatoret jane te fundem, dmth ekzistojne vetem
	 * 
	 * 		ALBTELECOM	67
	 * 		ONE			68
	 * 		VODAFONE	69
	 **/

	public static final short ALBANIAN_PREFIX = 355;
	public static final byte ALBTELECOM_OPERATOR_NUMBER = 67;
	public static final byte ONE_OPERATOR_NUMBER = 68;
	public static final byte VODAFONE_OPERATOR_NUMBER = 69;
	public static final int MIN_SIM_CARD_NUMBER = 2_000_000;
	public static final int MAX_SIM_CARD_NUMBER = 9_999_999;
	
	private static final ArrayList<PhoneNumber> PHONE_NUMBERS = new ArrayList<>();
	
	private byte actualOperatorNumber;		//i ndryshueshem
	private byte originalOperatorNumber;	//i pandryshueshem
	private int simCardNumber;				//i pandryshueshem
	
	public PhoneNumber(int actualOperatorNumber,  
					   int simCardNumber) {
		this(actualOperatorNumber, actualOperatorNumber, simCardNumber);
	}
	
	public PhoneNumber(int actualOperatorNumber, 
					   int originalOperatorNumber, 
					   int simCardNumber) {
		if(!isValidAlbanianOperator(originalOperatorNumber)) {
			//ndalohet krijimi i objektit
			//nuk di si </3
			//me marreveshje e vendosim ALBTELECOM
			originalOperatorNumber = ALBTELECOM_OPERATOR_NUMBER;
		}
		if(!isValidAlbanianOperator(actualOperatorNumber)) {
			//ndalohet krijimi i objektit
			//nuk di si </3
			//me marreveshje e vendosim originalOperatorNumber
			actualOperatorNumber = originalOperatorNumber;
		}
		if(!isValidSimCardNumber(simCardNumber)) {
			//ndalohet krijimi i objektit
			//gjej numrin e radhes te vlefshem per 
			//operatorin origjinal
			simCardNumber = newOperatorSimCardNumber(originalOperatorNumber);
		}
		while(exists(originalOperatorNumber, simCardNumber)) {
			simCardNumber = newOperatorSimCardNumber(originalOperatorNumber) ;
		}
		this.actualOperatorNumber = (byte) actualOperatorNumber;
		this.originalOperatorNumber = (byte) originalOperatorNumber;
		this.simCardNumber = simCardNumber;
		PHONE_NUMBERS.add(this);
	}
	
	public void setActualOperatorNumber(byte actualOperatorNumber) {
		if(isValidAlbanianOperator(actualOperatorNumber)) {
			this.actualOperatorNumber = actualOperatorNumber;
		}
	}
	
	public byte getActualOperatorNumber() {
		return actualOperatorNumber;
	}
	
	public byte getOriginalOperatorNumber() {
		return originalOperatorNumber;
	}
	
	public int getSimCardNumber() {
		return simCardNumber;
	}

	private static int newOperatorSimCardNumber(int operatorNumber) {
		int newSimCardNumber = (int) Util.randomValue(MIN_SIM_CARD_NUMBER, MAX_SIM_CARD_NUMBER);
		while(exists(operatorNumber, newSimCardNumber)) {
			newSimCardNumber = (int) Util.randomValue(MIN_SIM_CARD_NUMBER, MAX_SIM_CARD_NUMBER);
		}
		return newSimCardNumber;
	}

	private static boolean isValidSimCardNumber(int simCardNumber) {
		if(simCardNumber < MIN_SIM_CARD_NUMBER) {
			return false;
		}
		if(simCardNumber > MAX_SIM_CARD_NUMBER) {
			return false;
		}
		return true;
	}
	
	private static boolean exists(int originalOperatorNumber, int simCardNumber) {
		for(PhoneNumber phone : PHONE_NUMBERS) {
			if(phone.originalOperatorNumber == originalOperatorNumber && 
			   phone.simCardNumber == simCardNumber) {
				return true;
			}
		}
		return false;
	}

	private static boolean isValidAlbanianOperator
				(int actualOperatorNumber) {
//		if(actualOperatorNumber == ALBTELECOM_OPERATOR_NUMBER ||
//		   actualOperatorNumber == ONE_OPERATOR_NUMBER || 
//		   actualOperatorNumber == VODAFONE_OPERATOR_NUMBER) {
//			return true;
//		}
//		return false;
		return actualOperatorNumber == ALBTELECOM_OPERATOR_NUMBER ||
			   actualOperatorNumber == ONE_OPERATOR_NUMBER || 
			   actualOperatorNumber == VODAFONE_OPERATOR_NUMBER;
	}
	
}







