/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package POS;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author NELSON
 */
public class CargaSucursales extends javax.swing.JFrame {

    /**
     * Creates new form CargaSucursales
     */
    public CargaSucursales() {
        initComponents();
    }

        //metodo para mostrar la ventana donde se carga un nuevo vendedor
    public void cambioCreaSucursal(boolean solicitud) {
        setVisible(true);
        btnActualizarSucursal.setVisible(false);
    }
    
    private LinkedList<sucursales> listaSucursales = new LinkedList<sucursales>();
    
     //Metodo para crear la persistencia
        public void CreaListaSucursal(){
                // Obtener los valores ingresados por el usuario
                String codSucursalTexto = txtCodigoSuc.getText();
                String nombreSucursal = txtNombreSuc.getText();
                String direccion = txtDireccionSuc.getText();
                String correo = txtCorreoSuc.getText();
                String telefono = txtTelefono.getText();


                    // Validar el campo "codigo"
                    boolean codigoValido = codSucursalTexto.matches("\\d+");
                    if (!codigoValido) {
                        // El valor ingresado no es un número entero, informar al usuario
                        JOptionPane.showMessageDialog(null, "El valor ingresado en el campo 'codigo sucursal' no es un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                    // Salir del método si alguno de los campos no es válido
                    if ( !codigoValido ) {
                        return;
                    }

                    // Convertir los valores a enteros
                    int codigo = Integer.parseInt(codSucursalTexto);
                    // Agregar un nuevo cliente a la lista
                    sucursales cli = new sucursales(codigo, nombreSucursal, direccion, correo, telefono);
                    listaSucursales.add(cli);

                    // Escribir la lista completa en el archivo "clientes.dat"
                    try {
                        FileOutputStream fileOut = new FileOutputStream("sucursales.dat");
                        ObjectOutputStream out = new ObjectOutputStream(fileOut);
                        out.writeObject(listaSucursales);
                        out.close();
                        fileOut.close();

                        JOptionPane.showMessageDialog(null, "Sucursal ingresado Exitosamente");

                        Modulos ad = new Modulos();
                        ad.cambioSucursal(true);
                        dispose();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    // Imprimir todos los vendedores en la lista
                    for (sucursales sucursal : listaSucursales) {
                        System.out.print(" Registro insertado: " + sucursal);
                        System.out.print(" Código: " + sucursal.getCodigo());
                        System.out.print(" Nombre: " + sucursal.getNombre());
                        System.out.print(" Direccion: " + sucursal.getDireccion());
                        System.out.print(" Correo: " + sucursal.getCorreo());
                        System.out.print(" Telefono: " + sucursal.getTelefono());
                        System.out.println("");
                    }
            }
        
        
        
        public void editarSucursal(sucursales sucursal) {
            // Llenar los campos del panel con los valores del objeto vendedor
            txtCodigoSuc.setText(String.valueOf(sucursal.getCodigo()));
            txtNombreSuc.setText(sucursal.getNombre());
            txtDireccionSuc.setText(sucursal.getDireccion());
            txtCorreoSuc.setText(sucursal.getCorreo());
            txtTelefono.setText(sucursal.getTelefono());

    
            // Mostrar el panel
            setVisible(true);
            
            btnCrearSucursal.setVisible(false);


            sucursal.setCodigo(Integer.parseInt(txtCodigoSuc.getText()));
            sucursal.setNombre(txtNombreSuc.getText());
            sucursal.setDireccion(txtDireccionSuc.getText());
            sucursal.setCorreo(txtCorreoSuc.getText());
            sucursal.setTelefono(txtTelefono.getText());

            
            }
        
        
        public void actualizarSucursal(){
        try {
            // Leer los datos actuales del archivo y guardarlos en una nueva LinkedList
            FileInputStream fileIn = new FileInputStream("sucursales.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            LinkedList<sucursales> listaSucursalesActual = (LinkedList<sucursales>) in.readObject();
            in.close();
            fileIn.close();

            // Buscar el vendedor a actualizar en la nueva LinkedList y actualizar sus datos
            for (sucursales sucursalActual : listaSucursalesActual) {
                if (sucursalActual.getCodigo() == Integer.parseInt(txtCodigoSuc.getText())) {
                    sucursalActual.setNombre(txtNombreSuc.getText());
                    sucursalActual.setDireccion(txtDireccionSuc.getText());
                    sucursalActual.setCorreo(txtCorreoSuc.getText());
                    sucursalActual.setTelefono(txtTelefono.getText());
                    break;
                }
            }

            // Escribir la nueva LinkedList actualizada en el archivo
            FileOutputStream fileOut = new FileOutputStream("sucursales.dat");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(listaSucursalesActual);
            out.close();
            fileOut.close();

            JOptionPane.showMessageDialog(null, "Sucursal actualizado exitosamente");

            Modulos ad = new Modulos();
            ad.cambioSucursal(true);
            dispose();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pSucursales = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCodigoSuc = new javax.swing.JTextField();
        txtNombreSuc = new javax.swing.JTextField();
        txtDireccionSuc = new javax.swing.JTextField();
        txtCorreoSuc = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        btnCrearSucursal = new javax.swing.JButton();
        btnActualizarSucursal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pSucursales.setBackground(new java.awt.Color(153, 153, 255));
        pSucursales.setForeground(new java.awt.Color(153, 153, 255));

        jLabel1.setText("Crea Sucursales");

        jLabel2.setText("Código:");

        jLabel3.setText("Nombre:");

        jLabel4.setText("Dirección");

        jLabel5.setText("Correo:");

        jLabel6.setText("Teléfono:");

        btnCrearSucursal.setText("crear");
        btnCrearSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearSucursalActionPerformed(evt);
            }
        });

        btnActualizarSucursal.setText("actualizar");
        btnActualizarSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarSucursalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pSucursalesLayout = new javax.swing.GroupLayout(pSucursales);
        pSucursales.setLayout(pSucursalesLayout);
        pSucursalesLayout.setHorizontalGroup(
            pSucursalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pSucursalesLayout.createSequentialGroup()
                .addGroup(pSucursalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pSucursalesLayout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(jLabel1))
                    .addGroup(pSucursalesLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(pSucursalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(21, 21, 21)
                        .addGroup(pSucursalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDireccionSuc)
                            .addComponent(txtCodigoSuc)
                            .addComponent(txtNombreSuc)
                            .addComponent(txtCorreoSuc)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)))
                    .addGroup(pSucursalesLayout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(btnCrearSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnActualizarSucursal)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        pSucursalesLayout.setVerticalGroup(
            pSucursalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pSucursalesLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(pSucursalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtCodigoSuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pSucursalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombreSuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pSucursalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDireccionSuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(pSucursalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCorreoSuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(pSucursalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pSucursalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrearSucursal)
                    .addComponent(btnActualizarSucursal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pSucursales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pSucursales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearSucursalActionPerformed
        try {
            FileInputStream fileIn = new FileInputStream("sucursales.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            listaSucursales = (LinkedList<sucursales>) in.readObject();
            in.close();
            fileIn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        CreaListaSucursal();
    }//GEN-LAST:event_btnCrearSucursalActionPerformed

    private void btnActualizarSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarSucursalActionPerformed
        actualizarSucursal();
    }//GEN-LAST:event_btnActualizarSucursalActionPerformed

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
            java.util.logging.Logger.getLogger(CargaSucursales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CargaSucursales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CargaSucursales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CargaSucursales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CargaSucursales().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarSucursal;
    private javax.swing.JButton btnCrearSucursal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel pSucursales;
    private javax.swing.JTextField txtCodigoSuc;
    private javax.swing.JTextField txtCorreoSuc;
    private javax.swing.JTextField txtDireccionSuc;
    private javax.swing.JTextField txtNombreSuc;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
