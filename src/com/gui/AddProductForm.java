/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.gui;

import com.bus.PetProductBUS;
import com.bus.PetProductTypeBUS;
import com.bus.SupplierTempBUS;
import com.dao.PetProductDTO;
import com.dao.PetProductTypeDTO;
import com.dao.SupplierDTO;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author DUC PHU
 */
public class AddProductForm extends javax.swing.JFrame {

    /**
     * Creates new form AddProductForm
     */
    private String imageUrl = "null";
    private JFileChooser fileChooser = new JFileChooser();
    private File selectedFile;
    private String imagePath;
    
    SupplierTempBUS supplier = new SupplierTempBUS();
    PetProductTypeBUS typeBus = new PetProductTypeBUS();
    
    Validator valid = new Validator();
    private Long importPrice;
    private Long soldPrice;
    public AddProductForm() {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        inputImPrice = new javax.swing.JButton();
        tfImportPrice = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfSoldPrice = new javax.swing.JTextField();
        inputSoldPrice = new javax.swing.JButton();
        cbbSupplier = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbbCategory = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tfDescription = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        btnAddImage = new javax.swing.JButton();
        btnDeleteImage = new javax.swing.JButton();
        lbImage = new javax.swing.JLabel();
        btnConfirm = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Thêm sản phẩm mới");

        jLabel12.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel12.setText("Tên");

        tfName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Giá Nhập");

        inputImPrice.setText("+");
        inputImPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputImPriceActionPerformed(evt);
            }
        });

        tfImportPrice.setEditable(false);
        tfImportPrice.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Giá bán");

        tfSoldPrice.setEditable(false);
        tfSoldPrice.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        inputSoldPrice.setText("+");
        inputSoldPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputSoldPriceActionPerformed(evt);
            }
        });

        cbbSupplier.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Bên cung cấp");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Loại sản phẩm");

        cbbCategory.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setText("Thông tin mô tả");

        tfDescription.setColumns(20);
        tfDescription.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfDescription.setRows(5);
        jScrollPane1.setViewportView(tfDescription);
        tfDescription.setWrapStyleWord(true);
        tfDescription.setLineWrap(true);

        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setText("Ảnh : ");

        btnAddImage.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnAddImage.setText("Chọn ảnh");
        btnAddImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddImageActionPerformed(evt);
            }
        });

        btnDeleteImage.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnDeleteImage.setText("Xóa ảnh");
        btnDeleteImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteImageActionPerformed(evt);
            }
        });

        lbImage.setBackground(new java.awt.Color(255, 255, 255));
        lbImage.setOpaque(true);

        btnConfirm.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnConfirm.setText("Xác nhận");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAddImage)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDeleteImage))
                            .addComponent(lbImage, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(inputSoldPrice))
                                .addComponent(tfSoldPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(inputImPrice))
                                .addComponent(tfImportPrice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 281, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cbbSupplier, javax.swing.GroupLayout.Alignment.LEADING, 0, 217, Short.MAX_VALUE)
                                .addComponent(cbbCategory, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(194, 194, 194))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(546, 546, 546))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(inputImPrice))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfImportPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(inputSoldPrice))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfSoldPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(btnAddImage)
                    .addComponent(btnDeleteImage))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbImage, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        loadSup();
        loadCategory();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void inputImPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputImPriceActionPerformed
        // TODO add your handling code here:
        PriceInput input = new PriceInput(tfImportPrice);
        input.setVisible(true);
    }//GEN-LAST:event_inputImPriceActionPerformed

    private void inputSoldPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputSoldPriceActionPerformed
        // TODO add your handling code here:
        PriceInput input = new PriceInput(tfSoldPrice);
        input.setVisible(true);
    }//GEN-LAST:event_inputSoldPriceActionPerformed

    private void btnAddImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddImageActionPerformed
        // TODO add your handling code here:
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            // Lấy đường dẫn của tệp hình ảnh được chọn
            selectedFile = fileChooser.getSelectedFile();
            imagePath = selectedFile.getAbsolutePath();

            // Thực hiện các bước tiếp theo ở đây

            imageUrl = selectedFile.getName()+"";
            ImageIcon imageIcon = new ImageIcon("" +imagePath);
            Image image = imageIcon.getImage();
            int labelWidth = lbImage.getWidth();
            int labelHeight = lbImage.getHeight();
            Image newImage = image.getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
            ImageIcon newImageIcon = new ImageIcon(newImage);
            lbImage.setIcon(newImageIcon);
        }
    }//GEN-LAST:event_btnAddImageActionPerformed

    private void btnDeleteImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteImageActionPerformed
        // TODO add your handling code here:
        imageUrl = "null";
        lbImage.setIcon(null);
    }//GEN-LAST:event_btnDeleteImageActionPerformed

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        // TODO add your handling code here:
        if(validInput())
        {
            PetProductDTO product = new PetProductDTO();
            PetProductBUS productBus = new PetProductBUS();
            String id = productBus.generateID();
            if(imageUrl.equals("null"))
            {
                product.setImageUrl(imageUrl);
            }
            else{
                product.setImageUrl(imageUrl);
                File sourceImageFile = new File(imagePath);
                File destinationImageFile = new File("src/com/image/" + selectedFile.getName());
                try {
                    Files.copy(sourceImageFile.toPath(), destinationImageFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            product.setId(id);
            product.setName(tfName.getText()+"");
            importPrice = valid.convertStringToLong(tfImportPrice.getText());
            product.setImportPrice(importPrice);
            
            soldPrice = valid.convertStringToLong(tfSoldPrice.getText());
            product.setSoldPrice(soldPrice);
            
            product.setDescription(tfDescription.getText()+"");
            
            String supID = supplier.getID(cbbSupplier.getSelectedItem().toString());
            product.setSupplierId(supID);
            
            String typeID = typeBus.getID(cbbCategory.getSelectedItem().toString());
            product.setCategoryID(typeID);
            
            product.setInStock(0);
            
            System.out.println("id: "+product.getId());
          
//            System.out.println("name : "+product.getName());
//            System.out.println("soldPrice: "+product.getSoldPrice());
//            System.out.println("importPrice: "+product.getImportPrice());
//            System.out.println("Des "+ product.getDescription());
//            System.out.println("sup :"+product.getSupplierId());
//            System.out.println("type: "+product.getCategoryID());
//            System.out.println("in stock : "+product.getInStock());
//            
            productBus.add(product);
            JOptionPane.showMessageDialog(null, "thêm sản phẩm thành công");
            this.dispose();
        }
        else{
            JOptionPane.showMessageDialog(null, "dữ liệu trong form chưa đủ hoặc chưa chính xác");
        }
    }//GEN-LAST:event_btnConfirmActionPerformed

    public void loadSup()
    {
        for(SupplierDTO sup : supplier.supList)
        {
            cbbSupplier.addItem(sup.getName());
        }
    }
    
    public void loadCategory()
    {
        for(PetProductTypeDTO type : typeBus.typeList)
        {
            cbbCategory.addItem(type.getName());
        }
    }
    
    private boolean validInput()
    {
        boolean isValid;
        if(tfName.getText().isEmpty() ||
                tfImportPrice.getText().isEmpty() ||
                tfSoldPrice.getText().isEmpty())
        {
            isValid = false;
        }
        else{
            isValid = true;
        }
        return isValid;
    }
    
    /**
     * @param args the command line arguments
     */
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
//            java.util.logging.Logger.getLogger(AddProductForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(AddProductForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(AddProductForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(AddProductForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new AddProductForm().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddImage;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnDeleteImage;
    private javax.swing.JComboBox<String> cbbCategory;
    private javax.swing.JComboBox<String> cbbSupplier;
    private javax.swing.JButton inputImPrice;
    private javax.swing.JButton inputSoldPrice;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbImage;
    private javax.swing.JTextArea tfDescription;
    private javax.swing.JTextField tfImportPrice;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfSoldPrice;
    // End of variables declaration//GEN-END:variables
}
