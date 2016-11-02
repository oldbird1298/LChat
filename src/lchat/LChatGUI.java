/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lchat;

import chatConnection.ConnectToServer;
import java.awt.EventQueue;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.SwingUtilities;

/**
 *
 * @author dgerontop
 */
public class LChatGUI extends javax.swing.JFrame implements Runnable {

    /**
     * Creates new form LChatGUI
     */
    settingsGUI setupGui = new settingsGUI();
    ConnectToServer con = new ConnectToServer();
    InetAddress server;
    String svr = setupGui.getServer();
    DatagramSocket socket_in = null;
    ExecutorService executor = null;

    public LChatGUI() {

        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chatPanel = new java.awt.Panel();
        userList = new java.awt.List();
        label1 = new java.awt.Label();
        textField1 = new java.awt.TextField();
        sendButton = new java.awt.Button();
        label2 = new java.awt.Label();
        //ConnectToServer conn = new ConnectToServer();
        chatArea = new java.awt.TextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Connect = new javax.swing.JMenuItem();
        exitItem = new javax.swing.JMenuItem();
        Settings = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LChat");
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 2, 2);
        flowLayout1.setAlignOnBaseline(true);
        getContentPane().setLayout(flowLayout1);

        chatPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userListActionPerformed(evt);
            }
        });
        chatPanel.add(userList, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 130, 430));

        label1.setBackground(new java.awt.Color(102, 102, 102));
        label1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        label1.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        label1.setText("Enter :");
        chatPanel.add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 440, 80, 30));

        textField1.setBackground(new java.awt.Color(204, 204, 204));
        textField1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        chatPanel.add(textField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 440, 440, 30));

        sendButton.setBackground(new java.awt.Color(204, 204, 204));
        sendButton.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        sendButton.setLabel("Send");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });
        chatPanel.add(sendButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(647, 440, 70, 30));

        label2.setAlignment(java.awt.Label.CENTER);
        label2.setBackground(new java.awt.Color(204, 204, 204));
        label2.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        label2.setText("Chat List");
        chatPanel.add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 30));

        chatArea.setEditable(false);
        chatPanel.add(chatArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 570, 390));

        getContentPane().add(chatPanel);

        jMenu1.setText("File");

        Connect.setText("Connect");
        Connect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConnectActionPerformed(evt);
            }
        });
        jMenu1.add(Connect);

        exitItem.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        exitItem.setText("Exit");
        exitItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitItemActionPerformed(evt);
            }
        });
        jMenu1.add(exitItem);

        jMenuBar1.add(jMenu1);

        Settings.setText("Edit");
        Settings.setAlignmentX(4.0F);
        Settings.setBorderPainted(true);

        jMenuItem1.setText("Settings");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        Settings.add(jMenuItem1);

        jMenuBar1.add(Settings);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

//chatArea.append(con.receiveData());
    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        // TODO add your handling code here:
        //String msg = String.format("User : %s\n", textField1.getText());
        String msg = textField1.getText();

        svr = setupGui.getServer();
        textField1.getAccessibleContext();
        //textArea1.setText(textField1.getText());
        con.sendData(svr, 28988, msg);
        //chatArea.append(msg);
        textField1.setText("");
    }//GEN-LAST:event_sendButtonActionPerformed

    private void exitItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitItemActionPerformed
        con.sendData(svr, 28988, "bye");
        System.exit((0));
    }//GEN-LAST:event_exitItemActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:

        setupGui.setVisible(true);
        //       chatArea.append(con.receiveData());
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void ConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConnectActionPerformed
        // TODO add your handling code here:
        executor = Executors.newSingleThreadExecutor();

        executor.submit(() -> {
            String msg = null;
            userList.add("User");
            try {
                socket_in = new DatagramSocket(27985);
                if (socket_in.isBound()) {
                    socket_in.close();
                }
                socket_in = new DatagramSocket(27985);
                while (true) {
                    byte[] bf = new byte[65536];
                    DatagramPacket incoming = new DatagramPacket(bf, bf.length);
                    socket_in.receive(incoming);

                    byte[] data = incoming.getData();
                    msg = new String(data, 0, incoming.getLength());
                    msg = "\n" + msg;
                    appendchat(msg);
                    
                    Connect.setText("Disconnect");
                }
            } catch (IOException e) {
                System.err.println("IOException : " + e);

            }
            
            System.out.println(con.receiveData());
        });


    }//GEN-LAST:event_ConnectActionPerformed

    private void userListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userListActionPerformed

    private void appendchat(final String messageToDisplay) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                chatArea.append(messageToDisplay);

            }
        });

    }
// public static void main(String[] args)  {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(LChatGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(LChatGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(LChatGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(LChatGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//       java.awt.EventQueue.invokeLater(new Runnable() {
//           public void run() {
//               LChatGUI client = new LChatGUI();
//               client.setVisible(true);
//               client.appendchat();
//           }
//        });
//        
//        
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Connect;
    private javax.swing.JMenu Settings;
    private java.awt.TextArea chatArea;
    private java.awt.Panel chatPanel;
    private javax.swing.JMenuItem exitItem;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Button sendButton;
    private java.awt.TextField textField1;
    private java.awt.List userList;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        String msg = null;
        try {
            socket_in = new DatagramSocket(27985);
            while (true) {
                byte[] bf = new byte[65536];
                DatagramPacket incoming = new DatagramPacket(bf, bf.length);
                socket_in.receive(incoming);

                byte[] data = incoming.getData();
                msg = new String(data, 0, incoming.getLength());
                appendchat(msg);
            }
        } catch (IOException e) {
            System.err.println("IOException : " + e);

        }
    }
}
