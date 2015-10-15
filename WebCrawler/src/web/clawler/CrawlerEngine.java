package web.clawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlerEngine {
	
	public void getCategories() {
		HashMap<Integer,ArrayList<String>> map_links = new HashMap<>();
		Document doc;
		int mapIndex = 0;
		try {
			doc = Jsoup.connect("http://www.basearticles.com/").get();
			
			Elements links = doc.select("a[href]");
			for (Element link : links) {
				
				if(link.attr("href").toLowerCase().contains("category")){
					ArrayList<String> temporary = new ArrayList<String>();
					temporary.add("http://www.basearticles.com" + link.attr("href"));
					temporary.add(link.text());
					mapIndex++;
					map_links.put(mapIndex,temporary);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	  }

}
