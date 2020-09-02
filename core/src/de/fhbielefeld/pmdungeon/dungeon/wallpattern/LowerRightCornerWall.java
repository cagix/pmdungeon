package de.fhbielefeld.pmdungeon.dungeon.wallpattern;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ObjectMap;
import de.fhbielefeld.pmdungeon.dungeon.Dungeon;
import de.fhbielefeld.pmdungeon.util.Textures;
import de.fhbielefeld.pmdungeon.util.dungeonconverter.Coordinate;

public class LowerRightCornerWall extends WallPattern {

    public LowerRightCornerWall(ObjectMap<Textures, Texture> textureMap) {
        super(textureMap);

        this.pattern = new Dungeon.Tile[][]{
                {A, W, A},
                {W, W, A},
                {A, A, A}
        };
    }

    @Override
    public void render(SpriteBatch batch, Coordinate position) {
        batch.draw(textureMap.get(Textures.WALL_SIDE_FRONT_RIGHT), position.getX() * textureMap.get(Textures.WALL_SIDE_FRONT_RIGHT).getWidth(), position.getY() * textureMap.get(Textures.WALL_SIDE_FRONT_RIGHT).getHeight());
        batch.draw(textureMap.get(Textures.WALL_CORNER_FRONT_RIGHT), (position.getX() - 1f) * textureMap.get(Textures.WALL_CORNER_FRONT_RIGHT).getWidth(), position.getY() * textureMap.get(Textures.WALL_CORNER_FRONT_RIGHT).getHeight());
    }
}