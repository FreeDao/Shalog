package com.shaw.shalog;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;

import com.shaw.shalog.lib.Shalog;
import com.shaw.shalog.lib.Sheelog;
import com.shaw.shalog.lib.Toalog;
import com.shaw.shalog.lib.Shalog.Builder;
import com.shaw.shalog.lib.base.ShalogInterface;
import com.shaw.shalog.lib.base.TouchableBuilder;
import com.shaw.shalog.lib.base.TouchableDialog;

/**
 * demo演示activity
 *
 * @author shaw
 *
 */
public class MainActivity extends Activity {

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    
    public void clickButton(View view) {
        TouchableDialog shalog = new Shalog.Builder(this)
        .setIcon(R.drawable.uc_browser_logo)
        .setTitle("Rate me").setContent("Thanks for using UC Browser. Share your smile and give us 5 stars if you like UC.")
                .setPositiveButton("Yes", new Shalog.OnClickListener() {
                    
                    @Override
                    public void onClick(ShalogInterface shalog, int which) {
                        Toast.makeText(MainActivity.this, "HEHE", Toast.LENGTH_LONG).show();
                        
                    }
                }).setNegativeButton("No", null)
                .setNoDim(true)
                .create();
        shalog.show();
        
    }
    
    public void clickButton2(View view) {
        Toalog toalog = new Toalog.Builder(this).setTitle("极速模式已开启").setContent("速度更省, 流量更省")
                .setIcon(R.drawable.uc_browser_logo).setDuration(Toalog.LENGTH_SHORT)
                .create();
        toalog.show();
    }
    
    public void clickButton3(View view) {
        TouchableDialog shalog = new Shalog.Builder(this)
        .setContent("Your bookmarks and speeddial data are saved from tha last time you uninstalled UC Browser. Do you want to recover these data?")
                .setPositiveButton("Recover", new Shalog.OnClickListener() {
                    
                    @Override
                    public void onClick(ShalogInterface shalog, int which) {
                        Toast.makeText(MainActivity.this, "HEHE", 2000).show();
                        
                    }
                }).setNegativeButton("No, thanks", null)
//                .setRightButton(null)
                .setDonotshow("Do not ask again", new CompoundButton.OnCheckedChangeListener() {
                    
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) Toast.makeText(MainActivity.this, "不ask怎么骚扰用户?", 200).show();
                        
                    }
                })
                .setCanceledOnTouchOutside(false)
                .create();
        shalog.show();
    }
    
    public void clickButton4(View view) {
        TouchableDialog shalog = new Shalog.Builder(this)
//        .setIcon(R.drawable.uc_browser_logo)
        .setTitle("只有标题就惨了")
//        .setRightButton(null)
//        .setContent("Your bookmarks and speeddial data are saved from tha last time you uninstalled UC Browser. Do you want to recover these data?")
                .create();
        shalog.show();
    }
    
    public void clickButton5(View view) {
        List<String> item = new ArrayList<String>();
        item.add("允许");
        item.add("拒绝");
        new Sheelog.Builder(this).setContent("m.taobao.com要获取你的地理位置")
        .setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, item))
        .create().show();
        
    }

    public void clickButton6(View view) {
        List<String> item = new ArrayList<String>();
        item.add("高速下载");
        item.add("普通下载");
        item.add("离线下载");
        new Sheelog.Builder(this).setTitle("下载提示").setContent("文件名:UCBrowser_V9.9.0.apk").setRightButton(R.drawable.checkbox_selector, null)
        .setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, item))
        .create().show();
    }
    
}
