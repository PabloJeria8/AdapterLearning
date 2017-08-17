package cl.empresapjm.adapterlearning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import cl.empresapjm.adapterlearning.adapters.DogsAdapter;

public class MainActivity extends AppCompatActivity {

    private DogsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.dogRv);

        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);

        List<Dog> dogs = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            String value = String.valueOf(i);
            dogs.add(new Dog(value,value));
        }

        adapter =  new DogsAdapter(dogs);
        recyclerView.setAdapter(adapter);

        Button button = (Button) findViewById(R.id.addBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.add(new Dog("someee","fffff"));

            }
        });


    }
}
