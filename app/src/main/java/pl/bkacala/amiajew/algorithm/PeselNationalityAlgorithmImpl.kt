package pl.bkacala.amiajew.algorithm

class PeselNationalityAlgorithmImpl(private val peselValidator: PeselValidator) : PeselNationalityAlgorithm {


    override fun checkNationality(pesel: String): Nationality {
        if(peselValidator.validate(pesel)) {
            return checkNationalityByAlgorithms(pesel)
        } else {
            throw IncorrectPeselException()
        }
    }

    private fun checkNationalityByAlgorithms(pesel: String): Nationality {
        //TODO
        return Nationality.POLISH
    }


}