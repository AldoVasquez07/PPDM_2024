package com.ppdm.app_musica.controlador

import android.os.Parcelable

@
data class Musica(
    val name: String,
    val imageResId: Int,
    val duration: String,
    val audioResId: Int
) : Parcelable

