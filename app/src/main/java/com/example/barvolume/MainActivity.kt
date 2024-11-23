package com.example.barvolume

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var etHeight: EditText
    private lateinit var etWidth: EditText
    private lateinit var etLength: EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView


    companion object {
        private const val STATE_RESULT = "state_result"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //init component in activity_main
        etHeight = findViewById(R.id.et_height)
        etWidth = findViewById(R.id.et_width)
        etLength = findViewById(R.id.et_length)
        btnCalculate = findViewById(R.id.btn_calculate)
        tvResult = findViewById(R.id.tv_result)

        btnCalculate.setOnClickListener(this)

        if (savedInstanceState != null) {
            val result = savedInstanceState.getString(STATE_RESULT)
            tvResult.text = result
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, tvResult.text.toString())
    }

    override fun onClick(view: View?) {
        if (view?.id == R.id.btn_calculate) {
            val inputHeight = etHeight.text.toString().trim()
            val inputWidth = etWidth.text.toString().trim()
            val inputLength = etLength.text.toString().trim()
            var isEmptyField = false

            if (inputLength.isEmpty()) {
                isEmptyField = true
                etLength.error = "Field ini tidak boleh kosong"
            }

            if (inputWidth.isEmpty()) {
                isEmptyField = true
                etWidth.error = "Field ini tidak boleh kosong"
            }

            if (inputHeight.isEmpty()) {
                isEmptyField = true
                etHeight.error = "Field ini tidak boleh kosong"
            }

            if (!isEmptyField) {
                val volume = inputLength.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()
                tvResult.text = volume.toString()

            }
        }
    }
}