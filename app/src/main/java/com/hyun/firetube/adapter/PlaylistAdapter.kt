package com.hyun.firetube.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hyun.firetube.R
import com.hyun.firetube.model.Playlist

/************************************************************************
 * Purpose:         Recycler View Adapter For Playlist
 * Precondition:    .
 * Postcondition:   Initiate and Assign View Holders to
 *                  XML playlist_item_list
 ************************************************************************/
class PlaylistAdapter(context : Context, playlists : ArrayList<Playlist>) :
    RecyclerView.Adapter<PlaylistAdapter.ViewHolder>() {

    companion object {
        private const val TAG = "ChannelAdapter"  // Logcat
    }

    private val mPlayLists : ArrayList<Playlist>? = playlists
    private val mContext : Context? = context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.playlist_item_list, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var playlist : Playlist = this.mPlayLists!![position]

        holder.title.text = playlist.title
        Glide.with(mContext!!).load(playlist.thumbnail).into(holder.thumbnail)
    }

    override fun getItemCount(): Int {

        return this.mPlayLists!!.size
    }

    /************************************************************************
     * Purpose:         View Holder For Recycler View Adapter
     * Precondition:    .
     * Postcondition:   .
     ************************************************************************/
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var title = itemView.findViewById<View>(R.id.Playlist_Title) as TextView
        var thumbnail = itemView.findViewById(R.id.Playlist_Thumbnail) as ImageView
    }
}
