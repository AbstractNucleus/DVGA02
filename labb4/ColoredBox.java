import java.awt.*;

public class ColoredBox extends Sprite {
    private int points;
    private int visible = 1;

    public ColoredBox(int x, int y, int width, int height, int hp, int points){
        super(x, y, width, height, hp);
        this.points = points;
    }

    @Override
    public void draw(Graphics2D graphics) {
        if(visible == 0){return;}

        switch (getHp()-getHits()){
            case 0: graphics.setColor(Color.red); break;
            case 1: graphics.setColor(Color.pink); break;
            case 2: graphics.setColor(Color.magenta); break;
            case 3: graphics.setColor(Color.blue); break;
            case 4: graphics.setColor(Color.cyan); break;
            case 5: graphics.setColor(Color.yellow); break;
            case 6: graphics.setColor(Color.white); break;
            default: graphics.setColor(Color.gray); break;
        }
        
        graphics.fillRect(getX(), getY(), getWidth(), getHeight());
        graphics.setColor(Color.black);
        graphics.drawRect(getX(), getY(), getWidth(), getHeight());
        graphics.setColor(Color.black);
        graphics.drawString(String.valueOf(getHp()-getHits()), getX() + getWidth()/2, getY() + getHeight()/2);
        
    }

    @Override
    public void update(Keyboard keyboard){
        if(getHits() < getHp()){
            this.visible = 1;
        } else{this.visible = 0;}
    }

    public int getPoints(){
        return this.points;
    }

    public int getVisible(){return this.visible;}
}
