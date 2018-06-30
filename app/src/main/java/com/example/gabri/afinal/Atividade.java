package com.example.gabri.afinal;

public class Atividade {

    private String tipo;
    private int tempo;
    private int km;
    private  int num;

    public Atividade(String tipo, int tempo, int km, int num){

        setTipo(tipo);
        setTempo(tempo);
        setKm(km);
        setNum(num);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
