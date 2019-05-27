package id.web.hn.svgloaderlib;

import android.app.Activity;
import android.net.Uri;
import android.widget.ImageView;

/**
 * Created by hahn on 27.05.19.
 * Project: SvgLoader
 */

public class SvgLoader {

    private static SvgLoader instances;

    private SvgParser svgParser;
    private Activity activity;

    public static SvgLoader pluck() {
        if (instances == null)
            instances = new SvgLoader();
        return instances;
    }

    public SvgLoader with(Activity activity){
        this.activity = activity;
        svgParser = new SvgParser(activity);
        return instances;
    }

    public void close(){
        svgParser.clearCache();
    }

    public SvgLoader setPlaceHolder(int placeHolderLoading, int placeHolderError){
        svgParser.setPlaceHolder(placeHolderLoading, placeHolderError);
        return instances;
    }

    public SvgLoader load(String url, ImageView imageView){
        Uri uri = Uri.parse(url);
        svgParser.loadImage(uri, imageView);
        return instances;
    }

}