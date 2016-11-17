package com.aqy.matingting.myapplication.toolbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.aqy.matingting.myapplication.R;

public class ToolBarActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ImageView self_share;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_bar);
        toolbar= (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setLogo(R.mipmap.ic_launcher);


        setSupportActionBar(toolbar);
        self_share= (ImageView) findViewById(R.id.self_share);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        self_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("selfShare");
            }
        });


//        toolbar.setTitle("ToolBar");
//        toolbar.setSubtitle("toolbar");
////        toolbar.setNavigationIcon(R.drawable.back);
//        toolbar.setOnMenuItemClickListener(menuItemClickListener);
    }


    Toolbar.OnMenuItemClickListener menuItemClickListener=new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()){
                case R.id.action_settings:
                    showToast("Setting");
                    return true;
                case R.id.search:
                    showToast("Search");
                    return true;
                case R.id.share:
                 showToast("Share");
                    return true;
                case R.id.self_share:
                    showToast("self_share");
                default:
                    return false;
            }

        }
    };
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu,menu);
//        return true;
//    }

    public void showToast(String msg){
        Toast.makeText(ToolBarActivity.this,msg,Toast.LENGTH_LONG).show();

    }
}
