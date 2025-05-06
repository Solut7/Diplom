package com.example.demo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

public class AnalysController {
    @FXML
    public ListView<String> MetricMenu;
    @FXML
    public CategoryAxis CategoryAxe;
    @FXML
    public NumberAxis NumberAxe;
    @FXML
    public Button Close;
    @FXML
    public Button Init;

    private ObservableList<MainInfo> MainInfoList;

    private final ObservableList<String> MetricList = FXCollections.observableArrayList("Финансовая эффективность", "Конверсия и отток", "Доходы");

    public AnalysController() {
        MainInfoList = FXCollections.observableArrayList();
    }
    public void LoadAll(){
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("D:/AnalysData.json")) {
            Type listType = new TypeToken<ObservableList<MainInfo>>(){}.getType();
            List<MainInfo> loaded = gson.fromJson(reader, listType);
            MainInfoList.setAll(loaded);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void Init(){
        MetricMenu.setItems(MetricList);
    }
    public void Close(){
        Stage stage = (Stage) Close.getScene().getWindow();
        stage.close();
    }

}