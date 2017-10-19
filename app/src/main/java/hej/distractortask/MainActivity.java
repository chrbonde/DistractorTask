package hej.distractortask;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import java.io.File;
import java.io.FileWriter;
import java.util.Date;

import static hej.distractortask.R.id.button2;
import static hej.distractortask.R.id.time;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        init();

        Date timeStamp = new Date();
        String timeStr = timeStamp.toString();
        try {
            writeLog(timeStr);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void onResume() {
        super.onResume();  // Always call the superclass method first
        Date timeStamp = new Date();
        String timeStr = timeStamp.toString();
        try {
            writeLog(timeStr);
        } catch (Exception ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }
    }

    public void writeLog (String time) throws Exception{
        File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File LogFile = new File(path, "arrowlog.txt");
        final FileWriter LogWriter = new FileWriter(LogFile, true);
        //LogWriter.write("Timestamp: ");
        LogWriter.write(time);
        LogWriter.write(", ");
        LogWriter.close();
    }

        public Button button2;

        public void init(){
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent start = new Intent(MainActivity.this, DistractorTask.class);
                startActivity(start);
            }
        });
    }

}
