package xiangxiao.asynctaskdemo;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;

public class ProgressBarTest extends AppCompatActivity {
    private ProgressBar progressBar;
    private MyAsyncTask task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar_test);
        progressBar = (ProgressBar)findViewById(R.id.progressBar2);
        task = new MyAsyncTask();
        task.execute();
    }

    class MyAsyncTask extends AsyncTask<Void, Integer, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            for (int i = 0; i < 100; i++) {
                publishProgress(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            finish();
        }
    }
}
