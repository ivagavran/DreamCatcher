package hr.ferit.ivagavran.dreamcatcher.ui.dream_new

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import hr.ferit.ivagavran.dreamcatcher.R
import hr.ferit.ivagavran.dreamcatcher.databinding.FragmentNewDreamBinding
import hr.ferit.ivagavran.dreamcatcher.di.DreamRepositoryFactory
import hr.ferit.ivagavran.dreamcatcher.model.Dream
import hr.ferit.ivagavran.dreamcatcher.model.DreamColor
import hr.ferit.ivagavran.dreamcatcher.utils.getDate

class NewDreamFragment : Fragment() {

    private val dreamRepository = DreamRepositoryFactory.dreamRepository
    lateinit var binding: FragmentNewDreamBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewDreamBinding.inflate(layoutInflater)
        binding.bSaveDream.setOnClickListener{saveDream()}
        return binding.root
    }

    private fun saveDream() {

        val description = binding.etDreamDescriptionInput.text.toString()
        val color = when(binding.rgColorInput.checkedRadioButtonId){
            R.id.rb_color_black -> DreamColor.Black
            R.id.rb_color_blue -> DreamColor.Blue
            R.id.rb_color_red -> DreamColor.Red
            R.id.rb_color_yellow -> DreamColor.Yellow
            else -> DreamColor.Black
        }
        val dateAdded = binding.dpDateAddedInput.getDate()

        dreamRepository.save(Dream(0, description, color, dateAdded))

        Toast.makeText(context, getString(R.string.dream_saving), Toast.LENGTH_SHORT).show()
        val action = NewDreamFragmentDirections.actionNewDreamFragmentToDreamListFragment()
        findNavController().navigate(action)
    }

    companion object {
        val Tag = "NewDream"

        fun create(): Fragment {
            return NewDreamFragment()
        }
    }
}
