package testClasses;

import gameEngine.*;
import errors.*;
import gameDisplay.*;

public class InitializationTest {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		// Menu menu = new Menu();
		Game game = new Game();
		game.map.printMap(game.map);
	}

}
