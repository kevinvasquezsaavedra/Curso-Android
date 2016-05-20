package com.programandoando.hamp.thefm.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.programandoando.hamp.thefm.R;
import com.programandoando.hamp.thefm.domain.Artist;

import java.util.ArrayList;

/**
 * Created by HAMP on 18/05/2016.
 */
public class HypedArtistAdapter
        extends
        RecyclerView.Adapter<HypedArtistAdapter.HypedArtistViewHolder> {

    ArrayList<Artist> artists;

    //Actividad: porque ADAPTER ---- XML ( VISTA )
    Context context;
    public HypedArtistAdapter(Context context) {
        this.context = context;
        this.artists=new ArrayList<>();//Evitar NullPointException
    }

    @Override
    public HypedArtistViewHolder onCreateViewHolder
            (ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(context)
                .inflate(R.layout.item_hyped_artists,parent
                        ,false);

        return new HypedArtistViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(HypedArtistViewHolder holder, int position) {
        Artist currentArtist=artists.get(position);
        //Setear el valor del nombre
        holder.setArtistName(currentArtist.getName());
    }

    @Override
    public int getItemCount() {
        return artists.size();
    }

    public void addAll(@NonNull ArrayList<Artist> artists){
        if(artists==null)
            throw  new NullPointerException("Lista no puede estar vacio");
        this.artists.addAll(artists);
        notifyItemRangeInserted(getItemCount()-1,artists.size());
    }

    //Definir los views
    public class HypedArtistViewHolder
            extends RecyclerView.ViewHolder {

        TextView artistName;
        ImageView artistImage;

        public HypedArtistViewHolder(View itemView) {
            super(itemView);

            artistName=(TextView) itemView.findViewById(R.id.txt_name);
            artistImage=(ImageView) itemView.findViewById(R.id.img_artist);
        }

        public void setArtistName(String name){
            artistName.setText(name);
        }
    }

}
