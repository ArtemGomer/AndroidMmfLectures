package me.gomer.nsu_mmf.second

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import me.gomer.nsu_mmf.R
import me.gomer.nsu_mmf.databinding.ActivitySecondBinding
import me.gomer.nsu_mmf.second.item_decoration.HorizontalPaddingItemDecoration
import me.gomer.nsu_mmf.second.item_decoration.VerticalPaddingItemDecoration
import me.gomer.nsu_mmf.second.list.AsyncListItemAdapter

class SecondActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivitySecondBinding.inflate(layoutInflater)
    }

    private val adapter by lazy {
        AsyncListItemAdapter()
    }

    private val viewModel: SecondViewModel by viewModels<SecondViewModel>(
        factoryProducer = {
            SecondViewModelFactory(mapper = SecondMapper())
        }
    )

    companion object {

        fun startActivity(context: Context, text: String) {
            val intent = Intent(context, SecondActivity::class.java)
            intent.putExtra("TEXT", text)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.list.adapter = adapter
        binding.list.layoutManager = LinearLayoutManager(
            this,
            RecyclerView.VERTICAL,
            false
        )
        binding.list.addItemDecoration(HorizontalPaddingItemDecoration(
            rightPadding = 16,
            leftPadding = 16,
            viewTypes = listOf(R.layout.list_item)
        ))
        binding.list.addItemDecoration(VerticalPaddingItemDecoration(
            topPadding = 16,
            bottomPadding = 16,
            viewTypes = listOf(R.layout.list_item)
        ))

        viewModel.state.observe(this) { list ->
            adapter.submitList(list)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}