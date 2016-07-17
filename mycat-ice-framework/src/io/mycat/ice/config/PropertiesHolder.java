package io.mycat.ice.config;

import java.util.HashMap;
import java.util.Map;

/**
 * �������ñ��������ñ�����������Zookeeper,Database����ĳ���ļ�
 * 
 * @author wuzhih
 *
 */
public class PropertiesHolder {
	private Map<String, String> propMap=new HashMap<String, String>();
	private Map<String, PropUpdatedHandler> propUpdatedHandlerMap = new HashMap<String, PropUpdatedHandler>();



	public String getPropValue(String propName) {
		return propMap.get(propName);

	}
	/**
	 * ���������ڱ仯�����ñ���������ص��ӿڣ������������仯�󣬱���ʱ֪ͨ�޸ĸ�ֵ
	 * @param propName
	 * @param updatedHandler
	 * @return
	 */
	public String getPropValue(String propName, PropUpdatedHandler updatedHandler) {
		if (updatedHandler != null) {
			synchronized (propUpdatedHandlerMap) {
				propUpdatedHandlerMap.put(propName, updatedHandler);
			}
		}

		return getPropValue(propName);
	}
}
