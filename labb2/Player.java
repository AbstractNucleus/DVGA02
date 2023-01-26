import java.awt.*;
import java.util.*;

public class Player extends Sprite{
    private Color color;
    Player(int x, int y, int height, int width, Color color){
        super(x, y, width, height);
        this.color = color;
    }
    
    @Override
    public void draw(Graphics2D graphics){
        graphics.setColor(this.color);
        graphics.fillOval(getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public void update(Keyboard keyboard){
        ArrayList<Key> keysDown = keyboard.getKeysDown();

        for (int i = 0; i < keysDown.size(); i++){
            switch (keysDown.get(i)){
                case Up: this.setY(getY() - 5); break;
                case Down: this.setY(getY() + 5); break;
                case Right: this.setX(getX() + 5); break;
                case Left: this.setX(getX() - 5); break;
                case Enter: continue;
                case Escape: continue;
                case Space: continue;
            }
        }
    }
}
