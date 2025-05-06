package com.example.demo;

import com.google.gson.Gson;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.FileReader;
import java.text.DecimalFormat;


public class OpenController {
    @FXML
    private Button CloseButt;
    @FXML
    private Label ClientsAmount;
    @FXML
    private Label NewClients;
    @FXML
    private Label LeftClients;
    @FXML
    private Label ActiveClients;
    @FXML
    private Label Visitors;
    @FXML
    private Label Converted;
    @FXML
    private Label Period;

    @FXML
    private Label MarketingExp;
    @FXML
    private Label SellExp;
    @FXML
    private Label DevelopExp;
    @FXML
    private Label ProtoExp;
    @FXML
    private Label AllExp;

    @FXML
    private Label SubInc;
    @FXML
    private Label SellInc;
    @FXML
    private Label InApp;
    @FXML
    private Label AllInc;

    @FXML
    private Label CAC;
    @FXML
    private Label CR;
    @FXML
    private Label RR;
    @FXML
    private Label ConvR;
    @FXML
    private Label ROI;
    @FXML
    private Label ARPU;
    @FXML
    private Label LTV;
    @FXML
    private Label Name;


    MainInfo mainInfo = new MainInfo();
    //DecimalFormat df = new DecimalFormat("#.##");

    public void Load(){
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("D:/data.json")) {
            mainInfo = gson.fromJson(reader, MainInfo.class);
            DecimalFormat df = new DecimalFormat("#.##");
            ClientsAmount.setText(String.valueOf(mainInfo.getClientsInfo().getCurrentAmountClients()));
            NewClients.setText(String.valueOf(mainInfo.getClientsInfo().getNewClientsNumber()));
            LeftClients.setText(String.valueOf(mainInfo.getClientsInfo().getLeftClientsNumber()));
            ActiveClients.setText(String.valueOf(mainInfo.getClientsInfo().getActiveClientsNumber()));
            Visitors.setText(String.valueOf(mainInfo.getClientsInfo().getVisitors()));
            Converted.setText(String.valueOf(mainInfo.getClientsInfo().getConvertedUsers()));
            Period.setText(String.valueOf(mainInfo.getClientsInfo().getCustomerLifetime()));
            //mainInfo.setClientsInfo(clientsInfo);

            MarketingExp.setText(String.valueOf(mainInfo.getExpensesInfo().getMarketingExpenses()));
            SellExp.setText(String.valueOf(mainInfo.getExpensesInfo().getSaleExpenses()));
            DevelopExp.setText(String.valueOf(mainInfo.getExpensesInfo().getDevelopExpenses()));
            ProtoExp.setText(String.valueOf(mainInfo.getExpensesInfo().getPrototypeExpenses()));
            AllExp.setText(String.valueOf(mainInfo.getExpensesInfo().getAllExpenses()));
            //mainInfo.setExpensesInfo(expensesInfo);

            SubInc.setText(String.valueOf(mainInfo.getIncomeInfo().getSubInc()));
            SellInc.setText(String.valueOf(mainInfo.getIncomeInfo().getSellInc()));
            InApp.setText(String.valueOf(mainInfo.getIncomeInfo().getInAPP()));
            AllInc.setText(String.valueOf(mainInfo.getIncomeInfo().getAllIncome()));
            //mainInfo.setIncomeInfo(incomeInfo);

            Name.setText(mainInfo.getName());

            if(mainInfo.getCR() >= (double) (2 /100) && mainInfo.getCR() <= (double) (5 /100)){
                CR.setText(df.format(mainInfo.getCR()));
                CR.setStyle("-fx-background-color: green;");
            } else if(mainInfo.getCR() > (double) (5 /100) && mainInfo.getCR() <= (double) (7 /100)){
                CR.setText(df.format(mainInfo.getCR()));
                CR.setStyle("-fx-background-color: yellow;");
            } else{
                CR.setText(df.format(mainInfo.getCR()));
                CR.setStyle("-fx-background-color: red;");
            }

            if(mainInfo.getConvR() >= 10 && mainInfo.getConvR() <= 30){
                ConvR.setText(df.format(mainInfo.getConvR()));
                ConvR.setStyle("-fx-background-color: green;");
            } else if(mainInfo.getConvR() < 10){
                ConvR.setText(df.format(mainInfo.getConvR()));
                ConvR.setStyle("-fx-background-color: red;");
            }

            if(mainInfo.getRetR() >= 70 && mainInfo.getRetR() <= 85){
                RR.setText(df.format(mainInfo.getRetR()));
                RR.setStyle("-fx-background-color: green;");
            } else if(mainInfo.getRetR() < 70 && mainInfo.getRetR() >= 60){
                RR.setText(df.format(mainInfo.getRetR()));
                RR.setStyle("-fx-background-color: yellow;");
            } else if(mainInfo.getRetR()<60){
                RR.setText(df.format(mainInfo.getRetR()));
                RR.setStyle("-fx-background-color: red;");
            }


            if(mainInfo.getCac()>= (double) (3 /100)*mainInfo.getLTV() && (mainInfo.getCac()<= (double) (2 /10)*mainInfo.getLTV() )){
                CAC.setText(df.format(mainInfo.getCac()));
                CAC.setStyle("-fx-background-color: green;");
            }else if(mainInfo.getCac() > (double) (2 /10)*mainInfo.getLTV() && (mainInfo.getCac() < (double) (5 /10)*mainInfo.getLTV() )){
                CAC.setText(df.format(mainInfo.getCac()));
                CAC.setStyle("-fx-background-color: yellow;");
            } else{
                CAC.setText(df.format(mainInfo.getCac()));
                CAC.setStyle("-fx-background-color: red;");
            }

            if(mainInfo.getROI() > 10 && mainInfo.getROI() <= 50){
                ROI.setText(df.format(mainInfo.getROI()));
                ROI.setStyle("-fx-background-color: yellow;");
            } else if(mainInfo.getROI() > 50){
                ROI.setText(df.format(mainInfo.getROI()));
                ROI.setStyle("-fx-background-color: green;");
            } else if(mainInfo.getROI() <= 10){
                ROI.setText(df.format(mainInfo.getROI()));
                ROI.setStyle("-fx-background-color: red;");
            }

            if(mainInfo.getARPU() >= 10 && mainInfo.getARPU() <= 50){
                ARPU.setText(df.format(mainInfo.getARPU()));
                ARPU.setStyle("-fx-background-color: green;");
            } else if(mainInfo.getARPU() < 10){
                ARPU.setText(df.format(mainInfo.getARPU()));
                ARPU.setStyle("-fx-background-color: red;");
            }


            if(mainInfo.getLTV()/ mainInfo.getCac() >= 3){
                LTV.setText(df.format(mainInfo.getLTV()));
                LTV.setStyle("-fx-background-color: green;");
            } else if(mainInfo.getLTV() < mainInfo.getCac() || mainInfo.getLTV()<=50){
                LTV.setText(df.format(mainInfo.getLTV()));
                LTV.setStyle("-fx-background-color: red;");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void Close(){
        Stage stage = (Stage) CloseButt.getScene().getWindow();
        stage.close();
    }

}