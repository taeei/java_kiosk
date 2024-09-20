package torder;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Point;
import java.awt.ScrollPane;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

public class Torder extends JFrame{
	public static void main(String[] args) {
		
		
		Frame f = new Frame();
		f.setLayout(null);                   
		f.setBounds(200, 170, 1500, 750);     //마스터 오더 창 크기 
		f.setBackground(new Color(13,13,13)); //마스터 오더 창 색상
		f.toBack();
		
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
		
// ----------------------- 메뉴 프레임 ---------------------------	
		
		JFrame mf = new JFrame("메뉴");
		mf.setBounds(380, 270, 1005, 630);
		mf.setBackground(Color.BLACK);
		
		// JPanel 생성
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 3)); // 수직으로 버튼 배치
		
		//메뉴 이름과 가격
		String[] mainName = {"<HTML>가라아게<br>23000원</HTML>", 
				"<HTML>밀푀유나베<br>28000원</HTML>", 
				"<HTML>술찜<br>27000원</HTML>", 
				"<HTML>오코노미야끼<br>24000원</HTML>",
				"<HTML>차돌숙주볶음<br>24000원</HTML>", 
		"<HTML>한우타다끼<br>28000원</HTML>"};
		
		String[] sideName = {"<HTML>계란말이<br>15000원</HTML>",
				"<HTML>고구마튀김<br>13000원</HTML>",
				"<HTML>문어튀김<br>26000원</HTML>", 
				"<HTML>숯불꼬치<br>29000원</HTML>", 
				"<HTML>타코와사비<br>29000원</HTML>",
		"<HTML>해물떡볶이<br>26000원</HTML>"};
		
		// 이미지 아이콘 경로
		String mainImagePath = "C:\\Users\\user1\\Desktop\\메인메뉴\\image";
		String sideImagePath = "C:\\Users\\user1\\Desktop\\사이드메뉴\\image";
		
		
		// 메인 메뉴 버튼 생성
		for (int i = 0; i < 6; i++) {
			JButton main_btn = new JButton(mainName[i],
					new ImageIcon(mainImagePath + (i % 4 + 1) + ".jpg"));
			panel.add(main_btn);
			main_btn.setBorder(BorderFactory.createEmptyBorder(15, 20, 100, 20));
			main_btn.setBackground(Color.BLACK);
			main_btn.setVerticalTextPosition(JButton.BOTTOM);			// 텍스트 위치 가운데
			main_btn.setHorizontalTextPosition(JButton.CENTER);		// 텍스트 위치 아래로
			main_btn.setForeground(Color.WHITE);
		}
		
		// 사이드 메뉴 버튼 생성
		for (int i = 0; i < 6; i++) {
			JButton side_btn = new JButton(sideName[i],
					new ImageIcon(sideImagePath + (i % 4 + 1) + ".jpg")); 
			panel.add(side_btn);
			side_btn.setBorder(BorderFactory.createEmptyBorder(15, 20, 100, 20));
			side_btn.setBackground(Color.BLACK);
			side_btn.setVerticalTextPosition(JButton.BOTTOM);			
			side_btn.setHorizontalTextPosition(JButton.CENTER);	
			side_btn.setForeground(Color.WHITE);
		}
		
		
		// JScrollPane 생성
		JScrollPane scroll = new JScrollPane(panel);
		scroll.setPreferredSize(new Dimension(1005, 630)); // 스크롤 초기 설정 크기
		
		
		mf.add(scroll);
		
// --------------------------------------------------------------------------------
		// 메인메뉴 버튼 감지자
		m_menu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				scroll.getViewport().setViewPosition(new Point(0, 0)); // 스크롤 위치 조정하기
				f.toBack();
				
			}
		});
		
		// 사이드 메뉴 버튼 감지자
		s_menu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				scroll.getViewport().setViewPosition(new Point(0, 700));
				f.toBack();
			}
		});
		
// ------------------------------------ 장바구니 프레임 --------------------------------
		
		Frame bf = new Frame("장바구니");
		bf.setLayout(null);
		bf.setBounds(1375, 270, 320, 630);
		bf.setBackground(Color.BLACK);
		
		JButton btn_pay = new JButton("주문하기");
		btn_pay.setBounds(15, 40, 290, 70);
		
		JButton reset = new JButton("장바구니 비우기");
		reset.setBounds(15, 545, 290, 70);
		
		bf.add(btn_pay);
		bf.add(reset);
		
		
////-------------------------------------- 메인 메뉴 ---------------------------------------
//		JButton main_menu1 = new JButton("<HTML>한우타다끼<br>28000원</HTML>",
//										new ImageIcon("img/한우타다끼.png"));
//		main_menu1.setBounds(30, 0, 280, 250);
//		main_menu1.setVerticalTextPosition(JButton.BOTTOM);			// 텍스트 가운데
//		main_menu1.setHorizontalTextPosition(JButton.CENTER);		// 텍스트 아래로
//		main_menu1.setForeground(Color.WHITE);
////		main_menu1.setHorizontalAlignment(JButton.CENTER);
//		main_menu1.setBorderPainted(false);
//		main_menu1.setContentAreaFilled(false);
//		
//		
//		JButton main_menu2 = new JButton("<HTML>밀푀유나베<br>28000원</HTML>",
//				new ImageIcon("img/밀푀유나베.jpg"));
//		main_menu2.setBounds(365, 0, 280, 250);
//		main_menu2.setVerticalTextPosition(JButton.BOTTOM);
//		main_menu2.setHorizontalTextPosition(JButton.CENTER);
//		main_menu2.setForeground(Color.WHITE);
//		main_menu2.setBorderPainted(false);
//		main_menu2.setContentAreaFilled(false);
//		
//		JButton main_menu3 = new JButton("<HTML>차돌숙주볶음<br>24000원</HTML>",
//				new ImageIcon("img/차돌숙주볶음.jpg"));
//		main_menu3.setBounds(700, 0, 280, 250);
//		main_menu3.setVerticalTextPosition(JButton.BOTTOM);
//		main_menu3.setHorizontalTextPosition(JButton.CENTER);
//		main_menu3.setForeground(Color.WHITE);
//		main_menu3.setBorderPainted(false);
//		main_menu3.setContentAreaFilled(false);
//		
//		JButton main_menu4 = new JButton("<HTML>가라아게<br>23000원</HTML>",
//				new ImageIcon("img/가라아게.jpg"));
//		main_menu4.setBounds(30, 280, 280, 250);
//		main_menu4.setVerticalTextPosition(JButton.BOTTOM);
//		main_menu4.setHorizontalTextPosition(JButton.CENTER);
//		main_menu4.setForeground(Color.WHITE);
//		main_menu4.setBorderPainted(false);
//		main_menu4.setContentAreaFilled(false);
//		
//		JButton main_menu5 = new JButton("<HTML>술찜<br>27000원</HTML>",
//				new ImageIcon("img/술찜.jpg"));
//		main_menu5.setBounds(365, 280, 280, 250);
//		main_menu5.setVerticalTextPosition(JButton.BOTTOM);
//		main_menu5.setHorizontalTextPosition(JButton.CENTER);
//		main_menu5.setForeground(Color.WHITE);
//		main_menu5.setBorderPainted(false);
//		main_menu5.setContentAreaFilled(false);
//		
//		JButton main_menu6 = new JButton("<HTML>오코노미야끼<br>24000원</HTML>",
//				new ImageIcon("img/오코노미야끼.jpg"));
//		main_menu6.setBounds(700, 280, 280, 250);
//		main_menu6.setVerticalTextPosition(JButton.BOTTOM);
//		main_menu6.setHorizontalTextPosition(JButton.CENTER);
//		main_menu6.setForeground(Color.WHITE);
//		main_menu6.setBorderPainted(false);
//		main_menu6.setContentAreaFilled(false);
//	
//		mf.add(main_menu1);
//		mf.add(main_menu2);
//		mf.add(main_menu3);
//		mf.add(main_menu4);
//		mf.add(main_menu5);
//		mf.add(main_menu6);
//		
//// ------------------------------------ 사이드 메뉴 --------------------------------------
//		
//		JButton side_menu1 = new JButton("<HTML>계란말이<br>15000원</HTML>",
//				new ImageIcon("img/계란말이.jpg"));
//		side_menu1.setBounds(30, 560, 280, 250);
//		side_menu1.setVerticalTextPosition(JButton.BOTTOM);
//		side_menu1.setHorizontalTextPosition(JButton.CENTER);
//		side_menu1.setForeground(Color.WHITE);
//		side_menu1.setBorderPainted(false);
//		side_menu1.setContentAreaFilled(false);
//	
//		JButton side_menu2 = new JButton("<HTML>고구마튀김<br>13000원</HTML>",
//				new ImageIcon("img/고구마튀김.jpg"));
//		side_menu2.setBounds(365, 560, 280, 250);
//		side_menu2.setVerticalTextPosition(JButton.BOTTOM);
//		side_menu2.setHorizontalTextPosition(JButton.CENTER);
//		side_menu2.setForeground(Color.WHITE);
//		side_menu2.setBorderPainted(false);
//		side_menu2.setContentAreaFilled(false);
//		
//		JButton side_menu3 = new JButton("<HTML>문어튀김<br>26000원</HTML>",
//				new ImageIcon("img/문어튀김.jpg"));
//		side_menu3.setBounds(700, 560, 280, 250);
//		side_menu3.setVerticalTextPosition(JButton.BOTTOM);
//		side_menu3.setHorizontalTextPosition(JButton.CENTER);
//		side_menu3.setForeground(Color.WHITE);
//		side_menu3.setBorderPainted(false);
//		side_menu3.setContentAreaFilled(false);
//		
//		JButton side_menu4 = new JButton("<HTML>숯불꼬치<br>29000원</HTML>",
//				new ImageIcon("img/숯불꼬치.jpg"));
//		side_menu4.setBounds(30, 840, 280, 250);
//		side_menu4.setVerticalTextPosition(JButton.BOTTOM);
//		side_menu4.setHorizontalTextPosition(JButton.CENTER);
//		side_menu4.setForeground(Color.WHITE);
//		side_menu4.setBorderPainted(false);
//		side_menu4.setContentAreaFilled(false);
//		
//		JButton side_menu5 = new JButton("<HTML>타코와사비<br>29000원</HTML>",
//				new ImageIcon("img/타코와사비.jpg"));
//		side_menu5.setBounds(365, 840, 280, 250);
//		side_menu5.setVerticalTextPosition(JButton.BOTTOM);
//		side_menu5.setHorizontalTextPosition(JButton.CENTER);
//		side_menu5.setForeground(Color.WHITE);
//		side_menu5.setBorderPainted(false);
//		side_menu5.setContentAreaFilled(false);
//		
//		JButton side_menu6 = new JButton("<HTML>해물떡볶이<br>26000원</HTML>",
//				new ImageIcon("img/해물떡볶이.jpg"));
//		side_menu6.setBounds(700, 840, 280, 250);
//		side_menu6.setVerticalTextPosition(JButton.BOTTOM);
//		side_menu6.setHorizontalTextPosition(JButton.CENTER);
//		side_menu6.setForeground(Color.WHITE);
//		side_menu6.setBorderPainted(false);
//		side_menu6.setContentAreaFilled(false);
//		
//		mf.add(side_menu1);
//		mf.add(side_menu2);
//		mf.add(side_menu3);
//		mf.add(side_menu4);
//		mf.add(side_menu5);
//		mf.add(side_menu6);
//	
//		
// ----------------------------------------------------------------------------------------	
	
		// 종료 버튼
		f.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		}); 
		
		mf.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		bf.addWindowListener(new WindowAdapter() {
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
		mf.setVisible(true);
		bf.setVisible(true);
		
		
	}// main
	
}
