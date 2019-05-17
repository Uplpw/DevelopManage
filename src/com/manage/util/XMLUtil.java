package com.manage.util;

import java.io.File;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class XMLUtil {

	/**
	 * 
	 * @return 读取数据库配置文件mysqlConfig.xml,并返回相应map
	 */
	public static HashMap<String, String> getBean() {
		try {
			String path = "D:\\soft_application\\eclipse\\program_codes\\AgileManage\\WebContent\\WEB-INF\\mysqlConfig.xml";
			//"D:\\soft_application\\eclipse\\program_codes\\AgileManage\\WebContent\\WEB-INF"
			DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document document = dBuilder.parse(new File(path));

			String ip = document.getElementsByTagName("ip").item(0).getFirstChild().getNodeValue();
			String port = document.getElementsByTagName("port").item(0).getFirstChild().getNodeValue();
			String database = document.getElementsByTagName("database").item(0).getFirstChild().getNodeValue();
			String user = document.getElementsByTagName("user").item(0).getFirstChild().getNodeValue();
			String password = document.getElementsByTagName("password").item(0).getFirstChild().getNodeValue();

			HashMap<String, String> rst = new HashMap<>();
			rst.put("ip", ip);
			rst.put("port", port);
			rst.put("database", database);
			rst.put("user", user);
			rst.put("password", password);
			return rst;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
