package com.project.androidApp.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0019\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0002\u0010\u0010J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0012H\u0014J\u001e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001aH\u0016J\u001e\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001aH\u0016J-\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u000e\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016\u00a2\u0006\u0002\u0010\u001fJ\u0019\u0010 \u001a\u00020\u00122\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0002\u0010!R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\f\u00a8\u0006\""}, d2 = {"Lcom/project/androidApp/ui/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/vmadalin/easypermissions/EasyPermissions$PermissionCallbacks;", "()V", "_binding", "Lcom/project/androidApp/databinding/ActivityMainBinding;", "binding", "getBinding", "()Lcom/project/androidApp/databinding/ActivityMainBinding;", "permissions", "", "", "[Ljava/lang/String;", "checkPermission", "", "permission", "([Ljava/lang/String;)Z", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPermissionsDenied", "requestCode", "", "perms", "", "onPermissionsGranted", "onRequestPermissionsResult", "grantResults", "", "(I[Ljava/lang/String;[I)V", "requestPermission", "([Ljava/lang/String;)V", "androidApp_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity implements com.vmadalin.easypermissions.EasyPermissions.PermissionCallbacks {
    private java.lang.String[] permissions = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};
    private com.project.androidApp.databinding.ActivityMainBinding _binding;
    private java.util.HashMap _$_findViewCache;
    
    private final com.project.androidApp.databinding.ActivityMainBinding getBinding() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final boolean checkPermission(@org.jetbrains.annotations.NotNull()
    java.lang.String[] permission) {
        return false;
    }
    
    public final void requestPermission(@org.jetbrains.annotations.NotNull()
    java.lang.String[] permission) {
    }
    
    @java.lang.Override()
    public void onPermissionsDenied(int requestCode, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> perms) {
    }
    
    @java.lang.Override()
    public void onPermissionsGranted(int requestCode, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> perms) {
    }
    
    @java.lang.Override()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    public MainActivity() {
        super();
    }
}