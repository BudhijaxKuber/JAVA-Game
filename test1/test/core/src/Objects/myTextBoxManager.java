package Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class myTextBoxManager {

    private SpriteBatch sb;

    private GlyphLayout layout;

    private BitmapFont font;

    private FreeTypeFontGenerator gen;

    private FreeTypeFontGenerator.FreeTypeFontParameter parameter;

    private myShapeRenderer sr;

    float font_width;

    public myTextBoxManager(String fontPath) {

        sb = new SpriteBatch();

        layout = new GlyphLayout();

        font = new BitmapFont();

        gen = new FreeTypeFontGenerator(Gdx.files.internal("Exo-VariableFont_wght.ttf"));

        parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

        sr = new myShapeRenderer();

    }

    public void setTextBox(int center_x, int y, int padding, int margin, int borderWidth, int fontSize, String[] items,
                           int currentItem, Color col1, Color col2, Color col3) {

        parameter.size = fontSize;
        parameter.color = col1;
        parameter.spaceX = 3;
        parameter.borderWidth=borderWidth;
        parameter.borderColor = col1;

        font = gen.generateFont(parameter);

        font_width=0;

        int len = items.length;

        for (int i=0;i<len;i++) {
            layout.setText(font,items[i]);
            if (font_width< layout.width) font_width= layout.width;
        }

        // Text Box

        for (int i=0;i<len;i++) {

            if (i==0) {
                sr.roundedRect(center_x - font_width / 2 - padding,
                        y - layout.height - padding,
                        font_width + 2 * padding,
                        layout.height + 2 * padding,
                        10,
                        col3
                );
            }
            else {
                sr.roundedRect(center_x - font_width / 2 - padding,
                        y - margin*i - layout.height*(i+1) - padding,
                        font_width + 2 * padding,
                        layout.height + 2 * padding,
                        10,
                        col3
                );
            }
        }

        // TEXT

        sb.begin();

        for (int i=0;i<len;i++) {

            layout.setText(font,items[i]);

            if (currentItem==i) font.setColor(col2);
            else font.setColor(col1);

            if (i==0) {
                font.draw(sb,
                        items[i],
                        center_x - layout.width/2,
                        y
                );
            }
            else {
                font.draw(sb,
                        items[i],
                        center_x - layout.width/2,
                        y - (layout.height + margin)*i
                );
            }

        }

        sb.end();

    }

    public void setBackBox(String back, float x, float y, float width, float radius, float padding,
                           float padding2, boolean b, Color col1, Color col2, Color col3) {

        // Drawing Background Shape
        if (b) sr.halfRoundedRect(x,y,width,radius,padding2,col1,col2);
        else sr.halfRoundedRect(x,y,width,radius, padding,col1,col2);

        // Drawing Text
        if (b) parameter.size=(int)(radius+2*padding)*2;
        else parameter.size = (int)(radius+2*padding2)*2;
        parameter.color = col3;
        parameter.spaceX = 3;
        parameter.borderWidth=3;
        parameter.borderColor = col3;

        font = gen.generateFont(parameter);

        layout.setText(font, back);

        sb.begin();
        font.draw(sb,
                back,
                x + width - layout.width/2,
                y + layout.height/2 + radius
        );
        sb.end();

    }

}
