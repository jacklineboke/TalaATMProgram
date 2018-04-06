import static org.junit.Assert.*;

import org.junit.Test;

public class unittests {
	
	@Test
	public void bal() {
		double output = AtmMachine.balances();
		assertEquals(150000, output, 1);
		
	}
	
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
	
	@Test
	public void withdrawalmore() {
		double output = AtmMachine.withdrawing("60000");
		assertEquals(170000, output, 1);
		
	}
	
	@Test
	public void withdrawalless() {
		double output = AtmMachine.withdrawing("0");
		assertEquals(170000, output, 1);
		
	}

}
