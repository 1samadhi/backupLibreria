package vista;

import javax.swing.JOptionPane;
import modelo.Libro;
import modelo.Conexion;
import modelo.Libro;
import modelo.LibroDAO;

import javax.swing.table.DefaultTableModel;
import java.util.List;


public class LibroView extends javax.swing.JFrame {
    // Variables de instancia
    private final LibroDAO libroDAO;
    
    public LibroView() {
        initComponents(); // Inicializa la interfaz gráfica
        Conexion conexionDB = new Conexion(); // Crea la conexión
        libroDAO = new LibroDAO(conexionDB.getConnection()); // Inicializa LibroDAO
        configurarTabla(); // Configura la tabla
        cargarLibrosEnTabla(); // Carga datos en la tabla
    }
    
    private void configurarTabla() {
        String[] columnas = {"ID", "Título", "Autor", "Género", "Publicado", "Cantidad", "Precio"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        tblLibros.setModel(modelo); // tblLibros es tu JTable
    }
    
    private void cargarLibrosEnTabla() {
        DefaultTableModel modelo = (DefaultTableModel) tblLibros.getModel();
        modelo.setRowCount(0); // Limpia la tabla
        List<Libro> libros = libroDAO.obtenerLibros(); // Obtiene los libros desde la base de datos
        for (Libro libro : libros) {
            modelo.addRow(new Object[]{
                libro.getId(),
                libro.getTitulo(),
                libro.getAutor(),
                libro.getGenero(),
                libro.getPublicado(),
                libro.getCantidad(),
                libro.getPrecio()
            });
        }
    }
    
    private void limpiarCampos() {
    txtTitulo.setText("");
    txtAutor.setText("");
    txtGenero.setText("");
    txtPublicado.setText("");
    txtCantidad.setText("");
    txtPrecio.setText("");
}
 

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblAutor = new javax.swing.JLabel();
        lblGenero = new javax.swing.JLabel();
        lblPublicado = new javax.swing.JLabel();
        lblCantidad = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        txtAutor = new javax.swing.JTextField();
        txtGenero = new javax.swing.JTextField();
        txtPublicado = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLibros = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTitulo.setText("Título");

        lblAutor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblAutor.setText("Autor");

        lblGenero.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblGenero.setText("Género");

        lblPublicado.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPublicado.setText("Fecha de publicación");

        lblCantidad.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCantidad.setText("Cantidad");

        lblPrecio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPrecio.setText("Precio");

        txtTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTituloActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnListar.setText("Listar");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        tblLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Título", "Autor", "Género", "Publicado", "Cantidad", "Precio"
            }
        ));
        tblLibros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLibrosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblLibros);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 937, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblGenero)
                            .addComponent(lblAutor)
                            .addComponent(lblTitulo))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtAutor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                            .addComponent(txtTitulo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGenero))
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPublicado)
                            .addComponent(lblCantidad)
                            .addComponent(lblPrecio))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPublicado)
                            .addComponent(txtCantidad)
                            .addComponent(txtPrecio)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnAgregar)
                        .addGap(80, 80, 80)
                        .addComponent(btnEditar)
                        .addGap(80, 80, 80)
                        .addComponent(btnEliminar)
                        .addGap(80, 80, 80)
                        .addComponent(btnListar)))
                .addGap(283, 283, 283))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminar)
                    .addComponent(btnListar))
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitulo)
                    .addComponent(lblPublicado)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPublicado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAutor)
                    .addComponent(lblCantidad)
                    .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGenero)
                    .addComponent(lblPrecio)
                    .addComponent(txtGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTituloActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
                                    
    
    // Código para agregar un libro
    String titulo = txtTitulo.getText();
    String autor = txtAutor.getText();
    String genero = txtGenero.getText();
    String publicado = txtPublicado.getText();
    int cantidad = Integer.parseInt(txtCantidad.getText());
    int precio = Integer.parseInt(txtPrecio.getText());

    Libro libro = new Libro(0, titulo, autor, genero, publicado, cantidad, precio);
    boolean insertado = libroDAO.insertarLibro(libro);

    if (insertado) {
        JOptionPane.showMessageDialog(this, "Libro agregado correctamente.");
        cargarLibrosEnTabla();
        limpiarCampos();
    } else {
        JOptionPane.showMessageDialog(this, "Error al agregar el libro.");
    }

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
    cargarLibrosEnTabla();
    }//GEN-LAST:event_btnListarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
    int filaSeleccionada = tblLibros.getSelectedRow();
    if (filaSeleccionada == -1) {
        JOptionPane.showMessageDialog(this, "Seleccione un libro para editar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        return;
    }

    int id = Integer.parseInt(tblLibros.getValueAt(filaSeleccionada, 0).toString());
    String titulo = txtTitulo.getText();
    String autor = txtAutor.getText();
    String genero = txtGenero.getText();
    String publicado = txtPublicado.getText();
    int cantidad = Integer.parseInt(txtCantidad.getText());
    int precio = Integer.parseInt(txtPrecio.getText());

    Libro libro = new Libro(id, titulo, autor, genero, publicado, cantidad, precio);
    //Llamar al método actualizar del DAO
    boolean actualizado = libroDAO.actualizarLibro(libro);

    if (actualizado) {
        JOptionPane.showMessageDialog(this, "Libro actualizado correctamente.");
        cargarLibrosEnTabla();
        limpiarCampos();
    } else {
        JOptionPane.showMessageDialog(this, "Error al actualizar el libro.");
    }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
    int filaSeleccionada = tblLibros.getSelectedRow();
    if (filaSeleccionada == -1) {
        JOptionPane.showMessageDialog(this, "Seleccione un libro para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        return;
    }

    int id = Integer.parseInt(tblLibros.getValueAt(filaSeleccionada, 0).toString());
    int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar este libro?", "Confirmación", JOptionPane.YES_NO_OPTION);
    if (confirmacion == JOptionPane.YES_OPTION) {
        boolean eliminado = libroDAO.eliminarLibro(id);

        if (eliminado) {
            JOptionPane.showMessageDialog(this, "Libro eliminado correctamente.");
            cargarLibrosEnTabla();
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(this, "Error al eliminar el libro.");
        }
    }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tblLibrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLibrosMouseClicked
    int filaSeleccionada = tblLibros.getSelectedRow();

    if (filaSeleccionada != -1) {
        // Cargar los datos de la fila seleccionada en los campos de texto
        txtTitulo.setText(tblLibros.getValueAt(filaSeleccionada, 1).toString());
        txtAutor.setText(tblLibros.getValueAt(filaSeleccionada, 2).toString());
        txtGenero.setText(tblLibros.getValueAt(filaSeleccionada, 3).toString());
        txtPublicado.setText(tblLibros.getValueAt(filaSeleccionada, 4).toString());
        txtCantidad.setText(tblLibros.getValueAt(filaSeleccionada, 5).toString());
        txtPrecio.setText(tblLibros.getValueAt(filaSeleccionada, 6).toString());
    }
    }//GEN-LAST:event_tblLibrosMouseClicked

    
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
            java.util.logging.Logger.getLogger(LibroView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LibroView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LibroView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LibroView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LibroView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnListar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAutor;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblPublicado;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblLibros;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtGenero;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtPublicado;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
