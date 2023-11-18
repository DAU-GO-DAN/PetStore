/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.gui;

import com.bus.BreedBUS;
import com.bus.PetOnStoreBUS;
import com.bus.PetProductBUS;
import com.bus.PetProductTypeBUS;
import com.bus.SoldPetBUS;
import com.bus.SupplierBUS;
import com.dao.BreedDTO;
import com.dao.PetOnStoreDTO;
import com.dao.PetProductDTO;
import com.dao.PetProductTypeDTO;
import com.dao.ProductDTO;
import com.dao.SoldPetDTO;
import com.dao.SupplierDTO;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author DUC PHU
 */
public class ProductUI extends javax.swing.JPanel {

    /**
     * Creates new form ProductCom
     */
    PetOnStoreBUS POSBus = new PetOnStoreBUS();
    ArrayList<PetOnStoreDTO> petOnStoreList = new ArrayList<>();
    
    PetProductBUS PetProBus = new PetProductBUS();
    ArrayList<PetProductDTO> proList = new ArrayList<>();
    
    SoldPetBUS soldBus = new SoldPetBUS();
    ArrayList<SoldPetDTO> soldList = new ArrayList<>();
    
    
    
    BreedBUS breed = new BreedBUS();
    PetProductTypeBUS typeBus = new PetProductTypeBUS();
    int hgap = 5;
    int vgap = 5;
    String section = "";
    String searchOption = "";
    public ProductUI() {
        initComponents();
        setSize(new Dimension(1280, 620));
//        svgAdd.setSVGImage("com/image/add.svg", 32, 32);
        Table.removeAll();
        Table.revalidate();
        Table.repaint();
        refreshTable();
//        svgAdd.setIcon(null);
        svgAdd.setSVGImage("com/image/add.svg", 32, 32);
        section = "petonstore";
        loadFilter();
        lbPetOnStore.setBackground(new Color(0xA7D2CB));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NavBar = new javax.swing.JPanel();
        lbPetOnStore = new javax.swing.JLabel();
        lbSoldPet = new javax.swing.JLabel();
        lbPetProduct = new javax.swing.JLabel();
        tfSearch = new javax.swing.JTextField();
        BaseTable = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        Table = new javax.swing.JPanel();
        svgAdd = new com.gui.SvgImage();
        jLabel1 = new javax.swing.JLabel();
        cbbFilter = new javax.swing.JComboBox<>();
        btnFilter = new javax.swing.JButton();

        setBackground(new java.awt.Color(167, 210, 203));
        setName(""); // NOI18N

        NavBar.setBackground(new java.awt.Color(255, 255, 255));

        lbPetOnStore.setBackground(new java.awt.Color(255, 255, 255));
        lbPetOnStore.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbPetOnStore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPetOnStore.setText("Thú đang bán");
        lbPetOnStore.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbPetOnStore.setOpaque(true);
        lbPetOnStore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbPetOnStoreMouseClicked(evt);
            }
        });

        lbSoldPet.setBackground(new java.awt.Color(255, 255, 255));
        lbSoldPet.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbSoldPet.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSoldPet.setText("Thú đã bán");
        lbSoldPet.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbSoldPet.setOpaque(true);
        lbSoldPet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbSoldPetMouseClicked(evt);
            }
        });

        lbPetProduct.setBackground(new java.awt.Color(255, 255, 255));
        lbPetProduct.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbPetProduct.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPetProduct.setText("Sản phẩm cho thú");
        lbPetProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbPetProduct.setOpaque(true);
        lbPetProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbPetProductMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout NavBarLayout = new javax.swing.GroupLayout(NavBar);
        NavBar.setLayout(NavBarLayout);
        NavBarLayout.setHorizontalGroup(
            NavBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbPetOnStore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbSoldPet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbPetProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );
        NavBarLayout.setVerticalGroup(
            NavBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NavBarLayout.createSequentialGroup()
                .addComponent(lbPetOnStore, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbSoldPet, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbPetProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        List<JLabel> navButtons = Arrays.asList(lbPetOnStore, lbPetProduct, lbSoldPet);

        for(JLabel navButton : navButtons)
        {
            navButton.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e){
                    for(JLabel navBtn : navButtons)
                    {
                        navBtn.setBackground(new Color(0xFFFFFF));
                    }
                    navButton.setBackground(new Color(0xA7D2CB));
                }

            });
        }

        tfSearch.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfSearchKeyPressed(evt);
            }
        });

        BaseTable.setBackground(new java.awt.Color(167, 210, 203));

        scrollPane.setBackground(new java.awt.Color(167, 210, 203));
        scrollPane.setBorder(null);

        Table.setBackground(new java.awt.Color(167, 210, 203));

        javax.swing.GroupLayout TableLayout = new javax.swing.GroupLayout(Table);
        Table.setLayout(TableLayout);
        TableLayout.setHorizontalGroup(
            TableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1078, Short.MAX_VALUE)
        );
        TableLayout.setVerticalGroup(
            TableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 548, Short.MAX_VALUE)
        );

        scrollPane.setViewportView(Table);

        javax.swing.GroupLayout BaseTableLayout = new javax.swing.GroupLayout(BaseTable);
        BaseTable.setLayout(BaseTableLayout);
        BaseTableLayout.setHorizontalGroup(
            BaseTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane)
        );
        BaseTableLayout.setVerticalGroup(
            BaseTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane)
        );

        int scrollAmount = 15;
        scrollPane.getVerticalScrollBar().setUnitIncrement(scrollAmount);

        svgAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                svgAddMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Bộ lọc : ");

        cbbFilter.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbbFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbFilter.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbFilterItemStateChanged(evt);
            }
        });
        cbbFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbFilterActionPerformed(evt);
            }
        });

        btnFilter.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnFilter.setText("Lọc");
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(NavBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(BaseTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFilter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(svgAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NavBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(svgAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(11, 11, 11)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbbFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnFilter)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BaseTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        BaseTable.setPreferredSize(new Dimension(1080, 550));
    }// </editor-fold>//GEN-END:initComponents

    private void svgAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_svgAddMouseClicked
        // TODO add your handling code here:
//        AddPetForm addForm = new AddPetForm(this);
//        addForm.setVisible(true);
        if(section.equals("petonstore"))
        {
            AddPetForm addForm = new AddPetForm(this);
            addForm.setVisible(true);
        }
        else if(section.equals("petproduct")){
            AddProductForm addForm = new AddProductForm(this);
            addForm.setVisible(true);
        }
        
    }//GEN-LAST:event_svgAddMouseClicked

    private void lbPetOnStoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbPetOnStoreMouseClicked
        // TODO add your handling code here:
        Table.removeAll();
        Table.revalidate();
        Table.repaint();
        refreshTable();
//        svgAdd.setIcon(null);
        svgAdd.setSVGImage("com/image/add.svg", 32, 32);
        section = "petonstore";
        loadFilter();
    }//GEN-LAST:event_lbPetOnStoreMouseClicked

    private void lbPetProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbPetProductMouseClicked
        // TODO add your handling code here:
        
        refreshPetProList();
        svgAdd.setSVGImage("com/image/add.svg", 32, 32);
        section = "petproduct";
        loadFilter();
    }//GEN-LAST:event_lbPetProductMouseClicked

    private void lbSoldPetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSoldPetMouseClicked
        // TODO add your handling code here:
        soldPetTable();
        svgAdd.setIcon(null);
        section = "soldpet";
        loadFilter();
    }//GEN-LAST:event_lbSoldPetMouseClicked

    private void cbbFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbFilterActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cbbFilterActionPerformed

    private void cbbFilterItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbFilterItemStateChanged
        // TODO add your handling code here:
//        if(!section.equals(""))
//        {
//            System.out.println(""+cbbFilter.getSelectedItem().toString());
//        }
    }//GEN-LAST:event_cbbFilterItemStateChanged

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        // TODO add your handling code here:
        if(!section.equals(""))
        {
            
        }
    }//GEN-LAST:event_btnFilterActionPerformed

    private void tfSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSearchKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tfSearchKeyPressed

    public void revalidateTable()
    {
        Table.removeAll();
        Table.revalidate();
        Table.repaint();
    }
    
    public void refreshTable()
    {
        revalidateTable();
        
        
        POSBus.readData();
        petOnStoreList = POSBus.petList;
        
        if(petOnStoreList.size() <= 6)
        {
           Table.setLayout(new GridLayout(2, 3, hgap, vgap));
            for(PetOnStoreDTO pet : petOnStoreList)
            {
                ProductCom product = new ProductCom(pet, this);
                Table.add(product);
            }
            int remains = 6 - petOnStoreList.size();
            for(int i = 0; i < remains; i++)
            {
                EmptyProduct emp = new EmptyProduct();
                Table.add(emp);
            }
        }
        else if(petOnStoreList.size() > 6)
        {
            int rows = 0;
            int remains = petOnStoreList.size() % 3;
            if(remains != 0)
            {
                rows = (petOnStoreList.size() / 3) + 1;
            }
            else{
                rows = (petOnStoreList.size() / 3);
            }
            Table.setLayout(new GridLayout(rows, 3, hgap, vgap));
            
            for(PetOnStoreDTO pet : petOnStoreList)
            {
                ProductCom product = new ProductCom(pet, this);
                Table.add(product);
            }
        }
        
        Table.revalidate();
        Table.repaint();
    }
    
    public void refreshPetProList()
    {
        Table.removeAll();
        Table.revalidate();
        Table.repaint();
        
        
        PetProBus.readData();
        proList = PetProBus.productList;
        
//        System.out.println("int 1:"+testList.size());
//        System.out.println("int 2: "+PetProBus.productList.size());
        
        if(proList.size() <= 6)
        {
            Table.setLayout(new GridLayout(2, 3, hgap, vgap));
            for(PetProductDTO product : proList)
            {
                ProductCom productCom = new ProductCom(product, this);
                Table.add(productCom);
            }
            int remains = 6 - proList.size();
            for(int i = 0; i < remains; i++)
            {
                EmptyProduct emp = new EmptyProduct();
                Table.add(emp);
            }
        }
        else if(proList.size() > 6)
        {
            int rows = 0;
            int remains = proList.size() % 3;
            if(remains != 0)
            {
                rows = (proList.size() / 3) + 1;
            }
            else{
                rows = (proList.size() / 3);
            }
            Table.setLayout(new GridLayout(rows, 3, hgap, vgap));
            
            for(PetProductDTO product : proList)
            {
                ProductCom productCom = new ProductCom(product, this);
                Table.add(productCom);
            }
        }
        Table.revalidate();
        Table.repaint();
    }
    
    public void soldPetTable()
    {
        Table.removeAll();
        Table.revalidate();
        Table.repaint();
        
        
        soldBus.readData();
        soldList = soldBus.soldList;
        
        if(soldList.size() <= 6)
        {
            Table.setLayout(new GridLayout(2, 3, hgap, vgap));
            for(SoldPetDTO product : soldList)
            {
                ProductCom productCom = new ProductCom(product, this);
                Table.add(productCom);
            }
            int remains = 6 - soldList.size();
            for(int i = 0; i < remains; i++)
            {
                EmptyProduct emp = new EmptyProduct();
                Table.add(emp);
            }
        }
        else if(soldList.size() > 6)
        {
            int rows = 0;
            int remains = soldList.size() % 3;
            if(remains != 0)
            {
                rows = (soldList.size() / 3) + 1;
            }
            else{
                rows = (soldList.size() / 3);
            }
            Table.setLayout(new GridLayout(rows, 3, hgap, vgap));
            
            for(SoldPetDTO product : soldList)
            {
                ProductCom productCom = new ProductCom(product, this);
                Table.add(productCom);
            }
        }
        Table.revalidate();
        Table.repaint();
    }
    
    public void loadFilter()
    {
        cbbFilter.removeAllItems();
        if(section.equals("petonstore") || section.equals("soldpet"))
        {
            for(BreedDTO bre : breed.breedList)
            {
                cbbFilter.addItem(bre.getName());
            }
        }
        else if(section.equals("petproduct"))
        {
            for(PetProductTypeDTO type : typeBus.typeList)
            {
                cbbFilter.addItem(type.getName());
            }
        }
    }
    
    
    
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(1280, 620);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ProductUI product = new ProductUI();
        f.add(product);
        f.setVisible(true);
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BaseTable;
    private javax.swing.JPanel NavBar;
    private javax.swing.JPanel Table;
    private javax.swing.JButton btnFilter;
    private javax.swing.JComboBox<String> cbbFilter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbPetOnStore;
    private javax.swing.JLabel lbPetProduct;
    private javax.swing.JLabel lbSoldPet;
    private javax.swing.JScrollPane scrollPane;
    private com.gui.SvgImage svgAdd;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables
}
