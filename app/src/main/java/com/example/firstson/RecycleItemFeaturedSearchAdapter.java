package com.example.firstson;
import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RecycleItemFeaturedSearchAdapter extends RecyclerView.Adapter<RecycleItemFeaturedSearchAdapter.RecyclerViewHolder> {
    @NonNull
    private Context mContext;
    private RelativeLayout itemFeatureSearch;
    private ArrayList<String> list= new ArrayList<>();

    public RecycleItemFeaturedSearchAdapter(Context context, ArrayList<String> list)
    {
        this.mContext=context;
        this.list=list;
    }
    @Override
    public RecycleItemFeaturedSearchAdapter.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.item_recycleview_featured_search,viewGroup,false);
        return new RecyclerViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final RecycleItemFeaturedSearchAdapter.RecyclerViewHolder holder, int position) {
        //set text cho từng item
        holder.txtItemFeaturedSearch.setText(list.get(position));

        //Băt sự kiện LinearLayout
        holder.itemFeatureSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //thay đổi background khi bấm vào item
                if(mOnItemClickListener != null)
                {
                    mOnItemClickListener.onItemClick(holder.txtItemFeaturedSearch.getText().toString());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView txtItemFeaturedSearch;
        RelativeLayout itemFeatureSearch;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            itemFeatureSearch = (RelativeLayout) itemView.findViewById(R.id.itemFeaturedSearch);
            txtItemFeaturedSearch = (TextView) itemView.findViewById(R.id.txtItemFeaturedSearch);
        }
    }

    public interface OnItemClickListener{
        void onItemClick(String user);
    }

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener)
    {
        this.mOnItemClickListener=mOnItemClickListener;

    }
}
