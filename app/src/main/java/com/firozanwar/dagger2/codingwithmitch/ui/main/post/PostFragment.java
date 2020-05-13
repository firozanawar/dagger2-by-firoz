package com.firozanwar.dagger2.codingwithmitch.ui.main.post;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.firozanwar.dagger2.R;
import com.firozanwar.dagger2.codingwithmitch.model.Post;
import com.firozanwar.dagger2.codingwithmitch.ui.main.Resource;
import com.firozanwar.dagger2.codingwithmitch.utils.VerticalSpacingItemDecoration;
import com.firozanwar.dagger2.codingwithmitch.viewmodels.ViewModelProvidersFactory;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

import static com.firozanwar.dagger2.codingwithmitch.ui.main.Resource.Status.LOADING;

public class PostFragment extends DaggerFragment {

    private static final String TAG = "PostFragment";

    private PostViewModel mViewModel;

    private RecyclerView recyclerView;

    @Inject
    PostsRecyclerAdapter adapter;

    @Inject
    ViewModelProvidersFactory providerFactory;

    public static PostFragment newInstance() {
        return new PostFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Toast.makeText(getActivity(), "PostFragment", Toast.LENGTH_LONG).show();
        return inflater.inflate(R.layout.post_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        recyclerView = view.findViewById(R.id.recycler_view);
        mViewModel = ViewModelProviders.of(this,providerFactory).get(PostViewModel.class);

         initRecyclerView();
        subscribeObervers();
    }

    private void subscribeObervers(){
        mViewModel.observePosts().removeObservers(getViewLifecycleOwner());
        mViewModel.observePosts().observe(getViewLifecycleOwner(), new Observer<Resource<List<Post>>>() {
            @Override
            public void onChanged(Resource<List<Post>> listResource) {
                if(listResource != null){
                    switch (listResource.status){

                        case LOADING:{
                            Log.d(TAG, "onChanged: LOADING...");
                            break;
                        }

                        case SUCCESS:{
                            Log.d(TAG, "onChanged: got posts...");
                            adapter.setPosts(listResource.data);
                            break;
                        }

                        case ERROR:{
                            Log.e(TAG, "onChanged: ERROR..." + listResource.message );
                            break;
                        }
                    }
                }
            }
        });
    }

    private void initRecyclerView(){
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        VerticalSpacingItemDecoration itemDecoration = new VerticalSpacingItemDecoration(15);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setAdapter(adapter);
    }

}
