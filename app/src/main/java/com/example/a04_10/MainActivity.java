package com.example.a04_10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //declaro Variables
    TextView textView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Enlazo las variables con los ID del XML
        textView = findViewById(R.id.textView);
        imageView = findViewById(R.id.imagenView);

        //instancio el metodo asincrono y la inicio
        MyAsyncTask asyncTask = new MyAsyncTask();
        asyncTask.execute();
    }
    public class MyAsyncTask extends AsyncTask<Void, Void,String>{
        @Override
        protected String doInBackground(Void... voids){
            //Inicio la actividad en segundo plano
            //Le indicamos que debe esperar 5 segundos
            try {
                Thread.sleep(5000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return "BOOOOO!!";
        }
        @Override
        protected void onPostExecute(String result){
            //Actualizar la interfaz con el texto
            textView.setText(result);
            //Moatrar Imagen
            imageView.setVisibility(imageView.VISIBLE);
        }
    }

}