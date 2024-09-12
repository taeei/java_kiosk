package torder;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class Torder {
	public static void main(String[] args) {
		Frame f = new Frame();
		f.setLayout(null);                   
		f.setBounds(200, 170, 1500, 750);     //마스터 오더 창 크기 
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
		top_logo2.setForeground(Color.WHITE);       	//왼쪽 상단 로고 글자 색상
		top_logo2.setFont(logo_font2);                  //왼쪽 상단 로고 폰트 적용
		
		Font menu = new Font("", Font.BOLD, 20); 		//메뉴 버튼 폰트
		Button m_menu = new Button("메인메뉴");			//메인메뉴 버튼 
		m_menu.setFont(menu);
		m_menu.setBounds(30, 100, 150, 50);
		
		Button s_menu = new Button("사이드메뉴");			//사이드메뉴 버튼
		s_menu.setFont(menu);
		s_menu.setBounds(30, 160, 150, 50);
		
		Button call = new Button("직원호출");				//직원 호출 버튼 
		call.setFont(menu);
		call.setBackground(new Color(242, 5, 5));
		call.setBounds(30, 670, 150, 50);
		
//- ------------------------------------ 메인 메뉴 ---------------------------------------
		JButton main_menu1 = new JButton("<HTML>한우타다끼<br>28000원</HTML>",
										new ImageIcon("img/한우타다끼.png"));
		main_menu1.setBounds(200, 100, 280, 250);
		main_menu1.setVerticalTextPosition(JButton.BOTTOM);			// 텍스트 가운데
		main_menu1.setHorizontalTextPosition(JButton.CENTER);		// 텍스트 아래로
		main_menu1.setForeground(Color.WHITE);
		main_menu1.setBorderPainted(false);
		main_menu1.setContentAreaFilled(false);
		
		JButton main_menu2 = new JButton("<HTML>밀푀유나베<br>28000원</HTML>",
				new ImageIcon("img/밀푀유나베.jpg"));
		main_menu2.setBounds(535, 100, 280, 250);
		main_menu2.setVerticalTextPosition(JButton.BOTTOM);
		main_menu2.setHorizontalTextPosition(JButton.CENTER);
		main_menu2.setForeground(Color.WHITE);
		main_menu2.setBorderPainted(false);
		main_menu2.setContentAreaFilled(false);
		
		JButton main_menu3 = new JButton("<HTML>차돌숙주볶음<br>24000원</HTML>",
				new ImageIcon("img/차돌숙주볶음.jpg"));
		main_menu3.setBounds(870, 100, 280, 250);
		main_menu3.setVerticalTextPosition(JButton.BOTTOM);
		main_menu3.setHorizontalTextPosition(JButton.CENTER);
		main_menu3.setForeground(Color.WHITE);
		main_menu3.setBorderPainted(false);
		main_menu3.setContentAreaFilled(false);
		
		JButton main_menu4 = new JButton("<HTML>가라아게<br>23000원</HTML>",
				new ImageIcon("img/가라아게.jpg"));
		main_menu4.setBounds(200, 380, 280, 250);
		main_menu4.setVerticalTextPosition(JButton.BOTTOM);
		main_menu4.setHorizontalTextPosition(JButton.CENTER);
		main_menu4.setForeground(Color.WHITE);
		main_menu4.setBorderPainted(false);
		main_menu4.setContentAreaFilled(false);
		
		JButton main_menu5 = new JButton("<HTML>술찜<br>27000원</HTML>",
				new ImageIcon("img/술찜.jpg"));
		main_menu5.setBounds(535, 380, 280, 250);
		main_menu5.setVerticalTextPosition(JButton.BOTTOM);
		main_menu5.setHorizontalTextPosition(JButton.CENTER);
		main_menu5.setForeground(Color.WHITE);
		main_menu5.setBorderPainted(false);
		main_menu5.setContentAreaFilled(false);
		
		JButton main_menu6 = new JButton("<HTML>오코노미야끼<br>24000원</HTML>",
				new ImageIcon("img/오코노미야끼.jpg"));
		main_menu6.setBounds(870, 380, 280, 250);
		main_menu6.setVerticalTextPosition(JButton.BOTTOM);
		main_menu6.setHorizontalTextPosition(JButton.CENTER);
		main_menu6.setForeground(Color.WHITE);
		main_menu6.setBorderPainted(false);
		main_menu6.setContentAreaFilled(false);
	
		f.add(main_menu1);
		f.add(main_menu2);
		f.add(main_menu3);
		f.add(main_menu4);
		f.add(main_menu5);
		f.add(main_menu6);
		
// ------------------------------------ 사이드 메뉴 --------------------------------------
		
		
		
	
		
						
		// 종료 버튼
		f.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		}); 

		f.add(ui_top); //상단 ui 패널
		f.add(top_logo);
		f.add(top_logo2);
		f.add(call);
		f.add(m_menu);
		f.add(s_menu);
		f.setVisible(true);

		
		
	}// main

}
