package es.iesoretania.dam2.hlc;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Ut2_b01_03 extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture image;
	private TextureRegion reposo, reposoIzquierda, reposoDerecha;
	private TextureRegion reposoArriba, reposoArribaIzquierda, reposoArribaDerecha;
	private TextureRegion reposoAbajo, reposoAbajoIzquierda, reposoAbajoDerecha;
	private Sprite nave;

	@Override
	public void create() {
		batch = new SpriteBatch();
		image = new Texture(Gdx.files.internal("spacetheme.png"));
		reposo = new TextureRegion(image, 42, 0, 39, 43);
		reposoIzquierda = new TextureRegion(image, 0, 0, 39, 43);
		reposoDerecha = new TextureRegion(image, 84, 0, 39, 43);
		reposoArriba = new TextureRegion(image, 42, 43, 39, 43);
		reposoArribaIzquierda = new TextureRegion(image, 0, 43, 39, 43);
		reposoArribaDerecha = new TextureRegion(image, 84, 43,39, 43);
		reposoAbajo = new TextureRegion(image, 42, 86, 39, 43);
		reposoAbajoIzquierda = new TextureRegion(image, 0, 86, 39, 43);
		reposoAbajoDerecha = new TextureRegion(image, 84, 86, 39, 43);

		nave = new Sprite();

		nave.setX(320 - reposo.getRegionWidth() / 2.0f);
		nave.setY(240 - reposo.getRegionHeight() / 2.0f);
		nave.setSize(39, 43);
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0f, 0f, 0.2f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		nave.setRegion(reposo);

		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			nave.translateX(- 400 * Gdx.graphics.getDeltaTime());
			nave.setRegion(reposoIzquierda);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			nave.translateX(400 * Gdx.graphics.getDeltaTime());
			nave.setRegion(reposoDerecha);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
			nave.translateY(- 400 * Gdx.graphics.getDeltaTime());
			nave.setRegion(reposoArriba);
			if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
				nave.setRegion(reposoArribaIzquierda);
			} else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
				nave.setRegion(reposoArribaDerecha);
			}
		} else if (Gdx.input.isKeyPressed(Input.Keys.UP)){
			nave.translateY(400 * Gdx.graphics.getDeltaTime());
			nave.setRegion(reposoAbajo);
			if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
				nave.setRegion(reposoAbajoIzquierda);
			} else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
				nave.setRegion(reposoAbajoDerecha);
			}
		}

		if (nave.getX() < 0) {
			nave.setX(0);
		}
		if (nave.getY() < 0) {
			nave.setY(0);
		}
		if (nave.getX() > 640 - nave.getWidth()) {
			nave.setX(640 - nave.getHeight());
		}
		if (nave.getY() > 480 - nave.getWidth()) {
			nave.setY(480 - nave.getWidth());
		}

		batch.begin();
		nave.draw(batch);
		batch.end();
	}

	@Override
	public void dispose() {
		batch.dispose();
		image.dispose();
	}
}