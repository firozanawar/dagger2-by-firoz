package com.firozanwar.dagger2.codingwithmitch.di;

import android.app.Application;

import com.firozanwar.dagger2.BaseApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Think this AppComponent as a service and BaseApplication as a client.
 */
@Singleton
@Component(
        modules = {
                AndroidSupportInjectionModule.class,
                ActivityBuilderModule.class,
                AppModule.class,
                ViewModelFactoryModule.class,

        }
)
public interface AppComponent extends AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

}
