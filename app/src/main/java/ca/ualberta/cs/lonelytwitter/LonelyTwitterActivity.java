package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LonelyTwitterActivity extends Activity implements MyObserver {

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	private ArrayList<Tweet> tweets;
	private ArrayAdapter<Tweet> adapter;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState); // View
		setContentView(R.layout.main); // View

		bodyText = (EditText) findViewById(R.id.body); // View
		Button saveButton = (Button) findViewById(R.id.save); // controller
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList); // model

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK); // View
				String text = bodyText.getText().toString(); // move to controller
				tweets.add(new NormalTweet(text)); // move to controller
				saveInFile(); // move to model
				adapter.notifyDataSetChanged(); // View
			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart(); //view
		loadFromFile(); // model
		adapter = new ArrayAdapter<Tweet>(this, R.layout.list_item, tweets); //view
		oldTweetsList.setAdapter(adapter); //view
	}

	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME); //model
			BufferedReader in = new BufferedReader(new InputStreamReader(fis)); //model
			Gson gson = new Gson(); // model
			// Following line based on https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html
			Type listType = new TypeToken<ArrayList<NormalTweet>>() {}.getType(); //model
			tweets = gson.fromJson(in, listType); //model

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			tweets = new ArrayList<Tweet>(); // model
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e); //view
		}
	}
	
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME, 0); //model
			OutputStreamWriter writer = new OutputStreamWriter(fos); //model
			Gson gson = new Gson();//model
			gson.toJson(tweets, writer); //model
			writer.flush();//model
			fos.close();//model
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e); //view
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);//view
		}
	}

	public void myNotify(MyObservable observable) {
		adapter.notifyDataSetChanged(); //view
	}
}