package twitterexample;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class Twitter_test {

	@Test
	public void test() {
		TwitterES tm = new TwitterES("");
		Assert.assertNotNull(tm);
	}

}