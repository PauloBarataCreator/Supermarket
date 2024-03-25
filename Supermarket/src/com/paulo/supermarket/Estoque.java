package com.paulo.supermarket;
import java.util.ArrayList;


public class Estoque {
    ArrayList<Produto> produto_lista = new ArrayList<Produto>();



    public ArrayList<Produto> getProduto_lista() {
        return produto_lista;
    }

    public void setProduto_lista(ArrayList<Produto> produto_lista) {
        this.produto_lista = produto_lista;
    }


    
}
