package org.techtown.mvvm_ex2;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;


public class MainActivity extends AppCompatActivity {

    private BlankFragment[] fragments = {BlankFragment.newInstance(1), BlankFragment.newInstance(2), BlankFragment.newInstance(3)};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        setViewPager();

        //버튼을 클릭하면 viewModel의 mutable data의 값이 1씩 증가한다.
        Button btn = (Button) findViewById(R.id.main_button);
        btn.setOnClickListener(view -> {
            viewModel.add();
        });
    }


    private void setViewPager() {
        ViewPager2 viewPager2 = (ViewPager2) findViewById(R.id.viewpager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), getLifecycle());
        adapter.setList(fragments);
        viewPager2.setAdapter(adapter);
    }

}