package matcom.dcf.com.mytestapp;

import android.app.Instrumentation;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.UiThreadTest;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)
public class MainActivityTest extends
        ActivityInstrumentationTestCase2<MainActivity> {

    MainActivity ma;
    Instrumentation instr;


    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();

        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        setActivityInitialTouchMode(false);

         ma = getActivity();

    }


    @Test
     public void keyEvents() throws Throwable {
        TextView tv = (TextView) ma.findViewById(R.id.editText);
        TextView tva = (TextView) ma.findViewById(R.id.editText2);
        //tv.requestFocus();
        sendKeys("2 4 TAB");
        sendKeys("6 6 ");
        String entry = tv.getText().toString();
        String entrya = tva.getText().toString();
        //
       Log.i("Tests", "Testdf  ====" + entry + " = " + entrya);

        ma.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Log.i("Tests", "Testdf 1  ====");
                Button calc = (Button) ma.findViewById(R.id.calculate);
                calc.performClick();
                Log.i("Tests", "Testdf 2  ====");

            }
        });


    }

    @Test
    public void testAddition() {
        TextView tv = (TextView) ma.findViewById(R.id.editText);
        String res = tv.getText().toString();
        Assert.assertEquals("Result should be ***", "***", res);

    }

}