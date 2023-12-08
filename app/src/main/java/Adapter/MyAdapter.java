package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.travelguider.R;
import com.example.travelguider.RecyclerViewInterface;

import java.util.List;

import Model.MyModel;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.viewHolder> {
    private Context context;
    private List<MyModel> myModels;
    private RecyclerViewInterface recyclerViewInterface;

    public MyAdapter(Context context, List<MyModel> myModels, RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.myModels = myModels;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public MyAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_list,parent,false);
        return new viewHolder(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.viewHolder holder, int position) {
        MyModel myModel = myModels.get(position);

        holder.image.setImageResource(myModel.getImage());
        holder.topic.setText(myModel.getTopic());
        holder.category1.setText(myModel.getCategory1());
        holder.category2.setText(myModel.getCategory2());
        holder.category3.setText(myModel.getCategory3());
        holder.category4.setText(myModel.getCategory4());
        holder.desc.setText(myModel.getDesc());
    }

    @Override
    public int getItemCount() {
        return myModels.size();
    }

    public void filterList(List<MyModel> filteredList){
        myModels = filteredList;
        notifyDataSetChanged();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        public ImageView image;
        public TextView topic;
        public TextView category1;
        public TextView category2;
        public TextView category3;
        public TextView category4;
        public TextView desc;

        public CardView cardView;

        public viewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.imageView);
            topic = (TextView) itemView.findViewById(R.id.topic);
            category1 = (TextView) itemView.findViewById(R.id.category1);
            category2 = (TextView) itemView.findViewById(R.id.category2);
            category3 = (TextView) itemView.findViewById(R.id.category3);
            category4 = (TextView) itemView.findViewById(R.id.category4);
            cardView = (CardView) itemView.findViewById(R.id.cardView);
            desc = (TextView) itemView.findViewById(R.id.textView3);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (MyAdapter.this.recyclerViewInterface != null){
                        int pos = getAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION){
                            MyAdapter.this.recyclerViewInterface.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }
}
