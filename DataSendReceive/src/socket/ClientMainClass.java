package socket;

import java.io.BufferedOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * ������Ʈ�� : DataSendReceive
 * ���ϸ� : ClientMainClass
 * �ۼ��� : ȫ����
 * �ۼ����� : 2021/04/05
 * ���� : ���� �����ϱ�, ������ �޽��� ������
 * @author ITSC
 *
 */
public class ClientMainClass {

	public static void main(String[] args) {
		Socket client = null;
		Scanner sc = null;
		BufferedOutputStream bos = null;
		try {
			client = new Socket();
			client.connect(new InetSocketAddress("localhost", 1234));
			System.out.println("������ ���ӵǾ����ϴ�.");
			sc = new Scanner(System.in);
			System.out.println("�������� ������ �޼����� �Է��ϼ���");
			String message = sc.nextLine();
			bos = new BufferedOutputStream(client.getOutputStream());
			bos.write(message.getBytes("UTF-8"));
			bos.flush();
			
			
		}catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}finally {
			try {
				if(bos!=null)bos.close();
				if(!client.isClosed()) {
					client.isClosed();
				}
			}catch (Exception e) {
				
				e.printStackTrace();// TODO: handle exception
			}
		}
	}
}
		
	