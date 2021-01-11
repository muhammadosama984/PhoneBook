/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonedirectory;
//gui,displayTable, more counties, powerpoint
import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author usamaasif
 */

public class AddingNumber<T extends Comparable<T>> extends javax.swing.JFrame   {
    

 String [] pak ;
 String [] ind ;
 String [] US ;
 String [] UK ;
 String [] Tur ;
//pak =  new String[ArraySize(pakFile)];
File USFile = new File("USHash.txt");
File UKFile = new File("UKHash.txt");
File TurFile = new File("TurHash.txt");
       
File IndFile = new File("IndHash.txt");
File pakFile = new File("pakHash.txt");
File mainFile = new File("data.txt");
    /**
     * Creates new form AddingNumber
     */
    public AddingNumber() {
     try {
         initComponents();
         pak =  new String[ArraySize(pakFile)];
         ind =  new String[ArraySize(IndFile)];
         US =  new String[ArraySize(USFile)];
         UK =  new String[ArraySize(UKFile)];
         Tur =  new String[ArraySize(TurFile)];
     } catch (FileNotFoundException ex) {
         Logger.getLogger(AddingNumber.class.getName()).log(Level.SEVERE, null, ex);
     }
    }
    public AddingNumber(String s) {
      
    }
   
  
  public int CountryCode(String s){
      //String s ="923343237228";
        BigInteger w = new BigInteger(s);
        BigInteger r = new BigInteger("10000000000");
        
        w = w.divide(r);
        
        String  a = w.toString();
       return  Integer.parseInt(a);
  }
  
  public int ArraySize(File filepath) throws FileNotFoundException{
      
     //File file = new File(filepath);
     Scanner sc = new Scanner(filepath);
     sc.useDelimiter("[\n]");
     int count =0;
     while(sc.hasNext()){
         String id = sc.next();
         
         count++;
     }
        return (count-1);
  }
  public BigInteger phone(String s){
              BigInteger w = new BigInteger(s);
                return w;
  }
  public int hash(BigInteger s){
     BigInteger r = new BigInteger("1000");
      int a = Integer.parseInt(s.mod(r).toString());
      return a;
      
  }
  public int rehash(int s){
      return s++;
  }
  public String[] copy(String[] oldArray){
      String[] newArray = new String[oldArray.length*2];
      for(int i=0;i<oldArray.length;i++){
          newArray[i]=oldArray[i];
      }
      return newArray;
  }
  public void fileToArray(String file,String[] arr) throws IOException{
      Scanner sc = new Scanner(new File(file));
      sc.useDelimiter("[,\n]");
                     
                         String i="-1";
                         int index = 0;
                         String a="";String phone="";
                         while(sc.hasNext()){
                             a = sc.next();
                             phone = sc.next();
                             if(i.equals( a)){
                               
                             }
                             else{
                                   arr[index] = phone;
                                   index++;
                             }
                            
                         }
  }
  public boolean searchPhonenumber(String q,String f) throws FileNotFoundException{
     
      String index="";String phone="";
      Boolean found = false;
      Scanner sc = new Scanner(new File(f));
      sc.useDelimiter("[,\n]");
      while(sc.hasNext()){
          index = sc.next();
          phone = sc.next();
          
          if(phone.equals(q)){
              found = true;
              return found;
          }
      }
      return found;
  }
  public void data(String phone,String name){
                FileWriter fw = null;
    try {
        fw = new FileWriter(mainFile,true); 
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter ww = new PrintWriter(bw);
        ww.println(phone+","+name);
        ww.close();
    } catch (IOException ex) {
        Logger.getLogger(AddingNumber.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(AddingNumber.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  }
  public void editInHashFile(String filepath, int q,String phone){
      String tempFile = "temp.txt";
        File oldFile = new File(filepath);
        File newFile = new File(tempFile);
        String id =" ";String number=" ";
        String hashnumber = String.valueOf(q);
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
               
                if (id.equals(hashnumber)){
                    pw.println(id + ","+phone);
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
  public void whenArrayIncrease(String[] arr, String filepath){
      String tempFile = "temp.txt";
        File oldFile = new File(filepath);
        File newFile = new File(tempFile);
        Scanner x ;
        try {
           FileWriter fw = new FileWriter(tempFile,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            x = new Scanner(new File(filepath));
            x.useDelimiter("[,\n]");
            pw.println("-1"+","+"null");
                         
                         for(int i=0;i<arr.length;i++){
                           pw.println(i+","+arr[i]);
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
  public void adding(String filepath, String phone, String personname, String[] arr) throws IOException{
      int q = hash(phone(phone));
                 fileToArray(filepath,arr);
                 String sss = arr[q];
                 if (arr[q].equals("null") && !(searchPhonenumber(phone,filepath)) ){
                     arr[q] = phone + "," +personname;
                        data(phone,personname);
                        editInHashFile(filepath,q,phone);
                        JOptionPane.showMessageDialog(null,"Record Added");
                        this.setVisible(false);
                 }
                 else if((searchPhonenumber(phone,filepath))){
                     JOptionPane.showMessageDialog(null,"Record not added, because previously added");
                 }
                 else if(arr[q]!=null){
                     int i=0;
                 while(!(arr[q].equals("null")) && i<arr.length){    
                  q++;
                  i++;
                  int  jj = arr.length;
                  if(q>=arr.length){
                      String [] pak1 = copy(arr);                   
                      arr = pak1;
                      int aaa = arr.length;
                       String s = arr[q];
                      whenArrayIncrease(arr,filepath);
                     data(phone,personname);
                   editInHashFile(filepath,q,phone);
                   JOptionPane.showMessageDialog(null,"Record Added");
                        this.setVisible(false);
                  }            
                }
                     data(phone,personname);
                   editInHashFile(filepath,q,phone);
                        JOptionPane.showMessageDialog(null,"Record Added");
                        this.setVisible(false);
                 }
  }
  public boolean checkingNumber(String phone, int a){
      Boolean check = true;
      String code = String.valueOf(a);
      String h="";
    String p="";
    if (phone.length()<11)
       return false;
       int i;
    for ( i=0;i<10;i++){
       h= h + phone.charAt(phone.length()-1-i); 
    }
    if (h.length()!=10){
        return false;
    }
    for(int j=0;j<code.length();j++){
        p = p+phone.charAt(phone.length()-1-i);
        i++;
    }
    StringBuilder l = new StringBuilder();
    l.append(p);
       String ss = l.reverse().toString();
       if(!(code.equals(ss))){
           return false;
       }
    
      
      return check;
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
        jLabel3 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        txtnumber = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Apple SD Gothic Neo", 1, 36)); // NOI18N
        jLabel1.setText("Adding Number");

        jLabel2.setText("Name");

        jLabel3.setText("PhoneNumber");

        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        jLabel5.setText("ex. 923343237228    ");

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setText("1. Number must be 10 digit excluding country code.");

        jLabel6.setText("2. Country Code must be at the starting of number");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Accepting Counties:\n1. Pakistan\n2. United States\n3. United Kingdom\n4.Turkey\n5.India\n");
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(97, 97, 97))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtname)
                                .addComponent(txtnumber, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addGap(25, 25, 25))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))))
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
                .addGap(0, 39, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
 
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String personname;
         String phone;
         personname = txtname.getText();
         phone = txtnumber.getText();
         
         int a = CountryCode(phone);
         if(!(checkingNumber(phone,a))){
             JOptionPane.showMessageDialog(null,"Number format does not match");
             return;
         }
            try {
                if (a==92){
                adding("pakHash.txt",phone,personname,pak);
                return;
                }
                else if(a==91){
                  adding("IndHash.txt",phone,personname,ind);
                    return;
                }
                else if (a==44){
                     adding("UKHash.txt",phone,personname,UK);
                    return;
                }
                 else if (a==1){
                      adding("USHash.txt",phone,personname,US);
                    return;
                }
                else if (a==90){
                     adding("TurHash.txt",phone,personname,Tur);
                    return;
                }
                
                JOptionPane.showMessageDialog(null,"Please only follow the mentioned instructions");
            } catch (IOException ex) {
                Logger.getLogger(AddingNumber.class.getName()).log(Level.SEVERE, null, ex);}
             catch (Exception e){
                     JOptionPane.showMessageDialog(null,"Format Problem");
                     }
         
         
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnameActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        StartingPage sp = new StartingPage();
        this.setVisible(false);
        sp.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(AddingNumber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddingNumber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddingNumber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddingNumber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddingNumber().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtnumber;
    // End of variables declaration//GEN-END:variables
}
