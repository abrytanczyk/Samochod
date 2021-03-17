import java.lang.Math;
public class Pozycja {
    private double x;
    private double y;

    public Pozycja(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }

    public double[] getXY() {
        double[] p = {this.x, this.y};
        return p;
    }

    public void setXY(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double odleglosc(double x, double y){
        double d = (x-this.x)*(x-this.x) + (y-this.y)*(y-this.y);
        return Math.sqrt(d);
    }

    public void przeniesc(double v, double time, double x, double y){
        if(v*time >= odleglosc(x, y)) {
            this.x = x;
            this.y = y;
        }
        else {
            double dx = v*time*(x-this.x)/odleglosc(x, y);
            double dy = v*time*(y-this.y)/odleglosc(x, y);
            this.x += dx;
            this.y += dy;
        }
    }

}
