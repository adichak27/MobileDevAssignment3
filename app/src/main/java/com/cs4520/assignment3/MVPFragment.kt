package com.cs4520.assignment3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import com.cs4520.assignment3.databinding.FragmentMVPBinding

/**
 * A simple [Fragment] subclass.
 * Use the [MVPFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MVPFragment : Fragment(), CalculatorView {
    private lateinit var binding: FragmentMVPBinding
    private lateinit var presenter: CalculatorPresenter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMVPBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = CalculatorPresenter(this, CalculatorModel())

        binding.addButton.setOnClickListener {
            val num1 = getNumber(binding.firstNumber)
            val num2 = getNumber(binding.secondNumber)
            presenter.add(num1, num2)
        }
        binding.subtractButton.setOnClickListener {
            val num1 = getNumber(binding.firstNumber)
            val num2 = getNumber(binding.secondNumber)
            presenter.subtract(num1, num2)
        }
        binding.multiplyButton.setOnClickListener {
            val num1 = getNumber(binding.firstNumber)
            val num2 = getNumber(binding.secondNumber)
            presenter.multiply(num1, num2)
        }
        binding.divideButton.setOnClickListener {
            val num1 = getNumber(binding.firstNumber)
            val num2 = getNumber(binding.secondNumber)
            presenter.divide(num1, num2)
        }
    }

    private fun getNumber (editTextElem: EditText): Double {
        return editTextElem.text.toString().toDoubleOrNull() ?: 0.0
    }

    private fun clearInputs() {
        binding.firstNumber.text.clear()
        binding.secondNumber.text.clear()
    }

    override fun showResult(result: Double) {
        binding.result.text = result.toString()
        clearInputs()
    }

    override fun showError(error: String) {
        Toast.makeText(activity, error, Toast.LENGTH_SHORT).show()
        clearInputs()
    }
}