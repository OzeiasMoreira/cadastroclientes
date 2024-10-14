package com.cadastroclientes;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Controlador {
    @FXML
    private TextField nome;

    @FXML
    private TextField cep;

    @FXML
    private TextField rua;

    @FXML
    private TextField cidade;

    @FXML
    private TextField telefone;

    @FXML
    private TextField numero;

    @FXML
    private TextField estado;

    private Buscador buscador;
    private Endereco endereco;
    private Cliente cliente;
    private ArrayList<Cliente> cadastroClientes;
    private Integer codigoCliente;

    @FXML
    private void initialize(){
        buscador = new Buscador();
        endereco = new Endereco();
        cliente = new Cliente();
        cadastroClientes = new ArrayList<>();
        codigoCliente = 0;
    }

    @FXML
    private void buscar(){
        try {
            endereco = buscador.buscar(cep.getText());
            cidade.setText(endereco.getCidade());
            rua.setText(endereco.getRua());
            estado.setText(endereco.getEstado());
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Ocorreu um erro!");
            alert.setContentText("Verifique se o CPF está no formato correto: 99999-999");
            alert.show();
        }
    }

    @FXML
    private void limpar(){
        nome.setText("");
        cep.setText("");
        rua.setText("");
        cidade.setText("");
        telefone.setText("");
        numero.setText("");
        estado.setText("");
    }

    @FXML
    private void cadastrar(){
        cliente = new Cliente();
        cliente.endereco = new Endereco();
        cliente.setNome(nome.getText());
        cliente.setCodigo(codigoCliente++);
        cliente.setTelefone(telefone.getText());
        cliente.endereco.setCep(cep.getText());
        cliente.endereco.setNumero(numero.getText());
        cliente.endereco.setEstado(estado.getText());
        cliente.endereco.setCidade(cidade.getText());
        cadastroClientes.add(cliente);
    }

    @FXML
    private void listar(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("telaClientes.fxml"));
            Parent root = fxmlLoader.load();

            // Create a new Stage
            Stage stage = new Stage();
            stage.setTitle("Listar cadastros");

            // Create a Scene with the loaded FXML file
            Scene scene = new Scene(root);

            // Set the Scene to the Stage
            stage.setScene(scene);

            // Show the Stage (window)
            stage.show();

            // Used for listing the customers
            ControlarTela controlarTela = fxmlLoader.getController();
            controlarTela.listarCLientes(cadastroClientes);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
