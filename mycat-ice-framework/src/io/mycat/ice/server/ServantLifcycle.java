package io.mycat.ice.server;

import Ice.ObjectAdapter;

/**
 * Servant�������ڽӿ�
 * 
 * @author wuzhih
 *
 */
public interface ServantLifcycle {
	/**
	 * Servant�ṩ����֮ǰ�ᱻ�����˽ӿڵ��ã��������ڳ�ʼ����Դ�����罨�����ӳص�
	 */
	public void init(ObjectAdapter adapter);
	/**
	 * Servant�����ٵ�ʱ�򴥷��˵��ã������ͷ���Դ
	 */
	public void destroy();
}
