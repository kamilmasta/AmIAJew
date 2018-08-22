package pl.bkacala.amiajew

import pl.bkacala.amiajew.algorithm.Nationality

class PeselsCreator {

    fun createPeselsForAllCases(): List<PeselNationalityPair> {
        val list = arrayListOf<PeselNationalityPair>()

        //unia pracy
        list.add(PeselNationalityPair("51072606579", Nationality.JEWISH))
        //ruch polski niepodległej
        list.add(PeselNationalityPair("59101109198", Nationality.POLISH))
        //polski ruch monarchistyczny
        list.add(PeselNationalityPair("49091007417", Nationality.POLISH))
        list.add(PeselNationalityPair("49070102162", Nationality.POLISH))
        list.add(PeselNationalityPair("38091302837", Nationality.POLISH))

        //TODO https://wolna-polska.pl/wiadomosci/polacy-zydzi-i-numery-pesel-2012-10
        return list
    }

}