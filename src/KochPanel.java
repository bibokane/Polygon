import javax.swing.*;
import java.awt.*;

public class KochPanel extends JPanel {
    int xPoints[]= {250, 400, 100};
    int yPoints[] = {50, 350, 350};
    int nPoints = 3;
    int step;
    KochPanel(int step){
        this.step = step;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Polygon p1 = new Polygon(xPoints, yPoints, nPoints);
        //Polygon p2 = subdivide(p1);
        Graphics2D g2 = (Graphics2D) g;
        //g2.drawPolygon(p2);
        drawPolygon(g2, p1, this.step);
    }
    protected void drawPolygon(Graphics2D g2, Polygon polygon, int step) {
        if(step==0) {
            g2.drawPolygon(polygon);
        }else {
            Polygon p2 = subdivide(polygon);
            drawPolygon(g2, p2, step-1);
        }
    }

    static Polygon subdivide(Polygon polygon) {
        int n = polygon.npoints;
        Polygon pnew = new Polygon();
        for (int i = 0; i < n; i++) {
            int ax = polygon.xpoints[i];
            int ay = polygon.ypoints[i];

            int ex = polygon.xpoints[(i + 1) % n];
            int ey = polygon.ypoints[(i + 1) % n];

            double bx = (2 * ax + ex) / 3.0;
            double by = (2 * ay + ey) / 3.0;

            double dx = (ax + 2 * ex) / 3.0;
            double dy = (ay + 2 * ey) / 3.0;

            int AEx = ex - ax;
            int AEy = ey - ay;

            //Orth AEx

            double oAEx = AEy;
            double oAEy = -AEx;

            double lengthAE = Math.sqrt(AEy * AEy + AEx * AEx);

            double nAEx = oAEx / lengthAE;
            double nAEy = oAEy / lengthAE;

            double lengthBC = lengthAE / 3.0;

            double lengthBPm = lengthAE / 6.0;

            double lengthPmC = Math.sqrt(lengthBC * lengthBC - lengthBPm * lengthBPm);

            double pmx = ax + AEx / 2.0;
            double pmy = ay + AEy / 2.0;

            int cx = (int) (pmx + lengthPmC * nAEx);
            int cy = (int) (pmy + lengthPmC * nAEy);

            pnew.addPoint(ax, ay);
            pnew.addPoint((int) bx, (int) by);
            pnew.addPoint(cx, cy);
            pnew.addPoint((int) dx, (int) dy);


        }
        return pnew;
    }
}
