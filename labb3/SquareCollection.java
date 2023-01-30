import java.util.*;
import java.awt.*;

public class SquareCollection {
    private ArrayList<ColoredBox> squares = new ArrayList<ColoredBox>();

    public SquareCollection(int row_size, int rows){
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < row_size; j++){
                ColoredBox redBox = new ColoredBox(j * 80, i*80, 80, 80, i + 1, rows - i - 1);
                this.squares.add(redBox);
            }
        }
    }

    public void update(Keyboard keyboard){
        for (ColoredBox square: this.squares){
            square.update(keyboard);
        }
    }

    public void draw(Graphics2D graphics){
        for (int i = 0; i < squares.size(); i++){
            this.squares.get(i).draw(graphics);
        }
    }

    public ColoredBox getSquare(int i){
        return squares.get(i);
    }

    public ArrayList<ColoredBox> getAllSquares(){
        return squares;
    }
}
