/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package POS;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.util.LinkedList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;


public class CargaClientes extends javax.swing.JFrame {

   
    public CargaClientes() {
        initComponents();
    }

    //metodo para mostrar la ventana donde se carga un nuevo vendedor
    public void cambioCreaCliente(boolean solicitud) {
        setVisible(true);
        btnActualizaCliente.setVisible(false);
    }    

        private LinkedList<clientes> listaClientes = new LinkedList<clientes>();


         //Metodo para crear la persistencia
        public void CreaListaCliente(){
                // Obtener los valores ingresados por el usuario
                String codClienteTexto = txtCodigoCliente.getText();
                String nombreCliente = txtNombreCliente.getText();
                String nitTexto = txtNitCliente.getText();
                String correoTexto = txtCorreoCliente.getText();

                DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) cmbGeneroCliente.getModel();
                int selectedIndex = cmbGeneroCliente.getSelectedIndex();
                String selectedValue = model.getElementAt(selectedIndex);
                String generoCliente = selectedValue;



                    // Validar el campo "codigo"
                    boolean codigoValido = codClienteTexto.matches("\\d+");
                    if (!codigoValido) {
                        // El valor ingresado no es un número entero, informar al usuario
                        JOptionPane.showMessageDialog(null, "El valor ingresado en el campo 'codigo cliente' no es un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                    // Salir del método si alguno de los campos no es válido
                    if ( !codigoValido ) {
                        return;
                    }

                    // Convertir los valores a enteros
                    int codigo = Integer.parseInt(codClienteTexto);
                    // Agregar un nuevo cliente a la lista
                    clientes cli = new clientes(codigo, codClienteTexto, nitTexto, correoTexto, generoCliente);
                    listaClientes.add(cli);

                    // Escribir la lista completa en el archivo "clientes.dat"
                    try {
                        FileOutputStream fileOut = new FileOutputStream("clientes.dat");
                        ObjectOutputStream out = new ObjectOutputStream(fileOut);
                        out.writeObject(listaClientes);
                        out.close();
                        fileOut.close();

                        JOptionPane.showMessageDialog(null, "Cliente ingresado Exitosamente");

                        Modulos ad = new Modulos();
                        ad.cambioCliente(true);
                        dispose();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    // Imprimir todos los vendedores en la lista
                    for (clientes cliente : listaClientes) {
                        System.out.print(" Registro insertado: " + cliente);
                        System.out.print(" Código: " + cliente.getCodigo());
                        System.out.print(" Nombre: " + cliente.getNombre());
                        System.out.print(" Nit: " + cliente.getNit());
                        System.out.print(" Correo: " + cliente.getCorreo());
                        System.out.print(" Género: " + cliente.getGenero());
                        System.out.println("");
                    }
            }
        
        
        
        public void editarCliente(clientes cliente) {
            // Llenar los campos del panel con los valores del objeto vendedor
            txtCodigoCliente.setText(String.valueOf(cliente.getCodigo()));
            txtNombreCliente.setText(cliente.getNombre());
            txtNitCliente.setText(String.valueOf(cliente.getNit()));
            txtCorreoCliente.setText(String.valueOf(cliente.getCorreo()));

            // Seleccionar el valor correcto en el combo box de género
            DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) cmbGeneroCliente.getModel();
            int selectedIndex = 0;
            for (int i = 0; i < model.getSize(); i++) {
                if (model.getElementAt(i).equals(cliente.getGenero())) {
                    selectedIndex = i;
                    break;
                }
            }
            cmbGeneroCliente.setSelectedIndex(selectedIndex);

            // Mostrar el panel
            setVisible(true);
            
            btnCreaCliente.setVisible(false);



            cliente.setCodigo(Integer.parseInt(txtCodigoCliente.getText()));
            cliente.setNombre(txtNombreCliente.getText());
            cliente.setNit(txtNitCliente.getText());
            cliente.setCorreo(txtCorreoCliente.getText());
            cliente.setGenero((String) cmbGeneroCliente.getSelectedItem());

            
            }
        
        
        
        public void actualizarCliente(){
        try {
            // Leer los datos actuales del archivo y guardarlos en una nueva LinkedList
            FileInputStream fileIn = new FileInputStream("clientes.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            LinkedList<clientes> listaClientesActual = (LinkedList<clientes>) in.readObject();
            in.close();
            fileIn.close();

            // Buscar el vendedor a actualizar en la nueva LinkedList y actualizar sus datos
            for (clientes clienteActual : listaClientesActual) {
                if (clienteActual.getCodigo() == Integer.parseInt(txtCodigoCliente.getText())) {
                    clienteActual.setNombre(txtNombreCliente.getText());
                    clienteActual.setNit(txtNitCliente.getText());
                    clienteActual.setCorreo(txtCorreoCliente.getText());
                    clienteActual.setGenero((String) cmbGeneroCliente.getSelectedItem());
                    break;
                }
            }

            // Escribir la nueva LinkedList actualizada en el archivo
            FileOutputStream fileOut = new FileOutputStream("clientes.dat");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(listaClientesActual);
            out.close();
            fileOut.close();

            JOptionPane.showMessageDialog(null, "Cliente actualizado exitosamente");

            Modulos ad = new Modulos();
            ad.cambioCliente(true);
            dispose();

        } catch (Exception e) {
            e.printStackTrace();
        }
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
        txtCodigoCliente = new javax.swing.JTextField();
        txtNombreCliente = new javax.swing.JTextField();
        txtNitCliente = new javax.swing.JTextField();
        txtCorreoCliente = new javax.swing.JTextField();
        btnCreaCliente = new javax.swing.JButton();
        btnActualizaCliente = new javax.swing.JButton();
        cmbGeneroCliente = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 255));

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Crear Nuevo Cliente");
        jLabel1.setToolTipText("");

        jLabel2.setText("Código Cliente:");

        jLabel3.setText("Nombre Cliente:");

        jLabel4.setText("Nit:");

        jLabel5.setText("Correo:");

        jLabel6.setText("Genero:");

        btnCreaCliente.setText("Crear");
        btnCreaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreaClienteActionPerformed(evt);
            }
        });

        btnActualizaCliente.setText("Actualizar");
        btnActualizaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizaClienteActionPerformed(evt);
            }
        });

        cmbGeneroCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodigoCliente)
                    .addComponent(txtNombreCliente)
                    .addComponent(txtNitCliente)
                    .addComponent(txtCorreoCliente)
                    .addComponent(cmbGeneroCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnCreaCliente)
                                .addGap(18, 18, 18)
                                .addComponent(btnActualizaCliente))
                            .addComponent(jLabel1))
                        .addGap(0, 14, Short.MAX_VALUE)))
                .addGap(87, 87, 87))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtNitCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtCorreoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbGeneroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreaCliente)
                    .addComponent(btnActualizaCliente))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreaClienteActionPerformed
        try {
            FileInputStream fileIn = new FileInputStream("clientes.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            listaClientes = (LinkedList<clientes>) in.readObject();
            in.close();
            fileIn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        CreaListaCliente();
    }//GEN-LAST:event_btnCreaClienteActionPerformed

    private void btnActualizaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizaClienteActionPerformed
       actualizarCliente();
    }//GEN-LAST:event_btnActualizaClienteActionPerformed

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
            java.util.logging.Logger.getLogger(CargaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CargaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CargaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CargaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CargaClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizaCliente;
    private javax.swing.JButton btnCreaCliente;
    private javax.swing.JComboBox<String> cmbGeneroCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCodigoCliente;
    private javax.swing.JTextField txtCorreoCliente;
    private javax.swing.JTextField txtNitCliente;
    private javax.swing.JTextField txtNombreCliente;
    // End of variables declaration//GEN-END:variables
}
