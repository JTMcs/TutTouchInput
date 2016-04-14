
//http://www.gamefromscratch.com/page/LibGDX-Video-Tutorial-Series.aspx
package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter implements InputProcessor {
    SpriteBatch sbPic;
    Texture txtrPic;
    Sprite sprPic;
    boolean isMoveR = false, isMoveL = false, isMoveU = false, isMoveD = false;

    @Override
    public void create() {
        sbPic = new SpriteBatch();
        txtrPic = new Texture("badlogic.jpg");
        sprPic = new Sprite(txtrPic);
        sprPic.setPosition(Gdx.graphics.getWidth() / 2 - txtrPic.getWidth() / 2,
                Gdx.graphics.getHeight() / 2 - txtrPic.getHeight() / 2);

        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render() {
        if (isMoveR) {
            sprPic.translateX(5f);
        }
        if (isMoveL) {
            sprPic.translateX(-5f);
        }
        if (isMoveU) {
            sprPic.translateY(5f);
        }
        if (isMoveD) {
            sprPic.translateY(-5f);
        }
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        sbPic.begin();
        sbPic.draw(sprPic, sprPic.getX(), sprPic.getY());
        sbPic.end();
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.RIGHT) {
            isMoveR = true;
        }
        if (keycode == Input.Keys.LEFT) {
            isMoveL = true;
        }
        if (keycode == Input.Keys.UP) {
            isMoveU = true;
        }
        if (keycode == Input.Keys.DOWN) {
            isMoveD = true;
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.RIGHT) {
            isMoveR = false;
        }
        if (keycode == Input.Keys.LEFT) {
            isMoveL = false;
        }
        if (keycode == Input.Keys.UP) {
            isMoveU = false;
        }
        if (keycode == Input.Keys.DOWN) {
            isMoveD = false;
        }
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
