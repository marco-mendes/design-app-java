package dia02.laboratorio1.exemplos.exemplo3;

public class AreaCalculator {
    public double getArea(Shape[] shapes) {
        double area = 0;
        for(var shape : shapes) {
            area += shape.getArea();
        }

        return area;
    }
}