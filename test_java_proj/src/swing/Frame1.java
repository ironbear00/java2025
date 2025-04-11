package swing;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class Frame1 extends JFrame 
{
	private List<Person1> people=new ArrayList<>();
    private JTable table;
    private DefaultTableModel tableModel;

    public Frame1()
    {
        setTitle("Person Manager");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel addressLabel=new JLabel("파일 경로: ");
        JButton loadButton = new JButton("파일 열기");
        JTextField pathField = new JTextField(20);
        pathField.setEditable(false);

        tableModel = new DefaultTableModel(new String[]{"ID", "이름", "나이", "주소", "기타정보"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(480, 200));
        
        loadButton.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            chooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Text Files", "txt"));
            int result = chooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                pathField.setText(file.getAbsolutePath());

                people = FileManager1.importFromFile(file);
                updateTable(people);
            }
        });

        JPanel topPanel = new JPanel();
        topPanel.add(addressLabel);
        topPanel.add(pathField);
        topPanel.add(loadButton);
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        JButton addButton = new JButton("추가");
        JButton editButton = new JButton("수정");
        JButton deleteButton = new JButton("삭제");
        JButton sortButton = new JButton("정렬");
        JButton saveButton = new JButton("저장");

        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(sortButton);
        buttonPanel.add(saveButton);

        addButton.addActionListener(e -> handleAdd());
        editButton.addActionListener(e -> handleEdit());
        deleteButton.addActionListener(e -> handleDelete());
        sortButton.addActionListener(e -> handleSort());
        saveButton.addActionListener(e -> handleSave());

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.add(buttonPanel);
        centerPanel.add(scrollPane);

        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
    }

    private void updateTable(List<Person1> people) 
    {
        tableModel.setRowCount(0);
        for (Person1 p : people) 
        {
            tableModel.addRow(new Object[]{
                    p.getId(), p.getName(), p.getAge(), p.getAddress(), p.getInfo()
            });
        }
    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(() -> new Frame1().setVisible(true));
    }

    //기능 구현
    private void handleAdd()
    {
    	JDialog dialog = new JDialog(this, "사용자 추가", true);
        dialog.setSize(400, 400);
        dialog.setLayout(new BorderLayout());
        dialog.setLocationRelativeTo(this);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));

        // 직업 선택
        JRadioButton studentButton = new JRadioButton("Student");
        JRadioButton professorButton = new JRadioButton("Professor");
        JRadioButton staffButton = new JRadioButton("Staff");
        ButtonGroup group = new ButtonGroup();
        group.add(studentButton);
        group.add(professorButton);
        group.add(staffButton);
        
        JPanel rolePanel = new JPanel();
        inputPanel.add(new JLabel("직업 선택:"));
        inputPanel.add(rolePanel);
        
        // 공통 필드
        JTextField idField = new JTextField(20);
        JTextField nameField = new JTextField(20);
        JTextField ageField = new JTextField(20);
        JTextField addressField = new JTextField(20);

        inputPanel.add(createLabeledField("ID:", idField));
        inputPanel.add(createLabeledField("이름:", nameField));
        inputPanel.add(createLabeledField("나이:", ageField));
        inputPanel.add(createLabeledField("주소:", addressField));

        
     
        rolePanel.add(studentButton);
        rolePanel.add(professorButton);
        rolePanel.add(staffButton);

        

        // 직업별 추가 필드
        JPanel dynamicPanel = new JPanel();
        dynamicPanel.setLayout(new BoxLayout(dynamicPanel, BoxLayout.Y_AXIS));
        inputPanel.add(dynamicPanel);

        // 필드 구성요소
        JTextField gradeField = new JTextField(20);
        JTextField studentNoField = new JTextField(20);
        JTextField majorField = new JTextField(20);

        JTextField salaryField = new JTextField(20);
        JTextField positionField = new JTextField(20);
        JTextField courseField = new JTextField(20);
        JTextField departmentField = new JTextField(20);

        
        // 직업 선택 이벤트
        ActionListener updateFields = e -> {
            dynamicPanel.removeAll();
            if (studentButton.isSelected()) 
            {
            	dynamicPanel.add(createLabeledField("학년:", gradeField));
            	dynamicPanel.add(createLabeledField("학번:", studentNoField));
            	dynamicPanel.add(createLabeledField("전공:", majorField));
            } 
            else if (professorButton.isSelected()) 
            {
            	dynamicPanel.add(createLabeledField("연봉:", salaryField));
            	dynamicPanel.add(createLabeledField("직위:", positionField));
            	dynamicPanel.add(createLabeledField("전공:", majorField));
            	dynamicPanel.add(createLabeledField("강의:", courseField));
            } 
            else if (staffButton.isSelected()) 
            {
            	dynamicPanel.add(createLabeledField("연봉:", salaryField));
            	dynamicPanel.add(createLabeledField("직책:", positionField));
            	dynamicPanel.add(createLabeledField("부서:", departmentField));
            }
            dynamicPanel.revalidate();
            dynamicPanel.repaint();
        };

        studentButton.addActionListener(updateFields);
        professorButton.addActionListener(updateFields);
        staffButton.addActionListener(updateFields);
        

        // 버튼
        JPanel buttonPanel = new JPanel();
        JButton okButton = new JButton("확인");
        JButton cancelButton = new JButton("취소");

        okButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText().trim());
                String name = nameField.getText().trim();
                int age = Integer.parseInt(ageField.getText().trim());
                String address = addressField.getText().trim();

                Person1 person = null;

                if (studentButton.isSelected()) {
                    int grade = Integer.parseInt(gradeField.getText().trim());
                    int studentNo = Integer.parseInt(studentNoField.getText().trim());
                    String major = majorField.getText().trim();
                    person = new Student1(id, name, age, address, grade, studentNo, major);
                } else if (professorButton.isSelected()) {
                    int salary = Integer.parseInt(salaryField.getText().trim());
                    String position = positionField.getText().trim();
                    String major = majorField.getText().trim();
                    String course = courseField.getText().trim();
                    person = new Professor1(id, name, age, address, salary, position, major, course);
                } else if (staffButton.isSelected()) {
                    int salary = Integer.parseInt(salaryField.getText().trim());
                    String position = positionField.getText().trim();
                    String department = departmentField.getText().trim();
                    person = new Staff1(id, name, age, address, salary, position, department);
                }

                if (person != null) 
                {
                    people.add(person);
                    updateTable(people);
                }

                dialog.dispose();
            } 
            catch (Exception ex) 
            {
                JOptionPane.showMessageDialog(dialog, "입력 값을 확인해주세요: " + ex.getMessage());
            }
        });

        cancelButton.addActionListener(e -> dialog.dispose());

        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);

        dialog.add(inputPanel, BorderLayout.CENTER);
        dialog.add(buttonPanel, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }
    
    private void handleEdit() 
    {
        JTextField idField = new JTextField(10);
        JPanel panel = new JPanel(new GridLayout(2, 1));
        panel.add(new JLabel("수정할 ID를 입력하세요:"));
        panel.add(idField);

        int result = JOptionPane.showConfirmDialog(
            this,
            panel,
            "ID로 사용자 수정",
            JOptionPane.OK_CANCEL_OPTION
        );

        if (result == JOptionPane.CANCEL_OPTION || result == JOptionPane.CLOSED_OPTION) return;

        int id;
        try 
        {
            id = Integer.parseInt(idField.getText());
        } 
        catch (NumberFormatException e) 
        {
            JOptionPane.showMessageDialog(this, "올바른 ID를 입력하세요.");
            return;
        }

        Person1 person = people.stream()
            .filter(p -> p.getId() == id)
            .findFirst()
            .orElse(null);

        if (person == null) 
        {
            JOptionPane.showMessageDialog(this, "해당하는 ID의 사용자가 없습니다.");
            return;
        }

        JDialog editDialog = new JDialog(this, "사용자 수정", true);
        editDialog.setSize(400, 400);
        editDialog.setLayout(new BorderLayout());
        editDialog.setLocationRelativeTo(this);

        JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JRadioButton studentBtn = new JRadioButton("Student");
        JRadioButton professorBtn = new JRadioButton("Professor");
        JRadioButton staffBtn = new JRadioButton("Staff");
        ButtonGroup group = new ButtonGroup();
        group.add(studentBtn);
        group.add(professorBtn);
        group.add(staffBtn);

        // 라디오 버튼 비활성화 및 체크
        if (person instanceof Student1) studentBtn.setSelected(true);
        else if (person instanceof Professor1) professorBtn.setSelected(true);
        else if (person instanceof Staff1) staffBtn.setSelected(true);
        studentBtn.setEnabled(false);
        professorBtn.setEnabled(false);
        staffBtn.setEnabled(false);

        radioPanel.add(new JLabel("직업: "));
        radioPanel.add(studentBtn);
        radioPanel.add(professorBtn);
        radioPanel.add(staffBtn);

        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout(new GridLayout(0, 2, 5, 5));

        JTextField nameField = new JTextField(person.getName());
        JTextField ageField = new JTextField(String.valueOf(person.getAge()));
        JTextField addressField = new JTextField(person.getAddress());

        fieldPanel.add(new JLabel("이름:"));
        fieldPanel.add(nameField);
        fieldPanel.add(new JLabel("나이:"));
        fieldPanel.add(ageField);
        fieldPanel.add(new JLabel("주소:"));
        fieldPanel.add(addressField);

        // 추가 정보 입력란
        JTextField[] extraFields;
        if (person instanceof Student1 s) 
        {
            extraFields = new JTextField[]{
                new JTextField(String.valueOf(s.getGrade())),
                new JTextField(String.valueOf(s.getStudentNo())),
                new JTextField(s.getMajor())
            };
            fieldPanel.add(new JLabel("학년:"));
            fieldPanel.add(extraFields[0]);
            fieldPanel.add(new JLabel("학번:"));
            fieldPanel.add(extraFields[1]);
            fieldPanel.add(new JLabel("전공:"));
            fieldPanel.add(extraFields[2]);
        } 
        else if (person instanceof Professor1 p) 
        {
            extraFields = new JTextField[]{
                new JTextField(String.valueOf(p.getSalary())),
                new JTextField(p.getPosition()),
                new JTextField(p.getMajor()),
                new JTextField(p.getCourse())
            };
            fieldPanel.add(new JLabel("급여:"));
            fieldPanel.add(extraFields[0]);
            fieldPanel.add(new JLabel("직위:"));
            fieldPanel.add(extraFields[1]);
            fieldPanel.add(new JLabel("전공:"));
            fieldPanel.add(extraFields[2]);
            fieldPanel.add(new JLabel("강의과목:"));
            fieldPanel.add(extraFields[3]);
        } 
        else 
        { 
            Staff1 st = (Staff1) person;
            extraFields = new JTextField[]{
                new JTextField(String.valueOf(st.getSalary())),
                new JTextField(st.getPosition()),
                new JTextField(st.getDepartment())
            };
            fieldPanel.add(new JLabel("급여:"));
            fieldPanel.add(extraFields[0]);
            fieldPanel.add(new JLabel("직책:"));
            fieldPanel.add(extraFields[1]);
            fieldPanel.add(new JLabel("부서:"));
            fieldPanel.add(extraFields[2]);
        }

        JPanel bottomPanel = new JPanel();
        JButton confirmBtn = new JButton("확인");
        JButton cancelBtn = new JButton("취소");
        bottomPanel.add(confirmBtn);
        bottomPanel.add(cancelBtn);

        confirmBtn.addActionListener(e -> {
            try 
            {
            	Person1 updatedPerson = switch (person) {
                case Student1 s -> new Student1(
                    s.getId(), nameField.getText(), Integer.parseInt(ageField.getText()), addressField.getText(),
                    Integer.parseInt(extraFields[0].getText()), Integer.parseInt(extraFields[1].getText()), extraFields[2].getText());
                case Professor1 p -> new Professor1(
                    p.getId(), nameField.getText(), Integer.parseInt(ageField.getText()), addressField.getText(),
                    Integer.parseInt(extraFields[0].getText()), extraFields[1].getText(), extraFields[2].getText(), extraFields[3].getText());
                case Staff1 st -> new Staff1(
                    st.getId(), nameField.getText(), Integer.parseInt(ageField.getText()), addressField.getText(),
                    Integer.parseInt(extraFields[0].getText()), extraFields[1].getText(), extraFields[2].getText());
                default -> throw new IllegalStateException("Unexpected value: " + person);
            };

            int index = people.indexOf(person);
            if (index != -1) 
            {
                people.set(index, updatedPerson);
            }
             updateTable(people);
             editDialog.dispose();
            } 
            catch (Exception ex) 
            {
                JOptionPane.showMessageDialog(this, "입력 값 오류: " + ex.getMessage());
            }
        });

        cancelBtn.addActionListener(e -> editDialog.dispose());

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(radioPanel, BorderLayout.NORTH);
        mainPanel.add(fieldPanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        editDialog.add(mainPanel);
        editDialog.setVisible(true);
    }

    private void handleDelete() 
    {
        JTextField idField = new JTextField(10);

        JPanel panel = new JPanel(new GridLayout(2, 1, 5, 5));
        panel.add(new JLabel("삭제할 ID를 입력하세요:"));
        panel.add(idField);

        int result = JOptionPane.showConfirmDialog(
                this,
                panel,
                "ID 입력",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (result == JOptionPane.CANCEL_OPTION || result == JOptionPane.CLOSED_OPTION) 
        {
            return;
        }

        String input = idField.getText().trim();

        if (input.isEmpty()) 
        {
            JOptionPane.showMessageDialog(this, "ID를 입력하세요.");
            return;
        }

        int id;
        try 
        {
            id = Integer.parseInt(input);
        } 
        catch (NumberFormatException e) 
        {
            JOptionPane.showMessageDialog(this, "숫자 형식의 ID를 입력하세요.");
            return;
        }

        Person1 target = null;
        for (Person1 p : people) 
        {
            if (p.getId() == id) 
            {
                target = p;
                break;
            }
        }

        if (target == null) 
        {
            JOptionPane.showMessageDialog(this, "해당 ID를 가진 사람이 존재하지 않습니다.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(
                this,
                "다음 레코드를 삭제하시겠습니까?\n\n" + target.toString(),
                "삭제 확인",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) 
        {
            people.remove(target);
            updateTable(people);
            JOptionPane.showMessageDialog(this, "레코드가 삭제되었습니다.");
        }
    }
 
    private void handleSort() 
    {
    	people.sort(Comparator.comparingInt(Person1::getId));
	    updateTable(people);
    }

    private void handleSave()
    {
    	String baseName = "output";
        String extension = ".txt";
        int counter = 0;
        File file;

        while (true) 
        {
            String fileName = (counter == 0) ? baseName + extension : baseName + counter + extension;
            file = new File(fileName);
            if (!file.exists()) break;
            counter++;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) 
        {
            if (people.isEmpty()) 
            {
                writer.write("현재 등록된 사용자가 없습니다.\n");
            } 
            else 
            {
                for (Person1 p : people) 
                {
                    writer.write("[ID: " + p.getId() + "]\n");
                    writer.write(p.toString() + "\n\n");
                }
            }
            JOptionPane.showMessageDialog(this, "사용자 정보가 저장되었습니다: " + file.getName());
        } 
        catch 
        (IOException e) 
        {
            JOptionPane.showMessageDialog(this, "파일 저장 중 오류 발생: " + e.getMessage());
        }
    }
    
    private int extractInt(String info, String key) 
    {
        try 
        {
            String[] parts = info.split(", ");
            for (String part : parts) 
            {
                if (part.startsWith(key)) 
                {
                    return Integer.parseInt(part.split(":")[1].trim());
                }
            }
        } 
        catch (Exception ignored) {}
        return 0;
    }

    private String extractString(String info, String key) 
    {
        try 
        {
            String[] parts = info.split(", ");
            for (String part : parts) 
            {
                if (part.startsWith(key)) 
                {
                    return part.split(":")[1].trim();
                }
            }
        } 
        catch (Exception ignored) {}
        return "";
    }

    private JPanel createLabeledField(String label, JTextField field) 
    {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(new JLabel(label));
        field.setPreferredSize(new Dimension(200, 25));
        panel.add(field);
        return panel;
    }
    
    
    
    
}
