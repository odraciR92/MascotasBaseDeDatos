package com.ricardoguzman.puppy;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class ContactoActivity extends AppCompatActivity {

    private EditText etNombreCompleto;
    private EditText etEmail;
    private EditText etMensaje;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);


        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar2);
        setSupportActionBar(miActionBar);

        etNombreCompleto =  (EditText) findViewById(R.id.etNombreCompleto);
        etEmail =  (EditText) findViewById(R.id.etEmail);
        etMensaje =  (EditText) findViewById(R.id.etMensaje);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id){
            case R.id.btnMasLikes:
                startActivity(new Intent(getApplicationContext(), SegundoActivity.class));
                break;
            case R.id.btnAcercaDe:
                startActivity(new Intent(getApplicationContext(), AboutActivity.class));
                break;
            case R.id.btnContacto:
                startActivity(new Intent(getApplicationContext(), ContactoActivity.class));
                break;
        }


        return true;
    }

    public void enviaMail(View view){
        String email = etEmail.getText().toString();
        String mensaje = etEmail.getText().toString();
        Intent emailIntent = new Intent((Intent.ACTION_SEND));
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_EMAIL,email);
        emailIntent.putExtra(Intent.EXTRA_TEXT,mensaje);
        emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent,"e-mail"));
    }
}
