package com.shapp.contactsbackup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.shapp.contactsbackup.FileIOOper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public Button btnStartB; //Declarations
    public EditText etn,etp,etm;
    public TextView T;
    String name;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present. Requires Android 5.0.x Lollipop Plus but I don't
        // tried because I've Android 4.4.4 KitKat
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //Menu having About Us (AU), Contact(CU) and Achievements

        switch(item.getItemId()){
            case R.id.action_au:
                Toast.makeText(getApplicationContext(), "Saad Harris Ahmad", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_cu:
                Toast.makeText(getApplicationContext(), "+92-303-43-26-206", Toast.LENGTH_LONG).show();
                break;
            case R.id.achieve: // Opens another Activity
                Intent intent =new Intent (MainActivity.this,Achievements.class);
                startActivity(intent);
                break;
        }
        //Return false to allow normal menu processing to proceed,
        //true to consume it here.
        return false;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Linking xml and java class
        btnStartB=(Button)findViewById(R.id.btnStartB);
        btnStartB.setOnClickListener(this);
        etn=(EditText)findViewById(R.id.etperson);
        etp=(EditText)findViewById(R.id.etphn);
        etm=(EditText)findViewById(R.id.etmail);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnStartB) {
            Toast.makeText(getApplicationContext(), "Please Wait!", Toast.LENGTH_SHORT).show();
            Contact conatct=new Contact();
            conatct.setContactName(etn.getText().toString()); // Converting to string and setting vals using setters
            conatct.setContactNumber(etp.getText().toString());
            conatct.setEmail(etm.getText().toString());
            FileIOOper contact=new FileIOOper(); // Class object created
            boolean acknowledgement=contact.write(conatct.getContactName(),conatct.getContactNumber(),conatct.getEmail()); //receives true or false
            if(acknowledgement){
                Toast.makeText(getApplicationContext(), "Entry saved in sdcard/SHABackupConatct.txt", Toast.LENGTH_SHORT).show(); // Success
            }else{
                Toast.makeText(getApplicationContext(), "I/O error. Maybe memory full or corrupted", Toast.LENGTH_SHORT).show(); // Failed
            }
            etn.setText(""); //Clears after saving
            etp.setText(""); // same
            etm.setText("");// same as above
        }
    }
}
