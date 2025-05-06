package com.example.demo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class MenuController {
    @FXML
    private Button CreateButt;
    @FXML
    private Button ChangeButt;
    @FXML
    private Button DeleteButt;
    @FXML
    private Button OpenButt;
    @FXML
    private Button AnalysButt;
    @FXML
    private Button LoadButt;
    @FXML
    private ImageView CloseButt;
    @FXML
    private ListView<MainInfo> MainList;
    @FXML
    private Label WarningField;

    private ObservableList<MainInfo> MainInfoList;



    public MenuController() {
        MainInfoList = FXCollections.observableArrayList();

    }
    public void CreateNew() throws IOException {
        HelloApplication.CreateWindow();
    }
    public void Load(){
        Gson gson = new Gson();
        MainInfo selected = MainList.getSelectionModel().getSelectedItem();
        MainInfo mainInfo = new MainInfo();
        try (FileReader reader = new FileReader("D:/data.json")) {
             mainInfo = gson.fromJson(reader, MainInfo.class); // Десериализация
        } catch (Exception e) {
            e.printStackTrace();
        }
        MainInfoList.add(mainInfo);
        MainList.setItems(MainInfoList);
    }
    public void LoadAll(){
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("D:/PrevSession.json")) {
            Type listType = new TypeToken<ObservableList<MainInfo>>(){}.getType();
            List<MainInfo> loaded = gson.fromJson(reader, listType);
            MainInfoList.setAll(loaded);
        } catch (Exception e) {
            e.printStackTrace();
        }
        MainList.setItems(MainInfoList);
        MainList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }
    public void Change() throws IOException {
        saveToJson();
        HelloApplication.ChangeWindow();
    }
    public void Delate(){
        MainInfo selected = MainList.getSelectionModel().getSelectedItem();
        if(selected!=null){
            MainInfoList.remove(selected);
        }
    }
    public void Open() throws IOException {
        saveToJson();
        HelloApplication.OpenWindow();
    }
    public void Close(){
        Stage stage = (Stage) CloseButt.getScene().getWindow();
        stage.close();
        saveToJsonAll();
    }
    public void Analys() throws IOException {
        MultipleSelectionModel<MainInfo> selectionModel = MainList.getSelectionModel();
        ObservableList<MainInfo> selected = selectionModel.getSelectedItems();
            Gson gson = new Gson();
            try (FileWriter writer = new FileWriter("D:/AnalysData.json")) {
                gson.toJson(selected, writer); // Сериализация в файл
            } catch (Exception e) {
                e.printStackTrace();
            }
            HelloApplication.AnalysWindow();
    }
    private void saveToJson() {
        Gson gson = new Gson();
        MainInfo selected = MainList.getSelectionModel().getSelectedItem();
        try (FileWriter writer = new FileWriter("D:/data.json")) {
            gson.toJson(selected, writer); // Сериализация в файл
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void saveToJsonAll() {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter("D:/PrevSession.json")) {
            gson.toJson(MainInfoList, writer); // Сериализация в файл
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}