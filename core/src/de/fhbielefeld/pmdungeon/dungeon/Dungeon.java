package de.fhbielefeld.pmdungeon.dungeon;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ObjectMap;
import de.fhbielefeld.pmdungeon.dungeon.wallpattern.WallPattern;
import de.fhbielefeld.pmdungeon.dungeon.wallpattern.WallPatternFactory;
import de.fhbielefeld.pmdungeon.util.Textures;
import de.fhbielefeld.pmdungeon.util.dungeonconverter.Coordinate;
import de.fhbielefeld.pmdungeon.util.dungeonconverter.Room;

import java.util.Random;

public class Dungeon {

    private Room[] rooms;

    private int width;
    private int height;
    private Tile[][] tiles;

    private final ObjectMap<Textures, Texture> textureMap;
    private final WallPatternFactory wallPatternFactory;

    public Dungeon() {
        textureMap = Textures.loadAllTextures();
        wallPatternFactory = new WallPatternFactory(textureMap);
    }

    public Dungeon(int width, int height) {
        this();
        this.width = width;
        this.height = height;
        tiles = new Tile[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                tiles[i][j] = Tile.EMPTY;
            }
        }
    }

    public Coordinate getStartingPoint() {
        Coordinate startRoomExtensions = rooms[0].getExtension();
        Random random = new Random();
        Coordinate start = new Coordinate(Integer.MIN_VALUE, Integer.MIN_VALUE);
        while (getTileAt(start) != Tile.FLOOR) {
            start.setX(random.nextInt(startRoomExtensions.getX() - 1));
            start.setY(random.nextInt(startRoomExtensions.getY() - 1));
        }
        start.add(new Coordinate(1, 1));
        start.add(new Coordinate(rooms[0].getPosition().getX(), rooms[0].getPosition().getY()));
        return start;
    }

    public void renderWalls(SpriteBatch batch) {
        for (int x = 0; x < this.width; x++) {
            for (int y = this.height - 1; y >= 0; y--) {
                if (this.tiles[x][y] == Tile.WALL) {
                    WallPattern wallPattern = wallPatternFactory.getWallPattern(this, new Coordinate(x, y));
                    if (wallPattern != null) {
                        wallPattern.render(batch, new Coordinate(x, y));
                    }
                }
            }
        }
    }

    public void renderFloor(SpriteBatch batch) {
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                if (this.tiles[i][j] != Tile.EMPTY && this.tiles[i + 1][j] != Tile.EMPTY) {
                    batch.draw(textureMap.get(Textures.FLOOR), i, j, 1, 1);
                }
            }
        }
    }

    public enum Tile {
        FLOOR,
        WALL,
        DOOR,
        EMPTY,
    }

    public Tile getTileAt(int x, int y) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            return tiles[x][y];
        }
        return null;
    }

    public Tile getTileAt(Coordinate coordinate) {
        return this.getTileAt(coordinate.getX(), coordinate.getY());
    }

    public void setTileAt(int x, int y, Tile tile) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            tiles[x][y] = tile;
        }
    }

    public void setRooms(Room[] rooms) {
        this.rooms = rooms;
    }

    public Room getRoom(int index) {
        return this.rooms[index];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void dispose() {
        for (Texture t : textureMap.values()) {
            t.dispose();
        }
    }
}
