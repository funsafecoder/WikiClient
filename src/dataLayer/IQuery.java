package dataLayer;

import java.util.ArrayList;

public interface IQuery 
{
	public Boolean CheckTitle(String Title);
	
	public Page getPageByTitle(String title);
	
	public ArrayList<String> getPagesByKeyword(String keyword);
}
