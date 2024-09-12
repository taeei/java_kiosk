package torder;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MasterOrder {
	public static void main(String[] args) {
		
		Frame f = new Frame();
		f.setLayout(null);                   
		f.setBounds(100, 100, 1000, 500);     //마스터 오더 창 크기
		f.setBackground(new Color(13,13,13)); //마스터 오더 창 색상
		
		Panel ui_top = new Panel(); //상단 ui
		ui_top.setBounds(0, 25, 1000, 10);
		ui_top.setBackground(new Color(242, 5, 5));
		
		
		
		Label top_logo = new Label("KH_Izakaya"); //왼쪽 상단 로
		Font font8 = new Font("", Font.BOLD, 30); //왼쪽 상단 로고 폰트
		top_logo.setBounds(80, 52, 100, 30);      //왼쪽 상단 로고 위치
		top_logo.setForeground(Color.WHITE);      //왼쪽 상단 로고 글자 색상
		top_logo.setFont(font8);                  //왼쪽 상단 로고 폰트 적용
		
		
		
		f.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		}); // 종료 버튼

		f.add(ui_top); //상단 ui 패널
		f.setVisible(true);
	}
}
