package io.mycat.ice.config;
/**
 * ��Prop��ֵ�����仯�󣬻ص�֪ͨ
 * @author wuzhih
 *
 */
public interface PropUpdatedHandler {

	public void valueChanged(String propName,String oldVal ,String newValue);
	
}
