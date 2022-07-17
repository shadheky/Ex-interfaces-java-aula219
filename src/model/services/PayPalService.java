package model.services;

public class PayPalService implements PaymentService {
		
	

	@Override
	public double[] interest(double amount, int months) {
		double[] taxes = new double[months];
		for(int i = 0 ; i < taxes.length ; i++) {
			double aux = amount/months  ;
			aux += aux*0.01*(i+1);
			aux += aux*0.02;
			taxes[i] = aux;
		}
		
		return taxes;
	}

}
