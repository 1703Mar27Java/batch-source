package com.revature.minmutation;

import org.junit.Test;

public class MutationUtilityTest {
	
	@Test(expected = RuntimeException.class)
	public final void notRegLengthGene () {
		String[] C = {"A", "B"};
		MutationUtility newMU = new MutationUtility("A", "B", C);
		newMU.Result();
	}
}
