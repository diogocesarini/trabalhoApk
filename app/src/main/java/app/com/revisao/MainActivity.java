package app.com.revisao;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btnCalcular = (Button)findViewById(R.id.main_btnOk);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView txtNome = (TextView) findViewById(R.id.main_txtNome);
                String Nome = txtNome.getText().toString();

                Intent intent = new Intent(getContext(), ListaActivity.class);
                Bundle params = new Bundle();

                params.putString("nome", Nome);

                intent.putExtras(params);
                startActivity(intent);

            }
        });

    }


    private Context getContext(){
        return this;
    }

}
