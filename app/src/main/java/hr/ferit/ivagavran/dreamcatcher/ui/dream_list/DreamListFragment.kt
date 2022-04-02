package hr.ferit.ivagavran.dreamcatcher.ui.dream_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import hr.ferit.ivagavran.dreamcatcher.databinding.FragmentDreamListBinding
import hr.ferit.ivagavran.dreamcatcher.di.DreamRepositoryFactory
import hr.ferit.ivagavran.dreamcatcher.model.Dream

class DreamListFragment : Fragment(), OnDreamEventListener {
    private lateinit var binding: FragmentDreamListBinding
    private lateinit var adapter: DreamAdapter
    private val dreamRepository = DreamRepositoryFactory.dreamRepository

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDreamListBinding.inflate(layoutInflater)
        setupRecyclerView()
        binding.fabAddDream.setOnClickListener { showCreateNewDreamFragment() }
        return binding.root
    }

    private fun setupRecyclerView() {
        binding.dreamListRvDreams.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL,
            false
        )
        adapter = DreamAdapter()
        adapter.onDreamSelectedListener = this
        binding.dreamListRvDreams.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        updateData()
    }

    private fun updateData() {
        adapter.setDreams(dreamRepository.getAllDreams())
    }

    companion object {
        val Tag = "DreamsList"

        fun create(): Fragment {
            return DreamListFragment()
        }
    }

    override fun onDreamLongPress(dream: Dream?): Boolean {
        dream?.let { it ->
            dreamRepository.delete(it)
            adapter.setDreams(dreamRepository.getAllDreams())
        }
        return true
    }

    private fun showCreateNewDreamFragment() {
        val action = DreamListFragmentDirections.actionDreamListFragmentToNewDreamFragment()
        findNavController().navigate(action)
    }
}
