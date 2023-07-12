package com.example.coffeemasters.ui


import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.coffeemasters.NavBar
import com.example.coffeemasters.pages.OffersPage
import com.example.coffeemasters.R
import com.example.coffeemasters.Routes
import com.example.coffeemasters.pages.InfoPage
import com.example.coffeemasters.pages.MenuPage
import com.example.coffeemasters.pages.OrderPage
import com.example.coffeemasters.ui.theme.CoffeeMastersTheme


@Preview
@Composable
fun App_Preview(){
    CoffeeMastersTheme() {
        App()
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun App() {
    var  selectedRoute = remember{
        mutableStateOf(Routes.MenuPage.route)
    }
    Scaffold (
        topBar = {
                 AppTitle()
        },
        bottomBar = {
                    NavBar(
                        selectedRoute = selectedRoute.value,
                        onChange = {
                            selectedRoute.value = it
                    })
        },

        content = {
            when(selectedRoute.value){
                Routes.MenuPage.route -> MenuPage()
                Routes.OffersPage.route -> OffersPage()
                Routes.InfoPage.route -> InfoPage()
                Routes.OrderPage.route -> OrderPage()
            }
        }


    )
}


@Preview
@Composable
fun AppTitle() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth()
    ){
        Image(painter = painterResource(id = R.drawable.logo),
            contentDescription = "Coffee Masters Logo",
        )
    }

}