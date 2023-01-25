import java.awt.*;

public class Player extends Sprite{
    private Color color;
    Player(int x, int y, int height, int width, Color color){
        super(x, y, width, height);
        this.color = color;
    }
    
    @Override
    public void draw(Graphics2D graphics){
        graphics.drawRect(getX(), getY(), getWidth(), getHeight());
        graphics.setColor(this.color);
    }

    @Override
    public void update(Keyboard keyboard){

    }
}
