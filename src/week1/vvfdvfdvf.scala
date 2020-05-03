package week1

import scala.annotation.tailrec
object Solution2 extends App {
    def shortestCompletingWord(licensePlate: String, words: Array[String]): String = {
        //Letters and count
        @tailrec
        def loopMapLicensePlate(licensePlateLeft: String, lettersLicense: Map[String, Int]): Map[String, Int] = {
            if(licensePlateLeft.length() == 0) lettersLicense
            else{
              
              //Is it letter?              
              if(licensePlateLeft.head.isLetter){

                val count = lettersLicense.getOrElse(licensePlateLeft.head.toString().toLowerCase(), 0)
                loopMapLicensePlate(licensePlateLeft.tail, (lettersLicense - licensePlateLeft.head.toString()) + (licensePlateLeft.head.toString().toLowerCase() -> (count + 1)) )
              }
              else loopMapLicensePlate(licensePlateLeft.tail, lettersLicense)
            }
        }
        
        val lettersLicense: Map[String, Int] = loopMapLicensePlate(licensePlate, Map())
        
        // Iterate each word
        @tailrec
        def loopWords(wordsLeft: Array[String], word: String): String = {
          if(wordsLeft.length == 0) word
          else{
            val lettersWord: Map[String, Int] = loopMapLicensePlate(wordsLeft.head, Map())
            // The word at least the same number of letter as the plate?
            if(loopWord(lettersLicense, lettersWord, true) && (wordsLeft.head.length() < word.length() || word.length() == 0)){
              loopWords(wordsLeft.tail, wordsLeft.head)
            }else{
              loopWords(wordsLeft.tail, word)
            }
          }
        }

        // Contains the letter?
        @tailrec
        def loopWord(lettersLicense: Map[String, Int],lettersWord: Map[String, Int], isOk: Boolean): Boolean = {
          if(!isOk || lettersLicense.isEmpty) isOk
          else{
            // The word at least the same number of letter as the plate?
            if(lettersLicense.head._2 <= lettersWord.getOrElse(lettersLicense.head._1, 0)) loopWord(lettersLicense.tail, lettersWord, true)
            else loopWord(lettersLicense.tail, lettersWord, false)
          }
        }

        loopWords(words, "")
    }
    
    
    val licensePlate="1s3 PSt"
    val words=Array("step","steps","stripe","stepple")
    println(shortestCompletingWord(licensePlate, words))
}