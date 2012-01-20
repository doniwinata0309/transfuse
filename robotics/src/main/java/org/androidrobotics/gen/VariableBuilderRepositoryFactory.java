package org.androidrobotics.gen;

import android.accounts.AccountManager;
import android.app.*;
import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.hardware.SensorManager;
import android.location.LocationManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.DropBoxManager;
import android.os.PowerManager;
import android.os.Vibrator;
import android.service.wallpaper.WallpaperService;
import android.telephony.TelephonyManager;
import android.text.ClipboardManager;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.inputmethod.InputMethodManager;
import org.androidrobotics.gen.variableBuilder.VariableInjectionBuilderFactory;
import org.androidrobotics.gen.variableBuilder.VariableInjectionNodeBuilder;

import javax.inject.Inject;
import javax.inject.Provider;
import java.util.HashMap;
import java.util.Map;

/**
 * @author John Ericksen
 */
public class VariableBuilderRepositoryFactory {

    private Provider<VariableInjectionNodeBuilder> variableInjectionNodeBuilderProvider;
    private VariableInjectionBuilderFactory variableInjectionBuilderFactory;
    private Map<String, Class<?>> systemService;

    @Inject
    public VariableBuilderRepositoryFactory(Provider<VariableInjectionNodeBuilder> variableInjectionNodeBuilderProvider, VariableInjectionBuilderFactory variableInjectionBuilderFactory) {
        this.variableInjectionNodeBuilderProvider = variableInjectionNodeBuilderProvider;
        this.variableInjectionBuilderFactory = variableInjectionBuilderFactory;

        systemService = new HashMap<String, Class<?>>();
        systemService.put(Context.ACCESSIBILITY_SERVICE, AccessibilityManager.class);
        systemService.put(Context.ACCOUNT_SERVICE, AccountManager.class);
        systemService.put(Context.ACTIVITY_SERVICE, ActivityManager.class);
        systemService.put(Context.ALARM_SERVICE, AlarmManager.class);
        systemService.put(Context.AUDIO_SERVICE, AudioManager.class);
        systemService.put(Context.CLIPBOARD_SERVICE, ClipboardManager.class);
        systemService.put(Context.CONNECTIVITY_SERVICE, ConnectivityManager.class);
        systemService.put(Context.DEVICE_POLICY_SERVICE, DevicePolicyManager.class);
        //systemService.put(Context.DOWNLOAD_SERVICE, DownloadManager.class);
        systemService.put(Context.DROPBOX_SERVICE, DropBoxManager.class);
        systemService.put(Context.INPUT_METHOD_SERVICE, InputMethodManager.class);
        systemService.put(Context.NOTIFICATION_SERVICE, NotificationManager.class);
        systemService.put(Context.KEYGUARD_SERVICE, KeyguardManager.class);
        systemService.put(Context.LAYOUT_INFLATER_SERVICE, LayoutInflater.class);
        systemService.put(Context.LOCATION_SERVICE, LocationManager.class);
        //put(Context.NFC_SERVICE, NfcManager.class);
        systemService.put(Context.NOTIFICATION_SERVICE, NotificationManager.class);
        systemService.put(Context.POWER_SERVICE, PowerManager.class);
        systemService.put(Context.SEARCH_SERVICE, SearchManager.class);
        systemService.put(Context.SENSOR_SERVICE, SensorManager.class);
        //put(Context.STORAGE_SERVICE, StorageManager.class);
        systemService.put(Context.TELEPHONY_SERVICE, TelephonyManager.class);
        //put(Context.TEXT_SERVICES_MANAGER_SERVICE, TextServicesManager.class);
        systemService.put(Context.UI_MODE_SERVICE, UiModeManager.class);
        //put(Context.USB_SERVICE, UsbManager.class);
        systemService.put(Context.VIBRATOR_SERVICE, Vibrator.class);
        systemService.put(Context.WALLPAPER_SERVICE, WallpaperService.class);
        //put(Context.WIFI_P2P_SERVICE, WifiP2pManager.class);
        systemService.put(Context.WIFI_SERVICE, WifiManager.class);
        systemService.put(Context.WINDOW_SERVICE, WindowManager.class);
    }

    public InjectionNodeBuilderRepository buildRepository() {
        InjectionNodeBuilderRepository injectionNodeBuilderRepository = new InjectionNodeBuilderRepository(variableInjectionNodeBuilderProvider);

        for (Map.Entry<String, Class<?>> systemServiceEntry : systemService.entrySet()) {
            injectionNodeBuilderRepository.put(systemServiceEntry.getValue().getName(),
                    variableInjectionBuilderFactory.buildSystemServiceInjectionNodeBuilder(
                            systemServiceEntry.getKey(),
                            systemServiceEntry.getValue()));
        }

        return injectionNodeBuilderRepository;
    }

    public InjectionNodeBuilderRepository buildRepository(InjectionNodeBuilderRepository parent) {
        return new InjectionNodeBuilderRepository(parent, variableInjectionNodeBuilderProvider);
    }
}
