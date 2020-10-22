package com.pablo.u2p4conversor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends LogActivity {

    private TextView textView;

    private EditText etPulgadas;

    private EditText etResultado;

    private TextView textError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUI();
    }

    private void setUI(){
        // metodo que controla las acciones de la aplicacion
        final TextView textView = findViewById(R.id.textView);
        final EditText etPulgada = findViewById(R.id.editTextNumberDecimal);
        final EditText etResultado = findViewById(R.id.et_Resultado);
        final TextView textViewError = findViewById(R.id.textViewError);
        Button buttonConvertir = findViewById(R.id.button_Convertir);

        etPulgada.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                imprimirLog("etPulgadas","onTextChanged");

                // aqui dectecta si hay texto en el textView transforma si esta en cm o en pulgadas
                // y carga los errores si estos suceden

                try {
                    textViewError.setText(null);
                    if (s.length() > 0){
                        if (textView.getText() == getString(R.string.textViewInfo)){
                            etResultado.setText(convertirCmPul(s.toString(),textViewError));
                        }else {
                            etResultado.setText(convertirPulCm(s.toString(),textViewError));
                        }
                    }else {
                        etResultado.setText("");
                    }
                }catch (Exception e){
                    textViewError.setText(e.getMessage());
                    Log.e("logConversor",e.getMessage());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        buttonConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imprimirLog("buttonConvertir","onTextChanged");

                // El boton cambia de conversor cm o pulgadas esto son los if necesario para ello


                if (textView.getText() == getString(R.string.textViewInfo)){
                    textView.setText(getString(R.string.textViewInfo2));
                    etPulgada.setHint(R.string.textViewHintPedir2);
                }else{
                    textView.setText(getString(R.string.textViewInfo));
                    etPulgada.setHint(R.string.textViewHintPedir);
                }
                etPulgada.setText(etResultado.getText());
            }
        });
    }
    private String convertirCmPul(String pulgada,TextView textView){
        // pasamos a cm a pulgadas
        double pulgadaValue = Double.parseDouble(pulgada) ;

           if (pulgadaValue < 1){
               try {
                   throw new Exception("Solo numeros > o =  1");
               } catch (Exception e) {
                   textView.setText(e.getMessage());
                   e.printStackTrace();
               }
           }

        return String.format("%.2f",pulgadaValue * 2.54);
    }

    private String convertirPulCm(String pulgada,TextView textView){
        // pasamos a cm a pulgadas
        double cmValue = Double.parseDouble(pulgada);
        if (cmValue < 1){
            try {
                throw new Exception("Solo numeros > o =  1");
            } catch (Exception e) {
                textView.setText(e.getMessage());
                e.printStackTrace();

            }
        }
        return String.format("%.2f",cmValue / 2.54);
    }
    @Override
    public void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        // Cargar la información anterior cuando carga la pantalla
        super.onRestoreInstanceState(savedInstanceState);
        textView.setText(savedInstanceState.getString("textView"));
        imprimirLog("onRestoreIntnceState","textView => " + textView.getText().toString());
        etPulgadas.setText(savedInstanceState.getString("etPulgadas"));
        imprimirLog("onRestoreIntnceState","etPulgadas => " + etPulgadas.getText().toString());
        etResultado.setText(savedInstanceState.getString("etResultado"));
        imprimirLog("onRestoreIntnceState","etResultado => " + etResultado.getText().toString());
        textError.setText(savedInstanceState.getString("textError"));
        imprimirLog("onRestoreIntnceState","textError => " + textError.getText().toString());

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        // Guardar la información a la hora de volver a inicializar la pantalla
        outState.putString("textViewInfo", textView.getText().toString());
        imprimirLog("onSaveInstanceState", "textViewInfo => " + textView.getText().toString());
        outState.putString("etPrimerCampo", etPulgadas.getText().toString());
        imprimirLog("onSaveInstanceState", "etPrimerCampo => " + etPulgadas.getText().toString());
        outState.putString("etSegundoCampo", etResultado.getText().toString());
        imprimirLog("onSaveInstanceState", "etSegundoCampo => " + etResultado.getText().toString());
        outState.putString("textViewError", textError.getText().toString());
        imprimirLog("onSaveInstanceState", "textViewError => " + textError.getText().toString());
        super.onSaveInstanceState(outState);
    }
}