package com.example.demo;

public class AdminLog {
    private String Name;
    private String Password;

    public AdminLog(String name, String password) {
        Name = name;
        Password = password;
    }

    public AdminLog() {
        Name = "";
        Password = "";
    }

    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getPassword() {
        return Password;
    }
    public void setPassword(String password) {
        Password = password;
    }

    protected boolean Check(AdminLog obj1,AdminLog[] obj2)
    {
        int a = 0;
        boolean check = false;
        for(int i=0;i<2;i++)
        {
            if((obj1.getName().equalsIgnoreCase(obj2[i].Name))&&(obj1.getPassword().equalsIgnoreCase(obj2[i].Password))){
                a = 1;
                break;
            }else{
                a = 0;
            }
        }
        if(a==1){check = true;}
        if(a==0){check = false;}
        return check;
    }

}
