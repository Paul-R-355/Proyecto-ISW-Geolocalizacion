package com.example.epn_turnos_geolocalizacion_covid

import android.os.Parcel
import android.os.Parcelable

class Pacientes(var nombre:String?, var apellido:String?, var longitud:Double?, var latitud:Double?):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readDouble(),
        parcel.readDouble()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeString(apellido)
        longitud?.let { parcel.writeDouble(it) }
        latitud?.let { parcel.writeDouble(it) }
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Pacientes> {
        override fun createFromParcel(parcel: Parcel): Pacientes {
            return Pacientes(parcel)
        }

        override fun newArray(size: Int): Array<Pacientes?> {
            return arrayOfNulls(size)
        }
    }

    override fun toString(): String {
        return "nombre: ${nombre}, apellido: ${apellido}"
    }

}