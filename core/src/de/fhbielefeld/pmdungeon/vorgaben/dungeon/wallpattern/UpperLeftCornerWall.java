package de.fhbielefeld.pmdungeon.vorgaben.dungeon.wallpattern;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ObjectMap;
import de.fhbielefeld.pmdungeon.vorgaben.dungeon.DungeonTextures;
import de.fhbielefeld.pmdungeon.vorgaben.dungeon.dungeonconverter.Coordinate;
import de.fhbielefeld.pmdungeon.vorgaben.dungeon.tiles.Tile;
public class UpperLeftCornerWall extends WallPattern {

    public UpperLeftCornerWall(ObjectMap<DungeonTextures, Texture> textureMap) {
        super(textureMap);

        this.patternList.add(new Tile.Type[][]{
                {A, A, A},
                {A, W, W},
                {A, W, A}
        });
    }

    @Override
    public void render(SpriteBatch batch, Coordinate position) {
        batch.draw(textureMap.get(DungeonTextures.WALL_CORNER_LEFT), position.getX(), position.getY(), 1, 1);
        batch.draw(textureMap.get(DungeonTextures.WALL_CORNER_TOP_LEFT), position.getX(), position.getY() + 1f, 1, 1);
    }
}
