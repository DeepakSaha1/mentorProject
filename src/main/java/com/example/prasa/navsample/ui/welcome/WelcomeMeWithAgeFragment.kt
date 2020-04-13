package com.example.prasa.navsample.ui.welcome


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.prasa.navsample.R
import kotlinx.android.synthetic.main.fragment_welcome_with_age.*

/**
 * A simple [Fragment] subclass.
 *
 */
class WelcomeMeWithAgeFragment : androidx.fragment.app.Fragment() {

    private val args: WelcomeMeWithAgeFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_welcome_with_age, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name = args.myname
        val age = args.myage

        welcomewithNameandAge.text = "Welcome $name! Your age is $age"
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val callback: OnBackPressedCallback = object : OnBackPressedCallback(
                true) {
            override fun handleOnBackPressed() {
                findNavController().navigate(WelcomeMeWithAgeFragmentDirections.actionGlobalMainFragment())
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(
                this,  // LifecycleOwner
                callback)
    }
}
