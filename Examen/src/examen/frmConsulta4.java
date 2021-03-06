/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.*;

public class frmConsulta4 extends javax.swing.JFrame {

    Connection con;
    Statement stmt;
    ResultSet rs;
    DefaultTableModel dtm=new DefaultTableModel();
    
    public frmConsulta4() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setSize(675,475);
        String titulos []={"id_tienda","nro_ruc","dirección"};
        dtm.setColumnIdentifiers(titulos);
        tblConsulta.setModel(dtm);
        conectarJDBC();
        fecha();
        
    }
    public void conectarJDBC() {
        
        String url="jdbc:sqlserver://localhost;databaseName=Floreria;user=sa; password=123456;";
    try
    {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        con=DriverManager.getConnection(url);
        JOptionPane.showMessageDialog(rootPane, "Yeeeeee", "Conectar", JOptionPane.INFORMATION_MESSAGE);
    }
    catch(Exception ex)
    {
                JOptionPane.showMessageDialog(rootPane, "Noooooooo", "Conectar", JOptionPane.ERROR_MESSAGE);

    }
    }
    
    private void fecha(){
        try{
            String sql="SELECT fecha_reg FROM Pedido_F";
            stmt=con.createStatement();
            rs=stmt.executeQuery(sql);
            while (rs.next()){
            cboValor.addItem(rs.getString(1));
            }
//            con.close();
//            stmt.close();
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(rootPane,ex.getMessage());
        }
    } 
    private void mostrar(){
        String valor=(String)cboValor.getSelectedItem();

   
        String sql="SELECT p.id_pedido,d.nro_doc_dest,d.dirección,d.referencias FROM Pedido_F AS p INNER JOIN Destinatario_F AS d ON p.id_destinatario=d.id_destinatario WHERE p.fecha_reg='"+valor+"'";
        try {
            
            stmt=con.createStatement();
            rs=stmt.executeQuery(sql);
            while(rs.next()){
                String []datos=new String[4];
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                dtm.addRow(datos);
            }
//            con.close();
//            stmt.close();
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cboValor = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblConsulta = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        getContentPane().add(cboValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 110, -1));

        tblConsulta.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblConsulta);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 98, -1, 240));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        mostrar();
    }//GEN-LAST:event_btnBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(frmConsulta4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmConsulta4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmConsulta4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmConsulta4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmConsulta4().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox<String> cboValor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblConsulta;
    // End of variables declaration//GEN-END:variables
}
