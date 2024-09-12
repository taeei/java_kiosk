package torder;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		Button master_menu = new Button("메뉴추가");			//메인메뉴 버튼 
		master_menu.setFont(menu);
		master_menu.setBounds(30, 100, 150, 50);
		
			
		Button last_order = new Button("주방마감");			//메인메뉴 버튼 
		last_order.setFont(menu);
		last_order.setBounds(30, 160, 150, 50);
		
		
		Button sold_out = new Button("품절 및 할인");			//메인메뉴 버튼 
		sold_out.setFont(menu);
		sold_out.setBounds(30, 220, 150, 50);
		
		Panel backzone = new Panel(); //상단 ui
		backzone.setBounds(220, 50, 750, 430);
		backzone.setBackground(Color.WHITE);
		
		Button backguest = new Button("guest");				//직원 호출 버튼 
		backguest.setFont(menu);
		backguest.setBackground(new Color(242, 5, 5));
		backguest.setBounds(30, 430, 150, 50);
		
		
		ActionListener go = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String str = e.getActionCommand();
				 switch (str) {
				 case "guest":
					 System.exit(0);
					 break;
				 }
				
			}
		};
		
		
		f.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		}); // 종료 버튼
		
		backguest.addActionListener(go);
		
		
		f.add(ui_top); //상단 ui 패널
		f.add(top_logo);
		f.add(top_logo2);
		f.add(master_menu);
		f.add(last_order);
		f.add(sold_out);
		f.add(backzone);
		f.add(backguest);
		f.setVisible(true);
	}
}
