package my.project.bottompopupmenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private Button btnTest;
	private SelectPicPopupWindow menuWindow;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnTest = (Button) findViewById(R.id.btn_test);
		btnTest.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_test:
			menuWindow = new SelectPicPopupWindow(this);
			menuWindow.setOnInnerItemClickListener(this);
			menuWindow.showAtLocation(findViewById(R.id.main), Gravity.BOTTOM
					| Gravity.CENTER_HORIZONTAL, 0, 0);
			break;
		case R.id.btn_menu_1:
			showToastAndHidePopDown("Menu 1 clicked!");
			break;
		case R.id.btn_menu_2:
			showToastAndHidePopDown("Menu 2 clicked!");
			break;
		case R.id.btn_menu_3:
			showToastAndHidePopDown("Menu 3 clicked!");
			break;
		default:
			break;
		}
	}

	private void showToastAndHidePopDown(String text) {
		Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
		menuWindow.dismiss();
	}

}
