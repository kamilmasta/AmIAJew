package pl.bkacala.amiajew.algorithm

interface PeselNationalityAlgorithm {

    @Throws(IncorrectPeselException::class)
    fun checkNationality(pesel: String) : Nationality
}