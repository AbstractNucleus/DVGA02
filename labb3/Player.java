import java.awt.*;
import java.util.*;

public class Player extends Sprite{
    private Color color;
    private int player_speed = 8;
    private int max_speed = 30;
    Player(int x, int y, int width, int height, Color color){
        super(x, y, width, height, 1);
        this.color = color;
    }
    
    @Override
    public void draw(Graphics2D graphics){
        graphics.setColor(this.color);
        graphics.fillRect(getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public void update(Keyboard keyboard){
        ArrayList<Key> keysDown = keyboard.getKeysDown();

        for (int i = 0; i < keysDown.size(); i++){
            switch (keysDown.get(i)){
                case Up: continue;
                case Down: continue;
                case Right: if ((getX() + getWidth()/2) < (800 - getWidth()/2)){this.setX(getX() + this.player_speed);}; break;
                case Left: if ((getX() - getWidth()/2) > (0 - getWidth()/2)){this.setX(getX() - this.player_speed);}; break;
                case X: this.player_speed = 8; break;
                case C: if (this.player_speed < this.max_speed){this.player_speed += 2;}; break;
                case Z: if (this.player_speed > 4){this.player_speed -= 2;}; break;
                case Enter: continue;
                case Escape: continue;
                case Space: continue;
            }
        }
    }
}
