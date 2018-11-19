package Interface;

import org.junit.jupiter.api.Test;

class Appl_test {

	@Test
	void test() {
		Appl test = new Appl();
		Appl compare = test.getThis();
		assert(compare) != null ;
	}

}