package com.ppdm.app_musica.modelos

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Musica(
    val nombre: String,
    val logoId: Int,
    val duracion: String,
    val audioId: Int
) : Parcelable

