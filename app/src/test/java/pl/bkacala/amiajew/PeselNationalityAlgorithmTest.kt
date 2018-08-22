package pl.bkacala.amiajew

import org.junit.Assert
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import pl.bkacala.amiajew.algorithm.PeselNationalityAlgorithm
import pl.bkacala.amiajew.algorithm.PeselNationalityAlgorithmImpl
import pl.bkacala.amiajew.algorithm.PeselValidator


class PeselNationalityAlgorithmTest {

    val peselsCreator = PeselsCreator()

    @Test
    fun allCases() {

        //prepare
        val testCases = peselsCreator.createPeselsForAllCases()
        val peselValidator = getMockedPeselValidator()
        val testedAlgorithm: PeselNationalityAlgorithm = PeselNationalityAlgorithmImpl(peselValidator)

        val allCasesAmount = testCases.size
        var correctlyPredictedNationalities = 0


        //execute
        for (pair in testCases) {
            if (testedAlgorithm.checkNationality(pair.pesel) == pair.nationality) correctlyPredictedNationalities++
        }

        //verify
        System.out.println("Correctly predicted cases: $correctlyPredictedNationalities for total number $allCasesAmount of all cases.")
        System.out.println("Effectivness:" + correctlyPredictedNationalities * 100 / allCasesAmount + "%")
        Assert.assertEquals(correctlyPredictedNationalities, allCasesAmount)
    }

    private fun getMockedPeselValidator(): PeselValidator {
        val peselValidator = mock(PeselValidator::class.java)
        `when`(peselValidator.validate(ArgumentMatchers.anyString())).thenReturn(true)
        return peselValidator
    }
}
