package com.examples.avptest;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

/**
*/
public class AVPtest extends Activity implements OnClickListener {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main);
		
		View getlocButton = findViewById(R.id.getloc_button);
		getlocButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.getloc_button:
			Intent i = new Intent(this, GetLocation.class);
			startActivity(i);
			break;
		// More buttons
		}
	}

}
