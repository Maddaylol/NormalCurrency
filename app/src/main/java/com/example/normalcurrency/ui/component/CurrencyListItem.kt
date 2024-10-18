package com.example.normalcurrency.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.normalcurrency.R

@Composable
fun CurrencyItem(modifier: Modifier = Modifier, selected: Boolean, currency: String) {
    var currencyText by remember { mutableStateOf(currency) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.width(255.dp)

    ) {
        Image(
            painter = painterResource(id = R.drawable.flag_of_sweden),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape),

            )
        TextField(
            value = currencyText,
            onValueChange = {
                if (isValidCurrencyInput(it)) {
                    currencyText = it
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            shape = RoundedCornerShape(8.dp)
        )
    }
}

private fun isValidCurrencyInput(input: String): Boolean {
    return input.all { it.isDigit() || it == '.' } && (input.count { it == '.' } <= 1)
}

@Preview
@Composable
fun CurrencyElementPreview() {
    CurrencyItem(Modifier, true, "100.00")
}