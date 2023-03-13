import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.*;

public class Keyboard {
	HashMap<Key, Boolean> state;
	public Keyboard() {
		state = new HashMap<Key, Boolean>();
		state.put(Key.Up, false);
		state.put(Key.Down, false);
		state.put(Key.Left, false);
		state.put(Key.Right, false);
		state.put(Key.Escape, false);
		state.put(Key.Enter, false);
		state.put(Key.Space, false);
		state.put(Key.X, false);
		state.put(Key.Z, false);
		state.put(Key.C, false);
	}
	
	public boolean isKeyDown(Key key) {
		if(state.containsKey(key)) {
			return state.get(key);
		}
		return false;
	}
	
	public boolean isKeyUp(Key key) {
		return !isKeyDown(key);
	}
	
	public void processKeyEvent(int key, boolean st) {
		switch(key) {
			case KeyEvent.VK_UP:     state.put(Key.Up,     st); break;
			case KeyEvent.VK_DOWN:   state.put(Key.Down,   st); break;
			case KeyEvent.VK_LEFT:   state.put(Key.Left,   st); break;
			case KeyEvent.VK_RIGHT:  state.put(Key.Right,  st); break;
			case KeyEvent.VK_ESCAPE: state.put(Key.Escape, st); break;
			case KeyEvent.VK_ENTER:  state.put(Key.Enter,  st); break;
			case KeyEvent.VK_SPACE:  state.put(Key.Space,  st); break;
			case KeyEvent.VK_X:  	 state.put(Key.X,  	   st); break;
			case KeyEvent.VK_Z:  	 state.put(Key.Z,  	   st); break;
			case KeyEvent.VK_C:  	 state.put(Key.C,  	   st); break;
		}
	}

	public ArrayList<Key> getKeysDown(){
		ArrayList<Key> keysDown = new ArrayList<Key>();

		if (state.get(Key.Up)){
			keysDown.add(Key.Up);
		}
		if (state.get(Key.Down)){
			keysDown.add(Key.Down);
		}
		if (state.get(Key.Left)){
			keysDown.add(Key.Left);
		}
		if (state.get(Key.Right)){
			keysDown.add(Key.Right);
		}
		if (state.get(Key.X)){
			keysDown.add(Key.X);
		}
		if (state.get(Key.Z)){
			keysDown.add(Key.Z);
		}
		if (state.get(Key.C)){
			keysDown.add(Key.C);
		}


		return keysDown;
	}
	
}
