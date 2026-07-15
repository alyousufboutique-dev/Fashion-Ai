package com.fashionai.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.fashionai.R
import com.fashionai.ui.components.PrimaryButton
import com.fashionai.ui.components.SecondaryButton
import com.fashionai.ui.navigation.Routes

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.home_title),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(top = 16.dp)
        )
        PrimaryButton(
            text = stringResource(R.string.scan_outfit),
            onClick = {
                navController.navigate(Routes.SCANNER)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp)
        )
        SecondaryButton(
            text = stringResource(R.string.view_wardrobe),
            onClick = {
                navController.navigate(Routes.WARDROBE)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        )
        PrimaryButton(
            text = stringResource(R.string.settings),
            onClick = {
                navController.navigate(Routes.SETTINGS)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        )
    }
}
