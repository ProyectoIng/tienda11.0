
package Vista;

import Controlador.*;
import Modelo.Producto;
import Modelo.Usuario;
import static Vista.PantallaAdminTablaUsuarios.idaux;
import static Vista.PantallaIngresar.usuario;
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.BasicConfigurator;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;


public class PantallaAdminTablaProductos extends javax.swing.JFrame {

     DefaultTableModel modelo;
     private boolean resultado = false;
     static String idaux;
     DaoProductoXml datosProducto = new DaoProductoXml();//Creo objeto del controlador del producto
    
     private TableRowSorter trsfiltro;
    
    public PantallaAdminTablaProductos(java.awt.Frame parent, boolean modal,String id) {
        initComponents();
        
        modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Precio");
        modelo.addColumn("Imagen");
        modelo.addColumn("Categoria");
        modelo.addColumn("Proveedor");
        modelo.addColumn("Id");
        modelo.addColumn("Estado");
        modelo.addColumn("Cant.Mínima");
        modelo.addColumn("Cant.Actual");
        
        this.jTable1.setModel(modelo);//a mi tabla table le asigno el tipo modelo que cree ahora
        
        llenaTabla(id);//Lleno la tabla
        
        //imagen de fondo
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Pantalla");
        
        ((JPanel)getContentPane()).setOpaque(false);
        ImageIcon uno = new ImageIcon(this.getClass().getResource("/imagenes/04092gverdeprimavera.jpg"));
        JLabel fondo = new JLabel();
        fondo.setIcon(uno);
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
    }

   public void filtro() {
   trsfiltro.setRowFilter(RowFilter.regexFilter(jTextField1.getText(), 0));
   }
    
     private void llenaTabla(String id)
    {   
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);
        
        ArrayList<Producto> Lista = datosProducto.todosLosProductos();
        

        for (Producto pro : Lista)
        {
           

             if (pro != null) {
               String[] row = {pro.getNombre(),pro.getDescripcion(),pro.getPrecio(),pro.getImagen(),pro.getCategoria(),pro.getProveedor(),pro.getIdProducto(),pro.getEstadoProducto(),pro.getCantidadMinima(),pro.getCantidadActual()};
               modelo.addRow(row);
             }
            
            
        jTable1.setModel(modelo);
            
            
            
        }
            
     }   
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        JBVolver = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(950, 400));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Eliminar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Modificar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Agregar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        JBVolver.setText("Volver");
        JBVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBVolverActionPerformed(evt);
            }
        });

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jLabel1.setText("Buscar Producto ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(10, 10, 10))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JBVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JBVolver)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        PantallaAdminAgregarProducto _PantallaAdminAgregarProducto = new PantallaAdminAgregarProducto();
        _PantallaAdminAgregarProducto.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        
        BasicConfigurator.configure();
        int filaSeleccionada = jTable1.getSelectedRow();//Obtengo la fila seleccionada
        String nombre,descripcion,precio,imagen,categoria,proveedor,id,estado,cantidadMinima,cantidadActual;
        //meto los valores de la fila seleccionada en las variables
        
        if (filaSeleccionada >= 0 ){
        nombre = jTable1.getValueAt(filaSeleccionada, 0).toString();
        descripcion = jTable1.getValueAt(filaSeleccionada, 1).toString();
        precio = jTable1.getValueAt(filaSeleccionada, 2).toString();
        imagen = jTable1.getValueAt(filaSeleccionada, 3).toString();
        categoria = jTable1.getValueAt(filaSeleccionada, 4).toString();
        proveedor = jTable1.getValueAt(filaSeleccionada, 5).toString();
        id = jTable1.getValueAt(filaSeleccionada, 6).toString();
        estado = jTable1.getValueAt(filaSeleccionada, 7).toString();
        cantidadMinima = jTable1.getValueAt(filaSeleccionada, 8).toString();
        cantidadActual = jTable1.getValueAt(filaSeleccionada, 9).toString();
        
        //creo objeto producto
        Producto pro = new Producto(nombre, descripcion, precio, imagen, categoria, proveedor, id, estado, cantidadMinima, cantidadActual);
        //abro la pantalla de modificar y le paso como parametro mi objeto
        PantallaAdminModificarProducto _PantallaModificarProducto = new PantallaAdminModificarProducto(pro);
        _PantallaModificarProducto.setVisible(true);
        this.setVisible(false);
         //log4j
        Logger log = Logger.getLogger("Logger de Ejemplo");
        log.info("admin producto satisfactorio");
        }else{
        
            JOptionPane.showMessageDialog(null, "No has seleccionado ningun producto");
          //log4j
           Logger log = Logger.getLogger("Logger de Ejemplo");
            log.warning("error no se encontro ninguna seleccion");   
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        String idProductoSeleccionado;
        
        int filaseleccionada = jTable1.getSelectedRow();// le asigno a la variable la fila seleccionada
        
        
        
        if (filaseleccionada >= 0){
        
            
            idProductoSeleccionado = jTable1.getValueAt(filaseleccionada, 6).toString();
            
            
            datosProducto.borrarProducto(idProductoSeleccionado);//Borro el producto con el id seleccionado
            modelo.removeRow(filaseleccionada);
             //log4j
            Logger log = Logger.getLogger("Logger de Ejemplo");
            log.info("el objeto se ha eliminado");
            
        }else{
            JOptionPane.showMessageDialog(null, "Tabla vacía o no seleccionó fila");
             //log4j
            Logger log = Logger.getLogger("Logger de Ejemplo");
            log.warning("error no se pudo eliminar");
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void JBVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBVolverActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
                   
                   public void run() {
                   new PantallaInicialInvUsuario(usuario).setVisible(true);
                   }
                   });
                   this.setVisible(false); 
    }//GEN-LAST:event_JBVolverActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped

        jTextField1.addKeyListener(new KeyAdapter() {
            public void keyReleased(final KeyEvent e) {
                String cadena = (jTextField1.getText());
                jTextField1.setText(cadena);
                repaint();
                filtro();
            }
        });
        trsfiltro = new TableRowSorter(jTable1.getModel());
        jTable1.setRowSorter(trsfiltro);

    }//GEN-LAST:event_jTextField1KeyTyped

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
            java.util.logging.Logger.getLogger(PantallaAdminTablaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaAdminTablaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaAdminTablaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaAdminTablaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaAdminTablaProductos(new javax.swing.JFrame(), true, idaux).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBVolver;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
