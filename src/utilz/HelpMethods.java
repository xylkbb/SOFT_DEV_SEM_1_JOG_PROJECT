package utilz;

import java.awt.geom.Rectangle2D;

import main.Game;

import static java.util.function.Predicate.not;

public class HelpMethods {

	public static boolean CanMoveHere(float x, float y, float width, float height, int[][] lvlData) {
		if (IsSolid(x, y, lvlData)){
			if(!IsSolid(x + width, y + height, lvlData)){
				if(!IsSolid(x + width, y, lvlData)){
					return true;
				}

			}
		}
		// TODO: check if not IsSolid(x, y, lvlData)
		// TODO: if so check if not isSolid(x + width, y + heigth, lvlData)
		// TODO: if so check if not isSolid(x + width, y, lvlData)
		// TODO: if so check if not isSolid(x, y + height, lvlData) and return true
		// TODO: if not do nothing
		// TODO: if not do nothing
		// TODO: if not do nothing
		// TODO: if not return false.
        return false;
    }

	private static boolean IsSolid(float x, float y, int[][] lvlData) {
		if (x < 0 || x >= Game.GAME_WIDTH){
			return true;
		}
		if (y < 0 || y >= Game.GAME_HEIGHT){
			return true;
		}

		float xIndex = x / Game.TILES_SIZE;
		float yIndex = y / Game.TILES_SIZE;
		// TODO: if x is less than 0 or x is greater than or equal to Game.GAME_WIDTH -> return true
		// TODO: if y is less than 0 or y is greater than or equal to Game.GAME_HEIGHT -> return true
		// TODO: create a float called xIndex and set to x divided by Game.TILES_SIZE
		// TODO: repeat for yIndex.

		int value = lvlData[(int) yIndex][(int) xIndex];

		if(value >= 48 || value < 0 || value != 11){
			return true;
		}
		// TODO: get an integer named value from lvlData[(int) yIndex][(int) xIndex]

		// TODO: if value is greater than or equal to 48 or value is less than 0 or value is not equal to 11 -> return true

		return false;
	}

	public static float GetEntityXPosNextToWall(Rectangle2D.Float hitbox, float xSpeed) {
		int currentTile = (int) (hitbox.x / Game.TILES_SIZE);
		if (xSpeed >  0){
			int tileXPos = currentTile * Game.TILES_SIZE;
			int xOffset = (int) (Game.TILES_SIZE - hitbox.width);
			return tileXPos + xOffset - 1;
		}
		else return currentTile * Game.TILES_SIZE;
		// TODO: create an int called currentTile and set to (int) (hitbox.x / Game.TILES_SIZE
		// TODO: if xSpeed is positive
		// TODO: create an int called tileXPos and set to currentTile * Game.TILES_SIZE
		// TODO: create an int called xOffset and set to (int) (Game.TILES_SIZE - hitbox.width)
		// TODO: return tileXPos + xOffset - 1
		// TODO: else return currentTile * Game.TILES_SIZE
	}

	public static float GetEntityYPosUnderRoofOrAboveFloor(Rectangle2D.Float hitbox, float airSpeed) {
		int currentTile = (int) (hitbox.y / Game.TILES_SIZE);
		if (airSpeed > 0){
			int tileYPos = currentTile * Game.TILES_SIZE;
			int yOffset = (int) (Game.TILES_SIZE - hitbox.height);
			return tileYPos + yOffset -1;
		}
		else return currentTile * Game.TILES_SIZE;
		// TODO: create an int called currentTile and set ot (int) (hitbox.y / Game.TILES_SIZE)
		// TODO: if airSpeed is positive
		// TODO: create an int called tileYPos and set to currentTile * Game.TILES_SIZE
		// TODO: create an int called yOffset and set to (int) (Game.TILES_SIZE - hitbox.height)
		// TODO: return tileYPos + yOffset - 1
		// TODO: else return currentTile * Game.TILES_SIZE
	}

	public static boolean IsEntityOnFloor(Rectangle2D.Float hitbox, int[][] lvlData) {

		if (!IsSolid(hitbox.x, hitbox.y + hitbox.height + 1, lvlData)){
			if(!IsSolid(hitbox.x + hitbox.width, hitbox.y + hitbox.height + 1, lvlData)){
				return false;
			}
		}

		// TODO: if not isSolid(hitbox.x, hitbox.y + hitbox.height + 1, lvlData)
		// TODO: if not isSolid(hitbox.x + hitbox.width, hitbox.y + hitbox.height + 1, lvlData)
		// TODO: return false
		// TODO: else nothing

		return true;

	}

}