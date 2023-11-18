/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.gui;

//import com.bus.AccountBUS;
import com.bus.EmployeeBUS;
import com.dao.EmployeeDTO;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;





public class EmployeeGUI extends javax.swing.JPanel {
    EmployeeBUS empBUS = new EmployeeBUS();
    public EmployeeGUI() {
        initComponents();
        btnadd.setSVGImage("com/image/add.svg", 30, 30);
        btndelete.setSVGImage("com/image/trash.svg", 30, 30);
        btnedit.setSVGImage("com/image/edit.svg", 36, 36);
        btnfind.setSVGImage("com/image/search.svg", 30, 30);
        excelsvg.setSVGImage("com/image/sheets.svg", 30,30);
        LogoEmp.setSVGImage("com/image/Logoemp.svg", 70, 70);
        addDocumentListenerToTextField();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        findtextfield = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        empTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnadd = new com.gui.SvgImage();
        btndelete = new com.gui.SvgImage();
        btnedit = new com.gui.SvgImage();
        excelsvg = new com.gui.SvgImage();
        combox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        LogoEmp = new com.gui.SvgImage();
        btnfind = new com.gui.SvgImage();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1280, 620));

        findtextfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                findtextfieldKeyPressed(evt);
            }
        });

        jScrollPane1.setPreferredSize(new java.awt.Dimension(1280, 530));

        empTable.setAutoCreateRowSorter(true);
        empTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        empTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Họ Tên", "Số điện thoại", "Địa chỉ", "Ngày tạo", "Chức vụ", "Lương"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        empTable.setPreferredSize(new java.awt.Dimension(1280, 530));
        empTable.setShowGrid(false);
        jScrollPane1.setViewportView(empTable);
        if (empTable.getColumnModel().getColumnCount() > 0) {
            empTable.getColumnModel().getColumn(0).setPreferredWidth(20);
            empTable.getColumnModel().getColumn(2).setPreferredWidth(15);
            empTable.getColumnModel().getColumn(4).setPreferredWidth(20);
            empTable.getColumnModel().getColumn(5).setPreferredWidth(15);
            empTable.getColumnModel().getColumn(6).setPreferredWidth(20);
        }
        empTable.setSize(new Dimension(1280,530));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnadd.setText("add");
        btnadd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnaddMouseClicked(evt);
            }
        });
        jPanel2.add(btnadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 33, 33));

        btndelete.setText("delete");
        btndelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btndeleteMouseClicked(evt);
            }
        });
        jPanel2.add(btndelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 33, 33));

        btnedit.setText("edit");
        btnedit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btneditMouseClicked(evt);
            }
        });
        jPanel2.add(btnedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 35, 35));

        excelsvg.setText("excelSVG");
        excelsvg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                excelsvgMouseClicked(evt);
            }
        });
        jPanel2.add(excelsvg, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 33, 33));

        combox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Export", "Import" }));
        jPanel2.add(combox, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, 20));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ NHÂN VIÊN");

        LogoEmp.setText("LogoEmp");
        LogoEmp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoEmpMouseClicked(evt);
            }
        });

        btnfind.setText("findsvg");
        btnfind.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnfindMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(findtextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnfind, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LogoEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(LogoEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(findtextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnfind, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnaddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnaddMouseClicked
        String id = empBUS.generateEmployeeID();
        LocalDate currentDate = LocalDate.now();
        String createdDate = currentDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        EmployeeGUIinfo empAdd = new EmployeeGUIinfo(id , createdDate, this);
        empAdd.setVisible(true);
        empAdd.setLocationRelativeTo(null);
  
    }//GEN-LAST:event_btnaddMouseClicked
    
    private void btneditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btneditMouseClicked
        // TODO add your handling code here:
        String flag = "edit";
        int rowSelected = empTable.getSelectedRow();
        
        /*ép kiểu từng dòng*/
        String id = (String) empTable.getValueAt(rowSelected, 0);
        String name = (String) empTable.getValueAt(rowSelected, 1);
        String phone = (String) empTable.getValueAt(rowSelected, 2);
        String address = (String) empTable.getValueAt(rowSelected, 3);
        LocalDate creDate = (LocalDate) empTable.getValueAt(rowSelected, 4);
        String role = (String) empTable.getValueAt(rowSelected, 5);
        Long salary = (Long) empTable.getValueAt(rowSelected, 6);
        
        /*truyền đối số cho DTO*/
        EmployeeDTO empDTO = new EmployeeDTO(id, name, phone, address, creDate, role, 0);

        EmployeeGUIinfo empEdit = new EmployeeGUIinfo(empDTO,flag, this);
        empEdit.setVisible(true);
        empEdit.setLocationRelativeTo(null);
    }//GEN-LAST:event_btneditMouseClicked

    
    private void btndeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndeleteMouseClicked
        // TODO add your handling code here:
//        AccountBUS accBUS = new AccountBUS();
        String empID = (String) empTable.getValueAt(empTable.getSelectedRow() ,0);
        boolean deleteSucess =  empBUS.delete(empID);
        if(deleteSucess){
            DefaultTableModel newModel = empBUS.printTable();
            empTable.setModel(newModel);
            
        }else{
//            JOptionPane.showMessageDialog(null, "Xóa không thành công");

        }
    }//GEN-LAST:event_btndeleteMouseClicked

    private void findtextfieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_findtextfieldKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            if(empBUS.containsInput(findtextfield.getText())){
                empTable.setModel(empBUS.getNameModel(findtextfield.getText()));
            }else{
                empTable.setModel(empBUS.getIdModel(findtextfield.getText()));
            }
        }
    }//GEN-LAST:event_findtextfieldKeyPressed

    private void LogoEmpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoEmpMouseClicked
        // TODO add your handling code here:
        empBUS.readData();
        empTable.setModel(empBUS.printTable());
    }//GEN-LAST:event_LogoEmpMouseClicked

    private void btnfindMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnfindMouseClicked
        // TODO add your handling code here:
        if(empBUS.containsInput(findtextfield.getText())){
            empTable.setModel(empBUS.getNameModel(findtextfield.getText()));
        }else{
            empTable.setModel(empBUS.getIdModel(findtextfield.getText()));
        }
    }//GEN-LAST:event_btnfindMouseClicked

    
    private void excelsvgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_excelsvgMouseClicked
        // TODO add your handling code here:
        if((String)combox.getSelectedItem() == "Export"){
            JFileChooser fileChooser = new JFileChooser();
            PrintGUI f = new PrintGUI();
            int x = fileChooser.showSaveDialog(f);
            if(x == JFileChooser.APPROVE_OPTION){
                String fileName = fileChooser.getSelectedFile().getName();
                String folderPath = fileChooser.getSelectedFile().getParent();
                empBUS.printExcel(fileName, folderPath);
                f.dispose();
            }
        }else if((String)combox.getSelectedItem() == "Import"){
            JFileChooser fileChooser = new JFileChooser();
            PrintGUI f = new PrintGUI();
            int x = fileChooser.showOpenDialog(f);
            if(x==JFileChooser.APPROVE_OPTION){
                String namePath = fileChooser.getSelectedFile().getParent() + fileChooser.getSelectedFile().getName();
                empBUS.importData(empTable, namePath);
            }
        }else{
                JOptionPane.showMessageDialog(null, "vui lòng chọn Export hoặc Import để thực hiện");
            }
        
      
       
    }//GEN-LAST:event_excelsvgMouseClicked
    
  public void reloadData(){
      empTable.removeAll();
      empTable.repaint();
      empBUS.readData();
      empTable.setModel(empBUS.printTable());
  }

    public static void main(String args[]) {
        JFrame f = new JFrame();
        f.setSize(1280,620);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        EmployeeGUI x = new EmployeeGUI();
        f.add(x);
        f.setVisible(true);
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.gui.SvgImage LogoEmp;
    private com.gui.SvgImage btnadd;
    private com.gui.SvgImage btndelete;
    private com.gui.SvgImage btnedit;
    private com.gui.SvgImage btnfind;
    private javax.swing.JComboBox<String> combox;
    private javax.swing.JTable empTable;
    private com.gui.SvgImage excelsvg;
    private javax.swing.JTextField findtextfield;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void addDocumentListenerToTextField() {
            findtextfield.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    handleTextChanged();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    handleTextChanged();
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    // Được gọi khi thuộc tính của Document thay đổi, không thường được sử dụng trong JTextField
                }
            });
        }

        private void handleTextChanged() {
            String searchText = findtextfield.getText();
            // Gọi các phương thức tìm kiếm hoặc xử lý dữ liệu tại đây
            
            if(searchText.isEmpty()){
                reloadData();
            }else{
                if(empBUS.numOnly(searchText) || searchText.contains("nv")){
//                if(empBUS.containsInput(searchText)){
                    empTable.setModel(empBUS.getIdModel(searchText));
//                    empTable.setModel(empBUS.getNameModel(searchText));
                }else if(empBUS.containsInput(searchText)){ 
                    empTable.setModel(empBUS.getNameModel(searchText));
////                }else if(searchText.contains("nv")){
////                    empTable.setModel(empBUS.getIdModel(searchText));
                 
                }
            }
        }
            
        
}
