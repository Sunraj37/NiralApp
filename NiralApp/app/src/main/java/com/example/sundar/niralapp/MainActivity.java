package com.example.sundar.niralapp;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
public class MainActivity extends Activity {
    ListView lstCar;
    ArrayList<Question> arrCar = new ArrayList<Question>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstCar = (ListView) findViewById(R.id.listView);
        for (int i = 0; i <= 20; i++) {
            Question c = new Question();
            c.question = "What is Android" + i;
            c.tags = "Android";
            c.time = "11:0" + i;
            arrCar.add(c);
        }
        CustomAdapter cadapter = new CustomAdapter();
        lstCar.setAdapter(cadapter);
    }
    class CustomAdapter extends BaseAdapter {
        LayoutInflater Inflater;
        public CustomAdapter() {
            // TODO Auto-generated constructor stub
            Inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return arrCar.size();
        }
        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return arrCar.get(position);
        }
        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            convertView = Inflater.inflate(R.layout.layout1, null);
            TextView lblCarName = (TextView) convertView
                    .findViewById(R.id.textView);
            TextView lblCarBrand = (TextView) convertView
                    .findViewById(R.id.textView2);
            TextView lblCarModel = (TextView) convertView
                    .findViewById(R.id.textView3);
            Question c = arrCar.get(position);
            lblCarName.setText(c.question);
            lblCarBrand.setText(c.tags);
            lblCarModel.setText(c.time);
            return convertView;
        }

    }
}