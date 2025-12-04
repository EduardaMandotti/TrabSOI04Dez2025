package com.example.trabsoi04dez;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etNumInteiro;
    private TextView tvResposta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etNumInteiro = findViewById(R.id.etNumeroInteiro);
        etNumInteiro.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        tvResposta = findViewById(R.id.tvResposta);
        tvResposta.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        Button btnValidar = findViewById(R.id.btnValidar);

        btnValidar.setOnClickListener(op -> ValidPrimo());

    }

    public void ValidPrimo() {
        int num = Integer.parseInt(etNumInteiro.getText().toString());
        String resp = "";
        boolean primo = true;

        if (num < 2 ) {
            primo = false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++){
            if (num % i == 0){
                primo = false;
            }
        }

        if (primo) {
            resp = getString(R.string.resp) + " " + num + " é primo!";
        }

        if(!primo){
            resp = getString(R.string.resp) + " " + num + " não é primo." ;
        }

        etNumInteiro.setText("");
        tvResposta.setText(resp);

    }

}