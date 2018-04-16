/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcsample;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author AGUIRREMR
 */

import  jdbcsample.employee.frmMain;

public class app {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

       
        
        
        
 /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMain().setVisible(true);
            }
        });

    }

}
