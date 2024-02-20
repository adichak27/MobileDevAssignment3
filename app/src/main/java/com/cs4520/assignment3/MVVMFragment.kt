package com.cs4520.assignment3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.cs4520.assignment3.databinding.FragmentMVVMBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MVVMFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MVVMFragment : Fragment() {
    private lateinit var binding: FragmentMVVMBinding
    private val viewModel: CalculatorViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMVVMBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addButton.setOnClickListener {
            performOperation { num1, num2 -> num1 + num2 }
        }
        binding.subtractButton.setOnClickListener {
            performOperation { num1, num2 -> num1 - num2 }
        }
        binding.multiplyButton.setOnClickListener {
            performOperation { num1, num2 -> num1 * num2 }
        }
        binding.divideButton.setOnClickListener {
            performOperation { num1, num2 -> num1 / num2 }
        }
        observeViewModel()
    }

    private fun performOperation(operation: (num1: Double, num2: Double) -> Double) {
        val num1 = binding.firstNumber.text.toString()
        val num2 = binding.secondNumber.text.toString()
        viewModel.calculate(operation, num1, num2)
        clearInputs()
    }
    private fun clearInputs() {
        binding.firstNumber.text.clear()
        binding.secondNumber.text.clear()
    }
    private fun observeViewModel() {
        viewModel.result.observe(viewLifecycleOwner) {result ->
            binding.result.text = result
            if (result.startsWith("An error occurred")) {
                Toast.makeText(context, result, Toast.LENGTH_SHORT).show()
            }
        }
    }
}