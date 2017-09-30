package app.com.revisao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Produto {

    private String nome;
    private String quantidade;
    private String categoria;

    public Produto(String nome, String quantidade, String categoria) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

}
