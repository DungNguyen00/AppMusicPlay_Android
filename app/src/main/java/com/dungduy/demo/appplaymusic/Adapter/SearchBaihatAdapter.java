package com.dungduy.demo.appplaymusic.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dungduy.demo.appplaymusic.Activity.PlayNhacActivity;
import com.dungduy.demo.appplaymusic.Model.Baihat;
import com.dungduy.demo.appplaymusic.R;
import com.dungduy.demo.appplaymusic.Service.APIService;
import com.dungduy.demo.appplaymusic.Service.Dataservice;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

// <<<<<<< merge1
public class SearchBaihatAdapter extends RecyclerView.Adapter<SearchBaihatAdapter.ViewHolder> {
    Context context;
    ArrayList<Baihat> mangbaihat;

    public SearchBaihatAdapter(Context context, ArrayList<Baihat> mangbaihat) {
// =======
// public class SearchBaiHatAdapter extends  RecyclerView.Adapter<SearchBaiHatAdapter.ViewHolder>{
//     Context context;
//     ArrayList<Baihat> mangbaihat;

//     public SearchBaiHatAdapter(Context context, ArrayList<Baihat> mangbaihat) {
// >>>>>>> complate
        this.context = context;
        this.mangbaihat = mangbaihat;
    }

// <<<<<<< merge1
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.dong_search_bai_hat, parent, false);
// =======
// //    @NonNull
//     @Override
//     public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//         LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//         View view = inflater.inflate(R.layout.dong_search_bai_hat, parent, false);
// >>>>>>> complate
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Baihat baihat = mangbaihat.get(position);
        holder.txtTenbaihat.setText(baihat.getTenbaihat());
        holder.txtCasi.setText(baihat.getCasi());
// <<<<<<< merge1
        Picasso.with(context).load(baihat.getLinkbaihat()).into(holder.imgbaihat);

// =======
//         Picasso.with(context).load(baihat.getHinhbaihat()).into(holder.imgbaihat);
// >>>>>>> complate
    }

    @Override
    public int getItemCount() {
        return mangbaihat.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
// <<<<<<< merge1
        TextView txtTenbaihat,txtCasi;
        ImageView imgbaihat,imgluotthich;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTenbaihat = itemView.findViewById(R.id.textviewsearchtenbaihat);
            txtCasi = itemView.findViewById(R.id.textviewsearchtencasi);
// =======
//         TextView txtTenbaihat, txtCasi;
//         ImageView imgbaihat, imgluotthich;
//         public ViewHolder(@NonNull View itemView) {
//             super(itemView);
//             txtTenbaihat = itemView.findViewById(R.id.textviewsearchtenbaihat);
//             txtCasi = itemView.findViewById(R.id.textviewsearchcasi);
// >>>>>>> complate
            imgbaihat = itemView.findViewById(R.id.imageviewSearchbaihat);
            imgluotthich = itemView.findViewById(R.id.imageviewSearchluotthich);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, PlayNhacActivity.class);
// <<<<<<< merge1
                    intent.putExtra("cakhuc",mangbaihat.get(getLayoutPosition()));
// =======
//                     intent.putExtra("cakhuc", mangbaihat.get(getPosition()));
// >>>>>>> complate
                    context.startActivity(intent);
                }
            });
            imgluotthich.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imgluotthich.setImageResource(R.drawable.iconloved);
                    Dataservice dataservice = APIService.getService();
                    Call<String> callback = dataservice.Updateluotthich("1", mangbaihat.get(getPosition()).getIdbaihat());

                    callback.enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            String ketqua = response.body();
                            if(ketqua.equals("Success")) {
                                Toast.makeText(context, "Da Thich", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(context, "Loi!", Toast.LENGTH_SHORT).show();

                            }
                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {

                        }
                    });
                    imgluotthich.setEnabled(false);

                }
            });

        }
    }
//                }
//            });
//        }
//    }
}
