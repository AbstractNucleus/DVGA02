import java.awt.*;

public class Lives extends Sprite {
    private int life;
    private Color color;
    private String text;

    public Lives(int x, int y, Color color, String text){
        super(x, y, 100, 100, 1);
        this.color = color;
        this.text = text;
    }

    public void setLife(int i){
        this.life = i;
    }

    @Override
    public void draw(Graphics2D graphics){
        graphics.setColor(this.color);
        graphics.setFont(new Font("Comic Sans MS", Font.PLAIN, 18)); 
        graphics.drawString(text + Integer.toString(this.life), getX(), getY());
    }

    @Override
    public void update(Keyboard keyboard){

    }
}
