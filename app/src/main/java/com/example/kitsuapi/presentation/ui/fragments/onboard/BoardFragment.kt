package com.example.kitsuapi.presentation.ui.fragments.onboard

import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.data.local.prefs.TokenPreferenceHelper
import com.example.kitsuapi.R
import com.example.kitsuapi.databinding.FragmentBoardBinding
import com.example.kitsuapi.presentation.base.BaseFragment
import com.example.kitsuapi.presentation.extensions.navigateSafely
import com.example.kitsuapi.presentation.ui.adapters.OnBoardAdapter
import org.koin.android.ext.android.inject

/**
 * [BoardFragment] наследуется от класса BaseFragment, который является базовым классом
 * для фрагментов в приложении. Класс BoardFragment используется для отображения экрана
 * Onboarding в приложении, который отображает экран входа в приложение иобеспечивает
 * навигацию пользователя по первоначальной информации о приложении.
 * @author Aziz
 * @since 1.0v
 */
class BoardFragment : BaseFragment<FragmentBoardBinding>(R.layout.fragment_board) {

    override val binding by viewBinding(FragmentBoardBinding::bind)
    private val tokenPreferenceHelper: TokenPreferenceHelper by inject()

    /**
     * Метод [initialize] используется для инициализации элементов пользовательского интерфейса.
     * В данном случае, установлен адаптер OnBoardAdapter для ViewPager, а WormDotsIndicator
     * прикреплен к ViewPager.
     */
    override fun initialize() {
        binding.viewPager.adapter = OnBoardAdapter(requireContext())
        binding.dotsIndicator.attachTo(binding.viewPager)
    }

    /**
     * Метод [setupListener] используется для настройки обработчиков событий пользовательского
     * ввода. В данном случае, установлены обработчики для кнопок btnNext и btnStart, которые
     * перемещают ViewPager на следующий экран и переходят на фрагмент LoginFragment соответственно.
     * Также установлен обратный вызов для ViewPager, который скрывает кнопку btnNext и отображает
     * кнопку btnStart при достижении последнего экрана в ViewPager.
     */
    override fun setupListener() {
        binding.btmNext.setOnClickListener {
            binding.viewPager.currentItem++
        }

        binding.tvSkip.setOnClickListener {
            tokenPreferenceHelper.onBoardIsShown = true
            findNavController().navigateSafely(R.id.action_boardFragment_to_singInFragment)
        }

        binding.btnStart.setOnClickListener {
            tokenPreferenceHelper.onBoardIsShown = true
            findNavController().navigateSafely(R.id.action_boardFragment_to_singInFragment)
        }

        binding.viewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                if (position == 2) {
                    binding.btnStart.visibility = View.VISIBLE
                    binding.btmNext.visibility = View.GONE
                } else {
                    binding.btnStart.visibility = View.GONE
                    binding.btmNext.visibility = View.VISIBLE
                }
            }
        })
    }
}