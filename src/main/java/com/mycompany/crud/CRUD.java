
package com.mycompany.crud;

import View.TelaCrud; // IMPORTANTE: Substitua 'TelaCrud' pelo nome exato da classe da sua tela

/**
 *
 * @author Helena Amaro
 */
public class CRUD {
    
   public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            // Trocamos o 'logger' problemático por um print padrão do Java
            ex.printStackTrace();
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new TelaCrud().setVisible(true));
    }
}