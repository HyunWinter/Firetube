package com.hyun.firetube.activity

import android.os.Bundle
import com.hyun.firetube.R
import com.hyun.firetube.model.Video
import kotlinx.android.synthetic.main.activity_videoplayer.*


class VideoPlayerActivity : BaseActivity() {

    // Variables
    private lateinit var mVideo : Video

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_videoplayer)

        this.setContents()
    }

    /************************************************************************
     * Purpose:         Set Intent
     * Precondition:    onCreate
     * Postcondition:   Contents Initialization
     ************************************************************************/
    private fun setContents() {

        val videoID = intent.getStringExtra(getString(R.string.Uploads_ID_Key)) as String
        val videoTitle = intent.getStringExtra(getString(R.string.Uploads_Title_Key)) as String
        this.mVideo = Video(videoID, videoTitle, "")

        this.VideoPlayer_Youtube.play(this.mVideo.id)
    }
}