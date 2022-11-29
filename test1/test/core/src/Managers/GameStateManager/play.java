package Managers.GameStateManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygame.MyGame;

public class play extends gameStates {

    private SpriteBatch sb;

    private Texture texture;

    private Sprite sprite;

    public play(gameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void init() {

        sb = new SpriteBatch();

        texture = new Texture(Gdx.files.internal("play.jpg"));

        sprite = new Sprite(texture,0,0,1200,500);

    }

    @Override
    public void update(float dt) {
        ScreenUtils.clear(Color.BLACK);
        sb.begin();

        sprite.setPosition(0,0);
        sprite.setSize(MyGame.WIDTH,MyGame.HEIGHT);
        sprite.draw(sb);

        sb.end();
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void draw() {

    }

    @Override
    public void dispose() {

    }

}
