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
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {
    @NonNull
    private Context mContext;
    private LinearLayout line;
    private ArrayList<String> list= new ArrayList<>();

    public RecyclerViewAdapter(Context context, ArrayList<String> list)
    {
        this.mContext=context;
        this.list=list;
    }
    @Override
    public RecyclerViewAdapter.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.item_recyclerview_main,viewGroup,false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerViewAdapter.RecyclerViewHolder holder, int position) {
        //set text cho từng item
        holder.txtBookName.setText(list.get(position));

        //Băt sự kiện LinearLayout
        holder.line.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //thay đổi background khi bấm vào item
                if(mOnItemClickListener != null)
                {
                    mOnItemClickListener.onItemClick(holder.txtBookName.getText().toString());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView txtBookName,txtAuthorName;
        CardView line;
        ImageView imgBook;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            line = (CardView) itemView.findViewById(R.id.line);
            txtBookName = (TextView) itemView.findViewById(R.id.txtBookName);
            txtAuthorName = (TextView) itemView.findViewById(R.id.txtAuthorName);
            imgBook = (ImageView) itemView.findViewById(R.id.imgBook);
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
