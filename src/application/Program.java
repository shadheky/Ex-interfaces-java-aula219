package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.services.ContractService;
import model.services.PayPalService;

public class Program {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		try{System.out.println("Enter contract data: ");
		System.out.print("Number ");
		int numberOfContract = sc.nextInt();
		System.out.print("Date (dd/MM/yyyy): ");
		sc.nextLine();
		Date start = sdf.parse(sc.nextLine());
		System.out.print("Contract value: ");
		Double valueOfContract = sc.nextDouble();
		
		Contract contract = new Contract(numberOfContract,start,valueOfContract);
		System.out.print("Enter number of installments: ");
		int months = sc.nextInt();
		
		ContractService cs = new ContractService(new PayPalService());
		
		cs.processContract(contract, months);
		
		
		System.out.println("Installments:");
		System.out.println(contract);
		
		}catch(ParseException p) {
			System.out.println("ERROR: INVALID DATE");
		}catch(RuntimeException r) {
			System.out.println("Unexpected ERROR");
		}
		
		
		sc.close();
		

	}

}
