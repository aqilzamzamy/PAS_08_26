package com.example.pas_08_26;

public class PlayerModel {
    private String strCutout;
    private String strNumber;
    private String strPlayer;

    public PlayerModel(String strCutout, String strNumber, String strPlayer){
        this.strCutout=strCutout;
        this.strNumber=strNumber;
        this.strPlayer=strPlayer;
    }

    public  String getStrCutout(){
        return  strCutout;
    }

    public String getStrPlayer() {
        return strPlayer;
    }

    public String getStrNumber() {
        return strNumber;
    }
}

