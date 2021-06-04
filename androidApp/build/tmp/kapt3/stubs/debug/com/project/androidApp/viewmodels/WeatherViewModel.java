package com.project.androidApp.viewmodels;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0007R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/project/androidApp/viewmodels/WeatherViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "baseVM", "Lcom/project/shared/viewmodel/CurrentTemperature;", "getBaseVM", "()Lcom/project/shared/viewmodel/CurrentTemperature;", "getWeather", "", "lat", "", "lon", "androidApp_debug"})
public final class WeatherViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.project.shared.viewmodel.CurrentTemperature baseVM = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.project.shared.viewmodel.CurrentTemperature getBaseVM() {
        return null;
    }
    
    @kotlinx.coroutines.ExperimentalCoroutinesApi()
    public final void getWeather(double lat, double lon) {
    }
    
    public WeatherViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
}