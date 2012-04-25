package cos333.Project;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class PrincetonTD extends Activity implements OnClickListener {
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // set layout
        initWindow();
        setContentView(R.layout.menu);
        
        // set click listeners
        Button solo = (Button)findViewById(R.id.solo);
        solo.setOnClickListener(this);
        Button multi = (Button)findViewById(R.id.multi);
        multi.setOnClickListener(this);
    }
	
	private void initWindow() {
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
	}

	public void onClick(View arg0) {
		if (arg0.getId() == R.id.solo) {
			Intent newGame = new Intent(this, GameSoloActivity.class);
            startActivityForResult(newGame, 0);
		}
		else if (arg0.getId() == R.id.multi) {
			// not implemented
			finish();
		}
	}
	
	protected void onActivityResult(int requestCode, int resultCode,
            Intent data) {
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
            	TextView score = (TextView)findViewById(R.id.score);
            	score.setText(data.getStringExtra("SCORE"));
            }
        }
    }

}
