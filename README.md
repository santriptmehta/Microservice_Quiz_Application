# Microservice-Quiz-App
Quiz App using different microservices such as question-service, quiz-service, service-registry and an api-gateway-service. <br>

# Postman cURLs
1. <b>generateQuiz</b> <br>
curl --location 'localhost:8765/quiz-service/quiz/generate' \
--header 'Content-Type: application/json' \
--data '{
    "category":"Java",
    "limit":10,
    "title":"Java Guy"
}'

<br><br>
2. <b>generateQuizQuestions</b> <br>
curl --location 'localhost:8765/quiz-service/quiz/getQuiz/1'

<br><br>
3. <b>getResult</b> <br>
curl --location --request GET 'localhost:8765/quiz-service/quiz/getScore' \
--header 'Content-Type: application/json' \
--data '[
    {
        "rid":2,
        "response": "A programming language"
    },
    {
        "rid":4,
        "response": "A value that has a name and a type"
    },
    {
        "rid":7,
        "response": "A blueprint for creating objects"
    },
    {
        "rid":11,
        "response": "The ability of an object to take on many forms"
    },
    {
        "rid":20,
        "response": "A structure that repeats a block of code"
    }
]'

<br><br>
4. <b>getAllQuestions</b> <br>
curl --location 'localhost:8765/question-service/question/getAllQuestions'

<br><br>
5. <b>getAllQuestionsByCategory</b> <br>
curl --location 'localhost:8765/question-service/question/category/Java'

<br><br>
6. <b>addQuestion</b> <br>
curl --location 'localhost:8765/question-service/question/addQuestion' \
--header 'Content-Type: application/json' \
--data '{
	"questionTitle":"What is the default scope of the Spring Bean?",
    "option1":"singleton",
    "option2":"prototype",
    "option3":"request",
    "option4":"session",
    "correctAnswer":"singleton",
    "category":"Java",
    "difficultyLevel":"Medium"
}'

<br><br>
7. <b>updateQuestion</b> <br>
curl --location --request PUT 'localhost:8765/question-service/question/update/1' \
--header 'Content-Type: application/json' \
--data '{
        "questionTitle": "What is size of int in java? (in Bytes)",
        "option1": 1,
        "option2": 2,
        "option3": 4,
        "option4": 8,
        "correctAnswer": 4,
        "category": "Java",
        "difficultyLevel": "Easy"
    }'

<br><br>
8. <b>deleteQuestion</b> <br>
curl --location --request DELETE 'localhost:8765/question-service/question/delete/22' \
--data ''

<br><br>
9. <b>generateQuestionsForQuiz</b> <br>
curl --location --request GET 'localhost:8765/question-service/question/generate?category=Python&limit=10' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--data-urlencode 'category=Java' \
--data-urlencode 'limit=5'

<br><br>
10. <b>generateQuestionsByIds</b> <br>
curl --location 'localhost:8765/question-service/question/getQuestions' \
--header 'Content-Type: application/json' \
--data '[10,16,3,18,19,21,6,12,8,14]'

<br><br>
11. <b>score</b> <br>
curl --location 'localhost:8765/question-service/question/getScore' \
--header 'Content-Type: application/json' \
--data '[
    {
        "rid":2,
        "response": "A programming language"
    },
    {
        "rid":4,
        "response": "A value that has a name and a type"
    },
    {
        "rid":7,
        "response": "A blueprint for creating objects"
    },
    {
        "rid":11,
        "response": "The ability of an object to take on many forms"
    },
    {
        "rid":20,
        "response": "A structure that repeats a block of code"
    }
]'

# Eureka-Server setup
![image](https://github.com/akkiePro/Microservice-Quiz-App/assets/72514060/21807a0a-5185-4dc7-98a1-3e9047e6efab)

# Monolithic-Quiz-App
<a href="https://github.com/akkiePro/Monolithic-Quiz-App">Monolithic-Quiz-App</a> <br>
<br>
learnt from: https://www.youtube.com/watch?v=Jl9OKQ92SJU&ab_channel=Telusko
