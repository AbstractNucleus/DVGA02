import java.awt.*;
import java.util.*;

public class Ball extends Sprite {
    private boolean started_moving = false;
    private int x_speed = 0;
    private int y_speed = 0;

    public Ball(int x, int y, int width, int height){
        super(x, y, width, height, 1);
    }

    @Override
    public void draw(Graphics2D graphics){
        graphics.setColor(Color.gray);
        graphics.fillOval(getX(), getY(), getWidth(), getHeight());
        graphics.setColor(Color.white);
        graphics.drawOval(getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public void update(Keyboard keyboard){}
    
    public void new_update(Keyboard keyboard, ArrayList<Sprite> objects){
        if (keyboard.isKeyDown(Key.Space) && !started_moving){
            started_moving = true;
            this.x_speed = 4;
            this.y_speed = 6;
        }

        checkCollission(objects);

        setX(getX() + x_speed);
        setY(getY() + y_speed);
    }

    public void checkCollission(ArrayList<Sprite> objects){
        for (Sprite object: objects){
            if (isCollidedWith(object)){
                Side side = getCollSide(object);
                switch (side){
                    case Top: this.y_speed *= -1; break;
                    case Bottom: this.y_speed *= -1; break;
                    case Left: this.x_speed *= -1; break;
                    case Right: this.x_speed *= -1; break;
                }
                object.addHits(1);
            }
        }

        if ((getX() + getWidth()/2) >= (800)){
            this.x_speed *= -1;
        }
        else if ((getX() - getWidth()/2) <= (0 - getWidth()/2)){
            this.x_speed *= -1;
        }
        else if ((getY() - getHeight()/2) <= (0 - getHeight()/2)){
            this.y_speed *= -1;
        }
        
    }
}