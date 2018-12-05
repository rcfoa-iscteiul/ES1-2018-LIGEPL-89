package twitterexample;


public class Twitter_test {

	@Test
	public void test() {
		TwitterES tm = new TwitterES("");
		Assert.assertNotNull(tm);
	}

}