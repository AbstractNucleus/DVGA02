import java.awt.Graphics2D;

public abstract class Sprite {
	private int x, y, width, height, hp;
	private int hits = 0;
	public int getX() { return this.x; }
	public int getY() { return this.y; }
	public int getWidth() { return this.width; }
	public int getHeight() { return this.height; }
	public void setX(int x) { this.x = x; };
	public void setY(int y) { this.y = y; };
	public void setWidth(int width) { this.width = width; };
	public void setHeight(int height) { this.height = height; };
	public Sprite(int x, int y, int width, int height, int hp) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.hp = hp;
	}
	public abstract void update(Keyboard keyboard);
	public abstract void draw(Graphics2D graphics);

	public boolean isCollidedWith(Sprite target){
		int target_left_side_x = target.getX();
		int target_right_side_x = target.getX() + target.getWidth();
		int target_bottom_side_y = target.getY() + target.getHeight();
		int target_top_side_y = target.getY();
		
		int self_left_side_x = this.getX();
		int self_right_side_x = this.getX() + this.getWidth();
		int self_top_side_y = this.getY();
		int self_bottom_side_y = this.getY() + this.getHeight();

		if (self_left_side_x <= target_right_side_x && self_right_side_x >= target_left_side_x && self_top_side_y <= target_bottom_side_y && self_bottom_side_y >= target_top_side_y){return true;}
        return false;
    }

    public Side getCollSide(Sprite target){
        int target_left_side_x = target.getX();
		int target_right_side_x = target.getX() + target.getWidth();
		int target_bottom_side_y = target.getY() + target.getHeight();
		int target_top_side_y = target.getY();
		
		int self_left_side_x = this.getX();
		int self_right_side_x = this.getX() + this.getWidth();
		int self_top_side_y = this.getY();
		int self_bottom_side_y = this.getY() + this.getHeight();

		boolean self_is_right_of_target = self_left_side_x >= target_right_side_x;
		boolean self_is_left_of_target = self_right_side_x <= target_left_side_x;
		boolean self_is_below_of_target = self_top_side_y >= target_bottom_side_y;
		boolean self_is_above_of_target = self_bottom_side_y <= target_top_side_y;

		if (self_is_right_of_target && !self_is_above_of_target && !self_is_below_of_target && !self_is_left_of_target){return Side.Right;}
		else if (self_is_left_of_target && !self_is_above_of_target && !self_is_below_of_target && !self_is_right_of_target){return Side.Left;}
		else if (self_is_below_of_target && !self_is_above_of_target && !self_is_left_of_target && !self_is_right_of_target){return Side.Bottom;}
		else {return Side.Top;}
		
    }

	public void addHits(int i){
		this.hits += i;
	}

	public void setHits(int i){
		this.hits = i;
	}

	public int getHits(){
		return this.hits;
	}

	public void setHp(int i){
		this.hp = i;
	}

	public int getHp(){
		return this.hp;
	}
}
