package StreamsFilesAndDirectories.lab;

import java.io.*;

public class N3CopyBytes {
    public static void main(String[] args) {
        String programDir = System.getProperty("user.dir");

       try(InputStream in = new FileInputStream(programDir+"\\input.txt");
           OutputStream out = new FileOutputStream(programDir+"\\output.txt")){
           int oneByte = in.read();
           while (oneByte >= 0){
              if(oneByte == 10 || oneByte == 32){
                    out.write(oneByte);
              }else{
                  String digits = String.valueOf(oneByte);
                  for (int i = 0; i < digits.length(); i++) {
                      out.write(digits.charAt(i));
                  }
              }
               oneByte=in.read();
           }
       }catch(IOException ignored){}
    }
}
