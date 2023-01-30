import java.awt.*;
import java.util.*;

public class Ball extends Sprite {
    private boolean started_moving = false;
    private int x_speed = 0;
    private int y_speed = 0;
    private int visible = 0;

    public Ball(int x, int y, int width, int height){
        super(x, y, width, height, 1);
    }

    public void setVisible(boolean i){
        if (i){this.visible = 1;}
        else {this.visible = 0;}
    }

    @Override
    public void draw(Graphics2D graphics){
        if (this.visible == 0){
            return;
        }

        graphics.setColor(Color.gray);
        graphics.fillOval(getX(), getY(), getWidth(), getHeight());
        graphics.setColor(Color.white);
        graphics.drawOval(getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public void update(Keyboard keyboard){}
    
    public void new_update(Keyboard keyboard, ArrayList<Sprite> objects){
        if (this.visible == 0){
            return;
        }

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
                    case Top: this.y_speed = -Math.abs(this.y_speed); break;
                    case Bottom: this.y_speed = Math.abs(this.y_speed); break;
                    case Left: this.x_speed = -Math.abs(this.x_speed); break;
                    case Right: this.x_speed = Math.abs(this.x_speed); break;
                }
                object.addHits(1);
            }
        }

        if ((getX() + getWidth()) > (800)){
            this.x_speed = -Math.abs(this.x_speed);
        }
        else if (getX() < 0){
            this.x_speed = Math.abs(this.x_speed);
        }
        else if (getY() < 0){
            this.y_speed = Math.abs(this.y_speed);
        }
    }
}
