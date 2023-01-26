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
		int target_left_side_coord = target.getX() - target.getWidth()/2;
		int target_right_side_coord = target.getX() + target.getWidth()/2;
		int target_top_side_coord = target.getY() - target.getHeight()/2;
		int target_bottom_side_coord = target.getY() + target.getHeight()/2;
		
		int self_left_side_coord = this.getX() - this.getWidth()/2;
		int self_right_side_coord = this.getX() + this.getWidth()/2;
		int self_top_side_coord = this.getY() - this.getHeight()/2;
		int self_bottom_side_coord = this.getY() + this.getHeight()/2;

		if (self_left_side_coord < target_right_side_coord && self_right_side_coord > target_left_side_coord && self_top_side_coord < target_bottom_side_coord && self_bottom_side_coord > target_top_side_coord){
			return true;
		}
        return false;
    }

    public Side getCollSide(Sprite target){
        int target_left_side_coord = target.getX() - target.getWidth()/2;
		int target_right_side_coord = target.getX() + target.getWidth()/2;
		int target_bottom_side_coord = target.getY() + target.getHeight()/2;
		
		int self_left_side_coord = this.getX() - this.getWidth()/2;
		int self_right_side_coord = this.getX() + this.getWidth()/2;
		int self_top_side_coord = this.getY() - this.getHeight()/2;

		if (self_left_side_coord < target_right_side_coord && self_right_side_coord > target_left_side_coord){
			if (self_top_side_coord < target_bottom_side_coord){
				return Side.Top;
			} else {
				return Side.Bottom;
			}
		} else {
			if (self_left_side_coord < target_right_side_coord){
				return Side.Left;
			} else {
				return Side.Right;
			}
		}
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
