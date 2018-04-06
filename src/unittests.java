import static org.junit.Assert.*;

import org.junit.Test;

public class unittests {
	
	@Test
	public void deposit() {
		double output = AtmMachine.depositing("40000");
		assertEquals(190000, output, 1);
		
	}
	@Test
	public void depositless() {
		double output = AtmMachine.depositing("0");
		assertEquals(190000, output, 1);
	}
	
	@Test
	public void depositmore() {
		double output = AtmMachine.depositing("50000");
		assertEquals(190000, output, 1);
	}
	
	@Test
	public void withdrawal() {
		double output = AtmMachine.withdrawing("20000");
		assertEquals(170000, output, 1);
		
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void withdrawalless() {
		double output = AtmMachine.withdrawing("0");
		assertEquals("Withdrawal amount is less than the Minimum allowed amount of Ksh 1.", output, 1);
		
	}
	@Test
	public void withdrawalmore() {
		double output = AtmMachine.withdrawing("40000");
		assertEquals(170000, output, 1);
		
	}
}
