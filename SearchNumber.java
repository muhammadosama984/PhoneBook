/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonedirectory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author usamaasif
 */
public class SearchNumber extends javax.swing.JFrame {

    /**
     * Creates new form SearchNumber
     */
    public SearchNumber() {
        initComponents();
    }
public int CountryCode(String s){
      //String s ="923343237228";
        BigInteger w = new BigInteger(s);
        BigInteger r = new BigInteger("10000000000");
        
        w = w.divide(r);
        
        String  a = w.toString();
       return  Integer.parseInt(a);
  }
public void deleteFromData(String filepath,String phone){
    String tempFile = "temp.txt";
        File oldFile = new File(filepath);
        File newFile = new File(tempFile);
        String phone1 =" ";String name1=" ";
        Scanner x ;
        
          // fw = null;
        try {
           FileWriter fw = new FileWriter(tempFile,true);
        
       
        
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
        
       
            x = new Scanner(new File(filepath));
        
       
            x.useDelimiter("[,\n]");
            while(x.hasNext()){
                phone1 = x.next();
                name1 = x.next();
                
                if (!(phone1.equals(phone))){
                    pw.println(phone1 + ","+name1);
                }
            }
            x.close();
            pw.flush();
            pw.close();
            oldFile.delete();
            File dump = new File(filepath);
            newFile.renameTo(dump);
        } catch (IOException ex) {
            Logger.getLogger(SearchNumber.class.getName()).log(Level.SEVERE, null, ex);
        }
       
}
public void deleteFromHash(String filepath,String phone,String[] arr) throws IOException{
       // filetoArray, find hashnumber, increase hashnumber++ until found, put "null" instead number, copy array to file
        String tempFile = "temp.txt";
        File oldFile = new File(filepath);
        File newFile = new File(tempFile);
        String id =" ";String phone1=" ";
        Scanner x ;
        AddingNumber a = new AddingNumber();
        //int cc = a.pak.length;
        a.fileToArray(filepath, arr);
       int q= a.hash(a.phone(phone));
       while(!(arr[q].equals(phone))){
           q++;
       }
       if(arr[q].equals(phone)){
           arr[q] = "null";
       }
      FileWriter fw = new FileWriter(tempFile,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter ww = new PrintWriter(bw);
                  ww.println("-1"+","+"null");
                         
                         for(int i=0;i<arr.length;i++){
                           ww.println(i+","+arr[i]);
                         }
                         ww.close();
             oldFile.delete();
            File dump = new File(filepath);
            newFile.renameTo(dump);
        
        
        
}
public void editInHash(String filepath,String oldPhone,String newPhone){
    String tempFile = "temp.txt";
        File oldFile = new File(filepath);
        File newFile = new File(tempFile);
        String id =" ";String number=" ";
        //String hashnumber = String.valueOf(q);
        Scanner x ;
        try {
           FileWriter fw = new FileWriter(tempFile,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            x = new Scanner(new File(filepath));
            x.useDelimiter("[,\n]");
            while(x.hasNext()){
                id = x.next();
                number = x.next();
               
                if (number.equals(oldPhone)){
                    pw.println(id + ","+newPhone);
                }
                else{
                    pw.println(id +","+number);
                }
            }
            x.close();
            pw.flush();
            pw.close();
            oldFile.delete();
            File dump = new File(filepath);
            newFile.renameTo(dump);
        } catch (IOException ex) {
        Logger.getLogger(AddingNumber.class.getName()).log(Level.SEVERE, null, ex);
    }
}
public void searching(String filepath, String phone,String []arr) throws FileNotFoundException{
     AddingNumber aa = new AddingNumber();
      String phone1 = "";
    try {
                aa.fileToArray(filepath, arr);
               int q= aa.hash(aa.phone(phone));
               int c = arr.length;
            while((q<arr.length) && !(arr[q].equals(phone)) ){
            //while((arr[q].equals("null")) && !(arr[q].equals(phone)) ){
           q++;
           }
            if(q>= arr.length){
                JOptionPane.showMessageDialog(null, "Record not exists");
                return;
            }
            if(arr[q].equals(phone)){
              phone1 = arr[q];
           }
            } catch (IOException ex) {
                Logger.getLogger(SearchNumber.class.getName()).log(Level.SEVERE, null, ex);
            }
            Scanner sc = new Scanner(new File("data.txt"));
            String name="";String phonenumber="";
         
      
      sc.useDelimiter("[,\n]");
      while(sc.hasNext()){
          
          phonenumber = sc.next();
           name = sc.next();
          if(phonenumber.equals(phone1)){
              displayname.setText(name);
              displaynumber.setText(phonenumber);
              return;
          }
      }
      //jj.setText("Record not exists");
      JOptionPane.showMessageDialog(null, "Record not exists");
      this.setVisible(true);
}
public void editInData(String filepath,String oldPhone,String newPhone,String newName){
    String tempFile = "temp.txt";
        File oldFile = new File(filepath);
        File newFile = new File(tempFile);
        String phone1 =" ";String name1=" ";
        //String hashnumber = String.valueOf(q);
        Scanner x ;
        try {
           FileWriter fw = new FileWriter(tempFile,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            x = new Scanner(new File(filepath));
            x.useDelimiter("[,\n]");
            while(x.hasNext()){
                phone1 = x.next();
                name1 = x.next();
               
                if (phone1.equals(oldPhone)){
                    pw.println(newPhone + ","+newName);
                }
                else{
                    pw.println(phone1 +","+name1);
                }
            }
            x.close();
            pw.flush();
            pw.close();
            oldFile.delete();
            File dump = new File(filepath);
            newFile.renameTo(dump);
        } catch (IOException ex) {
        Logger.getLogger(AddingNumber.class.getName()).log(Level.SEVERE, null, ex);
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
        searchnumber = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        displayname = new javax.swing.JTextField();
        displaynumber = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jj = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("PhoneNumber");

        jButton1.setText("Delete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Search");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setText("Name");

        jLabel3.setText("PhoneNumber");

        displayname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displaynameActionPerformed(evt);
            }
        });

        displaynumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displaynumberActionPerformed(evt);
            }
        });

        jButton4.setText("Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(255, 51, 51));
        jLabel5.setText("Search by entering the phone number");

        jj.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(142, 142, 142))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(68, 68, 68))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(120, 120, 120)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(searchnumber, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(displaynumber, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                                        .addComponent(displayname, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton4)
                                        .addGap(73, 73, 73)
                                        .addComponent(jButton1))
                                    .addComponent(jj, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(96, 96, 96))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(searchnumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jj, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(displayname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(displaynumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton4))
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 64, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String oldphone = searchnumber.getText();
        String name = displayname.getText();
        String phone = displaynumber.getText();
       AddingNumber aa = new AddingNumber();
         int a = CountryCode(phone);
        
            try {
                 if (a==92){
                deleteFromHash( "pakHash.txt",phone,aa.pak);
                 deleteFromData("data.txt",phone);
                JOptionPane.showMessageDialog(null, "Record deleted");
                searchnumber.setText("");displayname.setText("");displaynumber.setText("");
                return;
                
                 }
                 else if (a==91){
                deleteFromHash( "IndHash.txt",phone,aa.ind);
                 deleteFromData("data.txt",phone);
                JOptionPane.showMessageDialog(null, "Record deleted");
                searchnumber.setText("");displayname.setText("");displaynumber.setText("");
                return;
                 }
                 else if (a==44){
                deleteFromHash( "UKHash.txt",phone,aa.UK);
                 deleteFromData("data.txt",phone);
                JOptionPane.showMessageDialog(null, "Record deleted");
                searchnumber.setText("");displayname.setText("");displaynumber.setText("");
                return;
                 }
                 else if (a==1){
                deleteFromHash( "USHash.txt",phone,aa.US);
                 deleteFromData("data.txt",phone);
                JOptionPane.showMessageDialog(null, "Record deleted");
                searchnumber.setText("");displayname.setText("");displaynumber.setText("");
                return;
                 }
                 else if (a==90){
                deleteFromHash( "TurHash.txt",phone,aa.Tur);
                 deleteFromData("data.txt",phone);
                JOptionPane.showMessageDialog(null, "Record deleted");
                searchnumber.setText("");displayname.setText("");displaynumber.setText("");
                return;
                 }
                 JOptionPane.showMessageDialog(null, "Number not avaliable to be deleted");
            } catch (IOException ex) {
                Logger.getLogger(SearchNumber.class.getName()).log(Level.SEVERE, null, ex);
            }
         
        //deleteFromHash needed to be implement
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void displaynameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displaynameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_displaynameActionPerformed

    private void displaynumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displaynumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_displaynumberActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String phone = searchnumber.getText();
        AddingNumber bb = new AddingNumber();
        int a = CountryCode(phone);
        
            try {
                if (a==92){
                searching("pakHash.txt",phone,bb.pak);
                return;
                }
                else if(a==91){
                    searching("IndHash.txt",phone,bb.ind);
                    return;
                }
                else if(a==44){
                    searching("UKHash.txt",phone,bb.UK);
                    return;
                }
                else if(a==1){
                    searching("USHash.txt",phone,bb.US);
                    return;
                }
                else if(a==90){
                    searching("TurHash.txt",phone,bb.Tur);
                    return;
                }
                jj.setText("Number entered does match format");
                return;
            } catch (FileNotFoundException ex) {
                Logger.getLogger(SearchNumber.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String oldphone = searchnumber.getText();
        String name = displayname.getText();
        String phone = displaynumber.getText();
        int a = CountryCode(phone);
        
        if (a==92){
             editInData("data.txt",oldphone,phone,name);
             editInHash("pakHash.txt", oldphone,phone);
              JOptionPane.showMessageDialog(null, "Record Updated");
               searchnumber.setText("");displayname.setText("");displaynumber.setText("");
              return;
        }
        else if(a==91){
            editInData("data.txt",oldphone,phone,name);
             editInHash("IndHash.txt", oldphone,phone);
              JOptionPane.showMessageDialog(null, "Record Updated");
               searchnumber.setText("");displayname.setText("");displaynumber.setText("");
              return;
        }
        else if(a==44){
            editInData("data.txt",oldphone,phone,name);
             editInHash("UKHash.txt", oldphone,phone);
              JOptionPane.showMessageDialog(null, "Record Updated");
               searchnumber.setText("");displayname.setText("");displaynumber.setText("");
              return;
        }else if(a==1){
            editInData("data.txt",oldphone,phone,name);
             editInHash("USHash.txt", oldphone,phone);
              JOptionPane.showMessageDialog(null, "Record Updated");
               searchnumber.setText("");displayname.setText("");displaynumber.setText("");
              return;
        }else if(a==90){
            editInData("data.txt",oldphone,phone,name);
             editInHash("TurHash.txt", oldphone,phone);
              JOptionPane.showMessageDialog(null, "Record Updated");
               searchnumber.setText("");displayname.setText("");displaynumber.setText("");
              return;
        }
      JOptionPane.showMessageDialog(null, "Number entered does match format");
      

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        StartingPage sp = new StartingPage();
        this.setVisible(false);
        sp.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(SearchNumber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchNumber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchNumber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchNumber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchNumber().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField displayname;
    private javax.swing.JTextField displaynumber;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jj;
    private javax.swing.JTextField searchnumber;
    // End of variables declaration//GEN-END:variables
}
