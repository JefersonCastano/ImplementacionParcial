package vista;

import controlador.AbstractController;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Accion;
import modelo.iQueryEstado;

/**
 * @brief Clase concreta para una vista
 * @author Jeferson Castano Ossa <jcastanoossa@unicauca.edu.co>
 * @author David Santiago Giron Munoz <davidgiron@unicauca.edu.co>
*/
public class SeguimientoAcciones extends javax.swing.JFrame implements iView{

    //Modelo y controlador asociado a la vista
    iQueryEstado modelo;
    AbstractController controlador;
    
    //Lista de acciones disponibles para seguir por el usuario
    List<Accion> accionesDisp;
    
    /**
     * Creates new form seguimientoValores
     * @param accionesDisp
     */
    public SeguimientoAcciones(List<Accion> accionesDisp) {
        initComponents();
        this.accionesDisp = accionesDisp;
        fillCbxAccionesDisp();
        initializeTable();
        setLocationRelativeTo(null);
    }
    //Inicializar tabla para las acciones seguidas por el usuario 
    private void initializeTable() {
        tblAcciones.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Nombre", "Precio actual", "Precio anterior", "Umbral Inf", "Umbral Sup"
                }
        )); 
    }
    //Llenar tabla con las acciones seguidas por el usuario
    private void fillTable(List<Accion> listAcciones) {
        initializeTable();
        DefaultTableModel model = (DefaultTableModel) tblAcciones.getModel();

        Object rowData[] = new Object[5];//No columnas
        for (int i = 0; i < listAcciones.size(); i++) {
            rowData[0] = listAcciones.get(i).getNombre();
            rowData[1] = listAcciones.get(i).getActPrecio();
            rowData[2] = listAcciones.get(i).getOldPrecio();
            rowData[3] = listAcciones.get(i).getUmbralInf();
            rowData[4] = listAcciones.get(i).getUmbralSup();

            model.addRow(rowData);
        }
    }
    //Llenar comboBox con las acciones disponibles
    private void fillCbxAccionesDisp (){
        cbxAccionesDisp.removeAllItems();
        cbxAccionesDisp.addItem("<Seleccione>");
        for(Accion accion: accionesDisp){
            cbxAccionesDisp.addItem(accion.getNombre() +" - Precio actual: " +accion.getActPrecio());
        }
    }
    //Verificar que una accion disponible este seleccionada
    private boolean isCbxAccionesDispSelected(){
        if(cbxAccionesDisp.getSelectedIndex() < 1){
            JOptionPane.showMessageDialog(null, "Selecciona una accion", "Atenci�n", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        return true;
    }
    //Llenar comboBox con las acciones seguidas por el usuario
    private void fillCbxAccionesUser (){
        cbxAccionesUser.removeAllItems();
        cbxAccionesUser.addItem("<Seleccione>");
        for(Accion accion: modelo.getAcciones()){
            cbxAccionesUser.addItem(accion.getNombre());
        }
    }
    //Verificar que una accion seguida por el usuario este seleccionada
    private boolean isCbxAccionesUserSelected(){
        if(cbxAccionesUser.getSelectedIndex() < 1){
            JOptionPane.showMessageDialog(null, "Selecciona una accion", "Atenci�n", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        return true;
    }
    
    @Override
    public void mostrarVista() {
        this.setVisible(true);
    }

     @Override
    public void setController(AbstractController controlador) {
        this.controlador = controlador;
    }

    @Override
    public void setModel(iQueryEstado modelo) {
        this.modelo = modelo;
    }

    @Override
    public void actualizar(String estado) {
        //Llenar tabla y comboBox con las nuevas acciones seguidas por el usuario
        fillTable(modelo.getAcciones());
        fillCbxAccionesUser();
        //Imprimir el estado cambiado
        System.out.println(estado);
    }
    
    //Valida que un string se pueda convertir en numero
    private boolean numeroValido (String numero){
        float valor;
        try{
            valor = Float.valueOf(numero);
        }catch(Exception e){
            return false;
        }
        return true;
    }  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAcciones = new javax.swing.JTable();
        lblAddAcc = new javax.swing.JLabel();
        lblDelAcc = new javax.swing.JLabel();
        btnAddAcc = new javax.swing.JButton();
        btnDelAcc = new javax.swing.JButton();
        cbxAccionesDisp = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtUmbralInf = new javax.swing.JTextField();
        txtUmbralSup = new javax.swing.JTextField();
        lbUmbralInf = new javax.swing.JLabel();
        lbUmbralSup = new javax.swing.JLabel();
        lbAccionesUsuario = new javax.swing.JLabel();
        lbAccionEliminar = new javax.swing.JLabel();
        cbxAccionesUser = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblAcciones.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblAcciones);

        lblAddAcc.setText("Agregar accion:");

        lblDelAcc.setText("Eliminar accion:");

        btnAddAcc.setText("Agregar");
        btnAddAcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAccActionPerformed(evt);
            }
        });

        btnDelAcc.setText("Eliminar");
        btnDelAcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelAccActionPerformed(evt);
            }
        });

        cbxAccionesDisp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxAccionesDisp.setSelectedItem(tblAcciones);
        cbxAccionesDisp.setToolTipText("cvbc");

        jLabel1.setText("Seleccione una accion:");

        lbUmbralInf.setText("Umbral inferior:");

        lbUmbralSup.setText("Umbral superior");

        lbAccionesUsuario.setText("Acciones del usuario:");

        lbAccionEliminar.setText("Seleccione una accion:");

        cbxAccionesUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxAccionesUser.setSelectedItem(tblAcciones);
        cbxAccionesUser.setToolTipText("cvbc");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDelAcc)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbAccionEliminar)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnDelAcc)
                                    .addComponent(cbxAccionesUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAddAcc)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(lbUmbralInf)
                                    .addComponent(lbUmbralSup))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAddAcc)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cbxAccionesDisp, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtUmbralInf)
                                        .addComponent(txtUmbralSup)))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbAccionesUsuario)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(lblAddAcc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cbxAccionesDisp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUmbralInf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbUmbralInf))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUmbralSup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbUmbralSup))
                        .addGap(18, 18, 18)
                        .addComponent(btnAddAcc)
                        .addGap(23, 23, 23)
                        .addComponent(lblDelAcc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbAccionEliminar)
                            .addComponent(cbxAccionesUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnDelAcc))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lbAccionesUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddAccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAccActionPerformed
        
        //Validacion de que una acciones disponible este seleccionada
        if(!isCbxAccionesDispSelected()) return;
        Accion accion = accionesDisp.get(cbxAccionesDisp.getSelectedIndex()-1);
        
        //Validacion de que los umbrales sean de tipo numerico
        if(!numeroValido(txtUmbralInf.getText()) || !numeroValido(txtUmbralSup.getText())){    
            JOptionPane.showMessageDialog(null, "Ingrese valores numericos", "Atenci�n", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        float limIn = Float.valueOf(txtUmbralInf.getText());
        float limSup = Float.valueOf(txtUmbralSup.getText());
        
        //Validacion de que los umbrales sean validos de manera logica 
        if (limIn >= limSup || limIn > accion.getActPrecio() || accion.getActPrecio() > limSup) {
            JOptionPane.showMessageDialog(null, "Ingrese umbrales validos", "Atenci�n", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        //Agregar accion como accion seguida por el usuario
        controlador.fijarUmbrales(accion, limIn, limSup);
        controlador.agregarAccion(accion); 
        
        //Quitar accion como accion disponible
        accionesDisp.remove(accion);
        
        JOptionPane.showMessageDialog(null, "Se ha agregado la accion con exito", "Atenci�n", JOptionPane.INFORMATION_MESSAGE);
        
        //Resetear opcioens de agregar accion
        fillCbxAccionesDisp();
        txtUmbralInf.setText("");
        txtUmbralSup.setText("");
    }//GEN-LAST:event_btnAddAccActionPerformed

    private void btnDelAccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelAccActionPerformed
        
        //Validacion de que una acciones seguida por el usuario este seleccionada
        if(!isCbxAccionesUserSelected()) return;
        Accion accion = modelo.getAcciones().get(cbxAccionesUser.getSelectedIndex()-1);
        
        //Se agrega la accion como una accion disponible y se elimina de las acciones seguidas por el usuario
        accionesDisp.add(accion);
        controlador.eliminarAccion(accion);
        
        JOptionPane.showMessageDialog(null, "Se ha eliminado la accion con exito", "Atenci�n", JOptionPane.INFORMATION_MESSAGE);
        
        //Se actualizan las acciones disponibles
        fillCbxAccionesDisp();
    }//GEN-LAST:event_btnDelAccActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddAcc;
    private javax.swing.JButton btnDelAcc;
    private javax.swing.JComboBox<String> cbxAccionesDisp;
    private javax.swing.JComboBox<String> cbxAccionesUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbAccionEliminar;
    private javax.swing.JLabel lbAccionesUsuario;
    private javax.swing.JLabel lbUmbralInf;
    private javax.swing.JLabel lbUmbralSup;
    private javax.swing.JLabel lblAddAcc;
    private javax.swing.JLabel lblDelAcc;
    private javax.swing.JTable tblAcciones;
    private javax.swing.JTextField txtUmbralInf;
    private javax.swing.JTextField txtUmbralSup;
    // End of variables declaration//GEN-END:variables
}
