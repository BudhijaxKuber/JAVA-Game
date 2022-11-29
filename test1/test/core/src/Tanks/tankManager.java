package Tanks;

import Managers.InputManager.gameKeys;
import Objects.myTextBoxManager;
import Player.player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygame.MyGame;

public class tankManager {

    private ShapeRenderer sr;
    private SpriteBatch sb;

    private myTextBoxManager tbm;

    private FreeTypeFontGenerator.FreeTypeFontParameter parameter;

    private BitmapFont font;

    private GlyphLayout layout;

    private int tankNo;
    private tank[] tanks;
    private int no_of_tanks;

    public tankManager() {

        tbm = new myTextBoxManager("Exo-VariableFont_wght.ttf");

        sr = new ShapeRenderer();
        sb = new SpriteBatch();

        FreeTypeFontGenerator gen = new FreeTypeFontGenerator(
                Gdx.files.internal("Exo-VariableFont_wght.ttf")
        );

        layout = new GlyphLayout();

        parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 30;
        parameter.color = new Color(1F,1F,1F,1F);
        parameter.borderWidth=2;
        parameter.borderColor = new Color(1F,1F,1F,1F);

        font = gen.generateFont(parameter);

        tankNo = 0;
        no_of_tanks = 3;

        tanks = new tank[no_of_tanks];
        tanks[0] = new tank_ABRAMS("tank.png");
        tanks[1] = new tank_COALITION("badlogic.jpg");
        tanks[2] = new tank_ABRAMS("wings.jpg");

    }

    public void allotTank(player player) {
        player.allotTank(tanks[tankNo]);
    }

    public int update(float dt, Color bgColor) {
        ScreenUtils.clear(bgColor);
        return handleInput();
    }

    public void draw(boolean b) {

        // Title Box
        tbm.setTextBox(MyGame.WIDTH*4/5,MyGame.HEIGHT*3/4,10,0,1,
                10, new String[]{"CHOOSE TANK"},-1,new Color(1F,1F,1F,1F),
                new Color(1F,1F,1F,1F), new Color(0.292F,0.0F,0.507F,1F)
        );

        // Center Circle
        sr.setAutoShapeType(true);
        sr.begin(ShapeRenderer.ShapeType.Filled);

        if (b) {
            sr.setColor(new Color(1F, 1F, 1F, 1F));
            sr.circle(MyGame.WIDTH * 4 / 5, MyGame.HEIGHT / 2, 45);
        }

        sr.setColor(new Color(0.292F,0.0F,0.507F,1F));
        sr.circle(MyGame.WIDTH*4/5,MyGame.HEIGHT/2,40);

        // Left Circle
        sr.setColor(new Color(0.292F,0.0F,0.507F,1F));
        sr.circle(MyGame.WIDTH*7/10 ,MyGame.HEIGHT/2,30);

        // Right Circle
        sr.setColor(new Color(0.292F,0.0F,0.507F,1F));
        sr.circle(MyGame.WIDTH*9/10 ,MyGame.HEIGHT/2,30);

        sr.end();

        sb.begin();
        // Left Arrow
        layout.setText(font,"<");
        font.setColor(new Color(1F,1F,1F,1F));
        font.draw(sb,"<",MyGame.WIDTH*3/5 + layout.width,MyGame.HEIGHT/2);

        // Right Arrow
        font.setColor(new Color(1F,1F,1F,1F));
        font.draw(sb,">",MyGame.WIDTH - 2*layout.width,MyGame.HEIGHT/2);

        sb.end();

        // Draw Tank
        tanks[tankNo].draw(0);
        if (tankNo>0) tanks[tankNo-1].draw(-1);
        else tanks[no_of_tanks-1].draw(-1);
        if (tankNo<no_of_tanks-1) tanks[tankNo+1].draw(1);
        else tanks[0].draw(1);

    }

    private int handleInput() {
        if (gameKeys.isPressed(gameKeys.DOWN)) {
            return 1;
        }
        else if (gameKeys.isPressed(gameKeys.UP)) {
            return -1;
        }
        else if (gameKeys.isPressed(gameKeys.LEFT)) {
            if (tankNo == 0) tankNo = no_of_tanks-1;
            else tankNo--;
        }
        else if (gameKeys.isPressed(gameKeys.RIGHT)) {
            if (tankNo == no_of_tanks-1) tankNo = 0;
            else tankNo++;
        }
        return 0;
    }

    private void chooseTank() {

    }

    public String getTankName() {
        return tanks[tankNo].getName();
    }

}
