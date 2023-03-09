/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package POS;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NELSON
 */
public class Modulos extends javax.swing.JFrame {

    /**
     * Creates new form Modulos
     */
    public Modulos() {
        initComponents();
        llena_tabla_vendedores();
        llena_tabla_clientes();
        llena_tabla_productos();
        llena_tabla_sucursales();
    }

   private int seleccionar;
    
   private LinkedList<vendedores> listaVendedores = new LinkedList<vendedores>();
   private LinkedList<clientes> listaClientes = new LinkedList<clientes>();
   private LinkedList<productos> listaProductos = new LinkedList<productos>();
   private LinkedList<sucursales> listaSucursales = new LinkedList<sucursales>();
   
    public void cambioVendedor(boolean solicitud) {
        if (solicitud) {
            pVendedores.setBackground(new Color(204, 255, 255));
        }else{
            pVendedores.setBackground(Color.blue);
        }
        setVisible(true);
        pModulos.setSelectedIndex(3); // Seleccionar el panel de vendedores
    }
    
    public void cambioCliente(boolean solicitud) {
        if (solicitud) {
            pClientes.setBackground(new Color(204, 255, 255));
        }else{
            pClientes.setBackground(Color.blue);
        }
        setVisible(true);
        pModulos.setSelectedIndex(2); // Seleccionar el panel de vendedores
    }
    
    public void cambioSucursal(boolean solicitud) {
        if (solicitud) {
            pSucursales.setBackground(new Color(204, 255, 255));
        }else{
            pSucursales.setBackground(Color.blue);
        }
        setVisible(true);
        pModulos.setSelectedIndex(0); // Seleccionar el panel de vendedores
    }
    
    public void cambioProducto(boolean solicitud) {
        if (solicitud) {
            pProductos.setBackground(new Color(204, 255, 255));
        }else{
            pProductos.setBackground(Color.blue);
        }
        setVisible(true);
        pModulos.setSelectedIndex(1); // Seleccionar el panel de vendedores
    }
    
    public void llena_tabla_vendedores() {
 
        try {
            FileInputStream fileIn = new FileInputStream("vendedores.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            
            //tomamos la lista ya creada
            listaVendedores = (LinkedList<vendedores>) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("La lista se ha deserializado correctamente");
            
            String columnas[] = {"codigo", "nombre", "caja","ventas","genero"};
            DefaultTableModel t1 = new DefaultTableModel(null, columnas);

            for (vendedores v : listaVendedores) {
                Object[] fila = new Object[5];
                fila[0] = v.getCodigo();
                fila[1] = v.getNombre();
                fila[2] = v.getCaja();
                fila[3] = v.getVentas();
                fila[4] = v.getGenero();
                t1.addRow(fila);
            }
            
            tblVendedores.setModel(t1);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        }

        public void llena_tabla_clientes() {
 
        try {
            FileInputStream fileIn = new FileInputStream("clientes.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            
            //tomamos la lista ya creada
            listaClientes = (LinkedList<clientes>) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("La lista Clientes se ha deserializado correctamente");
            
            String columnas[] = {"codigo", "nombre", "Nit","Correo","Genero"};
            DefaultTableModel t1 = new DefaultTableModel(null, columnas);

            for (clientes v : listaClientes) {
                Object[] fila = new Object[5];
                fila[0] = v.getCodigo();
                fila[1] = v.getNombre();
                fila[2] = v.getNit();
                fila[3] = v.getCorreo();
                fila[4] = v.getGenero();
                t1.addRow(fila);
            }
            
            tblClientes.setModel(t1);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        }
        
        public void llena_tabla_productos() {
 
        try {
            FileInputStream fileIn = new FileInputStream("productos.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            
            //tomamos la lista ya creada
            listaProductos = (LinkedList<productos>) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("La lista de productos se ha deserializado correctamente");
            
            String columnas[] = {"codigo", "nombre", "Descripción","cantidad","precio"};
            DefaultTableModel t1 = new DefaultTableModel(null, columnas);

            for (productos v : listaProductos) {
                Object[] fila = new Object[5];
                fila[0] = v.getCodigo();
                fila[1] = v.getNombre();
                fila[2] = v.getDescripcion();
                fila[3] = v.getCantidad();
                fila[4] = v.getPrecio();
                t1.addRow(fila);
            }
            
            tblProductos.setModel(t1);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        }
        
        
        public void llena_tabla_sucursales() {
 
        try {
            FileInputStream fileIn = new FileInputStream("sucursales.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            
            //tomamos la lista ya creada
            listaSucursales = (LinkedList<sucursales>) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("La lista Sucursales se ha deserializado correctamente");
            
            String columnas[] = {"codigo", "nombre", "Dirección","Correo","Telefono"};
            DefaultTableModel t1 = new DefaultTableModel(null, columnas);

            for (sucursales v : listaSucursales) {
                Object[] fila = new Object[5];
                fila[0] = v.getCodigo();
                fila[1] = v.getNombre();
                fila[2] = v.getDireccion();
                fila[3] = v.getCorreo();
                fila[4] = v.getTelefono();
                t1.addRow(fila);
            }
            
            tblSucursales.setModel(t1);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        }
 
       public void eliminar(int posicion) {
    try {
        // Leer los datos actuales del archivo y guardarlos en una nueva LinkedList
        FileInputStream fileIn = new FileInputStream("vendedores.dat");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        LinkedList<vendedores> listaVendedoresActual = (LinkedList<vendedores>) in.readObject();
        in.close();
        fileIn.close();

        // Eliminar el vendedor en la posición deseada de la nueva LinkedList
        listaVendedoresActual.remove(posicion);

        // Escribir la nueva LinkedList actualizada en el archivo
        FileOutputStream fileOut = new FileOutputStream("vendedores.dat");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(listaVendedoresActual);
        out.close();
        fileOut.close();

        JOptionPane.showMessageDialog(null, "Vendedor eliminado exitosamente");

        Modulos ad = new Modulos();
        ad.cambioVendedor(true);
        dispose();

    } catch (Exception e) {
        e.printStackTrace();
    }
}
       
       
          public void eliminarCliente(int posicion) {
            try {
                // Leer los datos actuales del archivo y guardarlos en una nueva LinkedList
                FileInputStream fileIn = new FileInputStream("clientes.dat");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                LinkedList<clientes> listaClientesActual = (LinkedList<clientes>) in.readObject();
                in.close();
                fileIn.close();

                // Eliminar el vendedor en la posición deseada de la nueva LinkedList
                listaClientesActual.remove(posicion);

                // Escribir la nueva LinkedList actualizada en el archivo
                FileOutputStream fileOut = new FileOutputStream("clientes.dat");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(listaClientesActual);
                out.close();
                fileOut.close();

                JOptionPane.showMessageDialog(null, "Cliente eliminado exitosamente");

                Modulos ad = new Modulos();
                ad.cambioCliente(true);
                dispose();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
          
          public void eliminarProducto(int posicion) {
            try {
                // Leer los datos actuales del archivo y guardarlos en una nueva LinkedList
                FileInputStream fileIn = new FileInputStream("productos.dat");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                LinkedList<productos> listaProductosActual = (LinkedList<productos>) in.readObject();
                in.close();
                fileIn.close();

                // Eliminar el vendedor en la posición deseada de la nueva LinkedList
                listaProductosActual.remove(posicion);

                // Escribir la nueva LinkedList actualizada en el archivo
                FileOutputStream fileOut = new FileOutputStream("productos.dat");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(listaProductosActual);
                out.close();
                fileOut.close();

                JOptionPane.showMessageDialog(null, "Producto eliminado exitosamente");

                Modulos ad = new Modulos();
                ad.cambioProducto(true);
                dispose();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
          
          public void eliminarSucursal(int posicion) {
            try {
                // Leer los datos actuales del archivo y guardarlos en una nueva LinkedList
                FileInputStream fileIn = new FileInputStream("sucursales.dat");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                LinkedList<sucursales> listaSucursalesActual = (LinkedList<sucursales>) in.readObject();
                in.close();
                fileIn.close();

                // Eliminar el vendedor en la posición deseada de la nueva LinkedList
                listaSucursalesActual.remove(posicion);

                // Escribir la nueva LinkedList actualizada en el archivo
                FileOutputStream fileOut = new FileOutputStream("sucursales.dat");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(listaSucursalesActual);
                out.close();
                fileOut.close();

                JOptionPane.showMessageDialog(null, "Sucursal eliminado exitosamente");

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

        pModulos = new javax.swing.JTabbedPane();
        pSucursales = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblSucursales = new javax.swing.JTable();
        btnCreaSucursales = new javax.swing.JButton();
        btnCreaCargaMas = new javax.swing.JButton();
        btnActualizaSuc = new javax.swing.JButton();
        btnEliminaSuc = new javax.swing.JButton();
        btnExportarPdf = new javax.swing.JButton();
        pProductos = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        btnCrearProducto = new javax.swing.JButton();
        btnCargaMasivaProd = new javax.swing.JButton();
        btnActualizarProducto = new javax.swing.JButton();
        btnEliminarProducto = new javax.swing.JButton();
        btnExportarPDFProducto = new javax.swing.JButton();
        pClientes = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        btnCrearCliente = new javax.swing.JButton();
        btnCargaMasClientes = new javax.swing.JButton();
        btnActualizarCliente = new javax.swing.JButton();
        btnEliminarCliiente = new javax.swing.JButton();
        BtnExportaPDF = new javax.swing.JButton();
        pVendedores = new javax.swing.JPanel();
        btnCrear = new javax.swing.JButton();
        btnCargaMasiva = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnExportarPDF = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVendedores = new javax.swing.JTable();
        btnCerrarSesion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblSucursales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tblSucursales);

        btnCreaSucursales.setText("Crear");
        btnCreaSucursales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreaSucursalesActionPerformed(evt);
            }
        });

        btnCreaCargaMas.setText("Carga Masiva");

        btnActualizaSuc.setText("Actualizar");
        btnActualizaSuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizaSucActionPerformed(evt);
            }
        });

        btnEliminaSuc.setText("Eliminar");
        btnEliminaSuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminaSucActionPerformed(evt);
            }
        });

        btnExportarPdf.setText("Exportar a un PDF");

        javax.swing.GroupLayout pSucursalesLayout = new javax.swing.GroupLayout(pSucursales);
        pSucursales.setLayout(pSucursalesLayout);
        pSucursalesLayout.setHorizontalGroup(
            pSucursalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pSucursalesLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addGroup(pSucursalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pSucursalesLayout.createSequentialGroup()
                        .addGroup(pSucursalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCreaSucursales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnActualizaSuc, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                        .addGap(33, 33, 33)
                        .addGroup(pSucursalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCreaCargaMas, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                            .addComponent(btnEliminaSuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btnExportarPdf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        pSucursalesLayout.setVerticalGroup(
            pSucursalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pSucursalesLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(pSucursalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCreaCargaMas, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                    .addComponent(btnCreaSucursales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(pSucursalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnActualizaSuc, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                    .addComponent(btnEliminaSuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39)
                .addComponent(btnExportarPdf)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pSucursalesLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pModulos.addTab("Sucursales", pSucursales);

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblProductos);

        btnCrearProducto.setText("Crear");
        btnCrearProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearProductoActionPerformed(evt);
            }
        });

        btnCargaMasivaProd.setText("Carga Masiva");

        btnActualizarProducto.setText("Actualizar");
        btnActualizarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarProductoActionPerformed(evt);
            }
        });

        btnEliminarProducto.setText("Eliminar");
        btnEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProductoActionPerformed(evt);
            }
        });

        btnExportarPDFProducto.setText("Exportar a PDF");

        javax.swing.GroupLayout pProductosLayout = new javax.swing.GroupLayout(pProductos);
        pProductos.setLayout(pProductosLayout);
        pProductosLayout.setHorizontalGroup(
            pProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pProductosLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(pProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnActualizarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                            .addComponent(btnCrearProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(pProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCargaMasivaProd, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                            .addComponent(btnEliminarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pProductosLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(btnExportarPDFProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        pProductosLayout.setVerticalGroup(
            pProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pProductosLayout.createSequentialGroup()
                .addGroup(pProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pProductosLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pProductosLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(pProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCargaMasivaProd, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                            .addComponent(btnCrearProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(pProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnActualizarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                            .addComponent(btnEliminarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(34, 34, 34)
                        .addComponent(btnExportarPDFProducto)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pModulos.addTab("Productos", pProductos);

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tblClientes);

        btnCrearCliente.setText("Crear");
        btnCrearCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearClienteActionPerformed(evt);
            }
        });

        btnCargaMasClientes.setText("Carga Masiva");

        btnActualizarCliente.setText("Actualizar");
        btnActualizarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarClienteActionPerformed(evt);
            }
        });

        btnEliminarCliiente.setText("Eliminar");
        btnEliminarCliiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCliienteActionPerformed(evt);
            }
        });

        BtnExportaPDF.setText("Exportar Listado a PDF");

        javax.swing.GroupLayout pClientesLayout = new javax.swing.GroupLayout(pClientes);
        pClientes.setLayout(pClientesLayout);
        pClientesLayout.setHorizontalGroup(
            pClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pClientesLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(pClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnActualizarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCrearCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(32, 32, 32)
                        .addGroup(pClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCargaMasClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminarCliiente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pClientesLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(BtnExportaPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        pClientesLayout.setVerticalGroup(
            pClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pClientesLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(pClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pClientesLayout.createSequentialGroup()
                        .addGroup(pClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCrearCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCargaMasClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnActualizarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminarCliiente, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(BtnExportaPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pModulos.addTab("Clientes", pClientes);

        pVendedores.setBackground(new java.awt.Color(204, 255, 255));

        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnCargaMasiva.setText("Carga Masiva");

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnExportarPDF.setText("Exportar listado a PDF");

        tblVendedores.setShowGrid(false);
        tblVendedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVendedoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblVendedores);

        javax.swing.GroupLayout pVendedoresLayout = new javax.swing.GroupLayout(pVendedores);
        pVendedores.setLayout(pVendedoresLayout);
        pVendedoresLayout.setHorizontalGroup(
            pVendedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pVendedoresLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(pVendedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnExportarPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pVendedoresLayout.createSequentialGroup()
                        .addGroup(pVendedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                            .addComponent(btnCrear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pVendedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCargaMasiva, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pVendedoresLayout.setVerticalGroup(
            pVendedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pVendedoresLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(pVendedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pVendedoresLayout.createSequentialGroup()
                        .addGroup(pVendedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCargaMasiva, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pVendedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(btnExportarPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(73, Short.MAX_VALUE))
        );

        pModulos.addTab("Vendedores", pVendedores);

        btnCerrarSesion.setBackground(new java.awt.Color(255, 102, 102));
        btnCerrarSesion.setText("cerrar sesión");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pModulos)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnCerrarSesion))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(btnCerrarSesion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pModulos, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
      
        CargaVendedores ad = new CargaVendedores();
        ad.cambioCreaVendedor(true);
        dispose();
            
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        
        try {
            FileInputStream fileIn = new FileInputStream("vendedores.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            
            //tomamos la lista ya creada
            listaVendedores = (LinkedList<vendedores>) in.readObject();
            in.close();
            fileIn.close();
         
            CargaVendedores cv = new CargaVendedores();

            cv.editarVendedor(listaVendedores.get(tblVendedores.getSelectedRow()));
            
            dispose();
        
        } catch (Exception e) {
            e.printStackTrace();
        }  
        
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void tblVendedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVendedoresMouseClicked
        System.out.println(tblVendedores.getSelectedRows());
        System.out.println(tblVendedores.getSelectedRow());
    }//GEN-LAST:event_tblVendedoresMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminar(tblVendedores.getSelectedRow());
        System.out.println(tblVendedores.getSelectedRow());
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        dispose();
        POS po = new POS();
        po.setVisible(true);
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnCrearClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearClienteActionPerformed
        CargaClientes ad = new CargaClientes();
        ad.cambioCreaCliente(true);
        dispose();
    }//GEN-LAST:event_btnCrearClienteActionPerformed

    private void btnActualizarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarClienteActionPerformed
        try {
            FileInputStream fileIn = new FileInputStream("clientes.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            
            //tomamos la lista ya creada
            listaClientes = (LinkedList<clientes>) in.readObject();
            in.close();
            fileIn.close();
         
            CargaClientes cv = new CargaClientes();

            cv.editarCliente(listaClientes.get(tblClientes.getSelectedRow()));
            
            dispose();
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnActualizarClienteActionPerformed

    private void btnEliminarCliienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCliienteActionPerformed
        eliminarCliente(tblClientes.getSelectedRow());
        System.out.println(tblClientes.getSelectedRow());
    }//GEN-LAST:event_btnEliminarCliienteActionPerformed

    private void btnCrearProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearProductoActionPerformed
            
        CargaProductos prod = new CargaProductos();
        prod.cambioCreaProducto(true);
        dispose();
    }//GEN-LAST:event_btnCrearProductoActionPerformed

    private void btnActualizarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarProductoActionPerformed
                
        try {
            FileInputStream fileIn = new FileInputStream("productos.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            
            //tomamos la lista ya creada
            listaProductos = (LinkedList<productos>) in.readObject();
            in.close();
            fileIn.close();
         
            CargaProductos prod = new CargaProductos();

            prod.editarProductos(listaProductos.get(tblProductos.getSelectedRow()));
            
            dispose();
        
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }//GEN-LAST:event_btnActualizarProductoActionPerformed

    private void btnEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProductoActionPerformed
        eliminarProducto(tblProductos.getSelectedRow());
        System.out.println(tblProductos.getSelectedRow());
    }//GEN-LAST:event_btnEliminarProductoActionPerformed

    private void btnCreaSucursalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreaSucursalesActionPerformed
        CargaSucursales suc = new CargaSucursales();
        suc.cambioCreaSucursal(true);
        dispose();
    }//GEN-LAST:event_btnCreaSucursalesActionPerformed

    private void btnActualizaSucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizaSucActionPerformed
       try {
            FileInputStream fileIn = new FileInputStream("sucursales.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            
            //tomamos la lista ya creada
            listaSucursales = (LinkedList<sucursales>) in.readObject();
            in.close();
            fileIn.close();
         
            CargaSucursales cv = new CargaSucursales();

            cv.editarSucursal(listaSucursales.get(tblSucursales.getSelectedRow()));
            
            dispose();
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnActualizaSucActionPerformed

    private void btnEliminaSucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminaSucActionPerformed
               eliminarSucursal(tblSucursales.getSelectedRow());
               System.out.println(tblSucursales.getSelectedRow());
    }//GEN-LAST:event_btnEliminaSucActionPerformed

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
            java.util.logging.Logger.getLogger(Modulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Modulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Modulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Modulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Modulos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnExportaPDF;
    private javax.swing.JButton btnActualizaSuc;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnActualizarCliente;
    private javax.swing.JButton btnActualizarProducto;
    private javax.swing.JButton btnCargaMasClientes;
    private javax.swing.JButton btnCargaMasiva;
    private javax.swing.JButton btnCargaMasivaProd;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnCreaCargaMas;
    private javax.swing.JButton btnCreaSucursales;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnCrearCliente;
    private javax.swing.JButton btnCrearProducto;
    private javax.swing.JButton btnEliminaSuc;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminarCliiente;
    private javax.swing.JButton btnEliminarProducto;
    private javax.swing.JButton btnExportarPDF;
    private javax.swing.JButton btnExportarPDFProducto;
    private javax.swing.JButton btnExportarPdf;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel pClientes;
    private javax.swing.JTabbedPane pModulos;
    private javax.swing.JPanel pProductos;
    private javax.swing.JPanel pSucursales;
    private javax.swing.JPanel pVendedores;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTable tblSucursales;
    public javax.swing.JTable tblVendedores;
    // End of variables declaration//GEN-END:variables
}
