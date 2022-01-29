package tests.factories;

import entities.Financing;

public class FinancingFactory {
	
	public static Financing create(Double totalAmount, Double income, Integer months) {
		return new Financing(totalAmount, income, months);		
	}
}
