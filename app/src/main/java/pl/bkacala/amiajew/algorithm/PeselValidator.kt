package pl.bkacala.amiajew.algorithm

interface PeselValidator {

    fun validate(pesel: String?): Boolean

    companion object {
        val PESEL_SIZE: Int = 11
    }
}