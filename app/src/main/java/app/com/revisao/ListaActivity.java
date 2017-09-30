package app.com.revisao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class ListaActivity extends AppCompatActivity {

    ArrayList<Produto>  produtos = new ArrayList<Produto>();

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        if(savedInstanceState!=null)
            produtos = (ArrayList<Produto>)savedInstanceState.getSerializable("produtos");
        else
            produtos = new ArrayList<Produto>();


        final Button btnSalvar = (Button) findViewById(R.id.lista_btnSalvar);
        final CheckBox chkPerecivel = (CheckBox) findViewById(R.id.lista_chkPerecivel);
        final ListView lista = (ListView) findViewById(R.id.lista_lstProdutos);
        final ArrayAdapter adpter = new ProdutoAdapter(this, R.layout.linha, produtos);

        lista.setAdapter(adpter);

        //Produto
        Bundle args = getIntent().getExtras();
        final TextView txtNome = (TextView) findViewById(R.id.lista_txtProduto);
        String nomeParam = args.getString("nome");
        txtNome.setText(nomeParam);

        //Spinner de Categoria
        String[] categorias = {"Frios/Laticionios", "Vegetais/Frutas", "Limpeza/Higiene", "Refrigerantes/Cervejas"};
        final Spinner spnCategorias = (Spinner)findViewById(R.id.lista_spnCategoria);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categorias);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spnCategorias.setAdapter(adapter);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean checkPerecivel = chkPerecivel.isChecked();

                if(checkPerecivel)
                    alert("Produto perecivel");
                else
                    alert("Produto não perecivel");

                // Quantidade
                TextView txtQuantidade = (TextView) findViewById(R.id.lista_txtQuantidade);

                String Nome = txtNome.getText().toString();
                //int Quantidade = Integer.parseInt(txtQuantidade.getText().toString());
                String Quantidade = txtQuantidade.getText().toString();

                String Categoria = spnCategorias.getSelectedItem().toString();


                Produto p = new Produto(Nome, Quantidade, Categoria);
                produtos.add(p);
                adpter.notifyDataSetChanged();

            }
        });
    }
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.("produtos",produtos);
    }


    private void alert(String msg)
    {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
