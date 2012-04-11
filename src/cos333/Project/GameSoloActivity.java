package cos333.Project;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class GameSoloActivity extends Activity implements OnClickListener {
	
	private GameBoardView gbv;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initWindow();

		setContentView(R.layout.main);
		gbv = (GameBoardView)findViewById(R.id.surfaceView1);
		gbv.requestFocusFromTouch();

		// Tower buttons
		final ImageButton arrow = (ImageButton)findViewById(R.id.button1);
		final ImageButton canon = (ImageButton)findViewById(R.id.button2);
		final ImageButton aa = (ImageButton)findViewById(R.id.button3);
		final ImageButton ice = (ImageButton)findViewById(R.id.button4);
		final ImageButton elect = (ImageButton)findViewById(R.id.button5);
		final ImageButton fire = (ImageButton)findViewById(R.id.button6);
		final ImageButton air = (ImageButton)findViewById(R.id.button7);
		final ImageButton earth = (ImageButton)findViewById(R.id.button8);
		arrow.setOnClickListener(this);
		canon.setOnClickListener(this);
		aa.setOnClickListener(this);
		ice.setOnClickListener(this);
		elect.setOnClickListener(this);
		fire.setOnClickListener(this);
		air.setOnClickListener(this);
		earth.setOnClickListener(this);
	}

	@Override
	protected void onPause() {
		super.onPause();
	}


	private void initWindow() {
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
	}

	public void onClick(View v) {
		gbv.onClick(v);
	}

}
