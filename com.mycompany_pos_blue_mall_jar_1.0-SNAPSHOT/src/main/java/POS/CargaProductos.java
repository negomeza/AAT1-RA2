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

/**
 *
 * @author NELSON
 */
public class CargaProductos extends javax.swing.JFrame {

    /**
     * Creates new form CargaProductos
     */
    public CargaProductos() {
        initComponents();
    }
    
    private LinkedList<productos> listaProductos = new LinkedList<productos>();

    //metodo para mostrar la ventana donde se carga un nuevo vendedor
    public void cambioCreaProducto(boolean solicitud) {
        setVisible(true);
        btnActualizarProd.setVisible(false);
    }
    
    
     //Metodo para crear la persistencia
    public void CreaListaProducto(){
        // Obtener los valores ingresados por el usuario
        String codigoTexto = txtCodigoProducto.getText();
        String nombre = txtNombre.getText();
        String Descripcion = txtDescripcionProd.getText();
        String cantidadTexto = txtCantidadProd.getText();
        String precioTexto = txtPrecio.getText();
        



            // Validar el campo "codigo"
            boolean codigoValido = codigoTexto.matches("\\d+");
            if (!codigoValido) {
                // El valor ingresado no es un número entero, informar al usuario
                JOptionPane.showMessageDialog(null, "El valor ingresado en el campo 'codigo' no es un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            // Validar el campo "codigo"
            boolean cantidadValido = codigoTexto.matches("\\d+");
            if (!cantidadValido) {
                // El valor ingresado no es un número entero, informar al usuario
                JOptionPane.showMessageDialog(null, "El valor ingresado en el campo 'cantidad' no es un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
            }            
            
            // Validar el campo "ventas"
            boolean precioValido = precioTexto.matches("\\d+(\\.\\d{1,10})");
            if (!precioValido ) {
                // El valor ingresado no es un número de moneda, informar al usuario
                JOptionPane.showMessageDialog(null, "El valor ingresado en el campo 'ventas' no es un número moneda ejemplo(155.10).", "Error", JOptionPane.ERROR_MESSAGE);
            }


            // Salir del método si alguno de los campos no es válido
            if (!cantidadValido || !codigoValido || !precioValido) {
                return;
            }

            // Convertir los valores a enteros
            int codigo = Integer.parseInt(codigoTexto);
            int cantidad = Integer.parseInt(cantidadTexto);
            BigDecimal precio = new BigDecimal(precioTexto);
            // Agregar un nuevo vendedor a la lista
            productos prod = new productos(codigo, nombre, Descripcion,cantidad, precio);
            listaProductos.add(prod);

            // Escribir la lista completa en el archivo "vendedores.dat"
            try {
                FileOutputStream fileOut = new FileOutputStream("productos.dat");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(listaProductos);
                out.close();
                fileOut.close();

                JOptionPane.showMessageDialog(null, "Producto ingresado Exitosamente");

                Modulos ad = new Modulos();
                ad.cambioProducto(true);
                dispose();

            } catch (Exception e) {
                e.printStackTrace();
            }

            // Imprimir todos los vendedores en la lista
            for (productos producto : listaProductos) {
                System.out.print(" Registro insertado: " + producto);
                System.out.print(" Código: " + producto.getCodigo());
                System.out.print(" Nombre: " + producto.getNombre());
                System.out.print(" Descripcion: " + producto.getDescripcion());
                System.out.print(" Cantidad: " + producto.getCantidad());
                System.out.print(" Ventas: " + producto.getPrecio());
                System.out.println("");
            }
    }
    
    
    public void actualizarProductos(){
        try {
            // Leer los datos actuales del archivo y guardarlos en una nueva LinkedList
            FileInputStream fileIn = new FileInputStream("productos.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            LinkedList<productos> listaProductosActual = (LinkedList<productos>) in.readObject();
            in.close();
            fileIn.close();

            // Buscar el vendedor a actualizar en la nueva LinkedList y actualizar sus datos
            for (productos productoActual : listaProductosActual) {
                if (productoActual.getCodigo() == Integer.parseInt(txtCodigoProducto.getText())) {
                    productoActual.setNombre(txtNombre.getText());
                    productoActual.setDescripcion(txtDescripcionProd.getText());
                    productoActual.setCantidad(Integer.parseInt(txtCantidadProd.getText()));
                    productoActual.setPrecio(new BigDecimal(txtPrecio.getText()));
                    break;
                }
            }

            // Escribir la nueva LinkedList actualizada en el archivo
            FileOutputStream fileOut = new FileOutputStream("productos.dat");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(listaProductosActual);
            out.close();
            fileOut.close();

            JOptionPane.showMessageDialog(null, "Producto actualizado exitosamente");

            Modulos ad = new Modulos();
            ad.cambioProducto(true);
            dispose();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public void editarProductos(productos producto) {
            // Llenar los campos del panel con los valores del objeto vendedor
            txtCodigoProducto.setText(String.valueOf(producto.getCodigo()));
            txtNombre.setText(producto.getNombre());
            txtDescripcionProd.setText(producto.getDescripcion());
            txtCantidadProd.setText(String.valueOf(producto.getCantidad()));
            txtPrecio.setText(String.valueOf(producto.getPrecio()));

            // Mostrar el panel
            setVisible(true);
            
            btnCrearProd.setVisible(false);

            producto.setCodigo(Integer.parseInt(txtCodigoProducto.getText()));
            producto.setNombre(txtNombre.getText());
            producto.setDescripcion(txtDescripcionProd.getText());
            producto.setCantidad(Integer.parseInt(txtCantidadProd.getText()));
            producto.setPrecio(new BigDecimal(txtPrecio.getText()));

    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCodigoProducto = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtDescripcionProd = new javax.swing.JTextField();
        txtCantidadProd = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        btnCrearProd = new javax.swing.JButton();
        btnActualizarProd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Código:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Descripción:");

        jLabel4.setText("Cantidad:");

        jLabel5.setText("Precio:");

        btnCrearProd.setText("Crear");
        btnCrearProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearProdActionPerformed(evt);
            }
        });

        btnActualizarProd.setText("Actualizar");
        btnActualizarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarProdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCrearProd)
                        .addGap(30, 30, 30)
                        .addComponent(btnActualizarProd))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtCodigoProducto)
                        .addComponent(txtNombre)
                        .addComponent(txtDescripcionProd)
                        .addComponent(txtCantidadProd)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDescripcionProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCantidadProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrearProd)
                    .addComponent(btnActualizarProd))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearProdActionPerformed
        
        try {
            FileInputStream fileIn = new FileInputStream("productos.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            listaProductos = (LinkedList<productos>) in.readObject();
            in.close();
            fileIn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        
        CreaListaProducto();
        
    }//GEN-LAST:event_btnCrearProdActionPerformed

    private void btnActualizarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarProdActionPerformed
        actualizarProductos();
    }//GEN-LAST:event_btnActualizarProdActionPerformed

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
            java.util.logging.Logger.getLogger(CargaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CargaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CargaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CargaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CargaProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarProd;
    private javax.swing.JButton btnCrearProd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtCantidadProd;
    private javax.swing.JTextField txtCodigoProducto;
    private javax.swing.JTextField txtDescripcionProd;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
