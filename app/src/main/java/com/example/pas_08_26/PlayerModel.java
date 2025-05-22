package com.example.pas_08_26;

public class PlayerModel {
    private String strCutout;
    private String strPlayer;

    private String strNumber;

    private String strTeam;



    public PlayerModel(String strTeam,String strCutout,  String strPlayer, String strNumber){
        this.strCutout=strCutout;
        this.strNumber=strNumber;
        this.strPlayer=strPlayer;
        this.strTeam=strTeam;

    }



    public  String getStrPlayer(){
        return  strPlayer;
    }

    public String getStrCutout() {
        return strCutout;
    }

    public String getStrNumber() {
        return strNumber;
    }

    public String getStrTeam() {
        return strTeam;
    }
}
