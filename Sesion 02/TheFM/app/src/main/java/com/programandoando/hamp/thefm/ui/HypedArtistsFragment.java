package com.programandoando.hamp.thefm.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.programandoando.hamp.thefm.R;
import com.programandoando.hamp.thefm.domain.Artist;
import com.programandoando.hamp.thefm.ui.adapter.HypedArtistAdapter;

import java.util.ArrayList;

/**
 * Created by HAMP on 18/05/2016.
 */
public class HypedArtistsFragment extends Fragment {

    public static final String LOG_TAG=HypedArtistsFragment
                            .class.getSimpleName();

    public static final int NUM_COLUMS=2;
    private RecyclerView mHyedArtistsList;
    private HypedArtistAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter=new HypedArtistAdapter(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //Tener un vista principal : VIEW
        View root=inflater.inflate(R.layout
                .fragment_hyped_artists,container,false);
        //A esta vista( root) le pedimos que busque el nuevo
        //view (RecyclerView)
        mHyedArtistsList=(RecyclerView)root
                .findViewById(R.id.hyped_artists_list);
        setupArtistsList();
        setDummyContent();
        return root;
    }

    private void setupArtistsList(){
        mHyedArtistsList.setLayoutManager(
                new GridLayoutManager(getActivity(),NUM_COLUMS));
        //RecyclerView(LayoutManager)--- Adapter ---> Dataset(ArrayList)
        mHyedArtistsList.setAdapter(adapter);
        mHyedArtistsList.addItemDecoration(new ItemOffsetDecoration(getActivity()
                ,R.integer.offset));
    }

    private void setDummyContent(){
        ArrayList<Artist> artists=new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            artists.add(new Artist("Artist "+i));
        }
        adapter.addAll(artists);
    }
}
