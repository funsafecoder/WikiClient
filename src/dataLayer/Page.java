package dataLayer;

import org.apache.commons.lang3.text.WordUtils;

public class Page 
{
	private String pageTitle;
	private String content;
	
	public String getPageTitle() {
		return pageTitle;
	}
	
	private void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}
	
	public String getContent() {
		return content;
	}
	
	private void setContent(String content) {
		this.content = content;
	}
	
	public Page(String title, String content)
	{
		setPageTitle(title);
		setContent(content);
	}
	
	@Override
	public String toString(){
		String result = "";
		result += pageTitle + "\n";
		
		result += WordUtils.wrap(content, 80);
		return result;
	}
}