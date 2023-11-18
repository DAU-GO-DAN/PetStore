
package com.gui;

import com.bus.EmployeeBUS;
import com.dao.EmployeeDTO;
import java.text.Normalizer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;


public class EmployeeGUIinfo extends javax.swing.JFrame {

    String flag = "";
    EmployeeGUI ui;
    
    
    //Code thêm nhân viên
    public EmployeeGUIinfo(String id , String createdDate, EmployeeGUI ui) {
        this.ui = ui;
        initComponents();
        idTF.setText(id);
        createdDateTF.setText(createdDate);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        checkNull();
    }

    //Code sửa thông tin nhân viên
    public EmployeeGUIinfo(EmployeeDTO empDTO, String flag, EmployeeGUI ui) {
        this.ui = ui;
        initComponents();
        this.flag = flag;
        DateTimeFormatter newFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = empDTO.getCreatedDate().format(newFormat);
        String longSalary = Long.toString(empDTO.getSalary());
        idTF.setText(empDTO.getId());
        nameTF.setText(empDTO.getName());
        phoneTF.setText(empDTO.getPhone());
        addressTF.setText(empDTO.getAddress());
        createdDateTF.setText(formattedDate);
        roleTF.setText(empDTO.getRole());
        salaryTF.setText(longSalary);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);  
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnconfirm = new javax.swing.JButton();
        idTF = new javax.swing.JTextField();
        nameTF = new javax.swing.JTextField();
        phoneTF = new javax.swing.JTextField();
        roleTF = new javax.swing.JTextField();
        createdDateTF = new javax.swing.JTextField();
        salaryTF = new javax.swing.JTextField();
        noticeName = new javax.swing.JLabel();
        noticePhone = new javax.swing.JLabel();
        addressTF = new javax.swing.JTextField();
        noticeAddress = new javax.swing.JLabel();
        noticeRole = new javax.swing.JLabel();
        noticeSalary = new javax.swing.JLabel();
        btnCancle = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setText("ID");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Họ tên");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Số điện thoại");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("Địa chỉ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setText("Ngày tạo");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, -1, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setText("Chức vụ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 343, -1, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setText("Lương");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, -1, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("THÔNG TIN NHÂN VIÊN");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, 790, 30));

        btnconfirm.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnconfirm.setText("Xác nhận");
        btnconfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconfirmActionPerformed(evt);
            }
        });
        jPanel1.add(btnconfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 460, -1, 30));

        idTF.setEditable(false);
        idTF.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jPanel1.add(idTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 500, 30));

        nameTF.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        nameTF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                nameTFFocusLost(evt);
            }
        });
        jPanel1.add(nameTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 500, 30));

        phoneTF.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        phoneTF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                phoneTFFocusLost(evt);
            }
        });
        jPanel1.add(phoneTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 500, 30));

        roleTF.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        roleTF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                roleTFFocusLost(evt);
            }
        });
        jPanel1.add(roleTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, 500, 30));

        createdDateTF.setEditable(false);
        createdDateTF.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jPanel1.add(createdDateTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 500, 30));

        salaryTF.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        salaryTF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                salaryTFFocusLost(evt);
            }
        });
        jPanel1.add(salaryTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 400, 500, 30));

        noticeName.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        noticeName.setForeground(new java.awt.Color(255, 0, 51));
        jPanel1.add(noticeName, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 500, 20));

        noticePhone.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        noticePhone.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(noticePhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 500, 20));

        addressTF.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        addressTF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                addressTFFocusLost(evt);
            }
        });
        jPanel1.add(addressTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 500, 30));

        noticeAddress.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        noticeAddress.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(noticeAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, 500, 20));

        noticeRole.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        noticeRole.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(noticeRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, 500, 20));

        noticeSalary.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        noticeSalary.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(noticeSalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 430, 500, 20));

        btnCancle.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnCancle.setText("Hủy");
        btnCancle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancleActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancle, new org.netbeans.lib.awtextra.AbsoluteConstraints(655, 460, -1, 30));

        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("**Vui lòng nhập đầy đủ thông tin**");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 480, 190, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    //Nút bấm xác nhận thực hiện thêm hay sửa thông tin nhân viên
    private void btnconfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconfirmActionPerformed
        // TODO add your handling code here:
        EmployeeBUS empBUS = new EmployeeBUS();
        EmployeeDTO empDTO = new EmployeeDTO();
        empDTO.setId(idTF.getText());
        empDTO.setName(nameTF.getText());
        empDTO.setPhone(phoneTF.getText());
        empDTO.setAddress(addressTF.getText());
        empDTO.setCreatedDate(LocalDate.now());
        empDTO.setRole(roleTF.getText());
        empDTO.setSalary(Long.parseLong(salaryTF.getText()));
        if(this.flag.equalsIgnoreCase("edit")){
            empBUS.edit(empDTO, idTF.getText());
        }else{
            empBUS.add(empDTO);
        }
        ui.reloadData();
        this.dispose();

    }//GEN-LAST:event_btnconfirmActionPerformed

    private void nameTFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameTFFocusLost
        // TODO add your handling code here:
//        String enteredText = nameTF.getText();
        checkNull();
        EmployeeBUS empBUS = new EmployeeBUS();
        String enteredName = nameTF.getText();
        String normalizedName =  empBUS.normalizeName(enteredName);
        nameTF.setText(normalizedName);
        // Kiểm tra và thực hiện xử lý tương ứng (ví dụ: kiểm tra tính hợp lệ của dữ liệu)
        if (nameTF.getText().isEmpty()) {
            // Thực hiện hành động khi dữ liệu hợp lệ
            noticeName.setText("Hãy điền tên vào khung");
        }else if(empBUS.containsInput(enteredName) == false){
            noticeName.setText("Tên không hợp lệ");
        }else{
            noticeName.setText("");
            
        }
    }//GEN-LAST:event_nameTFFocusLost

    private void phoneTFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_phoneTFFocusLost
        // TODO add your handling code here:
        checkNull();
        EmployeeBUS empBUS = new EmployeeBUS();
        String enteredPhone = phoneTF.getText();
            if(empBUS.numOnly(enteredPhone) && empBUS.startsWithZero(enteredPhone)){
                noticePhone.setText("");
//                btnconfirm.setEnabled(true);
            }else{
                noticePhone.setText("Số điện thoại không hợp lệ");
//                btnconfirm.setEnabled(false);
            }
    }//GEN-LAST:event_phoneTFFocusLost

    private void addressTFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_addressTFFocusLost
        // TODO add your handling code here:
        checkNull();
        EmployeeBUS empBUS = new EmployeeBUS();
        String enteredAddress = addressTF.getText();
        if(enteredAddress.isEmpty()){
            noticeAddress.setText("Hãy điền địa chỉ");
        }else{
            noticeAddress.setText("");
        }
    }//GEN-LAST:event_addressTFFocusLost

    private void roleTFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_roleTFFocusLost
        // TODO add your handling code here:
        checkNull();
        EmployeeBUS empBUS = new EmployeeBUS();
        String enteredRole = roleTF.getText();
        if(enteredRole.isEmpty()){
            noticeRole.setText("Hãy điền chức vụ");
        }else{
            noticeRole.setText("");
        }
    }//GEN-LAST:event_roleTFFocusLost

    private void salaryTFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_salaryTFFocusLost
        // TODO add your handling code here:
        checkNull();
        EmployeeBUS empBUS = new EmployeeBUS();
        String enteredSalary = salaryTF.getText();
        if(enteredSalary.isEmpty()){
            noticeSalary.setText("Hãy điền số lương");
        }else{
            noticeSalary.setText("");
        }
    }//GEN-LAST:event_salaryTFFocusLost

    private void btnCancleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancleActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancleActionPerformed
   
    
    public void checkNull(){
        String enteredName = nameTF.getText();
        String enteredPhone = phoneTF.getText();
        String enteredAddress = addressTF.getText();
        if(enteredName.isEmpty() || enteredPhone.isEmpty() || enteredAddress.isEmpty()){
            btnconfirm.setEnabled(false);
        }else{
            btnconfirm.setEnabled(true);
        }
    }
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(EmployeeGUIinfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(EmployeeGUIinfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(EmployeeGUIinfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(EmployeeGUIinfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new EmployeeGUIinfo().setVisible(true);
//              
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressTF;
    private javax.swing.JButton btnCancle;
    private javax.swing.JButton btnconfirm;
    private javax.swing.JTextField createdDateTF;
    private javax.swing.JTextField idTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nameTF;
    private javax.swing.JLabel noticeAddress;
    private javax.swing.JLabel noticeName;
    private javax.swing.JLabel noticePhone;
    private javax.swing.JLabel noticeRole;
    private javax.swing.JLabel noticeSalary;
    private javax.swing.JTextField phoneTF;
    private javax.swing.JTextField roleTF;
    private javax.swing.JTextField salaryTF;
    // End of variables declaration//GEN-END:variables
}
