
import java.lang.*;
public class Pozycja {
    public Pozycja(double x, double y) {
        this.x = x;
        this.y = y;
    }


    public double x;
    public double y;


    public double odl(Pozycja cel) {
        double dx = cel.x - this.x;
        double dy = cel.y - this.y;
        double d = (double) Math.pow(dx*dx+dy*dy, 0.5);
        return d;
    }


    public void przemiesc(double aktPredkosc, double dt, Pozycja cel) {
        if (aktPredkosc * dt > odl(cel)) { //zeby nie pojechal za daleko
            this.x = cel.x;
            this.y = cel.y;
        } else {
            double dist = odl(cel);
            this.x += aktPredkosc * dt * (cel.x - this.x) / dist;
            this.y += aktPredkosc * dt * (cel.y - this.y) / dist;
        }
    }

}




