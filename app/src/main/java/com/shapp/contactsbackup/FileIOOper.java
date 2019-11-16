package com.shapp.contactsbackup;

import android.util.Log;

import java.io.*; // Include / Import every library of Java I/O xD

/**
 * Created by Saad Harris Ahmad on 002 Mar 21, 16.
 */
public class FileIOOper {
    public FileIOOper() {

    }
    public Boolean write(String name, String phone, String emaill){
        try {

            String fpath = "/sdcard/"+"SHAContactBackup"+".txt";
            File file = new File(fpath);
            if (!file.exists()) {  // If file does not exists, then create it.. built-in
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile(),true); //false opens as overwrite mode, true to append
            BufferedWriter bw = new BufferedWriter(fw); // Class object creation
            bw.write(name);bw.write("'s Phone Number is "); //I Added \n to move to next line but not so :(.. so doing like this
            bw.write(phone);bw.write(", and his/her E-mail is: "); // same here
            bw.write(emaill);bw.write(". \n\n"); //Not working on mine
            // Above it is may be error on Android Ice-Cream coz it requires min API 19
            bw.close();
            Log.d("Success","File Created and Contact Added"); // LOGCAT :D
            return true;
        } catch (IOException e) {
            e.printStackTrace(); // Don't understand this :P
            Log.d("Failed","I/O Error. Maybe storage is full or corrupted"); // Again Log
            return false; // boolean so that i returns and toast appears accordingly
        }
    }
}
