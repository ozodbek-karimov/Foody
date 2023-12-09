package pl.ozodbek.foody.ui.fragments.instructions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebViewClient
import androidx.activity.addCallback
import pl.ozodbek.foody.R
import pl.ozodbek.foody.databinding.FragmentInstructionsBinding
import pl.ozodbek.foody.models.Result
import pl.ozodbek.foody.util.Constants

class InstructionsFragment : Fragment() {

    private var _binding: FragmentInstructionsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInstructionsBinding.inflate(inflater, container, false)

        val args = arguments
        val myBundle: Result? = args?.getParcelable(Constants.RECIPE_RESULT_KEY)

        binding.instructionsWebview.webViewClient = object : WebViewClient() {}
        val webViewUrl: String = myBundle!!.sourceUrl
        binding.instructionsWebview.loadUrl(webViewUrl)

        //LOAD CASHES
//        val webSettings = binding.instructionsWebview.settings
//
//        webSettings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            if (binding.instructionsWebview.canGoBack()) {
                binding.instructionsWebview.goBack()
            } else {
                requireActivity().onBackPressedDispatcher
            }
        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}