package org.example.lesson4.Figura;

class Circle extends Figura implements Operations {
    private double radius;
    public Circle (String colorBorder, String colorFill, double radius){
        super(colorBorder, colorFill);
        if (radius>0){
            this.radius = radius;
        }
        else{System.out.println("Радиус не может быть отрицательным числом");}
    }
    public double getRadius() {
        return radius;
    }
    @Override
    public double getPerimetr (){
        return 2*Math.PI*radius;
    }
    @Override
    public double getArea (){
        return Math.PI*radius*radius;
    }
    @Override
    public void figuraInfo(){
        System.out.printf("Фигура: Круг\n");
        System.out.printf("Периметр: %.2f\nПлощадь: %.2f\n", getPerimetr(), getArea());
        super.figuraColorInfo();
    }
}
