package hej.distractortask;
import android.Manifest;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class DistractorTask extends AppCompatActivity {
    Random rand;
    ImageView randomArrow;
    Button randomBtnUp;
    Button randomBtnDown;
    int btnUp = 1;
    int btnDown = 0;
    static final Integer MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL = 1;


    Integer[] images = {
            R.drawable.arrow_down,
            R.drawable.arrow_up
    };

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distractor_task);

        randomArrow = (ImageView) findViewById(R.id.randomArrow);
        randomBtnUp = (Button) findViewById(R.id.randomBtnUp);
        randomBtnDown = (Button) findViewById(R.id.randomBtnDown);
        rand = new Random();
        int startArrow = rand.nextInt(images.length);
        randomArrow.setImageResource(images[startArrow]);
        try {writeLog(startArrow);
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }

        randomBtnUp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {


                try {writeLog(btnUp);
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
        });
    }

    public void writeLog (Integer arrowStr) throws Exception{
        File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File LogFile = new File(path, "arrowlog.txt");
        //SimpleDateFormat format= new SimpleDateFormat("mm:ss:SSSS", Locale.getDefault());
        //String myDate = format.format(new Date());
        long time = System.currentTimeMillis();
        String timeStamp = Long.toString(time);
        final FileWriter LogWriter = new FileWriter(LogFile, true);
            //LogWriter.write(myDate);
            LogWriter.write(timeStamp);
            LogWriter.write("; ");
            LogWriter.write(arrowStr.toString());
            LogWriter.write(",");
            LogWriter.close();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        if (requestCode == MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL) {
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

    @Override
    public Resources getResources() {
        return super.getResources();
    }
}
