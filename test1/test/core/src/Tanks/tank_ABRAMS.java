package Tanks;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygame.MyGame;

public class tank_ABRAMS extends tank {

    private String name;

    private SpriteBatch sb;

    private Texture texture;

    private Sprite sprite;

    public tank_ABRAMS(String imgPath) {

        name = "ABRAMS";

        sb = new SpriteBatch();

        texture = new Texture(Gdx.files.internal(imgPath));

        sprite = new Sprite(texture,0,0,500,500);

    }

    public void draw(int x) {
        sb.begin();

        if (x == -1) {
            sprite.setPosition(MyGame.WIDTH*4/5-95,MyGame.HEIGHT/2-15);
            sprite.setSize(30,30);
            sprite.draw(sb);
        }
        else if (x == 0) {
            sprite.setPosition(MyGame.WIDTH*4/5+65,MyGame.HEIGHT/2-15);
            sprite.setSize(30,30);
            sprite.draw(sb);
        }
        else {
            sprite.setPosition(MyGame.WIDTH*4/5-25,MyGame.HEIGHT/2-25);
            sprite.setSize(50,50);//sprite.setSize(80,80);
            sprite.draw(sb);
        }

        sb.end();
    }

    public String getName() {
        return name;
    }

}
