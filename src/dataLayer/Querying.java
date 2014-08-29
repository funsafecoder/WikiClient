package dataLayer;

import java.util.ArrayList;

import mongoConnection.MongoIO;

public class Querying 
{
	private MongoIO io = new MongoIO("168.63.148.117", 27019, "wiki", "pages");
	public Boolean CheckTitle(String title)
	{
		boolean PageExist = true;
		if(io.findPage(title).getPageTitle().equals("")){
			PageExist = false;
		}
		return PageExist;
	}


	public Page getPageByTitle(String title)
	{

		Page page = io.findPage(title);
		if(title.equals("")){
			page = null;
		}
		return page;
	}

	public ArrayList<String> getPagesByKeyword(String keyword)
	{
		ArrayList<String> titles = new ArrayList<String>();
		//query for Pages that have keyword
		//Page page = current Page queried
		//titles.add(page.getPageTitle);
				///make sure to print the first time key word appears only
			//sort so that pages with most references to keyword are first

		return titles;
	}
}
