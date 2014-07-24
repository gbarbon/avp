package com.examples.avptest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

public class GetLocation extends Activity {

	private LocationManager locationManager;
	String filename = "testfile";
	String str = "Not confidential data";
	FileOutputStream outputStream;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0,
				0, new LocationUpdateHandler());

		setContentView(R.layout.getloc);
	}

	public class LocationUpdateHandler implements LocationListener {

		@Override
		public void onLocationChanged(Location loc)  {
			int lat = (int) (loc.getLatitude() * 1E6);
			int lng = (int) (loc.getLongitude() * 1E6);
			
			TextView myLocationText = (TextView) findViewById(R.id.getloc_content);
			myLocationText.setText("Latitude: " + lat + "\n" + "Longitude: "
					+ lng);
			
			System.out.println("Ciao");
			

			try {
				outputStream = openFileOutput("testfile2", Context.MODE_PRIVATE);
				outputStream.write(str.getBytes());
				outputStream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			
		}

		@Override
		public void onProviderDisabled(String provider) {
		}

		@Override
		public void onProviderEnabled(String provider) {
		}

		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
		}
	}
}
