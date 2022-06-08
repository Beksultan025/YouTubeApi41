package kg.junesqo.youtubeapi41.ui.playlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import kg.junesqo.youtubeapi41.R
import kg.junesqo.youtubeapi41.base.BaseActivity
import kg.junesqo.youtubeapi41.base.BaseViewModel
import kg.junesqo.youtubeapi41.databinding.ActivityPlaylistBinding

class PlaylistActivity : BaseActivity<ActivityPlaylistBinding, PlaylistViewModel>() {

    override val viewModel: PlaylistViewModel by lazy {
        ViewModelProvider(this)[PlaylistViewModel::class.java]
    }

    override fun inflateViewBinding(inflater: LayoutInflater): ActivityPlaylistBinding {
        return ActivityPlaylistBinding.inflate(inflater)
    }

    override fun initView() {
        TODO("Not yet implemented")
    }

    override fun initListener() {
        TODO("Not yet implemented")
    }

    override fun initViewModel() {
        viewModel.getPlaylist().observe(this) {
            Toast.makeText(this, it.kind, Toast.LENGTH_SHORT).show()
        }
    }

    override fun checkInternet() {
        TODO("Not yet implemented")
    }

}