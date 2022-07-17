package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {

	private PaymentService paymentService;

	public ContractService(PaymentService paymentService) {
		
		this.paymentService = paymentService;
	}

	public PaymentService getPaymentService() {
		return paymentService;
	}

	public void setPaymentService(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
	
	
	public void processContract(Contract contract, int months) {
		double[] amount = paymentService.interest(contract.getValueOfContract(), months);
		Calendar c = Calendar.getInstance();
		c.setTime(contract.getStart());
		for(int i = 0; i < amount.length ; i ++) {
			c.add(Calendar.MONTH, 1);
			Date aux = c.getTime();
			contract.addinstallment(new Installment(aux,amount[i]));
		}
		
	}
	
}
