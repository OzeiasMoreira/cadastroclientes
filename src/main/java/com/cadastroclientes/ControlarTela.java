package com.cadastroclientes;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class ControlarTela {
    @FXML
    private ListView<String> listViewClientes;

    public void listarCLientes(ArrayList<Cliente> clientes){
        listViewClientes.getItems().clear(); 
        for(Cliente cliente : clientes){
            listViewClientes.getItems().add(cliente.getNome() + " - " + cliente.getEndereco().getCep());
        }
    }
}
