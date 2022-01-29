package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Financing;
import tests.factories.FinancingFactory;

public class FinancingTests {
	
	@Test
	public void constructorShouldCreateObjectWithCorrectDataWhenDataIsValid() {
		
		Double totalAmount = 100000.0;
		Double income = 2000.0;
		Integer months = 80;
		
		Financing fin = FinancingFactory.create(totalAmount, income, months);
		
		Assertions.assertEquals(totalAmount, fin.getTotalAmount());
		Assertions.assertEquals(income, fin.getIncome());
		Assertions.assertEquals(months, fin.getMonths());
	}
	
	@Test
	public void constructorShouldThrowsExceptionWhenDataIsInvalid() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {			
			FinancingFactory.create(100000.0, 2000.0, 20);
		});		
	}
	
	@Test
	public void setTotalAmountShouldUpdateDataWhenAmountIsValid() {
		
		Double setTotalAmount = 5000.0;
		Financing fin = FinancingFactory.create(100000.0, 2000.0, 80);
		
		fin.setTotalAmount(setTotalAmount);
		
		Assertions.assertEquals(setTotalAmount, fin.getTotalAmount());
	}
	
	@Test
	public void setTotalAmountShouldThrowsExceptionWhenAmountIsInvalid() {
		
		Financing fin = FinancingFactory.create(100000.0, 2000.0, 80);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			fin.setTotalAmount(100001.0);
		});
	}
	
	@Test
	public void setIncomeShouldUpdateIncomeWhenIncomeIsValid() {
		
		Double setIncome = 2001.0;
		Financing fin = FinancingFactory.create(100000.0, 2000.0, 80);
		
		fin.setIncome(setIncome);
		
		Assertions.assertEquals(setIncome, fin.getIncome());
	}
	
	@Test
	public void setIncomeShouldThrowsExceptionWhenIncomeIsInvalid() {
		
		Financing fin = FinancingFactory.create(100000.0, 2000.0, 80);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			fin.setIncome(1999.0);
		});
	}
	
	@Test
	public void setMonthsShouldUpdateMonthsWhenMonthsIsValid() {
		
		Integer setMonths = 81;
		Financing fin = FinancingFactory.create(100000.0, 2000.0, 80);
		
		fin.setMonths(setMonths);
		
		Assertions.assertEquals(setMonths, fin.getMonths());
	}
	
	@Test
	public void setMonthsShouldThrowsExceptionWhenMonthsIsInvalid() {
		
		Financing fin = FinancingFactory.create(100000.0, 2000.0, 80);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			fin.setMonths(79);
		});
	}
	
	@Test
	public void entryShouldCalculateEntryValueCorrectly() {
		
		Double totalAmount = 100000.0;
		Financing fin = FinancingFactory.create(totalAmount, 2000.0, 80);
		Double entryExpected = totalAmount * 0.2;
		
		Double entry = fin.entry();
		
		Assertions.assertEquals(entry, entryExpected);
	}
	
	@Test
	public void quotaShouldCalculateQuotaValueCorrectly() {
		
		Double totalAmount = 100000.0;
		Integer months = 80;
		Financing fin = FinancingFactory.create(totalAmount, 2000.0, months);
		Double quotaExpected = (totalAmount - fin.entry()) / months;
		
		Double quota = fin.quota();
		
		Assertions.assertEquals(quota, quotaExpected);
	}
}
