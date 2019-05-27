package id.web.hn.svgloaderlib;

import android.app.Activity;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.util.Log;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.io.File;


/**
 * Created by hahn on 27.05.19.
 * Project: SvgLoader
 */

public class SvgParser {

    private final Activity activity;

    private RequestBuilder<PictureDrawable> requestBuilder;

    public SvgParser(Activity activity) {
        this.activity = activity;
        createRequestBuilder();
    }

    private void createRequestBuilder() {
        //TODO: transition not work (image not load fit screen)
//        DrawableCrossFadeFactory factory =
//                new DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build();

        requestBuilder = GlideApp.with(activity)
                .as(PictureDrawable.class)
//                .transition(withCrossFade(factory))
                .listener(new SvgSoftwareLayerSetter());
    }

    public void setPlaceHolder(int placeHolderLoading, int placeHolderError){
        requestBuilder
                .placeholder(placeHolderLoading)
                .error(placeHolderError)
                .fitCenter();
    }


    public void loadImage(Uri uri, ImageView imageView) {
        requestBuilder
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .load(uri)
                .into(imageView);
    }

    public void clearCache() {
        Glide.get(activity).clearMemory();
        File cacheDir = Glide.getPhotoCacheDir(activity);
        if (cacheDir != null && cacheDir.isDirectory()) {
            for (File child : cacheDir.listFiles()) {
                if (!child.delete()) {
                    Log.w(TAG, "cannot delete: " + child);
                }
            }
        }
    }

    private static final String TAG = "SvgParser";
}