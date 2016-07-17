package io.mycat.ice.server;
import Ice.Object;
/**
 * ����һ��servant�࣬���㱾�ز�����
 * @author wuzhih
 *
 */
public class GenServantRunner {

	public static void main(String[] args) {
		if(args.length<2)
		{
			System.out.println("Missing params: serviceName servantClassName \r\n Example:\r\n  MyService com.my.demo.MyServiceImpl");
			System.exit(-1);
		}
		String serviceName=args[0];
		String servantClass=args[1];
		int status = 0;
		Ice.Communicator ic = null;
		try {
			
			ic = Ice.Util.initialize();
			// ������ΪMyServiceAdapter��ObjectAdapter��ʹ��ȱʡ��ͨ��Э�飨TCP/IP �˿�Ϊ20000������
			Ice.ObjectAdapter adapter = ic.createObjectAdapterWithEndpoints(
					serviceName+"Adapter", "default -p 20000");
			// ʵ����һ���������(Servant)
			 Ice.Object servant =(Object) Class.forName(servantClass).newInstance();
			// ��Servant���ӵ�ObjectAdapter�У�����Servant������IDΪMyService��Ice Object
			adapter.add(servant, Ice.Util.stringToIdentity(serviceName));
			// ����ObjectAdapter
			adapter.activate();
			// �÷������˳�֮ǰ��һֱ����������ļ���
			System.out.print("server started for "+serviceName);
			ic.waitForShutdown();
		} catch (Exception e) {
			e.printStackTrace();
			status = 1;
		} finally {
			if (ic != null) {
				ic.destroy();
			}
		}
		System.exit(status);
	}

}
