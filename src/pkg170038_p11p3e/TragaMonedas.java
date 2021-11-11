/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg170038_p11p3e;

/**
 *
 * @author 170038
 */
public class TragaMonedas extends javax.swing.JFrame implements Runnable{
    
    // Instancias
    private final Thread hilo1,hilo2,hilo3,hilo4,hilo5;
    private boolean sigue=true;
    private int indice[],num1,num2,num3,num4;
    private String parce1,parce2,parce3,parce4,adj[],parceRonda;
    private float total,ganado,perdido,ronda;
    private String acumJuegos,acumPremios;
    
    
    // Constructor, inicializa lo necesario para ejecutar los hilos correctamente
    public TragaMonedas() {
        adj = new String[4];
        indice = new int[4];
        for(int i=0;i<4;i++){
            adj[i] = "";
        }
        acumJuegos="";
        acumPremios="";
        hilo1 = new Thread(this,"H1");
        hilo2 = new Thread(this,"H2");
        hilo3 = new Thread(this,"H3");
        hilo4 = new Thread(this,"H4");
        hilo5 = new Thread(this,"H5");
        initComponents();
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();
        
        hilo1.suspend();
        hilo2.suspend();
        hilo3.suspend();
        hilo4.suspend();
        this.setLocationRelativeTo(null);
    }
    
    public void set(String nombre,String apuesta){
        txtNombre.setText(nombre);
        txtApuesta.setText("$"+apuesta);
        total = Float.valueOf(apuesta);
        txtFinal.setText("$"+apuesta);
    }
    
    // Funcion para ejecutar los hilos
    public void run(){
        while(sigue){
            try{
                
                // Se ejecuta el hilo 1
                if(Thread.currentThread().getName().equals("H1")){
                    num1 = (int)(Math.random() * (10-0)+0);
                    parce1 = String.valueOf(num1);
                    adj[0] += parce1+"\n";
                    txt1.setText(adj[0]);
                    indice[0]++;
                    hilo1.sleep(200);
                }
                
                // Se ejecuta el hilo 2
                if(Thread.currentThread().getName().equals("H2")){
                    num2 = (int)(Math.random() * (10-0)+0);
                    parce2 = String.valueOf(num2);
                    adj[1] += parce2+"\n";
                    txt2.setText(adj[1]);
                    indice[1]++;
                    hilo2.sleep(200);
                }
                
                // Se ejecuta el hilo 3
                if(Thread.currentThread().getName().equals("H3")){
                    num3 = (int)(Math.random() * (10-0)+0);
                    parce3 = String.valueOf(num3);
                    adj[2] += parce3+"\n";
                    txt3.setText(adj[2]);
                    indice[2]++;
                    hilo3.sleep(200);
                }

                // Se ejecuta el hilo 4
                if(Thread.currentThread().getName().equals("H4")){
                    num4 = (int)(Math.random() * (10-0)+0);
                    parce4 = String.valueOf(num4);
                    adj[3] += parce4+"\n";
                    txt4.setText(adj[3]);
                    indice[3]++;
                    hilo4.sleep(200);
                }
                
                // Se ejecuta el hilo 5 este hilo se usa para actualizar la información
                // que se muestra en pantalla
                if(Thread.currentThread().getName().equals("H5")){
                    String string; 
                    string="$"+String.valueOf(ganado);
                    txtGanado.setText(string);
                    string="";
                    string="$"+String.valueOf(perdido);
                    txtPerdido.setText(string); 
                    string="";
                    string="$"+String.valueOf(total);
                    txtFinal.setText(string);
                    txtJuegos.setText(acumJuegos);
                    txtPremios.setText(acumPremios);
                    hilo5.sleep(1);
                }
                
                // Si los contadores de cada hilo llega a 7
                // se detiene cada hilo
                if(indice[0]==7){
                    hilo1.suspend();
                }
                if(indice[1]==7){
                    hilo2.suspend();
                }
                if(indice[2]==7){
                    hilo3.suspend();
                }
                if(indice[3]==7){
                    hilo4.suspend();
                }
                
                // Cuando todos los hilos se hayan detenido, se verifica 
                // el premio
                if(indice[0]==7 && indice[1]==7 && indice[2]==7 && indice[3]==7){
                    if(num1==num2 && num1==num3 && num1==num4){
                        ronda=500;
                    }else if(num1==num2 && num1==num3){
                        ronda=250;
                    }else if(num1==num2 && num1==num4){
                        ronda=250;
                    }else if(num1==num3 && num1==num4){
                        ronda=250;
                    }else if(num2==num1 && num2==num3){
                        ronda=250;
                    }else if(num2==num1 && num2==num4){
                        ronda=250;
                    }else if(num2==num3 && num2==num4){
                        ronda=250;
                    }else if(num3==num1 && num3==num2){
                        ronda=250;
                    }else if(num3==num1 && num3==num4){
                        ronda=250;
                    }else if(num3==num2 && num3==num4){
                        ronda=250;
                    }else if(num1==num2){
                        ronda=100;
                    }else if(num1==num3){
                        ronda=100;
                    }else if(num1==num4){
                        ronda=100;
                    }else if(num2==num3){
                        ronda=100;
                    }else if(num2==num4){
                        ronda=100;
                    }else if(num3==num4){
                        ronda=100;
                    }else{
                        ronda=-50;
                    }
                }
            }catch(InterruptedException e){
            }
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtApuesta = new javax.swing.JTextField();
        btnPalanca = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt2 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt3 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        txt4 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        txtGanado = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPerdido = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtFinal = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtJuegos = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtPremios = new javax.swing.JTextArea();
        btnRetirarse = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Traga monedas 3000");

        jLabel2.setText("Jugador");

        txtNombre.setEditable(false);

        jLabel3.setText("Apuesta inicial");

        txtApuesta.setEditable(false);

        btnPalanca.setText("Tirar palanca");
        btnPalanca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPalancaActionPerformed(evt);
            }
        });

        txt1.setEditable(false);
        txt1.setColumns(20);
        txt1.setRows(5);
        jScrollPane1.setViewportView(txt1);

        txt2.setEditable(false);
        txt2.setColumns(20);
        txt2.setRows(5);
        jScrollPane2.setViewportView(txt2);

        txt3.setEditable(false);
        txt3.setColumns(20);
        txt3.setRows(5);
        jScrollPane3.setViewportView(txt3);

        txt4.setEditable(false);
        txt4.setColumns(20);
        txt4.setRows(5);
        jScrollPane4.setViewportView(txt4);

        jLabel4.setText("Ganado");

        txtGanado.setEditable(false);
        txtGanado.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setText("Perdido");

        txtPerdido.setEditable(false);
        txtPerdido.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setText("Final");

        txtFinal.setEditable(false);
        txtFinal.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setText("Partidas");

        txtJuegos.setEditable(false);
        txtJuegos.setColumns(20);
        txtJuegos.setRows(5);
        jScrollPane5.setViewportView(txtJuegos);

        txtPremios.setEditable(false);
        txtPremios.setColumns(20);
        txtPremios.setRows(5);
        jScrollPane6.setViewportView(txtPremios);

        btnRetirarse.setText("Retirarse");
        btnRetirarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetirarseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnRetirarse, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(txtApuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(60, 60, 60)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addGap(10, 10, 10)
                                .addComponent(txtGanado, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(btnPalanca, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtPerdido, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jLabel7)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(txtApuesta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane4)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPalanca, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtGanado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtPerdido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addComponent(jScrollPane6)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(btnRetirarse, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
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

    private void btnPalancaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPalancaActionPerformed
        // TODO add your handling code here:
        // Cuando activa la ruleta se reinician los atributos necesarios para ejecutar 
        // los hilos de forma correcta
        for(int i=0;i<4;i++){
            adj[i]="";
            indice[i]=0;
        }
        // Si ronda es negativo, se le suma a lo perdido o a lo ganado si es positivo
        if(ronda<0){
            perdido+=ronda;
        }else{
            ganado+=ronda;
        }
        total+=ronda;
        
        // Se registra en las instancias las partidas
        parceRonda=String.valueOf(ronda);
        acumJuegos+=parce1+" "+parce2+" "+parce3+" "+parce4+"\n";
        acumPremios+=parceRonda+"\n";
        
        // Se reanudan los hilos
        hilo1.resume();
        hilo2.resume();
        hilo3.resume();
        hilo4.resume();
    }//GEN-LAST:event_btnPalancaActionPerformed

    private void btnRetirarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetirarseActionPerformed
        // TODO add your handling code here:
        // Mostrar mensaje de despedida
        Despedida obj = new Despedida();
        obj.set(txtNombre.getText(),txtFinal.getText());
        obj.setVisible(true);
    }//GEN-LAST:event_btnRetirarseActionPerformed

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
            java.util.logging.Logger.getLogger(TragaMonedas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TragaMonedas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TragaMonedas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TragaMonedas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TragaMonedas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPalanca;
    private javax.swing.JButton btnRetirarse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextArea txt1;
    private javax.swing.JTextArea txt2;
    private javax.swing.JTextArea txt3;
    private javax.swing.JTextArea txt4;
    private javax.swing.JTextField txtApuesta;
    private javax.swing.JTextField txtFinal;
    private javax.swing.JTextField txtGanado;
    private javax.swing.JTextArea txtJuegos;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPerdido;
    private javax.swing.JTextArea txtPremios;
    // End of variables declaration//GEN-END:variables
}
