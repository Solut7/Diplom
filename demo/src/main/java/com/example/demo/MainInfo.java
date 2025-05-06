package com.example.demo;


public class MainInfo {
         ClientsInfo clientsInfo;
         ExpensesInfo expensesInfo;
         IncomeInfo incomeInfo;
         double CR;
         double ConvR;
         double RetR;
         double Cac;
         double ARPU;
         double LTV;
         double ROI;
         String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ClientsInfo getClientsInfo() {
            return clientsInfo;
        }

        public void setClientsInfo(ClientsInfo clientsInfo) {
            this.clientsInfo = clientsInfo;
        }

        public ExpensesInfo getExpensesInfo() {
            return expensesInfo;
        }

        public void setExpensesInfo(ExpensesInfo expensesInfo) {
            this.expensesInfo = expensesInfo;
        }

        public IncomeInfo getIncomeInfo() {
            return incomeInfo;
        }

        public void setIncomeInfo(IncomeInfo incomeInfo) {
            this.incomeInfo = incomeInfo;
        }

    @Override
    public String toString() {
        return this.name;
    }

    public double ChurnRate() {
        return ((double) clientsInfo.getLeftClientsNumber() / clientsInfo.getCurrentAmountClients()) * 100;
    }

    public double ConversionRate() {
        return ((double) clientsInfo.getConvertedUsers() / clientsInfo.getVisitors()) * 100;
    }

    public double RetentionRate() {
        return 100 - ChurnRate();
    }

    public double CAC() {
        double totalAcquisitionCost = expensesInfo.getMarketingExpenses() + expensesInfo.getSaleExpenses();
        return totalAcquisitionCost / clientsInfo.getNewClientsNumber();
    }

    public double ARPUCount() {
        return incomeInfo.getAllIncome() / (float) clientsInfo.getCurrentAmountClients();
    }

    public double LTVCount() {
        return ARPUCount() * clientsInfo.getCustomerLifetime(); // период сотрудничества в месяцах
    }


    public double ROI() {
        return ((incomeInfo.getAllIncome() - expensesInfo.getAllExpenses()) / expensesInfo.getAllExpenses()) * 100;
    }
        public void SetCR(){this.CR = ChurnRate();}
        public void SetConvR(){
            this.ConvR = ConversionRate();
        }
        public void SetRetR(){
            this.RetR = RetentionRate();
        }
        public void SetCAC(){
            this.Cac = CAC();
        }
        public void SetARPU(){
            this.ARPU = ARPUCount();
        }
        public void SetLTV(){
            this.LTV = LTVCount();
        }
        public void SetRoI(){
            this.ROI = ROI();
        }

        public double getCR() {
            return CR;
        }

        public double getConvR() {
            return ConvR;
        }

        public double getRetR() {
            return RetR;
        }

        public double getCac() {
            return Cac;
        }

        public double getARPU() {
            return ARPU;
        }

        public double getLTV() {
            return LTV;
        }

        public double getROI() {
            return ROI;
        }
}
