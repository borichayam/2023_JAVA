package assignment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//나 30% 챗gpt 70%..가 만든 코드 주석달아보기...

public class AddressBookApp extends JFrame {
    private JTextField nameField;
    private JTextField phoneNumberField;
    private JTextField addressField;
    private JTextArea displayArea;
    private ArrayList<Contact> contacts;

    public AddressBookApp() {
        contacts = new ArrayList<>();

        setTitle("주소록 애플리케이션");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // 입력 패널 생성 및 구성
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(new JLabel("이름:"));
        nameField = new JTextField();
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("전화번호:"));
        phoneNumberField = new JTextField();
        inputPanel.add(phoneNumberField);
        inputPanel.add(new JLabel("주소:"));
        addressField = new JTextField();
        inputPanel.add(addressField);

        // 버튼 패널 생성 및 구성
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton saveButton = new JButton("저장");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveContact();
            }
        });
        JButton searchButton = new JButton("검색");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchContact();
            }
        });
        JButton exitButton = new JButton("종료");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        buttonPanel.add(saveButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(exitButton);

        // 컴포넌트를 프레임에 추가
        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // 결과 표시 영역 생성 및 구성
        displayArea = new JTextArea(10, 40);
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        add(scrollPane, BorderLayout.NORTH);

        // 프레임 설정
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // 연락처 저장 메서드
    private void saveContact() {
        String name = nameField.getText();
        String phoneNumber = phoneNumberField.getText();
        String address = addressField.getText();

        if (!name.isEmpty() && !phoneNumber.isEmpty() && !address.isEmpty()) {
            Contact contact = new Contact(name, phoneNumber, address);
            contacts.add(contact);
            displayArea.append("저장된 연락처:\n" + contact + "\n");
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "모든 필드를 입력하세요.");
        }
    }

    // 연락처 검색 메서드
    private void searchContact() {
        String nameToSearch = nameField.getText();

        if (!nameToSearch.isEmpty()) {
            for (Contact contact : contacts) {
                if (contact.getName().equalsIgnoreCase(nameToSearch)) {
                    displayArea.setText("검색된 연락처:\n" + contact + "\n");
                    return;
                }
            }
            displayArea.setText("연락처를 찾을 수 없습니다.");
        } else {
            JOptionPane.showMessageDialog(this, "검색할 이름을 입력하세요.");
        }
    }

    // 입력 필드 초기화 메서드
    private void clearFields() {
        nameField.setText("");
        phoneNumberField.setText("");
        addressField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AddressBookApp();
        });
    }

    // 연락처 정보를 담는 내부 클래스
    private class Contact {
        private String name;
        private String phoneNumber;
        private String address;

        public Contact(String name, String phoneNumber, String address) {
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.address = address;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "이름: " + name + "\n전화번호: " + phoneNumber + "\n주소: " + address;
        }
    }
}
