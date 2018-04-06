import static org.junit.Assert.*;

import org.junit.Test;

public class unittests {
	
	@Test
	public void test1() {// get balance
		double output = AtmMachine.balances();
		assertEquals(150000, output, 1);
		
	}
	
	@Test
	public void test2() {// deposit valid amount
		double output = AtmMachine.depositing("40000");
		assertEquals(190000, output, 1);
		
	}
	
	@Test
	public void test3() {// deposit invalid amount
		double output = AtmMachine.depositing("0");
		assertEquals(190000, output, 1);
	}
	
	@Test
	public void test4() {//deposit more than allowed amount
		double output = AtmMachine.depositing("50000");
		assertEquals(190000, output, 1);
	}
	
	@Test
	public void test5() {//withdraw correct amount
		double output = AtmMachine.withdrawing("20000");
		assertEquals(170000, output, 1);
		
	}
	
	@Test
	public void test6() {//withdraw more than allowed amount
		double output = AtmMachine.withdrawing("60000");
		assertEquals(170000, output, 1);
		
	}
	
	@Test
	public void test7() {//withdraw less than allowed amount
		double output = AtmMachine.withdrawing("0");
		assertEquals(170000, output, 1);
		
	}

}
