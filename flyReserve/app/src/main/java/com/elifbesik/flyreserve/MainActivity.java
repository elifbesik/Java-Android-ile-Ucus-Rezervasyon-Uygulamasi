package com.elifbesik.flyreserve;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private BiletAdapter adapter;
    static public BiletDetails biletDetails;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.add_menu_add_flight) {
            //intent geçiş
            Intent addFlightIntent= new Intent(this,AddFlightActivity.class);
            finish();
            startActivity(addFlightIntent);
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView =(RecyclerView)findViewById(R.id.main_activity_recyclerView);
        adapter = new BiletAdapter(Bilet.getData(this),this);

        mRecyclerView.setHasFixedSize(true);
        //GridLayoutManager manager =new GridLayoutManager(this,2);
        LinearLayoutManager manager =new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.addItemDecoration(new GridManagerDecoration());
        mRecyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new BiletAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Bilet bilet) {
                biletDetails = new BiletDetails(bilet.getIsim(),bilet.getSoyisim(),bilet.getTarih(),bilet.getTarih2(),bilet.getUlke(),bilet.getHavaalani(),bilet.getKoltuk());

                Intent detailsIntent = new Intent(MainActivity.this,DetailsActivity.class);

                startActivity(detailsIntent);
            }
        });
    }
    private class GridManagerDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            outRect.bottom=25;
        }
    }
}