package com.example.tbrams.rtkreview;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    public static final int FIRST_LESSON = 1;
    private static int[][] toc = new int[60][2];
    private static final String LOGTAG = "RTK Main";
    private SeekBar seekBar;
    private TextView textView, textNumber;
    private int progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeVariables();

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                progress = progresValue;
                updateNumberOfKanjis();

                //                Toast.makeText(getApplicationContext(), "Changing seekbar's progress", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            //    Toast.makeText(getApplicationContext(), "Started tracking seekbar", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                updateNumberOfKanjis();
//                Toast.makeText(getApplicationContext(), "Stopped tracking seekbar", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void reviewLesson3(View view) {
        int lesson=seekBar.getProgress()+ FIRST_LESSON;
        String fromKanji =  Integer.toString(toc[lesson][0]);
        String toKanji = Integer.toString(toc[lesson][1]);
        String url="http://kanji.koohii.com/review/free?from="+fromKanji+"&to="+toKanji;

        if (isOnline()) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        } else {
            Toast.makeText(this, "This app requires network access!", Toast.LENGTH_LONG).show();
        }

    }

     // A private method to help us initialize our variables.
    private void initializeVariables() {
        seekBar = (SeekBar) findViewById(R.id.seekBar1);
        textView  = (TextView) findViewById(R.id.textView);
        textNumber  = (TextView) findViewById(R.id.textNumber);

        progress=0;
        seekBar.setMax(57);

        InitializeTOC();
        updateNumberOfKanjis();

    }

    protected boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        } else {
            return false;
        }
    }

    private void updateNumberOfKanjis() {
        int antal = toc[progress+FIRST_LESSON][1]-toc[progress+FIRST_LESSON][0];
        textNumber.setText(Integer.toString(antal)+" cards");
        String message="";
        if (progress+FIRST_LESSON==57)
            message="RTK Vol. 3";
        else if (progress+FIRST_LESSON==58)
            message="RTK Suppl.";
        else
            message="Lesson: " + (progress+FIRST_LESSON);

        textView.setText(message);
    }

    private void InitializeTOC() {
        toc[1][0] =  1;  toc[1][1] = 15;
        toc[2][0] = 16;  toc[2][1] = 34;
        toc[3][0] = 35;  toc[3][1] = 52;
        toc[4][0] = 53;  toc[4][1] = 70;
        toc[5][0] = 71;  toc[5][1] = 94;
        toc[6][0] = 95;  toc[6][1] =104;
        toc[7][0] =105;  toc[7][1] =126;
        toc[8][0] =127;  toc[8][1] =172;
        toc[9][0] =173;  toc[9][1] =194;
        toc[10][0]=195;  toc[10][1]=234;
        toc[11][0]=235;  toc[11][1]=249;
        toc[12][0]=250;  toc[12][1]=276;
        toc[13][0]=277;  toc[13][1]=299;
        toc[14][0]=300;  toc[14][1]=323;
        toc[15][0]=324;  toc[15][1]=352;
        toc[16][0]=353;  toc[16][1]=369;
        toc[17][0]=370;  toc[17][1]=395;
        toc[18][0]=396;  toc[18][1]=475;
        toc[19][0]=476;  toc[19][1]=508;
        toc[20][0]=509;  toc[20][1]=514;
        toc[21][0]=515;  toc[21][1]=577;
        toc[22][0]=578;  toc[22][1]=636;
        toc[23][0]=637;  toc[23][1]=766;
        toc[24][0]=767;  toc[24][1]=795;
        toc[25][0]=796;  toc[25][1]=891;
        toc[26][0]=892;  toc[26][1]=950;
        toc[27][0]=951;  toc[27][1]=1026;
        toc[28][0]=1027; toc[28][1]=1044;
        toc[29][0]=1045; toc[29][1]=1085;
        toc[30][0]=1086; toc[30][1]=1124;
        toc[31][0]=1125; toc[31][1]=1183;
        toc[32][0]=1184; toc[32][1]=1219;
        toc[33][0]=1220; toc[33][1]=1247;
        toc[34][0]=1248; toc[34][1]=1293;
        toc[35][0]=1294; toc[35][1]=1332;
        toc[36][0]=1333; toc[36][1]=1394;
        toc[37][0]=1395; toc[37][1]=1426;
        toc[38][0]=1427; toc[38][1]=1483;
        toc[39][0]=1484; toc[39][1]=1530;
        toc[40][0]=1531; toc[40][1]=1586;
        toc[41][0]=1587; toc[41][1]=1615;
        toc[42][0]=1616; toc[42][1]=1647;
        toc[43][0]=1648; toc[43][1]=1681;
        toc[44][0]=1682; toc[44][1]=1709;
        toc[45][0]=1710; toc[45][1]=1756;
        toc[46][0]=1757; toc[46][1]=1775;
        toc[47][0]=1776; toc[47][1]=1805;
        toc[48][0]=1806; toc[48][1]=1827;
        toc[49][0]=1828; toc[49][1]=1852;
        toc[50][0]=1853; toc[50][1]=1879;
        toc[51][0]=1880; toc[51][1]=1903;
        toc[52][0]=1904; toc[52][1]=1926;
        toc[53][0]=1927; toc[53][1]=1977;
        toc[54][0]=1978; toc[54][1]=2005;
        toc[55][0]=2006; toc[55][1]=2025;
        toc[56][0]=2026; toc[56][1]=2042;
        toc[57][0]=2043; toc[57][1]=3007;
        toc[58][0]=3008; toc[58][1]=3030;
    }

}
