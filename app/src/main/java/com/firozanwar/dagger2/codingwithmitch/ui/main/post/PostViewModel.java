package com.firozanwar.dagger2.codingwithmitch.ui.main.post;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.firozanwar.dagger2.codingwithmitch.SessionManager;
import com.firozanwar.dagger2.codingwithmitch.model.Post;
import com.firozanwar.dagger2.codingwithmitch.network.main.MainApi;
import com.firozanwar.dagger2.codingwithmitch.ui.main.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import javax.inject.Inject;

import io.reactivex.schedulers.Schedulers;

public class PostViewModel extends ViewModel {

    private static final String TAG = "PostsViewModel";

    // inject
    private final SessionManager sessionManager;
    private final MainApi mainApi;

    private MediatorLiveData<Resource<List<Post>>> posts;

    @Inject
    public PostViewModel(SessionManager sessionManager, MainApi mainApi) {
        this.sessionManager = sessionManager;
        this.mainApi = mainApi;
        Log.d(TAG, "PostsViewModel: viewmodel is working...");
    }

    public LiveData<Resource<List<Post>>> observePosts() {
        if(posts == null){
            posts = new MediatorLiveData<>();
            posts.setValue(Resource.loading((List<Post>)null));

            final LiveData<Resource<List<Post>>> source = LiveDataReactiveStreams.fromPublisher(

                    mainApi.getPostsFromUser(sessionManager.getAuthUser().getValue().data.getId())

                            .onErrorReturn(new io.reactivex.functions.Function<Throwable, List<Post>>() {
                                @Override
                                public List<Post> apply(Throwable throwable) throws Exception {
                                    Log.e(TAG, "apply: ", throwable);
                                    Post post = new Post();
                                    post.setId(-1);
                                    ArrayList<Post> posts = new ArrayList<>();
                                    posts.add(post);
                                    return posts;
                                }
                            })

                            .map(new io.reactivex.functions.Function<List<Post>, Resource<List<Post>>>() {
                                @Override
                                public Resource<List<Post>> apply(List<Post> posts) throws Exception {

                                    if(posts.size() > 0){
                                        if(posts.get(0).getId() == -1){
                                            return Resource.error("Something went wrong", null);
                                        }
                                    }

                                    return Resource.success(posts);
                                }
                            })

                            .subscribeOn(Schedulers.io())
            );

            posts.addSource(source, new Observer<Resource<List<Post>>>() {
                @Override
                public void onChanged(Resource<List<Post>> listResource) {
                    posts.setValue(listResource);
                    posts.removeSource(source);
                }
            });
        }
        return posts;
    }
}
