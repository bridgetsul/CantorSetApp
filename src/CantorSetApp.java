import processing.core.PApplet;
import processing.core.PVector;
import java.util.ArrayList;

public class CantorSetApp extends PApplet {
    private static CantorSetApp app;
    private ArrayList<Line> lines;
    private int nextIndex;

    public static void main(String[] args){
        PApplet.main("CantorSetApp");
    }

    public CantorSetApp(){
        app = this;
        lines = new ArrayList<Line>();
        nextIndex = 0;
    }

    public void setup() {
        cantor( width / 2, height / 2, 300);
    }

    public void settings(){
        size(1000, 1000);
    }

    public void draw(){
        if (nextIndex < lines.size()) {
            lines.get(nextIndex).display();
            nextIndex++;
        }
    }

    public static CantorSetApp getApp(){
        return app;
    }

    private void cantor(float x, float y, float len) {
        if (len >= 2) {
            PVector start = new PVector(x, y);
            PVector end = new PVector(len + x, y);
            Line line = new Line(start, end);
            lines.add(line);
            y += 20;

            //code from textbook
            cantor(x, y, len / 3);
            cantor(x + len * 2 / 3, y, len / 3);
        }
    }
}