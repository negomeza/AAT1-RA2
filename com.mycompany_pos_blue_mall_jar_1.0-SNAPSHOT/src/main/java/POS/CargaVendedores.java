package POS;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author NELSON
 */
public class CargaVendedores extends javax.swing.JFrame {

    /**
     * Creates new form CargaVendedores
     */
    public CargaVendedores() {
        initComponents();
    }

    //metodo para mostrar la ventana donde se carga un nuevo vendedor
    public void cambioCreaVendedor(boolean solicitud) {
        setVisible(true);
        btnActualizar.setVisible(false);
    }
    
private LinkedList<vendedores> listaVendedores = new LinkedList<vendedores>();

    
 //Metodo para crear la persistencia
public void CreaListaVendedor(){
        // Obtener los valores ingresados por el usuario
        String codigoTexto = txtCodigo.getText();
        String nombre = txtNombre.getText();
        String cajaTexto = txtCaja.getText();
        String ventasTexto = txtVentas.getText();
        
        DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) cmbGenero.getModel();
        int selectedIndex = cmbGenero.getSelectedIndex();
        String selectedValue = model.getElementAt(selectedIndex);
        String genero = selectedValue;
        String contrasenia = pswNuevoPass.getText();

            // Validar el campo "caja"
            boolean cajaValida = cajaTexto.matches("\\d+");
            if (!cajaValida) {
                // El valor ingresado no es un número entero, informar al usuario
                JOptionPane.showMessageDialog(null, "El valor ingresado en el campo 'caja' no es un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            // Validar el campo "codigo"
            boolean codigoValido = codigoTexto.matches("\\d+");
            if (!codigoValido) {
                // El valor ingresado no es un número entero, informar al usuario
                JOptionPane.showMessageDialog(null, "El valor ingresado en el campo 'codigo' no es un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            // Validar el campo "ventas"
            boolean ventasValido = ventasTexto.matches("\\d+(\\.\\d{1,10})");
            if (!ventasValido ) {
                // El valor ingresado no es un número de moneda, informar al usuario
                JOptionPane.showMessageDialog(null, "El valor ingresado en el campo 'ventas' no es un número moneda ejemplo(155.10).", "Error", JOptionPane.ERROR_MESSAGE);
            }


            // Salir del método si alguno de los campos no es válido
            if (!cajaValida || !codigoValido || !ventasValido) {
                return;
            }

            // Convertir los valores a enteros
            int caja = Integer.parseInt(cajaTexto);
            int codigo = Integer.parseInt(codigoTexto);
            BigDecimal ventas = new BigDecimal(ventasTexto);
            // Agregar un nuevo vendedor a la lista
            vendedores v1 = new vendedores(codigo, nombre, caja, ventas, genero,contrasenia);
            listaVendedores.add(v1);

            // Escribir la lista completa en el archivo "vendedores.dat"
            try {
                FileOutputStream fileOut = new FileOutputStream("vendedores.dat");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(listaVendedores);
                out.close();
                fileOut.close();

                JOptionPane.showMessageDialog(null, "Vendedor ingresado Exitosamente");

                Modulos ad = new Modulos();
                ad.cambioVendedor(true);
                dispose();

            } catch (Exception e) {
                e.printStackTrace();
            }

            // Imprimir todos los vendedores en la lista
            for (vendedores vendedor : listaVendedores) {
                System.out.print(" Registro insertado: " + vendedor);
                System.out.print(" Código: " + vendedor.getCodigo());
                System.out.print(" Nombre: " + vendedor.getNombre());
                System.out.print(" Caja: " + vendedor.getCaja());
                System.out.print(" Ventas: " + vendedor.getVentas());
                System.out.print(" Género: " + vendedor.getGenero());
                System.out.print(" Constraseña: " + vendedor.getContrasenia());
                System.out.println("");
            }
    }


    public void editarVendedor(vendedores vendedor) {
            // Llenar los campos del panel con los valores del objeto vendedor
            txtCodigo.setText(String.valueOf(vendedor.getCodigo()));
            txtNombre.setText(vendedor.getNombre());
            txtCaja.setText(String.valueOf(vendedor.getCaja()));
            txtVentas.setText(String.valueOf(vendedor.getVentas()));
            pswNuevoPass.setText(vendedor.getContrasenia());

            // Seleccionar el valor correcto en el combo box de género
            DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) cmbGenero.getModel();
            int selectedIndex = 0;
            for (int i = 0; i < model.getSize(); i++) {
                if (model.getElementAt(i).equals(vendedor.getGenero())) {
                    selectedIndex = i;
                    break;
                }
            }
            cmbGenero.setSelectedIndex(selectedIndex);

            // Mostrar el panel
            setVisible(true);
            
            btnAgregar.setVisible(false);



            vendedor.setCodigo(Integer.parseInt(txtCodigo.getText()));
            vendedor.setNombre(txtNombre.getText());
            vendedor.setCaja(Integer.parseInt(txtCaja.getText()));
            vendedor.setVentas(new BigDecimal(txtVentas.getText()));
            vendedor.setGenero((String) cmbGenero.getSelectedItem());
            vendedor.setContrasenia(pswNuevoPass.getText());

            
    }

    public void actualizar(){
        try {
            // Leer los datos actuales del archivo y guardarlos en una nueva LinkedList
            FileInputStream fileIn = new FileInputStream("vendedores.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            LinkedList<vendedores> listaVendedoresActual = (LinkedList<vendedores>) in.readObject();
            in.close();
            fileIn.close();

            // Buscar el vendedor a actualizar en la nueva LinkedList y actualizar sus datos
            for (vendedores vendedorActual : listaVendedoresActual) {
                if (vendedorActual.getCodigo() == Integer.parseInt(txtCodigo.getText())) {
                    vendedorActual.setNombre(txtNombre.getText());
                    vendedorActual.setCaja(Integer.parseInt(txtCaja.getText()));
                    vendedorActual.setVentas(new BigDecimal(txtVentas.getText()));
                    vendedorActual.setGenero((String) cmbGenero.getSelectedItem());
                    vendedorActual.setContrasenia(pswNuevoPass.getText());
                    break;
                }
            }

            // Escribir la nueva LinkedList actualizada en el archivo
            FileOutputStream fileOut = new FileOutputStream("vendedores.dat");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(listaVendedoresActual);
            out.close();
            fileOut.close();

            JOptionPane.showMessageDialog(null, "Vendedor actualizado exitosamente");

            Modulos ad = new Modulos();
            ad.cambioVendedor(true);
            dispose();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pCreaVendedor = new javax.swing.JPanel();
        lbl_crearVendedor = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        txtCodigo = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        lblCaja = new javax.swing.JLabel();
        lblVentas = new javax.swing.JLabel();
        lblGenero = new javax.swing.JLabel();
        lblNuevoPass = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtCaja = new javax.swing.JTextField();
        txtVentas = new javax.swing.JTextField();
        pswNuevoPass = new javax.swing.JPasswordField();
        cmbGenero = new javax.swing.JComboBox<>();
        btnActualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pCreaVendedor.setBackground(new java.awt.Color(204, 255, 255));

        lbl_crearVendedor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl_crearVendedor.setText("Crear Nuevo Vendedor");

        lblCodigo.setText("Código:");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        lblNombre.setText("Nombre:");

        lblCaja.setText("Caja:");

        lblVentas.setText("Ventas:");

        lblGenero.setText("Genero");

        lblNuevoPass.setText("Password:");

        cmbGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" }));
        cmbGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbGeneroActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pCreaVendedorLayout = new javax.swing.GroupLayout(pCreaVendedor);
        pCreaVendedor.setLayout(pCreaVendedorLayout);
        pCreaVendedorLayout.setHorizontalGroup(
            pCreaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCreaVendedorLayout.createSequentialGroup()
                .addGroup(pCreaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pCreaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pCreaVendedorLayout.createSequentialGroup()
                            .addGap(141, 141, 141)
                            .addComponent(lbl_crearVendedor))
                        .addGroup(pCreaVendedorLayout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addGroup(pCreaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblNuevoPass)
                                .addGroup(pCreaVendedorLayout.createSequentialGroup()
                                    .addGroup(pCreaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblCodigo)
                                        .addComponent(lblNombre)
                                        .addComponent(lblCaja)
                                        .addComponent(lblVentas)
                                        .addComponent(lblGenero))
                                    .addGap(43, 43, 43)
                                    .addGroup(pCreaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                                        .addComponent(txtNombre)
                                        .addComponent(txtCaja)
                                        .addComponent(txtVentas)
                                        .addComponent(cmbGenero, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                    .addGroup(pCreaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pCreaVendedorLayout.createSequentialGroup()
                            .addComponent(btnAgregar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnActualizar))
                        .addComponent(pswNuevoPass, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        pCreaVendedorLayout.setVerticalGroup(
            pCreaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCreaVendedorLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lbl_crearVendedor)
                .addGap(40, 40, 40)
                .addGroup(pCreaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pCreaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pCreaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCaja)
                    .addComponent(txtCaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pCreaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVentas)
                    .addComponent(txtVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pCreaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGenero)
                    .addComponent(cmbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pCreaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNuevoPass)
                    .addComponent(pswNuevoPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pCreaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnActualizar))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pCreaVendedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pCreaVendedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
    
        try {
            FileInputStream fileIn = new FileInputStream("vendedores.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            listaVendedores = (LinkedList<vendedores>) in.readObject();
            in.close();
            fileIn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        
        CreaListaVendedor();
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void cmbGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbGeneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbGeneroActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        actualizar();
    }//GEN-LAST:event_btnActualizarActionPerformed

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
            java.util.logging.Logger.getLogger(CargaVendedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CargaVendedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CargaVendedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CargaVendedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CargaVendedores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JComboBox<String> cmbGenero;
    private javax.swing.JLabel lblCaja;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNuevoPass;
    private javax.swing.JLabel lblVentas;
    private javax.swing.JLabel lbl_crearVendedor;
    private javax.swing.JPanel pCreaVendedor;
    private javax.swing.JPasswordField pswNuevoPass;
    private javax.swing.JTextField txtCaja;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtVentas;
    // End of variables declaration//GEN-END:variables
}
