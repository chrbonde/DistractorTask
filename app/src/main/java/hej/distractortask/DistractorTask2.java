package hej.distractortask;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;

public class DistractorTask2 extends AppCompatActivity {

    Random rand;
    //ImageView randomArrow;
    Button randomBtnUp;
    Button randomBtnDown;
    int btnUp = 1;
    int btnDown = 0;

    public  static final int PERMISSIONS_MULTIPLE_REQUEST = 123;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distractor_task2);
        checkPermission();
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        long[] patternUp ={0, 100, 200, 100, 150 , 100 , 100 , 100 ,50, 100, 0, 100};
        long[] patternDown ={0, 100, 0, 100, 50 , 100 , 100 , 100 ,150, 100, 200, 100};
        final long[][] randomVibration = {patternDown,patternUp};
        //v.vibrate (randomVibration[rand.nextInt(randomVibration.length)], -1);

        /*randomBtnUp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {


                try {writeLog(btnUp);
                }
                catch (Exception ex)
                {
                    // TODO Auto-generated catch block
                    ex.printStackTrace();
                }
                int vibrationNum = rand.nextInt(randomVibration.length);

                try {writeLog(vibrationNum);
                }
                catch (Exception e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                var randomVib = randomVibration[vibrationNum];
                v.vibrate (randomVibration[vibrationNum], -1);
            }
        });

        randomBtnDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                try {writeLog(btnDown);
                }
                catch (Exception ex)
                {
                    // TODO Auto-generated catch block
                    ex.printStackTrace();
                }
                int arrowNum = rand.nextInt(images.length);
                try {writeLog(arrowNum);
                }
                catch (Exception e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                randomArrow.setImageResource(images[arrowNum]);
            }
        }); */

    }



    private void checkPermission() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) + ContextCompat
                .checkSelfPermission(this,
                        Manifest.permission.VIBRATE)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale
                    (this, Manifest.permission.WRITE_EXTERNAL_STORAGE) ||
                    ActivityCompat.shouldShowRequestPermissionRationale
                            (this, Manifest.permission.VIBRATE)) {
            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.VIBRATE}, PERMISSIONS_MULTIPLE_REQUEST);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }
    }

    public void writeLog (Integer arrowStr) throws Exception{
        File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File LogFile = new File(path, "arrowlog.txt");
        final FileWriter LogWriter = new FileWriter(LogFile, true);
        //LogWriter.write("");
        LogWriter.write(arrowStr.toString());
        LogWriter.write(",");
        LogWriter.close();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        if (requestCode == PERMISSIONS_MULTIPLE_REQUEST) {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                // permission was granted, yay! Do the
                // contacts-related task you need to do.

            } else {

                // permission denied, boo! Disable the
                // functionality that depends on this permission.
            }
            return;

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }
}
