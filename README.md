# learnEntertain

OpenNLP Project

# Pos Constants
**NN**  = "Noun, singular or mass" <br>
**DT**  = "Determiner" <br>
**VB**  = "Verb, base form" <br>
**VBD** = "Verb, past tense" <br>
**VBZ** = "Verb, third person singular present" <br>
**IN**  = "Preposition or subordinating conjunction" <br>
**NNP** = "Proper noun, singular" <br>
**TO**  = "to" <br>
**JJ**  = "Adjective"

# REST Calls

###### GET: localhost:8080/dailySentence
**Response(randomly select a sentence from file):** `Oh, how I'd love to go!` 

###### POST: localhost:8080/validateSentence
**Input body:** 
`{
"inputSentence":"Oh, how I'd love to go!",
"posData":{"Would":"MD","you":"PRP","like":"IN","to":"TO","travel":"VB","with":"IN","me":"PRP","Oh":"UH","how":"WRB","I'd":"NNP","love":"VB","go":"VB"}
}`
**Response(Validate input using Apache OpenNLP POS library):**
`{"sentence":"Oh, how I'd love to go!","posInputMap":{"Would":"MD","you":"PRP","like":"IN","to":"TO","travel":"VB","with":"IN","me":"PRP","Oh":"UH","how":"WRB","I'd":"NNP","love":"VB","go":"VB"},"posOutputMap":{"Would":"MD","you":"PRP","like":"IN","to":"TO","travel":"VB","with":"IN","me":"PRP","Oh":"UH","how":"WRB","I'd":"NNP","love":"VB","go":"VB"},"successFlag":true}`


Build jar Using `mvn clean install`<br>
Run created jar 
