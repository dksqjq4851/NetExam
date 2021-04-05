package socket;

import java.io.BufferedOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * 프로젝트명 : DataSendReceive
 * 파일명 : ClientMainClass
 * 작성자 : 홍성혁
 * 작성일자 : 2021/04/05
 * 설명 : 서버 접속하기, 서버에 메시지 보내기
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
			System.out.println("서버에 접속되었습니다.");
			sc = new Scanner(System.in);
			System.out.println("서버에게 전송할 메세지를 입력하세요");
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
		
	