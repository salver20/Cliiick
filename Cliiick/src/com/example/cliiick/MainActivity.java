package com.example.cliiick;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		Display display = getWindowManager().getDefaultDisplay();
		int width = display.getWidth();
		int height = display.getHeight();

		Pagewidget pageWidget = new Pagewidget(this);
		pageWidget.SetScreen(width, height);

		BitmapFactory.Options options = new BitmapFactory.Options();
		options.inPreferredConfig = Bitmap.Config.ARGB_8888;
		options.inPurgeable = true;// 允许可清除
		options.inInputShareable = true;// 以上options的两个属性必须联合使用才会有效果

		InputStream is = this.getResources().openRawResource(R.drawable.click1);

		Bitmap bm1 = BitmapFactory.decodeStream(is, null, options);
		Bitmap foreImage = Bitmap.createScaledBitmap(bm1, width, height, false);
		pageWidget.setForeImage(foreImage);
		bm1.recycle();

		is = this.getResources().openRawResource(R.drawable.click2);
		Bitmap bm2 = BitmapFactory.decodeStream(is,null,options);
		Bitmap bgImage = Bitmap.createScaledBitmap(bm2, width, height, false);
		pageWidget.setBgImage(bgImage);
		bm2.recycle();
        
		try {
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setContentView(pageWidget);

		super.onCreate(savedInstanceState);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
