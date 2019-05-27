package id.web.hn.svgloader

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.web.hn.svgloaderlib.SvgLoader
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val url = "https://upload.wikimedia.org/wikipedia/commons/0/02/SVG_logo.svg"

        SvgLoader.pluck()
            .with(this)
            .setPlaceHolder(R.mipmap.ic_launcher, R.drawable.ic_launcher_background)
            .load(url, imageView)//, R.mipmap.ic_launcher, R.mipmap.ic_launcher)

    }

    override fun onDestroy() {
        super.onDestroy()
        SvgLoader.pluck().close()
    }
}
