package com.teachmeskills.lesson21sample.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import com.teachmeskills.lesson21sample.R

class SelectColorFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // создаем View
        return inflater.inflate(R.layout.activity_select_color, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.red).setOnClickListener {
            sendResult("red")
        }
        view.findViewById<Button>(R.id.green).setOnClickListener {
            sendResult("green")
        }
        view.findViewById<Button>(R.id.yellow).setOnClickListener {
            sendResult("yellow")
        }

    }

    private fun sendResult(message: String) {
        // Отправляем результат выполнения всем кто подписался
        setFragmentResult(
            REQUESTED_COLOR_KEY,
            // Создаем Bundle
            bundleOf(BUNDLE_COLOR_KEY to message)
        )
        // Закрываем фрагмент(удаляем его из стека)
        parentFragmentManager.popBackStack()
    }

    companion object {
        const val REQUESTED_COLOR_KEY = "requestedKey"
        const val BUNDLE_COLOR_KEY = "bundleKey"
    }
}