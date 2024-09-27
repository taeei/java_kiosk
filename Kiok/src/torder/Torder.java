package torder;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;
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
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

public class Torder extends JFrame {

	// 버튼 클릭 횟수
	static int mainCnt[] = new int[12];
	
	static String[] mainName = { "가라아게", "밀푀유나베", "술찜", "오코노미야끼", "차돌숙주볶음", "한우타다끼", 
									"계란말이", "고구마튀김", "문어튀김", "숯불꼬치", "타코와사비", "해물떡볶이" };
	static int[] mainPrice = { 23000, 28000, 27000, 24000, 24000, 28000, 
								15000, 13000, 26000, 29000, 29000, 26000 };

	static ImageIcon[] mainIcons = new ImageIcon[mainName.length];

	static Frame f = new Frame();
	static Frame bf = new Frame("장바구니");
	static JFrame pf = new JFrame("결제");
	
	static JPanel bp = new JPanel(); // 장바구니 레이블을 추가할 패널
	static JPanel cartPanel = new JPanel(); // 장바구니 레이블을 추가할 패널
	static JPanel payPanel = new JPanel();
	static JLabel[] cartLabels = new JLabel[mainName.length]; // 장바구니 레이블 배열
	static JLabel[] payLabels = new JLabel[mainName.length]; // 결제 레이블 배열

	static int totalPrice;

	public static void main(String[] args) {

		f.setLayout(null);
		f.setBounds(200, 170, 1500, 750); // 티오더 창 크기
		f.setBackground(new Color(13, 13, 13));

		createTopUI();

		// 종료 버튼
		f.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		
		f.setVisible(true);
		bf.setVisible(true);
		f.toBack();

	}

	private static void createTopUI() {
		// 상단 UI 구성
		Panel ui_top = new Panel();
		ui_top.setBounds(0, 25, 1500, 10);
		ui_top.setBackground(new Color(242, 5, 5));

		Label top_logo = new Label("KH_Izakaya");
		top_logo.setBounds(40, 40, 200, 50);
		top_logo.setForeground(Color.WHITE);
		top_logo.setFont(new Font("", Font.BOLD, 30));

		Button m_menu = new Button("메인메뉴");
		m_menu.setBounds(30, 100, 150, 50);
		m_menu.setFont(new Font("", Font.BOLD, 20));

		Button s_menu = new Button("사이드메뉴");
		s_menu.setBounds(30, 160, 150, 50);
		s_menu.setFont(new Font("", Font.BOLD, 20));

		Button call = new Button("직원호출");
		call.setBounds(30, 670, 150, 50);
		call.setBackground(new Color(242, 5, 5));
		call.setFont(new Font("", Font.BOLD, 20));

		f.add(ui_top);
		f.add(top_logo);
		f.add(m_menu);
		f.add(s_menu);
		f.add(call);

		// 메뉴 프레임 구성
		createMenuFrame(m_menu, s_menu);
		// 장바구니 프레임 구성
		createCartFrame();
	}

	private static void createMenuFrame(Button m_menu, Button s_menu) {
		JFrame mf = new JFrame("메뉴");
		mf.setBounds(380, 270, 1005, 630);
		mf.setBackground(Color.BLACK);

		JPanel mp = new JPanel();
		mp.setLayout(new GridLayout(0, 3));

		JButton[] main_btn = new JButton[mainName.length];
		

		// 메인 메뉴 버튼 생성
		for (int i = 0; i < mainName.length; i++) {
			main_btn[i] = createMenuButton(mainName[i], mainPrice[i], i,
					"C:\\Users\\user1\\Desktop\\메인메뉴\\image" + (i + 1) + ".jpg");
			mp.add(main_btn[i]);
		}

		

		JScrollPane scroll = new JScrollPane(mp);
		mf.add(scroll);
		mf.setVisible(true);

		// 메인 메뉴 버튼 감지자
		m_menu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mf.setVisible(true);
				scroll.getViewport().setViewPosition(new Point(0, 0));
				f.toBack();
				
				
				
			}
		});

		// 사이드 메뉴 버튼 감지자
		s_menu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mf.setVisible(true);
				scroll.getViewport().setViewPosition(new Point(0, 700));
				f.toBack();
				
			}
		});
		
		// 종료버튼
		mf.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}

	// 메뉴 프레임의 버튼들 생성 메서드
	private static JButton createMenuButton(String name, int price, int index, String imagePath) {
		JButton button = new JButton("<html><center>" + name + "<br>" + price + "원" + "</center></html>",
							new ImageIcon(imagePath));
		button.setBorder(BorderFactory.createEmptyBorder(15, 20, 100, 20));
		button.setBackground(Color.BLACK);
		button.setVerticalTextPosition(JButton.BOTTOM); // 텍스트 위치 가운데
		button.setHorizontalTextPosition(JButton.CENTER); // 텍스트 위치 아래로
		button.setForeground(Color.WHITE);

		mainIcons[index] = new ImageIcon(imagePath);
		
		
		// 메뉴 버튼들 감지자
		// bf 레이블에 정보 보내기
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainCnt[index]++;
				updateCartLabel(index);
				
			}
		});
		
		return button;
	}
	
// ------------------------------------------------------------------------------------

	// 장바구니 프레임 생성 메서드
	private static void createCartFrame() {
		bf.setLayout(null);
		bf.setBounds(1375, 270, 320, 630);
		bf.setBackground(Color.BLACK);

		// 장바구니 패널 설정
		cartPanel.setLayout(new BoxLayout(cartPanel, BoxLayout.Y_AXIS)); // 패널 수직으로 생성
		cartPanel.setBounds(15, 115, 290, 425);
		cartPanel.setBackground(Color.BLACK);

		// 초기 레이블 생성
		for (int i = 0; i < cartLabels.length; i++) {
			cartLabels[i] = new JLabel();
			cartLabels[i].setForeground(Color.BLACK);
			cartLabels[i].setFont(new Font("", Font.BOLD, 13));
			cartLabels[i].setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // 레이블 간격 설정
			cartPanel.add(cartLabels[i]);
		}


		JButton btn_pay = new JButton("주문하기");
		btn_pay.setBounds(15, 545, 290, 70);
		btn_pay.setFont(new Font("", Font.BOLD, 18));
		btn_pay.setBackground(Color.RED);

		JButton btn_reset = new JButton("장바구니 비우기");
		btn_reset.setBounds(15, 40, 290, 70);
		btn_reset.setFont(new Font("", Font.BOLD, 18));
		btn_reset.setBackground(Color.RED);
		
		
		JScrollPane cartScroll = new JScrollPane(cartPanel);
		cartScroll.setBounds(15, 115, 290, 425);
		cartScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		// 종료 버튼
		bf.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}

		});

		
		bf.add(cartScroll);
		bf.add(btn_pay);
		bf.add(btn_reset);

		bf.setVisible(true);

		// 장바구니 비우기 버튼 감지자
		btn_reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				clearCart();

			}
		});
		
		// 주문하기 버튼 감지자
		btn_pay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				createPayFrame();
				
				
				
			}
		});
	}

	
	// 메뉴 버튼 클릭 시 장바구니 레이블 생성
	private static void updateCartLabel(int index) {

		// 메인 메뉴인지 사이드 메뉴인지 구분
		
		String menuName = mainName[index];
		int menuPrice = mainPrice[index];
		int count = mainCnt[index];

		JLabel cartLabel = cartLabels[index];
		
		if(count > 0) {	// 클릭수 > 0 일 때 만 레이블 생성
			
			cartLabel.setText("<html>" +
		            "<div style='position: relative; width: 100px; height: 80spx; '>" +
		            "<div style='text-align: center; position: absolute; top: -20px; right: 10px;'>" +
		            menuName + "<br>" + menuPrice + "원" +
		            "</div>" +
		            "<div style='position: absolute; bottom: -5px; right: 10px;'>" +
		            count + "개" +
		            "</div>" +
		            "</div>" +
		            "</html>");
			cartLabel.setForeground(Color.WHITE);
			
			// 이미지 사이즈 재정의
			cartLabel.setIcon(resizeImage(mainIcons[index], 120, 120));
			
			
			JButton plus = new JButton("+"); 
			plus.setBounds(165, 80, 40, 30);
			plus.setFont(new Font("", Font.BOLD, 10));
			plus.setBackground(Color.WHITE);
			plus.setHorizontalTextPosition(JButton.CENTER);
			cartLabel.add(plus);
			
			JButton minus = new JButton("-");
			minus.setBounds(210, 80, 40, 30);
			minus.setFont(new Font("", Font.BOLD, 10));
			minus.setBackground(Color.WHITE);
			plus.setHorizontalTextPosition(JButton.CENTER);
			cartLabel.add(minus);
			
			// 플러스 버튼 감지자
			plus.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(mainCnt[index] > 0) {
						mainCnt[index]++;
						updateCartLabel(index);
						
					}else {
						updateCartLabel(index);
					}
					
				}
			});
			
			// 마이너스 버튼 감지자
			minus.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(mainCnt[index] > 0) {
						mainCnt[index]--;
						updateCartLabel(index);
						
					}else {
						updateCartLabel(index);
					}
					
				}
			});
	
		}else {
			mainCnt[index] = 0;
			cartLabel.setText("");
			cartLabel.setIcon(null);
			
		}
		
	}
	
	
// ---------------------------------------------------------------------------------------

	
	// 이미지 사이즈 재정의 메서드
	private static ImageIcon resizeImage(ImageIcon icon, int width, int height) {
		Image img = icon.getImage(); // 이미지 아이콘 배열에서 이미지 가져오기
		Image resizedImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH); // 사이즈 재정의
		return new ImageIcon(resizedImg); // 바뀐 이미지 이미지 아이콘으로 반환
	}

	// 장바구니 비우기
	private static void clearCart() {
		// 클릭 횟수 초기화
		mainCnt = new int[mainName.length]; 
		// 장바구니 글씨, 사진 초기화
		for (JLabel label : cartLabels) {
			label.setText(""); 
			label.setIcon(null); 

		}
	}
	
	
// -------------------------------- 결제창 생성 ---------------------------------
	
	
	// 결제 프레임 생성 메서드
	private static void createPayFrame() {
		
		pf.setLayout(null);
		pf.setBounds(380, 270, 1005, 630);
		pf.getContentPane().setBackground(Color.BLACK);
		
		payPanel.setLayout(new BoxLayout(payPanel, BoxLayout.Y_AXIS)); // 패널 수직으로 생성
		payPanel.setBounds(10, 110, 980, 405);
		payPanel.setBackground(Color.BLACK);
		
		
			
		// 기존 레이블 제거
		payPanel.removeAll(); // 결제창 닫고, 다시 주문하기 눌렀을 때 레이블 재생성
		
		// 레이블 생성
		for (int i = 0; i < payLabels.length; i++) {
			payLabels[i] = new JLabel();
			payLabels[i].setForeground(Color.BLACK);
			payLabels[i].setFont(new Font("", Font.BOLD, 18));
			payLabels[i].setBorder(BorderFactory.createEmptyBorder(0, 70, 5, 0)); // 레이블 간격 설정
			payPanel.add(payLabels[i]);
			
		}
		
		// 총가격 레이블
		JLabel totalLabel = new JLabel();
	    totalLabel.setForeground(Color.WHITE);
	    totalLabel.setFont(new Font("", Font.BOLD, 20));
	    totalLabel.setBounds(750, 525, 200, 50);
	    
	    // 상단 글씨
	    JLabel pay_top = new JLabel();
	    pay_top.setForeground(Color.WHITE);
	    pay_top.setFont(new Font("", Font.BOLD, 20));
	    pay_top.setBounds(10, 10, 1005, 100);
	    
	    // 공백 주기
	    String space = "";
	    for(int i = 1; i <= 26; i++) {
	    	space += "&nbsp;";
	    }
	    pay_top.setText("<html>"
	    	    + "<div style='text-align: center;'>"
	    		+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
	    	    + "상품명"+ space
	    	    + "상품금액" + space
	    	    + "수량" + space	
	    	    + "주문금액" + space
	    	    + "</div></html>");
	    
	    // 현금결제 버튼
	    Button cash_btn = new Button("현금결제");
	    cash_btn.setBounds(300, 530, 100, 50);
	    cash_btn.setBackground(Color.RED);
	    cash_btn.setFont(new Font("", Font.BOLD, 17));
	    
	    // 카드결제 버튼
	    Button card_btn = new Button("카드결제");
	    card_btn.setBounds(600, 530, 100, 50);
	    card_btn.setBackground(Color.RED);
	    card_btn.setFont(new Font("", Font.BOLD, 17));
	    

		JScrollPane payScroll = new JScrollPane(payPanel);
		payScroll.setBounds(10, 115, 980, 400);
		payScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		// 현금결제 버튼 감지자
		cash_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				PayButtonAction bill = new PayButtonAction();
//				bill.pay();
			}
		});
		
		// 카드결제 버튼 감지자
		card_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
//				PayButtonAction bill = new PayButtonAction();
//				bill.pay();
			}
		});
		
		// 종료
		pf.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				pf.setVisible(false);
			}
			
		});
	
		pf.getContentPane().removeAll();
		pf.add(payScroll);
		pf.add(cash_btn);
		pf.add(card_btn);
		pf.add(pay_top);
		pf.add(totalLabel);
		
//		pf.revalidate(); 
//		pf.repaint();
		
		updatePayLabel(totalLabel);
		pf.setVisible(true);
		
	}
	
	// 결체창에서 메뉴 레이블 생성 메서드
	public static void updatePayLabel(JLabel totalLabel) {
		
		int totalPrice = 0;
        int index = 0;  
        
        int namex = 50;
        int pricex = 300;
        int cntx = 500;
        int totalx = 800;
        
        int y = 20;

        int z = 30;
        
        String space = "";
	    for(int i = 1; i <= 30; i++) {
	    	space += "&nbsp;";
	    }
        
        // 메인 메뉴 정보 결제 창으로 복사 	// mainName[i], mainPrice[i], mainCnt[i], (mainCnt[i] * mainPrice[i])
        for (int i = 0; i < mainCnt.length; i++) {
            if (mainCnt[i] > 0) {  // 메인 메뉴가 장바구니에 추가된 경우만
//                String menuInfo = "<html><div style='text-align: center;'>" +
//                        "<span style='padding-right: 30px;'>" + mainName[i] + "</span>" +  // 메뉴 이름과 간격
//                        space +
//                        "<span style='padding-right: 30px;'>" + mainPrice[i] + "원</span>" +  // 가격과 간격
//                        space +
//                        "<span>" + mainCnt[i] + "개</span>" +  // 수량
//                        space +
//                        "<span>" + (mainCnt[i] * mainPrice[i]) + "</span>" +  // 수량 * 가격
//                        "</div></html>";
//                payLabels[index].setText(menuInfo);  // 결제 레이블에 메뉴 정보 설정
//                payLabels[index].setForeground(Color.WHITE);  // 텍스트 색상 설정
                String menuInfo = "<html><div style='text-align: center;'>" +
                		"<span style='padding-right: 30px;'>" + mainName[i] + "</span>" +  // 메뉴 이름과 간격
                		space +
                		"<span style='padding-right: 30px;'>" + mainPrice[i] + "원</span>" +  // 가격과 간격
                		space +
                		"<span>" + mainCnt[i] + "개</span>" +  // 수량
                		space +
                		"<span>" + (mainCnt[i] * mainPrice[i]) + "</span>" +  // 수량 * 가격
                		"</div></html>";
                payLabels[index].setText(menuInfo);  // 결제 레이블에 메뉴 정보 설정
                payLabels[index].setForeground(Color.WHITE);  // 텍스트 색상 설정
            	
//            	// 상품명 레이블 설정
//                String nameLabel = "<html><div style='text-align: left;'>" + mainName[i] + "</div></html>";
//                payLabels[index].setText(nameLabel);
//                payLabels[index].setForeground(Color.WHITE);
//                payLabels[index].setLocation(namex, y + i * z);
//
//                // 가격 레이블 설정
//                String priceLabel = "<html><div style='text-align: left;'>" + mainPrice[i] + "원</div></html>";
//                payLabels[index + 1].setText(priceLabel);
//                payLabels[index + 1].setForeground(Color.WHITE);
//                payLabels[index].setLocation(pricex, y + i * z);
//           
//                // 수량 레이블 설정 (x = 500)
//                String cntLabel = "<html><div style='text-align: left;'>" + mainCnt[i] + "개</div></html>";
//                payLabels[index + 2].setText(cntLabel);
//                payLabels[index + 2].setForeground(Color.WHITE);
//                payLabels[index].setLocation(cntx, y + i * z);
//                
//                // 총 금액 레이블 설정 (x = 700)
//                String totalPLabel = "<html><div style='text-align: left;'>" + (mainCnt[i] * mainPrice[i]) + "원</div></html>";
//                payLabels[index + 3].setText(totalPLabel);
//                payLabels[index + 3].setForeground(Color.WHITE);
//                payLabels[index].setLocation(totalx, y + i * z);
                
              
                totalPrice += mainPrice[i] * mainCnt[i];	// 총가격
                index++;  // 다음 레이블로 이동
//                index+=4;  // 다음 레이블로 이동
            }
        }

     
        
        totalLabel.setText("<html><div style='text-align: center;'>" +
                "<span style='font-weight: bold;'>총 가격: " + totalPrice + "원</span>" +
                "</div></html>");
        

        // 남은 payLabels 비우기 (이전 정보가 남지 않도록)
        for (int i = index; i < payLabels.length; i++) {
            payLabels[i].setText("");  // 결제 레이블 비우기
        }
            
   	}
	
	
}
