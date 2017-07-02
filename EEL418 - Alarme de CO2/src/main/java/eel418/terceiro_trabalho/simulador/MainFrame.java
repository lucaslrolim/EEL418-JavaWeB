package eel418.terceiro_trabalho.simulador;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;

public class MainFrame extends javax.swing.JFrame {
    static      String  ip_destino_str;
    static      String  porta_destino_str;
    static   MainFrame  mainFrame;
    static Transmissor  tx;
               boolean  alarme = false;

    public MainFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        text_Porta_destino = new javax.swing.JTextField();
        text_IP_destino = new javax.swing.JTextField();
        botao_iniciar = new javax.swing.JButton();
        botao_parar = new javax.swing.JButton();
        text_parado_transmitindo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        botaoALARME = new javax.swing.JToggleButton();

        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 450));
        setPreferredSize(new java.awt.Dimension(600, 450));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SIMULADOR DE SENSOR DE MONÓXIDO DE CARBONO");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, 580, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("PORTA DE DESTINO (SERVIDOR):");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("IP DE DESTINO (SERVIDOR):");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 240, -1));

        text_Porta_destino.setBackground(new java.awt.Color(0, 51, 255));
        text_Porta_destino.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        text_Porta_destino.setForeground(new java.awt.Color(51, 255, 255));
        text_Porta_destino.setText("8084");
        getContentPane().add(text_Porta_destino, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 130, -1));

        text_IP_destino.setBackground(new java.awt.Color(0, 51, 255));
        text_IP_destino.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        text_IP_destino.setForeground(new java.awt.Color(51, 255, 255));
        text_IP_destino.setText("127.0.0.1");
        getContentPane().add(text_IP_destino, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 130, -1));

        botao_iniciar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botao_iniciar.setForeground(new java.awt.Color(0, 204, 51));
        botao_iniciar.setText("INICIAR");
        botao_iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_iniciarActionPerformed(evt);
            }
        });
        getContentPane().add(botao_iniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 100, -1));

        botao_parar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botao_parar.setForeground(new java.awt.Color(255, 0, 0));
        botao_parar.setText("PARAR");
        botao_parar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_pararActionPerformed(evt);
            }
        });
        getContentPane().add(botao_parar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, 100, -1));

        text_parado_transmitindo.setEditable(false);
        text_parado_transmitindo.setBackground(new java.awt.Color(0, 51, 255));
        text_parado_transmitindo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        text_parado_transmitindo.setForeground(new java.awt.Color(51, 255, 255));
        text_parado_transmitindo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        text_parado_transmitindo.setFocusable(false);
        getContentPane().add(text_parado_transmitindo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 470, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("\"http://IP_DESTINO:PORTA_DESTINO/terceiro_trabalho/input\"");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("O objeto é enviado a cada 5 segundos, e o valor é escolhido no painel abaixo.");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("O destino TEM que ser uma aplicação com a URI ");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("onde input é a url de um servlet que recebe um objeto JSON ");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("com um campo booleano chamado \"alarme\".");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, -1));

        botaoALARME.setBackground(new java.awt.Color(0, 204, 0));
        botaoALARME.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botaoALARME.setText("FALSE");
        botaoALARME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoALARMEActionPerformed(evt);
            }
        });
        getContentPane().add(botaoALARME, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 340, 140, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botao_iniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_iniciarActionPerformed
        ip_destino_str = text_IP_destino.getText();
        porta_destino_str = text_Porta_destino.getText();
        if(ip_destino_str.isEmpty() || porta_destino_str.isEmpty()){
            text_parado_transmitindo.setText("PREENCHA O IP E A PORTA DE DESTINO CORRETAMENTE");
        }else{
            tx = new Transmissor();
            tx.start();
            text_parado_transmitindo.setText("TRANSMITINDO");     
        }
    }//GEN-LAST:event_botao_iniciarActionPerformed

    private void botao_pararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_pararActionPerformed
        tx.ok = false;
        tx = null;
        text_parado_transmitindo.setText("PARADO");
    }//GEN-LAST:event_botao_pararActionPerformed

    private void botaoALARMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoALARMEActionPerformed
        if(evt.getActionCommand().equals("FALSE")){
            botaoALARME.setText("TRUE");
            botaoALARME.setBackground(Color.red);
            Transmissor.alarme = true;
        }else{
            botaoALARME.setText("FALSE");
            botaoALARME.setBackground(new java.awt.Color(0, 204, 0));
            Transmissor.alarme = false;
        };
    }//GEN-LAST:event_botaoALARMEActionPerformed

    public static void main(String args[]) {

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                mainFrame = new MainFrame();
                mainFrame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton botaoALARME;
    private javax.swing.JButton botao_iniciar;
    private javax.swing.JButton botao_parar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField text_IP_destino;
    private javax.swing.JTextField text_Porta_destino;
    javax.swing.JTextField text_parado_transmitindo;
    // End of variables declaration//GEN-END:variables
}

class Transmissor extends Thread{
    
    Socket sCliente;
    InetAddress remoteAddress;
    BufferedReader entrada;
    String linha;
    PrintStream saida;
    float tetaF = 0F;
    float delta = 0.1F;
    int ii = 0;
    boolean ok;
    static Boolean alarme = false;
    
    @Override
    public void run(){
        ok = true;
        while (ok) {
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
            enviarRequest(alarme.toString());
        }
    }
    
    void enviarRequest(String alarme) {
        try {
            remoteAddress = InetAddress.getByName(MainFrame.ip_destino_str);
            sCliente = new Socket(remoteAddress, Integer.parseInt(MainFrame.porta_destino_str));
            saida = new PrintStream(sCliente.getOutputStream());
            entrada = new BufferedReader(
                        new InputStreamReader(
                            sCliente.getInputStream()));
        } catch (Exception e) {
            MainFrame.mainFrame.text_parado_transmitindo.setText(
                                        "ERRO NA CONEXÃO COM O SERVIDOR");
            e.printStackTrace();
        }
        try {
            //String dados = "alarme="+alarme;;
            String dados = "alarme="+alarme;
            String request =
               "POST /terceiro_trabalho/servlet HTTP/1.1\r\n"
             + "Host: "+MainFrame.ip_destino_str+":"+MainFrame.porta_destino_str+"\r\n"
             + "Keep-Alive: 115\n"
             + "Content-Type: application/x-www-form-urlencoded\r\n"
             + "Content-Length: " + Integer.toString(dados.length()) + "\r\n"
             + "\r\n"
             + dados;
  
//System.out.println("=== request HTTP:\n" + request);
            saida.print(request);
            saida.flush();
            sCliente.shutdownOutput();
            
            
            sCliente.close();
/*            
//--------------------------------------------
//            System.out.println("\n=== Recebeu response: ");
            do {
                linha = entrada.readLine();
                if (linha != null) {
                    if (linha.equals("")) {
//                        System.out.println("(linha vazia)");
                    } else {
//                        System.out.println(linha);
                    }
                }
            } while (entrada.ready());
*/        
//            System.out.print("=== FIM ===\n\n");
        } catch (Exception e) {
            MainFrame.mainFrame.text_parado_transmitindo.setText(
                                        "ERRO NA COMUNICAÇÃO COM O SERVIDOR");
            e.printStackTrace();
        }
    }
}