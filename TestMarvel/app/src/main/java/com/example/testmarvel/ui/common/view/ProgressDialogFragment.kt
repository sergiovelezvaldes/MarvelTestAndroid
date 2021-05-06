package com.example.testmarvel.ui.common.view

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.example.testmarvel.R
import java.util.*

class ProgressDialogFragment : DialogFragment() {

    companion object {
        fun newInstance(isCancelable: Boolean = false) =
                ProgressDialogFragment().apply {
                    this.isCancelable = isCancelable
                }
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_progress_dialog, container)
    }

    fun show(fragmentManager: FragmentManager) {
        show(fragmentManager, UUID.randomUUID().toString())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

}