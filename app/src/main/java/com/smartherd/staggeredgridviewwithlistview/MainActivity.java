package com.smartherd.staggeredgridviewwithlistview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rvMain);

        Bitmap[] bitmaps = setUpBitmaps();
        recyclerView.setAdapter(new GridLayoutAdapter(bitmaps));
        StaggeredGridLayoutManager mLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLayoutManager);

    }

    private class GridHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public GridHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ivImage);
            textView = itemView.findViewById(R.id.tvCaption);
        }
    }

    private class GridLayoutAdapter extends RecyclerView.Adapter<GridHolder> {

        Bitmap[] bitmaps;

        public GridLayoutAdapter(Bitmap[] bitmaps) {
            this.bitmaps = bitmaps;
        }

        @Override
        public GridHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.staggered_row, parent, false);
            return new GridHolder(view);
        }

        @Override
        public void onBindViewHolder(GridHolder holder, int position) {
            holder.imageView.requestLayout();
            holder.imageView.setImageBitmap(bitmaps[position]);
            holder.textView.setText("Caption: " + position);
        }

        @Override
        public int getItemCount() {
            return bitmaps.length;
        }
    }

    private Bitmap[] setUpBitmaps() {
        Bitmap[] bitmaps = new Bitmap[9];
        bitmaps[0] = BitmapFactory.decodeResource(getResources(), R.drawable.album_default);
        bitmaps[1] = BitmapFactory.decodeResource(getResources(), R.drawable.arrow_right);
        bitmaps[2] = BitmapFactory.decodeResource(getResources(), R.drawable.background);
        bitmaps[3] = BitmapFactory.decodeResource(getResources(), R.drawable.circle);
        bitmaps[4] = BitmapFactory.decodeResource(getResources(), R.drawable.error);
        bitmaps[5] = BitmapFactory.decodeResource(getResources(), R.drawable.facebook);
        bitmaps[6] = BitmapFactory.decodeResource(getResources(), R.drawable.google);
        bitmaps[7] = BitmapFactory.decodeResource(getResources(), R.drawable.kids_wear);
        bitmaps[8] = BitmapFactory.decodeResource(getResources(), R.drawable.icon);
        return bitmaps;
    }
}


