import java.awt.*;

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
        if (keyboard.isKeyDown(Key.Down)){
            setY(getY() + 5);
        }
        if (keyboard.isKeyDown(Key.Up)){
            setY(getY() - 5);
        }
        if (keyboard.isKeyDown(Key.Right)){
            setX(getX() + 5);
        }
        if (keyboard.isKeyDown(Key.Left)){
            setX(getX() - 5);
        }
    }
}
