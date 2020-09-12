package com.example.epn_turnos_geolocalizacion_covid

import java.util.*

class PacienteHttp(
    var createdAt: Long,
    var updatedAt: Long,
    var id: Int,
    var nombre: String,
    var modo: String,
    var codigoUnico: String,
    var cedula: String,
    var clave: String,
    var correo: String,
    var estado: String

) {
    var fechaCreacion: Date
    var fechaActualizacion: Date
    init {
        fechaCreacion = Date(createdAt)
        fechaActualizacion = Date(updatedAt)
    }
}