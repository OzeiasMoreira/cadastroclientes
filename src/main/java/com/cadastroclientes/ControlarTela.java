/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.cadastroclientes;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

class ControlarTela {

    @FXML
    ListView<String> clientesListview;

    public void listarCLientes(ArrayList<Cliente> clientes){
        for(Cliente cliente : clientes){
            clientesListview.getItems().addAll(String.format("%d | Nome: %s | Telefone: %s | CEP: %s | Número: %s",cliente.getCodigo(), cliente.getNome(),
                    cliente.getTelefone(), cliente.getEndereco().getCep(),cliente.getEndereco().getNumero()));
        }
    }
}
