package com.vsv.core.utils

import android.text.SpannableStringBuilder
import android.widget.EditText
import androidx.core.widget.doAfterTextChanged

object NumberFormat {
    var format = "(***)-***-**-**"
}

/**не дает стереть текст, не успеваю исправить*/
fun EditText.setMask() {
    val numPlace = '*'
    val stingBuilder = StringBuilder()
    val sp = SpannableStringBuilder(NumberFormat.format)
    var ignore = false
    doAfterTextChanged { editable ->
        if (!ignore) {
            stingBuilder.setLength(0)
            editable?.forEach { char ->
                if (char in '0'..'9')
                    stingBuilder.append(char)
            }
            val numbers = stingBuilder.toString()
            stingBuilder.setLength(0)
            var i = 0
            var textIndex = 0

            if (editable != null)
                while (i < NumberFormat.format.length && textIndex < numbers.length) {
                    if (NumberFormat.format[i] == numPlace) {
                        stingBuilder.append(numbers[textIndex])
                        textIndex++
                    } else {
                        stingBuilder.append(NumberFormat.format[i])
                    }
                    i++
                }
            ignore = true
            sp.replace(0, i, stingBuilder.toString())
            editable?.replace(0, editable.length, sp.toString())
//            editable?.replace(0, editable.length, stingBuilder.toString())
            ignore = false
        }
    }
}