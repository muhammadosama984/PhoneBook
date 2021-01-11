/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonedirectory;
import java.io.*;
import java.math.BigInteger;
/**
 *
 * @author usamaasif
 */
public class PhoneDirectory {

    /**
     * @param args the command line arguments
     */
    public void conversion(){
        String s ="923343237228";
        BigInteger w = new BigInteger(s);
        BigInteger r = new BigInteger("10000000");
        w = w.divide(r);
        String  a = w.toString();
        int q = Integer.parseInt(a);
        System.out.println(q);
    }
    public static void fillingFile(String q) throws IOException{
                         File file = new File(q);
                         FileWriter fw = new FileWriter(file,true);
                         BufferedWriter bw = new BufferedWriter(fw);
                         PrintWriter ww = new PrintWriter(bw);
                         ww.println("-1"+","+"null");
                         String[] s = new String[1000];
                         for(int i=0;i<s.length;i++){
                           ww.println(i+","+s[i]);
                         }
                         ww.close();
    }
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        StartingPage s = new StartingPage();
        s.setVisible(true);

              fillingFile("pakHash.txt");
                         
//      AddingNumber a = new AddingNumber();
//       a.fileToArray("pakHash.txt", a.pak);
//        for(int i=0;i<a.pak.length;i++){
//            System.out.println(a.pak[i]);
//        }
//        
        
    }
    
}
