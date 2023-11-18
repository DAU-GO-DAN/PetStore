/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.gui;

import com.bus.InvoiceBUS;
import com.bus.InvoiceDetailBUS;
import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.time.LocalDate;




/**
 *
 * @author DELL
 */
public class InvoiceGUI extends javax.swing.JPanel {
    String Idp;
    /**
     * Creates new form InvoiceGUI
     */
    String empName, empID;
    InvoiceBUS InvBUS= new InvoiceBUS();
    Validator valid = new Validator();
    public InvoiceGUI(String empName, String empID) {
        this.empID = empID;
        this.empName = empName;
        initComponents();
        Search.setSVGImage("com/image/search.svg", 30, 30);
        Add.setSVGImage("com/image/add.svg", 30, 30);
        delete.setSVGImage("com/image/trash.svg", 30, 30);
        Xemsvg.setSVGImage("com/image/view.svg", 30, 30);
        svgImage1.setSVGImage("com/image/invoice.svg", 70, 70);
    }
    
//   public static void main(String[] args) {
//        JFrame f = new JFrame();
//        InvoiceGUI x = new InvoiceGUI();
//        f.add(x);
//        f.setSize(1280,620);
//        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        f.setVisible(true);
//    
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Search = new com.gui.SvgImage();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        SearchTxt = new javax.swing.JTextField();
        Add = new com.gui.SvgImage();
        Reset = new com.gui.SvgImage();
        delete = new com.gui.SvgImage();
        Xemsvg = new com.gui.SvgImage();
        jLabel1 = new javax.swing.JLabel();
        svgImage1 = new com.gui.SvgImage();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SearchMouseClicked(evt);
            }
        });
        add(Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 150, 30, 30));

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Ngày tạo", "Tổng Tiền", "Mã Khách hàng", "Mã Nhân viên"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Table);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 1280, 431));

        SearchTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchTxtActionPerformed(evt);
            }
        });
        SearchTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SearchTxtKeyPressed(evt);
            }
        });
        add(SearchTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 150, 475, 28));

        Add.setText("add");
        Add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddMouseClicked(evt);
            }
        });
        add(Add, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 150, 30, 30));

        Reset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ResetMouseClicked(evt);
            }
        });
        add(Reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(871, 88, 50, 50));

        delete.setText("de");
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteMouseClicked(evt);
            }
        });
        add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 150, 30, 30));

        Xemsvg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                XemsvgMouseClicked(evt);
            }
        });
        add(Xemsvg, new org.netbeans.lib.awtextra.AbsoluteConstraints(1225, 145, 40, 40));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 0));
        jLabel1.setText("QUẢN LÝ HÓA ĐƠN");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 368, -1));

        svgImage1.setText("svgImage1");
        svgImage1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                svgImage1MouseClicked(evt);
            }
        });
        add(svgImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 16, 75, 75));
    }// </editor-fold>//GEN-END:initComponents
public static boolean containsSubstring(String mainString, String subString) {
        int mainLength = mainString.length();
        int subLength = subString.length();
        
        for (int i = 0; i <= mainLength - subLength; i++) {
            if (mainString.substring(i, i + subLength).equals(subString)) {
                return true; // Tìm thấy chuỗi con
            }
        }
        
        return false; // Không tìm thấy chuỗi con
    }
    private void SearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchMouseClicked
        String input=SearchTxt.getText();
        
         
            Table.setModel(InvBUS.getModelId(SearchTxt.getText()));
            
        
    }//GEN-LAST:event_SearchMouseClicked

    private void SearchTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchTxtActionPerformed
      //   TODO add your handling code here:
//          String input=SearchTxt.getText();
//   if (KeyEvent.VK_ENTER == evt.getKeyCode()){
//         Table.setModel(InvBUS.getModelId(SearchTxt.getText()));
//   //}
        
    }//GEN-LAST:event_SearchTxtActionPerformed

    private void ResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResetMouseClicked
        // TODO add your handling code here:
        InvBUS.readData();
        Table.setModel(InvBUS.getModel());
    }//GEN-LAST:event_ResetMouseClicked

    private void deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseClicked
        // TODO add your handling code here:
//        try { 
//          
//            String s = (String) Table.getValueAt(Table.getSelectedRow(), 0); //Nhận giá trị tại hàng được chọn cột 0 (tức id)
//             InvoiceDetailBUS InvDBUS = new InvoiceDetailBUS(s);
//            InvBUS.delete(s);
//            InvDBUS.deleteInvDT(s);
//            
//        } catch (Exception e) {
//        }
    }//GEN-LAST:event_deleteMouseClicked

    private void SearchTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchTxtKeyPressed
        // TODO add your handling code here:
        String input=SearchTxt.getText();
   if (KeyEvent.VK_ENTER == evt.getKeyCode()){
         Table.setModel(InvBUS.getModelId(SearchTxt.getText()));
   }
    }//GEN-LAST:event_SearchTxtKeyPressed

    private void XemsvgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_XemsvgMouseClicked
        // TODO add your handling code here:
        String Idp=(String) Table.getModel().getValueAt(Table.getSelectedRow(),0 );
        LocalDate day= valid.toDataDate((String) Table.getModel().getValueAt(Table.getSelectedRow(),1 ));
        String cusID=(String) Table.getModel().getValueAt(Table.getSelectedRow(),4 );
        System.out.println("id khach hang: "+cusID);
//        String tt = (String) Table.getModel().getValueAt(Table.getSelectedRow(), 2);
        Object value = Table.getValueAt(Table.getSelectedRow(), 2);

String s = "";
if (value != null) {
    if (value instanceof Long longValue) {
        s = String.valueOf(longValue); // Chuyển đổi từ Long sang String
    } else {
        s = value.toString(); // Sử dụng toString nếu không phải là Long
    }
}
        InvoiceDetail IDT= new InvoiceDetail(Idp,day,s, cusID);
      
        IDT.setVisible(true);
    }//GEN-LAST:event_XemsvgMouseClicked

    private void svgImage1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_svgImage1MouseClicked
        InvBUS.readData();
        Table.setModel(InvBUS.getModel());
    }//GEN-LAST:event_svgImage1MouseClicked

    private void AddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddMouseClicked
        // TODO add your handling code here:
        AddInvoice add = new AddInvoice(empID, empName);
        add.setVisible(true);
    }//GEN-LAST:event_AddMouseClicked

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.gui.SvgImage Add;
    private com.gui.SvgImage Reset;
    private com.gui.SvgImage Search;
    private javax.swing.JTextField SearchTxt;
    private javax.swing.JTable Table;
    private com.gui.SvgImage Xemsvg;
    private com.gui.SvgImage delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.gui.SvgImage svgImage1;
    // End of variables declaration//GEN-END:variables
}
