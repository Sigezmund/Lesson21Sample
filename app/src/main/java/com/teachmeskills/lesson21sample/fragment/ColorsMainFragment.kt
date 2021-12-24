package com.teachmeskills.lesson21sample.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import com.teachmeskills.lesson21sample.R

class ColorsMainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // создаем View
        return inflater.inflate(R.layout.fragment_colors, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.selectColor).setOnClickListener {

            // вместо requireActivity().supportFragmentManager можно использовать
            // parentFragmentManager
            // Заменяем текущий fragment на SelectColorFragment
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container, SelectColorFragment(), "tag")
                // Добавляем его в backStack,
                // чтобы по нажатию на кнопку back мы вернулись к предыдущему фрагменты
                .addToBackStack(null)
                .commit()
        }


        // Подписываемся на результат от следующего фрагмента
        setFragmentResultListener(
            SelectColorFragment.REQUESTED_COLOR_KEY
        ) { _, bundle ->

            Toast.makeText(
                requireContext(),
                bundle.getString(SelectColorFragment.BUNDLE_COLOR_KEY),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    companion object {

        fun newInstance(): ColorsMainFragment {
            return ColorsMainFragment()
        }
    }

}