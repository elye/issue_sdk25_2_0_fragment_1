package framentissue25_2_0.myproject.com.fragmentissue1

import android.os.Bundle
import android.support.v4.app.Fragment
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class FragmentEmpty : Fragment() {

        var fragmentTwo : Fragment? = null
        var fragmentOne : Fragment? = null

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            return inflater.inflate(R.layout.fragment_empty, container, false)
        }


        override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            if (childFragmentManager.findFragmentByTag("FragmentOne") == null) {
                fragmentOne = FragmentOne()
                childFragmentManager.beginTransaction().add(R.id.container, fragmentOne, "FragmentOne").commit()
            } else {
                fragmentOne = childFragmentManager.findFragmentByTag("FragmentOne")
            }

            if (childFragmentManager.findFragmentByTag("FragmentTwo") != null) {
                fragmentTwo = childFragmentManager.findFragmentByTag("FragmentTwo")
                childFragmentManager.popBackStackImmediate()
            } else {
                fragmentTwo = FragmentTwo()
            }

            val transitionInflater = TransitionInflater.from(activity)
            val sharedElement = transitionInflater.inflateTransition(R.transition.shared_transition)
            fragmentTwo?.sharedElementReturnTransition = sharedElement
            fragmentOne?.sharedElementEnterTransition = sharedElement
        }

        fun openFragmentTwo() {
            var fragmentTransaction = childFragmentManager.beginTransaction()
            fragmentTransaction = fragmentTransaction
                    // Uncomment below to fix the issue in 25.2.0
                    // .setAllowOptimization(true)
                    .addSharedElement(activity.findViewById(R.id.fragment_button), "my_transition")
            fragmentTransaction.replace(R.id.container, fragmentTwo, "FragmentTwo").addToBackStack("").commit()
        }

    }

