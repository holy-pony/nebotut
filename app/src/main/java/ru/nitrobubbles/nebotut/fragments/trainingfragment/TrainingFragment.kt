package ru.nitrobubbles.nebotut.fragments.trainingfragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.nitrobubbles.nebotut.R

/**
 * Created by konstantinaksenov on 03.03.16.
 */
class TrainingFragment : Fragment(){
    var controller : TrainingFragmentController? = null
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.training_layout, null)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        controller = TrainingFragmentController(view!!)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        controller?.connect()

    }

    override fun onPause() {
        super.onPause()
        controller?.diconnect()
    }
}