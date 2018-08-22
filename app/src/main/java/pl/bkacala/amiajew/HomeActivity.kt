package pl.bkacala.amiajew

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import pl.bkacala.amiajew.algorithm.*
import pl.bkacala.amiajew.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private var algorithm: PeselNationalityAlgorithm
    var validator: PeselValidator = PeselValidatorImpl()
    lateinit var binding: ActivityHomeBinding
    private val viewModel = HomeActivityViewModel()

    init {
        algorithm = PeselNationalityAlgorithmImpl(validator)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        binding.viewModel = viewModel

        setInputListener()
        setCheckListener()
    }

    private fun setCheckListener() {
        binding.check.setOnClickListener {
            when (algorithm.checkNationality(binding.input.text.toString())) {
                Nationality.POLISH -> viewModel.image = R.drawable.img_polan
                Nationality.JEWISH -> viewModel.image = R.drawable.img_jew
                Nationality.UNKNOWN -> viewModel.image = 0
            }
        }
    }

    private fun setInputListener() {

        binding.input.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                updateViewModel(s?.toString() ?: "")
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
    }

    private fun updateViewModel(pesel: String?) {
        pesel?.let {
            when {
                pesel.isEmpty() -> updateModelForEmptyInput()
                !validator.validate(pesel) -> updateModelForIncorrectPesel()
                else -> updateModelForCorrectPesel(pesel)
            }
            binding.executePendingBindings()
        }
    }

    private fun updateModelForCorrectPesel(pesel: String) {
        viewModel.apply {
            errorText = null
            enableCheckButton = true
            image = 0
        }
    }

    private fun updateModelForIncorrectPesel() {
        viewModel.apply {
            errorText = getString(R.string.home_input_incorrect_pesel)
            enableCheckButton = false
            image = 0
        }
    }

    private fun updateModelForEmptyInput() {
        viewModel.apply {
            errorText = null
            enableCheckButton = false
            image = 0
        }
    }


}
