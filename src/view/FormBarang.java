package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Barang;

public class FormBarang extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    private final List<Barang> daftarBarang = new ArrayList<Barang>();
    private DefaultTableModel modelTabel;

    public FormBarang() {
        initComponents();
        siapkanTabel();
        isiDataContoh();
        setLocationRelativeTo(null);
    }

    private void siapkanTabel() {
        modelTabel = new DefaultTableModel(
                new Object[]{"Kode", "Nama Barang", "Tersedia"}, 0) {
            private static final long serialVersionUID = 1L;

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblBarang.setModel(modelTabel);
        tblBarang.setRowHeight(26);
        tblBarang.getTableHeader().setReorderingAllowed(false);
    }

    private void isiDataContoh() {
        daftarBarang.add(new Barang("BRG-001", "Keyboard USB", 10));
        daftarBarang.add(new Barang("BRG-002", "Mouse USB", 8));
        perbaruiTabel();
        lblStatus.setText("Siap. Dua data contoh dimuat di memori.");
    }

    private void perbaruiTabel() {
        modelTabel.setRowCount(0);
        for (Barang barang : daftarBarang) {
            modelTabel.addRow(new Object[]{
                barang.getKode(),
                barang.getNama(),
                barang.getJumlahTersedia()
            });
        }
    }

private void bersihkanInput() {
    txtkode.setText("");
    txtBarang.setText("");
    txtJumlah.setText("");
    txtkode.requestFocusInWindow();
}

private void tambahDemo() {
    String kode = txtkode.getText().trim();
    String nama = txtBarang.getText().trim();
    String teksJumlah = txtJumlah.getText().trim();


        try {
            if (kode.isEmpty() || nama.isEmpty() || teksJumlah.isEmpty()) {
                throw new IllegalArgumentException(
                        "Kode, nama, dan jumlah wajib diisi.");
            }

            int jumlah = Integer.parseInt(teksJumlah);
            Barang barang = new Barang(kode, nama, jumlah);
            daftarBarang.add(barang);
            perbaruiTabel();
            bersihkanInput();
            lblStatus.setText("Barang " + barang.getNama()
                    + " ditambahkan ke daftar sementara.");
        } catch (NumberFormatException e) {
            lblStatus.setText("Jumlah belum valid. Data tidak ditambahkan.");
            JOptionPane.showMessageDialog(this,
                    "Jumlah harus bilangan bulat antara 0 dan 2147483647.",
                    "Input jumlah", JOptionPane.WARNING_MESSAGE);
            txtJumlah.requestFocusInWindow();
            txtJumlah.selectAll();
        } catch (IllegalArgumentException e) {
            lblStatus.setText("Data tidak ditambahkan: " + e.getMessage());
            JOptionPane.showMessageDialog(this, e.getMessage(),
                    "Periksa data barang", JOptionPane.WARNING_MESSAGE);
        }

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblJudul = new javax.swing.JLabel();
        lblInfo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBarang = new javax.swing.JTable();
        pnlInput = new javax.swing.JPanel();
        btnTutup = new javax.swing.JButton();
        btnBersihkan = new javax.swing.JButton();
        btnTambah = new javax.swing.JButton();
        lblKode = new javax.swing.JLabel();
        lblNama = new javax.swing.JLabel();
        lblJumlah = new javax.swing.JLabel();
        txtkode = new javax.swing.JTextField();
        txtBarang = new javax.swing.JTextField();
        txtJumlah = new javax.swing.JTextField();
        lblStatus = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inventori Laboratorium - Data Barang");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblJudul.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        lblJudul.setText("INVENTORI LABORATORIUM");
        getContentPane().add(lblJudul, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        lblInfo.setText("Latihan antarmuka - data tersimpan sementara");
        getContentPane().add(lblInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        tblBarang.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(240, 240, 240), null, null, new java.awt.Color(240, 240, 240)));
        tblBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane2.setViewportView(tblBarang);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 710, 110));

        pnlInput.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Input barang", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16))); // NOI18N
        pnlInput.setToolTipText("");

        btnTutup.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnTutup.setText("Tutup");
        btnTutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTutupActionPerformed(evt);
            }
        });

        btnBersihkan.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnBersihkan.setText("Bersihkan Input");
        btnBersihkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBersihkanActionPerformed(evt);
            }
        });

        btnTambah.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnTambah.setText("Tambah Demo");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        lblKode.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblKode.setText("Kode Barang");

        lblNama.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblNama.setText("Nama Barang");

        lblJumlah.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblJumlah.setText("Jumlah Tersedia");

        javax.swing.GroupLayout pnlInputLayout = new javax.swing.GroupLayout(pnlInput);
        pnlInput.setLayout(pnlInputLayout);
        pnlInputLayout.setHorizontalGroup(
            pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInputLayout.createSequentialGroup()
                .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBersihkan, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTutup)
                .addGap(236, 236, 236))
            .addGroup(pnlInputLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNama)
                    .addComponent(lblKode)
                    .addComponent(lblJumlah))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtJumlah, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
                    .addComponent(txtkode, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
                    .addComponent(txtBarang))
                .addContainerGap())
        );
        pnlInputLayout.setVerticalGroup(
            pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInputLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKode)
                    .addComponent(txtkode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNama)
                    .addComponent(txtBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJumlah)
                    .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTutup)
                    .addComponent(btnBersihkan)
                    .addComponent(btnTambah))
                .addContainerGap())
        );

        getContentPane().add(pnlInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 710, 230));

        lblStatus.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblStatus.setText("Barang Kabel HDMI Di Tambahkan Ke Daftar Sementara");
        getContentPane().add(lblStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        tambahDemo();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnBersihkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBersihkanActionPerformed
        // TODO add your handling code here:
         bersihkanInput();
lblStatus.setText("Input dibersihkan. Daftar barang tetap.");
    }//GEN-LAST:event_btnBersihkanActionPerformed

    private void btnTutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTutupActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnTutupActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormBarang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBersihkan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnTutup;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JLabel lblJumlah;
    private javax.swing.JLabel lblKode;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JPanel pnlInput;
    private javax.swing.JTable tblBarang;
    private javax.swing.JTextField txtBarang;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtkode;
    // End of variables declaration//GEN-END:variables
}
