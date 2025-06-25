package com.app.praktikum_kel1_2.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.app.kelompok_34.Screen.HomeScreen
import com.app.kelompok_34.Screen.ProfileScreen
import com.app.kelompok_34.Screen.ResultScreen
import com.app.kelompok_34.navigation.Screen

/**
 * Fungsi `SetupNavGraph` digunakan untuk mengatur semua rute navigasi aplikasi.
 * Fungsi ini menentukan halaman awal (startDestination) dan halaman-halaman yang bisa diakses melalui navigasi.
 *
 * @param navController controller navigasi yang digunakan untuk berpindah halaman.
 * @param modifier modifier opsional untuk penyesuaian tampilan.
 */
@Composable
fun SetupNavGraph(navController: NavHostController, modifier: Modifier = Modifier) {
    // Membuat NavHost untuk mengatur semua rute
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route, // Halaman awal aplikasi
        modifier = modifier
    ) {

        // Halaman Home
        composable(
            route = Screen.Home.route
        ) {
            HomeScreen(navController)
        }

        // Halaman Result, membutuhkan parameter "text"
        composable(
            route = Screen.Result.route,
            arguments = listOf(navArgument("text") {
                type = NavType.StringType // Tipe parameter: String
            })
        ) {
            // Mengambil argumen "text" dari route dan mengirim ke ResultScreen
            ResultScreen(it.arguments?.getString("text").toString(), navController)
        }

        // Halaman Profile
        composable(
            route = Screen.Profile.route
        ) {
            ProfileScreen(navController)
        }
    }
}
