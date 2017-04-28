package com.zyd.poi;

import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

import com.zyd.poi.utils.PoiUtil;

//@RunWith(SpringRunner.class)
//@SpringBootTest()
public class AppTest {

//	@Test
	public void test() throws Exception {
		String tmpFile = "classpath:conf/template.doc";
		System.out.println(ResourceUtils.getFile(tmpFile).exists());
	}
	
//	@Test
	public void test1() throws Exception {
		URL fileURL=this.getClass().getResource("/conf/template.doc"); 
	    System.out.println(fileURL.getFile());
	}
	
	

	
//	@Test
	public void testExportWord() throws Exception {
		String tmpFile = "classpath:conf/template.doc";
		Map<String, Object> map = getMap();
		String expFile = "D:/员工绩效考核表_产研技术岗-" + map.get("name") + "(" + map.get("year") + "-" + map.get("month") + "-"
				+ map.get("day") + ").doc";
		PoiUtil.build(ResourceUtils.getFile(tmpFile), map, expFile);
	}

	private Map<String, Object> getMap() {
		Map<String, Object> datas = new HashMap<String, Object>();
		datas.put("name", "张亚东");
		datas.put("depart", "软件研发部");
		datas.put("position", "软件工程师");
		datas.put("jobContent", "  测试\r  测试\r  测试\r  测试\r");
		datas.put("performance", "   测试\r  测试\r  测试\r  测试\r");
		datas.put("power", "  测试\r  测试\r  测试\r  测试\r");
		datas.put("learnSituation", "  测试\r  测试\r  测试\r  测试\r");
		datas.put("suggestion", "  测试\r  测试\r  测试\r  测试\r");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		datas.put("year", c.get(Calendar.YEAR));
		datas.put("month", c.get(Calendar.MONTH) + 1);
		datas.put("day", c.get(Calendar.DAY_OF_MONTH));
		return datas;
	}
}
