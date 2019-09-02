package com.example.tmdb

import java.net.ConnectException
import java.net.UnknownHostException

object GenericException {

    fun getErrorMessage(exception: Throwable): String {
        if(exception is ConnectException) return "Favor verificar sua conexão!"
        if(exception is UnknownHostException) return "Não foi possível conectar ao servidor, verifica sua conexão com a internet!"
        return "Ocorreu um erro"
    }

}