package model.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	
	private int numberOfContract;
	private Date start;
	private double valueOfContract;
	
	private List<Installment> installments = new ArrayList<>();
	
	public Contract() {
		
	}
	public Contract(int numberOfContract, Date start, double valueOfContract) {
		this.numberOfContract = numberOfContract;
		this.start = start;
		this.valueOfContract = valueOfContract;
		
		
	}
	public int getNumberOfContract() {
		return numberOfContract;
	}
	public void setNumberOfContract(int numberOfContract) {
		this.numberOfContract = numberOfContract;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public double getValueOfContract() {
		return valueOfContract;
	}
	public void setValueOfContract(double valueOfContract) {
		this.valueOfContract = valueOfContract;
	}
	public List<Installment> getInstallment(){
		return installments;
		
	}
	public void addinstallment(Installment installment ) {
		
		installments.add(installment);
		
	}
	public void remove(Installment installment ) {
		
		installments.remove(installment);
		
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Installment i: installments) {
			sb.append(sdf.format(i.getDueDate() ) + " - " + String.format("%.2f", i.getAmount()) + "\n" );
		}
		return sb.toString();
	}
	
	
	
	
	
	
	
	
	
}
