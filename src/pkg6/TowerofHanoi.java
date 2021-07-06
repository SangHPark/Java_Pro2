package pkg6;

public class TowerofHanoi {

	public void move(int numberOfDiscs, char from, char to, char inter) {
		if (numberOfDiscs <= 1) {
			System.out.println("Moving disc " + 1 + " from " + from + " to " + to);
		} else {
			move(numberOfDiscs -1, from, inter, to);
			System.out.println("Moving disc " + numberOfDiscs + " from " + from + " to " + to);
			move(numberOfDiscs -1, inter, to, from);		
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TowerofHanoi toh = new TowerofHanoi();
		toh.move(100, 'A','C','B');

	}

}
