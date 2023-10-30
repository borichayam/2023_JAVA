package CH15;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ex02 extends JFrame {
	//protected JLabel numL, nameL, telL, emailL;
	protected JTextField numTF, nameTF, telTF, emailTF;
	protected JTextArea checkTA;
	protected JPanel inputP, buttonP;
	protected JButton saveB, searchB;
	
	public Ex02() {
		setTitle("주소록");
		
		// 입력 패널
		inputP = new JPanel(new GridLayout(4, 2));
		inputP.add(new JLabel("번호:"));
        numTF = new JTextField();
        inputP.add(numTF);
		inputP.add(new JLabel("이름:"));
        nameTF = new JTextField();
        inputP.add(nameTF);
        inputP.add(new JLabel("전화번호:"));
        telTF = new JTextField();
        inputP.add(telTF);
        inputP.add(new JLabel("이메일:"));
        emailTF = new JTextField();
        inputP.add(emailTF);
        
        // 버튼 패널
        buttonP = new JPanel();
        saveB = new JButton("저장");
        saveB.addActionListener(e -> {
        	try {
				saveContact();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
        });
        searchB = new JButton("검색");
        searchB.addActionListener(e -> {
        	try {
        		searchContact();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
        });
        buttonP.add(saveB);
        buttonP.add(searchB);
        
        // 프레임에 추가
        add(inputP, "Center");
        add(buttonP, "South");
        
        // 텍스트 아리아 추가
        checkTA = new JTextArea(10,40);
        checkTA.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(checkTA);
        add(scrollPane, BorderLayout.NORTH);
		
        // 프레임 설정
        pack();
        setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	// 저장 메서드
	private void saveContact() throws IOException {
		int n;
		String search;
		String num = numTF.getText();
		String name = nameTF.getText();
		String tel = telTF.getText();
		String email = emailTF.getText();
		// true를 추가하여 이어쓰기 모드
		PrintWriter in = new PrintWriter(new FileWriter("user.txt", true)); 
		
		if (!name.isEmpty() && !num.isEmpty() && !tel.isEmpty() && !email.isEmpty()) {
			
			// 기존 연락처 정보를 읽어들이기
	        BufferedReader br = new BufferedReader(new FileReader("user.txt"));
	        String line;
	        StringBuilder existingContacts = new StringBuilder();

	        while ((line = br.readLine()) != null) {
	            existingContacts.append(line).append("\n");
	        }
	        br.close();
			
			// user.txt에 입력
			in.print(num + ", "+name+", "+tel+", "+email+"\n");
			in.flush();
			in.close();
			
            checkTA.append("저장된 연락처:\n" + num + ", "+name+", "+tel+", "+email + "\n");
            clearFields();
            
        } else {
            JOptionPane.showMessageDialog(this, "모든 필드를 입력하세요.");
        }
	}
	
	// 검색 메서드
    private void searchContact() throws IOException {
        String numToSearch = numTF.getText();
        
        String line = null;
		File f = new File("user.txt");
		
		if (!numToSearch.isEmpty()) {
			try(BufferedReader out = new BufferedReader(new FileReader(f))) {
				while (( line = out.readLine()) != null) {
					// 변수 설정
					String[] parts = line.split(", ");
					String num = parts[0];
					String name = parts[1];
					String tel = parts[2];
					String email = parts[3];
					
					if (parts.length > 0 && parts[0].equals(numToSearch)) {
						checkTA.setText("검색된 연락처\n no."+num+" "+name+", "+tel+", "+email+"\n");
						return;
					}
				}
				checkTA.setText("해당 번호를 찾을 수 없습니다.");
			}
		} else {
            JOptionPane.showMessageDialog(this, "검색할 이름을 입력하세요.");
		}
    }
	
	// 입력 필드 초기화 메서드
    private void clearFields() {
    	numTF.setText("");
        nameTF.setText("");
        telTF.setText("");
        emailTF.setText("");
    }

	public static void main(String[] args) throws IOException {
		Ex02 e = new Ex02();
	}

}
