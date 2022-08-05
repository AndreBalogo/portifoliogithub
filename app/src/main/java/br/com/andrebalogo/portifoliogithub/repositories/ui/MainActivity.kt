package br.com.andrebalogo.portifoliogithub.repositories.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.widget.SearchView
import br.com.andrebalogo.portifoliogithub.R
import br.com.andrebalogo.portifoliogithub.databinding.ActivityMainBinding
import br.com.andrebalogo.portifoliogithub.repositories.core.createDialog
import br.com.andrebalogo.portifoliogithub.repositories.core.createProgessDialog
import br.com.andrebalogo.portifoliogithub.repositories.core.hideSoftKeyboard
import br.com.andrebalogo.portifoliogithub.repositories.presentation.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    private val dialog by lazy { createProgessDialog() }
    private val viewModel by viewModel<MainViewModel>()
    private val adapter by lazy { RepoListAdapter() }
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

       setSupportActionBar(binding.toolbar)
        binding.rvRepos.adapter = adapter

        viewModel.repos.observe(this) {
            when(it) {
                is MainViewModel.State.Error -> {
                    createDialog{
                        setMessage(it.error.message)
                    }.show()
                    dialog.dismiss()
                }

                MainViewModel.State.Loading -> dialog.show()

                is MainViewModel.State.Success -> {
                    dialog.dismiss()
                    adapter.submitList(it.list)
                }
            }

        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        val searchView = menu.findItem(R.id.action_search).actionView as SearchView
        searchView.setOnQueryTextListener(this)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        query?.let { viewModel.getRepoList(it) }
        binding.root.hideSoftKeyboard()
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        Log.e(TAG, "onQueryTextSubmit: $newText")
        return false
    }
    companion object {
        private const val TAG = "TAG"
    }
}


