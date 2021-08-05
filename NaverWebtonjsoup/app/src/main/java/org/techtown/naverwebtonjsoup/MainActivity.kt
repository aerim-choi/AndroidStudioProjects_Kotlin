package org.techtown.naverwebtonjsoup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import org.jsoup.Jsoup
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        retrieveWebInfo()
    }
    private fun retrieveWebInfo(){
        thread{
            // network call, so run it in the background
            //에피소드 웹툰가져오기
            val doc =
                Jsoup.connect("https://comic.naver.com/webtoon/genre?genre=episode")
                    .get()
            val epThumb = doc.getElementsByClass("thumb")
            //0번째는 쓰잘데기없는거들어있음
            val img1=epThumb[1].getElementsByTag("img")[0].absUrl("src")
            val title1=epThumb[1].getElementsByTag("img")[0].attr("title").trim()

            val img2=epThumb[2].getElementsByTag("img")[0].absUrl("src")
            val title2=epThumb[2].getElementsByTag("img")[0].attr("title").trim()

            val img3=epThumb[3].getElementsByTag("img")[0].absUrl("src")
            val title3=epThumb[3].getElementsByTag("img")[0].attr("title").trim()

            val img4=epThumb[4].getElementsByTag("img")[0].absUrl("src")
            val title4=epThumb[4].getElementsByTag("img")[0].attr("title").trim()

            val img5=epThumb[5].getElementsByTag("img")[0].absUrl("src")
            val title5=epThumb[5].getElementsByTag("img")[0].attr("title").trim()


             //can't access UI elements from the background thread
            this.runOnUiThread{
                Picasso.get().load(img1).into(epimg1)
                eptit1.text =title1
                Picasso.get().load(img2).into(epimg2)
                eptit2.text =title2
                Picasso.get().load(img3).into(epimg3)
                eptit3.text =title3
                Picasso.get().load(img4).into(epimg4)
                eptit4.text =title4
                Picasso.get().load(img5).into(epimg5)
                eptit5.text =title5
            }
        }
    }
}