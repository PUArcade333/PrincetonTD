package cos333.Project;

import towers.*;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;
import android.widget.Scroller;

public class GameBoardView extends SurfaceView implements 
OnTouchListener, SurfaceHolder.Callback {

	/*
	 * Tag used for LogCat
	 */
	private static final String TAG = "GameBoardView";

	private SurfaceHolder surfaceHolder;

	public Context context;

	/*
	 * Reference to the thread which controls graphics/game control
	 *  Will communicate to View through use of Handlers
	 */
	private GameThread gameThread;

	public GameBoardView(Context context)  {
		super(context);
		this.context = context;
		setFocusable(true);
		setFocusableInTouchMode(true);
		this.setOnTouchListener(this);
	}

	public GameBoardView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		this.context = context;
		setFocusable(true);
		setFocusableInTouchMode(true);
		this.setOnTouchListener(this);
	}

	public GameBoardView(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;
		setFocusable(true);
		setFocusableInTouchMode(true);
		this.setOnTouchListener(this);
	}

	@Override
	public void onSizeChanged(int w, int h, int oldw, int oldh) {
		Log.d(TAG, "width=" + w + " height=" + h);
		SurfaceHolder holder = getHolder();
		holder.addCallback(this);

		gameThread = new GameThread(holder, w, h, context);

		super.onSizeChanged(w, h, oldw, oldh);
	}

	public void onClick(View v) {
		if (v.getId() == R.id.button1)
		{
			gameThread.setActiveTower(new TowerArcher());
		}
		else if (v.getId() == R.id.button2)
		{
			gameThread.setActiveTower(new TowerCanon());
		}
		else if (v.getId() == R.id.button3)
		{
			gameThread.setActiveTower(new TowerAA());
		}
		else if (v.getId() == R.id.button4)
		{
			gameThread.setActiveTower(new TowerIce());
		}
		else if (v.getId() == R.id.button5)
		{
			gameThread.setActiveTower(new TowerElectric());
		}
		else if (v.getId() == R.id.button6)
		{
			gameThread.setActiveTower(new TowerFire());
		}
		else if (v.getId() == R.id.button7)
		{
			gameThread.setActiveTower(new TowerAir());
		}
		else if (v.getId() == R.id.button8)
		{
			gameThread.setActiveTower(new TowerEarth());
		}
	}

	public boolean onTouch(View view, MotionEvent event) {
		gameThread.onTouch(event);
		return true;
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(event.getKeyCode() == KeyEvent.KEYCODE_ENTER){
			return gameThread.doOnKeyDown(keyCode, event);
		}
		else{
			return super.onKeyDown(keyCode, event);
		}

	}

	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

	}

	public void surfaceCreated(SurfaceHolder holder) {
		gameThread.setRunning(true);
		gameThread.start();
	}

	public void accelertatorShaken() {
		gameThread.acceleratorShaken();
	}

	public void surfaceDestroyed(SurfaceHolder holder) {
		boolean retry = true;
		gameThread.setRunning(false);
		while (retry) {
			try {
				gameThread.join();
				retry = false;
			} catch (InterruptedException e) {
			}
		}
	}

	public SurfaceHolder getSurfaceHolder() {
		return surfaceHolder;
	}

}
