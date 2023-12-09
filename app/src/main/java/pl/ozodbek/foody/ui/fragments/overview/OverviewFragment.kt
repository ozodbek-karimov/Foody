package pl.ozodbek.foody.ui.fragments.overview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import coil.load
import pl.ozodbek.foody.R
import pl.ozodbek.foody.bindingadapters.RecipesRowBinding
import pl.ozodbek.foody.models.Result
import pl.ozodbek.foody.databinding.FragmentOverviewBinding
import pl.ozodbek.foody.util.Constants.Companion.RECIPE_RESULT_KEY

class OverviewFragment : Fragment() {

    private var _binding: FragmentOverviewBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOverviewBinding.inflate(inflater, container, false)

        val args = arguments
        val myBundle: Result = args!!.getParcelable<Result>(RECIPE_RESULT_KEY) as Result

        binding.mainImageView.load(myBundle.image)
        binding.titleTextview.text = myBundle.title
        binding.likesTextview.text = myBundle.aggregateLikes.toString()
        binding.timeTextView.text = myBundle.readyInMinutes.toString()
        RecipesRowBinding.parseHtml(binding.summaryTextview, myBundle.summary)

        updateColor(myBundle.vegetarian, binding.vegetarianTextview, binding.vegetarianImageview)
        updateColor(myBundle.vegan, binding.veganTextview, binding.veganImageview)
        updateColor(myBundle.glutenFree, binding.glutenFreeTextview, binding.glutenFreeImageview)
        updateColor(myBundle.cheap, binding.cheapTextview, binding.cheapImageview)
        updateColor(myBundle.dairyFree, binding.diaryFreeTextview, binding.diaryFreeImageview)
        updateColor(myBundle.glutenFree, binding.glutenFreeTextview, binding.glutenFreeImageview)
        updateColor(myBundle.veryHealthy, binding.healthyTextview, binding.healthyImageview)

        return binding.root
    }

    private fun updateColor(isStateOn: Boolean, textView: TextView, imageView: ImageView) {

        if (isStateOn) {

            imageView.setColorFilter(ContextCompat.getColor(requireContext(), R.color.green))
            textView.setTextColor(ContextCompat.getColor(requireContext(), R.color.green))

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}