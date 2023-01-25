import java.util.*;
import java.awt.*;

public class SquareCollection {
    private ArrayList<RedBox> squares = new ArrayList<RedBox>();

    public SquareCollection(int size){
        for (int i = 0; i < size; i++){
            RedBox redBox = new RedBox(i * 80 + 30, 20, 20, 20);
            this.squares.add(redBox);
        }
    }

    public void update(Keyboard keyboard, int tickcount){
        if (tickcount % 40 == 0){
            for (int i = 0; i < this.squares.size(); i ++){
                this.squares.get(i).setY(this.squares.get(i).getY() + 20);
            }
        }
        if (this.squares.get(0).getY() >= 600){
            System.exit(0);
        }
    }

    public void draw(Graphics2D graphics){
        for (int i = 0; i < squares.size(); i++){
            this.squares.get(i).draw(graphics);
        }
    }
}
