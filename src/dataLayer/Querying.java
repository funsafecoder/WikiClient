package dataLayer;

import java.util.ArrayList;

import mongoConnection.MongoIO;

public class Querying 
{
<<<<<<< HEAD
	private MongoIO io = new MongoIO("168.63.148.44", 27017, "wiki", "pages");
=======
	private MongoIO io = new MongoIO("168.63.148.117", 27019, "wiki", "pages");
>>>>>>> 33d03b1fab5366170f49a71068a7fbcc5acccb65
	public Boolean CheckTitle(String title)
	{
		boolean PageExist = true;
		if(io.findPage(title).getPageTitle().equals("")){
			PageExist = false;
		}
		return PageExist;
	}
<<<<<<< HEAD
	
	public Page getPageByTitle(String title)
	{
		
=======

	public Page getPageByTitle(String title)
	{

>>>>>>> 33d03b1fab5366170f49a71068a7fbcc5acccb65
		Page page = io.findPage(title);
		if(title.equals("")){
			page = null;
		}
		return page;
	}
<<<<<<< HEAD
	
=======

>>>>>>> 33d03b1fab5366170f49a71068a7fbcc5acccb65
	public ArrayList<String> getPagesByKeyword(String keyword)
	{
		ArrayList<String> titles = new ArrayList<String>();
		//query for Pages that have keyword
		//Page page = current Page queried
		//titles.add(page.getPageTitle);
<<<<<<< HEAD
			//Get digest from page.Content 
=======
			//Get digest from page.Content
>>>>>>> 33d03b1fab5366170f49a71068a7fbcc5acccb65
				///make sure to print the first time key word appears only
			//sort so that pages with most references to keyword are first

		return titles;
	}
}
