package torder;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Torder {
	public static void main(String[] args) {
		Frame f = new Frame();
		f.setLayout(null);                   
		f.setBounds(100, 100, 1000, 500);     //마스터 오더 창 크기 
		f.setBackground(new Color(13,13,13)); //마스터 오더 창 색상
		
		Panel ui_top = new Panel(); //상단 ui
		ui_top.setBounds(0, 25, 1000, 10);
		ui_top.setBackground(new Color(242, 5, 5));
		
		Label top_logo = new Label("="); 			  //왼쪽 상단 로고(=)
		Font logo_font = new Font("", Font.BOLD, 30); //왼쪽 상단 로고 폰트
		top_logo.setBounds(40, 40, 30, 50);      	  //왼쪽 상단 로고 위치
		top_logo.setForeground(Color.WHITE);      	  //왼쪽 상단 로고 글자 색상
		top_logo.setFont(logo_font);                  //왼쪽 상단 로고 폰트 적용
		
		Label top_logo2 = new Label("KH_Izakaya"); 		//왼쪽 상단 로고(kh)
		Font logo_font2 = new Font("", Font.BOLD, 15);  //왼쪽 상단 로고 폰트
		top_logo2.setBounds(80, 52, 100, 30);      		//왼쪽 상단 로고 위치
		top_logo2.setForeground(Color.WHITE);      		//왼쪽 상단 로고 글자 색상
		top_logo2.setFont(logo_font2);                  //왼쪽 상단 로고 폰트 적용
		
		Font menu = new Font("", Font.BOLD, 20); 		//메뉴 버튼 폰트
		Button m_menu = new Button("메인메뉴");			//메인메뉴 버튼 
		m_menu.setFont(menu);
		m_menu.setBounds(30, 100, 150, 50);
		
		Button s_menu = new Button("세트메뉴");			//세트메뉴 버튼
		s_menu.setFont(menu);
		s_menu.setBounds(30, 160, 150, 50);
		
		Label menu_ui = new Label("|");					//번트 옆 ui
		menu_ui.setBounds(200, 95, 50, 50);
		menu_ui.setForeground(Color.RED);
		menu_ui.setFont(menu);
		
		Button call = new Button("직원호출");				//직원 호출 버튼 
		call.setFont(menu);
		call.setBackground(new Color(242, 5, 5));
		call.setBounds(30, 430, 150, 50);
		
		
		f.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		}); // 종료 버튼

		f.add(ui_top); //상단 ui 패널
		f.add(top_logo);
		f.add(top_logo2);
		f.add(menu_ui);
		f.add(call);
		f.add(m_menu);
		f.add(s_menu);
		f.setVisible(true);
	}

	}
