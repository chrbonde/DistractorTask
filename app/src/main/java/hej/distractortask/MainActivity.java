package hej.distractortask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import java.io.File;
import java.io.FileWriter;
import java.util.Date;

public class MainActivity extends Activity implements View.OnClickListener {
    public Button button2;
    public Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);
        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        /*Date timeStamp = new Date();
        String timeStr = timeStamp.toString();
        try {
            writeLog(timeStr);
            writeLogHap(timeStr);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
    }

    @Override
    public void onResume() {
        super.onResume();  // Always call the superclass method first
        Date timeStamp = new Date();
        String timeStr = timeStamp.toString();
        try {
            writeLog(timeStr);
            writeLogHap(timeStr);
        } catch (Exception ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }
    }

    private void writeLog (String time) throws Exception{
        File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File LogFile = new File(path, "arrowlog.txt");
        final FileWriter LogWriter = new FileWriter(LogFile, true);
        //LogWriter.write("Timestamp: ");
        LogWriter.write(time);
        LogWriter.write(", ");
        LogWriter.close();
    }

    private void writeLogHap (String timez) throws Exception{
        File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File LogFile = new File(path, "hapticlog.txt");
        final FileWriter LogWriter = new FileWriter(LogFile, true);
        //LogWriter.write("Timestamp: ");
        LogWriter.write(timez);
        LogWriter.write(", ");
        LogWriter.close();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button2:
                Date timeStamp = new Date();
                String timeStr = timeStamp.toString();
                try {
                    writeLog(timeStr);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                Intent start = new Intent(MainActivity.this, DistractorTask.class);
                startActivity(start);
                break;
            case R.id.button3:
                Date timeStamp2 = new Date();
                String timeStr2 = timeStamp2.toString();
                try {
                    writeLog(timeStr2);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                Intent start2 = new Intent(MainActivity.this, DistractorTask2.class);
                startActivity(start2);
                break;
        }
    }
}
