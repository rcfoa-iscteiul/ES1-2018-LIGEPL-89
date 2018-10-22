package twitterexample;


import java.awt.EventQueue;
import java.util.List;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public final class TwitterMain  {
	
	
	public static void main(String[] args) {

			
				try {
					App frame = new App();
					frame.setVisible(true);
					
		            System.out.println("------------------------\n Showing home timeline \n------------------------");
		    		
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		
		
//public void search() {
//	int counter=0;
//	int counterTotal = 0;
//    for (Status status : statuses) {
//		if (status.getUser().getName() != null && status.getUser().getName().contains("Correio")) {
//		//	if(frame.getCheckTwitter().isSelected()) {
//			frame.getTextarea().append(status.getUser().getName() + ":" + status.getText()+"\n");
//			counter++;
//			//}
//		}
//		counterTotal++;
//    }
//	System.out.println("-------------\nNº of Results: " + counter+"/"+counterTotal);
//}
}

    

