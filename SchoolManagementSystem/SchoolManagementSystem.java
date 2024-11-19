package SchoolManagementSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class SchoolManagementSystem extends JFrame {
    private HashMap<String, User> userDatabase = new HashMap<>();

    public SchoolManagementSystem() {
        setTitle("학교 정보 시스템");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // 메인 패널
        JPanel mainPanel = new JPanel(new GridLayout(2, 2));

        JButton addButton = new JButton("정보 입력");
        JButton updateButton = new JButton("정보 수정");
        JButton deleteButton = new JButton("정보 삭제");
        JButton searchButton = new JButton("정보 조회");

        addButton.addActionListener(e -> addUser());
        updateButton.addActionListener(e -> updateUser());
        deleteButton.addActionListener(e -> deleteUser());
        searchButton.addActionListener(e -> searchUser());

        mainPanel.add(addButton);
        mainPanel.add(updateButton);
        mainPanel.add(deleteButton);
        mainPanel.add(searchButton);

        add(mainPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    private void addUser() {
        // 사용자 정보를 입력받기 위한 Swing 폼
        JTextField nameField = new JTextField();
        JTextField deptField = new JTextField();
        JTextField ssnField = new JTextField();
        JTextField idField = new JTextField();
        String[] userTypes = {"학생", "교수"};
        String[] departments = {"전산학과", "전자공학과", "화학공학과", "기계공학과", "항공우주공학과"};

        JComboBox<String> userTypeBox = new JComboBox<>(userTypes);
        JComboBox<String> deptBox = new JComboBox<>(departments);

        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.add(new JLabel("이름:"));
        panel.add(nameField);
        panel.add(new JLabel("학과:"));
        panel.add(deptBox);
        panel.add(new JLabel("주민번호:"));
        panel.add(ssnField);
        panel.add(new JLabel("사용자 유형:"));
        panel.add(userTypeBox);
        panel.add(new JLabel("학번/교수 번호:"));
        panel.add(idField);

        int result = JOptionPane.showConfirmDialog(null, panel, "정보 입력", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String name = nameField.getText();
            String dept = (String) deptBox.getSelectedItem();
            String ssn = ssnField.getText();
            String id = idField.getText();
            String userType = (String) userTypeBox.getSelectedItem();

            // 중복 검사
            if (!userDatabase.containsKey(id)) {
                if (userType.equals("학생")) {
                    userDatabase.put(id, new Student(name, dept, ssn, id));
                } else {
                    userDatabase.put(id, new Professor(name, dept, ssn, id));
                }
                JOptionPane.showMessageDialog(null, "사용자가 성공적으로 등록되었습니다.");
            } else {
                JOptionPane.showMessageDialog(null, "중복된 학번/교수 번호가 있습니다.");
            }
        }
    }


    private void updateUser() {
        String id = JOptionPane.showInputDialog("수정할 학번/교수 번호를 입력하세요:");
        if (userDatabase.containsKey(id)) {
            User user = userDatabase.get(id);
            JTextField nameField = new JTextField(user.getName());
            JComboBox<String> deptBox = new JComboBox<>(new String[]{"전산학과", "전자공학과", "화학공학과", "기계공학과", "항공우주공학과"});
            deptBox.setSelectedItem(user.getDept());
            JTextField ssnField = new JTextField(user.getSsn());

            JPanel panel = new JPanel(new GridLayout(4, 2));
            panel.add(new JLabel("이름:"));
            panel.add(nameField);
            panel.add(new JLabel("학과:"));
            panel.add(deptBox);
            panel.add(new JLabel("주민번호:"));
            panel.add(ssnField);

            int result = JOptionPane.showConfirmDialog(null, panel, "정보 수정", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                user.setName(nameField.getText());
                user.setDept((String) deptBox.getSelectedItem());
                user.setSsn(ssnField.getText());
                JOptionPane.showMessageDialog(null, "정보가 수정되었습니다.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "해당 학번/교수 번호가 존재하지 않습니다.");
        }
    }


    private void deleteUser() {
        String id = JOptionPane.showInputDialog("삭제할 학번/교수 번호를 입력하세요:");
        if (userDatabase.remove(id) != null) {
            JOptionPane.showMessageDialog(null, "사용자가 삭제되었습니다.");
        } else {
            JOptionPane.showMessageDialog(null, "해당 학번/교수 번호가 존재하지 않습니다.");
        }
    }


    private void searchUser() {
        String id = JOptionPane.showInputDialog("검색할 학번/교수 번호를 입력하세요:");
        User user = userDatabase.get(id);
        if (user != null) {
            JOptionPane.showMessageDialog(null, user);
        } else {
            JOptionPane.showMessageDialog(null, "해당 학번/교수 번호가 존재하지 않습니다.");
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(SchoolManagementSystem::new);
    }
}
