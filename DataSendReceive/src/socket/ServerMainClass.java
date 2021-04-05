package socket;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
/**
 * ������Ʈ�� : DataSendReceive
 * ���ϸ� : ServerMainClass
 * �ۼ��� : ȫ����
 * �ۼ����� : 2021/04/05
 * ���� : ��������, Ŭ�󸮾�Ʈ�� �����ϴ°�Ȯ��, Ŭ���̾�Ʈ�κ��Ϳ� �޽��� �ޱ�
 * @author ITSC
 *
 */

public class ServerMainClass {

	public static void main(String[] args) {
		ServerSocket server = null;
		Socket client = null;
		BufferedInputStream bis = null;
		Scanner sc =null;
		BufferedOutputStream bos = null;
		try {
			server = new ServerSocket();
			server.bind(new InetSocketAddress("localhost", 1234));
			
			while(true) {
				System.out.println("=====���� ���� ====");
				client = server.accept();
				InetSocketAddress isa = (InetSocketAddress)client.getRemoteSocketAddress();
				System.out.println("���� Ŭ���̾�Ʈ : " + isa.getHostName());
				
				bis = new BufferedInputStream(client.getInputStream());
				byte[]b = new byte[1024];
				int length = bis.read(b);
				String rem = new String(b, 0, length, "UTF-8");
				System.out.println(rem);
				

			}
		}catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}finally {
			try {
				if(bis != null)bis.close();
				if(!server.isClosed()) {
					server.isClosed();
				}
			}catch (Exception e) {
				e.printStackTrace();// TODO: handle exception
			}
		}

	}

}
