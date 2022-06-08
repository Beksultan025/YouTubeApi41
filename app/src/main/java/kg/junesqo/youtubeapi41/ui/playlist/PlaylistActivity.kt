package kg.junesqo.youtubeapi41.ui.playlist

import android.content.Intent
import android.view.LayoutInflater
import android.widget.Adapter
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import kg.junesqo.youtubeapi41.base.BaseActivity
import kg.junesqo.youtubeapi41.databinding.ActivityPlaylistBinding
import kg.junesqo.youtubeapi41.model.Item
import kg.junesqo.youtubeapi41.ui.playlist_detail.PlaylistDetailActivity

class PlaylistActivity : BaseActivity<ActivityPlaylistBinding, PlaylistViewModel>(), Adapter.OnClick {

    override val viewModel: PlaylistViewModel by lazy {
        ViewModelProvider(this)[PlaylistViewModel::class.java]
    }

    override fun inflateViewBinding(inflater: LayoutInflater): ActivityPlaylistBinding {
        return ActivityPlaylistBinding.inflate(inflater)
    }

    override fun checkInternet() {
    }

    override fun initViewModel() {
        viewModel.getPlaylist().observe(this) {
            Toast.makeText(this, it.kind, Toast.LENGTH_SHORT).show()
            initRecyclerView(it.items)
        }
    }

    override fun initView() {

    }

    override fun initListener() {
    }

    private fun initRecyclerView(playlistsList: List<Item>) {
        binding.recyclerMain.adapter = PlaylistAdapter(playlistsList, object:PlaylistAdapter.OnItemClickListener{
            override fun onItemClick(id: String) {
                Intent(this@PlaylistActivity, PlaylistDetailActivity::class.java)
                intent.putExtra("Username","John Doe")
                startActivity(intent)
            }

        })
    }

}