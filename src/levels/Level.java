package levels;

public class Level {

	// TODO: create a private int[][] called lvlData
	private int[][] lvlData;

	public Level(int[][] lvlData) {
		this.lvlData = lvlData;
		// TODO: set this lvlData to lvlData
	}

	public int getSpriteIndex(int x, int y) {
        return lvlData[y][x];
		// TODO: lvlData[y][x]
	}

	public int[][] getLevelData() {
		return lvlData;
		// TODO: return lvlData
	}

}
