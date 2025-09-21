package org.example.lesson4.Figura;

public class Figura {
    private String colorBorder;
    private String colorFill;
    public Figura (String colorBorder, String colorFill){
        this.colorBorder = colorBorder;
        this.colorFill = colorFill;
    }
    public void figuraColorInfo(){
        System.out.printf("Цвет границы: %s\nЦвет заливки: %s\n\n", colorBorder, colorFill);
    }
}
