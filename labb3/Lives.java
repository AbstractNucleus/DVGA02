import java.awt.*;

public class Lives extends Sprite {
    private int life;
    private Color color;

    public Lives(int x, int y, Color color){
        super(x, y, 100, 100, 1);
        this.color = color;
    }

    public void setLife(int i){
        this.life = i;
    }

    @Override
    public void draw(Graphics2D graphics){
        graphics.setColor(this.color);
        graphics.drawString(Integer.toString(this.life), getX(), getY());
    }

    @Override
    public void update(Keyboard keyboard){

    }
}
