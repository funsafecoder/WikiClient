package dataLayer;

import org.apache.commons.lang3.text.WordUtils;
import org.eclipse.mylyn.wikitext.confluence.core.ConfluenceLanguage;
import org.eclipse.mylyn.wikitext.core.parser.MarkupParser;
import org.eclipse.mylyn.wikitext.mediawiki.core.MediaWikiLanguage;
import org.eclipse.mylyn.wikitext.textile.core.TextileLanguage;
import org.eclipse.mylyn.wikitext.twiki.core.TWikiLanguage;


public class Page 
{
	private String pageTitle;
	private String content;
	
	public static void main(String[] args) {
		System.out.println(new Querying().getPageByTitle("TeleNav"));
	}

	public String getPageTitle() {
		return pageTitle;
	}
	
	private void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}
	
	public String getContent() {
		return content;
	}
	
	public String getPlainTextContent(){
		String filtered = stripBlock(content, "{{", "}}");
		filtered = stripBlock(filtered, "<ref", "</ref>");
		filtered = stripBlock(filtered, "<math", "</math>");
		filtered = stripBlock(filtered, "__", "__");
		filtered = filtered.replaceAll("(=+?)([^=]+?)\\1", "\n\n$2:\n");
		filtered = filtered.replaceAll("\\*(.*?)(:?\\*|\n)", "\n •$1");
		//filtered = filtered.replaceAll("(•(.*)\n)(:? [^( •)])", "$1\n");
		filtered = filtered.replaceAll("('+)([^=]+?)\\1", "*$2*");
		filtered = filtered.replaceAll("\\[\\[.*?\\|?(.+?)?\\]\\]", "$1");
		filtered = filtered.replaceAll("(�€�)|(�€\\?)", "'");
		filtered = filtered.replaceAll("�„�", "™");
		filtered = filtered.replaceAll("�€“", "–");
		filtered = filtered.replaceAll("\n{3,}", "\n\n");
		System.out.println(filtered);
		return filtered;
	}
	
	private String stripBlock(String input, String start, String end){
		int count = 0;
		String output = "";
		for(int i = 0; i < input.length(); i++){
			String spot = input.substring(i, Math.min(Math.max(start.length(), end.length()), input.length()-i)+i);
			if(spot.startsWith(end) && count > 0){
				count--;
				i+=end.length()-1;
				continue;
			}
			if(spot.startsWith(start)) {
				count++;
				i+=start.length()-1;
				continue;
			}
			
			if(count == 0){
				output += spot.charAt(0);
			}
		}
		return output;
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
		//result += pageTitle + "\n";
		
		//result += getPlainTextContent(); //WordUtils.wrap(getPlainTextContent(), 80);
		
		result += WordUtils.wrap(getPlainTextContent(), 80);
		return result;
	}
}