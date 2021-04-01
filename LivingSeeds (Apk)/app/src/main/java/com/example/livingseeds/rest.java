package com.example.livingseeds;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class rest extends AppCompatActivity {

    private String TAG = rest.class.getSimpleName();

    private ProgressDialog pDialog;
    private ListView lv;

    // URL to get contacts JSON
    private static String url = "https://rest.soilgrids.org/query?lon=74.47&lat=16.68";

    ArrayList<HashMap<String, String>> contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest
        );

        /*contactList = new ArrayList<>();

        lv = (ListView) findViewById(R.id.list);*/

        new GetContacts().execute();
    }

    /**
     * Async task class to get json by making HTTP call
     */
    private class GetContacts extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(rest.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @SuppressLint("WrongThread")
        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url);

            Log.e(TAG, "Response from url: " + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array node
                    JSONObject c=jsonObj.getJSONObject("properties");



                    JSONObject bd=c.getJSONObject("BDRICM");
                    JSONObject m=bd.getJSONObject("M");
                    String bd_m=m.getString("BDRICM_M");
                    /*TextView t1=(TextView)findViewById(R.id.name);
                    t1.setText(bd_m);*/


                    JSONObject bld=c.getJSONObject("BLDFIE");
                    JSONObject mbld=bld.getJSONObject("M");
                    String bldl=mbld.getString("sl4");

                    JSONObject cecsol=c.getJSONObject("CECSOL");
                    JSONObject mcec=cecsol.getJSONObject("M");
                    String cec=mcec.getString("sl4");

                    JSONObject clyppt=c.getJSONObject("CLYPPT");
                    JSONObject mcly=clyppt.getJSONObject("M");
                    String cly=mcly.getString("sl4");

                    JSONObject ocstha=c.getJSONObject("OCSTHA");
                    JSONObject mocs=ocstha.getJSONObject("M");
                    String ocs=mocs.getString("sd4");

                    JSONObject orcdrc=c.getJSONObject("ORCDRC");
                    JSONObject morc=orcdrc.getJSONObject("M");
                    String orc=morc.getString("sl4");

                    JSONObject phihox=c.getJSONObject("PHIHOX");
                    JSONObject mphi=phihox.getJSONObject("M");
                    String phi=mphi.getString("sl4");

                    JSONObject phikcl=c.getJSONObject("PHIKCL");
                    JSONObject mphikcl=phikcl.getJSONObject("M");
                    String phik=mphikcl.getString("sl4");

                    JSONObject sltppt=c.getJSONObject("SLTPPT");
                    JSONObject mslt=sltppt.getJSONObject("M");
                    String slt=mslt.getString("sl4");

                    JSONObject sndppt=c.getJSONObject("SNDPPT");
                    JSONObject msnd=sndppt.getJSONObject("M");
                    String snd=msnd.getString("sl4");

                    JSONObject texmht=c.getJSONObject("TEXMHT");
                    JSONObject mtex=texmht.getJSONObject("M");
                    String tex=mtex.getString("sl4");


                    TextView tt1=(TextView)findViewById(R.id.name);
                    tt1.setText(bd_m);
                    TextView tt2=(TextView)findViewById(R.id.email);
                    tt2.setText(bldl);
                    TextView tt3=(TextView)findViewById(R.id.mobile);
                    tt3.setText(cec);
                    TextView tt4=(TextView)findViewById(R.id.x1);
                    tt4.setText(cly);
                    TextView tt5=(TextView)findViewById(R.id.x2);
                    tt5.setText(ocs);
                    TextView tt6=(TextView)findViewById(R.id.orc);
                    tt6.setText(orc);
                    TextView tt7=(TextView)findViewById(R.id.phihox);
                    tt7.setText(phi);
                    TextView tt9=(TextView)findViewById(R.id.phikcl);
                    tt9.setText(phik);
                    TextView tt10=(TextView)findViewById(R.id.sltppt);
                    tt10.setText(slt);
                    TextView tt8=(TextView)findViewById(R.id.sndppt);
                    tt8.setText(snd);
                    TextView tt11=(TextView)findViewById(R.id.texmht);
                    tt11.setText(tex);


                    JSONObject taxnwrb=c.getJSONObject("TAXNWRB");
                    String hep=taxnwrb.getString("Haplic Vertisols");
                    String soil_class="Haplic Vertisols";
                    if(hep!=null){
                        TextView tt12=(TextView)findViewById(R.id.textView3);
                        tt12.setText(soil_class);
                    }


                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG)
                                    .show();
                        }

                    });

                }
            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });

            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
            /**
             * Updating parsed JSON data into ListView
             * */
            /*ListAdapter adapter = new SimpleAdapter(
                    MainActivity.this, contactList,
                    R.layout.list_item, new String[]{"BDRICM_M","BLDFIE","CECSOL","CLYPPT","OCSTHA","ORCDRC","PHIHOX","PHIKCL","SLTPPT","SNDPPT","TEXMHT"}, new int[]{R.id.name,R.id.email,R.id.mobile,R.id.x1,R.id.x2,R.id.orc,R.id.phihox,R.id.phikcl,R.id.sltppt,R.id.sndppt,R.id.texmht});

            lv.setAdapter(adapter);*/


        }

    }

}
