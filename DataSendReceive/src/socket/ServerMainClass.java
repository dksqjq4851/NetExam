package socket;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
/**
 * 프로젝트명 : DataSendReceive
 * 파일명 : ServerMainClass
 * 작성자 : 홍성혁
 * 작성일자 : 2021/04/05
 * 설명 : 서버생성, 클라리언트가 접속하는것확인, 클라이언트로부터온 메시지 받기
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
				System.out.println("=====서버 동작 ====");
				client = server.accept();
				InetSocketAddress isa = (InetSocketAddress)client.getRemoteSocketAddress();
				System.out.println("접속 클라이언트 : " + isa.getHostName());
				
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
