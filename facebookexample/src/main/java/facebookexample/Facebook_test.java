package facebookexample;

import static org.junit.Assert.*;

import org.junit.Test;

public class Facebook_test {

	@Test
	public void test() {
		Facebook test = new Facebook("");
		String token = test.getAcessToken();
		assert (token) != null;
	}

}
