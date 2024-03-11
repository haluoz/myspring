import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author Xingjing.Li
 * @since 2/29/2024
 */
public class HtmlParseTest {
	public static void main(String[] args) {
//		String s = new String("哈哈哈哈哈哈 " +
//				"<p><img src=\"http://testtas6.cepin.com/test/M00/0D/3E/rBAGgGXdmZaAVoWpAAADHlXB4OE232.png\" alt=\"\" data-href=\"\" style=\"\"/></p>" +
//				"<p><img src=\"http://testtas6.cepin.com/test/M00/0D/3E/rBAGgGXdmZmAIPUnAAADHlXB4OE433.png\" alt=\"\" data-href=\"\" style=\"\"/></p>" +
//				"<p><img src=\"http://testtas6.cepin.com/test/M00/0D/3E/rBAGgGXdmZmAN5WNAAADHlXB4OE307.png\" alt=\"\" data-href=\"\" style=\"\"/></p>" +
//				"<p><img src=\"http://testtas6.cepin.com/test/M00/0D/3E/rBAGgGXdmZqASj1LAAADHlXB4OE953.png\" alt=\"\" data-href=\"\" style=\"\"/>212121212</p>");
//		Document doc = Jsoup.parse(s);
//		Elements imgTags = doc.select("img");
//		for (Element imgTag : imgTags) {
//			String src = imgTag.attr("src");
//			String alt = imgTag.attr("alt");
//			System.out.println("Image Source: " + src);
//			System.out.println("Alt Text: " + alt);
//		}
//		List<Integer> integers = new ArrayList<>();
//		integers.add(1);
//		integers.add(2);
//		integers.add(3);
//		System.out.println(integers.toString());
		AtomicStampedReference<java.lang.String> atomicStamped = new AtomicStampedReference<>("aaa", 1);
		int stamp = atomicStamped.getStamp();
		java.lang.String reference1 = atomicStamped.getReference();
		System.out.println(stamp);
		System.out.println(reference1);
		atomicStamped.set("aaa", stamp+1);
		atomicStamped.set("bbb", stamp +1);
		stamp = atomicStamped.getStamp();
		reference1 = atomicStamped.getReference();
		System.out.println(stamp);
		System.out.println(reference1);
	}
}
