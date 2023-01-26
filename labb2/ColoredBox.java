import java.awt.*;

public class ColoredBox extends Sprite {
    private Color color;
    public ColoredBox(int x, int y, int width, int height, Color color){
        super(x, y, width, height);
        this.color = color;
    }

    @Override
    public void draw(Graphics2D graphics) {
        graphics.setColor(this.color);
        graphics.fillRect(getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public void update(Keyboard keyboard){

    }
}
