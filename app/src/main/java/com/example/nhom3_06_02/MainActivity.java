package com.example.nhom3_06_02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.nhom3_06_02.fragment.FragmentA;
import com.example.nhom3_06_02.fragment.FragmentB;
import com.example.nhom3_06_02.fragment.FragmentC;

public class MainActivity extends AppCompatActivity {
   private FragmentManager manager;
   private FragmentTransaction transaction;
   private Fragment fragment;
   private Button bt1,bt2,bt3,bt4,bt5,bt6,btBack,btPop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        manager=getSupportFragmentManager();
    }
    public void addA(View v){
        transaction=manager.beginTransaction();
        fragment=new FragmentA();
        transaction.replace(R.id.frame,fragment,"fa");
        transaction.addToBackStack("aa");
        transaction.commit();
    }
    public void removeA(View v){
        transaction=manager.beginTransaction();
        fragment=(FragmentA)getSupportFragmentManager().
                findFragmentByTag("fa");
        transaction.remove(fragment);
        transaction.commit();
    }
    public void addB(View v){
        transaction=manager.beginTransaction();
        fragment=new FragmentB();
        transaction.replace(R.id.frame,fragment,"fb");
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public void removeB(View v){
        transaction=manager.beginTransaction();
        fragment=(FragmentB)getSupportFragmentManager().
                findFragmentByTag("fb");
        transaction.remove(fragment);
        transaction.commit();
    }
    public void addC(View v){
        transaction=manager.beginTransaction();
        fragment=new FragmentC();
        transaction.replace(R.id.frame,fragment,"fc");
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public void removeC(View v){
        transaction=manager.beginTransaction();
        fragment=(FragmentC)getSupportFragmentManager().
                findFragmentByTag("fc");
        transaction.remove(fragment);
        transaction.commit();
    }
    public void back(View v){
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void onBackPressed() {
        if(getSupportFragmentManager().getBackStackEntryCount()>0){
            getSupportFragmentManager().popBackStack();
        }else
        super.onBackPressed();
    }
    public void popA(View v){
        getSupportFragmentManager().popBackStack("aa",0);
    }

    private void initView() {
        bt1=findViewById(R.id.bt1);
        bt2=findViewById(R.id.bt2);
        bt3=findViewById(R.id.bt3);
        bt4=findViewById(R.id.bt4);
        bt5=findViewById(R.id.bt5);
        bt6=findViewById(R.id.bt6);
        btBack=findViewById(R.id.back);
        btPop=findViewById(R.id.popA);
    }
}
