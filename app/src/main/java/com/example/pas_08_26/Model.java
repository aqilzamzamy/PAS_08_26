package com.example.pas_08_26;

public class Model {
    private String strTeam;
    private String strStadium;
    private String strBadge;



    public Model(String strTeam, String strStadium, String strBadge,String strCutout,  String strPlayer, String strNumber){
        this.strTeam=strTeam;
        this.strStadium=strStadium;
        this.strBadge=strBadge;

    }



    public  String getStrTeam(){
        return  strTeam;
    }

    public String getStrStadium() {
        return strStadium;
    }

    public String getStrBadge() {
        return strBadge;
    }


}
