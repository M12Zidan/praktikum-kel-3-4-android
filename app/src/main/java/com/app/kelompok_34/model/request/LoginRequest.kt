package com.app.kelompok_34.model.request

/**
 * Data class `LoginRequest` merepresentasikan data yang dikirim
 * dari aplikasi ke server saat melakukan proses login.
 *
 * @param username nama pengguna yang dimasukkan oleh user.
 * @param password kata sandi akun user.
 */
data class LoginRequest(
    val username: String,
    val password: String
)