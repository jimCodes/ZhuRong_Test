//package configParse;
//
//import java.io.File;
//import java.util.Iterator;
//
//import org.dom4j.Document;
//import org.dom4j.DocumentException;
//import org.dom4j.Element;
//import org.dom4j.io.SAXReader;
//
//public class Test {
//	public static void main(String[] args) throws DocumentException {
//		
//		List<Integer> scenList = new ArrayList<>
//		//<scene troopId="1" fishId="1" fishType="0" attachFishType="0" p_x="0" p_y="0" />
//		Document document = new SAXReader().read(new File("fish_troop_config.xml"));
//			
//		//<scene sceneId="1" troopId="1" startTime="1200" p_x="0" p_y="10945" swimLineId="1" repeatTime="1" />
//		Document document2 = new SAXReader().read(new File("fish_scene_troop.xml"));
//		
//		for (@SuppressWarnings("unchecked")
//		Iterator<Element> it = document.getRootElement().elements()
//				.iterator(); it.hasNext();) {
//			Element el = it.next();
//			int troop_id = Integer.parseInt(el.attributeValue("troopId"));
//			short fish_id = Short.parseShort(el.attributeValue("fishId"));
//			byte fish_type = Byte.parseByte(el.attributeValue("fishType"));
//			byte attach_fish_type = Byte.parseByte(el.attributeValue("attachFishType"));
//			int p_x = Integer.parseInt(el.attributeValue("p_x"));
//			int p_y = Integer.parseInt(el.attributeValue("p_y"));
//		}
//		
//		for (@SuppressWarnings("unchecked")
//		Iterator<Element> it = document2.getRootElement().elements()
//				.iterator(); it.hasNext();) {
//			Element el = it.next();
//			short scene_id = Short.parseShort(el.attributeValue("sceneId"));
//			int troop_id = Integer.parseInt(el.attributeValue("troopId"));
//			System.out.println(troop_id);
//			int startTime = Integer.parseInt(el.attributeValue("startTime"));
//			int p_x = Integer.parseInt(el.attributeValue("p_x"));
//			int p_y = Integer.parseInt(el.attributeValue("p_y"));
//			int swimLineId = Integer.parseInt(el.attributeValue("swimLineId"));
//			int repeatTime = Integer.parseInt(el.attributeValue("repeatTime"));
//		}
//		
//		
////<scene sceneId="1" troopId="1" fishId="1" fishType="3" attachType="0" startTime="4220" swimTime="21000"
////		p_x="-450" p_y="5280" swimLineId="1" repeatTime="1" electricId="1"/>
//
//		
//	}
//}
