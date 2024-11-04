package com.example.au23;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class MidController
{
    @javafx.fxml.FXML
    private TableColumn<Product,String> materialcol;
    @javafx.fxml.FXML
    private TableColumn<Product,String> idcol;
    @javafx.fxml.FXML
    private TableColumn<Product, String> namecol;
    @javafx.fxml.FXML
    private TableColumn<Product,Integer> quantitycol;
    @javafx.fxml.FXML
    private TableView<Product> productTable;
    @javafx.fxml.FXML
    private ComboBox<String> materialCB;
    @javafx.fxml.FXML
    private TextField productnameTF;
    @javafx.fxml.FXML
    private ComboBox<Integer> quantityCB;
    @javafx.fxml.FXML
    private TextField productidTF;
    @javafx.fxml.FXML
    private DatePicker deliverydatepicker;
    @javafx.fxml.FXML
    private Label errorMessageLable;

    @javafx.fxml.FXML
    public void initialize() {
        materialCB.getItems().addAll("Wood","Metal","Board","Cloth");
        quantityCB.getItems().addAll(1, 2, 3, 4, 5);


        namecol.setCellValueFactory(new PropertyValueFactory<>("name"));
        idcol.setCellValueFactory(new PropertyValueFactory<>("id"));
        materialcol.setCellValueFactory(new PropertyValueFactory<>("material"));
        quantitycol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
    }
    ArrayList<Product>itemList= new ArrayList<>();

    @javafx.fxml.FXML
    public void addproductButtonOnClick(ActionEvent actionEvent) {
        //validation
        errorMessageLable.setText("");
        //name
        if (productnameTF.getText().isEmpty()){
            errorMessageLable.setText("product name cannot be empty");
            return;

        }
        if (productidTF.getText().isEmpty()){
            errorMessageLable.setText("Product name cannot be empty");

        }
        for (Product item :itemList){
            if (item.getId().equals(productidTF.getText())){

                errorMessageLable.setText("Product id cannot be duplicate");
                return;
            }
        }
        if (materialCB.getSelectionModel().getSelectedItem()==null){
            errorMessageLable.setText("please select a material");
            return;
        }
        if (quantityCB.getSelectionModel().getSelectedItem()==null){
            errorMessageLable.setText("select Quantity");
            return;
        }
        if(deliverydatepicker.getValue()==null){
            errorMessageLable.setText("select Date");
            return;
        }
        if(deliverydatepicker.getValue().isBefore(LocalDate.now())){
            errorMessageLable.setText("date cannot be set in past");
            return;
        }

        String ProductName  = productnameTF.getText();
        String ProductId = productidTF.getText();
        String ProductMaterial= materialCB.getValue();
        int  ProductQuantity =quantityCB.getValue();
        LocalDate ProductDelaveryDate = deliverydatepicker.getValue();



        Product item = new Product(ProductId,ProductName,ProductMaterial,ProductQuantity,ProductDelaveryDate);
        itemList.add(item);

        productTable.getItems().clear();
        productTable.getItems().addAll(itemList);

    }

}