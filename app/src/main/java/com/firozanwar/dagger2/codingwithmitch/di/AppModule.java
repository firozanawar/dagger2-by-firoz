package com.firozanwar.dagger2.codingwithmitch.di;

import android.app.Application;
import android.graphics.drawable.Drawable;

import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.firozanwar.dagger2.R;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    // Using this we can directly get the string  @Inject String myString in AuthActivity;
    @Provides
    static String someString() {
        return "Hi this string is getting injected from AppModule";
    }

    /**
     * Using this we can directly get the boolean  @Inject boolean isApp in AuthActivity;
     *
     * It will return false because (Application application) already build in AppComponent's as a @BindsInstance.
     * So it will be available to all modules inserted in AppComponent.
     */
    @Provides
    static boolean getApp(Application application){
        return application ==null;
    }

    /************ Glide library injection - start ************/

    @Singleton
    @Provides
    static RequestOptions provideRequestOptions(){
        return RequestOptions
                .placeholderOf(R.drawable.white_background)
                .error(R.drawable.white_background);
    }

    /**
     * Here (Application application) will available through AppComponent's as a @BindsInstance and
     * (RequestOptions requestOptions) is available because it is defined in same module above.
     */
    @Singleton
    @Provides
    static RequestManager provideGlideInstance(Application application,RequestOptions requestOptions){
        return Glide
                .with(application)
                .setDefaultRequestOptions(requestOptions);
    }

    /**
     * * Here (Application application) will available through AppComponent's as a @BindsInstance
     */
    @Singleton
    @Provides
    static Drawable provideLogoDrawable(Application application){
        return ContextCompat.getDrawable(application,R.drawable.logo);
    }

    /************ Glide library injection - end ************/
}


