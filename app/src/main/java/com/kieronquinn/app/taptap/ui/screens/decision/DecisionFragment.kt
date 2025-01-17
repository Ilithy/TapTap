package com.kieronquinn.app.taptap.ui.screens.decision

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kieronquinn.app.taptap.ui.screens.root.RootSharedViewModel
import com.kieronquinn.app.taptap.utils.extensions.whenResumed
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DecisionFragment: Fragment() {

    private val decisionViewModel by viewModel<DecisionViewModel>()
    private val rootSharedViewModel by sharedViewModel<RootSharedViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setupDecision()
        return View(context)
    }

    private fun setupDecision() = whenResumed {
        decisionViewModel.decisionMade.collect {
            rootSharedViewModel.postDecisionMade()
        }
    }

}